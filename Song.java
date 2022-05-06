package javaapplication45;

/**
 *
 * @author stella
 */
import java.net.*;
import java.io.*;
import java.util.*;

public class Song {

    private static final String INFOURL = "https://genius.com/api/search/song?q=";
    private String lyrics, artist, title;
    private Date date;


    @Override
    public boolean equals(Object obj) {
        return (this.toString().equals(obj.toString()));
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.artist);
        hash = 53 * hash + Objects.hashCode(this.title);
        return hash;
    }

    public Song(String artist, String title, Date date) {
        this.artist = artist;
        this.title = title;
        this.date = date;
    }

    public Song(String title) {
        this.title = title;
        try {
            this.lyrics = Finder.readableLyrics(this.title);
            this.artist = retrieveArtist(this.title);
            //this.date = retrieveDate(this.title);
            //MUST CIRCUMVENT THE API HAVING A \n IN THE TEXT SOMEHOW!
            //===========================!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
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
        return this.lyrics;
    }

    public String getArtist() {
        return this.artist;
    }

    public String getTitle() {
        return this.title;
    }

    public Date getDate() {
        return this.date;
    }

    public static String retrieveArtist(String title) throws IOException {
        String input = infoReading(title);
        input = input.substring((input.indexOf("names\":\"") + 8), input.indexOf("\",\"full"));
        if (input.contains(" (Ft. ")) {
            input = input.substring(0, input.indexOf(" (Ft. "));
        }
        return input;
    }

    public static String retrieveTitle(String title) throws IOException {
        String input = infoReading(title);
        input = input.substring((input.indexOf("\"title\":\"") + 9), input.indexOf("\",\"title_with"));
        return input;
    }
//unused????

    /*  public static String retrieveApiPath(String title) throws IOException {
        String input = infoReading(title);
        input = input.substring((input.indexOf("path\":\"/songs/") + 14), input.indexOf("\",\"artist_names"));
        return input;
    }
     */
    public static Date retrieveDate(String title) throws IOException {
        String input = infoReading(title);
        input = input.substring((input.indexOf(("\"release_date_for_display\":\"") + 27, input.indexOf("\",\"song_art_image_thumbnail_url"))));
        return new Date(input);
    }

    @Override
    public String toString() {
        return (this.artist + " - " + this.title);
    }

    static Comparator<Song> DateComparator = (Song o1, Song o2) -> o1.getDate().compareTo(o2.getDate());

    static Comparator<Song> TitleComparator = (Song o1, Song o2) -> o1.getTitle().compareTo(o2.getTitle());

    static Comparator<Song> ArtistComparator = (Song o1, Song o2) -> o1.getArtist().compareTo(o2.getArtist());
}
