package com.example.dictionaryyy;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Dictionary {
    public static ArrayList<Word> words;

    // constructor
    public Dictionary() {
        this.words = new ArrayList<>();
    }

    // thêm từ vào từ điển
    public void addWord(Word word) {
        words.add(word);
    }



    // hiển thị tất cả từ trong từ điển
    public void showAllWords() {
        System.out.println("No | English | Vietnamese");
        for (int i = 0; i < words.size(); i++) {
            System.out.println((i + 1) + " | " + words.get(i).getWord_target() + " | " + words.get(i).getWord_explain());
        }
    }
    //get words
    public ArrayList<Word> getWords() {
        return words;
    }
    public String getVie(String t) {
        t = t.trim();
        for(int i=0; i < words.size() ; i++) {
            String newstr = words.get(i).getWord_target().trim();
            if( newstr.compareTo(t) == 0) {
                return words.get(i).getWord_explain();
            }
        }
        return null;
    }
    public void removeVie(String word) {
        word = word.trim();
        for(int i=0; i < words.size() ; i++) {
            String newstr = words.get(i).getWord_target().trim();
            if( newstr.compareTo(word) == 0) {
                words.remove(i);
            }
        }
    }
    public void addVie() {
        System.out.println("Nhap Tu tieng Viet");
        Scanner sc = new Scanner(System.in);
        String Vie = sc.nextLine();
        System.out.println("Nhap Tu tieng Anh");
        String Eng = sc.nextLine();
        words.add(new Word(Vie,Eng));
        System.out.println("success");
    }
    public void setVie(String word) {
        System.out.println("Nhap nghia muon thay doi");
        Scanner sc = new Scanner(System.in);
        String newword = sc.nextLine();
        newword = newword.trim();
        for(int i=0; i < words.size() ; i++) {
            String newstr = words.get(i).getWord_target().trim();
            if( newstr.compareTo(word) == 0) {
                words.get(i).setWord_target(newword);
            }
        }
    }
}
