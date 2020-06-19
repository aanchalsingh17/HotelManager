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

public class CustomerInfo  extends JFrame implements ActionListener {
    RoundButton backBtn;
    JTable customerInfo;
    CustomerInfo(){
        ImageIcon i1 = new ImageIcon("src/com/hotelmanagement/icons/bokeh.jpeg");
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

        customerInfo = new JTable();
        customerInfo.setBounds(0,0,1500,500);
        customerInfo.setBorder(BorderFactory.createLineBorder(Color.black,1));
        customerInfo.setGridColor(Color.black);
        customerInfo.setAutoCreateRowSorter(true);
        customerInfo.enableInputMethods(false);
        customerInfo.setFont(new Font("Dialog",Font.BOLD,10));
        customerInfo.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 12));
        customerInfo.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.black,1));
        customerInfo.getTableHeader().setPreferredSize(new Dimension(0,30));
        customerInfo.setRowHeight(40);
        customerInfo.setDefaultEditor(Object.class, null);
        customerInfo.setOpaque(false);
        customerInfo.setIntercellSpacing(new Dimension(10,15));
        //  Display selected cell data on JField at bottom
        customerInfo.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                int row = customerInfo.getSelectedRow();
                int column = customerInfo.getSelectedColumn();
                email.setText((String) customerInfo.getValueAt(row, column));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                email.setText("");
            }
        });

        //  Load all values in the first place into table
        try{
            DatabaseConnection connection = new DatabaseConnection();
            String cmd = "SELECT * FROM customer";
            ResultSet rs = connection.statement.executeQuery(cmd);

            customerInfo.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Occurred in loading data. Try again");
            e.printStackTrace();
        }
        centerTable();


        JScrollPane scrollPane= new  JScrollPane(customerInfo);
        scrollPane.setBounds(15,50,950,470);
        scrollPane.setPreferredSize(new Dimension(0,0 ));
        //  The two lines below are to make extra table transparent
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        background.add(scrollPane);


        JLabel jLabel = new JLabel("Customer Details");
        jLabel.setBounds(372,10,300,30);
        jLabel.setFont(new Font("Tahoma", Font.BOLD ,25));
        Font font = jLabel.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_LOW_TWO_PIXEL);
        jLabel.setFont(font.deriveFont(attributes));
        background.add(jLabel);


        //Adding Back Button
        backBtn = new RoundButton("BACK");
        backBtn.setBackground(Color.black);
        backBtn.setForeground(Color.ORANGE);
        backBtn.setBounds(840,530,120,30);
        backBtn.addActionListener(this);
        background.add(backBtn);

        this.setLayout(null);
        this.setSize(980,600);
        this.setLocationRelativeTo(null );      // To set window location centred
        this.setTitle("Customer Details");
        this.setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }
    private void centerTable() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for(int x = 0; x< customerInfo.getColumnCount(); x++){
            customerInfo.getColumnModel().getColumn(x).setCellRenderer(centerRenderer);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backBtn){
            this.setVisible(false);
            new Reception().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new CustomerInfo().setVisible(true);
    }

}
