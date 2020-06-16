import java.util.*;

public class Playlist{

   /*
        How the playlist process should work

        User creates array -> array gets fed to class creates a hashMap with playlist name and array of Song[]

        User adds to a playlist -> grabs array with key name -> converts array to list -> adds song -> converts back to array and
        added to hashMap

        The program uses HashMaps and because of this new methods have been made which preform inbuilt functions that HashMap has
        This is to reduce the amount of interim knowledge the user needs to know when using the playlist class, if the user just needs to know
        one classes methods instead of two its better for the user


    */

   public static HashMap <String, Song[]> Playlists = new HashMap<String, Song[]>();


    public static void createPlaylist(String playlistName, Song[] playlistSongs){
        /*
         * The method is used to create a playlist using HashMaps with a String key and array value related to each playlist
         * this allows users to store multiple playlists with no limit and easily access them as long as the name is listed
         * */

       if (!Playlists.containsKey(playlistName)) {
           Playlists.put(playlistName, playlistSongs);
       }else{
           System.out.println("Playlist already exists");
       }
   }

    public static Song[] getPlaylist(String playlistName){
        Song[] returnedPlaylist = null;


        if (Playlists.containsKey(playlistName)) {
            returnedPlaylist = Playlists.get(playlistName);
        }else{
            System.out.println("Playlist doesn't exist");

        }

        return returnedPlaylist;
    }

    public static void addPlaylistSong(String playlistName, Song newAddedSong){
        /*
         * The method is used to add a song this is done by taking the array in the hashMap and converting it to a linked list
         * then adding the provided song and then reconverting it back to an array though unfortunately the arrayTo function
         * only makes Object arrays so I needed to manually type cast each song in the object array back to a Song array
         * */
       if (Playlists.containsKey(playlistName)){
           Song[] currentPlaylist = Playlists.get(playlistName);


           List<Song> listedPlaylist = new LinkedList<Song> (Arrays.asList(currentPlaylist));

           listedPlaylist.add(newAddedSong);

           Object[] objectivePlaylist = listedPlaylist.toArray();

           Song[]  convertedPlaylists = new Song[objectivePlaylist.length];

            for (int x = 0; x < objectivePlaylist.length; x++){
                convertedPlaylists[x] = (Song) objectivePlaylist[x];
            }

            Playlists.put(playlistName,convertedPlaylists);


       }else {
           System.out.println("Invalid Playlist Name");
       }

    }
    public static void renamePlaylist(String playlistOldName, String playlistNewName) {

        if (Playlists.containsKey(playlistOldName)){
            Song[] returnedValue = Playlists.remove(playlistOldName);
            Playlists.put(playlistNewName, returnedValue);
        }else{
            System.out.println("Playlist does not exist");
        }
    }
    public static void deletePlaylist(String playlistName){
        if (Playlists.containsKey(playlistName)){
            Song[] returnedValue = Playlists.remove(playlistName);
        }else{
            System.out.println("Playlist does not exist");
        }
    }
    public static void deletePlaylistSong(String playlistName, Song removedSong){
        /*
         * The method is used to remove a playlist Song this is done the same way as the above method but instead uses .remove
         * instead of .add
         * */
        if (Playlists.containsKey(playlistName)){
            Song[] currentPlaylist = Playlists.get(playlistName);


            List<Song> listedPlaylist = new LinkedList<>(Arrays.asList(currentPlaylist));

            listedPlaylist.remove(removedSong);

            Object[] objectivePlaylist = listedPlaylist.toArray();

            Song[]  convertedPlaylists = new Song[objectivePlaylist.length];

            for (int x = 0; x < objectivePlaylist.length; x++){
                convertedPlaylists[x] = (Song) objectivePlaylist[x];
            }

            Playlists.put(playlistName,convertedPlaylists);

        }else {
            System.out.println("Invalid Playlist Name");
        }

    }
}
