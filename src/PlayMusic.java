import java.applet.AudioClip;
import java.io.File;
import java.util.Scanner;
import javax.sound.sampled.*;
import java.io.File;
@SuppressWarnings("unused")

public class PlayMusic{
    public static boolean MusicPlaying = false;
    public static Clip audioCLip;

    static {
        try {
            audioCLip = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
        }catch (Exception e) {
            System.out.println("Unable to create clip please restart program");
        }
    }


    public static void singlePlay(Song musicObject, String musicDir){
        boolean returnPlay = false;
        String audioObject = musicDir + musicObject.fPath;

        try{
            DataLine.Info clipDataLine = null;
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(new File(audioObject));

            //Inits the clips and stats playing
            audioCLip.open(audioInput);

            while (!checkPlay()) {
                audioCLip.setFramePosition(0);
                audioCLip.start();
                audioCLip.drain();
            }

        }
        catch (Exception e){
            System.out.println("Something went wrong please try again later");
            e.printStackTrace();
        }
    }


    public static boolean checkPlay(){
        /*
        * A line is the data stream of
        *
        * */
        audioCLip.addLineListener(new LineListener() {
            public void update(LineEvent evt) {
                if (evt.getType() == LineEvent.Type.STOP) {
                    //Sets music listener to false allowing new songs to play
                    MusicPlaying = true;
                }
            }
        });
        return MusicPlaying;
    }
    public static void repeatedPlay(){

    }

    //The following methods are locked unless a song is playing
    public static void skip(){

    }
    public static void playPause(){

    }
    public static void Shuffle(){

    }
    public static void Loop(){

    }
    public static void AddPlaylistSong(){

    }
    public static void ListInfo(){

    }
}
