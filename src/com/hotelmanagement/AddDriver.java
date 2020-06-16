package com.hotelmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.Map;

public class AddDriver extends JFrame implements ActionListener {
    JTextField name,Age,carCategory,carModel,location;
    JRadioButton male,female;
    JComboBox Availability,gender;
    JProgressBar progressBar;
    RoundButton addBtn,cancelBtn;
    AddDriver(){
        JLabel nameLabel,ageLabel,carcategoryLabel,carModelLabel,locationLabel,genderLabel,AvailabilityLabel;
        getContentPane().setBackground(Color.WHITE);
        this.setLayout(null);
        this.setSize(800,500);
        this.setLocationRelativeTo(null );      // To set window location centred
        this.setTitle("Add Driver");
        this.setResizable(false);
        ImageIcon imageIcon = new ImageIcon("src/com/hotelmanagement/icons/background.jpeg");
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
        name = new JTextField();
        name.setBackground(Color.WHITE);
        name.setBounds(180,30,150,30);
        name.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black,2),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        background.add(name);
        //AgeIcon
        ImageIcon ageic = new ImageIcon("src/com/hotelmanagement/icons/age_icon.png");
        Image image = ageic.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon age_icon = new ImageIcon(image);
        ageLabel = new JLabel("Age :");
        ageLabel.setBounds(15, 78, 120, 40);
        ageLabel.setIcon(age_icon);
        background.add(ageLabel);
        //AgeField
        Age = new JTextField();
        Age.setBackground(Color.WHITE);
        Age.setBounds(180,80,150,30);
        Age.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black,2),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        background.add(Age);
        //GenderIcon
        ImageIcon genderic = new ImageIcon("src/com/hotelmanagement/icons/gender_icon.png");
        Image genderImage = genderic.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon gender_icon = new ImageIcon(genderImage);
        genderLabel = new JLabel("Gender :");
        genderLabel.setBounds(15, 128, 120, 40);
        genderLabel.setIcon(gender_icon);
        background.add(genderLabel);
        //GenderRadioButton
       /* male = new JRadioButton("Male");
        male.setBounds(180,130,70,30);
        male.setBackground(Color.WHITE);
        background.add(male);
        female = new JRadioButton("Female");
        female.setBounds(250,130,80,30);
        female.setBackground(Color.WHITE);
        background.add(female);
        //Grouping of radio buttons
        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);*/
        gender = new JComboBox(new String[] {"Male", "Female"});
        gender.setSelectedIndex(0);
        gender.setBackground(Color.WHITE);
        gender.setBorder(BorderFactory.createLineBorder(Color.black,1));
        gender.setBounds(180,130,150,30);
        background.add(gender);
        //CarCategory
        ImageIcon caric = new ImageIcon("src/com/hotelmanagement/icons/gender_icon.png");
        Image carImage = caric.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon car_icon = new ImageIcon(carImage);
        carcategoryLabel = new JLabel("Car Category :");
        carcategoryLabel.setBounds(15, 178, 180, 40);
        carcategoryLabel.setIcon(car_icon);
        background.add(carcategoryLabel);
        carCategory = new JTextField();
        carCategory.setBackground(Color.WHITE);
        carCategory.setBounds(180,180,150,30);
        carCategory.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black,2),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        background.add(carCategory);
        //carModel
        ImageIcon modelic = new ImageIcon("src/com/hotelmanagement/icons/gender_icon.png");
        Image modelImage = modelic.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon model_icon = new ImageIcon(modelImage);
        carModelLabel = new JLabel("Car Model :");
        carModelLabel.setBounds(15, 228, 120, 40);
        carModelLabel.setIcon(model_icon);
        background.add(carModelLabel);
        carModel = new JTextField();
        carModel.setBackground(Color.WHITE);
        carModel.setBounds(180,230,150,30);
        carModel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black,2),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        background.add(carModel);
        //Availability
        ImageIcon availableic = new ImageIcon("src/com/hotelmanagement/icons/gender_icon.png");
        Image availableImage = availableic.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon available_icon = new ImageIcon(availableImage);
        AvailabilityLabel = new JLabel("Availability :");
        AvailabilityLabel.setBounds(15, 278, 120, 40);
        AvailabilityLabel.setIcon(available_icon);
        background.add(AvailabilityLabel);
        Availability = new JComboBox(new String[] {"Available", "Unavailable"});
        Availability.setSelectedIndex(0);
        Availability.setBackground(Color.WHITE);
        Availability.setBorder(BorderFactory.createLineBorder(Color.black,1));
        Availability.setBounds(180,280,150,30);
        background.add(Availability);
        //Location
        ImageIcon locationic = new ImageIcon("src/com/hotelmanagement/icons/location.jpeg");
        Image locationImage = locationic.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon location_icon = new ImageIcon(locationImage);
        locationLabel = new JLabel("Location :");
        locationLabel.setBounds(15, 328, 120, 40);
        locationLabel.setIcon(location_icon);
        background.add(locationLabel);
        //location field
        location = new JTextField();
        location.setBackground(Color.WHITE);
        location.setBounds(180,330,150,30);
        location.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black,2),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        background.add(location);
        progressBar=new JProgressBar();
        progressBar.setBounds(100,360,170,20);
        progressBar.setIndeterminate(true);
        progressBar.setVisible(false);
        background.add(progressBar);
        addBtn = new RoundButton("ADD DRIVER");
        addBtn.setBounds(50,405,120,30);
        addBtn.setForeground(Color.ORANGE);
        addBtn.setBackground(Color.black);
        addBtn.addActionListener(this);
        background.add(addBtn);

        cancelBtn = new RoundButton("CANCEL");
        cancelBtn.setBounds(205,405,120,30);
        cancelBtn.setForeground(Color.ORANGE);
        cancelBtn.setBackground(Color.black);
        cancelBtn.addActionListener(this);
        background.add(cancelBtn);
        JLabel jLabel = new JLabel("Add Driver Details");
        jLabel.setBounds(390,20,350,30);
        jLabel.setFont(new Font("Tahoma", Font.BOLD ,25));
        Font font = jLabel.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_LOW_TWO_PIXEL);
        jLabel.setFont(font.deriveFont(attributes));
        background.add(jLabel);
        ImageIcon icon = new ImageIcon("src/com/hotelmanagement/icons/driver.jpeg");
        Image icn_cmp = icon.getImage().getScaledInstance(360,360,Image.SCALE_SMOOTH);
        ImageIcon loginIcon = new ImageIcon(icn_cmp);
        JLabel loginLabel = new JLabel(loginIcon);
        loginLabel.setBounds(350,50,400,400);
        background.add(loginLabel);
       this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addBtn) {
            if (name.getText().equals("")) {
                JOptionPane.showMessageDialog(name, "Please specify name", "Warning", JOptionPane.ERROR_MESSAGE);
            }/*else if(!male.isSelected() && !female.isSelected()) {
                JOptionPane.showMessageDialog(male, "Please specify gender", "Warning", JOptionPane.ERROR_MESSAGE);
            }*/
            else if (Age.getText().equals("")) {
                JOptionPane.showMessageDialog(Age, "Please specify age", "Warning", JOptionPane.ERROR_MESSAGE);
            } else if (carCategory.getText().equals("")) {
                JOptionPane.showMessageDialog(Age, "Please specify carCategory", "Warning", JOptionPane.ERROR_MESSAGE);
            } else if (carModel.getText().equals("")) {
                JOptionPane.showMessageDialog(Age, "Please specify carModel", "Warning", JOptionPane.ERROR_MESSAGE);
            } else if (location.getText().equals("")) {
                JOptionPane.showMessageDialog(Age, "Please specify location", "Warning", JOptionPane.ERROR_MESSAGE);
            } else {
                progressBar.setVisible(true);
                String Name = name.getText();
                String age = Age.getText();
                String carcategory = carCategory.getText();
                String carmodel = carModel.getText();
                String Location = location.getText();
             /*   String gender = null;
                if(male.isSelected()){
                    gender = "Male";
                }else if(female.isSelected()){
                    gender = "Female";
                }*/
                String Gender = gender.getSelectedItem().toString();
                String available = Availability.getSelectedItem().toString();
                DatabaseConnection databaseConnection = new DatabaseConnection();
                //  To create table dynamically
                String sqlCreate = "CREATE TABLE IF NOT EXISTS driver"
                        + "  (name            VARCHAR(30),"
                        + "   age             VARCHAR(10),"
                        + "   gender          VARCHAR(10),"
                        + "   availability            VARCHAR(30),"
                        + "   carcategory          VARCHAR(15),"
                        + "   carmodel         VARCHAR(15),"
                        + "   location          VARCHAR(30))";

                String str = "insert into driver values('"+Name+"','"+age+"','"+Gender+"','"+available+"','"+carcategory+"','"+carmodel+"','"+Location+"')";
                try{
                    databaseConnection.statement.executeUpdate(sqlCreate);
                    databaseConnection.statement.executeUpdate(str);
                    JOptionPane.showMessageDialog(null,"New Driver Added");
                }catch (Exception exception){
                    JOptionPane.showMessageDialog(null, "Error Occurred. Try again");
                    exception.printStackTrace();
                }finally {
                    progressBar.setVisible(false);
                    this.setVisible(false);
                }


            }
        } else if (ae.getSource() == cancelBtn) {
            this.setVisible(false);
        }
    }




    public static void main(String[] args) {
        new AddDriver().setVisible(true);
    }


}
