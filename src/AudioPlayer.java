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
    *
    *
    *
    * */
    public static void ListSongs(String objectChoice) {
        //Switch statement that will display information accordingly based off of user input
        switch (objectChoice){
            //AudioPlayer.ListSongs("objectChoice"); <- based of user command the relevant information will be displayed
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
                //"Dump" shows all the information for every song that is in the array
                for (int songsList = 0; songsList < AudioListing.length; songsList++){
                    System.out.println((songsList+1) +". " + AudioListing[songsList].sName);
                    System.out.println("      " + AudioListing[songsList].fPath);
                    System.out.println("      " + AudioListing[songsList].aName);
                    System.out.println("      " + AudioListing[songsList].sLength);
                }
                break;
            default:
                //The method requires a String so runtime errors wont happen but in case a
                System.out.println("Invalid Quarry");
        }
    }
    public static void playLead() {
        //This method is used to autoplay playlists with arguments like looped, shuffled etc
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
    public static String[] search(String SearchCategory , String Quarry){
        switch (SearchCategory) {
            case aName:
                for (int songSearch = 0; songSearch < AudioListing.length; songSearch++){
                    if (AudioListing[songSearch].aName.equals(Quarry)){

                    }
                }
        }

        return new String[5];
    }
}
