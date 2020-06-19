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

public class ManagerInfo  extends JFrame implements ActionListener {
    RoundButton backBtn;
    JTable managerInfo;
    ManagerInfo(){
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

        managerInfo = new JTable();
        managerInfo.setBounds(0,0,1500,500);
        managerInfo.setBorder(BorderFactory.createLineBorder(Color.black,1));
        managerInfo.setGridColor(Color.black);
        managerInfo.setAutoCreateRowSorter(true);
        managerInfo.enableInputMethods(false);
        managerInfo.setFont(new Font("Dialog",Font.BOLD,10));
        managerInfo.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 12));
        managerInfo.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.black,1));
        managerInfo.getTableHeader().setPreferredSize(new Dimension(0,30));
        managerInfo.setRowHeight(40);
        managerInfo.setDefaultEditor(Object.class, null);
        managerInfo.setOpaque(false);
        managerInfo.setIntercellSpacing(new Dimension(10,15));
        //  Display selected cell data on JField at bottom
        managerInfo.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                int row = managerInfo.getSelectedRow();
                int column = managerInfo.getSelectedColumn();
                email.setText((String) managerInfo.getValueAt(row, column));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                email.setText("");
            }
        });

        //  Load all values in the first place into table
        try{
            DatabaseConnection connection = new DatabaseConnection();
            String cmd = "SELECT * FROM employee where job = \"manager\"";
            ResultSet rs = connection.statement.executeQuery(cmd);

            managerInfo.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Occurred in loading data. Try again");
            e.printStackTrace();
        }
        centerTable();


        JScrollPane scrollPane= new  JScrollPane(managerInfo);
        scrollPane.setBounds(15,50,950,470);
        scrollPane.setPreferredSize(new Dimension(0,0 ));
        //  The two lines below are to make extra table transparent
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        background.add(scrollPane);


        JLabel jLabel = new JLabel("Manager Details");
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
        this.setTitle("Manager Details");
        this.setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }
    private void centerTable() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for(int x = 0; x< managerInfo.getColumnCount(); x++){
            managerInfo.getColumnModel().getColumn(x).setCellRenderer(centerRenderer);
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
        new ManagerInfo().setVisible(true);
    }

}
