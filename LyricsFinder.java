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
public class LyricsFinder {
    public static String TitleNoSpace(String userInput){
        userInput = userInput.replaceAll(" ", "%20");
        userInput = userInput.toLowerCase();
        return userInput;
    }
    
    public static String infoURLBuilder(String title){
        title = TitleNoSpace(title);
        return ("https://genius.com/api/search/song?q="+title);
    }
    
    public static String lyricsURLBuilder(String artist, String title){
        return ("https://api.lyrics.ovh/v1/" + artist + "/" + title);
    }
    
    public static String readableLyrics(String rawLyrics){
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
        return rawLyrics;
    }
}
