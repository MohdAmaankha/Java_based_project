import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.sql.*;

public class Signup3 extends JFrame implements ActionListener {
    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6;
    JButton submit, cancel;
    String accounttype = null;
    Random random;
    String formno;

    Signup3(String formno) {// setlayout ko null krna hoga jab set bounds kam kareyga

        this.formno = formno;
        setLayout(null);

        JLabel h = new JLabel("Page 3: Account details");
        h.setFont(new Font("Railway", Font.BOLD, 25));
        h.setBounds(240, 20, 290, 25);
        add(h);

        JLabel l1 = new JLabel("ACCOUNT TYPE");
        l1.setFont(new Font("Railway", Font.BOLD, 20));
        l1.setBounds(150, 90, 200, 20);
        add(l1);
        r1 = new JRadioButton("SAVING ACCOUNT");
        r1.setBackground(Color.white);
        r1.setBounds(150, 140, 190, 20);
        add(r1);
        r2 = new JRadioButton("FIXED DEPOSITE ACCOUNT");
        r2.setBackground(Color.white);
        r2.setBounds(150, 170, 190, 20);
        add(r2);
        r3 = new JRadioButton("CURRENT ACCOUNT");
        r3.setBackground(Color.white);
        r3.setBounds(150, 200, 190, 20);
        add(r3);
        r4 = new JRadioButton("RECURRING ACCOUNT");
        r4.setBackground(Color.white);
        r4.setBounds(150, 225, 190, 20);
        add(r4);
        ButtonGroup togather = new ButtonGroup();
        togather.add(r1);
        togather.add(r2);
        togather.add(r3);
        togather.add(r4);
        JLabel cardnumber = new JLabel("CARD_N0 :");
        cardnumber.setFont(new Font("Railway", Font.BOLD, 25));
        cardnumber.setBounds(150, 270, 200, 20);
        add(cardnumber);
        JLabel p1 = new JLabel(" your  16 digit card number  ");
        p1.setFont(new Font("Railway", Font.ITALIC, 8));
        p1.setBounds(150, 290, 280, 15);
        add(p1);
        JLabel p3 = new JLabel(" XXXX XXXX XXXX 4781  ");
        p3.setFont(new Font("Railway", Font.BOLD, 15));
        p3.setBounds(340, 270, 280, 20);
        add(p3);
        JLabel pin = new JLabel("PIN no :");
        pin.setFont(new Font("Railway", Font.BOLD, 23));
        pin.setBounds(150, 320, 200, 20);
        add(pin);
        JLabel p4 = new JLabel(" XXXX  ");
        p4.setFont(new Font("Railway", Font.BOLD, 15));
        p4.setBounds(340, 320, 280, 20);
        add(p4);
        JLabel p2 = new JLabel("Enter your  4 digit pin number ");
        p2.setFont(new Font("Railway", Font.ITALIC, 7));
        p2.setBounds(150, 340, 200, 15);
        add(p2);
        JLabel services = new JLabel("Services required:");
        services.setFont(new Font("Railway", Font.BOLD, 23));
        services.setBounds(150, 370, 200, 20);
        add(services);
        c1 = new JCheckBox("ATM");
        c1.setBackground(Color.white);
        c1.setBounds(150, 400, 100, 20);
        add(c1);
        c2 = new JCheckBox("MOBILE BANKINT");
        c2.setBackground(Color.white);
        c2.setBounds(320, 400, 150, 20);
        add(c2);
        c3 = new JCheckBox("INTERNET BANKING");
        c3.setBackground(Color.white);
        c3.setBounds(150, 425, 150, 20);
        add(c3);
        c4 = new JCheckBox("CHECK BOOK");
        c4.setBackground(Color.white);
        c4.setBounds(320, 425, 130, 20);
        add(c4);
        c5 = new JCheckBox("EMAIL AND SMS ALERT");
        c5.setBackground(Color.white);
        c5.setBounds(150, 450, 200, 18);
        add(c5);
        c6 = new JCheckBox("E statement");
        c6.setBackground(Color.white);
        c6.setBounds(320, 450, 220, 20);
        add(c6);
        getContentPane().setBackground(Color.white);
        setSize(800, 800);
        submit = new JButton("SUBMIT");
        submit.setBounds(280, 500, 120, 29);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);
        cancel = new JButton("CANCEL");
        cancel.setBounds(420, 500, 120, 29);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);
        setVisible(true);
        setLocation(260, 40);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            if (r1.isSelected()) {
                String accounttype = null;
            } else if (r1.isSelected()) {
                accounttype = "saving account";

            } else if (r2.isSelected()) {
                accounttype = "deposite fixed account";

            } else if (r3.isSelected()) {
                accounttype = "current account";

            } else if (r4.isSelected()) {
                accounttype = "recurring account";

            }
            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5682312000000L);
            String pin = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
            String facility = "";
            if (c1.isSelected()) {
                facility = facility + "ATM";
            } else if (c2.isSelected()) {
                facility = facility + "MOBILE BANKING";
            } else if (c3.isSelected()) {
                facility = facility + "INTERNET BANKING";
            } else if (c4.isSelected()) {
                facility = facility + "CASH BOOK";
            } else if (c5.isSelected()) {
                facility = facility + "ENAIL AND SMS ALERT";
            } else if (c6.isSelected()) {
                facility = facility + "E STATEMENT";
            }
            try {
                if (facility.equals("")) {
                    JOptionPane.showMessageDialog(null, " services  is requaried");
                } else {
                    Conn c = new Conn();
                    String query = "INSERT Into signup3 values('" + formno + "','" + accounttype + "','" + cardnumber+ "','" + pin + "','" + facility + "')";
                    // setVisible(false);
                    String quary2 = "Insert into login values('" + formno + "','" + cardnumber + "','" + pin + "')";
                    c.s.executeUpdate(query);
                    c.s.executeUpdate(quary2);
                    JOptionPane.showMessageDialog(null, " cardnum:" + cardnumber + "  pin no:=" +pin);
                  setVisible(false);
                  new Deposite(pin).setVisible(true);
                  

                }
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println(e);
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
            new Login("").setVisible(true);
        }

    }

    public static void main(String args[]) {
        new Signup3("");
    }

}
