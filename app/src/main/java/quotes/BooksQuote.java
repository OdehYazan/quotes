package quotes;


import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;

public class BooksQuote {
    private String author;
    private String text;


    public BooksQuote(){

    }

    public BooksQuote(String author, String text) {
        this.author = author;
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }
//    public static String readFromFile(String path) throws Exception
//    {
//        Gson gson = new Gson();
//
//
//        BufferedReader file = new BufferedReader(new FileReader(path));
//        BooksQuote[] quotesFromFiles = gson.fromJson(file, BooksQuote[].class);
//
//        int randomIndex = (int)(Math.random() * quotesFromFiles.length);
//        String randomQuote = quotesFromFiles[randomIndex].toString();
//
//        return randomQuote;
//    }

    @Override
    public String toString() {
        return "BooksQuote{" +
                "author='" + author + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
