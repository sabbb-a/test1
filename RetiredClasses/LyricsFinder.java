/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication45;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;


/**
 *
 * @author sabri
 */
public class LyricsFinder {
    private static final String LYRICSURL = "https://api.lyrics.ovh/v1/";
    
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

    public static String lyricsURLBuilder(String title) throws IOException{
        return ( LYRICSURL+ SongInfo.getArtist(title) + "/" + removeSpaces(title));
    }
    
    public static String reading (String title) throws IOException{
        URL info = null;
        try {
            info = new URL(lyricsURLBuilder(title));
        } catch (MalformedURLException ex) {}
        BufferedReader in = new BufferedReader(
        new InputStreamReader(info.openStream()));
        return in.readLine();
    }
    
    public static String readableLyrics(String title) throws IOException{
        String rawLyrics = reading(title);
        rawLyrics = rawLyrics.replaceAll("\\{\"lyrics\":\"", "");
        rawLyrics = rawLyrics.replaceAll("\"}", "");
        rawLyrics = rawLyrics.replaceAll(" \\\\n\\\\n\\\\n\\\\n", "\n\n");
        rawLyrics = rawLyrics.replaceAll("\\\\n\\\\n\\\\n\\\\n", "\n\n");
        rawLyrics = rawLyrics.replaceAll(" \\\\n\\\\n\\\\n", "\n\n");
        rawLyrics = rawLyrics.replaceAll("\\\\n\\\\n\\\\n", "\n\n");
        rawLyrics = rawLyrics.replaceAll(" \\\\n\\\\n", "\n");
        rawLyrics = rawLyrics.replaceAll("\\\\n\\\\n", "\n");
        rawLyrics = rawLyrics.replaceAll(" \\\\n", "\n");
        rawLyrics = rawLyrics.replaceAll("\\\\n", "\n");
        rawLyrics = rawLyrics.replaceAll("\\\\\"", "\"");
        rawLyrics = rawLyrics.replaceAll("\\\\r", "");
        return rawLyrics;
    }
}
