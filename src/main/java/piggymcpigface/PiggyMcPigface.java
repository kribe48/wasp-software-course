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

}
