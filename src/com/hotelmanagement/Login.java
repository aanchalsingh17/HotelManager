package com.hotelmanagement;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {

    JLabel userLabel, passwordLabel;
    JTextField username;
    JPasswordField password;
    RoundButton loginBtn, cancelBtn;

    Login(){

        //  Username label
        ImageIcon ic = new ImageIcon("src/com/hotelmanagement/icons/user_icon.png");
        Image login = ic.getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
        ImageIcon user_icon = new ImageIcon(login);
        userLabel = new JLabel("Username :");
        userLabel.setBounds(10,28,120,40);
        userLabel.setIcon(user_icon);
        add(userLabel);

        //  Password label
        ImageIcon ic2 = new ImageIcon("src/com/hotelmanagement/icons/key_icon.png");
        Image key = ic2.getImage().getScaledInstance(24,27,Image.SCALE_SMOOTH);
        ImageIcon key_icon = new ImageIcon(key);
        passwordLabel = new JLabel("  Password :");
        passwordLabel.setBounds(10,78,120,40);
        passwordLabel.setIcon(key_icon);
        add(passwordLabel);

        //  Username textField
        username = new JTextField();
        username.setBackground(Color.lightGray);
        username.setBounds(150,30,150,30);
        username.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black,2),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        add(username);

        //  Password passwordField
        password = new JPasswordField();
        password.setBackground(Color.lightGray);
        password.setBounds(150,80,150,30);
        password.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black,2),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        add(password);

        //  Login button
        loginBtn = new RoundButton("LOGIN");
        loginBtn.setBounds(90,150,110,30);
        loginBtn.setBackground(Color.black);
        loginBtn.setForeground(Color.ORANGE);
        loginBtn.setFocusPainted(false);
        add(loginBtn);

        //  Cancel button
        cancelBtn = new RoundButton("CANCEL");
        cancelBtn.setBounds(230,150,110,30);
        cancelBtn.setBackground(Color.black);
        cancelBtn.setForeground(Color.ORANGE);
        cancelBtn.setFocusPainted(false);
        add(cancelBtn);

        //  Image icon at right corner
        ImageIcon icon = new ImageIcon("src/com/hotelmanagement/icons/login.png");
        Image icn_cmp = icon.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH);
        ImageIcon loginIcon = new ImageIcon(icn_cmp);
        JLabel loginLabel = new JLabel(loginIcon);
        loginLabel.setBounds(330,20,100,100);
        add(loginLabel);


        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(450,250);
        setLocationRelativeTo( null );      // To set window location centred
        setTitle("Login");
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }
}