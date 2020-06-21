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

public class CheckOut extends JFrame implements ActionListener{

    JLabel IdLabel,nameLabel,allotLabel,Deposit,Deposit1;
    JTextField name,room,amountpaid,amountremaining;
    JComboBox idChoice;
    RoundButton checkOutBtn,backBtn;


    CheckOut(){
        ImageIcon i1 = new ImageIcon("src/com/hotelmanagement/icons/bokeh.jpeg");
        Image b = i1.getImage().getScaledInstance(900,600,Image.SCALE_SMOOTH);
        ImageIcon i2 = new ImageIcon(b);
        JLabel background = new JLabel(i2);
        background.setBounds(0,0,900,600);
        add(background);

        JLabel jLabel = new JLabel("Check-Out");
        jLabel.setBounds(270,15,450,30);
        jLabel.setFont(new Font("Tahoma", Font.BOLD ,26));
        Font font = jLabel.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_LOW_TWO_PIXEL);
        jLabel.setFont(font.deriveFont(attributes));
        background.add(jLabel);


        ImageIcon idic = new ImageIcon("src/com/hotelmanagement/icons/id_icon.png");
        Image idImage = idic.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon id_icon = new ImageIcon(idImage);
        IdLabel = new JLabel("ID :");
        IdLabel.setBounds(15, 64, 155, 40);
        IdLabel.setIcon(id_icon);
        background.add(IdLabel);

        idChoice = new JComboBox();
        idChoice.setBackground(Color.WHITE);
        idChoice.setBounds(200,70,150,30);
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
        idChoice.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String roomnumber="",name1 = "",price = "",deposit="",check = "";
                try{
                    String idnumber = (String)idChoice.getSelectedItem();
                    DatabaseConnection databaseConnection = new DatabaseConnection();
                    ResultSet resultSet = databaseConnection.statement.executeQuery("SELECT * FROM customer WHERE idnumber = "+idnumber);
                    while (resultSet.next()){
                        roomnumber = resultSet.getString("room_number");
                        room.setText(roomnumber);
                        name1 = resultSet.getString("name");
                        name.setText(name1);
                        deposit = resultSet.getString("deposit");
                        amountpaid.setText(deposit);
                    }

                }catch (Exception ae){
                    ae.printStackTrace();
                }

                try {
                    DatabaseConnection c = new DatabaseConnection();
                    ResultSet rs2 = c.statement.executeQuery("select * from room where room_number = \"" + roomnumber + "\"");
                    while (rs2.next()){
                        price = rs2.getString("price");
                        int remaining = Integer.parseInt(price)-Integer.parseInt(deposit);
                        amountremaining.setText(Integer.toString(remaining));
                    }
                }catch (Exception a){
                    a.printStackTrace();
                }
            }
        });

        ImageIcon ic = new ImageIcon("src/com/hotelmanagement/icons/user_icon.png");
        Image login = ic.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon user_icon = new ImageIcon(login);
        nameLabel = new JLabel("Name :");
        nameLabel.setBounds(15, 134, 155, 40);
        nameLabel.setIcon(user_icon);
        background.add(nameLabel);


        name = new JTextField();
        name.setBackground(Color.white);
        name.setEditable(false);
        name.setBounds(200,140,150,30);
        name.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black,2),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        background.add(name);


        ImageIcon allotic = new ImageIcon("src/com/hotelmanagement/icons/roomNo_icon.png");
        Image allot = allotic.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon allot_icon = new ImageIcon(allot);
        allotLabel = new JLabel("Room Number:");
        allotLabel.setBounds(15, 204, 155, 40);
        allotLabel.setIcon(allot_icon);
        background.add(allotLabel);



        room = new JTextField("");
        room.setBackground(Color.white);
        room.setEditable(false);
        room.setBounds(200,210,150,30);
        room.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black,2),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        background.add(room);



        ImageIcon depositic = new ImageIcon("src/com/hotelmanagement/icons/price_icon.png");
        Image deposit = depositic.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon deposit_icon = new ImageIcon(deposit);
        Deposit = new JLabel("Amount Paid :");
        Deposit.setBounds(15, 274, 155, 40);
        Deposit.setIcon(deposit_icon);
        background.add(Deposit);

        amountpaid = new JTextField();
        amountpaid.setBackground(Color.white);
        amountpaid.setEditable(false);
        amountpaid.setBounds(200,280,150,30);
        amountpaid.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black,2),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        background.add(amountpaid);


        ImageIcon depositic1 = new ImageIcon("src/com/hotelmanagement/icons/price_icon.png");
        Image deposit1 = depositic1.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon deposit_icon1 = new ImageIcon(deposit1);
        Deposit1 = new JLabel("Amount Remaining :");
        Deposit1.setBounds(15, 344, 180, 40);
        Deposit1.setIcon(deposit_icon1);
        background.add(Deposit1);


        amountremaining = new JTextField();
        amountremaining.setBackground(Color.white);
        amountremaining.setEditable(false);
        amountremaining.setBounds(200,350,150,30);
        amountremaining.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black,2),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        background.add(amountremaining);


        checkOutBtn = new RoundButton("CHECK-OUT");
        checkOutBtn.setBounds(35,420,120,30);
        checkOutBtn.setForeground(Color.ORANGE);
        checkOutBtn.setBackground(Color.black);
        checkOutBtn.addActionListener(this);
        background.add(checkOutBtn);

        backBtn = new RoundButton("BACK");
        backBtn.setBounds(215,420,120,30);
        backBtn.setForeground(Color.ORANGE);
        backBtn.setBackground(Color.black);
        backBtn.addActionListener(this);
        background.add(backBtn);

        ImageIcon icon = new ImageIcon("src/com/hotelmanagement/icons/bye.png");
        Image icn_cmp = icon.getImage().getScaledInstance(300,350,Image.SCALE_SMOOTH);
        ImageIcon loginIcon = new ImageIcon(icn_cmp);
        JLabel loginLabel = new JLabel(loginIcon);
        loginLabel.setBounds(380,60,300,350);
        background.add(loginLabel);

        this.setLayout(null);
        this.setSize(690,510);
        this.setLocationRelativeTo(null );      // To set window location centred
        this.setTitle("Check-Out");
        this.setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backBtn){
            this.setVisible(false);
            new Reception().setVisible(true);
        }else if(e.getSource()== checkOutBtn){
            if(!room.getText().equals("")) {
                try {
                    DatabaseConnection c = new DatabaseConnection();
                    String id = (String)idChoice.getSelectedItem();
                    String roomNo = room.getText();
                    String str = "delete from customer where idnumber = \""+id+"\"";
                    String str2 = "update room set available = \"Available\" where room_number = \""+roomNo+"\"";
                    String str3 = "update room set clean = \"Dirty\" where room_number = \""+roomNo+"\"";

                    c.statement.executeUpdate(str);
                    c.statement.executeUpdate(str2);
                    c.statement.executeUpdate(str3);

                    JOptionPane.showMessageDialog(null, "Checked-out Successfully");
                    new Reception().setVisible(true);
                    setVisible(false);
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            }else{
                JOptionPane.showMessageDialog(null,"Please Select Customer Id");
            }
        }
    }
    public static void main(String[] args) {
        new CheckOut().setVisible(true);
    }


}
