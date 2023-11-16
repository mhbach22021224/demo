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

    public String showAllWords() {
        String res = "";
        res += "No | English | Vietnamese";
        res += '\n';
        for (int i = 0; i < words.size(); i++) {
            res += ((i + 1) + " | " + words.get(i).getWord_target() + " | " + words.get(i).getWord_explain()) + '\n';
        }
        return res;
    }
    //get words
    public static ArrayList<Word> getWords() {
        return words;
    }

    // Tìm từ
    public String getVie(String t) {
        for(int i=0; i < words.size(); i++) {
            String newstr = words.get(i).getWord_target().toLowerCase().trim();
            if( newstr.compareTo(t.toLowerCase()) == 0) {
                return words.get(i).getWord_explain();
            }
        }
        return null;
    }

    // Xóa từ
    public void remove(String TuCanXoa) {
        System.out.println("Nhap tu ban muon xoa");
        Scanner sc = new Scanner(System.in);
        TuCanXoa = sc.nextLine();
        TuCanXoa = TuCanXoa.trim();
        for(int i=0; i < words.size() ; i++) {
            String newstr = words.get(i).getWord_target().trim();
            if( newstr.compareTo(TuCanXoa) == 0) {
                words.remove(i);
            }
        }
    }

    //Thêm từ
    public void addWord(String Vie, String Eng) {
        System.out.println("Nhap Tu tieng Viet");
        Scanner sc = new Scanner(System.in);
        Vie = sc.nextLine();
        System.out.println("Nhap Tu tieng Anh");
        Eng = sc.nextLine();
        words.add(new Word(Vie,Eng));
        System.out.println("success");
    }

    // Cập nhật từ
    public void update(String Vie, String engUpdate) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap tu muon cap nhat");
        Vie = sc.nextLine();
        Vie = Vie.trim();
        System.out.println("Nhap nghia muon thay doi");
        engUpdate = sc.nextLine();
        engUpdate = engUpdate.trim();
        for(int i=0; i < words.size() ; i++) {
            String newstr = words.get(i).getWord_target().trim();
            if( newstr.compareTo(Vie) == 0) {
                words.get(i).setWord_explain(engUpdate);
            }
        }
    }

    //In ra các từ gợi ý
    public String hintedWord(String word) {
        String res = "";
        ArrayList<String> suggestions = new ArrayList<>();

        for(int i = 0; i < words.size(); i++) {
            String search = words.get(i).getWord_target().trim().toLowerCase();
            if(search.startsWith(word.toLowerCase())) {
                suggestions.add((words.get(i).getWord_target().trim() + " : " + words.get(i).getWord_explain().trim()) + '\n');
            }
        }
        for(int i = 0; i < suggestions.size(); i++) {
            res += suggestions.get(i);
        }
        return res;
    }
}
