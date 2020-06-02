import java.util.Scanner;
public class PlayMusic extends AudioPlayer{
    //global var used to see if music is playing
    public static boolean MusicEnded = false;




    public static void PlayMenu(int UserChoice){
        Scanner input = new Scanner(System.in);
        while (!MusicEnded) {
            System.out.println("Please pick one option");
            System.out.println("1. Play Song");
            System.out.println("2. Pause/Play");
            System.out.println("3. Skip");
            System.out.println("4. Shuffle");
            System.out.println("5. Loop");
            System.out.println("6. Add this song to playlist");
            System.out.println("7. List song info");
            System.out.println("8. Close Player");
            try {
                UserChoice = input.nextInt();
                PlayMenu(UserChoice);
                if (UserChoice == 4) break;
            } catch (Exception ex) {
                System.out.println("There was an unexpected error, please try again");
            }
        }
    }

    public static void singlePlay(){

    }
    public static void repeatedPlay(){

    }

    //The following methods are locked unless a song is playing
    public static void Play(){

    }
    public static void skip(){

    }
    public static void Pause(){

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
