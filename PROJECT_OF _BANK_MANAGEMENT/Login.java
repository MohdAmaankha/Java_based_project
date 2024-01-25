import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton login, clear, signup;// yeh classes hain
    JTextField cardTextField;
    JPasswordField pinTextField;
    String formno;
   

    Login(String formno) {
        this.formno=formno;
        
        // use fun like setsize(11, 11,);
        setTitle("atm");
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/Bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(120, 35, 100, 100);
        add(label);
        // label hai thatis help to text in your frame
        JLabel text = new JLabel("WELCOM to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 30));
        text.setBounds(250, 70, 400, 50);
        add(text);

        JLabel card_no = new JLabel("Card number:");
        card_no.setFont(new Font("Osward", Font.BOLD, 30));
        card_no.setBounds(150, 150, 300, 40);
        add(card_no);
        cardTextField = new JTextField();
        cardTextField.setBounds(400, 157, 180, 30);
        add(cardTextField);

        JLabel pin = new JLabel("PIN no:");
        pin.setFont(new Font("Osward", Font.BOLD, 30));
        pin.setBounds(150, 200, 300, 40);
        add(pin);
        pinTextField = new JPasswordField();
        pinTextField.setBounds(400, 218, 180, 30);
        add(pinTextField);

        login = new JButton("SIGN IN");
        login.setBounds(370, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        // for another button is clear
        clear = new JButton("CLEAR");
        clear.setBounds(500, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        // and last buttonwhich is login
        signup = new JButton("SIGN UP");
        signup.setBounds(370, 340, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        getContentPane().setBackground(Color.WHITE);
        setSize(800, 480);
        setVisible(true);
        setLocation(350, 178);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");

        } else if (ae.getSource() == login) {
            Conn c = new Conn();
            String cardnumber = cardTextField.getText();
            String pin = pinTextField.getText();
            String quary = "Select*from login where cardnumber ='" + cardnumber + "' and pin = '" + pin + "'";
            // DDL CMD//
            try {// FUNCTION RTURN SOME VALUES SO WE USE RESULT FUNC OR CLASS WHICH IS NIN
                 // SQLPAKG
                ResultSet re = c.s.executeQuery(quary);
                if (re.next()) {
                    setVisible(false);
                 new Transction(pin).setVisible(true);
                    // ;
                } else {
                    JOptionPane.showMessageDialog(null, " incorrect cardnumber or pin number: ");
                }

            } catch (Exception e) {
                System.out.println(e);
                // TODO: handle exception
            }

        } else if (ae.getSource() == signup)

        {// sign ka page or frame build krna hoga first of all
            setVisible(false);
            new Signup(formno).setVisible(true);

        }
    }

    public static void main(String args[]) {
        new Login("");

    }
}