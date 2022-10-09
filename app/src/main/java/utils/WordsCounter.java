package utils;

public class WordsCounter {
    public static String getWordsCount(String toString) {
        int numWords = 0;
        int index = 0;
        boolean prevWhiteSpace = true;
        while (index < toString.length()) {
            char c = toString.charAt(index++);
            boolean currWhiteSpace = Character.isWhitespace(c);
            if (prevWhiteSpace && !currWhiteSpace) {
                numWords++;
            }
            prevWhiteSpace = currWhiteSpace;
        }
        return String.valueOf(numWords);
    }
}
