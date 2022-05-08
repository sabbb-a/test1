/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication45;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author sabri
 */
public class Level {
    private String title;
    private String artist;
    private String chorus;

    //title & artist to lowercase when checking if equal
    
    public Level(String title, String artist, String chorus) {
        this.title = title;
        this.artist = artist;
        this.chorus = chorus;
    }

    //public static ArrayList<Level> levelsList = new ArrayList<>();
    
    
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return this.artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getChorus() {
        return this.chorus;
    }

    public void setChorus(String chorus) {
        this.chorus = chorus;
    }
    
    public static ArrayList<Level> levelsList = new ArrayList<>(
        Arrays.asList(new Level("As It Was", "Harry Styles" , "In this world, it's just us\n" +
            "You know it's not the same as it was\n" +
            "In this world, it's just us\n" +
            "You know it's not the same as it was"),
                new Level("First Class", "Jack Harlow" , "I been a (G), throw up the (L), s** in the (A.M.), uh-huh\n" +
            "(O-R-O-U-S, yeah)\n" +
            "And I can put you in (First class, up in the sky)\n" +
            "I can put you in (First class, up in the s—, up-up in the s—)"),
                new Level("WAIT FOR U", "Future" , "I can hear your tears when they drop over the phone\n" +
            "Get mad at yourself 'cause you can't leave me alone\n" +
            "Gossip, bein' messy, that ain't what we doing (World was ending)\n" +
            "Travel around the world (Would you cry or would you try to get me?)"),
                new Level("Heat Waves", "Glass Animals" , "Sometimes, all I think about is you\n" +
            "Late nights in the middle of June\n" +
            "Heat waves been fakin' me out\n" +
            "Can't make you happier now"),
                new Level("About Damn Time", "Lizzo" , "Turn up the music, turn down the lights\n" +
            "I got a feelin' I'm gon' be alright\n" +
            "Okay (Okay), alright\n" +
            "It's about damn time (Time)"),
                new Level("I'M ON ONE", "Future" , "I'm on one, I'm on one, yeah\n" +
            "Hold up, slow down, wait, catch up (Catch up)\n" +
            "I'm on one, yeah, yeah, yeah, yeah\n" +
            "I'm on one, I'm on one"),
                new Level("Cold Heart", "Elton John" , "And I think it's gonna be a long, long time\n" +
            "'Til touchdown brings me 'round again to find\n" +
            "I'm not the man they think I am at home\n" +
            "Oh no, no, no"),
                new Level("Bam Bam", "Camila Cabello" , "Así e' la vida, sí\n" +
            "Yeah, that's just life, baby\n" +
            "Yeah, love came around and it knocked me down\n" +
            "But I'm back on my feet"),
                new Level("STAY", "The Kid LAROI" , "I do the same thing I told you that I never would\n" +
            "I told you I'd change, even when I knew I never could\n" +
            "I know that I can't find nobody else as good as you\n" +
            "I need you to stay, need you to stay, hey (Oh)"), 
                new Level("Enemy", "Imagine Dragons" , "Oh, the misery\n" +
            "Everybody wants to be my enemy\n" +
            "Spare the sympathy\n" +
            "Everybody wants to be my enemy-y-y-y-y")
        ));
      
        
    }
    
    
