public class Song {
    String sName;
    String fPath;
    String aName;
    double sLength;

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
