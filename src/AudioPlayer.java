import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
@SuppressWarnings("unused")
public class AudioPlayer {
    /*
    Process:

    Class is called -> User provides a file group of songs which is required to initialize the rest of the class -> user then can invoke other methods with the array

   */
    public static Song[] AudioListing;
    public AudioPlayer(Song[] Audioinit) {
        AudioListing = Audioinit;
    }
    /*  TODO
    *   Start working on the other methods
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
    public static Song[] search(String SearchCategory , String Quarry) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        /*
        * The purpose of the method is to allow user to search the "Song" array of objects inorder to find
        * related values of the given quarry. The use of a list allows for a non linear search method meaning
        * array memory initialization is not required. Though inorder to improve compatibility the list is converted
        * to an array as the return value.
        * Return:
        * The method searches the available object array for the search category ex. artist and places the entire method
        * in the list meaning the end user can print any aspect of the returned list and wouldn't need to call the object again
        */

        //Returned array value
        Song[] ReturnedResult = new Song[0];
        // Method only list
        List<Song> SearchResult = new ArrayList<>();


        for (Song song : AudioListing) {
            //Using the field class takes the search category from the method and find its in the song class
            Field getSearchCategory = Song.class.getDeclaredField(SearchCategory);
            //converts the SearchCategory to string from the song class
            String fieldValue = (String) getSearchCategory.get(song);
            if (fieldValue.equals(Quarry)) {
                SearchResult.add(song);
            }
        }

        // Conversion of list to array for ease of use
        ReturnedResult = SearchResult.toArray(ReturnedResult);

        return ReturnedResult;
    }
}
