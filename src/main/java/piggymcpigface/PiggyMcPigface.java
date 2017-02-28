package piggymcpigface;

import java.util.Scanner;

public class PiggyMcPigface {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    System.out.println("Write a word that you want to translate:");

    String inputWord = scan.next();
    String translatedWord = translateWord(inputWord);
    System.out.println("The word in pig latin is: " + translatedWord);
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
