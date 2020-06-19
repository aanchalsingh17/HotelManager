package com.hotelmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame implements ActionListener {

    RoundButton newCustomerBtn,roomBtn,departmentBtn,employeeBtn,customerBtn,managerBtn,checkoutBtn,checkStatusBtn,roomStatusBtn,pickUpBtn,searchRoomBtn,logoutBtn;
    Reception(){


        ImageIcon i1 = new ImageIcon("src/com/hotelmanagement/icons/bokeh.jpeg");
        Image b = i1.getImage().getScaledInstance(750,640,Image.SCALE_SMOOTH);
        ImageIcon i2 = new ImageIcon(b);
        JLabel background = new JLabel(i2);
        background.setBounds(0,0,750,640);
        add(background);


        newCustomerBtn = new RoundButton("NEW CUSTOMER FORM");
        newCustomerBtn.setBackground(Color.black);
        newCustomerBtn.setForeground(Color.ORANGE);
        newCustomerBtn.setBounds(30,10,200,30);
        newCustomerBtn.addActionListener(this);
        background.add(newCustomerBtn);

        roomBtn = new RoundButton("ROOM");
        roomBtn.setBackground(Color.black);
        roomBtn.setForeground(Color.ORANGE);
        roomBtn.setBounds(30,50,200,30);
        roomBtn.addActionListener(this);
        background.add(roomBtn);

        departmentBtn = new RoundButton("DEPARTMENT");
        departmentBtn.setBackground(Color.black);
        departmentBtn.setForeground(Color.ORANGE);
        departmentBtn.setBounds(30,90,200,30);
        departmentBtn.addActionListener(this);
        background.add(departmentBtn);

        employeeBtn = new RoundButton("EMPLOYEES INFO");
        employeeBtn.setBackground(Color.black);
        employeeBtn.setForeground(Color.ORANGE);
        employeeBtn.setBounds(30,130,200,30);
        employeeBtn.addActionListener(this);
        background.add(employeeBtn);

        customerBtn = new RoundButton("CUSTOMERS INFO");
        customerBtn.setBackground(Color.black);
        customerBtn.setForeground(Color.ORANGE);
        customerBtn.setBounds(30,170,200,30);
        customerBtn.addActionListener(this);
        background.add(customerBtn);

        managerBtn = new RoundButton("MANAGER INFO");
        managerBtn.setBackground(Color.black);
        managerBtn.setForeground(Color.ORANGE);
        managerBtn.setBounds(30,210,200,30);
        managerBtn.addActionListener(this);
        background.add(managerBtn);

        checkoutBtn = new RoundButton("CHECKOUT");
        checkoutBtn.setBackground(Color.black);
        checkoutBtn.setForeground(Color.ORANGE);
        checkoutBtn.setBounds(30,250,200,30);
        checkoutBtn.addActionListener(this);
        background.add(checkoutBtn);

        checkStatusBtn = new RoundButton("UPDATE CHECK STATUS");
        checkStatusBtn.setBackground(Color.black);
        checkStatusBtn.setForeground(Color.ORANGE);
        checkStatusBtn.setBounds(30,290,200,30);
        checkStatusBtn.addActionListener(this);
        background.add(checkStatusBtn);

        roomStatusBtn = new RoundButton("UPDATE ROOM STATUS");
        roomStatusBtn.setBackground(Color.black);
        roomStatusBtn.setForeground(Color.ORANGE);
        roomStatusBtn.setBounds(30,330,200,30);
        roomStatusBtn.addActionListener(this);
        background.add(roomStatusBtn);

        pickUpBtn = new RoundButton("PICK-UP SERVICE");
        pickUpBtn.setBackground(Color.black);
        pickUpBtn.setForeground(Color.ORANGE);
        pickUpBtn.setBounds(30,370,200,30);
        pickUpBtn.addActionListener(this);
        background.add(pickUpBtn);

        searchRoomBtn = new RoundButton("SEARCH ROOM");
        searchRoomBtn.setBackground(Color.black);
        searchRoomBtn.setForeground(Color.ORANGE);
        searchRoomBtn.setBounds(30,410,200,30);
        searchRoomBtn.addActionListener(this);
        background.add(searchRoomBtn);

        logoutBtn = new RoundButton("LOGOUT");
        logoutBtn.setBackground(Color.black);
        logoutBtn.setForeground(Color.ORANGE);
        logoutBtn.setBounds(30,450,200,30);
        logoutBtn.addActionListener(this);
        background.add(logoutBtn);

        ImageIcon icon = new ImageIcon("src/com/hotelmanagement/icons/reception.jpeg");
        Image icn_cmp = icon.getImage().getScaledInstance(470,380,Image.SCALE_SMOOTH);
        ImageIcon loginIcon = new ImageIcon(icn_cmp);
        JLabel roomPhoto = new JLabel(loginIcon);
        roomPhoto.setBounds(260,50,470,380);
        background.add(roomPhoto);


        this.setLayout(null);
        this.setSize(750,520);
        this.setLocationRelativeTo(null );      // To set window location centred
        this.setTitle("Reception");
        this.setResizable(false);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == newCustomerBtn){
            new NewCustomer().setVisible(true);
            this.setVisible(false);
        }else if(e.getSource() == roomBtn){

            new Room().setVisible(true);
            this.setVisible(false);

        }else if(e.getSource() == departmentBtn){

        }else if(e.getSource() == employeeBtn){
            new EmployeeInfo().setVisible(true);
              this.setVisible(false);
        }else if(e.getSource() == customerBtn){
            new CustomerInfo().setVisible(true);
            this.setVisible(false);
        }else if(e.getSource() == managerBtn){
            new ManagerInfo().setVisible(true);
            this.setVisible(false);
        }else if(e.getSource() == checkoutBtn){
                  new CheckOut().setVisible(true);
                  this.setVisible(false);
        }else if(e.getSource() == checkStatusBtn){
                 new CheckStatus().setVisible(true);
                 this.setVisible(false);
        }else if(e.getSource() == roomStatusBtn){
            new UpdateRoom().setVisible(true);
            this.setVisible(false);
        }else if(e.getSource() == pickUpBtn){

        }else if(e.getSource() == searchRoomBtn){

        }else if(e.getSource() == logoutBtn){
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Reception().setVisible(true);
    }


}
