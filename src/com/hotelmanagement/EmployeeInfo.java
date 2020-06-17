package com.hotelmanagement;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
public class EmployeeInfo  extends JFrame implements ActionListener {
    RoundButton loadBtn,backBtn;
    JTable employeeInfo;
    JLabel name,age,gender,job,salary,phone,aadhaar,email;
    EmployeeInfo(){
        ImageIcon i1 = new ImageIcon("src/com/hotelmanagement/icons/sparkle.jpeg");
        Image b = i1.getImage().getScaledInstance(1000,600,Image.SCALE_SMOOTH);
        ImageIcon i2 = new ImageIcon(b);
        JLabel background = new JLabel(i2);
        background.setBounds(0,0,1000,600);
        add(background);

        name = new JLabel("NAME");
        name.setBounds(30,15,40,20);
        name.setForeground(Color.BLUE);
        background.add(name);

        age = new JLabel("AGE");
        age.setBounds(170,15,40,20);
        age.setForeground(Color.BLUE);
        background.add(age);


        gender = new JLabel("GENDER");
        gender.setBounds(290,15,70,20);
        gender.setForeground(Color.BLUE);
        background.add(gender);

        job = new JLabel("JOB");
        job.setBounds(420,15,40,20);
        job.setForeground(Color.BLUE);
        background.add(job);

        salary = new JLabel("SALARY");
        salary.setBounds(540,15,70,20);
        salary.setForeground(Color.BLUE);
        background.add(salary);

        phone = new JLabel("PHONE");
        phone.setBounds(660,15,70,20);
        phone.setForeground(Color.BLUE);
        background.add(phone);

        aadhaar = new JLabel("AADHAAR");
        aadhaar.setBounds(780,15,90,20);
        aadhaar.setForeground(Color.BLUE);
        background.add(aadhaar);


        email = new JLabel("EMAIL");
        email.setBounds(900,15,70,20);
        email.setForeground(Color.BLUE);
        background.add(email);


        employeeInfo = new JTable();
        employeeInfo.setBounds(0,40,1000,500);
        employeeInfo.setOpaque(false);
        background.add(employeeInfo);

        //Adding load btn
        loadBtn = new RoundButton("LOAD DATA");
        loadBtn.setBackground(Color.black);
        loadBtn.setForeground(Color.ORANGE);
        loadBtn.setBounds(330,550,150,30);
        loadBtn.addActionListener(this);
        background.add(loadBtn);


        //Adding Back Button
        backBtn = new RoundButton("BACK");
        backBtn.setBackground(Color.black);
        backBtn.setForeground(Color.ORANGE);
        backBtn.setBounds(500,550,150,30);
        backBtn.addActionListener(this);
        background.add(backBtn);

        this.setLayout(null);
        this.setSize(1000,600);
        this.setLocationRelativeTo(null );      // To set window location centred
        this.setTitle("Employee Details");
        this.setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == backBtn){
           this.setVisible(false);
           new Reception().setVisible(true);
       }else if(e.getSource() == loadBtn){
           try {
               DatabaseConnection databaseConnection = new DatabaseConnection();
               String str = "select * from employee";
               ResultSet resultSet = databaseConnection.statement.executeQuery(str);
               employeeInfo.setModel(DbUtils.resultSetToTableModel(resultSet));
           }catch (Exception ae){

           }
       }
    }
    public static void main(String[] args) {
        new EmployeeInfo().setVisible(true);
    }


}
