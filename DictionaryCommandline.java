package base;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class DictionaryCommandline {
    public static void dictionaryBasic() throws IOException {
        Dictionary dictionary = new Dictionary();
        DictionaryManagement dictionaryManagement = new DictionaryManagement();

        // nhập liệu từ file
        dictionaryManagement.insertFromFile(dictionary);
    }

    public static void dictionaryAdvanced() throws IOException {
        Dictionary dictionary = new Dictionary();
        DictionaryManagement dictionaryManagement = new DictionaryManagement();

        // nhập liệu từ file
        dictionaryManagement.insertFromFile(dictionary);
        System.out.println("1.showAllWords");
        System.out.println("2.Search Word");
        System.out.println("3.Add Word");
        System.out.println("4.Remove Word");
        System.out.println("5.Update Word");
        System.out.println("6.Look up Word");
        System.out.println("7.STOP");


        while (true) {
            Scanner sc = new Scanner(System.in);
            int choose = sc.nextInt();
            if (choose == 1) {
                String t = dictionary.showAllWords();
                System.out.println(t);
            }
            if (choose == 2) {
                while (true) {
                    String text = sc.nextLine();
                    text = text.trim();
                    if (text.compareTo("3") == 0) {
                        break;
                    }
                    System.out.println(dictionary.getVie(text));
                }
                String text = sc.nextLine();
                text = text.trim();
                System.out.println(dictionary.getVie(text));

            }
            if (choose == 7) {
                break;
            }
            if (choose == 3) {
                String vie = sc.nextLine();
                String eng = sc.nextLine();
                dictionary.addWord(eng,vie);
            }
            if (choose == 4) {
                String word = sc.nextLine();
                dictionary.remove(word);
            }
            if (choose == 5) {
                String engWord = sc.nextLine();
                String definition = sc.nextLine();
                dictionary.update(engWord,definition);
            }
            if (choose == 6) {
                System.out.println("Nhap tu:");
                String s = sc.next();
                System.out.println(dictionary.hintedWord(s));
            }

        }
    }


    public static void main(String[] args) throws IOException {
         dictionaryAdvanced();
    }
}
