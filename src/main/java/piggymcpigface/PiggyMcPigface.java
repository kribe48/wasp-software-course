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

    return "ashtray";
  }
}
