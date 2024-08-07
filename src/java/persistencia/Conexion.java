// proyecto hotel
package persistencia;
import java.sql.*;
public class Conexion {
    
    
    public Connection getConexion(){
    Connection cn;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            cn=DriverManager.getConnection("jdbc:derby://localhost:1527/BDcitasMedicas","denilson","123");
        } catch (Exception e) {
            cn=null;
        }
        return cn;
    }
   
// conecion con MYSQL
    public Connection getConexionMysqlLocal(){
        Connection cn;
        try {
            Class.forName("com.mysql.jdbc.Driver");//org.apache.derby.jdbc.ClientDriver
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_citasmedicas","root","");
        } catch (Exception e) {
            cn=null;
        }
        return cn;
    }
    
//conecion con SQLSERVER
    public Connection getConexionSQLserverLocal(){
        Connection cn;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//se conecta al driver
            String connectionBD="jdbc:sqlserver://DESKTOP-2U84SSU:1433;databaseName=BD_CITASMEDICAS;user=sa;password=123;";
            cn=DriverManager.getConnection(connectionBD);
        }catch(ClassNotFoundException e){
            System.out.println("error "+e.getMessage());
            cn=null;
        }catch(SQLException e){
            System.out.println("error "+e.getMessage());
            cn=null;
        }        
        catch (Exception e) {
            System.out.println("error "+e.getMessage());
            cn=null;
        }
        return cn;
    }
    
    
//conecion con  mi mysql remoto DENILSONS   byethost7
          public Connection getConexionDenilsonRemota1(){
        Connection cn;
        try {
            String url="jdbc:mysql://localhost:3306/b7_28638541_dbPersonal";
            String usuario="b7_28638541";
            String pass="1499Morropon";
            
            Class.forName("com.mysql.jdbc.Driver");//org.apache.derby.jdbc.ClientDriver
            cn=DriverManager.getConnection(url,usuario,pass);
           }catch(ClassNotFoundException e){
            System.out.println("error "+e.getMessage());
            cn=null;
        }catch(SQLException e){
            System.out.println("error "+e.getMessage());
            cn=null;
        }        
        catch (Exception e) {
            System.out.println("error "+e.getMessage());
            cn=null;
        }
        return cn;
    }
      
//conecion con  mi mysql remoto DENILSONS  WEB00OHOST 
          public Connection getConexionDenilsonWEB00OHOST(){
        Connection cn;
        try {
            String url="jdbc:mysql://botdenilson.000webhostapp.com:3306/id16830042_bd_prueba";
            String usuario="id16830042_denilson";
            String pass="Mnftc3E*bI!KNY_k";
            
            Class.forName("com.mysql.jdbc.Driver");//org.apache.derby.jdbc.ClientDriver
            cn=DriverManager.getConnection(url,usuario,pass);
           }catch(ClassNotFoundException e){
            System.out.println("error "+e.getMessage());
            cn=null;
        }catch(SQLException e){
            System.out.println("error "+e.getMessage());
            cn=null;
        }        
        catch (Exception e) {
            System.out.println("error "+e.getMessage());
            cn=null;
        }
        return cn;
    }          
          
    // conecion con otra mysql AGRODIRAC
        public Connection getConexionAGRODIRAC(){
        Connection cn;
        try {
            String url="jdbc:mysql://guisel.com:3306/guisel_bd_prueba";
            String usuario="guisel_agrodirac";
            String pass="agrodirac_2021";
            
            Class.forName("com.mysql.jdbc.Driver");//org.apache.derby.jdbc.ClientDriver
            cn=DriverManager.getConnection(url,usuario,pass);
            System.out.println("-"+cn);
            }       
        catch (Exception e) {
            System.out.println("error "+e.getMessage());
            cn=null;
        }
        return cn;
    }
        
        
}