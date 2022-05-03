package javaapplication45;

/**
 *
 * @author stella
 */
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class Song {

    private String lyrics, artist, title;

    public Song(String lyrics, String artist, String title) {
        this.lyrics = lyrics;
        this.artist = artist;
        this.title = title;
    }

    public Song(String title) {
        this.title = title;
        try {
            this.lyrics = Finder.readableLyrics(this.title);
            this.artist = 
        } catch (IOException ex) {
        }
    }

    public static String getArtist(String input) {
        input = input.substring((input.indexOf("names\":\"") + 8), input.indexOf("\",\"full"));
        return input;
    }

    public static String getTitle(String input) {
        input = input.substring((input.indexOf("\"title\":\"") + 9), input.indexOf("\",\"title_with"));
        return input;
    }

    public static String getApiPath(String input) {
        input = input.substring((input.indexOf("path\":\"/songs/") + 14), input.indexOf("\",\"artist_names"));
        return input;
    }
}
