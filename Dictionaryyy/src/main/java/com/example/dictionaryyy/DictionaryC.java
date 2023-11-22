package com.example.dictionaryyy;

import java.io.IOException;

public abstract class DictionaryC {

    public abstract String getVie(String t);

    public abstract void removeVie(String TuCanXoa) throws IOException;

    public abstract void update(String TV, String Update) throws IOException;

    public abstract void addVie(String Vie, String Eng) throws IOException;

    public abstract String hintedWord(String word);
}
