package bank.managament.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Withdraw  extends JFrame implements ActionListener{
    JLabel l1,l2,l3;
    JTextField t1,t2;
    JButton b1,b2,b3;
    String pin;
    Withdraw(String pin){
        this.pin = pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 900, 900);
        add(l2);
        
        l1 = new JLabel("Enter the amount you want to withdraw");
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(320,260,500,35);
        l2.add(l1);
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));
        t1.setBounds(200,320,500,35);
        l2.add(t1);
        
        b1 = new JButton("WITHDRAW");
        b1.setBounds(250,450,150,35);
        l2.add(b1);
        
        b2 = new JButton("BACK");
        b2.setBounds(500,450,150,35);
        l2.add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        try{
            if(ae.getSource()==b1){
                String deposit = t1.getText();
                Date date = new Date();
                if(deposit.equals("")){
                        JOptionPane.showMessageDialog(null, "Please enter the amount to you want to Withdraw");
                } else {
                    Connection c1 = new Connection();
                    String query = "insert into bank values('"+pin+"', '"+date+"', 'Withdraw', '"+deposit+"')";
                    c1.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Lei. "+deposit+" Withdraw Successfully");
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }
            } else if(ae.getSource()==b2){
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }

         }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Withdraw("").setVisible(true);
    }
}
