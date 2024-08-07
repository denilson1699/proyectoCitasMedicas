// proyecto hotel
package persistencia;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class Operacion {
    
    public static String ejecutar(String sql){
        String msg="Operacion Exitosa";
        try {
            Connection cn= new Conexion().getConexionSQLserverLocal();
            if(cn!=null){
                Statement st=cn.createStatement();
                st.executeUpdate(sql);
                cn.close();
            }else{
                msg="no hay conexion con la base de datos del hotel";
            }
            
        } catch (Exception e) {
            msg=e.getMessage();
        }
        return msg;
    } 
    
    public static String ejecutarConRespuesta(String sql){
        String msg="";
        try {
            Connection cn= new Conexion().getConexionSQLserverLocal();
            if(cn!=null){
                Statement st=cn.createStatement();
                ResultSet r=st.executeQuery(sql);
                String Respuesta="";
                while(r.next()){
                Respuesta=r.getString(1).toString();
                }
                cn.close();
                return msg=Respuesta;
            }else{
                msg="no hay conexion con la base de datos";
            }
            
        } catch (Exception e) {
            msg=e.getMessage();
        }
        return msg;
    } 
    
       public static List listar(String sql){
       List lista= new ArrayList();
       try {
           Connection cn= new Conexion().getConexionSQLserverLocal();
           if(cn!=null){
               Statement st= cn.createStatement();
               ResultSet rs=st.executeQuery(sql);
               ResultSetMetaData rm= rs.getMetaData();// informacion sobre las tablas
               int numCol=rm.getColumnCount();
               String [] titCol=new String[numCol];
               for(int i=0;i<numCol;i++)
                   titCol[i]=rm.getColumnName(i+1);// recuperar el nombre de los titulos
               lista.add(titCol);
               while(rs.next()){
                   Object[] fila=new Object[numCol];
                   for(int i =0;i<numCol;i++)
                       fila[i]=rs.getObject(i+1);
                   lista.add(fila);
               }
               cn.close();

           }else{
               lista=null;
           }
       } catch (SQLException e) {
           lista=null;
       }
       return lista;       
   }
   
    public static Object[] buscar (String sql){
        Object[] fila=null;
        List lista= listar(sql);
        if(lista!=null){
            if(lista.size()>1)
                fila= (Object[])lista.get(1);
        }
        return fila;
    }
}
