/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication45;

/**
 *
 * @author sabri
 */
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class SongInfo {
    private static final String INFOURL = "https://genius.com/api/search/song?q=";
    
    public static String removeSpaces (String userInput){
        if (userInput.contains(" ")){
            userInput = userInput.replaceAll(" ", "%20");
            userInput = userInput.toLowerCase();
            return userInput;
        }
        else{
            return userInput;
        }
    }

    public static String getArtist(String title) throws IOException{
        String input = reading(title);
        input = input.substring((input.indexOf("names\":\"")+8), input.indexOf("\",\"full"));
        if(input.contains(" (Ft. ")){
            input = input.substring(0, input.indexOf(" (Ft. "));
        }
        return input;
    }
    
    public static String getTitle(String title) throws IOException{
        String input = reading(title);
        input = input.substring((input.indexOf("\"title\":\"")+9), input.indexOf("\",\"title_with"));
        return input;
    }
    public static String getApiPath(String title) throws IOException{
        String input = reading(title);
        input = input.substring((input.indexOf("path\":\"/songs/")+14), input.indexOf("\",\"artist_names"));
        return input;
    }
    
    public static String infoURLBuilder(String title){
        return (INFOURL + removeSpaces(title));
    }
    
    public static String reading (String title) throws IOException{
        URL info = null;
        try {
            info = new URL(infoURLBuilder(title));
        } catch (MalformedURLException ex) {}
        BufferedReader in = new BufferedReader(
        new InputStreamReader(info.openStream()));
        return in.readLine();
    }
}
   

