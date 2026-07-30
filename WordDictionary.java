import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class WordDictionary {
    private ArrayList<String> words = new ArrayList<String>();
    public WordDictionary(String filename) {
        try {
            String line;
            BufferedReader inputStream = new BufferedReader(new FileReader(filename));
            line = inputStream.readLine();
            while (line != null) {
                words.add(line);
                line = inputStream.readLine();
            }
            inputStream.close();
        }
        catch(FileNotFoundException e) {
            System.out.println(filename + " could not be found or could not be opened.");
            System.exit(1); //program cannot run without a dictionary file
        }
        catch(IOException e) {
            System.out.println("Error reading " + filename);
        }
    }
    public boolean isInDictionary(String word) {
        ArrayList<String> limitedSearch = getWordsOfLength(word.length());
        return limitedSearch.contains(word);
    }
    public ArrayList<String> getWordsOfLength(int length) {
        ArrayList<String> limitedWords = new ArrayList<String>();
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).length() == length) {
                limitedWords.add(words.get(i));
            }
        }
        return limitedWords;
    }
}