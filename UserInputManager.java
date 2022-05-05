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
    public static void mainMenu() throws Exception {
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
    private static void searchMenu() throws IOException {
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
                    while (true) {
                        System.out.println(">Searching for lyrics. Please enter your query:");
                        try {
                            String lyrics = Finder.readableLyrics(getInput());
                            System.out.println("-------Displaying Lyrics------\n\n" + lyrics);
                            break;
                        } catch (IOException e) {
                            System.err.println("Please try again.");
                            System.err.println(e);
                            continue;
                        }
                        //method for searching lyrics, with parameter getInput() to retrieve title
                    }
                case "2":
                    while (true) {
                        System.out.println(">Searching for song info. Please input a snippet of the desired song's lyrics:");
                        try {
                            String[] matches = Finder.matches(getInput());
                            System.out.println("-------Displaying songs found------\n\n");
                            for (String i : matches) {
                                if (!(i == null)) {
                                    System.out.println(i);
                                }
                            }
                            break;
                        } catch (IOException e) {
                            System.err.println("Please try again.");
                            System.err.println(e);
                            continue;
                        }

                    }

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
    private static void playlistMenu() throws Exception {
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

    private static void playlistCreationMenu() throws Exception {
        System.out.println(">Creating a new playlist. Please enter a playlist title. Enter 0 to cancel.");
        String title = getInput();
        if (!title.equals("0")) {
            Playlist pl = new Playlist(title);
            //constructor for Playlist, using title variable as parameter.
            System.out.println("Playlist \"" + title + "\" created.");
        } else {
            System.out.println("Cancelling.");
        }
    }

    private static void playlistAccessMenu() throws Exception {
        System.out.println(">Please enter the desired playlist's title. Enter 0 to cancel.");
        String title = getInput();
        if (!title.equals("0")) {
            Playlist currentPlaylist = new Playlist(title);
            do {
                System.out.println("Playlist \"" + title + "\" selected.");

                System.out.println("Please select an action.\n"
                        + "[1] View songs in playlist\n"
                        + "[2] Add a song to the playlist\n"
                        + "[3] Remove a song from the playlist\n"
                        + "[4] Filter playlist\n"
                        + "[5] Delete playlist\n"
                        + "[0] Cancel\n"
                        + "Choice: ");
                userInput = getInput();
                switch (userInput) {
                    case "1":
                        System.out.println("Displaying playlist.");
                        currentPlaylist.loadPlaylist();
                        break;
                    case "2":
                        System.out.println("Adding a song.\n");
                        while (true) {
                            System.out.println("What is the title of the song you wish to add?");
                            try {
                                currentPlaylist.add(Song.retrieveTitle(getInput()));
                                break;
                            } catch (IOException e) {
                                System.out.println("We could not find that song, please try again.");
                                continue;
                            }
                        }
                        currentPlaylist.savePlaylist();
                        break;

                    case "3":

                        break;

                    case "4":

                        break;

                    case "5":

                        break;
                    case "0":
                        System.out.println("Cancelling.");
                        break;
                    default:
                        System.out.println("Invalid input, please try again.");
                }

            } while (!userInput.equals("0"));

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
                    Game.gameTitle();
                    break;
                case "2":
                    Game.gameArtist();
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
