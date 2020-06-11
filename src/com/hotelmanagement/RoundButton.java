package com.hotelmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.geom.RoundRectangle2D;


    //  Class used to implement JButton with rounded corners
public class RoundButton extends JButton {

    public RoundButton(String text) {
        super(text);
        Dimension size = getPreferredSize();
        size.width = size.height = Math.max(size.width, size.height);
        setPreferredSize(size);
        setContentAreaFilled(false);

        addMouseListener(new ML(this));
    }

    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.orange);
        } else {
            g.setColor(getBackground());
        }
        g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
        super.paintComponent(g);
    }
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
    }
    Shape shape;
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 20, 20);
        }
        return shape.contains(x, y);
    }




}

    //  So that the button color changes if hovered over
class ML extends MouseAdapter {
    RoundButton rb;
    public ML( RoundButton roundButton){
        this.rb = roundButton;
    }

    public void mouseEntered(java.awt.event.MouseEvent evt) {
        rb.setBackground(Color.orange);
        rb.setForeground(Color.black);//        rb.setSize(120,40);
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        rb.setBackground(Color.black);
        rb.setForeground(Color.orange);
    }

}