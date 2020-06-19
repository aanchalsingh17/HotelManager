package com.hotelmanagement;

import sun.java2d.pipe.AAShapePipe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.sql.ResultSet;
import java.util.Locale;
import java.util.Map;

public class NewCustomer extends JFrame implements ActionListener{
JTextField Aadhaar,name,depositField,costField;
JRadioButton male,female,yes,no;
JComboBox Id, countryCombo, bedCombo;
JComboBox Allocated;
RoundButton addBtn,cancelBtn;
    NewCustomer(){
        JLabel IdLabel,NumberLabel,genderLabel,nameLabel,bedLabel,countryLabel,allotLabel,checkLabel,Deposit,costLabel;

        ImageIcon imageIcon = new ImageIcon("src/com/hotelmanagement/icons/backgr.jpeg");
        Image image1 = imageIcon.getImage().getScaledInstance(1000, 650, Image.SCALE_SMOOTH);
        ImageIcon image_icon = new ImageIcon(image1);
        JLabel background = new JLabel(image_icon);
        background.setBounds(0, 0, 1000, 650);
        this.add(background);

        //  Heading
        JLabel appName = new JLabel("Add Customer Details");
        appName.setBounds(221, 10, 310, 30);
        appName.setFont(new Font("Tahoma", Font.BOLD ,25));
        Font font = appName.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_LOW_TWO_PIXEL);
        appName.setFont(font.deriveFont(attributes));
        background.add(appName);

        //IDIcon
        ImageIcon idic = new ImageIcon("src/com/hotelmanagement/icons/id_icon.png");
        Image idImage = idic.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon id_icon = new ImageIcon(idImage);
        IdLabel = new JLabel("ID :");
        IdLabel.setBounds(15, 54, 155, 40);
        IdLabel.setIcon(id_icon);
        background.add(IdLabel);

        String str[]={"Aadhaar","Pan Card","Driving Licence","College Id","Company Id","Voter Id","Passport"};
        Id = new JComboBox(str);
        Id.setBounds(240,58,150,30);
        Id.setBorder(BorderFactory.createLineBorder(Color.black,1));
        Id.setBackground(Color.WHITE);
        background.add(Id);


        ImageIcon nic = new ImageIcon("src/com/hotelmanagement/icons/id_icon.png");
        Image nImage = nic.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon n_icon = new ImageIcon(nImage);
        NumberLabel = new JLabel("ID Number :");
        NumberLabel.setBounds(15, 104, 180, 40);
        NumberLabel.setIcon(n_icon);
        background.add(NumberLabel);

        //IDField
        Aadhaar = new JTextField();
        Aadhaar.setBackground(Color.white);
        Aadhaar.setBounds(240,108,150,30);
        Aadhaar.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black,2),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        background.add(Aadhaar);

        //NameIcon
        ImageIcon ic = new ImageIcon("src/com/hotelmanagement/icons/user_icon.png");
        Image login = ic.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon user_icon = new ImageIcon(login);
        nameLabel = new JLabel("Name :");
        nameLabel.setBounds(15, 154, 155, 40);
        nameLabel.setIcon(user_icon);
        background.add(nameLabel);

        //Name TextField
        name = new JTextField();
        name.setBackground(Color.white);
        name.setBounds(240,158,150,30);
        name.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black,2),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        background.add(name);

        //GenderIcon
        ImageIcon genderic = new ImageIcon("src/com/hotelmanagement/icons/gender_icon.png");
        Image genderImage = genderic.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon gender_icon = new ImageIcon(genderImage);
        genderLabel = new JLabel("Gender :");
        genderLabel.setBounds(15, 204, 155, 40);
        genderLabel.setIcon(gender_icon);
        background.add(genderLabel);

        //GenderRadioButton
        male = new JRadioButton("Male");
        male.setBounds(240,208,70,30);
        male.setOpaque(false);
        background.add(male);
        female = new JRadioButton("Female");
        female.setBounds(320,208,90,30);
        female.setOpaque(false);
        background.add(female);
        //Grouping of radio buttons
        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);

        //CountryIcon
        ImageIcon countryc = new ImageIcon("src/com/hotelmanagement/icons/user_icon.png");
        Image country = countryc.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon country_icon = new ImageIcon(country);
        countryLabel = new JLabel("Country :");
        countryLabel.setBounds(15, 254, 155, 40);
        countryLabel.setIcon(country_icon);
        background.add(countryLabel);



        String[] countries = new String[Locale.getISOCountries().length];
        String[] countryCodes = Locale.getISOCountries();
        for (int i = 0; i < countryCodes.length; i++) {
            Locale obj = new Locale("", countryCodes[i]);
            countries[i] = obj.getDisplayCountry();
        }

        countryCombo = new JComboBox(countries);
        countryCombo.setBounds(240,258,150,30);
        countryCombo.setBorder(BorderFactory.createLineBorder(Color.black,1));
        countryCombo.setBackground(Color.WHITE);
        background.add(countryCombo);



        //BedType
        ImageIcon bed = new ImageIcon("src/com/hotelmanagement/icons/bed_icon.png");
        Image bedi = bed.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon bedd = new ImageIcon(bedi);
        bedLabel = new JLabel("Bed Type :");
        bedLabel.setBounds(15, 304, 155, 40);
        bedLabel.setIcon(bedd);
        background.add(bedLabel);


        bedCombo = new JComboBox(new String[]{"All", "Single Bed", "Double Bed"});
        bedCombo.setBounds(240,308,150,30);
        bedCombo.setBorder(BorderFactory.createLineBorder(Color.black,1));
        bedCombo.setBackground(Color.WHITE);
        bedCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str;
                if(bedCombo.getSelectedItem().equals("All")){
                    str = "select * from room where available = \"Available\" and clean = \"Clean\"";
                }else{
                    str = "select * from room where available = \"Available\" and clean = \"Clean\" and bed_type = \"" + bedCombo.getSelectedItem() +"\"";
                }
                try{
                    Allocated.removeAllItems();
                    DatabaseConnection databaseConnection = new DatabaseConnection();
                    ResultSet resultSet = databaseConnection.statement.executeQuery(str);
                    while(resultSet.next()) {
                        Allocated.addItem(resultSet.getString("room_number"));
                    }
                }catch (Exception exc){
                    exc.printStackTrace();
                }
            }
        });
        background.add(bedCombo);

        //AllocatedIcon
        ImageIcon allotic = new ImageIcon("src/com/hotelmanagement/icons/roomNo_icon.png");
        Image allot = allotic.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon allot_icon = new ImageIcon(allot);
        allotLabel = new JLabel("Allocated Room Number :");
        allotLabel.setBounds(15, 354, 220, 40);
        allotLabel.setIcon(allot_icon);
        background.add(allotLabel);

        Allocated = new JComboBox();
        try{
            DatabaseConnection databaseConnection = new DatabaseConnection();
            String string = "select * from room where available = \"Available\" and clean = \"Clean\"";
            ResultSet resultSet = databaseConnection.statement.executeQuery(string);
            while(resultSet.next()) {
                Allocated.addItem(resultSet.getString("room_number"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        Allocated.setBounds(240,358,150,30);
        Allocated.setBorder(BorderFactory.createLineBorder(Color.black,1));
        Allocated.setBackground(Color.WHITE);
        Allocated.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    DatabaseConnection databaseConnection = new DatabaseConnection();
                    String string = "select price from room where room_number = \"" + Allocated.getSelectedItem() + "\"";
                    ResultSet resultSet = databaseConnection.statement.executeQuery(string);
                    while(resultSet.next()) {
                        costField.setText("\u20B9  " + resultSet.getString("price"));
                    }
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        background.add(Allocated);


        //CheckIcon
        ImageIcon checkic = new ImageIcon("src/com/hotelmanagement/icons/tick_icon.png");
        Image check = checkic.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon check_icon = new ImageIcon(check);
        checkLabel = new JLabel("CheckIn :");
        checkLabel.setBounds(15, 404, 150, 40);
        checkLabel.setIcon(check_icon);
        background.add(checkLabel);

        //CheckInRadioButton
        yes = new JRadioButton("Yes");
        yes.setBounds(240,408,70,30);
        yes.setOpaque(false);
        background.add(yes);
        no = new JRadioButton("No");
        no.setBounds(320,408,90,30);
        no.setOpaque(false);
        background.add(no);
        //Grouping of radio buttons
        ButtonGroup group1 = new ButtonGroup();
        group1.add(yes);
        group1.add(no);


        //Priceicon
        ImageIcon priceic = new ImageIcon("src/com/hotelmanagement/icons/salary_icon.png");
        Image price = priceic.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon price_icon = new ImageIcon(price);
        costLabel = new JLabel("Room Price :");
        costLabel.setBounds(15, 454, 155, 40);
        costLabel.setIcon(price_icon);
        background.add(costLabel);

        //PriceTextField
        costField = new JTextField();
        costField.setBackground(Color.white);
        costField.setBounds(240,458,150,30);
        costField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black,2),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        costField.setText("\u20B9 ");
        costField.setEditable(false);
        background.add(costField);


        //DepositIcon
        ImageIcon depositic = new ImageIcon("src/com/hotelmanagement/icons/price_icon.png");
        Image deposit = depositic.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon deposit_icon = new ImageIcon(deposit);
        Deposit = new JLabel("Deposit :");
        Deposit.setBounds(15, 504, 155, 40);
        Deposit.setIcon(deposit_icon);
        background.add(Deposit);

        //DepositTextField
         depositField = new JTextField();
        depositField.setBackground(Color.white);
        depositField.setBounds(240,508,150,30);
        depositField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black,2),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        background.add(depositField);


        //RightSideImage

        ImageIcon icon = new ImageIcon("src/com/hotelmanagement/icons/checkin.png");
        Image icn_cmp = icon.getImage().getScaledInstance(450,450,Image.SCALE_SMOOTH);
        ImageIcon loginIcon = new ImageIcon(icn_cmp);
        JLabel loginLabel = new JLabel(loginIcon);
        loginLabel.setBounds(430,80,450,450);
        background.add(loginLabel);


        //AddBtn
                addBtn = new RoundButton("Add");
        addBtn.setBounds(70,570,120,30);
        addBtn.setBackground(Color.black);
        addBtn.setForeground(Color.ORANGE);
        addBtn.addActionListener(this);
        background.add(addBtn);

        cancelBtn = new RoundButton("CANCEL");
        cancelBtn.setBounds(235,570,120,30);
        cancelBtn.setForeground(Color.ORANGE);
        cancelBtn.setBackground(Color.black);
        cancelBtn.addActionListener(this);
        background.add(cancelBtn);

        this.setLayout(null);
        this.setSize(900,650);
        this.setLocationRelativeTo(null );      // To set window location centred
        this.setTitle("Add Customer");
        this.setResizable(false);
        setVisible(true);


    }
    public static void main(String[] args) {
        new NewCustomer().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==cancelBtn){
            this.setVisible(false);
            new Reception().setVisible(true);
        }else if(e.getSource()==addBtn){
            if (Aadhaar.getText().equals("")) {
                JOptionPane.showMessageDialog(Aadhaar, "Please specify id number", "Warning", JOptionPane.ERROR_MESSAGE);
            }else if(name.getText().equals("")) {
                JOptionPane.showMessageDialog(name, "Please specify name","Warning",JOptionPane.ERROR_MESSAGE);
            }else if(!male.isSelected() && !female.isSelected()){
                JOptionPane.showMessageDialog(male, "Please specify gender","Warning",JOptionPane.ERROR_MESSAGE);
            } else if(!yes.isSelected()&&!no.isSelected()){
                JOptionPane.showMessageDialog(yes, "Please specify check-in","Warning",JOptionPane.ERROR_MESSAGE);
            }else if(depositField.getText().equals("")){
                JOptionPane.showMessageDialog(depositField, "Please fill Deposit","Warning",JOptionPane.ERROR_MESSAGE);
            }else {
                String id = Id.getSelectedItem().toString();
                String idNumber = Aadhaar.getText();
                String Name = name.getText();
                String Gender = null;
                if (male.isSelected()) {
                    Gender = "Male";
                } else if (female.isSelected()) {
                    Gender = "Female";
                }
                String country = (String)countryCombo.getSelectedItem();
                String roomNo = Allocated.getSelectedItem().toString();
                String Check = null;
                if (yes.isSelected()) {
                    Check = "Yes";
                } else if (no.isSelected()) {
                    Check = "No";
                }
                String price = depositField.getText();
                DatabaseConnection databaseConnection = new DatabaseConnection();
                //  To create table dynamically
                String sqlCreate = "CREATE TABLE IF NOT EXISTS customer"
                        + "  (id            VARCHAR(30),"
                        + "   idnumber            VARCHAR(20),"
                        + "   name          VARCHAR(30),"
                        + "   gender            VARCHAR(10),"
                        + "   country           VARCHAR(20),"
                        + "   room_number         VARCHAR(15),"
                        + "   checkin          VARCHAR(15),"
                        + "   deposit           VARCHAR(30))";

                String str = "insert into customer values('"+id+"','"+idNumber+"','"+Name+"','"+Gender+"','"+country+"','"+roomNo+"','"+Check+"','"+price+"')";
                //  Query to make the booked room occupied
                String str2 = "update room set available = \"Occupied\" where room_number = \"" + roomNo +"\"";
                try{
                    databaseConnection.statement.executeUpdate(sqlCreate);
                    databaseConnection.statement.executeUpdate(str);
                    databaseConnection.statement.executeUpdate(str2);
                    JOptionPane.showMessageDialog(null,"New Customer Added");
                }catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Error Occurred. Try again");
                    exception.printStackTrace();
                }finally {
                    this.setVisible(false);
                    new Reception().setVisible(true);
                }
            }
        }

    }
}
