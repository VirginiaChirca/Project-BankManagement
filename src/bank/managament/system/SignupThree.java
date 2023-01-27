package bank.managament.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{
    JLabel l1;
    JRadioButton r1,r2,r3,r4;
    String formno;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton b1,b2;
    SignupThree(String formno){
        setLayout(null);
        this.formno = formno;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
        
        l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280,40,400,40);
        add(l1); 
        
        JLabel type = new JLabel("Account Type: ");
        type.setFont(new Font("Osward",Font.BOLD,20));
        type.setBounds(100,100,400,40);
        add(type);
        
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100,150,300,20);
        add(r1);
        
        r2 = new JRadioButton("Current account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(100,190,300,20);
        add(r2);
        
        r3 = new JRadioButton("Fixed deposit account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100,230,300,20);
        add(r3);
        
        r4 = new JRadioButton("Salary account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(100,270,300,20);
        add(r4);
        
        ButtonGroup group = new ButtonGroup();
        group.add(r1);
        group.add(r2);
        group.add(r3);
        group.add(r4);
        
        JLabel card = new JLabel("Card number: ");
        card.setFont(new Font("Osward",Font.BOLD,20));
        card.setBounds(100,300,400,40);
        add(card);
        
        JLabel number = new JLabel("XXXX-XXXX-XXXX-XXXX");
        number.setFont(new Font("Osward",Font.BOLD,20));
        number.setBounds(250,300,400,40);
        add(number);
        
        JLabel carddetail = new JLabel("Permanent Account Number");
        carddetail.setFont(new Font("Osward",Font.BOLD,10));
        carddetail.setBounds(100,320,400,40);
        add(carddetail);
        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Osward",Font.BOLD,20));
        pin.setBounds(100,400,400,40);
        add(pin);
        
        JLabel pin1 = new JLabel("XXXX");
        pin1.setFont(new Font("Osward",Font.BOLD,20));
        pin1.setBounds(250,400,400,40);
        add(pin1);
        
        JLabel pindetail = new JLabel("4 Digit password");
        pindetail.setFont(new Font("Osward",Font.BOLD,10));
        pindetail.setBounds(100,420,400,40);
        add(pindetail);
        
        JLabel services = new JLabel("Services Required");
        services.setFont(new Font("Osward",Font.BOLD,20));
        services.setBounds(100,470,400,40);
        add(services);
        
        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100,500,400,40);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(100,530,400,40);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(100,560,400,40);
        add(c3);
        
        c4 = new JCheckBox("EMAIL Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(100,590,400,40);
        add(c4);
        
        c5 = new JCheckBox("I hereby declare that the above made statements are true to the best of my knowledge and belief");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 10));
        c5.setBounds(100,620,800,40);
        add(c5);
        
        b1 = new JButton("Submit");
        b1.setFont(new Font("Raleway", Font.BOLD, 15));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(100,680,150,40);
        add(b1);
        
        b2 = new JButton("Cancel");
        b2.setFont(new Font("Raleway", Font.BOLD, 15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(350,680,150,40);
        add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        getContentPane().setBackground(Color.white);
        setSize(850,850);
        setLocation(500,120);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
             String accountType = null;
             if(r1.isSelected()){ 
            accountType = "Saving Account";
            }
            else if(r2.isSelected()){ 
                accountType = "Current account";
            }
            else if(r3.isSelected()){ 
                accountType = "Fixed deposit account";
            }else if(r4.isSelected()){ 
                accountType = "Salary account";
        }
             
            Random ran = new Random();
            long cardNumber = (ran.nextLong() % 90000000L) + 5040936000000000L;
            String cardno = "" + Math.abs(cardNumber);
            long pinNumber = (ran.nextLong() % 9000L) + 1000L;
            String pin = "" + Math.abs(pinNumber);
            
            
            String facility = "";
            if(c1.isSelected()){ 
                facility = facility + " ATM Card";
            }
            if(c2.isSelected()){ 
                facility = facility + " Internet Banking";
            }
            if(c3.isSelected()){ 
                facility = facility + " Mobile Banking";
            }
            if(c4.isSelected()){ 
                facility = facility + " EMAIL Alerts";
            }
            
            try{
                
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null, "Fill all the required fields");
                }else{
                    Connection c = new Connection();
                    String q1 = "insert into signupthree values('"+formno+"','"+accountType+"','"+cardno+"','"+pin+"','"+facility+"')";  
                    String q2 = "insert into login values('"+formno+"','"+cardno+"','"+pin+"')";
                    c.s.executeUpdate(q1);
                    c.s.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardno + "\n Pin:"+ pin);
                    
                    setVisible(false);
                    new Deposit(pin).setVisible(true);
                                       
                }
          
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            
            } else if(ae.getSource()==b2){
                    System.exit(0);
            }
    }
    
    public static void  main(String args[]){
        new SignupThree("");
    }
}
