import java.io.File;
import org.apache.commons.io.FilenameUtils;

//This page is for showing off the feature class it should'nt be used in production code
//production code needs to made in separate classes that dont have a main task
public class Main {
    public static void main(String[] args) {


        songs[] songList= new songs[10];

        songList[0] = new songs("Danger Zone", "danger zone.mp3", "Kenny Loggins",  3.33);
        songList[1] = new songs("Do I Wanna Know", "Do I Wanna Know.mp3", "Arctic Monkeys",  4.25);
        songList[2] = new songs("Heartless", "Heartless.wav", "The Weeknd",  4.02);
        songList[3] = new songs("Life Is Good", "Life Is Good.wav", "Drake",  5.35);
        songList[4] = new songs("lone Digger", "lone Digger.mp3", "Caravan place",  3.50);
        songList[5] = new songs("Panini", "Panini.wav", "Lil Nas X",  2.24);
        songList[6] = new songs("ROXANNE", "ROXANNE.wav", "Arizona",  2.50);
        songList[7] = new songs("Seven Nation Army", "Seven Nation Army.mp3", "The White Stripes",  4.17);
        songList[8] = new songs("Thunderstruck", "Thunderstruck.wav", "AC/DC",  5.00);
        songList[9] = new songs("Yummy", "Yummy.mp3", "Justin Bieber",  3.28);

        AudioPlayer APlayer = new AudioPlayer(songList);

        AudioPlayer.ListSongs("dump");

    }
}
