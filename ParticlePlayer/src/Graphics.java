package src;

import javax.swing.*;
import java.awt.event.*;

public class Graphics {

    public static JFrame MainFrame = new JFrame();

    public static JButton PlayButton =new JButton("Play");

    public static final JTextField tf=new JTextField();

    public static void MainScreen(){
        SizingConstraints();
        MainFrame.add(PlayButton);

        for (int ListNum = 0; ListNum < ProgramMap.pathnames.length; ListNum++) {
            
            System.out.println(ListNum + 1 + ". " + ProgramMap.pathnames[ListNum]);

        }

        PlayButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                tf.setText("Song Playing.");
            }
        });
        MainFrame.add(tf);




        MainFrame.setLayout(null);
        MainFrame.setVisible(true);
    }
    public static void SizingConstraints(){
        PlayButton.setBounds(150,400,100, 40);
        MainFrame.setSize(400,500);
        tf.setBounds(50,50, 150,20);
    }
}
