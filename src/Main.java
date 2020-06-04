import java.io.File;
import org.apache.commons.io.FilenameUtils;

//This page is for showing off the feature class it should'nt be used in production code
//production code needs to made in separate classes that dont have a main task
public class Main {
    public static void main(String[] args) {
        AudioPlayer AudioPlayer = new AudioPlayer();



        songs[] songInfo= new songs[10];

        songInfo[0] = new songs("Danger Zone", "danger zone.mp3", "Kenny Loggins",  3.33);
        songInfo[1] = new songs("Do I Wanna Know", "Do I Wanna Know.mp3", "Arctic Monkeys",  4.25);
        songInfo[2] = new songs("Heartless", "Heartless.wav", "The Weeknd",  4.02);
        songInfo[3] = new songs("Life Is Good", "Life Is Good.wav", "Drake",  5.35);
        songInfo[4] = new songs("lone Digger", "lone Digger.mp3", "Caravan place",  3.50);
        songInfo[5] = new songs("Panini", "Panini.wav", "Lil Nas X",  2.24);




        //String[] x = AudioPlayer.listInit(filedir);   <- used to provide a file array for the rest of the class
        File MusicDir = new File("/Users/ranvi/Desktop/Grade 12 School Work/CompSci/CompSci_MusicStreamingApp/src/Music");

        AudioPlayer.ListInit(MusicDir);

        //AudioPlayer.playLead();

    }
}
