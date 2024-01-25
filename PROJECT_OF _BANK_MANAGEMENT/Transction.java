import javax.swing.*;
import java.awt.image.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Transction extends JFrame implements ActionListener{
    JButton deposite, fastcash, cash, pin_change, mn_statement, inquiry, exit;
     String  pin;
    // setTitle("realatnm");
    Transction(String  pin) {
        this.pin =  pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/atm_purple.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 650);
        add(image);

        deposite = new JButton("DEPOSITE");
        deposite.setBackground(Color.white);
        deposite.setForeground(Color.black);
        deposite.setBounds(100, 150, 190, 20);
        deposite.addActionListener(this);
        image.add(deposite);

        fastcash = new JButton("FAST CASH");
        fastcash.setBackground(Color.white);
        fastcash.setForeground(Color.black);
        fastcash.setBounds(500, 150, 190, 20);
        fastcash.addActionListener(this);
        image.add(fastcash);

        pin_change = new JButton("PIN CHANGE");
        pin_change.setBackground(Color.white);
        pin_change.setForeground(Color.black);
        pin_change.setBounds(100, 200, 190, 20);
        pin_change.addActionListener(this);
        image.add(pin_change);

        cash = new JButton("CASH WIDRAWL");
        cash.setBackground(Color.white);
        cash.setForeground(Color.black);
        cash.setBounds(500 ,200, 190, 20);
        cash.addActionListener(this);
        image.add(cash);

        mn_statement = new JButton("MINI STATEMENT");
        mn_statement.setBackground(Color.white);
        mn_statement.setForeground(Color.black);
        mn_statement.setBounds(100, 250, 190, 20);
        mn_statement.addActionListener(this);
        image.add(mn_statement);

        inquiry = new JButton("BALANCE INQUIRY");
        inquiry.setBackground(Color.white);
        inquiry.setForeground(Color.black);
        inquiry.setBounds(500, 250, 190, 20);
        inquiry.addActionListener(this);
        image.add(inquiry);

        exit = new JButton("EXIT");
        exit.setBackground(Color.white);
        exit.setForeground(Color.black);
        exit.setBounds(100, 300, 100, 20);
        exit.addActionListener(this);
        image.add(exit);

        setSize(800, 650);
        setLocation(350, 0);
        setVisible(true);

    }
     public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==exit) {
              setVisible(false);
              new Login("").setVisible(true);
            
        }else if(ae.getSource()==deposite){
            setVisible(false);
            new Deposite(pin).setVisible(true);
        }else if(ae.getSource()==cash){
            setVisible(false);
            new Cash(pin).setVisible(true);
        }else if(ae.getSource()==fastcash){
            setVisible(false);
            new Fastc(pin).setVisible(true);
         }else if(ae.getSource()== pin_change){
             setVisible(false);
             new Pinchange(pin).setVisible(true);
        }else if(ae.getSource()== inquiry){
             setVisible(false);
             new Balanceenq(pin).setVisible(true);
        }else if(ae.getSource()== mn_statement){
             setVisible(false);
             new Minist(pin).setVisible(true);
        }

     }
    public static void main(String args[]) {
        new Transction("");

    }

}
