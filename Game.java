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
        System.out.println("At any time, press e to exit the game.");
        gameLoop : for (Level i:Level.levelsList){
            
            System.out.println("Level " + level);
            System.out.println(i.getChorus());
            System.out.println("Enter your guess: ");
            try{
                guess = sc.nextLine();
            
            if (guess.equalsIgnoreCase(i.getArtist())){
                score ++;
                System.out.println("Correct! +1 point");
                level++;
            }
            else if(guess.equals("e")){
                System.out.println("Exiting the game...");
                break gameLoop;
            }
            else{
                System.out.println("Wrong... The answer was " + i.getArtist());
                level++;
            }
            }catch(Exception e){
                System.err.println("Invalid guess, try again: ");
                continue;
            }
        }
        System.out.println("Final score: " + score + "/10");
    }
    public static void gameTitle (){
            Scanner sc = new Scanner(System.in);
        //option : artist or title
        String guess;
        int score  = 0;
        int level = 1;
        System.out.println("At any time, press 0 to exit the game.");
        try{
            gameLoop : for (Level i:Level.levelsList){
            
            System.out.println("Level " + level);
            System.out.println(i.getChorus());
            System.out.println("Enter your guess: ");
            guess = sc.nextLine();
            if (guess.equalsIgnoreCase(i.getTitle())){
                score ++;
                System.out.println("Correct! +1 point");
                level++;
            }
            else if(guess.equals("e")){
                System.out.println("Exiting the game...");
                break gameLoop;
            }
            else{
                System.out.println("Wrong... The answer was " + i.getTitle());
                level++;
            }
        }
        }catch(Exception e){}
        System.out.println("Final score: " + score + "/10");
    }
}