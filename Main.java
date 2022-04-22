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
        
        System.out.println(LyricsFinder.readableLyrics("chantaje"));

    }
}
