package com.hotelmanagement;

import javax.swing.*;
import java.awt.*;

public class AddEmployee extends JFrame {
    JLabel nameLabel,ageLabel,genderLabel,jobLabel,salaryLabel,IdLabel,emailLabel;
    JTextField name,Age,Salary,email,Aadhaar;
    RoundButton addBtn;
    AddEmployee() {
        //NameIcon
        ImageIcon ic = new ImageIcon("src/com/hotelmanagement/icons/user_icon.png");
        Image login = ic.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon user_icon = new ImageIcon(login);
        nameLabel = new JLabel("Name :");
        nameLabel.setBounds(10, 28, 120, 40);
        nameLabel.setIcon(user_icon);
        add(nameLabel);
        //AgeIcon
        ImageIcon ageic = new ImageIcon("src/com/hotelmanagement/icons/icon_age1.jpeg");
        Image image = ageic.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon age_icon = new ImageIcon(image);
        ageLabel = new JLabel("Age :");
        ageLabel.setBounds(10, 78, 120, 40);
        ageLabel.setIcon(age_icon);
        add(ageLabel);
        //GenderIcon
        ImageIcon genderic = new ImageIcon("src/com/hotelmanagement/icons/gender_icon.png");
        Image genderImage = genderic.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon gender_icon = new ImageIcon(genderImage);
        genderLabel = new JLabel("Gender :");
        genderLabel.setBounds(10, 128, 120, 40);
        genderLabel.setIcon(gender_icon);
        add(genderLabel);
        //JobIcon
        ImageIcon jobic = new ImageIcon("src/com/hotelmanagement/icons/jobs_icon.png");
        Image jobImage = jobic.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon job_icon = new ImageIcon(jobImage);
        jobLabel = new JLabel("Job :");
        jobLabel.setBounds(10, 178, 120, 40);
        jobLabel.setIcon(job_icon);
        add(jobLabel);
        //SalaryIcon
        ImageIcon salaryic = new ImageIcon("src/com/hotelmanagement/icons/salary_icon.png");
        Image salaryImage = salaryic.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon salary_icon = new ImageIcon(salaryImage);
        salaryLabel = new JLabel("Salary :");
        salaryLabel.setBounds(10, 228, 120, 40);
        salaryLabel.setIcon(gender_icon);
        add(salaryLabel);
        //IDIcon
        ImageIcon idic = new ImageIcon("src/com/hotelmanagement/icons/id_icon.png");
        Image idImage = idic.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon id_icon = new ImageIcon(idImage);
        IdLabel = new JLabel("Aadhaar :");
        IdLabel.setBounds(10, 278, 120, 40);
        IdLabel.setIcon(id_icon);
        add(IdLabel);
        //EmailIcon
        ImageIcon emailic = new ImageIcon("src/com/hotelmanagement/icons/email_icon.png");
        Image emailImage = emailic.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon email_icon = new ImageIcon(emailImage);
        emailLabel = new JLabel("Email :");
        emailLabel.setBounds(10, 328, 120, 40);
        emailLabel.setIcon(email_icon);
        add(emailLabel);
        //Name TextField
        name = new JTextField();
        name.setBackground(Color.lightGray);
        name.setBounds(150,30,150,30);
        name.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black,2),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        add(name);
        //AgeField
        Age = new JTextField();
        Age.setBackground(Color.lightGray);
        Age.setBounds(150,80,150,30);
        Age.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black,2),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        add(Age);
        //SalaryField
        Salary = new JTextField();
        Salary.setBackground(Color.lightGray);
        Salary.setBounds(150,130,150,30);
        Salary.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black,2),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        add(Salary);
        //IDField
        Aadhaar = new JTextField();
        Aadhaar.setBackground(Color.lightGray);
        Aadhaar.setBounds(150,280,150,30);
        Aadhaar.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black,2),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        add(Aadhaar);
        //EmailField
        email = new JTextField();
        email.setBackground(Color.lightGray);
        email.setBounds(150,330,150,30);
        email.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black,2),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        add(email);
        //AddBtn
        addBtn = new RoundButton("Add");
        addBtn.setBounds(160,380,110,30);
        addBtn.setBackground(Color.black);
        addBtn.setForeground(Color.ORANGE);
        addBtn.setFocusPainted(false);
       // addBtn.addActionListener(this);
        add(addBtn);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(700,450);
        setLocationRelativeTo( null );      // To set window location centred
        setTitle("Add Employee");
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AddEmployee().setVisible(true);
    }
}
