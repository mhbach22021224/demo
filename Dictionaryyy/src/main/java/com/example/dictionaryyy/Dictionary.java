package com.example.dictionaryyy;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class Dictionary extends DictionaryC {
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


    @Override
    public String getVie(String t) {
        t = t.trim();
        t = t.toLowerCase(); // fix
        for (int i = 0; i < words.size(); i++) {
            String newstr = words.get(i).getWord_target().trim().toLowerCase(); // String newstr = words.get(i).getWord_target().trim()
            if (newstr.compareTo(t) == 0) {
                return words.get(i).getWord_explain();
            }
        }
        return null;
    }

    @Override
    public void removeVie(String TuCanXoa) throws IOException {
        TuCanXoa = TuCanXoa.trim();
        TuCanXoa = TuCanXoa.toLowerCase();
        for (int i = 0; i < words.size(); i++) {
            String newstr = words.get(i).getWord_target().trim().toLowerCase();
            if (newstr.compareTo(TuCanXoa) == 0) {
                words.remove(i);
            }
        }
        //*****
        FileWriter fr = new FileWriter("truedata.txt");
        for (int i = 0; i < words.size(); i++) {
            fr.write(words.get(i).getWord_target() + " : " + words.get(i).getWord_explain() + "\n");
        }
        fr.close();
        //*****
    }

    @Override
    public void update(String TV, String Update) throws IOException {
        String word = TV.trim().toLowerCase();
        for (int i = 0; i < words.size(); i++) {
            String newstr = words.get(i).getWord_target().trim().toLowerCase();
            if (newstr.compareTo(word) == 0) {
                words.get(i).setWord_explain(Update);
            }
        }
        //*****
        FileWriter fr = new FileWriter("truedata.txt");
        for (int i = 0; i < words.size(); i++) {
            fr.write(words.get(i).getWord_target() + " : " + words.get(i).getWord_explain() + "\n");
        }
        fr.close();
        //*****
    }

    @Override
    public void addVie(String Vie, String Eng) throws IOException {
        words.add(new Word(Vie, Eng));
        //*****
        FileWriter fr = new FileWriter("truedata.txt");
        for (int i = 0; i < words.size(); i++) {
            fr.write(words.get(i).getWord_target() + " : " + words.get(i).getWord_explain() + "\n");
        }
        fr.close();
        //*****
    }

    @Override
    public String hintedWord(String word) {
        if(word.equals("")) {
            return "Kết quả của bạn...";
        }

        StringBuilder res = new StringBuilder();
        ArrayList<String> suggestions = new ArrayList<>();

        for (int i = 0; i < words.size(); i++) {
            String search = words.get(i).getWord_target().trim().toLowerCase();
            if (search.startsWith(word.toLowerCase())) {
                suggestions.add((words.get(i).getWord_target().trim() + " : " + words.get(i).getWord_explain().trim()) + '\n');
            }
        }

        for (String suggestion : suggestions) {
            res.append(suggestion);
        }

        return res.toString();
    }

    /** toi uu thuat toan tim kiem. */
    public String FindVie(String target) {
        int left = 0;
        int right = words.size() - 1;
        target = target.trim().toLowerCase();
        while (left <= right) {
            int mid = left + (right - left) / 2;
            String word = words.get(mid).getWord_target().trim().toLowerCase();

            int compareResult = word.compareTo(target);
            if (compareResult == 0) {
                return words.get(mid).getWord_explain(); // Trả về chuỗi
            } else if (compareResult < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return "Không có từ này trong từ điển"; // Trả về -1 nếu không tìm thấy chuỗi
    }
}


