import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class Minist extends JFrame implements ActionListener {
    JLabel text, card, text3, bale;
    JButton button2;
    String pin;

    Minist(String pin) {
        setTitle("mini statement");
        setLayout(null);
        this.pin = pin;

        text = new JLabel("INDIAN BANK");
        text.setFont(new Font("Railway", Font.BOLD, 15));
        text.setBounds(250, 20, 200, 20);
        add(text);

        card = new JLabel("");
        card.setForeground(Color.black);
        card.setBounds(10, 45, 300, 20);
        add(card);

        text3 = new JLabel("");
        text3.setBounds(30, 70, 450, 300);
        add(text3);
        bale = new JLabel("");
        text3.setForeground(Color.black);
        bale.setBounds(30, 260, 450, 300);
        add(bale);

        button2 = new JButton("BACK");
        button2.setBackground(Color.white);
        button2.setForeground(Color.black);
        button2.setBounds(300, 550, 100, 27);
        button2.addActionListener(this);
        add(button2);
        try {// FUNCTION RTURN SOME VALUES SO WE USE RESULT FUNC OR CLASS WHICH IS NIN
             // SQLPAKG
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select*from login where pin='" + pin + "'");
            while (rs.next()) {
                card.setText("Card_number:" + rs.getString("cardnumber").substring(0, 4) + "xxxxxxxx"
                        + rs.getString("cardnumber").substring(12));
            }

        } catch (Exception e) {
            System.out.println(e);
            // TODO: handle exception
        }
        try {
            // SQLPAKG
            Conn c = new Conn();
            int bal = 0;
            ;
            ResultSet rs = c.s.executeQuery("select*from depo where pin='" + pin + "'");
            while (rs.next()) {
                text3.setText(text3.getText() + "<html>" + rs.getString("date")
                        + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; " + rs.getString("accounttype")
                        + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; " + rs.getString("amount") + "</html>");

                if (rs.getString("accounttype").equals("Deposite")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));

                }
            }

            bale.setText("your current balance is" + bal);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }

        setSize(500, 800);
        setLocation(20, 20);
        getContentPane().setBackground(Color.white);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource()==button2){
        setVisible(false);
        new Transction(pin).setVisible(true);
       }
    }

    public static void main(String argss[]) {

        new Minist("").setVisible(true);
    }

}
