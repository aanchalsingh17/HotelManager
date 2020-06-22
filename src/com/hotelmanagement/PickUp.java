package com.hotelmanagement;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class PickUp extends JFrame implements ActionListener {

    JComboBox carTypeChoice;
    JTable t1;
    JButton findCarBtn,backBtn;
    JCheckBox availCheck;

    PickUp(){

        ImageIcon i1 = new ImageIcon("src/com/hotelmanagement/icons/bokeh.jpeg");
        Image b = i1.getImage().getScaledInstance(900,600,Image.SCALE_SMOOTH);
        ImageIcon i2 = new ImageIcon(b);
        JLabel background = new JLabel(i2);
        background.setBounds(0,0,900,600);
        add(background);

        JLabel jLabel = new JLabel("Pick-Up Service");
        jLabel.setBounds(270,15,450,30);
        jLabel.setFont(new Font("Tahoma", Font.BOLD ,26));
        Font font = jLabel.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_LOW_TWO_PIXEL);
        jLabel.setFont(font.deriveFont(attributes));
        background.add(jLabel);

        ImageIcon idic = new ImageIcon("src/com/hotelmanagement/icons/car_icon.png");
        Image idImage = idic.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon id_icon = new ImageIcon(idImage);
        JLabel carTypeLabel = new JLabel("Car Type");
        carTypeLabel.setBounds(95, 50, 155, 30);
        carTypeLabel.setIcon(id_icon);
        background.add(carTypeLabel);

        carTypeChoice = new JComboBox();
        carTypeChoice.setBackground(Color.WHITE);
        carTypeChoice.setBounds(75,80,150,25);
        carTypeChoice.setBorder(BorderFactory.createLineBorder(Color.black,1));
        carTypeChoice.addItem("All Cars");

        background.add(carTypeChoice);
        try{
            DatabaseConnection conn = new DatabaseConnection();
            ResultSet r = conn.statement.executeQuery("SELECT distinct carcategory FROM driver");
            while (r.next()){
                carTypeChoice.addItem(r.getString("carcategory"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        carTypeChoice.setSelectedItem(null);


        JLabel avaiLabel = new JLabel("Show only available cars");
        avaiLabel.setFont(new Font("Tahoma", Font.BOLD,15));
        avaiLabel.setBounds(485, 70, 200, 30);
        background.add(avaiLabel);

        availCheck = new JCheckBox();
        availCheck.setBounds(460,72,25,25);
        availCheck.setOpaque(false);
        background.add(availCheck);


        t1 = new JTable();
        t1.setBounds(0,0,770,400);
        t1.setBorder(BorderFactory.createLineBorder(Color.black,1));
        t1.setGridColor(Color.black);
        t1.setAutoCreateRowSorter(true);
        t1.enableInputMethods(false);
        t1.setFont(new Font("Dialog",Font.BOLD,15));
        t1.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 12));
        t1.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.black,1));
        t1.getTableHeader().setPreferredSize(new Dimension(0,30));
        t1.setRowHeight(40);
        //  Make the table non-editable
        t1.setDefaultEditor(Object.class, null);
        //  Two lined for transparent space between cells
        t1.setOpaque(false);
        t1.setIntercellSpacing(new Dimension(10,15));


        //  Scroll pane to enclose the JTable
        JScrollPane scrollPane= new  JScrollPane(t1);
        scrollPane.setBounds(15,120,770,400);
        scrollPane.setPreferredSize(new Dimension(0,0 ));
        //  The two lines below are to make extra table transparent
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        background.add(scrollPane);

        findCarBtn = new RoundButton("SEARCH CAR");
        findCarBtn.setBounds(195,530,120,30);
        findCarBtn.setForeground(Color.ORANGE);
        findCarBtn.setBackground(Color.black);
        findCarBtn.addActionListener(this);
        background.add(findCarBtn);

        backBtn = new RoundButton("BACK");
        backBtn.setBounds(485,530,120,30);
        backBtn.setForeground(Color.ORANGE);
        backBtn.setBackground(Color.black);
        backBtn.addActionListener(this);
        background.add(backBtn);


        this.setLayout(null);
        this.setSize(800,600);
        this.setLocationRelativeTo(null );      // To set window location centred
        this.setTitle("Pick-Up Service");
        this.setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource()==backBtn){
            this.setVisible(false);
            new Reception().setVisible(true);
        }else if(ae.getSource()== findCarBtn){
            if(carTypeChoice.getSelectedItem() == null){
                JOptionPane.showMessageDialog(this,"Please select a car type");
            }else{

                String carType = (String)carTypeChoice.getSelectedItem();
                String cmd = "";
                if(!carType.equals("All Cars")) {
                    if (availCheck.isSelected()) {
                        cmd = "SELECT * FROM driver where availability = \"Available\" AND carcategory = \"" + carType + "\"";
                    } else {
                        cmd = "SELECT * FROM driver where carcategory = \"" + carType + "\"";
                    }
                }
                else{
                    if (availCheck.isSelected()) {
                        cmd = "SELECT * FROM driver where availability = \"Available\"";
                    } else {
                        cmd = "SELECT * FROM driver";
                    }
                }
                try{
                    DatabaseConnection connection = new DatabaseConnection();
                    ResultSet rs = connection.statement.executeQuery(cmd);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));
                }catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error Occurred in loading data. Try again");
                    e.printStackTrace();
                }
                centerTable();
            }
        }
    }

    //  We need to call this every-time we update JTable data to align values to center
    private void centerTable() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for(int x=0;x<t1.getColumnCount();x++){
            t1.getColumnModel().getColumn(x).setCellRenderer(centerRenderer);
        }
    }

    public static void main(String[] args) {
        new PickUp().setVisible(true);
    }


}
