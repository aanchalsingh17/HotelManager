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

public class SearchRoom extends JFrame implements ActionListener {
    JLabel bedTypeLabel;
    JComboBox bedType;
    JCheckBox availCheck;
    JTable t1;
    RoundButton findRoomBtn,backBtn;
    SearchRoom(){

        ImageIcon i1 = new ImageIcon("src/com/hotelmanagement/icons/bokeh.jpeg");
        Image b1 = i1.getImage().getScaledInstance(800,600,Image.SCALE_SMOOTH);
        ImageIcon i2 = new ImageIcon(b1);
        JLabel background = new JLabel(i2);
        background.setBounds(0,0,800,600);
        add(background);


        JLabel appName = new JLabel("Search Room");
        appName.setBounds(300, 10, 310, 30);
        appName.setFont(new Font("Tahoma", Font.BOLD ,25));
        Font font = appName.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_LOW_TWO_PIXEL);
        appName.setFont(font.deriveFont(attributes));
        background.add(appName);

        bedTypeLabel = new JLabel(" Bed Type  :");
        bedTypeLabel.setBounds(60, 40, 155, 40);
        ImageIcon bedic = new ImageIcon("src/com/hotelmanagement/icons/bed_icon.png");
        Image bedImage = bedic.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon bed_icon = new ImageIcon(bedImage);
        bedTypeLabel.setIcon(bed_icon);
        background.add(bedTypeLabel);

        bedType = new JComboBox(new String[] {"All","Single Bed", "Double Bed"});
        bedType.setBounds(60,80,150,30);
        bedType.setBackground(Color.WHITE);
        bedType.setBorder(BorderFactory.createLineBorder(Color.black,1));
        background.add(bedType);



        JLabel avaiLabel = new JLabel("Show only available rooms");
        avaiLabel.setFont(new Font("Tahoma", Font.BOLD,15));
        avaiLabel.setBounds(500, 70, 250, 30);
        background.add(avaiLabel);

        availCheck = new JCheckBox();
        availCheck.setBounds(475,72,25,25);
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



        findRoomBtn = new RoundButton("SEARCH ROOM");
        findRoomBtn.setBounds(195,530,150,30);
        findRoomBtn.setForeground(Color.ORANGE);
        findRoomBtn.setBackground(Color.black);
        findRoomBtn.addActionListener(this);
        background.add(findRoomBtn);

        backBtn = new RoundButton("BACK");
        backBtn.setBounds(485,530,150,30);
        backBtn.setForeground(Color.ORANGE);
        backBtn.setBackground(Color.black);
        backBtn.addActionListener(this);
        background.add(backBtn);


        setSize(800,600);
        setLocationRelativeTo(null);
        setTitle("Search Room");
        setLayout(null);
        setResizable(false);
        setVisible(true);
    }
    public static void main(String[] args) {
        new SearchRoom().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==backBtn){
           this.setVisible(false);
           new Reception().setVisible(true);
       }else if(e.getSource()==findRoomBtn){
          String bedtype = (String)bedType.getSelectedItem();
          String  cmd="";
          if(!bedtype.equals("All")){
              if(availCheck.isSelected()){
                  cmd = "SELECT * FROM room WHERE available = \"Available\" AND bed_type = \"" + bedtype + "\"";
              }else{
                  cmd = "SELECT * FROM room where bed_type =\""+bedtype+"\"";

              }
          }else{
              if(availCheck.isSelected()){
                  cmd = "SELECT * FROM room WHERE available = \"Available\"";
              }else{
                  cmd = "SELECT * FROM room";
              }
          }
          try{
              DatabaseConnection databaseConnection = new DatabaseConnection();
              ResultSet resultSet = databaseConnection.statement.executeQuery(cmd);
              t1.
              setModel(DbUtils.resultSetToTableModel(resultSet));
          }catch (Exception ae){
              JOptionPane.showMessageDialog(null, "Error Occurred in loading data. Try again");
              ae.printStackTrace();
          }
          centerTable();
       }
    }
    private void centerTable() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for(int x=0;x<t1.getColumnCount();x++){
            t1.getColumnModel().getColumn(x).setCellRenderer(centerRenderer);
        }
    }
}
