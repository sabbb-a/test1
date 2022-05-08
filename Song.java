package javaapplication45;

/**
 *
 * @author stella
 */
import java.net.*;
import java.io.*;
import java.text.DateFormat;
import java.util.*;

public class Song {

    private static final String INFOURL = "https://genius.com/api/search/song?q=";
    private String lyrics, artist, title;
    private Date date;
    private static final DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.CANADA);

    public static String formatDate(Date date) {
        return df.format(date);
    }

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

    //OLD SONG CONSTRUCTOR, NEW ONE OPTIMIZES #of times URL is opened (reducing processing time)
    /* public Song(String title) throws IOException {
        this.title = Song.retrieveTitle(title);
        try {
            this.lyrics = Finder.readableLyrics(this.title);
        } catch (IOException ex) {
            System.out.println("Lyrics for this song could not be found. Continuing.");
            System.out.println(ex);
        } finally {
            this.artist = retrieveArtist(title);
            this.date = retrieveDate(title);
        }
    }
     */
    //new constructor! LITERALLY SPEEDS UP PROCESS OF ADDING/REMOVING BY 3X
    public Song(String title) throws IOException {
        String fullText = infoReading(title);
        this.title = fullText.substring((fullText.indexOf("\"title\":\"") + 9), fullText.indexOf("\",\"title_with"));
        String tempArtist = fullText.substring((fullText.indexOf("names\":\"") + 8), fullText.indexOf("\",\"full"));
        if (tempArtist.contains(" (Ft. ")) {
            tempArtist = tempArtist.substring(0, tempArtist.indexOf(" (Ft. "));
        }
        this.artist = tempArtist;
        this.date = new Date(fullText = fullText.substring((fullText.indexOf(("\"release_date_for_display\":\"")) + 28), fullText.indexOf("\",\"song_art_image_thumbnail_url")));
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

    //BELOW FUNCTIONS RETIRED
    //they were suboptimal in terms of speed/time complexity
    //previously, these were used to look for information online
    //retired because the functions they were used for did not need
    //for a URL to be opened 3 times, only once.
    /*
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

    public static Date retrieveDate(String title) throws IOException {
        String input = infoReading(title);
        input = input.substring((input.indexOf(("\"release_date_for_display\":\"")) + 28), input.indexOf("\",\"song_art_image_thumbnail_url"));
        System.out.println(input);
        return new Date(input);
    }
     */
    @Override
    public String toString() {
        return (this.artist + " - " + this.title);
    }

    static Comparator<Song> DateComparator = (Song o1, Song o2) -> o1.getDate().compareTo(o2.getDate());

    static Comparator<Song> TitleComparator = (Song o1, Song o2) -> o1.getTitle().compareTo(o2.getTitle());

    static Comparator<Song> ArtistComparator = (Song o1, Song o2) -> o1.getArtist().compareTo(o2.getArtist());
}
