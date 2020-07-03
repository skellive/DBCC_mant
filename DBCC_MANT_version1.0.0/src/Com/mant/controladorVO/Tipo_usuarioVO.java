/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.mant.controladorVO;

import Com.mant.CRUD.conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Tipo_usuarioVO {

    private Integer id_tipo;
    private String Nombre;

    public Integer getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(Integer id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Vector<Tipo_usuarioVO> mostrarEstados(){
         
    PreparedStatement ps = null;
        ResultSet rs = null;
        conexion conn = new conexion();
        Connection con = conn.getConexion();
        Vector<Tipo_usuarioVO> datos = new Vector<Tipo_usuarioVO>();
        Tipo_usuarioVO dat = null;
        
        
        
        try{
        
         dat = new Tipo_usuarioVO();
        
        String sql = "SELECT * FROM tipo_user";
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();        
        dat.setNombre("Seleccione puesto"); 
        datos.add(dat);
        while (rs.next()) {
            dat = new Tipo_usuarioVO();
        dat.setId_tipo(rs.getInt("id_tipo"));
        dat.setNombre(rs.getString("Nombre")); 
        datos.add(dat);
        }        
        }catch(SQLException e){
        System.err.println(e.toString());
    
    }
        return datos; 
    }

    
    
}
