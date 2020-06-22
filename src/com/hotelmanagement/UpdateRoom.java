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

    JComboBox availChoice, cleanChoice, roomNumberChoice;
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



        JLabel roomNoLabel = new JLabel(" Room Number");
        ImageIcon room = new ImageIcon("src/com/hotelmanagement/icons/roomNo_icon.png");
        Image roomm = room.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon room_icon = new ImageIcon(roomm);
        roomNoLabel.setIcon(room_icon);
        roomNoLabel.setBounds(15,58,170,30);
        roomNoLabel.setFont(new Font("SansSerif", Font.PLAIN ,18));
        background.add(roomNoLabel);

        roomNumberChoice = new JComboBox();
        roomNumberChoice.setBounds(200,60,150,25);
        roomNumberChoice.setBackground(Color.WHITE);
        roomNumberChoice.setFont(new Font("SansSerif",Font.BOLD,15));
        roomNumberChoice.setBorder(BorderFactory.createLineBorder(Color.black,1));
        roomNumberChoice.setOpaque(true);
        roomNumberChoice.setEditable(false);
        background.add(roomNumberChoice);

        try{

            DatabaseConnection conn = new DatabaseConnection();
            ResultSet r = conn.statement.executeQuery("SELECT * FROM room");
            while (r.next()){
                roomNumberChoice.addItem(r.getString("room_number"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        roomNumberChoice.setSelectedItem(null);


        //  Whenever a room is selected, corresponding details are changed
        roomNumberChoice.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    String s1 = (String) roomNumberChoice.getSelectedItem();
                    DatabaseConnection c = new DatabaseConnection();
                    ResultSet rs = c.statement.executeQuery("select * from room where room_number = \""+s1 +"\"");

                    while(rs.next()){
                        availChoice.setSelectedItem(rs.getString("available"));
                        cleanChoice.setSelectedItem(rs.getString("clean"));
                    }
                }catch(Exception ee){
                    ee.printStackTrace();
                }
            }
        });



        JLabel availLabel = new JLabel(" Availability");
        ImageIcon av = new ImageIcon("src/com/hotelmanagement/icons/roomNo_icon.png");
        Image avm = av.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon av_icon = new ImageIcon(avm);
        availLabel.setIcon(av_icon);
        availLabel.setFont(new Font("SansSerif", Font.PLAIN ,18));
        availLabel.setBounds(15,138,150,30);
        background.add(availLabel);


        availChoice = new JComboBox(new String[]{"Occupied","Available"});
        availChoice.setBounds(200,140,150,25);
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
        cleanLabel.setBounds(15,218,150,30);
        background.add(cleanLabel);

        cleanChoice = new JComboBox(new String[]{"Clean","Dirty"});
        cleanChoice.setBounds(200,220,150,25);
        cleanChoice.setBackground(Color.WHITE);
        cleanChoice.setSelectedItem(null);
        cleanChoice.setBorder(BorderFactory.createLineBorder(Color.black,1));
        background.add(cleanChoice);


        //Adding filter btn
        updateBtn = new RoundButton("UPDATE");
        updateBtn.setBackground(Color.black);
        updateBtn.setForeground(Color.ORANGE);
        updateBtn.setBounds(40,300,100,30);
        updateBtn.addActionListener(this);
        background.add(updateBtn);

        //Adding Back Button
        backBtn = new RoundButton("BACK");
        backBtn.setBackground(Color.black);
        backBtn.setForeground(Color.ORANGE);
        backBtn.setBounds(215,300,100,30);
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
            if (!roomNumberChoice.getSelectedItem().equals("")) {
                try {
                    DatabaseConnection c = new DatabaseConnection();
                    String str = "update room set clean = \"" + cleanChoice.getSelectedItem() + "\" where room_number = \"" + roomNumberChoice.getSelectedItem() + "\"";
                    c.statement.executeUpdate(str);
                    String str2 = "update room set available = \"" + availChoice.getSelectedItem() + "\" where room_number = \"" + roomNumberChoice.getSelectedItem() + "\"";
                    c.statement.executeUpdate(str2);
                    JOptionPane.showMessageDialog(null, "Room Updated Successfully");
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
