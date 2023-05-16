
import java.util.HashSet;


class WordDictionary {
    HashSet<String> dict;

    public WordDictionary() {
        dict = new HashSet<>();
    }

    public void addWord(String word) {
        dict.add(word);
    }

    public boolean isSame(String have, String search)
    {
        for (int i = 0; i < search.length(); i++)
        {
            if (search.charAt(i) != '.')
            {
                if (search.charAt(i) != have.charAt(i))
                    return false;
            }
        }
        return true;
    }
    public boolean search(String word) {
        if (dict.contains(word)) return true;
        for (String str: dict)
        {
            if (str.equals(word))
                return true;
            if (str.length() == word.length() && isSame(str, word)) {
                return true;
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}