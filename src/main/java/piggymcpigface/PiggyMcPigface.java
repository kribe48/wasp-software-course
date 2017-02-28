package piggymcpigface;

import java.util.Scanner;

public class PiggyMcPigface {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    System.out.println("Write a sentence that you want to translate:");

    String inputSentence = scan.nextLine();

    String translatedSentence = translateSentence(inputSentence);
    System.out.println("The sentence in pig latin is: " + translatedSentence);
  }

  public static String translateSentence(String inputSentence){
    String translatedSentence = "";
    String[] inputWords = inputSentence.split("\\s+");
    System.out.println(inputWords.length);
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
