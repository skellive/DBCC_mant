/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassDAO;

import Com.mant.CRUD.conexion.conexion;
import Com.mant.controladorVO.Calculo_mantenimiento_autoVO;
import Com.mant.controladorVO.Mantenimiento_autoVO;
import Com.mant.controladorVO.UsuariosVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author SKEL_LIVE
 */
public class Mantenimiento_autoDAO {
    
     public static String registrarMantenimiento_auto(Mantenimiento_autoVO mautv) {
        String result = null, last = null;
        conexion cc = new conexion();
        Connection con = cc.getConexion();
        PreparedStatement pst = null;
        String sql = "INSERT INTO mantenimiento_auto values(null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, mautv.getId_producto());
            pst.setString(2, mautv.getTipo_carroceria());
            pst.setString(3, mautv.getMotor());
            pst.setString(4, mautv.getSerie_fabrica());
            pst.setString(5, mautv.getCHASIS());
            pst.setString(6, mautv.getFiltro_aceite());
            pst.setString(7, mautv.getBobinas());
            pst.setString(8, mautv.getBujias());
            pst.setString(9, mautv.getFiltro_aire());
            pst.setString(10, mautv.getBomba_gasolina());
            pst.setString(11, mautv.getMicrofiltro());
            pst.setString(12, mautv.getPastillas_del());
            pst.setString(13, mautv.getSensor_del());
            pst.setString(14, mautv.getPastillas_post());
            pst.setString(15, mautv.getSensor_post());
            pst.setString(16, mautv.getDisco_del_1());
            pst.setString(17, mautv.getDisco_del_2());
            pst.setString(18, mautv.getDisco_post_1());
            pst.setString(19, mautv.getDisco_post_2());
            
            
            pst.execute();
            pst = con.prepareStatement("SELECT MAX(id_producto) AS id FROM mantenimiento_auto");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                last = rs.getString(1);

            }
            JOptionPane.showMessageDialog(null,"Registrado con exito" );

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al procesar: " + e.getMessage());

        } finally {
            try {
                if (con != null) {
                    con.close();
                    pst.close();
                }
            } catch (SQLException e) {
                result = "Error: " + e;

            }
        }

        return result;

    }

    public static String actualizarMantenimiento_auto(Mantenimiento_autoVO mautv) {
        String result = null, last = null;
        conexion cc = new conexion();
        Connection con = cc.getConexion();
        PreparedStatement pst = null;
        String sql = "UPDATE mantenimiento_auto SET Nombre = ?, Apellido = ?, Usuario = ?, Contrasenia = ?, Puesto_trabajo = ? WHERE id_usuario = ? ";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, mautv.getId_producto());
            pst.setString(2, mautv.getTipo_carroceria());
            pst.setString(3, mautv.getMotor());
            pst.setString(4, mautv.getSerie_fabrica());
            pst.setString(5, mautv.getCHASIS());
            pst.setString(6, mautv.getFiltro_aceite());
            pst.setString(7, mautv.getBobinas());
            pst.setString(8, mautv.getBujias());
            pst.setString(9, mautv.getFiltro_aire());
            pst.setString(10, mautv.getBomba_gasolina());
            pst.setString(11, mautv.getMicrofiltro());
            pst.setString(12, mautv.getPastillas_del());
            pst.setString(13, mautv.getSensor_del());
            pst.setString(14, mautv.getPastillas_post());
            pst.setString(15, mautv.getSensor_post());
            pst.setString(16, mautv.getDisco_del_1());
            pst.setString(17, mautv.getDisco_del_2());
            pst.setString(18, mautv.getDisco_post_1());
            pst.setString(19, mautv.getDisco_post_2());              
            pst.setInt(20, mautv.getId_producto());
            pst.execute();

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                last = rs.getString(1);

            }
           JOptionPane.showMessageDialog(null, "Actualizado con exito, ID:" + mautv.getId_producto());

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al procesar: " + e.getMessage());

        } finally {
            try {
                if (con != null) {
                    con.close();
                    pst.close();
                }
            } catch (SQLException e) {
                result = "Error: " + e;

            }
        }

        return result;

    }

    public static Mantenimiento_autoVO buscarRepuestos(String Id_producto, String Nombre) {
        Mantenimiento_autoVO cma = new Mantenimiento_autoVO();
        String result = null;
        conexion cc = new conexion();
        Connection con = cc.getConexion();
        PreparedStatement pst = null;
        String sql = "SELECT * FROM mantenimiento_auto WHERE Id_producto = ? OR CHASIS = ? OR Tipo_carroceria = %?%;";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, Id_producto);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                cma.setId_producto(Integer.parseInt(rs.getString(1)));
                cma.setCHASIS(rs.getString(2));
                cma.setSerie_fabrica(rs.getString(3));
                cma.setMotor(rs.getString(4));
                

            }
            JOptionPane.showMessageDialog(null, "Busqueda en proceso, ID:" + cma.getCHASIS());

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al procesar: " + e.getMessage());

        } finally {
            try {
                if (con != null) {
                    con.close();
                    pst.close();
                }
            } catch (SQLException e) {
                cma.setResultado("Error: " + e);

            }
        }

        return cma;

    }

    public static String eliminarMantenimiento_auto(String clave) {
        String result = null;
        conexion cc = new conexion();
        Connection con = cc.getConexion();
        PreparedStatement pst = null;
        String sql = "DELETE FROM mantenimiento_auto WHERE CHASIS = ?;";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, clave);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Chasis eliminado con exito");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al procesar: " + e.getMessage());

        } finally {
            try {
                if (con != null) {
                    con.close();
                    pst.close();
                }
            } catch (SQLException e) {
                result = "Error: " + e;

            }
        }

        return result;

    }

    public static ArrayList<UsuariosVO> getListUsuarios() {
        ArrayList<UsuariosVO> arrUser = new ArrayList<UsuariosVO>();
        conexion cc = new conexion();
        Connection con = cc.getConexion();
        PreparedStatement pst = null;
        UsuariosVO userv = null;
        String sql = "SELECT * FROM usuarios;";
        try {
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                userv = new UsuariosVO();
                userv.setId_usuario(Integer.parseInt(rs.getString(1)));
                userv.setNombre(rs.getString(2));

                if (arrUser.isEmpty()) {
                    arrUser.add(0, userv);

                } else {
                    arrUser.add(userv);
                }

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al procesar: " + e.getMessage());

        } finally {
            try {
                if (con != null) {
                    con.close();
                    pst.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e);

            }
        }
        return arrUser;
    }

    
}
