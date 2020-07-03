/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassDAO;

import Com.mant.CRUD.conexion.conexion;
import Com.mant.controladorVO.Calculo_mantenimiento_autoVO;
import Com.mant.controladorVO.Mantenimiento_autoVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author SKEL_LIVE
 */
public class Calculo_mantenimiento_autoDAO {
    
    
    public static Calculo_mantenimiento_autoVO buscarRepuestos(String CHASIS) {
        Calculo_mantenimiento_autoVO cma = new Calculo_mantenimiento_autoVO();
        String result = null;
        conexion cc = new conexion();
        Connection con = cc.getConexion();
        PreparedStatement pst = null;
        String sql = "SELECT * FROM mantenimiento_auto WHERE CHASIS = %?%;";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, CHASIS);            
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                cma.setId_calculo_mantenimiento_auto(Integer.parseInt(rs.getString(1)));
                cma.setCHASIS(rs.getString(2));
                cma.setTipo_carroceria(rs.getString(3));
                cma.setNumero_articulo(rs.getString(4));
                

            }
            JOptionPane.showMessageDialog(null, "Busqueda en proceso, ID:" + cma.getCHASIS());

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al procesar: " + e.getMessage());

        } 

        return cma;

    }
    
}
