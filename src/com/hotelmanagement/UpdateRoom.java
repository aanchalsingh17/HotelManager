package com.hotelmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.font.TextAttribute;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class UpdateRoom extends JFrame implements ActionListener {

    JComboBox idChoice, availChoice, cleanChoice;
    JTextField roomNumberField;
    RoundButton updateBtn,backBtn;

    UpdateRoom(){


        ImageIcon i1 = new ImageIcon("src/com/hotelmanagement/icons/bokeh.jpeg");
        Image b = i1.getImage().getScaledInstance(1170,600,Image.SCALE_SMOOTH);
        ImageIcon i2 = new ImageIcon(b);
        JLabel background = new JLabel(i2);
        background.setBounds(0,0,1170,600);
        add(background);


        JLabel updateLabel = new JLabel("UPDATE ROOM STATUS");
        updateLabel.setBounds(170,10,500,35);
        updateLabel.setFont(new Font("Tahoma", Font.BOLD ,27));
        Font font = updateLabel.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_LOW_TWO_PIXEL);
        updateLabel.setFont(font.deriveFont(attributes));
        background.add(updateLabel);

        JLabel guestIdLabel = new JLabel(" Guest ID:");
        ImageIcon id = new ImageIcon("src/com/hotelmanagement/icons/id_icon.png");
        Image idim = id.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon id_icon = new ImageIcon(idim);
        guestIdLabel.setIcon(id_icon);
        guestIdLabel.setBounds(15,58,150,30);
        guestIdLabel.setFont(new Font("SansSerif", Font.PLAIN ,18));
        background.add(guestIdLabel);




        idChoice = new JComboBox();
        idChoice.setBackground(Color.WHITE);
        idChoice.setBounds(200,60,150,25);
        idChoice.setBorder(BorderFactory.createLineBorder(Color.black,1));


        background.add(idChoice);
        try{

            DatabaseConnection conn = new DatabaseConnection();
            ResultSet r = conn.statement.executeQuery("SELECT * FROM customer");
            while (r.next()){
                idChoice.addItem(r.getString("idnumber"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        idChoice.setSelectedItem(null);

        //  Whenever a id is selected, corresponding room and details are changed
        idChoice.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String room = "";
                try{
                    String s1 = (String) idChoice.getSelectedItem();
                    DatabaseConnection c = new DatabaseConnection();
                    ResultSet rs1 = c.statement.executeQuery("select * from customer where idnumber = "+s1);

                    while(rs1.next()){
                        room = rs1.getString("room_number");
                        roomNumberField.setText(room);
                    }
                }catch(Exception ee){
                    ee.printStackTrace();
                }

                try{
                    DatabaseConnection c  = new DatabaseConnection();
                    ResultSet rs2 = c.statement.executeQuery("select * from room where room_number = \""+room + "\"");
                    while(rs2.next()){
                        availChoice.setSelectedItem(rs2.getString("available"));
                        cleanChoice.setSelectedItem(rs2.getString("clean"));
                    }
                }catch(Exception ee){
                    ee.printStackTrace();
                }
            }
        });



        JLabel roomNoLabel = new JLabel(" Room Number");
        ImageIcon room = new ImageIcon("src/com/hotelmanagement/icons/roomNo_icon.png");
        Image roomm = room.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon room_icon = new ImageIcon(roomm);
        roomNoLabel.setIcon(room_icon);
        roomNoLabel.setBounds(15,118,170,30);
        roomNoLabel.setFont(new Font("SansSerif", Font.PLAIN ,18));
        background.add(roomNoLabel);

        roomNumberField = new JTextField("");
        roomNumberField.setBounds(200,120,150,25);
        roomNumberField.setBackground(Color.WHITE);
        roomNumberField.setFont(new Font("SansSerif",Font.BOLD,15));
        roomNumberField.setBorder(BorderFactory.createLineBorder(Color.black,1));
        roomNumberField.setOpaque(true);
        roomNumberField.setEditable(false);
        background.add(roomNumberField);

        JLabel availLabel = new JLabel(" Availability");
        ImageIcon av = new ImageIcon("src/com/hotelmanagement/icons/roomNo_icon.png");
        Image avm = av.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon av_icon = new ImageIcon(avm);
        availLabel.setIcon(av_icon);
        availLabel.setFont(new Font("SansSerif", Font.PLAIN ,18));
        availLabel.setBounds(15,178,150,30);
        background.add(availLabel);


        availChoice = new JComboBox(new String[]{"Occupied","Available"});
        availChoice.setBounds(200,180,150,25);
        availChoice.setBackground(Color.WHITE);
        availChoice.setSelectedItem(null);
        availChoice.setBorder(BorderFactory.createLineBorder(Color.black,1));
        background.add(availChoice);

        JLabel cleanLabel = new JLabel(" Clean Status");
        ImageIcon cl = new ImageIcon("src/com/hotelmanagement/icons/clean_icon.png");
        Image clm = cl.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon cl_icon = new ImageIcon(clm);
        cleanLabel.setIcon(cl_icon);
        cleanLabel.setFont(new Font("SansSerif", Font.PLAIN ,18));
        cleanLabel.setBounds(15,238,150,30);
        background.add(cleanLabel);

        cleanChoice = new JComboBox(new String[]{"Clean","Dirty"});
        cleanChoice.setBounds(200,240,150,25);
        cleanChoice.setBackground(Color.WHITE);
        cleanChoice.setSelectedItem(null);
        cleanChoice.setBorder(BorderFactory.createLineBorder(Color.black,1));
        background.add(cleanChoice);


        //Adding filter btn
        updateBtn = new RoundButton("UPDATE");
        updateBtn.setBackground(Color.black);
        updateBtn.setForeground(Color.ORANGE);
        updateBtn.setBounds(40,320,100,30);
        updateBtn.addActionListener(this);
        background.add(updateBtn);

        //Adding Back Button
        backBtn = new RoundButton("BACK");
        backBtn.setBackground(Color.black);
        backBtn.setForeground(Color.ORANGE);
        backBtn.setBounds(215,320,100,30);
        backBtn.addActionListener(this);
        background.add(backBtn);


        ImageIcon icon = new ImageIcon("src/com/hotelmanagement/icons/roomClean.jpg");
        Image icn_cmp = icon.getImage().getScaledInstance(300,290,Image.SCALE_SMOOTH);
        ImageIcon loginIcon = new ImageIcon(icn_cmp);
        JLabel roomPhoto = new JLabel(loginIcon);
        roomPhoto.setBorder(BorderFactory.createLineBorder(Color.gray,2));
        roomPhoto.setBounds(375,60,300,290);
        background.add(roomPhoto);


        this.setLayout(null);
        this.setSize(700,400);
        this.setLocationRelativeTo(null );      // To set window location centred
        this.setTitle("Update Room");
        this.setResizable(false);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == updateBtn) {
            if (!roomNumberField.getText().equals("")) {
                try {
                    DatabaseConnection c = new DatabaseConnection();
                    String str = "update room set clean = \"" + cleanChoice.getSelectedItem() + "\" where room_number = \"" + roomNumberField.getText() + "\"";
                    c.statement.executeUpdate(str);
                    String str2 = "update room set available = \"" + availChoice.getSelectedItem() + "\" where room_number = \"" + roomNumberField.getText() + "\"";
                    c.statement.executeUpdate(str2);
                    JOptionPane.showMessageDialog(null, "Update Sucessful");
                    new Reception().setVisible(true);
                    setVisible(false);
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"Please select a room");
            }
        }

        else if(e.getSource() == backBtn){
            this.setVisible(false);
            new Reception().setVisible(true);
        }

    }

    public static void main(String[] args) {
        new UpdateRoom().setVisible(true);
    }

}
