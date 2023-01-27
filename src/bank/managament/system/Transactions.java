package bank.managament.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Transactions extends JFrame implements ActionListener{
    String pin;
    JLabel l1;
    JButton b1,b2,b3,b4,b5;
    Transactions(String pin){
        this.pin = pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 900, 900);
        add(l2);
        
        l1 = new JLabel("Please Select Your Transaction");
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(330,260,700,35);
        l2.add(l1);
        
        b1 = new JButton("DEPOSIT");
        b1.setBounds(190,320,170,35);
        b1.addActionListener(this);
        l2.add(b1);
        
        b2 = new JButton("CASH WITHDRAWAL");
        b2.setBounds(190,360,170,35);
        b2.addActionListener(this);
        l2.add(b2);
        
        b3 = new JButton("BALANCE INQUIRIES");
        b3.setBounds(190,400,170,35);
        b3.addActionListener(this);
        l2.add(b3);
        
        b4 = new JButton("PIN CHANGE");
        b4.setBounds(550,320,170,35);
        b4.addActionListener(this);
        l2.add(b4);
        
        b5 = new JButton("EXIT");
        b5.setBounds(550,360,170,35);
        b5.addActionListener(this);
        l2.add(b5);
        
        setSize(900,900);
        setLocation(300,0);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b5){
            System.exit(0);
        } else if(ae.getSource()==b1){
            setVisible(false);
            new Deposit(pin).setVisible(true);
        } else if(ae.getSource()==b2){
                    setVisible(false);
                    new Withdraw(pin).setVisible(true);
        }else if(ae.getSource()==b4){ 
                    setVisible(false);
                    new PinChange(pin).setVisible(true);
        } else if(ae.getSource()==b3){ 
            this.setVisible(false);
            new Balance(pin).setVisible(true);
        }
    }
    public static void  main(String args[]){
        new Transactions("");
    }
}
