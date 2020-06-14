package src;

import java.io.File;
import java.util.Scanner;

public class ProgramMap {

    public static String userDir = System.getProperty("user.dir");
    public static String imgDir = userDir+"/src/Images" ;

    public static File musicDir = new File(userDir +"/src/Music");

    public static  String[] pathnames = musicDir.list();
    public static Scanner input = new Scanner(System.in);

}
