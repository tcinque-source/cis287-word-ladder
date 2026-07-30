import java.util.Scanner;
import java.util.StringTokenizer;

public class WordLadderApp {
    public static void main(String[] args) {
        WordUtils wordTools = new WordUtils();
        WordDictionary dic = new WordDictionary("words_small.txt"); //replace filename here to use different dictionary
        WordLadderSolver solv = new WordLadderSolver(dic);
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Welcome to Word Ladder Solver!");
        System.out.println("Please enter two words of equal length that appear in the text file.");
        System.out.println(" ");
        System.out.print("Enter starting word: ");
        String startWord = keyboard.nextLine();
        System.out.println(" ");
        System.out.print("Enter ending word: ");
        String endWord = keyboard.nextLine();
        startWord = startWord.trim();
        endWord = endWord.trim();
        
        System.out.println(" ");
        System.out.println("Results: ");
        
        if (dic.isInDictionary(startWord) && dic.isInDictionary(endWord)) {
            if (startWord.length() == endWord.length()) {
                //check that the user did not enter the same word twice
                if (!startWord.equalsIgnoreCase(endWord)) {
                    //check that user did not enter words off by one
                    if (!wordTools.differsByOne(startWord, endWord)) {
                        
                        //calls the solver here
                        System.out.println(solv.findLadder(startWord, endWord));
                        
                    } else { //input words are off by one
                        System.out.println("These input words are off by one letter, if you look closesly. you already have a two-step ladder.");
                    }
                } else { //input words are the same
                    System.out.println("Both input words are the same, a ladder with only one rung is not a ladder.");
                }
            } else { //input words are different length
                System.out.println("You can't make a ladder with words of different lengths.");
            }
        } else { //input text is not a word
            System.out.println("One or more input words is not in the dictionary.");
        }
    }
}