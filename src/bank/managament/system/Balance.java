package bank.managament.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import java.util.*;

public class Balance extends JFrame implements ActionListener{
    String pin;
    JTextField t1, t2;
    JButton b1, b2, b3;
    JLabel l1, l2, l3;
    Balance(String pin) {
        this.pin = pin;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 900, 900);
        add(l2);
        
        l1 = new JLabel();
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(330,260,700,35);
        l2.add(l1);
        
        b2 = new JButton("BACK");
        b2.setBounds(500,450,150,35);
        l2.add(b2);
        
        b2.addActionListener(this);
        
        int balance = 0;
        try{
            Connection c1 = new Connection();
            ResultSet rs = c1.s.executeQuery("select * from bank where pin = '"+pin+"'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception e){}
        
        l3 = new JLabel();
        l3.setText("Your Current Account Balance is " + balance);
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("System", Font.BOLD, 20));
        l3.setBounds(250,300,700,35);
        l2.add(l3);
        
        setSize(900,900);
        setLocation(300,0);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pin).setVisible(true);
    }
    
    public static void main(String[] args) {
        new Balance("").setVisible(true);
    }
}
