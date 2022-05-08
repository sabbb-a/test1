package javaapplication45;

import java.util.*;
import java.io.*;
import java.net.*;

public class Finder {

    private static final String LYRICSURL = "https://api.lyrics.ovh/v1/";
    private static final String SEARCHURL = "https://genius.com/api/search/lyric?q=";

    public static String removeSpaces(String userInput) {
        if (userInput.contains(" ")) {
            userInput = userInput.replaceAll(" ", "%20");
            userInput = userInput.toLowerCase();
            return userInput;
        } else {
            return userInput;
        }
    }

    public static String lyricsURLBuilder(String title) throws IOException {
        String fullText = Song.infoReading(title);
        String URLTitle = removeSpaces(fullText.substring((fullText.indexOf("\"title\":\"") + 9), fullText.indexOf("\",\"title_with")));
        String tempArtist = fullText.substring((fullText.indexOf("names\":\"") + 8), fullText.indexOf("\",\"full"));
        if (tempArtist.contains(" (Ft. ")) {
            tempArtist = tempArtist.substring(0, tempArtist.indexOf(" (Ft. "));
        }
        String URLArtist = removeSpaces(tempArtist);
        return (LYRICSURL + URLArtist + "/" + URLTitle);

//RETIRED PIECE OF CODE, OPTIMIZED TO 3X SPEED (idk the actual math) (opening URL less times) (like Song Constructor)        
//return (LYRICSURL + removeSpaces(Song.retrieveArtist(title)) + "/" + removeSpaces(Song.retrieveTitle(title)));
    }

    public static void main(String[] args) throws IOException {
        System.out.println(readableLyrics("hey jude"));
    }

    private static String songURLBuilder(String snippet) {
        return (SEARCHURL + removeSpaces(snippet));
    }

    private static String lyricReading(String title) throws IOException {
        URL info = null;
        try {
            info = new URL(lyricsURLBuilder(title));
        } catch (MalformedURLException ex) {
        }
        BufferedReader in = new BufferedReader(
                new InputStreamReader(info.openStream()));
        return in.readLine();
    }

    private static String songReading(String snippet) throws IOException {
        URL search = null;
        try {
            search = new URL(songURLBuilder(snippet));
        } catch (MalformedURLException ex) {
        }
        Scanner scanner = new Scanner(search.openStream());
        return scanner.nextLine();
    }

    public static String[] matches(String snippet) throws IOException {
        String matches = songReading(snippet);
        String[] songMatches = new String[11];
        songMatches = matches.split(",\"full_title\":\"", 12);
        songMatches[0] = null;
        for (int i = 0; i < songMatches.length; i++) {
            if (!(songMatches[i] == null)) {
                songMatches[i] = songMatches[i].substring(0, songMatches[i].indexOf("\",\"header"));
            }
        }
        return songMatches;
    }

    public static String readableLyrics(String title) throws IOException {
        String rawLyrics = lyricReading(title);
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
