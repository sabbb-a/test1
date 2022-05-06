package javaapplication45;

import java.util.*;

/**
 * @author stellarium
 */
public class Main {

    public static void main(String[] args) throws Exception {
        
        //loading playlists titles
        ArrayList<String> temporary = new ArrayList<String>(Arrays.asList(Playlist.folder.list()));
        for (int i = 0; i < temporary.size(); i++) {
            String str = temporary.get(i);
            temporary.set(i, str.substring(0, str.length()-4));
        }
        Playlist.plTitles = temporary;
        System.out.println(Playlist.plTitles);
        
        
        
        UserInputManager.mainMenu();

    }
}
