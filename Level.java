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
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getChorus() {
        return chorus;
    }

    public void setChorus(String chorus) {
        this.chorus = chorus;
    }
    
    public static ArrayList<Level> levelsList = new ArrayList<>(
        Arrays.asList(new Level("As It Was", "Harry Styles" , "In this world, it's just us\n" +
            "You know it's not the same as it was\n" +
            "In this world, it's just us\n" +
            "You know it's not the same as it was\n" +
            "As it was, as it was\n" +
            "You know it's not the same"),
                new Level("First Class", "Jack Harlow" , "I been a (G), throw up the (L), sex in the (A.M.), uh-huh\n" +
            "(O-R-O-U-S, yeah)\n" +
            "And I can put you in (First class, up in the sky)\n" +
            "I can put you in (First class, up in the s—, up-up in the s—)\n" +
            "I been a (G), throw up the (L), sex in the (A.M.), uh-huh\n" +
            "(O-R-O-U-S, yeah)\n" +
            "And I can put you in (First class, up in the sky), mm, mm\n" +
            "I can put you in (First class, up in the s—, up-up in the s—)"),
                new Level("WAIT FOR U", "Future" , "I can hear your tears when they drop over the phone\n" +
            "Get mad at yourself 'cause you can't leave me alone\n" +
            "Gossip, bein' messy, that ain't what we doing (World was ending)\n" +
            "Travel around the world (Would you cry or would you try to get me?)\n" +
            "Over the phone, dropping tears (Tell me now, I want you to be clear, yeah)\n" +
            "I get more vulnerable when I do pills (Tell me now, I need you to be clear, yeah)\n" +
            "When you drunk, you tell me exactly how you feel (I will wait for you, for you)\n" +
            "When I'm loaded, I keep it real (I will wait for you, I will wait for you)\n" +
            "Please tell a real one exactly what it is (I will wait, will wait, for you, for you)\n" +
            "Don't say it 'cause you know that's what I wanna hear (I will wait for you, I will wait for you)"),
                new Level("Heat Waves", "Glass Animals" , "Sometimes, all I think about is you\n" +
            "Late nights in the middle of June\n" +
            "Heat waves been fakin' me out\n" +
            "Can't make you happier now\n" +
            "Sometimes, all I think about is you\n" +
            "Late nights in the middle of June\n" +
            "Heat waves been fakin' me out\n" +
            "Can't make you happier now"),
                new Level("About Damn Time", "Lizzo" , "Turn up the music, turn down the lights\n" +
            "I got a feelin' I'm gon' be alright\n" +
            "Okay (Okay), alright\n" +
            "It's about damn time (Time)\n" +
            "Turn up the music, let's celebrate (Alright)\n" +
            "I got a feelin' I'm gon' be okay\n" +
            "Okay (Okay), alright\n" +
            "It's about damn time"),
                new Level("I'M ON ONE", "Future" , "I'm on one, I'm on one, yeah\n" +
            "Hold up, slow down, wait, catch up (Catch up)\n" +
            "I'm on one, yeah, yeah, yeah, yeah\n" +
            "I'm on one, I'm on one\n" +
            "I got a different type of body built\n" +
            "(Ayy)"),
                new Level("Cold Heart", "Elton John" , "And I think it's gonna be a long, long time\n" +
            "'Til touchdown brings me 'round again to find\n" +
            "I'm not the man they think I am at home\n" +
            "Oh no, no, no\n" +
            "And this is what I should have said\n" +
            "Well, I thought it, but I kept it hid"),
                new Level("Bam Bam", "Camila Cabello" , "Así e' la vida, sí\n" +
            "Yeah, that's just life, baby\n" +
            "Yeah, love came around and it knocked me down\n" +
            "But I'm back on my feet\n" +
            "Así e' la vida, sí\n" +
            "Yeah, that's just life, baby\n" +
            "I was barely standin', but now I'm dancin'\n" +
            "He's all over me (Goza)"),
                new Level("STAY", "The Kid LAROI" , "I do the same thing I told you that I never would\n" +
            "I told you I'd change, even when I knew I never could\n" +
            "I know that I can't find nobody else as good as you\n" +
            "I need you to stay, need you to stay, hey (Oh)"), 
                new Level("Enemy", "Imagine Dragons" , "Oh, the misery\n" +
            "Everybody wants to be my enemy\n" +
            "Spare the sympathy\n" +
            "Everybody wants to be my enemy-y-y-y-y\n" +
            "(Look out for yourself)\n" +
            "My enemy-y-y-y-y (Look, look, look, look)\n" +
            "(Look out for yourself)\n" +
            "But I'm ready"),
                new Level("Thousand Miles", "The Kid LAROI" , "And I will never change\n" +
            "I couldn't even if I wanted to for you, oh, oh, oh\n" +
            "There's nothing left to say\n" +
            "If I was you, if I was you\n" +
            "Then I would stay a thousand miles away, ayy\n" +
            "(A thousand miles away, ayy, yeah)"),
                new Level("Ghost", "Justin Bieber" , "That if I can't be close to you, I'll settle for the ghost of you\n" +
            "I miss you more than life (More than life)\n" +
            "And if you can't be next to me, your memory is ecstasy\n" +
            "I miss you more than life, I miss you more than life"),
                new Level("The Motto", "Tiesto" , "That's the motto (Mhm)\n" +
            "Drop a few bills and pop a few champagne bottles (Mhm)\n" +
            "Throwin' that money like you just won the lotto (Mhm)\n" +
            "We been up all damn summer\n" +
            "Makin' that bread and butter\n" +
            "Tell me, did I just stutter?\n" +
            "That's the motto (Mhm)\n" +
            "Drop a few bills and pop a few champagne bottles (Mhm)\n" +
            "Throwin' that money like you just won the lotto (Mhm)\n" +
            "We been up all damn summer\n" +
            "Makin' that bread and butter\n" +
            "Tell me, did I just stutter?\n" +
            "That's the motto (I feel it)\n" +
            "That's the motto (I feel it)"),
                new Level("", "" , ""),
                new Level("", "" , ""),
                new Level("", "" , ""),
                new Level("", "" , ""),
                new Level("", "" , ""),
                new Level("", "" , ""),
                new Level("", "" , ""),
                new Level("", "" , ""),
                new Level("", "" , "")
        ));
      
        
    }
    
    

