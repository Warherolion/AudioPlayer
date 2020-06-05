import java.util.Arrays;

public class AudioPlayer {
    /*
    Process:

    Class is called -> User provides a file group of songs which is required to initialize the rest of the class -> user then can invoke other methods with the array

   */
    public static songs[] AudioListing;
    public AudioPlayer(songs[] Audioinit) {
        AudioListing = Audioinit;
    }
    /*  TODO
    *   Make a quarry search
    *   make a class of songs with info for each song
    *   nested classes
    *   Create an object of all the songs
    *
    *   String[] songs = {songs songs = new songs(), }
    * */

    public static void ListInit(songs[] audioObj){
        //Populates this classes array with the objects from Main class
        for (int x = 0; x < audioObj.length; x++){
            System.out.println(audioObj[x].sName);
            System.out.println(audioObj[x].fPath);
            System.out.println(audioObj[x].aName);
            System.out.println(audioObj[x].sLength);
        }


    }
    public static void ListSongs(String objectChoice) {
        //Switch statement that will display information accordingly based off of user input

        switch (objectChoice){
            case "sName":
                for (int songsList = 0; songsList < AudioListing.length; songsList++){
                    System.out.println((songsList+1) +". " + AudioListing[songsList].sName);
                }
                break;
            case "fPath":
                for (int songsList = 0; songsList < AudioListing.length; songsList++){
                    System.out.println((songsList+1) +". " + AudioListing[songsList].fPath);
                }
                break;
            case "aName":
                for (int songsList = 0; songsList < AudioListing.length; songsList++){
                    System.out.println((songsList+1) +". " + AudioListing[songsList].aName);
                }
                break;

            case "sLength":
                for (int songsList = 0; songsList < AudioListing.length; songsList++){
                    System.out.println((songsList+1) +". " + AudioListing[songsList].sLength);
                }
                break;

            case "dump":
                for (int songsList = 0; songsList < AudioListing.length; songsList++){
                    System.out.println((songsList+1) +". " + AudioListing[songsList].sName);
                    System.out.println("      " + AudioListing[songsList].fPath);
                    System.out.println("      " + AudioListing[songsList].aName);
                    System.out.println("      " + AudioListing[songsList].sLength);
                }
                break;
            default:
                System.out.println("Invalid Quarry");
        }
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
