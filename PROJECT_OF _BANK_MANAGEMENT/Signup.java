import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener {
   // Signup.forname("Oracle.jdbc.driver.OracleDriver");
   long random;
   JTextField nameeTextField, fatherTextField, emaillTextField, ctyTextField, statTextField, piTextField;
   JDateChooser dat;
   JRadioButton male, female;
   JButton Nextt;
   String formno;

   Signup(String formno) {
      this.formno=formno;
      Random ran = new Random();
      random = Math.abs((ran.nextLong() % 9000L) + 1000L);
      setLayout(null);

      JLabel Formno = new JLabel("APPLICATION FORM NO. " + random);
      Formno.setFont(new Font("Raleway", Font.BOLD, 30));
      Formno.setBounds(130, 30, 470, 28);
      add(Formno);
      setTitle("1 page");
      setLayout(null);
      JLabel text = new JLabel("Personal detail");
      text.setFont(new Font("Osward", Font.BOLD, 25));
      text.setBounds(250, 50, 400, 50);
      add(text);
      JLabel name = new JLabel("NAME:");
      name.setFont(new Font("Raleway", Font.ITALIC, 20));
      name.setBounds(170, 100, 200, 20);
      add(name);
      // JTextFIELD nameTextField = new JTextField();
      // nTF.set
      nameeTextField = new JTextField();
      nameeTextField.setBounds(390, 100, 150, 20);
      add(nameeTextField);
      ;
      JLabel father = new JLabel("FATHER NAEME:");
      father.setFont(new Font("Raleway", Font.ITALIC, 20));
      father.setBounds(170, 150, 200, 20);
      add(father);
      fatherTextField = new JTextField();
      fatherTextField.setBounds(390, 150, 150, 20);
      add(fatherTextField);

      JLabel date = new JLabel("DATE OF BIRTH:");
      date.setFont(new Font("Raleway", Font.ITALIC, 20));
      date.setBounds(170, 200, 200, 20);
      add(date);
      dat = new JDateChooser();
      dat.setBounds(392, 200, 150, 20);
      add(dat);

      JLabel gen = new JLabel("GENDER:");
      gen.setFont(new Font("Raleway", Font.ITALIC, 20));
      gen.setBounds(170, 258, 200, 20);
      add(gen);
      // ager koi thik wala button add krna hai toh JRadio button use krtey hai
      male = new JRadioButton("MALE");
      male.setBounds(390, 259, 68, 20);
      add(male);

      female = new JRadioButton("FEMALE");
      female.setBounds(490, 259, 75, 20);
      add(female);
      ButtonGroup gendegroup = new ButtonGroup();
      gendegroup.add(male);
      gendegroup.add(female);
      JLabel email = new JLabel("EMAIL ADDRESS:");// JTeaxtFeild place n f e ad ci st pim
      email.setFont(new Font("Raleway", Font.ITALIC, 20));
      email.setBounds(170, 310, 200, 20);
      add(email);
      emaillTextField = new JTextField();
      emaillTextField.setBounds(390, 310, 150, 20);
      add(emaillTextField);

      JLabel city = new JLabel("CITY:");
      city.setFont(new Font("Raleway", Font.ITALIC, 20));
      city.setBounds(170, 370, 200, 20);
      add(city);
      ctyTextField = new JTextField();
      ctyTextField.setBounds(390, 370, 150, 20);
      add(ctyTextField);

      JLabel sta = new JLabel("STATE:");
      sta.setFont(new Font("Raleway", Font.ITALIC, 20));
      sta.setBounds(170, 420, 200, 20);
      add(sta);
      statTextField = new JTextField();
      statTextField.setBounds(390, 420, 150, 20);
      add(statTextField);

      JLabel pin = new JLabel("PIN CODE:");
      pin.setFont(new Font("Raleway", Font.ITALIC, 20));
      pin.setBounds(170, 480, 200, 20);
      add(pin);
      piTextField = new JTextField();
      piTextField.setBounds(390, 480, 150, 20);
      add(piTextField);
      Nextt = new JButton("NEXT");
      Nextt.setBounds(550, 550, 150, 30);
      Nextt.setBackground(Color.BLACK);
      Nextt.setForeground(Color.WHITE);
      Nextt.addActionListener(this);
      add(Nextt);
      // JTextField naam =new JTextField();//

      getContentPane().setBackground(Color.WHITE);
      setSize(800, 700);
      setVisible(true);
      setLocation(300, 80);

   }

   public void actionPerformed(ActionEvent ae) {
      String formno = "" + random;
      String name = nameeTextField.getText();// set text
      String father = fatherTextField.getText();// set text
      String date= ((JTextField) dat.getDateEditor().getUiComponent()).getText();
      String gen = null;
       if (male.isSelected()) {
         gen = "Male";
      } else if (female.isSelected()) {
         gen = "Female";
      }
      String email = emaillTextField.getText();
      String city = ctyTextField.getText();
      String sta = statTextField.getText();
      String pin = piTextField.getText();

     
      try {
         if (name.equals("")) {
            JOptionPane.showMessageDialog(null, " name is requaried");
         } else {
               Conn c = new Conn();
               String quary = "INSERT Into signup values('" + formno + "','" + name + "','" + father + "','" + date + "','" + gen + "','" + email + "','" + city + "','" + sta + "','" + pin + "' )";
               c.s.executeUpdate(quary );
               setVisible(false);
               new Signup1(formno).setVisible(true);
              //.executeUpdate(query);
            
         }
      }
       catch (Exception e) {
         e.printStackTrace();
         System.out.println(e);
      }
   
}

   public static void main(String[] args) {
      new Signup("");
   }
}