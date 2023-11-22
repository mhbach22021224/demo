package com.example.dictionaryyy;
import java.io.*;
import java.util.Scanner;
class DictionaryManagement {
    // nhập liệu từ bàn phím và thêm vào từ điển
    public void inserFromFile(Dictionary dictionary) throws IOException {
//        Scanner scanner = new Scanner(System.in);
        FileReader fr = new FileReader("truedata.txt");
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
                    word_target+=s.charAt(i);
                }
                else {
                    word_explain += s.charAt(i);
                }
            }
            word_target = word_target.trim();
            word_explain = word_explain.trim();
            Word word = new Word(word_target, word_explain);
            dictionary.addWord(word);
        }
    }
}
