package javaapplication45;

import java.io.File;
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
                        } catch (Exception e) {
                            System.err.println("Please try again.");
                            continue;
                        }
                        //method for searching lyrics, with parameter getInput() to retrieve title
                    }
                    break;
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
                        } catch (Exception e) {
                            System.err.println("Please try again.");
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
                    + "[3] Display existing playlists\n"
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
                case "3":
                    System.out.println("Displaying names of all existing playlists.\n"
                            + Playlist.plTitles);
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
        String title;
        do {
            System.out.println(">Creating a new playlist. Please enter a playlist title. Enter 0 to cancel.");
            title = getInput();
            if (title.equals("0")) {
                System.out.println("Cancelling.");
            } else if (Playlist.plTitles.stream().anyMatch(title::equalsIgnoreCase)) {
                System.out.println("Playlist \"" + title + "\" already exists! Please try again.");
            } else {
                File plfile = new File("Playlists/" + title + ".txt");
                //constructor for Playlist, using title variable as parameter.
                plfile.createNewFile();
                System.out.println("Playlist \"" + title + "\" created.");

                break;
            }
        } while (!title.equals("0"));
    }

    private static void playlistAccessMenu() throws Exception {
        System.out.println(">Please enter the desired playlist's title. Enter 0 to cancel.");
        String title = getInput();
        if (title.equals("0")) {
            System.out.println("Cancelling.");
        } else {
            Playlist currentPlaylist = new Playlist(title);
            currentPlaylist.loadPlaylist();
            outerLoop:
            do {
                System.out.println("Playlist \"" + title + "\" selected.");

                System.out.println("Please select an action.\n"
                        + "[1] View songs in playlist\n"
                        + "[2] Add a song to the playlist\n"
                        + "[3] Remove a song from the playlist\n"
                        + "[4] Sort playlist\n"
                        + "[5] Delete playlist\n"
                        + "[0] Cancel\n"
                        + "Choice: ");
                userInput = getInput();
                switch (userInput) {
                    case "1":
                        System.out.println("Displaying playlist.");
                        currentPlaylist.displayPlaylist();
                        break;
                    case "2":
                        System.out.println("Adding a song.\n");
                        while (true) {
                            System.out.println("What is the title/query for the song you wish to add? Enter \"0\" to cancel.");
                            try {
                                String input = getInput();
                                if (input.equals("0")) {
                                    System.out.println("Cancelling.");
                                    break;
                                }
                                Song selectedSong = new Song(input);
                                if (currentPlaylist.add(selectedSong)) {
                                    System.out.println("Song \"" + selectedSong.toString() + "\" successfully added.");
                                    break;
                                }
                                System.out.println("Song already exists in this playlist. Please try again.");
                                continue;
                            } catch (IOException e) {
                                System.out.println("We could not find that song, please try again.");
                                continue;
                            }
                        }
                        currentPlaylist.savePlaylist();
                        break;

                    case "3":
                        //NOTE----------------------
                        //this could be made faster. Removing the song does not require to look up api,
                        //but if we want to give the possibility of removing a specific song, this helps with it.
                        System.out.println("Removing a song.\n");
                        while (true) {
                            System.out.println("What is the title/query for the song you wish to remove? Enter \"0\" to cancel.");
                            try {
                                String input = getInput();
                                if (input.equals("0")) {
                                    System.out.println("Cancelling.");
                                    break;
                                }
                                Song selectedSong = new Song(input);

                                if (currentPlaylist.remove(selectedSong)) {
                                    System.out.println("Song \"" + selectedSong.toString() + "\" successfully removed.");
                                    break;
                                }
                                System.out.println("Song does not exist in this playlist (perhaps try to be more specific?). Please try again.");
                                continue;
                            } catch (IOException e) {
                                System.out.println("We could not find that song, please try again.");
                                continue;
                            }
                        }
                        currentPlaylist.savePlaylist();
                        break;

                    case "4":
                        playlistSortMenu(currentPlaylist);
                        break;

                    case "5":
                        System.out.println("Are you sure you wish to delete this playlist: " + currentPlaylist.getTitle() + "\n"
                                + "[Y] Yes\n"
                                + "[N] No");
                        String input = getInput();
                        if (input.equalsIgnoreCase("y")) {
                            File plfile = new File("Playlists/" + currentPlaylist.getTitle() + ".txt");
                            plfile.delete();
                            System.out.println("Playlist \"" + currentPlaylist.getTitle() + "\" deleted.");
                            break outerLoop;
                        } else if (input.equalsIgnoreCase("n")) {
                            System.out.println("Cancelling.");
                        } else {
                            System.out.println("Invalid input.");
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
    }

    private static void playlistSortMenu(Playlist cpl) throws Exception {
        String input;
        do {
            System.out.println(">Sorting selected playlist. How would you like to sort the playlist?\n"
                    + "[1] Sort by title\n"
                    + "[2] Sort by artist\n"
                    + "[3] Sort by release date\n"
                    + "[0] Cancel");

            input = getInput();
            switch (input) {
                case "1":
                    System.out.println("Sorted by title.");
                    cpl.sort(Song.TitleComparator);
                    cpl.savePlaylist();
                    break;
                case "2":
                    System.out.println("Sorted by artist.");
                    cpl.sort(Song.ArtistComparator);
                    cpl.savePlaylist();
                    break;
                case "3":
                    System.out.println("Sorted by release date.");
                    cpl.sort(Song.DateComparator);
                    cpl.savePlaylist();
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Invalid input, please try again.");
                    break;
            }
        } while (!input.equals("0"));

        cpl.savePlaylist();
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
