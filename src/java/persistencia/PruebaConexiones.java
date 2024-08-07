
package persistencia;

import java.sql.Connection;

public class PruebaConexiones {

    public static void main(String[] args) {

    // probar si hay conexion con la base de datos
        Connection cn= new Conexion().getConexionSQLserverLocal();
    if(cn!=null){
        System.out.println("si hay conexion con la BD citas medicas SQLSERVER");
    }else{
        System.out.println("no hay conexion con bd ");
    }
    }
    
}
