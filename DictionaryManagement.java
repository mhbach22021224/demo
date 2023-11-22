package base;

import java.io.*;
import java.util.Scanner;
public class DictionaryManagement {
    public void insertFromFile(Dictionary dictionary) throws IOException {
//        Scanner scanner = new Scanner(System.in);
        FileReader fr = new FileReader("C:/Users/MAI HOANG BACH/IdeaProjects/Dictionary/src/main/resources/base/truedata.txt");
        BufferedReader br = new BufferedReader(fr);
        while (true){
            String word_target = "";
            String word_explain = "";
            boolean checkE = true;
            String s = br.readLine();
            if(s == null) {
                break;
            }
            for(int i = 0; i < s.length() ; i++) {
                if( s.charAt(i) == ':' ) {
                    checkE = false;
                    continue;
                }
                if(checkE == true) {
                    word_target += s.charAt(i);
                }
                else {
                    word_explain += s.charAt(i);
                }
            }
            word_target = word_target.trim();
            word_explain = word_explain.trim();
            String[] strings = word_target.split(", ");
            for(String str : strings) {
                Word w = new Word(str, word_explain);
                dictionary.addWord(w);
            }

        }
    }
}
