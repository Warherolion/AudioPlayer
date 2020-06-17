public class Song {
    //allows other classes to use this song
    String sName;
    String fPath;
    String aName;
    double sLength;
    //Class constructor used in an array for all other classes
    public Song(String songName,
                 String filePath,
                 String Artist,
                 double songLength) {
        sName = songName;
        fPath = filePath;
        aName = Artist;
        sLength = songLength;
    }
}
