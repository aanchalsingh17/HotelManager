package com.hotelmanagement;


import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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


        employeeInfo = new JTable();
        employeeInfo.setBounds(0,0,1000,500);
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

        JScrollPane scrollPane= new  JScrollPane(employeeInfo);
        scrollPane.setBounds(15,50,800,500);
        scrollPane.setPreferredSize(new Dimension(0,0 ));
        //  The two lines below are to make extra table transparent
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        background.add(scrollPane);

        //Initially loading all the data
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            String str = "select * from employee";
            ResultSet resultSet = databaseConnection.statement.executeQuery(str);
            employeeInfo.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception ae){
            JOptionPane.showMessageDialog(null,"Error Occurred in loading the data");
            ae.printStackTrace();
        }

        JLabel jLabel = new JLabel("Employee Details");
        jLabel.setBounds(272,10,300,30);
        jLabel.setFont(new Font("Tahoma", Font.BOLD ,25));
        Font font = jLabel.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_LOW_TWO_PIXEL);
        jLabel.setFont(font.deriveFont(attributes));
        background.add(jLabel);

        jobCombo = new JComboBox(new String[] {"All" , "Manager"});
        jobCombo.setSelectedIndex(0);
        jobCombo.setBackground(Color.WHITE);
        jobCombo.setBorder(BorderFactory.createLineBorder(Color.black,1));
        jobCombo.setBounds(850,110,120,30);
        background.add(jobCombo);

        JLabel availLabel = new JLabel("Job");
        availLabel.setBounds(850,80,120,30);
        background.add(availLabel);

        genderCombo = new JComboBox(new String[] {"All" , "Male" , "Female"});
        genderCombo.setSelectedIndex(0);
        genderCombo.setBackground(Color.WHITE);
        genderCombo.setBorder(BorderFactory.createLineBorder(Color.black,1));
        genderCombo.setBounds(850,220,120,30);
        background.add(genderCombo);

        JLabel statusLabel = new JLabel("Gender");
        statusLabel.setBounds(850,190,120,30);
        background.add(statusLabel);

        AgeCombo = new JComboBox(new String[] {"All" , "Above 20" , "Above 40"});
        AgeCombo.setSelectedIndex(0);
        AgeCombo.setBackground(Color.WHITE);
        AgeCombo.setBorder(BorderFactory.createLineBorder(Color.black,1));
        AgeCombo.setBounds(850,330,120,30);
        background.add(AgeCombo);

        JLabel typeLabel = new JLabel("Age");
        typeLabel.setBounds(850,300,120,30);
        background.add(typeLabel);

        //Adding filter btn
        filterBtn = new RoundButton("FILTER");
        filterBtn.setBackground(Color.black);
        filterBtn.setForeground(Color.ORANGE);
        filterBtn.setBounds(830,450,150,30);
        filterBtn.addActionListener(this);
        background.add(filterBtn);

        //Adding Back Button
        backBtn = new RoundButton("BACK");
        backBtn.setBackground(Color.black);
        backBtn.setForeground(Color.ORANGE);
        backBtn.setBounds(830,500,150,30);
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
               }/*else if((statusCombo.getSelectedItem()).equals("All") &&
                       (typeCombo.getSelectedItem()).equals("All")) {
                   cmd = "SELECT * FROM room WHERE available = \"" + availCombo.getSelectedItem() + "\"";
               }else if((availCombo.getSelectedItem()).equals("All")){
                   cmd = "SELECT * FROM room WHERE clean = \"" + statusCombo.getSelectedItem() + "\"" +
                           " AND bed_type = \""+typeCombo.getSelectedItem() +"\"";
               }else if((statusCombo.getSelectedItem()).equals("All")){
                   cmd = "SELECT * FROM room WHERE available = \"" + availCombo.getSelectedItem() + "\"" +
                           " AND bed_type = \""+typeCombo.getSelectedItem() +"\"";
               }else if((typeCombo.getSelectedItem()).equals("All")){
                   cmd = "SELECT * FROM room WHERE available = \"" + availCombo.getSelectedItem() + "\"" +
                           " AND clean = \""+statusCombo.getSelectedItem() +"\"";
               }else{
                   cmd = "SELECT * FROM room WHERE available = \"" + availCombo.getSelectedItem() + "\"" +
                           " AND clean = \""+statusCombo.getSelectedItem() +"\" AND bed_type = \"" +typeCombo.getSelectedItem()+"\"";
               }*/
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
