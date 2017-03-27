
package piggymcpigface;

import java.util.Scanner;

import static java.nio.file.StandardOpenOption.*;
import java.nio.file.*;
import java.io.*;
import java.io.IOException;

public class PiggyMcPigface {

  public static void main(String[] args){
    Scanner scan = new Scanner(System.in).useDelimiter("[\r\n]+");
    System.out.println("Type -r for reading from an input file, -s for translating a sentence in PigLatin, or -o for translating a sentence in Rövarspråket ");
    String inputCommand = scan.next();
    String translatedSentence = "";
    boolean translationComplete = false;

    if(inputCommand.equals("-r")){
      System.out.println("Write the name of the input file in the command line");
      String filename = scan.next();
      String translatedFile = translateFile(filename);
      if(translatedFile.equals("error")){
        translationComplete = false;
      }
      else
      {
        translationComplete = true;
        System.out.println("The sentence in pig latin is: " + translatedFile);
      }

    }
    else if(inputCommand.equals("-s")){
      System.out.println("Write your sentence in the command line");
      String inputSentence = scan.next();
      String translatedLanguage = "pigLatin";
      translatedSentence = translateSentence(inputSentence, translatedLanguage);
      translationComplete = true;
      System.out.println("The sentence in pig latin is: " + translatedSentence);
    }
    else if(inputCommand.equals("-o")){
      System.out.println("Write your sentence in the command line");
      String inputSentence = scan.next();
      String translatedLanguage = "rovarSpraket";
      translatedSentence = translateSentence(inputSentence, translatedLanguage);
      translationComplete = true;
      System.out.println("The sentence in rövarspråket is: " + translatedSentence);

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

  public static String translateSentence(String inputSentence, String translatedLanguage){
    String translatedSentence = "";
    String[] inputWords = inputSentence.split("\\s+");
    if(translatedLanguage.equals("pigLatin")){
      for (String inputWord: inputWords) {
        if (translatedSentence.length() != 0) {
            translatedSentence = translatedSentence + " ";
          }
      translatedSentence = translatedSentence + translateWordPigLatin(inputWord);
      }
    }
    else if(translatedLanguage.equals("rovarSpraket")){
      for (String inputWord: inputWords) {
        if (translatedSentence.length() != 0) {
            translatedSentence = translatedSentence + " ";
          }
      translatedSentence = translatedSentence + translateWordRovarSpraket(inputWord);
      }
    }
    return translatedSentence;
  }

  public static String translateWordPigLatin(String inputWord){
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

  public static String translateWordRovarSpraket(String inputWord){
    String rovarSpraket = "";
    String nextSubString = "";
    String loweredWord = inputWord.toLowerCase();
    String consonants = "bcdfghjklmnpqrstvwxz";
    int wordLength = inputWord.length();
    for (int index = 0; index < wordLength ;index++ ) {
      if (consonants.contains(String.valueOf(loweredWord.charAt(index)))){
          nextSubString = inputWord.substring(index, index+1) + "o" + inputWord.substring(index, index+1);
      }
      else {
        nextSubString = inputWord.substring(index, index+1);
      }
      rovarSpraket = rovarSpraket + nextSubString;
    }
    rovarSpraket = handleUppercase(inputWord, rovarSpraket);
    return rovarSpraket;
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

  public static String translateFile(String inputtextfile) {
  // translate the input text file.
  String translatedFile = "";
  try{
  FileReader inputFile = new FileReader(inputtextfile);

  //Instantiate the BufferedReader Class
  BufferedReader bufferReader = new BufferedReader(inputFile);

  //Variable to hold the one line data
  String line;

  // Read file line by line and print on the console
  while ((line = bufferReader.readLine()) != null)   {
    //System.out.println(line);
    translatedFile = translatedFile + translateSentence(line,"pigLatin");

  }
  //Close the buffer reader
  bufferReader.close();
  //System.out.println("Not yet implemented");
      }
  catch(Exception e){
      System.out.println("Error while reading file line by line:" + e.getMessage());
      translatedFile = "error";
                    }

  return translatedFile;
  }
}
