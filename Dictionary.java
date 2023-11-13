package base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Dictionary {
    public static ArrayList<Word> words = new ArrayList<>();

    public static void setWords(ArrayList<Word> words) {
        Dictionary.words = words;
    }

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
            System.out.println((i + 1) + " | " + words.get(i).getWord_explain() + " | " + words.get(i).getWord_target());
        }
    }
    //get words
    public static ArrayList<Word> getWords() {
        return words;
    }
    public String getVie(String t) {
        t = t.trim();
        for(int i=0; i < words.size() ; i++) {
            String newstr = words.get(i).getWord_explain().trim();
            if( newstr.compareTo(t) == 0) {
                return words.get(i).getWord_target();
            }
        }
        return null;
    }
    public void removeVie() {
        System.out.println("Nhap tu ban muon xoa");
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        word = word.trim();
        for(int i=0; i < words.size() ; i++) {
            String newstr = words.get(i).getWord_explain().trim();
            if( newstr.compareTo(word) == 0) {
                words.remove(i);
            }
        }
    }
    public void addEng() {
        System.out.println("Nhap Tu tieng Anh");
        Scanner sc = new Scanner(System.in);
        String Eng = sc.nextLine();
        System.out.println("Nhap Tu tieng Viet");
        String Vie = sc.nextLine();
        words.add(new Word(Eng,Vie));
        System.out.println("success");
    }
    public void setVie() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap tu muon cap nhat");
        String word = sc.nextLine();
        System.out.println("Nhap nghia muon thay doi");
        String newword = sc.nextLine();
        newword = newword.trim();
        for(int i=0; i < words.size() ; i++) {
            String newstr = words.get(i).getWord_target().trim();
            if( newstr.compareTo(word) == 0) {
                words.get(i).setWord_target(newword);
            }
        }
    }

    public void suggest() {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> suggestions = new ArrayList<>();

        System.out.println("Tra cuu:");
        String test = sc.nextLine();
        for(int i = 0; i < words.size(); i++) {
            String search = words.get(i).getWord_explain().trim();
            if(search.startsWith(test)) {
                suggestions.add(search);
            }
        }

        for(String s : suggestions) {
            System.out.println(s);
        }
    }
}
