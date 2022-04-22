/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication45;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import static javaapplication45.SongInfo.infoURLBuilder;



/**
 *
 * @author sabri
 */
public class Main {
    public static void main(String[] args) throws Exception {

         String[] idk = SongFinder.matches("I'm about to drop out");
         for(String i: idk)
             if (!(i==null))
             System.out.println(i);
    }
}
