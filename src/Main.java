import java.io.File;
import java.util.Arrays;

import org.apache.commons.io.FilenameUtils;

//This page is for showing off the feature class it should'nt be used in production code
//production code needs to made in separate classes that dont have a main task
public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {


        Song[] songList = new Song[10];
        songList[0] = new Song("Danger Zone", "\\danger zone.mp3", "Kenny Loggins", 3.33);
        songList[1] = new Song("Do I Wanna Know", "\\Do I Wanna Know.mp3", "Arctic Monkeys", 4.25);
        songList[2] = new Song("Heartless", "\\Heartless.wav", "The Weeknd", 4.02);
        songList[3] = new Song("Life Is Good", "\\Life Is Good.wav", "Drake", 5.35);
        songList[4] = new Song("lone Digger", "\\lone Digger.mp3", "Caravan place", 3.50);
        songList[5] = new Song("Panini", "\\Panini.wav", "Lil Nas X", 2.24);
        songList[6] = new Song("ROXANNE", "\\ROXANNE.wav", "Arizona", 2.50);
        songList[7] = new Song("Seven Nation Army", "\\Seven Nation Army.mp3", "The White Stripes", 4.17);
        songList[8] = new Song("Thunderstruck", "\\Thunderstruck.wav", "AC/DC", 5.00);
        songList[9] = new Song("Yummy", "\\Yummy.mp3", "Justin Bieber", 3.28);




        AudioPlayer APlayer = new AudioPlayer(songList, "C:\\Users\\ranvi\\Desktop\\Grade 12 School Work\\CompSci\\CompSci_MusicStreamingApp\\src\\Music");

        //AudioPlayer.ListSongs("dump");

        //Song[] search = AudioPlayer.search("aName", "Kenny Loggins");



        Song[] rapMusic = {songList[3], songList[5], songList[2], songList[6]};
        Song[] PopSongs = {songList[1], songList[9], songList[4], songList[0]};

        Playlist.createPlaylist("RapMusic", rapMusic);
        Playlist.createPlaylist("PopSongs", PopSongs);


        //PlayMusic.singlePlay(songList[6],"C:\\Users\\ranvi\\Desktop\\Grade 12 School Work\\CompSci\\CompSci_MusicStreamingApp\\src\\Music", false);


        /*
        Playlist.addPlaylistSong("RapMusic",songList[4]);

        Playlist.deletePlaylistSong("RapMusic", rapMusic[1]);

        for(int i = 0; i < Playlist.getPlaylist("RapMusic").length; i++){
            System.out.println("Rap songs: " + Playlist.getPlaylist("RapMusic")[i].aName);
        }
        */
        //AudioPlayer.playLead();
    }
}
