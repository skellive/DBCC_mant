/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassDAO;

import Com.mant.CRUD.conexion.conexion;
import Com.mant.controladorVO.Tipo_usuarioVO;
import Com.mant.vista.image.pantalla.registroUsuariosEC;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author User
 */
public class Tipo_usuarioDAO {
    Tipo_usuarioVO tip_user = new Tipo_usuarioVO();
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
        dat.setId_tipo(0);
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
    
   /* public void cbPuestoItemStateChanged(java.awt.event.ItemEvent  evt) {                                          
        
        if(evt.getStateChange() == ItemEvent.SELECTED){
            registroUsuariosEC reg = new registroUsuariosEC();
            PreparedStatement ps = null;
        ResultSet rs = null;
        conexion conn = new conexion();
        Connection con = conn.getConexion();
        
        
            Tipo_usuarioVO est = (Tipo_usuarioVO) reg.cbPuesto.getSelectedItem();
            est.getId_tipo();
            
            
            try {
                String sql = "INSERT INTO usuarios(id_tipo) values("+ est+ ")";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
            } catch (SQLException e) {
                System.err.println(e.toString());
            }
           
        }else{
            System.err.println("Error al obtener");
        }
    }*/
    
}
