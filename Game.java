/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication45;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author sabri
 */
public class Game {
    public static void gameArtist (){
        Scanner sc = new Scanner(System.in);
        //option : artist or title
        String guess;
        int score  = 0;
        int level = 1;
        try{
        for (Level i:Level.levelsList){
            
            System.out.println("Level " + level);
            System.out.println(i.getChorus());
            System.out.println("Enter your guess: ");
            guess = sc.nextLine();
            if (guess.equalsIgnoreCase(i.getArtist())){
                score ++;
                System.out.println("Correct! +1 point");
                level++;
            }
            else{
                System.out.println("Wrong... The answer was " + i.getArtist());
                level++;
            }
        }
        }catch(InputMismatchException e){}
        System.out.println("Final score: " + score + "/25");
    }
    public static void gameTitle (){
            Scanner sc = new Scanner(System.in);
        //option : artist or title
        String guess;
        int score  = 0;
        int level = 1;
        try{
        for (Level i:Level.levelsList){
            
            System.out.println("Level " + level);
            System.out.println(i.getChorus());
            System.out.println("Enter your guess: ");
            guess = sc.nextLine();
            if (guess.equalsIgnoreCase(i.getTitle())){
                score ++;
                System.out.println("Correct! +1 point");
                level++;
            }
            else{
                System.out.println("Wrong... The answer was " + i.getTitle());
                level++;
            }
        }
        }catch(InputMismatchException e){}
        System.out.println("Final score: " + score + "/25");
    }
}
