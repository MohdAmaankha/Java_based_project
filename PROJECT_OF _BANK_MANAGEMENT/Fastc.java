
import javax.swing.*;
import java.awt.image.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
//import java.sql.Date;
import java.util.Date;

public class Fastc extends JFrame implements ActionListener {
    JButton deposite, fastcash, cash, pin_change, exit;
    String pin;

    // setTitle("realatnm");
    Fastc(String pin) {
        this.pin = pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/atm_purple.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 650);
        add(image);
        JLabel text = new JLabel(" Please Select your widrawl amount ");
        text.setBounds(150, 120, 490, 25);
        text.setForeground(Color.GRAY);
        text.setFont(new Font("System", Font.BOLD, 25));
        image.add(text);

        deposite = new JButton("Rs 500");
        deposite.setBackground(Color.white);
        deposite.setForeground(Color.black);
        deposite.setBounds(100, 150, 190, 35);
        deposite.addActionListener(this);
        image.add(deposite);

        fastcash = new JButton("Rs 1000");
        fastcash.setBackground(Color.white);
        // fastcash.setForeground(Color.black);
        fastcash.setBounds(500, 150, 190, 35);
        fastcash.addActionListener(this);
        image.add(fastcash);

        pin_change = new JButton("Rs 5000");
        pin_change.setBackground(Color.white);
        // pin_change.setForeground(Color.black);
        pin_change.setBounds(100, 200, 190, 35);
        pin_change.addActionListener(this);
        image.add(pin_change);

        cash = new JButton("Rs 10000");
        cash.setBackground(Color.white);
        // cash.setForeground(Color.black);
        cash.setBounds(500, 200, 190, 35);
        cash.addActionListener(this);
        image.add(cash);

        exit = new JButton("Back");
        exit.setBackground(Color.white);
        exit.setForeground(Color.black);
        exit.setBounds(500, 240, 190, 36);
        exit.addActionListener(this);
        image.add(exit);

        setSize(800, 650);
        setLocation(350, 0);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            setVisible(false);
            new Transction(pin).setVisible(true);

        } else {
            String amount = ((JButton) ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("select*from depo where pin ='" + pin + "'");
                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("accounttype").equals("Deposite")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }

                }
                if (ae.getSource() != exit && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, " Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into depo values('" + pin + "','" + date + "','withdrawl','" + amount + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs" + amount + " withdrawl successfully");
                setVisible(false);
                new Transction(pin).setVisible(true);

            } catch (Exception e) {
                // TODO: handle exception
                System.out.println(e);
            }
        }
    }

    public static void main(String args[]) {
        new Fastc("");

    }

}
