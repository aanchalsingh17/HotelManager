package com.hotelmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.RescaleOp;
import java.sql.ResultSet;

public class AddEmployee extends JFrame implements ActionListener {
    JTextField name,Age,Salary,email,Aadhaar,phone;
    JRadioButton male,female;
    JComboBox jobs;
    AddEmployee() {
        JLabel nameLabel,ageLabel,genderLabel,jobLabel,salaryLabel,IdLabel,emailLabel,phoneLabel;

        RoundButton addBtn;


        JLabel jLabel;
        getContentPane().setBackground(Color.WHITE);
        this.setLayout(null);
        this.setSize(700,490);
        this.setLocationRelativeTo((Component)null );      // To set window location centred
        this.setTitle("Add Employee");
        this.setResizable(false);


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
        //PhoneIcon
        ImageIcon phoneic = new ImageIcon("src/com/hotelmanagement/icons/phone_icon.png");
        Image phoneImage = phoneic.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon phone_icon = new ImageIcon(phoneImage);
        phoneLabel = new JLabel("Phone :");
        phoneLabel.setBounds(10, 228, 120, 40);
        phoneLabel.setIcon(phone_icon);
        add(phoneLabel);
        //SalaryIcon
        ImageIcon salaryic = new ImageIcon("src/com/hotelmanagement/icons/salary_icon.png");
        Image salaryImage = salaryic.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon salary_icon = new ImageIcon(salaryImage);
        salaryLabel = new JLabel("Salary :");
        salaryLabel.setBounds(10, 278, 120, 40);
        salaryLabel.setIcon(salary_icon);
        add(salaryLabel);
        //IDIcon
        ImageIcon idic = new ImageIcon("src/com/hotelmanagement/icons/id_icon.png");
        Image idImage = idic.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon id_icon = new ImageIcon(idImage);
        IdLabel = new JLabel("Aadhaar :");
        IdLabel.setBounds(10, 328, 120, 40);
        IdLabel.setIcon(id_icon);
        add(IdLabel);
        //EmailIcon
        ImageIcon emailic = new ImageIcon("src/com/hotelmanagement/icons/email_icon.png");
        Image emailImage = emailic.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon email_icon = new ImageIcon(emailImage);
        emailLabel = new JLabel("Email :");
        emailLabel.setBounds(10, 378, 120, 40);
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
        //GenderRadioButton
        male = new JRadioButton("Male");
        male.setBounds(150,130,70,30);
        male.setBackground(Color.WHITE);
        add(male);
        female = new JRadioButton("Female");
        female.setBounds(230,130,70,30);
        female.setBackground(Color.WHITE);
        add(female);
        //DropDownField For job
        String str[] = {"Manager","HouseKeeping","Chef","Waiter/Waitress"};
        jobs = new JComboBox(str);
        add(jobs);
        //PhoneField
        phone = new JTextField();
        phone.setBackground(Color.lightGray);
        phone.setBounds(150,230,150,30);
        phone.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black,2),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        add(phone);
        //SalaryField
        Salary = new JTextField();
        Salary.setBackground(Color.lightGray);
        Salary.setBounds(150,280,150,30);
        Salary.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black,2),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        add(Salary);
        //IDField
        Aadhaar = new JTextField();
        Aadhaar.setBackground(Color.lightGray);
        Aadhaar.setBounds(150,330,150,30);
        Aadhaar.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black,2),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        add(Aadhaar);
        //EmailField
        email = new JTextField();
        email.setBackground(Color.lightGray);
        email.setBounds(150,380,150,30);
        email.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black,2),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        add(email);
        //AddBtn
        addBtn = new RoundButton("Add");
        addBtn.setBounds(160,430,110,30);
        addBtn.setBackground(Color.black);
        addBtn.setForeground(Color.ORANGE);
        addBtn.setFocusPainted(false);
        addBtn.addActionListener(this);
        add(addBtn);
        //icon at right side
        ImageIcon icon = new ImageIcon("src/com/hotelmanagement/icons/icon1.png");
        Image icn_cmp = icon.getImage().getScaledInstance(250,250,Image.SCALE_SMOOTH);
        ImageIcon loginIcon = new ImageIcon(icn_cmp);
        JLabel loginLabel = new JLabel(loginIcon);
        loginLabel.setBounds(400,70,250,250);
        add(loginLabel);
        jLabel = new JLabel("Add Employee Details");
        jLabel.setForeground(Color.BLUE);
        jLabel.setBounds(200,40,30,10);
        jLabel.setFont(new Font("Tahoma", Font.PLAIN,30));
        add(jLabel);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String Name = name.getText();
        String age = Age.getText();
        String salary = Salary.getText();
        String Phone = phone.getText();
        String Id = Aadhaar.getText();
        String Email = email.getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }else if(female.isSelected()){
            gender = "Female";
        }
        String job = jobs.getSelectedItem().toString();
        DatabaseConnection databaseConnection = new DatabaseConnection();
        String str = "insert into employee values('"+Name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+Phone+"','"+Id+"','"+Email+"')";
        try{
            databaseConnection.statement.executeUpdate(str);
            JOptionPane.showMessageDialog(null,"New Employee Added");
            this.setVisible(false);
        }catch (Exception exception){}

    }
    public static void main(String[] args) {
        new AddEmployee().setVisible(true);
    }


}
