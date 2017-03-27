
package piggymcpigface;

import java.util.Scanner;

import static java.nio.file.StandardOpenOption.*;
import java.nio.file.*;
import java.io.*;
import java.io.IOException;

public class PiggyMcPigface {

  public static void main(String[] args){
    Scanner scan = new Scanner(System.in).useDelimiter("\\n");
    System.out.println("Type -r for reading from an input file, -s for translating a sentence");
    String inputCommand = scan.next();
    String translatedSentence = "";
    boolean translationComplete = false;

    if(inputCommand.equals("-r")){
      String filename = "yourfile.txt";

      try{
      FileReader inputFile = new FileReader(filename);

      //Instantiate the BufferedReader Class
      BufferedReader bufferReader = new BufferedReader(inputFile);

      //Variable to hold the one line data
      String line;

      // Read file line by line and print on the console
      while ((line = bufferReader.readLine()) != null)   {
        //System.out.println(line);
        String inputSentence = line;
        translatedSentence = translateSentence(inputSentence);
        translationComplete = true;
        System.out.println("The sentence in pig latin is: " + translatedSentence);
      }
      //Close the buffer reader
      bufferReader.close();
      //System.out.println("Not yet implemented");
          }
      catch(Exception e){
          System.out.println("Error while reading file line by line:" + e.getMessage());
                        }

     }
    else if(inputCommand.equals("-s")){
      System.out.println("Write your sentence in the command line");
      String inputSentence = scan.next();
      translatedSentence = translateSentence(inputSentence);
      translationComplete = true;
      System.out.println("The sentence in pig latin is: " + translatedSentence);
    }
    else {
      System.out.println("Unknown Command");
    }

    if(translationComplete){
      System.out.println("Type -w if you want to store the data, otherwise type quit");
      String storeCommand = scan.next();
      if(storeCommand.equals("-w")){
        writeToFile(translatedSentence);
      }
    }

    System.out.println("Goodbye!");

  }

  public static String translateSentence(String inputSentence){
    String translatedSentence = "";
    String[] inputWords = inputSentence.split("\\s+");
    for (String inputWord: inputWords) {
      if (translatedSentence.length() != 0) {
          translatedSentence = translatedSentence + " ";
      }
      translatedSentence = translatedSentence + translateWord(inputWord);
    }
    return translatedSentence;
  }

  public static String translateWord(String inputWord){
    // inputWord = inputWord.toLowerCase();
    String pigLatin = "";
    int wordLength = inputWord.length();
    int vowelIdx = indexOfFirstVowel(inputWord);
    if (vowelIdx == 0){
      pigLatin = inputWord + "way";
    }
    else if(vowelIdx > 0){
      pigLatin = inputWord.substring(vowelIdx,wordLength)  + inputWord.substring(0,vowelIdx) + "ay";
    }
    pigLatin = handleUppercase(inputWord, pigLatin);
    pigLatin = handlePunctuation(pigLatin);
    return pigLatin;
  }

  public static String handleUppercase(String inputWord, String translatedWord){
    String handledWord = translatedWord.toLowerCase();
    if (isFirstLetterUppercase(inputWord)){
      handledWord = translatedWord.substring(0,1).toUpperCase() + translatedWord.substring(1).toLowerCase();
    }
    return handledWord;
  }

  public static String handlePunctuation(String inputWord){
    String outputWord = inputWord;
    int punctuationIdx = indexOfPunctutation(inputWord);
    if (punctuationIdx > -1){
      outputWord = inputWord.substring(0,punctuationIdx) + inputWord.substring(punctuationIdx+1) + inputWord.substring(punctuationIdx,punctuationIdx+1);
    }
    return outputWord;
  }

  private static int indexOfPunctutation(String inputWord){
    String punctuations = "!#$%&'()*+,-./:;<=>?@[]^_`{|}~";
    for (int index = 0; index < inputWord.length(); index++){
        if (punctuations.contains(String.valueOf(inputWord.charAt(index)))){
            return index;
        }
    }
    // handle cases where a punctuation is not found
    return -1;
  }

  private static boolean isFirstLetterUppercase(String inputWord){
    return Character.isUpperCase(inputWord.charAt(0));
  }

  public static int indexOfFirstVowel(String word){
    String loweredWord = word.toLowerCase();
    String vowels = "aeiouy";
    for (int index = 0; index < loweredWord.length(); index++){

        if (vowels.contains(String.valueOf(loweredWord.charAt(index)))){
            return index;
        }
    }
    // handle cases where a vowel is not found
    return -1;
  }

  private static void writeToFile(String sentence) {
    // Convert the string to a byte array.
    byte data[] = sentence.getBytes();
    Path p = Paths.get("./PigLatinOutput.txt");

    try (OutputStream out = new BufferedOutputStream(Files.newOutputStream(p, CREATE, APPEND))) {
      out.write(data, 0, data.length);
    } catch (IOException x) {
      System.err.println(x);
    }

  }

}
