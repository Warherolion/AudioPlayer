import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.sound.sampled.*;

@SuppressWarnings({"unused", ""})

public class PlayMusic{

    public static boolean MusicPlaying = true;
    public static Clip audioCLip;
    public static int playlistCheck;

    //Creates a clip with a line listener a clip is the object of the song that is provided, a line is the data stream of the file while being played
    static {
        try {
            audioCLip = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
        }catch (Exception e) {
            System.out.println("Unable to create clip please restart program");
        }
    }


    public static void singlePlay(Song musicObject, String musicDir, boolean loopedControl){
        boolean returnPlay = false;
        String audioObject = musicDir + musicObject.fPath;
        /*
        *   This method is the main one in the class as this uses the Audio class to play a clip and begin the monitoring of it
        *   with a line listener. This uses the audio input method which plugs the clip into a process hook that allows music to play through speakers.
        */
        try{
            //Nulls the data stream so overlap doesnt occur
            DataLine.Info clipDataLine = null;
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(new File(audioObject));
            //Inits the clips and stats playing
            audioCLip.open(audioInput);
            while (checkPlay()) {
                //Makes sure the whole song plays before the program exits or returns, this helps prevent overlapping of playback
                audioCLip.setFramePosition(0);
                //Start begins playing the song while drain is a redunency that prevents the program or method from exiting or returning respectively
                audioCLip.start();
                audioCLip.drain();
                if (loopedControl){
                    //Uses the inbuilt loop function ot loop the song till the pause function is used
                    audioCLip.loop(audioCLip.LOOP_CONTINUOUSLY);
                }
            }
        }
        catch (Exception e){
            System.out.println("Something went wrong please try again later");
            e.printStackTrace();
        }
    }


    public static boolean checkPlay(){
        /*
        * A line is the data stream of the music and the addition of a line listener allows for monitoring of
        * the status of songs this can be used to pause, play and check is music is playing so commands dont overlap
        */
        audioCLip.addLineListener(evt -> {
            //Sets music listener to false allowing new songs to play
            MusicPlaying = evt.getType() != LineEvent.Type.STOP;
        });
        return MusicPlaying;
    }
    public static Song[] playlistPlay(String playlistName, String musicDir, boolean loopControl, boolean shuffleControl){
       /*
       * The objective of this method is to allow the user to play playlist with specific commands attached to them
       *
       * */
        Song[] shuffle = Shuffle(playlistName);

            for(playlistCheck = 0; playlistCheck < Playlist.getPlaylist(playlistName).length; playlistCheck++){
                if (shuffleControl){
                    singlePlay(shuffle[playlistCheck], musicDir, false);
                }
                if (loopControl){
                    if (playlistCheck == (Playlist.getPlaylist(playlistName).length)-1){
                        playlistCheck = 0;
                    }
                }
            }

        return shuffle;
    }

    public static Song[] Shuffle(String playlistName){
        /*
         *   Shuffles a playlist by taking the playlist then using the list.shuffle method which comes with arrayLists,
         *    then converting it to a array and retuning that list for play or storage.
         */
        List<Song> shuffledMusicList = Arrays.asList(Playlist.getPlaylist(playlistName));

        Collections.shuffle(shuffledMusicList);
        //Converts the list to an object array and then to a song array and returns that.
        Object[] objectivePlaylist = shuffledMusicList.toArray();

        Song[]  convertedPlaylists = new Song[objectivePlaylist.length];

        for (int x = 0; x < objectivePlaylist.length; x++){
            convertedPlaylists[x] = (Song) objectivePlaylist[x];
        }
        return convertedPlaylists;
    }

    public static void playPause(boolean play){
        /*
        * This function when given a song to pause will take the microsecond position of the song and save that to a long
        * then pausing the music, to play it uses the position and sets the song to that position then starts the clip
        * this is because the .stop() function puts the song back at 0 microseconds.
        */

       if (checkPlay()){
           long musicTime = 0;
           if (!play && MusicPlaying){
               //Pauses the active song
               musicTime = audioCLip.getMicrosecondPosition();
               audioCLip.stop();
           }else if (play && !MusicPlaying){
               audioCLip.setMicrosecondPosition(musicTime);
               audioCLip.start();
           }
       }else {
           System.out.println("Nothing is playing");
       }


    }
    public static void skip(String playlistName){
        /*
         *   Skip takes the playlist name provided and updates the playlist check int which is used in the playlist,
         *   so the song is skipped.
         */
        if (checkPlay()){
            if (playlistCheck == (Playlist.getPlaylist(playlistName).length)-1){
                playlistCheck = 0;
            }else if (playlistCheck != (Playlist.getPlaylist(playlistName).length)-1){
                playlistCheck++;
            }
        }else {
            System.out.println("Nothing is playing");
        }


    }

}
