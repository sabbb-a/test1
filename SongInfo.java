/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication45;

/**
 *
 * @author sabri
 */
import java.net.*;
import java.io.*;
import java.util.stream.Stream;

public class SongInfo {

    /**
     * @param args the command line arguments
     */
    
    public static String getArtist(String input){
        input = input.substring((input.indexOf("names\":\"")+8), input.indexOf("\",\"full"));
        return input;
    }
    public static String getTitle(String input){
        input = input.substring((input.indexOf("\"title\":\"")+9), input.indexOf("\",\"title_with"));
        return input;
    }
    public static String getApiPath(String input){
        input = input.substring((input.indexOf("path\":\"/songs/")+14), input.indexOf("\",\"artist_names"));
        return input;
    }
}
   

