package src;

import javax.sound.sampled.*;
import java.io.IOException;
import java.io.File;
import javax.swing.*;

import java.util.Scanner;
/* TODO: 2020-03-21
 *   Make the program find all the different file extensions
 *   Put all the file paths into an array and play all the files
 *   Find a way to create a shuffle mode that can play songs randomly and will then remove them from the list once done
 */
/*TODO

 */
public class Main {
    public static boolean MusicEnded = false;
    public static boolean MusicPlaying = false;
    public static Clip clip;

    static{
        try {
            // Inits the Audio System
            clip = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
        }catch (Exception e){

        }
    }


    public static void main(String[] args) {
        //Graphics Screen = new Graphics();
        //Graphics.MainScreen();

        Scanner Input = new Scanner(System.in);

        while (!MusicEnded){
            System.out.println("Please pick one option");
            System.out.println("1. Play Song");
            System.out.println("2. Pause/Play");
            System.out.println("3. Skip");
            System.out.println("4. Close Player");
            try{
                int UserChoice = Input.nextInt();
                Menu(UserChoice);
                if (UserChoice == 4) break;
            }
            catch (Exception ex){
                System.out.println("There was an unexpected error, please try again");
            }
       }

    }
    public static void Menu(int choice){
        switch (choice){
            case 1:
                if (!MusicPlaying){
                    // Print the names of files and directories
                    for (int ListNum = 0; ListNum < ProgramMap.pathnames.length; ListNum++) {
                        System.out.println(ListNum + 1 + ". " + ProgramMap.pathnames[ListNum]);
                    }

                    System.out.println("Which Song would you like to play?");

                    int musicChoice = ProgramMap.input.nextInt();

                    String musicDir = ProgramMap.userDir + "\\src\\Music\\" + ProgramMap.pathnames[musicChoice - 1];

                    File MusicFileChosen = new File(musicDir);

                    MusicPlaying = PlaySound(MusicFileChosen, musicDir, musicChoice);
                }
                else {
                    System.out.println("Music is playing already");
                }
                break;
            case 2:
                PausePlay();
                break;
            case 3:
                Skip();
                break;
        }
    }

    public static void Skip(){

    }
    public static void PausePlay(){
        long musicTime;
        musicTime = clip.getMicrosecondPosition();
        if (clip.isActive()) {
            clip.stop();
        }else if (!MusicPlaying){
            clip.setMicrosecondPosition(musicTime);
            clip.start();
        }



    }

    public static void repeatedPlay(int playedSong){

        if (ProgramMap.pathnames.length > playedSong-1) {
            playedSong++;

            String musicDir = ProgramMap.userDir + "\\src\\Music\\" + ProgramMap.pathnames[playedSong];

            File MusicFileChosen = new File(musicDir);

            PlaySound(MusicFileChosen, musicDir, playedSong);

        }else{
            System.out.println("Music has ended");
        }

    }

    public static boolean PlaySound(File MusicFile, String MusicDir, int Choice) {
        long MusicTime;

        //Sets music listener to stop replay
        MusicPlaying = true;

            try {
                DataLine.Info dataLine = null;

                //Encodes song to play
                AudioInputStream AudioInput = AudioSystem.getAudioInputStream(MusicFile);

                //Function used to check when song ends
                clip.addLineListener(new LineListener() {
                    public void update(LineEvent evt) {
                        if (evt.getType() == LineEvent.Type.STOP) {
                            //Sets music listener to false allowing new songs to play
                            MusicPlaying = false;

                            repeatedPlay(Choice);

                        }
                    }
                });

                //Finds and accesses the clip
                clip.open(AudioInput);
                //Starts the clip
                clip.start();
                //Music Confirmation
                System.out.println("Now Playing " + MusicDir);
                //Makes sure program doesn't end while song plays
                clip.drain();


            } catch (Exception e) {
                System.out.println("Error playing music");
            }
            return  MusicPlaying;
        }

}
