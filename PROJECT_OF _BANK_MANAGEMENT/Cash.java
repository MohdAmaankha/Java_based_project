import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Cash extends JFrame implements ActionListener {
    JTextField amount;
    JButton cash, back;
    String  pin;

    Cash(String  pin) {
        this.pin =  pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/atm_purple.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 650);
        add(image);
        JLabel ENTER = new JLabel("Enter your withdrawl amount");
        ENTER.setForeground(Color.white);
        ENTER.setBounds(255, 240, 240, 27);
        ENTER.setFont(new Font("System", Font.BOLD, 22));
        ENTER.setSize(400, 30);
        // setVisible(true);
        image.add(ENTER);
        amount = new JTextField();
        amount.setBounds(255, 290, 274, 35);
        // setVisible(true);
        image.add(amount);
        cash = new JButton("withdrawl");
        cash.setBounds(370, 350, 100, 30);
        cash.setForeground(Color.white);
        cash.setBackground(Color.BLACK);
        cash.addActionListener(this);
        image.add(cash);
        back = new JButton("Back");
        back.setBounds(370, 390, 100, 30);
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        image.add(back);

        setSize(800, 600);
        setLocation(300, 0);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == cash) {
            String number = amount.getText();
            Date date = new Date();
            if (number.equals("")) {

                JOptionPane.showMessageDialog(null, "[Plese amount is required for Withdrawl]");
                setVisible(false);
                new Transction(pin).setVisible(true);
            } else {
                try {
                    Conn c = new Conn();
                    String query = "insert into depo values('" + pin + "','" + date + "','withdrawl','" +number+ "')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "rs :" + number + " withdrawl is successfully");

                } catch (Exception e) {
                    System.out.println(e);

                }
            }

        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transction(pin).setVisible(true);

        }

    }

    public static void main(String args[]) {
        new Cash("");
    }
}
