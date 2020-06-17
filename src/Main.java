public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        //Array of Song objects that can be accessed and manipulated
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



        // Object that creates the audioPlayer class
        AudioPlayer APlayer = new AudioPlayer(songList, "C:\\Users\\ranvi\\Desktop\\Grade 12 School Work\\CompSci\\CompSci_MusicStreamingApp\\src\\Music");


        //Lists all the songs and all the info related to them
        AudioPlayer.ListSongs("dump");


        //Shows all songs in the main class that contain the search quarry
        Song[] search = AudioPlayer.search("aName", "Kenny Loggins");


        //creates an array of Song objects
        Song[] rapMusic = {songList[3], songList[5], songList[2], songList[6]};
        Song[] PopSongs = {songList[1], songList[9], songList[4], songList[0]};


        //Creates playlists with arrays and array names
        Playlist.createPlaylist("RapMusic", rapMusic);
        Playlist.createPlaylist("PopSongs", PopSongs);

        //Plays a single song out of the main array
        PlayMusic.singlePlay(songList[6],"C:\\Users\\ranvi\\Desktop\\Grade 12 School Work\\CompSci\\CompSci_MusicStreamingApp\\src\\Music", false);


        //Displays the ability to add and remove songs from declared playlists
        Playlist.addPlaylistSong("RapMusic",songList[4]);

        Playlist.deletePlaylistSong("RapMusic", rapMusic[1]);

        //Displays the programs capability to display specific info about each song in a playlist
        for(int i = 0; i < Playlist.getPlaylist("RapMusic").length; i++){
            System.out.println("Rap songs: " + Playlist.getPlaylist("RapMusic")[i].aName);
        }

        //Plays all the songs in a playlist called rapMusic
        Song[] array =  PlayMusic.playlistPlay("RapMusic", "C:\\Users\\ranvi\\Desktop\\Grade 12 School Work\\CompSci\\CompSci_MusicStreamingApp\\src\\Music", false, true);

    }
}
