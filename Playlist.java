package javaapplication45;

import java.util.*;
import java.io.*;
import java.text.DateFormat;

public class Playlist {

    static File folder = new File("Playlists/");
    static ArrayList<String> plTitles;
    //must remove .txt ^ from here OR add txt to checkers.

    private LinkedHashSet<Song> playlist = new LinkedHashSet<>();
    private String title;

    public Playlist(String title) throws Exception {
        this.title = title;
        plTitles.add(this.title);

    }

    public boolean add(Song song) {
        return (this.playlist.add(song));
    }

    public boolean remove(Song song) {
        return (this.playlist.add(song));
    }

    public void delete(String title) {
        //file deletion
        plTitles.remove(this.title);
    }

    public void displayPlaylist() throws IOException {

        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.CANADA);
        System.out.println(this.playlist);
    }

    public void loadPlaylist() throws IOException {
        String artist, title;
        Date date;
        String line = null;
        FileReader fin = new FileReader("Playlists/" + this.title + ".txt");
        BufferedReader bin = new BufferedReader(fin);
        while ((line = bin.readLine()) != null) {
            System.out.println(line);
        }

        bin.close();
    }

    public void savePlaylist() throws Exception {

        FileWriter fout = new FileWriter("Playlists/" + this.title + ".txt");
        String line = null;
        BufferedWriter bout = new BufferedWriter(fout);
        for (String s : infoToWrite(this.playlist)) {
            bout.write(s);
        }
        bout.close();

    }

    private LinkedList<String> infoToWrite(LinkedHashSet<Song> pl) {
        LinkedList<String> lines = new LinkedList<String>();
        for (Song s : pl) {
            lines.add("artist:{\"" + s.getArtist() + "\"}, title:{\"" + s.getTitle() + "\"}, date:{\"" + s.getDate() + "\"}");
        }
        return lines;
    }

    public LinkedHashSet<Song> getPlaylist() {
        return this.playlist;
    }

    public void setPlaylist(LinkedHashSet<Song> playlist) {
        this.playlist = playlist;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
