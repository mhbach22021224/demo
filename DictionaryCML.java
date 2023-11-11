package com.example.dictionaryyy;

import java.io.IOException;
import java.util.Scanner;

class DictionaryCML {
    public static void dictionaryBasic() throws IOException {
        Dictionary dictionary = new Dictionary();
        DictionaryManagement dictionaryManagement = new DictionaryManagement();

        // nhập liệu từ file
        dictionaryManagement.inserFromFile(dictionary);
    }
    public static void main(String[] args) throws IOException {
        Dictionary dictionary = new Dictionary();
        DictionaryManagement dictionaryManagement = new DictionaryManagement();

        // nhập liệu từ file
        dictionaryManagement.inserFromFile(dictionary);
        System.out.println("1.showAllWords");
        System.out.println("2.Findword");
        System.out.println("3.STOP");
//        while (true) {
//            Scanner sc = new Scanner(System.in);
//            int choose = sc.nextInt();
//            if( choose == 1) {
//                dictionary.showAllWords();
//            }
//            if (choose == 2) {
//                while (true) {
//                    String text = sc.next();
//                    text = text.trim();
//                    if(text.compareTo("3") == 0) {
//                        break;
//                    }
//                    System.out.println(dictionary.getVie(text));
//                }
////                String text = sc.next();
////                text = text.trim();
////                System.out.println(dictionary.getVie(text));
//
//            }
//            if ( choose == 3) {
//                break;
//            }
//        }
//        dictionary.removeVie("A Dong ");
//        dictionary.showAllWords();
//        dictionary.addVie();
//        dictionary.showAllWords();
        dictionary.setVie("A di đà phật");
        dictionary.showAllWords();
    }
}