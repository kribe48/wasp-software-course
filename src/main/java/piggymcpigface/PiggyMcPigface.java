package piggymcpigface;

import java.util.Scanner;

public class PiggyMcPigface {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in).useDelimiter("\\n");
    System.out.println("Type -r for reading from an input file, -s for translating a sentence");
    String inputCommand = scan.next();
    String translatedSentence = "";
    boolean translationComplete = false;

    if(inputCommand.equals("-r")){
      System.out.println("Not yet implemented");
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
//    switch(inputCommand) {
//      case "-r":  System.out.println("Not yet implemented");
//                  break;
//      case "-s":  System.out.println("Write your sentence in the command line");
//                  String inputSentence = scan.nextLine();
//                  translatedSentence = translateSentence(inputSentence);
//                  translationComplete = true;
//                  System.out.println("The sentence in pig latin is: " + translatedSentence);
//                  break;
//    default:      System.out.println("Unknown Command");
//                  break;

//    }
    if(translationComplete){
      System.out.println("Type -w followed by a filename if you want to store the data, otherwise type quit");
      String storeCommand = scan.next();
      if(storeCommand.equals("-w")){
         System.out.println("Not yet implemented");
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
    String pigLatin = "";
    int wordLength = inputWord.length();
    int vowelIdx = indexOfFirstVowel(inputWord);
    if (vowelIdx == 0){
      pigLatin = inputWord + "way";
    }
    else if(vowelIdx > 0){
      pigLatin = inputWord.substring(vowelIdx,wordLength)  + inputWord.substring(0,vowelIdx) + "ay";
    }
    return pigLatin;
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

}
