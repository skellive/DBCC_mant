/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.mant.CRUD.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SKEL_LIVE
 */
public class conexion {
    
    public String base="elian_0zh7kki8n";
    public String user ="elian";
    public String password="sbpm12072020JPA";
    public String url ="jdbc:mysql://mysql-elian.alwaysdata.net:3306/"+ base;
    public Connection con = null;
    public Statement sentencia;
    public ResultSet resultado;
    
    public Connection getConexion(){
       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return con;
    }
    
    
}
