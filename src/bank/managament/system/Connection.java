package bank.managament.system;
 
import java.sql.*;
        
public class Connection {
    java.sql.Connection c;
    Statement s;
    public Connection(){  
        try{   
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagement","root","malina");   
            
            s =c.createStatement(); 
           
          
            
        }catch(Exception e){ 
            System.out.println(e);
        }  
    }  
    
}
