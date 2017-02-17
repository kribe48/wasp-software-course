//Version
import java.util.Scanner;

class PiggyMcPigface {
  public static void main(String[] args){

    String inputWord = readWord();
    translateWord(inputWord);

  }

  public static String readWord() {
    Scanner scan = new Scanner(System.in);
    System.out.println("Write a word that you want to translate:");

    String inputWord = scan.next();
    return inputWord;
  }

  public static void translateWord(String inputWord){
    System.out.println("The word in pig latin is: ashtray ");
  }
}
