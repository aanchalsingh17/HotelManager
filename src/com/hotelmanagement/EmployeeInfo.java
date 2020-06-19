package com.hotelmanagement;


import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.sql.ResultSet;
import java.util.Map;

public class EmployeeInfo  extends JFrame implements ActionListener {
    RoundButton filterBtn,backBtn;
    JTable employeeInfo;
    JComboBox jobCombo,genderCombo,AgeCombo;
    EmployeeInfo(){
        ImageIcon i1 = new ImageIcon("src/com/hotelmanagement/icons/sparkle.jpeg");
        Image b = i1.getImage().getScaledInstance(1170,600,Image.SCALE_SMOOTH);
        ImageIcon i2 = new ImageIcon(b);
        JLabel background = new JLabel(i2);
        background.setBounds(0,0,1170,600);
        add(background);




        //  email label in bottom as email can be long

        JLabel email = new JLabel("");
        email.setBounds(580,530,400,20);
        email.setFont(new Font("SansSerif", Font.BOLD ,20));
        background.add(email);

        employeeInfo = new JTable();
        employeeInfo.setBounds(0,0,1500,500);
        employeeInfo.setBorder(BorderFactory.createLineBorder(Color.black,1));
        employeeInfo.setGridColor(Color.black);
        employeeInfo.setAutoCreateRowSorter(true);
        employeeInfo.enableInputMethods(false);
        employeeInfo.setFont(new Font("Dialog",Font.BOLD,10));
        employeeInfo.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 12));
        employeeInfo.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.black,1));
        employeeInfo.getTableHeader().setPreferredSize(new Dimension(0,30));
        employeeInfo.setRowHeight(40);
        employeeInfo.setDefaultEditor(Object.class, null);
        employeeInfo.setOpaque(false);
        employeeInfo.setIntercellSpacing(new Dimension(10,15));
        //  Display selected cell data on JField at bottom
        employeeInfo.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                int row = employeeInfo.getSelectedRow();
                int column = employeeInfo.getSelectedColumn();
                email.setText((String)employeeInfo.getValueAt(row, column));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                email.setText("");
            }
        });

        //  Load all values in the first place into table
        try{
            DatabaseConnection connection = new DatabaseConnection();
            String cmd = "SELECT * FROM employee";
            ResultSet rs = connection.statement.executeQuery(cmd);

            employeeInfo.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Occurred in loading data. Try again");
            e.printStackTrace();
        }
        centerTable();


        JScrollPane scrollPane= new  JScrollPane(employeeInfo);
        scrollPane.setBounds(15,50,950,470);
        scrollPane.setPreferredSize(new Dimension(0,0 ));
        //  The two lines below are to make extra table transparent
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        background.add(scrollPane);




        JLabel jLabel = new JLabel("Employee Details");
        jLabel.setBounds(442,10,300,30);
        jLabel.setFont(new Font("Tahoma", Font.BOLD ,25));
        Font font = jLabel.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_LOW_TWO_PIXEL);
        jLabel.setFont(font.deriveFont(attributes));
        background.add(jLabel);

        jobCombo = new JComboBox(new String[] {"All" , "Manager","HouseKeeping","Chef","Waiter/Waitress"});
        jobCombo.setSelectedIndex(0);
        jobCombo.setBackground(Color.WHITE);
        jobCombo.setBorder(BorderFactory.createLineBorder(Color.black,1));
        jobCombo.setBounds(970,110,120,30);
        jobCombo.addActionListener(this);
        background.add(jobCombo);

        JLabel availLabel = new JLabel("Job");
        availLabel.setBounds(970,80,120,30);
        background.add(availLabel);

        genderCombo = new JComboBox(new String[] {"All" , "Male" , "Female"});
        genderCombo.setSelectedIndex(0);
        genderCombo.setBackground(Color.WHITE);
        genderCombo.setBorder(BorderFactory.createLineBorder(Color.black,1));
        genderCombo.setBounds(970,220,120,30);
        genderCombo.addActionListener(this);
        background.add(genderCombo);

        JLabel statusLabel = new JLabel("Gender");
        statusLabel.setBounds(970,190,120,30);
        background.add(statusLabel);

        AgeCombo = new JComboBox(new String[] {"All" , "Above 18" ,"Above 25","Above 30","Above 40","Above 50" ,"Above 60"});
        AgeCombo.setSelectedIndex(0);
        AgeCombo.setBackground(Color.WHITE);
        AgeCombo.setBorder(BorderFactory.createLineBorder(Color.black,1));
        AgeCombo.setBounds(970,330,120,30);
        AgeCombo.addActionListener(this);
        background.add(AgeCombo);

        JLabel typeLabel = new JLabel("Age");
        typeLabel.setBounds(970,300,120,30);
        background.add(typeLabel);

        //Adding filter btn
        filterBtn = new RoundButton("FILTER");
        filterBtn.setBackground(Color.black);
        filterBtn.setForeground(Color.ORANGE);
        filterBtn.setBounds(970,450,120,30);
        filterBtn.addActionListener(this);
        background.add(filterBtn);

        //Adding Back Button
        backBtn = new RoundButton("BACK");
        backBtn.setBackground(Color.black);
        backBtn.setForeground(Color.ORANGE);
        backBtn.setBounds(970,490,120,30);
        backBtn.addActionListener(this);
        background.add(backBtn);

        this.setLayout(null);
        this.setSize(1100,600);
        this.setLocationRelativeTo(null );      // To set window location centred
        this.setTitle("Employee Details");
        this.setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }
    private void centerTable() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for(int x=0;x<employeeInfo.getColumnCount();x++){
            employeeInfo.getColumnModel().getColumn(x).setCellRenderer(centerRenderer);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == backBtn){
           this.setVisible(false);
           new Reception().setVisible(true);
       }else if(e.getSource() == filterBtn){
           try {
               String cmd ;

               if((AgeCombo.getSelectedItem()).equals("All") &&
                       (jobCombo.getSelectedItem()).equals("All") &&
                       (genderCombo.getSelectedItem()).equals("All")){
                   cmd = "SELECT * FROM employee";
               }else if((AgeCombo.getSelectedItem()).equals("All") &&
                       (genderCombo.getSelectedItem()).equals("All")){
                   cmd = "SELECT * FROM employee WHERE job = \""+ jobCombo.getSelectedItem()+"\"";
               }else if((AgeCombo.getSelectedItem()).equals("All") &&
                       (jobCombo.getSelectedItem()).equals("All")) {
                   cmd = "SELECT * FROM employee WHERE gender = \"" + genderCombo.getSelectedItem() + "\"";
               }else if((genderCombo.getSelectedItem()).equals("All") &&
                       (jobCombo.getSelectedItem()).equals("All")){
                   cmd = "SELECT * FROM employee WHERE age >= \"" +getAge() + "\"";
               }else if(AgeCombo.getSelectedItem().equals("All")){
                   cmd = "SELECT * FROM employee WHERE job = \""+ jobCombo.getSelectedItem()+"\" and gender = \"" + genderCombo.getSelectedItem() + "\"";
               }else if(jobCombo.getSelectedItem().equals("All")){
                   cmd = "SELECT * FROM employee WHERE age >= \""+ getAge()+"\" and gender = \"" + genderCombo.getSelectedItem() + "\"";
               }else if(genderCombo.getSelectedItem().equals("All")){
                   cmd = "SELECT * FROM employee WHERE job = \""+ jobCombo.getSelectedItem()+"\" and age >= \"" + getAge() + "\"";
               }else{
                   cmd = "select * from employee WHERE job = \""+ jobCombo.getSelectedItem()+
                           "\" and age >= \"" + getAge() +
                           "\" and gender = \"" + genderCombo.getSelectedItem()+"\"";
               }
               DatabaseConnection databaseConnection = new DatabaseConnection();
               ResultSet resultSet = databaseConnection.statement.executeQuery(cmd);
              employeeInfo.setModel(DbUtils.resultSetToTableModel(resultSet));
              centerTable();
           }catch (Exception ae){
                ae.printStackTrace();
           }
       }
    }


    public String getAge(){
        String age;
        switch ((String)AgeCombo.getSelectedItem()) {
            case "Above 18":
                age = "18";
                break;
            case "Above 25":
                age = "25";
                break;
            case "Above 30":
                age = "30";
                break;
            case "Above 40":
                age = "40";
                break;
            case "Above 50":
                age = "50";
                break;
            default:
                age = "60";
                break;
        }
        return age;
    }
    public static void main(String[] args) {
        new EmployeeInfo().setVisible(true);
    }


}
