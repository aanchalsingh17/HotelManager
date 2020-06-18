package com.hotelmanagement;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.sql.ResultSet;
import java.util.Map;

public class Room extends JFrame implements ActionListener {

    JTable t1;
    RoundButton filterBtn,backBtn;
    JComboBox availCombo, statusCombo, typeCombo;


    Room(){

        ImageIcon i1 = new ImageIcon("src/com/hotelmanagement/icons/bokeh.jpeg");
        Image b = i1.getImage().getScaledInstance(750,640,Image.SCALE_SMOOTH);
        ImageIcon i2 = new ImageIcon(b);
        JLabel background = new JLabel(i2);
        background.setBounds(0,0,750,640);
        add(background);



        t1 = new JTable();
        t1.setBounds(0,0,580,430);
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
        scrollPane.setBounds(15,50,580,425);
        scrollPane.setPreferredSize(new Dimension(0,0 ));
        //  The two lines below are to make extra table transparent
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        background.add(scrollPane);


        //  Load all values in the first place into table
        try{
            DatabaseConnection connection = new DatabaseConnection();
            String cmd = "SELECT * FROM room";
            ResultSet rs = connection.statement.executeQuery(cmd);

            t1.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error Occurred in loading data. Try again");
            e.printStackTrace();
        }
        centerTable();


        filterBtn = new RoundButton("FILTER");
        filterBtn.setBounds(620,380,120,30);
        filterBtn.setForeground(Color.ORANGE);
        filterBtn.setBackground(Color.black);
        filterBtn.addActionListener(this);
        background.add(filterBtn);

        backBtn = new RoundButton("BACK");
        backBtn.setBounds(620,430,120,30);
        backBtn.setForeground(Color.ORANGE);
        backBtn.setBackground(Color.black);
        backBtn.addActionListener(this);
        background.add(backBtn);



        availCombo = new JComboBox(new String[] {"All" , "Available" , "Occupied"});
        availCombo.setSelectedIndex(0);
        availCombo.setBackground(Color.WHITE);
        availCombo.setBorder(BorderFactory.createLineBorder(Color.black,1));
        availCombo.setBounds(620,70,120,30);
        background.add(availCombo);

        JLabel availLabel = new JLabel("Availaibility");
        availLabel.setBounds(620,40,120,30);
        background.add(availLabel);

        statusCombo = new JComboBox(new String[] {"All" , "Clean" , "Dirty"});
        statusCombo.setSelectedIndex(0);
        statusCombo.setBackground(Color.WHITE);
        statusCombo.setBorder(BorderFactory.createLineBorder(Color.black,1));
        statusCombo.setBounds(620,180,120,30);
        background.add(statusCombo);

        JLabel statusLabel = new JLabel("Status");
        statusLabel.setBounds(620,150,120,30);
        background.add(statusLabel);

        typeCombo = new JComboBox(new String[] {"All" , "Single Bed" , "Double Bed"});
        typeCombo.setSelectedIndex(0);
        typeCombo.setBackground(Color.WHITE);
        typeCombo.setBorder(BorderFactory.createLineBorder(Color.black,1));
        typeCombo.setBounds(620,290,120,30);
        background.add(typeCombo);

        JLabel typeLabel = new JLabel("Bed type");
        typeLabel.setBounds(620,260,120,30);
        background.add(typeLabel);


        JLabel jLabel = new JLabel("Room Details");
        jLabel.setBounds(272,10,200,30);
        jLabel.setFont(new Font("Tahoma", Font.BOLD ,25));
        Font font = jLabel.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_LOW_TWO_PIXEL);
        jLabel.setFont(font.deriveFont(attributes));
        background.add(jLabel);


        this.setLayout(null);
        this.setSize(750,520);
        this.setLocationRelativeTo(null);      // To set window location centred
        this.setTitle("Rooms");
        this.setResizable(false);
        setVisible(true);

    }

    //  We need to call this every-time we update JTable data to align values to center
    private void centerTable() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for(int x=0;x<t1.getColumnCount();x++){
            t1.getColumnModel().getColumn(x).setCellRenderer(centerRenderer);
        }
    }


    @Override
    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource() == filterBtn){
            //  Filter to change SQL query
            String cmd ;

            if((availCombo.getSelectedItem()).equals("All") &&
                    (statusCombo.getSelectedItem()).equals("All") &&
            (typeCombo.getSelectedItem()).equals("All")){
                cmd = "SELECT * FROM room";
            }else if((availCombo.getSelectedItem()).equals("All") &&
                    (statusCombo.getSelectedItem()).equals("All")){
                cmd = "SELECT * FROM room WHERE bed_type = \""+ typeCombo.getSelectedItem()+"\"";
            }else if((availCombo.getSelectedItem()).equals("All") &&
                    (typeCombo.getSelectedItem()).equals("All")) {
                cmd = "SELECT * FROM room WHERE clean = \"" + statusCombo.getSelectedItem() + "\"";
            }else if((statusCombo.getSelectedItem()).equals("All") &&
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
            }

            try{
                DatabaseConnection connection = new DatabaseConnection();
                ResultSet rs = connection.statement.executeQuery(cmd);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
                centerTable();

            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Error Occurred. Try again");
                e.printStackTrace();
            }

        }else if(ae.getSource() == backBtn){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Room().setVisible(true);
    }


}
