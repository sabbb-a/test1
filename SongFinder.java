/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication45;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author sabri
 */
public class SongFinder {
    private static final String SEARCHURL = "https://genius.com/api/search/lyric?q=";
    
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
    
    public static String songURLBuilder(String snippet){
        return (SEARCHURL + removeSpaces(snippet));
    }
    public static String reading(String snippet) throws IOException{
        URL search = null;
        try {
            search = new URL(songURLBuilder(snippet));
        } catch (MalformedURLException ex) {}
        Scanner scanner = new Scanner(search.openStream());
        return scanner.nextLine();
    }
    
    public static String[] matches(String snippet) throws IOException{
        String matches = reading(snippet);
        String[] songMatches = new String[11];
        songMatches = matches.split(",\"full_title\":\"", 12);
        songMatches[0] = null;
        for (int i=0; i<songMatches.length; i++){
            if (!(songMatches[i]==null)){
                songMatches[i]=songMatches[i].substring(0, songMatches[i].indexOf("\",\"header"));
            }
        }
        return songMatches;
    }
    
    
    
    
}
