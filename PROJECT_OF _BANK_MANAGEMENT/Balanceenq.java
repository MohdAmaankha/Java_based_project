import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class Balanceenq extends JFrame implements ActionListener {

    JButton inquiry;
    String pin;

    Balanceenq(String pin) {

        // setLayout(null);
        this.pin = pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/atm_purple.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 650);
        add(image);

        inquiry = new JButton("BACK");
        inquiry.setBackground(Color.WHITE);
        inquiry.setForeground(Color.BLACK);
        inquiry.setBounds(130, 120, 120, 20);
        inquiry.addActionListener(this);
        image.add(inquiry);
        Conn c = new Conn();
        int balance = 0;
        try {
            ResultSet rs = c.s.executeQuery("select*from depo where pin ='" + pin + "'");

            while (rs.next()) {
                if (rs.getString("accounttype").equals("Deposite")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
        JLabel text = new JLabel("Your current balance is: " + balance);
        text.setFont(new Font("Railway", Font.BOLD, 18));
        text.setBounds(8, 56, 400, 20);
        text.setForeground(Color.white);
        image.add(text);

        setSize(800, 600);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        setVisible(false);
        new Transction(pin).setVisible(true);

    }

    public static void main(String argss[]) {
        new Balanceenq("").setVisible(true);
    }

}
