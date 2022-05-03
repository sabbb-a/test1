package javaapplication45;

import java.util.*;
import java.io.*;

public class Playlist {

    LinkedHashSet<Song> playlist = new LinkedHashSet<>();
    String title;

    public Playlist(String title) {
        this.title = title;
    }
    
    public void add(String songTitle){
        this.playlist.add(new Song(songTitle));
    }
    
    public void remove(String songTitle){
        
    }
    
    public void delete(String title){
        
    }

    public void loadPlaylist() throws IOException {
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
        BufferedWriter bout = new BufferedWriter(fout);
        
        String s = "\nsome random string";
        bout.write(this.playlist.toString());
        bout.close();

    }

    public static void main(String[] args) throws Exception {
        Playlist pl = new Playlist("test");
        pl.savePlaylist();
        pl.loadPlaylist();

    }

}
