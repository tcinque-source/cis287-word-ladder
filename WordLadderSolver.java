import java.util.ArrayList;

public class WordLadderSolver {
    
    WordDictionary dictionary;
    WordUtils wu = new WordUtils();
    ArrayList<String> ladder = new ArrayList<>();    
    ArrayList<String> candidateWords;
    ArrayList<String> badWords = new ArrayList<>();
    
    public WordLadderSolver(WordDictionary dictionary) {
        this.dictionary = dictionary;
    }
    public ArrayList<String> findLadder(String startWord, String endWord) {
        candidateWords = dictionary.getWordsOfLength(startWord.length());
         if (recursiveSearch(startWord, endWord)) {
            return ladder; 
         } else {
            System.out.println("Ladder could not be found.");
            return ladder; //recursive search returns falls, no ladder could be found
         }
    }
    
    

    private boolean recursiveSearch(String currentWord, String endWord) {
        ladder.add(currentWord);
        if (!wu.differsByOne(currentWord, endWord)) {
            for(String word: candidateWords) {
                if (!ladder.contains(word) && wu.differsByOne(word, currentWord) && !badWords.contains(word)) {
                    return recursiveSearch(word, endWord);
                }
            }
            //backtracking method
            return backtrack(endWord);

        } else { //ladder has been solved
            ladder.add(endWord);
            return true;
        }
    } 
    int bt = 0;
    private boolean backtrack(String endWord) {
        ++bt;
        if (bt > 999) { //arbitrary cut off to prevent infinite searching
            return false;
        }
        int ladderLength = ladder.size();
        for(String word: candidateWords) {
            if (!ladder.contains(word) && wu.differsByOne(word, ladder.get(ladderLength - 2)) && !badWords.contains(word)) {
                badWords.add(ladder.remove(ladderLength - 1));
                return recursiveSearch(word, endWord);
            }
        }
        if (ladderLength > 2) {
            badWords.add(ladder.remove(ladderLength - 1));
            return backtrack(endWord);
        } else return false;
    }
}