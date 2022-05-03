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
public class StevenMain {

    public static void main(String[] args) throws Exception {

        
        UserInputManager.mainMenu();

        /*
        //finding songs with lyrics
        String[] idk = Finder.matches("I'm about to drop out");
        for(String i: idk)
             if (!(i==null))
             System.out.println(i);
        
        System.out.println("------");
        */
        //finding lyrics with title
       // System.out.println(LyricsFinder.readableLyrics("purple rain"));
         
    }
}
