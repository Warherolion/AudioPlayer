import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import javax.sound.sampled.*;

@SuppressWarnings({"unused", ""})

public class PlayMusic{
    public static boolean MusicPlaying = true;
    public static Clip audioCLip;

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

        try{
            DataLine.Info clipDataLine = null;

            AudioInputStream audioInput = AudioSystem.getAudioInputStream(new File(audioObject));

            //Inits the clips and stats playing
            audioCLip.open(audioInput);

            while (checkPlay()) {
                audioCLip.setFramePosition(0);
                audioCLip.start();
                audioCLip.drain();
                if (loopedControl){
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
        audioCLip.addLineListener(new LineListener() {
            public void update(LineEvent evt) {
                //Sets music listener to false allowing new songs to play
                MusicPlaying = evt.getType() != LineEvent.Type.STOP;
            }
        });
        return MusicPlaying;
    }
    public static void playlistPlay(String playlistName, boolean loopControl, boolean shuffleControl){

    }

    //The following methods are locked unless a song is playing

    public static void playPause(boolean play){
        long musicTime;
        if (!play && MusicPlaying){
            //Pauses the active song
            musicTime = audioCLip.getMicrosecondPosition();
            audioCLip.stop();
        }else if (play && !MusicPlaying){
            audioCLip.start();
        }
    }
    public static void skip(){

    }
    public static Song[] Shuffle(String playlistName){

        List<Song> shuffledMusicList = Arrays.asList(Playlist.getPlaylist(playlistName));

        Collections.shuffle(shuffledMusicList);

        Object[] objectivePlaylist = shuffledMusicList.toArray();

        Song[]  convertedPlaylists = new Song[objectivePlaylist.length];

        for (int x = 0; x < objectivePlaylist.length; x++){
            convertedPlaylists[x] = (Song) objectivePlaylist[x];
        }
        return convertedPlaylists;
    }
    public static void Loop(String playlistName){

    }
}
