package bank.managament.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    
    JButton login,signup,clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){
        setTitle("ATM");
        
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(80,80,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);
        
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);
        
        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Raleway",Font.BOLD,20));
        card.setBounds(100,150,150,40);
        add(card);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(250, 150, 250, 40);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);
        
        JLabel pin = new JLabel("PIN");
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setBounds(100,200,400,40);
        add(pin);
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(250, 200, 250, 40);
        add(pinTextField);
        
        login = new JButton("SIGN IN");
        login.setBounds(250, 300, 100, 40);
        add(login);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        
        clear = new JButton("Clear");
        clear.setBounds(400, 300, 100, 40);
        add(clear);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        
        signup = new JButton("Sign up");
        signup.setBounds(250, 350, 250, 40);
        add(signup);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        
        getContentPane().setBackground(Color.white);
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if(ae.getSource() == login) {
            Connection conn = new Connection();
            String cardnumber  = cardTextField.getText();
            String pinnumber  = pinTextField.getText();
            String query  = "select * from login where cardno = '"+cardnumber+"' and pin = '"+pinnumber+"'";
            try{
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            }    
            catch(Exception e){
            System.out.println(e);
            }
        }
        else if(ae.getSource() == signup) {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    
    public static void  main(String args[]) {
        new Login();
    }
}
