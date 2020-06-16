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
    JProgressBar progressBar;
    RoundButton addBtn, cancelBtn;


    AddEmployee() {
        JLabel nameLabel,ageLabel,genderLabel,jobLabel,salaryLabel,IdLabel,emailLabel,phoneLabel;



        ImageIcon imageIcon = new ImageIcon("src/com/hotelmanagement/icons/backgr.jpeg");
        Image image1 = imageIcon.getImage().getScaledInstance(800, 550, Image.SCALE_SMOOTH);
        ImageIcon image_icon = new ImageIcon(image1);
        JLabel background = new JLabel(image_icon);
        background.setBounds(0, 0, 800, 550);
        this.add(background);


        //  Heading
        JLabel appName = new JLabel("Add Employee Details");
        appName.setBounds(221, 10, 310, 30);
        appName.setFont(new Font("Tahoma", Font.BOLD ,25));
        Font font = appName.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_LOW_TWO_PIXEL);
        appName.setFont(font.deriveFont(attributes));
        background.add(appName);



        //NameIcon
        ImageIcon ic = new ImageIcon("src/com/hotelmanagement/icons/user_icon.png");
        Image login = ic.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon user_icon = new ImageIcon(login);
        nameLabel = new JLabel("Name :");
        nameLabel.setBounds(15, 48, 155, 40);
        nameLabel.setIcon(user_icon);
        background.add(nameLabel);

        //Name TextField
        name = new JTextField();
        name.setBackground(Color.white);
        name.setBounds(180,50,150,30);
        name.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black,2),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        background.add(name);



        //AgeIcon
        ImageIcon ageic = new ImageIcon("src/com/hotelmanagement/icons/age_icon.png");
        Image image = ageic.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon age_icon = new ImageIcon(image);
        ageLabel = new JLabel("Age :");
        ageLabel.setBounds(15, 98, 155, 40);
        ageLabel.setIcon(age_icon);
        background.add(ageLabel);

        //AgeField
        Age = new JTextField();
        Age.setBackground(Color.white);
        Age.setBounds(180,100,150,30);
        Age.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black,2),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        background.add(Age);



        //GenderIcon
        ImageIcon genderic = new ImageIcon("src/com/hotelmanagement/icons/gender_icon.png");
        Image genderImage = genderic.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon gender_icon = new ImageIcon(genderImage);
        genderLabel = new JLabel("Gender :");
        genderLabel.setBounds(15, 148, 155, 40);
        genderLabel.setIcon(gender_icon);
        background.add(genderLabel);

        //GenderRadioButton
        male = new JRadioButton("Male");
        male.setBounds(180,150,70,30);
        male.setOpaque(false);
        background.add(male);
        female = new JRadioButton("Female");
        female.setBounds(250,150,90,30);
        female.setOpaque(false);
        background.add(female);
        //Grouping of radio buttons
        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);



        //JobIcon
        ImageIcon jobic = new ImageIcon("src/com/hotelmanagement/icons/jobs_icon.png");
        Image jobImage = jobic.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon job_icon = new ImageIcon(jobImage);
        jobLabel = new JLabel("Job :");
        jobLabel.setBounds(15, 198, 155, 40);
        jobLabel.setIcon(job_icon);
        background.add(jobLabel);

        //DropDownField For job
        String str[] = {"Manager","HouseKeeping","Chef","Waiter/Waitress"};
        jobs = new JComboBox(str);
        jobs.setBounds(180,200,150,30);
        jobs.setBorder(BorderFactory.createLineBorder(Color.black,1));
        jobs.setBackground(Color.WHITE);
        background.add(jobs);



        //PhoneIcon
        ImageIcon phoneic = new ImageIcon("src/com/hotelmanagement/icons/phone_icon.png");
        Image phoneImage = phoneic.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon phone_icon = new ImageIcon(phoneImage);
        phoneLabel = new JLabel("Phone :");
        phoneLabel.setBounds(15, 248, 155, 40);
        phoneLabel.setIcon(phone_icon);
        background.add(phoneLabel);

        //PhoneField
        phone = new JTextField();
        phone.setBackground(Color.white);
        phone.setBounds(180,250,150,30);
        phone.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black,2),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        background.add(phone);



        //SalaryIcon
        ImageIcon salaryic = new ImageIcon("src/com/hotelmanagement/icons/salary_icon.png");
        Image salaryImage = salaryic.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon salary_icon = new ImageIcon(salaryImage);
        salaryLabel = new JLabel("Salary :");
        salaryLabel.setBounds(15, 298, 155, 40);
        salaryLabel.setIcon(salary_icon);
        background.add(salaryLabel);

        //SalaryField
        Salary = new JTextField();
        Salary.setBackground(Color.white);
        Salary.setBounds(180,300,150,30);
        Salary.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black,2),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        background.add(Salary);



        //IDIcon
        ImageIcon idic = new ImageIcon("src/com/hotelmanagement/icons/id_icon.png");
        Image idImage = idic.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon id_icon = new ImageIcon(idImage);
        IdLabel = new JLabel("Aadhaar :");
        IdLabel.setBounds(15, 348, 155, 40);
        IdLabel.setIcon(id_icon);
        background.add(IdLabel);

        //IDField
        Aadhaar = new JTextField();
        Aadhaar.setBackground(Color.white);
        Aadhaar.setBounds(180,350,150,30);
        Aadhaar.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black,2),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        background.add(Aadhaar);



        //EmailIcon
        ImageIcon emailic = new ImageIcon("src/com/hotelmanagement/icons/email_icon.png");
        Image emailImage = emailic.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon email_icon = new ImageIcon(emailImage);
        emailLabel = new JLabel("Email :");
        emailLabel.setBounds(15, 398, 155, 40);
        emailLabel.setIcon(email_icon);
        background.add(emailLabel);

        //EmailField
        email = new JTextField();
        email.setBackground(Color.white);
        email.setBounds(180,400,150,30);
        email.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black,2),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        background.add(email);



        progressBar=new JProgressBar();
        progressBar.setBounds(100,440,165,20);
        progressBar.setIndeterminate(true);
        progressBar.setVisible(false);
        background.add(progressBar);



        //AddBtn
        addBtn = new RoundButton("Add");
        addBtn.setBounds(35,470,120,30);
        addBtn.setBackground(Color.black);
        addBtn.setForeground(Color.ORANGE);
        addBtn.addActionListener(this);
        background.add(addBtn);

        cancelBtn = new RoundButton("CANCEL");
        cancelBtn.setBounds(190,470,120,30);
        cancelBtn.setForeground(Color.ORANGE);
        cancelBtn.setBackground(Color.black);
        cancelBtn.addActionListener(this);
        background.add(cancelBtn);

        //icon at right side
        ImageIcon icon = new ImageIcon("src/com/hotelmanagement/icons/icon.jpg");
        Image icn_cmp = icon.getImage().getScaledInstance(360,360,Image.SCALE_SMOOTH);
        ImageIcon loginIcon = new ImageIcon(icn_cmp);
        JLabel loginLabel = new JLabel(loginIcon);
        loginLabel.setBounds(350,50,400,400);
        background.add(loginLabel);



        this.setLayout(null);
        this.setSize(750,550);
        this.setLocationRelativeTo(null );      // To set window location centred
        this.setTitle("Add Employee");
        this.setResizable(false);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource() == addBtn){

            //  Check if all fields are filled or not
            if(name.getText().equals("")) {
                JOptionPane.showMessageDialog(name, "Please specify name","Warning",JOptionPane.ERROR_MESSAGE);
            }else if(Age.getText().equals("")){
                JOptionPane.showMessageDialog(Age, "Please specify age","Warning",JOptionPane.ERROR_MESSAGE);
            }else if(!male.isSelected() && !female.isSelected()){
                JOptionPane.showMessageDialog(male, "Please specify gender","Warning",JOptionPane.ERROR_MESSAGE);
            }else if(phone.getText().equals("")){
                JOptionPane.showMessageDialog(phone, "Please specify phone number","Warning",JOptionPane.ERROR_MESSAGE);
            }else if(Salary.getText().equals("")){
                JOptionPane.showMessageDialog(Salary, "Please specify salary","Warning",JOptionPane.ERROR_MESSAGE);
            }else if(Aadhaar.getText().equals("")){
                JOptionPane.showMessageDialog(Aadhaar, "Please specify aadhar number","Warning",JOptionPane.ERROR_MESSAGE);
            }else if(email.getText().equals("")){
                JOptionPane.showMessageDialog(email, "Please specify email-id","Warning",JOptionPane.ERROR_MESSAGE);
            }else{
                progressBar.setVisible(true);
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
                //  To create table dynamically
                String sqlCreate = "CREATE TABLE IF NOT EXISTS employee"
                        + "  (name            VARCHAR(30),"
                        + "   age             VARCHAR(10),"
                        + "   gender          VARCHAR(10),"
                        + "   job             VARCHAR(30),"
                        + "   phone           VARCHAR(15),"
                        + "   salary          VARCHAR(15),"
                        + "   aadhar          VARCHAR(15),"
                        + "   email           VARCHAR(30))";

                String str = "insert into employee values('"+Name+"','"+age+"','"+gender+"','"+job+"','"+Phone+"','"+salary+"','"+Id+"','"+Email+"')";
                try{
                    databaseConnection.statement.executeUpdate(sqlCreate);
                    databaseConnection.statement.executeUpdate(str);
                    JOptionPane.showMessageDialog(null,"New Employee Added");
                }catch (Exception exception){
                    JOptionPane.showMessageDialog(null, "Error Occurred. Try again");
                    exception.printStackTrace();
                }finally {
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
        new AddEmployee().setVisible(true);
    }


}
