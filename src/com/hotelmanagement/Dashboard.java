package com.hotelmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {

    JMenuBar menuBar;
    JMenu menu1, admin;
    JMenuItem reception, add_employee, add_room, add_driver;
    Dimension screenSize;
    int screenHeight, screenWidth;

    Dashboard() {
        //  Get screen size
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenHeight = (int) screenSize.getHeight();
        screenWidth = (int) screenSize.getWidth();

        menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, screenWidth, 30);
        menuBar.setBackground(Color.BLACK);
        add(menuBar);

        menu1 = new JMenu("HOTEL MANAGEMENT");
        menu1.setForeground(Color.WHITE);
        menuBar.add(menu1);

        // This jmenu is just for space between two jmenu
        JMenu space = new JMenu("|");
        space.setEnabled(false);
        menuBar.add(space);

        admin = new JMenu("Admin Controls");
        admin.setForeground(Color.WHITE);
        menuBar.add(admin);

        reception = new JMenuItem("Reception");
        reception.setBackground(Color.darkGray);
        reception.setForeground(Color.WHITE);
        reception.addActionListener(this);
        menu1.add(reception);
        menu1.addSeparator();       //  Seperator for gap between two menu items


        add_employee = new JMenuItem("Add Employee");
        add_employee.setBackground(Color.darkGray);
        add_employee.setForeground(Color.WHITE);
        add_employee.addActionListener(this);
        admin.add(add_employee);
        admin.addSeparator();

        add_room = new JMenuItem("Add Room");
        add_room.setBackground(Color.darkGray);
        add_room.setForeground(Color.WHITE);
        add_room.addActionListener(this);
        admin.add(add_room);
        admin.addSeparator();


        add_driver = new JMenuItem("Add Driver");
        add_driver.setBackground(Color.darkGray);
        add_driver.setForeground(Color.WHITE);
        add_driver.addActionListener(this);
        admin.add(add_driver);

        ImageIcon dashImage = new ImageIcon("src/com/hotelmanagement/icons/dashboard.jpg");
        Image i1 = dashImage.getImage().getScaledInstance(screenWidth, screenHeight, Image.SCALE_DEFAULT);
        JLabel l1 = new JLabel(new ImageIcon(i1));
        l1.setBounds(0, 0, screenWidth, screenHeight);
        add(l1);

        JLabel welcomeNote = new JLabel("Welcome to hotel managment portal");
        welcomeNote.setBounds(screenWidth / 2 - 308, screenHeight - 125, 616, 50);
        welcomeNote.setForeground(Color.BLACK);
        welcomeNote.setBackground(Color.ORANGE);
        welcomeNote.setOpaque(true);
        welcomeNote.setFont(new Font("SansSerif", Font.BOLD, 30));
        l1.add(welcomeNote);

        setLayout(null);
        setBounds(0, 0, screenWidth, screenHeight);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Dashboard().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if (actionEvent.getActionCommand().equals("Add Employee")) {
            new AddEmployee().setVisible(true);
        } else if (actionEvent.getActionCommand().equals("Add Room")) {
            new AddRoom().setVisible(true);
        } else if (actionEvent.getActionCommand().equals("Reception")) {
            new Reception().setVisible(true);
        }


    }


}