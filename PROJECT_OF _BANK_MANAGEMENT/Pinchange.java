import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class Pinchange extends JFrame implements ActionListener {
    JPasswordField pinjJPasswordField, repin;
    JButton pin_change, button2;
    String pin;

    Pinchange(String pin) {
        // setLayout(null);
        this.pin = pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/atm_purple.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 650);
        add(image);
        JLabel text = new JLabel("CHANGE YOUR PIN NUMBER");
        text.setFont(new Font("Railway", Font.BOLD, 23));
        text.setBounds(260, 56, 350, 20);
        text.setForeground(Color.white);
        image.add(text);

        JLabel text2 = new JLabel("NEW PASSWORD");
        text2.setFont(new Font("Railway", Font.BOLD, 20));
        text2.setBounds(30, 100, 230, 20);
        text2.setForeground(Color.white);
        image.add(text2);
        add(image);

        pinjJPasswordField = new JPasswordField();
        pinjJPasswordField.setBounds(270, 100, 230, 20);
        pinjJPasswordField.setBackground(Color.white);
        image.add(pinjJPasswordField);
        JLabel text3 = new JLabel("RE_CHANGE_PASS");
        text3.setFont(new Font("Railway", Font.BOLD, 20));
        text3.setBounds(30, 150, 250, 20);
        text3.setForeground(Color.white);
        image.add(text3);

        repin = new JPasswordField();
        repin.setBounds(270, 150, 230, 20);
        repin.setBackground(Color.white);
        image.add(repin);
        pin_change = new JButton("CHANGE PIN");
        pin_change.setBackground(Color.WHITE);
        pin_change.setForeground(Color.BLACK);
        pin_change.setBounds(257, 190, 120, 27);
        pin_change.addActionListener(this);
        image.add(pin_change);

        button2 = new JButton("BACK");
        button2.setBackground(Color.WHITE);
        button2.setForeground(Color.BLACK);
        button2.setBounds(410, 190, 120, 27);
        button2.addActionListener(this);
        image.add(button2);

        setSize(800, 600);
        setLocation(300, 0);
        // setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == pin_change) {
            try {
                String apin = pinjJPasswordField.getText();
                String rpin = repin.getText();
                if (!apin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered pin does not match");
                    return;
                }

                if (apin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please entered pin ");
                    return;
                }
                if (rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please re_entered new pin does not match");
                    return;
                }
                Conn c = new Conn();
                String query1 = "update depo set pin ='" + rpin + "' where pin='" + pin + "'";
                String query2 = "update login set pin ='" + rpin + "' where pin='" + pin + "'";
                String query3 = "update Signup3 set pin ='" + rpin + "' where pin='" + pin + "'";
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);
                JOptionPane.showMessageDialog(null, "pin successfully changed");
                setVisible(false);
                new Transction(rpin).setVisible(true);
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println(e);
            }
        } else {
            setVisible(false);
            new Transction(pin).setVisible(true);
        }
    }

    public static void main(String argss[]) {
        new Pinchange("").setVisible(true);
    }

}
