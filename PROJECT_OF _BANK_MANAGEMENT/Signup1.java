import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.util.*;


public class Signup1 extends JFrame implements ActionListener {
    long random;
    JTextField PanTextField, AdhaarTextField;
    JComboBox Religion, category, income, education;
    JRadioButton  syes, sno, eyes, eno;
    JButton submiButton;
    String formno;
   

    Signup1(String formno) {
        this.formno = formno;

        setTitle("2 page");
        setLayout(null);
        JLabel text = new JLabel("Page 2 Addictional details");
        text.setFont(new Font("Osward", Font.BOLD, 25));
        text.setBounds(270, 20, 400, 40);
        add(text);
        // 1
        JLabel religion = new JLabel("RELIGION");
        religion.setFont(new Font("Osward", Font.BOLD, 20));
        religion.setBounds(130, 75, 250, 25);
        add(religion);
       
        String RELIGION[] = { "hindu", "muslim", "sikh", "chris", "other" };
        Religion = new JComboBox(RELIGION);
        Religion.setBounds(400, 75, 200, 25);
        add(Religion);

        // firstly creat obj_name = new JTextField();
        //
        JLabel Category = new JLabel("CATEGORY");
        Category.setFont(new Font("Osward", Font.BOLD, 20));
        Category.setBounds(129, 105, 150, 25);
        add(Category);
        String castl[] = { "gen", "sc", "obc", "insaan", "other" };
        category= new JComboBox(castl);
        category.setBounds(400, 105, 200, 25);
        add(category);
        //
        JLabel Incom = new JLabel("INCOME");
        Incom.setFont(new Font("Osward", Font.BOLD, 20));
        Incom.setBounds(130, 130, 250, 25);
        add(Incom);
        String inocom[] = { "null", "10k", "50k", "ilk", "more" };
        income = new JComboBox(inocom);
        income.setBounds(400, 130, 200, 25);
        add(income);
        //
        JLabel Education = new JLabel("EDUCATIONAL QUALIFICATION");
        Education.setFont(new Font("Osward", Font.BOLD, 18));
        Education.setBounds(130, 160, 250, 25);
        add(Education);
        String QUALI[] = { "BCA", "Bsc", "PHD", "MASTER", "other" };
        education = new JComboBox(QUALI);
        education.setBounds(400, 160, 200, 25);
        add(education);
        //
        JLabel Pan_No = new JLabel("PAN NUMBER");// pan num , adharrnum, no texfld senior citizen, existing accut
        Pan_No.setFont(new Font("Osward", Font.BOLD, 20));
        Pan_No.setBounds(130, 190, 250, 25);
        add(Pan_No);
        PanTextField = new JTextField();
        PanTextField.setBounds(400, 190, 200, 25);
        add(PanTextField);
        ; //

        JLabel Adhaar_num = new JLabel("ADHAAR NUMBER");
        Adhaar_num.setFont(new Font("Osward", Font.BOLD, 20));
        Adhaar_num.setBounds(130, 225, 250, 25);
        add(Adhaar_num);
        AdhaarTextField= new JTextField();
        AdhaarTextField.setBounds(400, 225, 200, 25);
        add(AdhaarTextField);
        //
        JLabel Senior = new JLabel("SENIOR CITIZEN");
        Senior.setFont(new Font("Osward", Font.BOLD, 20));
        Senior.setBounds(130, 255, 250, 25);
        add(Senior);
        // JLabel Snior = new JTextField();
        // Snior.setBounds(359, 255, 250, 25);
        // add(Snior);
        syes = new JRadioButton("yes");
        syes.setBounds(400, 255, 68, 20);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("no");
        sno.setBounds(467, 255, 75, 20);
        sno.setBackground(Color.white);

        add(sno);
        ButtonGroup Seeenior = new ButtonGroup();
        Seeenior.add(syes);
        Seeenior.add(sno);
        //
        JLabel Existing = new JLabel("EXISTING ACCOUNT");
        Existing.setFont(new Font("Osward", Font.BOLD, 20));
        Existing.setBounds(130, 300, 250, 25);
        add(Existing);
        // exetings = new JTextField();
        // exetings.setBounds(359, 300, 250, 25);
        // add(exetings);
        eyes = new JRadioButton("yes");
        eyes.setBounds(400, 300, 68, 20);
        eyes.setBackground(Color.white);
        add(eyes);

        eno = new JRadioButton("no");
        eno.setBounds(467, 300, 68, 20);
        eno.setBackground(Color.white);
        add(eno);
        ButtonGroup exeting = new ButtonGroup();
        exeting.add(eyes);
        exeting.add(eno);
         submiButton = new JButton("DONE OR SUBMIT");
         submiButton.setBounds(277, 340,150, 30);
         submiButton.setBackground(Color.BLACK );
         submiButton.setForeground(Color.WHITE );
         submiButton.addActionListener(this);
         add(submiButton);

        getContentPane().setBackground(Color.WHITE);
        setSize(700, 500);
        setVisible(true);
        setLocation(350, 140);

    }

    public void actionPerformed(ActionEvent ae) {
    // Signup1 next =new Signup1(formno);  
    String formno = "" + random;// long
    String sreligion = (String)Religion.getSelectedItem(); // set text
    String sCategory  =(String)category.getSelectedItem(); // set text
    String sincome  =(String)income.getSelectedItem();
    String seducation  =(String)education.getSelectedItem();
    String epan_no = PanTextField.getText();
    String eadhaar = AdhaarTextField.getText();
    String Senior = null;
     if (eyes.isSelected()) {
       Senior= "YES";
    } else if (eno.isSelected()) {
       Senior = "NO";
    }
    String existing_acc = null;
     if (syes.isSelected()) {
       existing_acc= "YES";
    } else if (sno.isSelected()) {
       existing_acc = "NO";
    }
  
   
    try {
      //  if (Religion.equals("")) {
      //     JOptionPane.showMessageDialog(null, "religion is requaried");
      //  } else {
             Conn c = new Conn(); 
             String quary = "INSERT Into signuptwo values('" + formno + "','" + sreligion + "','" + sCategory+ "','" + sincome+ "','" + seducation+ "','" + epan_no+ "','" +  eadhaar+ "','" +  Senior+ "','" + existing_acc+ "')";
             c.s.executeUpdate(quary);
             setVisible(false);
             new Signup3(formno).setVisible(true);
      // }
    }
     catch (Exception e) {
       e.printStackTrace();
       System.out.println(e);
    }
 
}

     

    public static void main(String[] args) {
        new Signup1("");

    }

}