package base;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

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

    //Tim kiem tu bang thuat toan
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

    public void sortDictionary() throws IOException {

        Collections.sort(words, new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                return o1.getWord_target().compareTo(o2.getWord_target());
            }
        });

        FileWriter fr = new FileWriter("C:/Users/MAI HOANG BACH/IdeaProjects/Dictionary/src/main/resources/base/truedata.txt");
        for(int i=0;i< words.size(); i++) {
            fr.write(words.get(i).getWord_target() + " : " + words.get(i).getWord_explain() + "\n");
        }

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
    public void remove(String TuCanXoa) throws IOException {
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

        FileWriter fr = new FileWriter("C:/Users/MAI HOANG BACH/IdeaProjects/Dictionary/src/main/resources/base/truedata.txt");
        for(int i=0;i< words.size(); i++) {
            fr.write(words.get(i).getWord_target() + " : " + words.get(i).getWord_explain() + "\n");
        }
    }

    //Thêm từ
    public void addWord(String Eng, String Vie) throws IOException {
        System.out.println("Nhap Tu tieng Anh");
        Scanner sc = new Scanner(System.in);
        Eng = sc.nextLine();
        System.out.println("Nhap Tu tieng Viet");
        Vie = sc.nextLine();
        words.add(new Word(Eng,Vie));
        System.out.println("success");

        FileWriter fr = new FileWriter("C:/Users/MAI HOANG BACH/IdeaProjects/Dictionary/src/main/resources/base/truedata.txt");
        for(int i=0;i< words.size(); i++) {
            fr.write(words.get(i).getWord_target() + " : " + words.get(i).getWord_explain() + "\n");
        }
    }

    // Cập nhật từ
    public void update(String Eng, String Update) throws IOException {
        System.out.println("Nhap tu can chinh");
        Scanner sc = new Scanner(System.in);
        Eng = sc.nextLine();
        System.out.println("Nhap nghia moi");
        Update = sc.nextLine();

        String word = Eng.trim().toLowerCase();
        for(int i=0; i < words.size() ; i++) {
            String newstr = words.get(i).getWord_target().trim().toLowerCase();
            if( newstr.compareTo(word) == 0) {
                words.get(i).setWord_explain(Update);
            }
        }
        //*****
        FileWriter fr = new FileWriter("C:/Users/MAI HOANG BACH/IdeaProjects/Dictionary/src/main/resources/base/truedata.txt");
        for(int i=0;i< words.size(); i++) {
            fr.write(words.get(i).getWord_target() + " : " + words.get(i).getWord_explain() + "\n");
        }
        //*****
    }

    //In ra các từ gợi ý
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
}