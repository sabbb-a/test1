package javaapplication45;

/**
 *
 * @author stella
 */
import java.net.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Song {

    private static final String INFOURL = "https://genius.com/api/search/song?q=";
    private String lyrics, artist, title, APIPath;

    public Song(String lyrics, String artist, String title) {
        this.lyrics = lyrics;
        this.artist = artist;
        this.title = title;
    }

    public Song(String title) {
        this.title = title;
        try {
            this.lyrics = Finder.readableLyrics(this.title);
            this.artist = retrieveArtist(this.title);
            this.APIPath = retrieveApiPath(this.title);
        } catch (IOException ex) {
            System.out.println("An error has occured.");
        }
    }

    public static String infoURLBuilder(String title) {
        return (INFOURL + Finder.removeSpaces(title));
    }

    public static String infoReading(String title) throws IOException {
        URL info = null;
        try {
            info = new URL(infoURLBuilder(title));
        } catch (MalformedURLException ex) {
        }
        BufferedReader in = new BufferedReader(
                new InputStreamReader(info.openStream()));
        return in.readLine();
    }

    public String getLyrics() {
        return lyrics;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }
    
    public static String retrieveArtist(String title) throws IOException{
        String input = infoReading(title);
        input = input.substring((input.indexOf("names\":\"")+8), input.indexOf("\",\"full"));
        if(input.contains(" (Ft. ")){
            input = input.substring(0, input.indexOf(" (Ft. "));
        }
        return input;
    }
    
    public static String retrieveTitle(String title) throws IOException{
        String input = infoReading(title);
        input = input.substring((input.indexOf("\"title\":\"")+9), input.indexOf("\",\"title_with"));
        return input;
    }
    public static String retrieveApiPath(String title) throws IOException{
        String input = infoReading(title);
        input = input.substring((input.indexOf("path\":\"/songs/")+14), input.indexOf("\",\"artist_names"));
        return input;
    }
}
