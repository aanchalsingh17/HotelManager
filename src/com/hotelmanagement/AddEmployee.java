package com.hotelmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.Map;

public class AddEmployee extends JFrame implements ActionListener {
    JTextField name,Age,Salary,email,Aadhaar,phone;
    JRadioButton male,female;
    JComboBox jobs;
    AddEmployee() {
        JLabel nameLabel,ageLabel,genderLabel,jobLabel,salaryLabel,IdLabel,emailLabel,phoneLabel;

        RoundButton addBtn;
        getContentPane().setBackground(Color.WHITE);
        this.setLayout(null);
        this.setSize(800,500);
        this.setLocationRelativeTo(null );      // To set window location centred
        this.setTitle("Add Employee");
        this.setResizable(false);
        ImageIcon imageIcon = new ImageIcon("src/com/hotelmanagement/icons/backgr.jpeg");
        Image image1 = imageIcon.getImage().getScaledInstance(800, 500, Image.SCALE_SMOOTH);
        ImageIcon image_icon = new ImageIcon(image1);
        JLabel background = new JLabel(image_icon);
        background.setBounds(0, 0, 800, 500);
        this.add(background);

        //NameIcon
        ImageIcon ic = new ImageIcon("src/com/hotelmanagement/icons/user_icon.png");
        Image login = ic.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon user_icon = new ImageIcon(login);
        nameLabel = new JLabel("Name :");
        nameLabel.setBounds(15, 28, 120, 40);
        nameLabel.setIcon(user_icon);
        background.add(nameLabel);
        //AgeIcon
        ImageIcon ageic = new ImageIcon("src/com/hotelmanagement/icons/icon_age1.jpeg");
        Image image = ageic.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon age_icon = new ImageIcon(image);
        ageLabel = new JLabel("Age :");
        ageLabel.setBounds(15, 78, 120, 40);
        ageLabel.setIcon(age_icon);
        background.add(ageLabel);
        //GenderIcon
        ImageIcon genderic = new ImageIcon("src/com/hotelmanagement/icons/gender_icon.png");
        Image genderImage = genderic.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon gender_icon = new ImageIcon(genderImage);
        genderLabel = new JLabel("Gender :");
        genderLabel.setBounds(15, 128, 120, 40);
        genderLabel.setIcon(gender_icon);
        background.add(genderLabel);
        //JobIcon
        ImageIcon jobic = new ImageIcon("src/com/hotelmanagement/icons/jobs_icon.png");
        Image jobImage = jobic.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon job_icon = new ImageIcon(jobImage);
        jobLabel = new JLabel("Job :");
        jobLabel.setBounds(15, 178, 120, 40);
        jobLabel.setIcon(job_icon);
        background.add(jobLabel);
        //PhoneIcon
        ImageIcon phoneic = new ImageIcon("src/com/hotelmanagement/icons/phone_icon.png");
        Image phoneImage = phoneic.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon phone_icon = new ImageIcon(phoneImage);
        phoneLabel = new JLabel("Phone :");
        phoneLabel.setBounds(15, 228, 120, 40);
        phoneLabel.setIcon(phone_icon);
        background.add(phoneLabel);
        //SalaryIcon
        ImageIcon salaryic = new ImageIcon("src/com/hotelmanagement/icons/salary_icon.png");
        Image salaryImage = salaryic.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon salary_icon = new ImageIcon(salaryImage);
        salaryLabel = new JLabel("Salary :");
        salaryLabel.setBounds(15, 278, 120, 40);
        salaryLabel.setIcon(salary_icon);
        background.add(salaryLabel);
        //IDIcon
        ImageIcon idic = new ImageIcon("src/com/hotelmanagement/icons/id_icon.png");
        Image idImage = idic.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon id_icon = new ImageIcon(idImage);
        IdLabel = new JLabel("Aadhaar :");
        IdLabel.setBounds(15, 328, 120, 40);
        IdLabel.setIcon(id_icon);
        background.add(IdLabel);
        //EmailIcon
        ImageIcon emailic = new ImageIcon("src/com/hotelmanagement/icons/email_icon.png");
        Image emailImage = emailic.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon email_icon = new ImageIcon(emailImage);
        emailLabel = new JLabel("Email :");
        emailLabel.setBounds(15, 378, 120, 40);
        emailLabel.setIcon(email_icon);
        background.add(emailLabel);
        //Name TextField
        name = new JTextField();
        name.setBackground(Color.lightGray);
        name.setBounds(150,30,150,30);
        name.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black,2),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        background.add(name);
        //AgeField
        Age = new JTextField();
        Age.setBackground(Color.lightGray);
        Age.setBounds(150,80,150,30);
        Age.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black,2),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        background.add(Age);
        //GenderRadioButton
        male = new JRadioButton("Male");
        male.setBounds(150,130,70,30);
        male.setBackground(Color.WHITE);
        background.add(male);
        female = new JRadioButton("Female");
        female.setBounds(220,130,90,30);
        female.setBackground(Color.WHITE);
        background.add(female);
        //Grouping of radio buttons
        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);
        //DropDownField For job
        String str[] = {"Manager","HouseKeeping","Chef","Waiter/Waitress"};
        jobs = new JComboBox(str);
        background.add(jobs);
        //PhoneField
        phone = new JTextField();
        phone.setBackground(Color.lightGray);
        phone.setBounds(150,230,150,30);
        phone.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black,2),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        background.add(phone);
        //SalaryField
        Salary = new JTextField();
        Salary.setBackground(Color.lightGray);
        Salary.setBounds(150,280,150,30);
        Salary.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black,2),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        background.add(Salary);
        //IDField
        Aadhaar = new JTextField();
        Aadhaar.setBackground(Color.lightGray);
        Aadhaar.setBounds(150,330,150,30);
        Aadhaar.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black,2),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        background.add(Aadhaar);
        //EmailField
        email = new JTextField();
        email.setBackground(Color.lightGray);
        email.setBounds(150,380,150,30);
        email.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black,2),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        background.add(email);
        //AddBtn
        addBtn = new RoundButton("Add");
        addBtn.setBounds(170,430,110,30);
        addBtn.setBackground(Color.black);
        addBtn.setForeground(Color.ORANGE);
        addBtn.setFocusPainted(false);
        addBtn.addActionListener(this);
        background.add(addBtn);
        //icon at right side
        ImageIcon icon = new ImageIcon("src/com/hotelmanagement/icons/icon.jpg");
        Image icn_cmp = icon.getImage().getScaledInstance(300,300,Image.SCALE_SMOOTH);
        ImageIcon loginIcon = new ImageIcon(icn_cmp);
        JLabel loginLabel = new JLabel(loginIcon);
        loginLabel.setBounds(400,90,300,300);
        background.add(loginLabel);
        //Adding  a label above the right corner icon
        JLabel appName = new JLabel("Add Employee Details");
        appName.setBounds(400, 40, 250, 20);
        appName.setForeground(Color.BLUE);
        appName.setFont(new Font("SansSerif", 1, 20));
        Font font = appName.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_LOW_TWO_PIXEL);
        appName.setFont(font.deriveFont(attributes));
        background.add(appName);
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
