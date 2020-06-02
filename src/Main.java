import java.io.File;
import java.util.Scanner;
import org.apache.commons.io.FilenameUtils;

//This page is for showing off the feature class it should'nt be used in production code
//production code needs to made in separate classes that dont have a main task
public class Main {
    public static void main(String[] args) {
        AudioPlayer AudioPlayer = new AudioPlayer();

        //String[] x = AudioPlayer.listInit(filedir);   <- used to provide a file array for the rest of the class
        File MusicDir = new File("/Users/ranvi/Desktop/Grade 12 School Work/CompSci/CompSci_MusicStreamingApp/src/Music");

        AudioPlayer.ListInit(MusicDir);


        //AudioPlayer.playLead();

    }
}
