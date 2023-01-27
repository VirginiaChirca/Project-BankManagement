package bank.managament.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
public class SignupOne extends JFrame implements ActionListener{
    long random;
    JTextField nameTextField,emailTextField,addressTextField,countryTextField,cityTextField,pinTextField,mobileTextField;
    JDateChooser dateChooser;
    JRadioButton b1,b2,b3,b4;
    JButton next;
    SignupOne(){
        setLayout(null);
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);
        
        JLabel formno = new JLabel("Application form no." + random);
        formno.setFont(new Font("Osward",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        JLabel name = new JLabel("Personal details");
        name.setFont(new Font("Osward",Font.BOLD,20));
        name.setBounds(290,80,200,30);
        add(name);
        
        JLabel details = new JLabel("Name: ");
        details.setFont(new Font("Osward",Font.BOLD,20));
        details.setBounds(100,140,100,30);
        add(details);
        
        JLabel birth = new JLabel("Date of birth: ");
        birth.setFont(new Font("Osward",Font.BOLD,20));
        birth.setBounds(100,180,200,30);
        add(birth);
        
        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Osward",Font.BOLD,20));
        gender.setBounds(100,220,200,30);
        add(gender);
        
        JLabel email = new JLabel("Email: ");
        email.setFont(new Font("Osward",Font.BOLD,20));
        email.setBounds(100,260,200,30);
        add(email);
        
        JLabel status = new JLabel("Marital Status: ");
        status.setFont(new Font("Osward",Font.BOLD,20));
        status.setBounds(100,300,200,30);
        add(status);
        
        JLabel mobile = new JLabel("Mobile Number: ");
        mobile.setFont(new Font("Osward",Font.BOLD,20));
        mobile.setBounds(100,340,200,30);
        add(mobile);
        
        JLabel address = new JLabel("Address: ");
        address.setFont(new Font("Osward",Font.BOLD,20));
        address.setBounds(100,380,200,30);
        add(address);
        
        JLabel city = new JLabel("City: ");
        city.setFont(new Font("Osward",Font.BOLD,20));
        city.setBounds(100,420,200,30);
        add(city);
        
        JLabel country = new JLabel("Country: ");
        country.setFont(new Font("Osward",Font.BOLD,20));
        country.setBounds(100,460,200,30);
        add(country);
        
        JLabel pincode = new JLabel("Pincode: ");
        pincode.setFont(new Font("Osward",Font.BOLD,20));
        pincode.setBounds(100,500,200,30);
        add(pincode);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Osward",Font.BOLD,14));
        nameTextField.setBounds(300,140,200,30);
        add(nameTextField);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Osward",Font.BOLD,14));
        emailTextField.setBounds(300,260,200,30);
        add(emailTextField);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Osward",Font.BOLD,14));
        addressTextField.setBounds(300,380,200,30);
        add(addressTextField);
        
        countryTextField = new JTextField();
        countryTextField.setFont(new Font("Osward",Font.BOLD,14));
        countryTextField.setBounds(300,460,200,30);
        add(countryTextField);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Osward",Font.BOLD,14));
        cityTextField.setBounds(300,420,200,30);
        add(cityTextField);
        
        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Osward",Font.BOLD,14));
        pinTextField.setBounds(300,500,200,30);
        add(pinTextField);
        
        mobileTextField = new JTextField();
        mobileTextField.setFont(new Font("Osward",Font.BOLD,14));
        mobileTextField.setBounds(300,340,200,30);
        add(mobileTextField);
        
        dateChooser = new JDateChooser();
	dateChooser.setForeground(new Color(105, 105, 105));
	dateChooser.setBounds(300,180,200,30);
	add(dateChooser);

        b1 = new JRadioButton("Male");
        b1.setFont(new Font("Raleway", Font.BOLD, 14));
        b1.setBounds(300,220,60,30);
        b1.setBackground(Color.WHITE);
        add(b1);
        
        b2 = new JRadioButton("Female");
        b2.setFont(new Font("Raleway", Font.BOLD, 14));
        b2.setBounds(400,220,150,30);
        b2.setBackground(Color.WHITE);
        add(b2);
        
        ButtonGroup group = new ButtonGroup();
        group.add(b1);
        group.add(b2);
        
        b3 = new JRadioButton("Married");
        b3.setFont(new Font("Raleway", Font.BOLD, 14));
        b3.setBounds(300,300,100,30);
        b3.setBackground(Color.WHITE);
        add(b3);
        
        b4 = new JRadioButton("Unmarried");
        b4.setFont(new Font("Raleway", Font.BOLD, 14));
        b4.setBounds(400,300,100,30);
        b4.setBackground(Color.WHITE);
        add(b4);
        
        ButtonGroup group2 = new ButtonGroup();
        group.add(b3);
        group.add(b4);
        
        next = new JButton("NEXT");
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(350,630,80,30);
        next.addActionListener(this); 
        add(next);
        
        getContentPane().setBackground(Color.white);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String formno = ""+random;
        String name = nameTextField.getText();
        String birth = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String pincode = pinTextField.getText();
        String country = countryTextField.getText();
        String mobile = mobileTextField.getText();
        
        
        if(b1.isSelected()){ 
            gender = "Male";
        }else if(b2.isSelected()){ 
            gender = "Female";
        }
        
        String email = emailTextField.getText();
        String status = null;
        if(b3.isSelected()){ 
            status = "Married";
        }else if(b3.isSelected()){ 
            status = "Unmarried";
        }
        
        try{
           
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            }else{
                Connection c1 = new Connection();
                String q1 = "insert into signup values('"+formno+"','"+name+"','"+birth+"','"+gender+"','"+email+"','"+mobile+"','"+status+"','"+address+"','"+city+"','"+pincode+"','"+country+"')";
                c1.s.executeUpdate(q1);
                
                new SignupTwo(formno).setVisible(true);
                setVisible(false);
            }
            
        }catch(Exception e){
             e.printStackTrace();
        }
        
    }
    public static void  main(String args[]){
        new SignupOne().setVisible(true);
    }
}
