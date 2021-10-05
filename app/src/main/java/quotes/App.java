/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class App {


    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(getQuote());
    }



    public static String getQuote() throws FileNotFoundException {
        Gson gson=new Gson();
        Reader reader =new FileReader("app/src/main/resources/test.json");

        Type listType=new TypeToken<List<BooksQuote>>(){}.getType();
        List<BooksQuote> booksList= new Gson().fromJson(reader,listType);


        Random random=new Random();
        int randomNum= random.nextInt((booksList.size()-1)+1);
        return booksList.get(randomNum).toString();
        // System.out.println("Book Author :"+booksList.get(randomNum).getAuthor());
        // System.out.println("Book Quote:"+booksList.get(randomNum).getText());

    }

//public static void main(String[] args) throws Exception {
//
//    System.out.println(BooksQuote.readFromFile("./app/src/main/resources/test.json"));
//}



}