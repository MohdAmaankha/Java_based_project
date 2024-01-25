import java.sql.*;

public class Conn {
    Connection  c;
    Statement s;
    public Conn(){// consrutor
        
        try {
          //  Class.forName(com.mysql.cj.jdbc.Driver); 
            c = DriverManager.getConnection("jdbc:mysql:///banksystem","root", "1234amaan");
            s = c.createStatement();    
        } catch (Exception e) {
            // TODO: handle exception
           // e.printStackTrace();
              System.out.println(e);
        }
    }

   
            
    
}
