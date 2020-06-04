import org.apache.commons.io.FilenameUtils;

import java.io.File;

public class AudioPlayer {
    /*
    Process:

    Class is called -> User provides a file group of songs which is required to initialize the rest of the class -> user then can invoke other methods with the array

   */

    /*  TODO
    *   https://dzone.com/articles/how-retrieveextract-metadata <- use this to extract meta data of file
    *   Make a quarry search
    *   make a class of songs with info for each song
    *   nested classes
    *   Create an object of all the songs
    *
    *   String[] songs = {songs songs = new songs(), }
    * */

    //Backend array
    public static String[] pathnames;
    //FrontEnd array
    public static String[] AudioLibrary;

    public void ListInit(File AudioDir){
        // User must invoke this inorder to initialize the rest of the class
        pathnames = AudioDir.list();
        //The two arrays are one for pathname and two for the user to see all the songs
        AudioLibrary = AudioDir.list();


        //creates the audioLibrary for the user without the file extensions at the end

        //Makes sure the array is not empty
        assert AudioLibrary != null : " File folder is empty ";

        //Removes the file extension for each index in the array
        for (int ALP = 0; ALP < AudioLibrary.length; ALP++){
            AudioLibrary[ALP] = FilenameUtils.removeExtension(AudioLibrary[ALP]);
        }
    }
    public static void ListSongs() {

    }
    public static void playLead() {

    }
    public static void playListLead() {

    }
    public static void AudioGrab() {

    }
    public static void SinglePLayClip(String Filename, boolean Looped) {

    }
    public static void ListPop() {

    }
    public static void Play() {

    }
    public static void PlayList() {

    }
}
