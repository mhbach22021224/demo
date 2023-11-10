package Base;
import javafx.scene.Scene;

import java.util.*;
import java.io.*;
import java.util.Dictionary;

public class DictionaryManagement extends Base.Dictionary {
    public static void insertFromFile(Dictionary dictionary, String path) {
         try {
             File file = new File("C:/Users/MAI HOANG BACH/IdeaProjects/project/src/main/resources/Dictionaries.txt");
             BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
             String line = bufferedReader.readLine();
             line = line.replace("@", "");
             System.out.println(line);
         } catch (FileNotFoundException e) {
             throw new RuntimeException(e);
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
    }

    public static int isContain(String str1, String str2) {
        for (int i = 0; i < Math.min(str1.length(), str2.length()); i++) {
            if (str1.charAt(i) > str2.charAt(i)) {
                return 1;
            } else if (str1.charAt(i) < str2.charAt(i)) {
                return -1;
            }
        }
        if (str1.length() > str2.length()) {
            return 1;
        }
        return 0;
    }
    public static int binarySearch(int left, int right, String word) {
        if (right < left) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        int compare = isContain(word, words.get(mid).getWord_target());
        if (compare == -1) {
            return binarySearch(left, mid - 1, word);
        } else if (compare == 1) {
            return binarySearch(mid + 1, right, word);
        } else {
            return mid;
        }
    }

    public static void dictionaryLookup() {
         Scanner sc = new Scanner(System.in);
         String word = sc.next();
         int index = binarySearch(0, words.size(), word);
    }
    public static void addWord(Word word, String path) {
        try {
            FileWriter fileWriter = new FileWriter(path, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("@" + word.getWord_target() + '\n' + "*" + word.getWord_type()
                    + '\n' + "-" + word.getWord_explain() + '\n' + "=" + word.getWord_example());
            bufferedWriter.newLine();
        } catch(FileNotFoundException e) {
            System.out.println("File error!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateWord() {

    }

    public static void removeWord() {

    }

    public static void main(String[] args) {
        try {
            File file = new File("C:/Users/MAI HOANG BACH/IdeaProjects/project/src/main/resources/Dictionaries.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {

        }
    }
}
