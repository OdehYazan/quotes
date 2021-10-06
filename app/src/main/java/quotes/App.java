/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static java.net.HttpURLConnection.HTTP_OK;

public class App {


    public static void main(String[] args) throws FileNotFoundException {
//        System.out.println(getQuote());
        String path = "./app/src/main/resources/test.json";
        // the star wars api give 307 statues error
//        String apiUrl = "http://swquotesapi.digitaljedi.dk/api/SWQuote/RandomStarWarsQuote";
        String apiUrl ="http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en";

       apiData(apiUrl);
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
    public static String apiData(String  apiUrl){
        StringBuilder createdLine = new StringBuilder();
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int connectionStatus = connection.getResponseCode();
            
            // this will have final value of the Http connectionStatus
//            if (connectionStatus == connection.getResponseCode(HTTP_OK))
            
            if(connectionStatus == 200){
                InputStream input = connection.getInputStream();
                InputStreamReader reader = new InputStreamReader(input);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String lineToRead = bufferedReader.readLine();
                createdLine = new StringBuilder(lineToRead);

                while(lineToRead != null){ 
                    
                    System.out.println(lineToRead);
                    lineToRead = bufferedReader.readLine();
                    createdLine.append(lineToRead);
                    
                }
                
                bufferedReader.close();

                // write methode remove all the data in the file and print the new one.
                // if we use true after the file name(path) will append it to the end of the existing text

                FileWriter fileToWrite = new FileWriter("app/src/main/resources/apiData.json");
                
                fileToWrite.write(createdLine.toString());
                
                fileToWrite.close();
            } else{
                System.out.println("NO INTERNET CONNECTION "+connectionStatus);
                getQuote();
            }
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return createdLine.toString();
    }

//public static void main(String[] args) throws Exception {
//
//    System.out.println(BooksQuote.readFromFile("./app/src/main/resources/test.json"));
//}




}