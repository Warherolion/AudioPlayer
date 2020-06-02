import org.apache.commons.io.FilenameUtils;

import java.io.File;

public class AudioPlayer {
    /*
    Process:

    Class is called -> User provides a file group of songs which is required to initialize the rest of the class -> user then can invoke other methods with the array

   */

    //Backend array
    public static String[] pathnames;
    //FrontEnd array
    public static String[] AudioLibrary;

    public void ListInit(File AudioDir){
        // User must invoke this inorder to initialize the rest of the class
        pathnames = AudioDir.list();
        AudioLibrary = AudioDir.list();
        //creates front end array
        for (int ALP  = 0; ALP < AudioLibrary.length; ALP++){
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
    public static void SinglePLayClip() {

    }
    public static void ListPop() {

    }
    public static void Play() {

    }
    public static void PlayList() {

    }
}
