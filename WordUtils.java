public class WordUtils {
    public boolean differsByOne(String word1, String word2) {
        if (word1.length() == word2.length()) {
            int uncommonLetters = 0;
            for (int i = 0; i < word1.length(); i++) {
                if (word1.charAt(i) != word2.charAt(i)) {
                    ++uncommonLetters;
                }
            }
            if (uncommonLetters == 1) {
                return true;
            } else {
                return false; }
        } else {
            return false;}
    }
}