package bank.managament.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
public class SignupTwo extends JFrame implements ActionListener{
    long random;
    JTextField additionalTextField,religionTextField,incomeTextField,educationTextField,occupationTextField,cnpTextField;
    JDateChooser dateChooser;
    JRadioButton r1,r2;
    JButton next;
    JComboBox c1,c2,c3,c4;
    String formno;
    JLabel l,l2;
    SignupTwo(String formno){
        setLayout(null);
        setTitle("Application Form - Page 2");
        this.formno = formno;
        JLabel additional = new JLabel("Additional details");
        additional.setFont(new Font("Osward",Font.BOLD,20));
        additional.setBounds(290,80,200,30);
        add(additional);
        
        l2 = new JLabel("Existing Account:");
        l2.setFont(new Font("Raleway", Font.BOLD, 18));
        l2.setBounds(100,140,250,30);
        add(l2);
        
        JLabel cnp = new JLabel("CNP: ");
        cnp.setFont(new Font("Osward",Font.BOLD,20));
        cnp.setBounds(100,180,100,30);
        add(cnp);
        
        JLabel religion = new JLabel("Religion: ");
        religion.setFont(new Font("Osward",Font.BOLD,20));
        religion.setBounds(100,220,100,30);
        add(religion);
        
        JLabel income = new JLabel("Income: ");
        income.setFont(new Font("Osward",Font.BOLD,20));
        income.setBounds(100,260,200,30);
        add(income);
        
        JLabel education = new JLabel("Education: ");
        education.setFont(new Font("Osward",Font.BOLD,20));
        education.setBounds(100,300,200,30);
        add(education);
        
        JLabel occupation = new JLabel("Occupation: ");
        occupation.setFont(new Font("Osward",Font.BOLD,20));
        occupation.setBounds(100,340,200,30);
        add(occupation);
        
        cnpTextField = new JTextField();
        cnpTextField.setFont(new Font("Osward",Font.BOLD,14));
        cnpTextField.setBounds(300,180,200,30);
        add(cnpTextField);
        
        String ValReligion[] = {"Christian","Hindu","Muslim","Other"};
        c1 = new JComboBox(ValReligion);
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 14));
        c1.setBounds(300,220,200,30);
        add(c1);
        
        
        String ValIncome[] = {"NULL","<2000","2000-5000",">5000"};
        c2 = new JComboBox(ValIncome);
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Osward",Font.BOLD,14));
        c2.setBounds(300,260,200,30);
        add(c2);
        
        String EducationValue[] = {"Non-Graduate","Graduate","Post-Graduate","Doctorate","Others"};
        c3 = new JComboBox(EducationValue);
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Osward",Font.BOLD,14));
        c3.setBounds(300,300,200,30);
        add(c3);
        
        String OccupationValue[] = {"Salaried","Self-Employmed","Business","Student","Retired","Others"};
        c4 = new JComboBox(OccupationValue);
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Osward",Font.BOLD,14));
        c4.setBounds(300,340,200,30);
        add(c4);
          
        next = new JButton("NEXT");
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(350,400,80,30);
        next.addActionListener(this); 
        add(next);
        
        r1 = new JRadioButton("Yes");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(Color.WHITE);
        r1.setBounds(300,140,100,30);
        add(r1);
        
        r2 = new JRadioButton("No");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(Color.WHITE);
        r2.setBounds(400,140,100,30);
        add(r2);
        
        l = new JLabel(formno);
        l.setFont(new Font("Raleway", Font.BOLD, 13));
        
        getContentPane().setBackground(Color.white);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String religion = (String)c1.getSelectedItem();   
        String income = (String)c2.getSelectedItem();
        String education = (String)c3.getSelectedItem();
        String occupation = (String)c4.getSelectedItem();
        String existingaccount = null;
         if(r1.isSelected()){ 
            existingaccount = "Yes";
        } else if(r2.isSelected()){ 
            existingaccount = "No";
        }
        String cnp = cnpTextField.getText();
        try{
            if(cnpTextField.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            }else{
                Connection c = new Connection();
                String q1 = "insert into signuptwo values('"+formno+"','"+cnp+"','"+religion+"','"+income+"','"+education+"','"+occupation+"','"+existingaccount+"')";
                c.s.executeUpdate(q1);
                
                new SignupThree(formno).setVisible(true);
                //setVisible(false);
            }
                
      
            
        }catch(Exception ex){
             ex.printStackTrace();
        }
         
    }
    public static void  main(String args[]){
        new SignupTwo("").setVisible(true);
    }
}
