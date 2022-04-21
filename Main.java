/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication45;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import static javaapplication45.SongInfo.getTitle;

/**
 *
 * @author sabri
 */
public class Main {
    public static void main(String[] args) throws Exception {
        URL info = new URL(LyricsFinder.infoURLBuilder("ciel noir"));
        BufferedReader in = new BufferedReader(
        new InputStreamReader(info.openStream()));
        String inputLine = in.readLine();
        

        URL search = new URL(LyricsFinder.lyricsURLBuilder(SongInfo.getArtist(inputLine), LyricsFinder.TitleNoSpace(SongInfo.getTitle(inputLine))));
        BufferedReader in1 = new BufferedReader(
        new InputStreamReader(search.openStream()));
        String rawLyrics = in1.readLine();
        System.out.println(LyricsFinder.readableLyrics(rawLyrics));


    }
}
