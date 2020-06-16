package com.hotelmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.Map;

public class Main extends JFrame implements ActionListener {
    Main(){
        //  Helps to create database if it doesn't exist
        DatabaseConnection databaseConnection = new DatabaseConnection();
        setSize(1024,683);
        setResizable(false);
        setLocationRelativeTo( null );      // To set window location centred
        setTitle("Hotel Manager");

        ImageIcon imageIcon = new ImageIcon("src/com/hotelmanagement/icons/hotel.jpg");
        JLabel background = new JLabel(imageIcon);
        background.setBounds(0,0,1024,683);
        add(background);

        //Creating a TextView for to be Displayed over the ImageView
        JLabel appName = new JLabel("Hotel Manager");
        appName.setBounds(30,20,1500,60);
        appName.setForeground(Color.BLACK);
        appName.setFont(new Font("SansSerif",Font.BOLD ,50));

        //  Add underline
        Font font = appName.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_LOW_TWO_PIXEL);
        appName.setFont(font.deriveFont(attributes));

        //adding the jlabel1 over the jlabel
        background.add(appName);

        JLabel click = new JLabel("Click Here -->");
        click.setBounds(640,590,170,20);
        click.setForeground(Color.orange);
        click.setFont(new Font("TimesRoman",Font.ITALIC | Font.BOLD,20));
        //adding the jlabel1 over the jlabel
        background.add(click);

        setLayout(null);
        setVisible(true);

        //Adding a button in order to go to login frame
        RoundButton nextBtn = new RoundButton("MENU");
        nextBtn.setFont(new Font("SansSerif",Font.BOLD,18));
        nextBtn.setBackground(Color.black);
        nextBtn.setForeground(Color.orange);
        nextBtn.setFocusPainted(false);
        nextBtn.setBounds(800,580,100,40);

        //Adding button over the ImageView
        nextBtn.addActionListener(this);
        background.add(nextBtn);


        //Below code will lead to textview to blink with the interval of 500ms which is handled by the code thread.sleep
        while(true){
            click.setVisible(false);
            try{
                Thread.sleep(600);
            }catch (Exception e){

            }
            click.setVisible(true);
            try{
               Thread.sleep(600);
            }catch (Exception e){}
        }
    }
    //  Implemented method for Action Listener
    public void actionPerformed(ActionEvent actionEvent){
        new Login().setVisible(true);
        this.setVisible(false);
    }


    public static void main(String[] args) {
        //Calling the Constructor of the MainPage Frame
        new Main();
    }
}
