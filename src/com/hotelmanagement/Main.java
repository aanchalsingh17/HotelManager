package com.hotelmanagement;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    Main(){
        //setBounds method do the work of setSize and setLocation together
        //first two arguments x and y fo setting the location of the frame from the x and y axis and last
        // two arguments decides the width and height of the frame
        setBounds(10,10,1024,683);
       // setSize(1000,500);

       // setLocation(100,100);
        //ImageView which we want to add upon the frame is retrieved from its location
        ImageIcon imageIcon = new ImageIcon("src/com/hotelmanagement/icons/hotel.jpg");
        JLabel jLabel = new JLabel(imageIcon);
        //setting the boundaries  of the imageview
        jLabel.setBounds(0,0,1024,683);
        //adding the image view upon the frame
        add(jLabel);
        //Creating a TextView for to be Displayed over the ImageView
        JLabel jLabel1 = new JLabel("Hotel Management");
        jLabel1.setBounds(20,500,1500,100);
        //specifying the color in which our textView is going to display
        jLabel1.setForeground(Color.BLACK);
        //font style of the text view
        jLabel1.setFont(new Font("sarif",Font.BOLD,50));
        //adding the jlabel1 over the jlabel
        jLabel.add(jLabel1);
        setLayout(null);
        setVisible(true);
        //Adding a button in order to go to next frame
        JButton jButton = new JButton("Menu");
        jButton.setBackground(Color.BLACK);
        jButton.setForeground(Color.WHITE);
        jButton.setBounds(1500,300,150,30);
        //Adding a button over the ImageView
        jLabel.add(jButton);

        //Below code will led to textview to blink with the interval of 500ms which is handle by the code thread.sleep
        while(true){
            jLabel1.setVisible(false);
            try{
                Thread.sleep(500);
            }catch (Exception e){

            }
            jLabel1.setVisible(true);
            try{
               Thread.sleep(500);
            }catch (Exception e){}
        }




    }
    public static void main(String[] args) {

        //Calling the Constructor of the MainPage Frame
        new Main();
    }
}
