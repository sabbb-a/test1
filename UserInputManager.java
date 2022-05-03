package javaapplication45;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author stella
 */
public class UserInputManager {

    static String userInput;

    private static String getInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

//====================
//MAIN MENU
//====================    
    public static void mainMenu() {
        do {
            System.out.print("<========== Menu ==========>\n"
                    + "Please enter your choice.\n"
                    + "[1] Search for lyrics/song information\n"
                    + "[2] Manage a playlist\n"
                    + "[3] Play a guessing game\n"
                    + "[e] Exit program\n"
                    + "Choice: ");
            userInput = getInput();
            switch (userInput) {
                case "1":
                    searchMenu();
                    break;
                case "2":
                    playlistMenu();
                    break;
                case "3":
                    gameMenu();
                    break;
                case "e":
                    System.out.println("Exiting.");
                    break;
                default:
                    System.out.println("Invalid input, please try again.");
            }
        } while (!userInput.equalsIgnoreCase("e"));

    }

//====================
//SEARCHING MENU
//====================
    private static void searchMenu() {
        do {
            System.out.print("\n<========== Search Menu ==========>\n"
                    + "Please enter your choice.\n"
                    + "[1] Search for a song's lyrics\n"
                    + "[2] Search for song info from lyrics\n"
                    + "[0] Cancel\n"
                    + "Choice: ");
            userInput = getInput();
            switch (userInput) {
                case "1":
                    while(true){
                    System.out.println(">Searching for lyrics. Please enter your query:");
                    try{
                        String lyrics = Finder.readableLyrics(getInput());
                        System.out.println("-------Printing Lyrics------\n\n"+lyrics);
                        break;
                    }catch(IOException e){
                        System.err.println("Please try again.");
                        System.err.println(e);
                        continue;
                    }
                    //method for searching lyrics, with parameter getInput() to retrieve title
                    }
                case "2":
                    System.out.println(">Searching for song info. Please input a snippet of the desired song's lyrics:");
                    //method for searching song info, with parameter getInput() to retrieve lyrics
                    break;
                case "0":
                    System.out.println("Cancelling.");
                    break;
                default:
                    System.out.println("Invalid input, please try again.");
            }
        } while (!userInput.equals("0"));
    }

//====================
//PLAYLIST MENU
//====================
    private static void playlistMenu() {
        do {
            System.out.print("\n<========== Playlist Menu ==========>\n"
                    + "Please enter your choice.\n"
                    + "[1] Create a new playlist\n"
                    + "[2] Access an existing playlist\n"
                    + "[0] Cancel\n"
                    + "Choice: ");
            userInput = getInput();
            switch (userInput) {
                case "1":
                    playlistCreationMenu();
                    break;
                case "2":
                    playlistAccessMenu();
                    break;
                case "0":
                    System.out.println("Cancelling.");
                    break;
                default:
                    System.out.println("Invalid input, please try again.");
            }
        } while (!userInput.equals("0"));
    }

    private static void playlistCreationMenu() {
        System.out.println(">Creating a new playlist. Please enter a playlist title. Enter 0 to cancel.");
        String title = getInput();
        if (!title.equals("0")) {
            //constructor for Playlist, using title variable as parameter.
            System.out.println("Playlist \"" + title + "\" created.");
        } else {
            System.out.println("Cancelling.");
        }

    }

    private static void playlistAccessMenu() {
        System.out.println(">Please enter the desired playlist's title. Enter 0 to cancel.");
        String title = getInput();
        if (!title.equals("0")) {
            //Playlist currentPlaylist = 
            System.out.println("Playlist \"" + title + "\" selected.");
        } else {
            System.out.println("Cancelling.");
        }
    }

//====================
//GAME MENU
//====================   
    private static void gameMenu() {
        do {
            System.out.print("\n<========== Game Menu ==========>\n"
                    + "Please enter your choice.\n"
                    + "[1] Guess the song\n"
                    + "[2] Guess the artist\n"
                    + "[0] Cancel\n"
                    + "Choice: ");
            userInput = getInput();
            switch (userInput) {
                case "1":
                    break;
                case "2":
                    break;
                case "0":
                    System.out.println("Cancelling.");
                    break;
                default:
                    System.out.println("Invalid input, please try again.");
            }
        } while (!userInput.equals("0"));

    }

}
