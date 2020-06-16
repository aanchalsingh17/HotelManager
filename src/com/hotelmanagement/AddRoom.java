package com.hotelmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.Map;

public class AddRoom extends JFrame implements ActionListener {

    JTextField roomNo, price;
    JComboBox available, clean, bedType;
    RoundButton addBtn, cancelBtn;
    JProgressBar progressBar;

    AddRoom(){

        JLabel roomNoLabel, availableLabel, cleanLabel, priceLabel, bedTypeLabel;


        ImageIcon i1 = new ImageIcon("src/com/hotelmanagement/icons/bokeh.jpeg");
        Image b1 = i1.getImage().getScaledInstance(700,440,Image.SCALE_SMOOTH);
        ImageIcon i2 = new ImageIcon(b1);
        JLabel background = new JLabel(i2);
        background.setBounds(0,0,700,440);
        add(background);

        JLabel jLabel = new JLabel("Add Room Details");
        jLabel.setBounds(221,10,258,30);
        jLabel.setFont(new Font("Tahoma", Font.BOLD ,25));
        Font font = jLabel.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_LOW_TWO_PIXEL);
        jLabel.setFont(font.deriveFont(attributes));
        background.add(jLabel);

        roomNoLabel = new JLabel(" Room Number      :");
        roomNoLabel.setBounds(15, 48, 155, 40);
        ImageIcon jobic = new ImageIcon("src/com/hotelmanagement/icons/roomNo_icon.png");
        Image jobImage = jobic.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon job_icon = new ImageIcon(jobImage);
        roomNoLabel.setIcon(job_icon);
        background.add(roomNoLabel);

        roomNo = new JTextField();
        roomNo.setBackground(Color.WHITE);
        roomNo.setBounds(180,50,150,30);
        roomNo.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black,2),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        background.add(roomNo);


        availableLabel = new JLabel(" Availability           :");
        availableLabel.setBounds(15, 98, 155, 40);
        ImageIcon availic = new ImageIcon("src/com/hotelmanagement/icons/tick_icon.png");
        Image availImage = availic.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon avail_icon = new ImageIcon(availImage);
        availableLabel.setIcon(avail_icon);
        background.add(availableLabel);

        available = new JComboBox(new String[] {"Available", "Occupied"});
        available.setSelectedIndex(0);
        available.setBorder(BorderFactory.createLineBorder(Color.black,1));
        available.setBounds(180,100,150,30);
        background.add(available);


        cleanLabel = new JLabel(" Cleaning Status  :");
        cleanLabel.setBounds(15, 148, 155, 40);
        ImageIcon cleanic = new ImageIcon("src/com/hotelmanagement/icons/clean_icon.png");
        Image cleanImage = cleanic.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon clean_icon = new ImageIcon(cleanImage);
        cleanLabel.setIcon(clean_icon);
        background.add(cleanLabel);

        clean = new JComboBox(new String[] {"Clean", "Dirty"});
        clean.setSelectedIndex(0);
        clean.setBorder(BorderFactory.createLineBorder(Color.black,1));
        clean.setBounds(180,150,150,30);
        background.add(clean);


        priceLabel = new JLabel(" Room Price           :");
        priceLabel.setBounds(15, 198, 155, 40);
        ImageIcon priceic = new ImageIcon("src/com/hotelmanagement/icons/price_icon.png");
        Image priceImage = priceic.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon price_icon = new ImageIcon(priceImage);
        priceLabel.setIcon(price_icon);
        background.add(priceLabel);

        price = new JTextField();
        price.setBackground(Color.WHITE);
        price.setBounds(180,200,150,30);
        price.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black,2),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        background.add(price);


        bedTypeLabel = new JLabel(" Bed Type              :");
        bedTypeLabel.setBounds(15, 248, 155, 40);
        ImageIcon bedic = new ImageIcon("src/com/hotelmanagement/icons/bed_icon.png");
        Image bedImage = bedic.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon bed_icon = new ImageIcon(bedImage);
        bedTypeLabel.setIcon(bed_icon);
        background.add(bedTypeLabel);

        bedType = new JComboBox(new String[] {"Single Bed", "Double Bed"});
        bedType.setBounds(180,250,150,30);
        bedType.setBorder(BorderFactory.createLineBorder(Color.black,1));
        background.add(bedType);


        progressBar=new JProgressBar();
        progressBar.setBounds(100,300,170,20);
        progressBar.setIndeterminate(true);
        progressBar.setVisible(false);
        background.add(progressBar);


        addBtn = new RoundButton("ADD ROOM");
        addBtn.setBounds(35,335,120,30);
        addBtn.setForeground(Color.ORANGE);
        addBtn.setBackground(Color.black);
        addBtn.addActionListener(this);
        background.add(addBtn);

        cancelBtn = new RoundButton("CANCEL");
        cancelBtn.setBounds(190,335,120,30);
        cancelBtn.setForeground(Color.ORANGE);
        cancelBtn.setBackground(Color.black);
        cancelBtn.addActionListener(this);
        background.add(cancelBtn);

        ImageIcon icon = new ImageIcon("src/com/hotelmanagement/icons/room.jpeg");
        Image icn_cmp = icon.getImage().getScaledInstance(320,320,Image.SCALE_SMOOTH);
        ImageIcon loginIcon = new ImageIcon(icn_cmp);
        JLabel roomPhoto = new JLabel(loginIcon);
        roomPhoto.setBounds(350,50,320,318);
        background.add(roomPhoto);



        this.setLayout(null);
        this.setSize(700,440);
        this.setLocationRelativeTo((Component)null );      // To set window location centred
        this.setTitle("Add Room");
        this.setResizable(false);


        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == addBtn){

            //  Check if all fields are filled or not
            if(roomNo.getText().equals("")) {
                JOptionPane.showMessageDialog(roomNo, "Please specify room number","Warning",JOptionPane.ERROR_MESSAGE);
            }else if(price.getText().equals("")){
                JOptionPane.showMessageDialog(price, "Please specify price","Warning",JOptionPane.ERROR_MESSAGE);
            }else {
                progressBar.setVisible(true);
                //  If everything is okay, proceed
                String roomNoText = roomNo.getText();
                String availableText = (String) available.getSelectedItem();
                String cleanText = (String) clean.getSelectedItem();
                String priceText = price.getText();
                String bedText = (String) bedType.getSelectedItem();

                DatabaseConnection databaseConnection = new DatabaseConnection();
                try {
                    //  To create table dynamically
                    String sqlCreate = "CREATE TABLE IF NOT EXISTS room"
                            + "  (room_number     VARCHAR(10),"
                            + "   available       VARCHAR(20),"
                            + "   clean           VARCHAR(20),"
                            + "   price           VARCHAR(20),"
                            + "   bed_type        VARCHAR(20))";

                    String addRoom = "INSERT INTO room VALUES" +
                            "('" + roomNoText + "','" + availableText + "','" + cleanText + "','" + priceText + "','" + bedText + "')";

                    databaseConnection.statement.executeUpdate(sqlCreate);
                    databaseConnection.statement.executeUpdate(addRoom);
                    JOptionPane.showMessageDialog(null, "New Employee Added");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error Occurred. Try again");
                    e.printStackTrace();
                } finally {
                    progressBar.setVisible(false);
                    this.setVisible(false);
                }
            }
        }
        else if(ae.getSource() == cancelBtn){
            this.setVisible(false);
        }
    }


    public static void main(String[] args) {
        new AddRoom().setVisible(true);
    }

}
