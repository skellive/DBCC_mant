/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassDAO;

import Com.mant.CRUD.conexion.conexion;
import Com.mant.controladorVO.UsuariosVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author SKEL_LIVE
 */
public class UsuariosDAO extends conexion {

    public boolean registrarUsuarios(UsuariosVO userv, Integer usuario) {

        conexion cc = new conexion();
        Connection con = cc.getConexion();
        PreparedStatement pst = null;        
        String sql = "INSERT INTO usuarios(Nombre, Apellido, Usuario, Contrasenia, id_tipo) values(?, ?, ?, ?, ?)";       
                        
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, userv.getNombre());
            pst.setString(2, userv.getApellido());
            pst.setString(3, userv.getUsuario());
            pst.setString(4, userv.getContrasenia()); 
            pst.setInt(5, usuario);
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al procesar: " + e.getMessage());
            return false;
        }

    }
    
    public int puesto(String usuar){
        int numb=0;
        try {
            conexion cc = new conexion();
            Connection con = cc.getConexion();            
            PreparedStatement pst = null;
            ResultSet rs = null;
            String sql = "SELECT id_tipo FROM tipo_user WHERE Nombre = ?"; 
            pst = con.prepareStatement(sql);            
            pst.setString(1,usuar);

            rs = pst.executeQuery();
            while(rs.next()){
            return rs.getInt("id_tipo");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ClassDAO.UsuariosDAO.puesto():  "+ex.getMessage());
           
        }
        return numb; 
    }
    public boolean login(UsuariosVO user) {
        ResultSet rs = null;
        conexion cc = new conexion();
        Connection con = cc.getConexion();
        PreparedStatement pst = null;
        String sql = "SELECT u.id_usuario, u.Nombre, u.Apellido, u.Usuario, u.Contrasenia, u.id_tipo, t.Nombre FROM usuarios AS u INNER JOIN tipo_user AS t ON u.id_tipo = t.id_tipo WHERE usuario = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, user.getUsuario());
            rs = pst.executeQuery();

            if (rs.next()) {
                
                if(user.getContrasenia().equals(rs.getString(5))){
                    user.setId_usuario(rs.getInt(1));
                    user.setNombre(rs.getString(2));
                    user.setId_tipo(rs.getInt(6));
                    user.setNombre_tipo(rs.getString(7));
                    return true;
                    
                    
                }else{
                    return false;
                }
                
            }
            return false;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al procesar: " + e.getMessage());
            return false;
        }

    }
    public int existeUsuario(String usuario) {
        ResultSet rs = null;
        conexion cc = new conexion();
        Connection con = cc.getConexion();
        PreparedStatement pst = null;
        String sql = "SELECT count(id_usuario) FROM usuarios WHERE usuario = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, usuario);
            rs = pst.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }
            return 1;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al procesar: " + e.getMessage());
            return 1;
        }

    }

    public static String actualizarUsuarios(UsuariosVO userv) {
        String result = null, last = null;
        conexion cc = new conexion();
        Connection con = cc.getConexion();
        PreparedStatement pst = null;
        String sql = "UPDATE usuarios SET Nombre = ?, Apellido = ?, Usuario = ?, Contrasenia = ?, Puesto_trabajo = ? WHERE id_usuario = ? ";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, userv.getNombre());
            pst.setString(2, userv.getApellido());
            pst.setString(3, userv.getUsuario());
            pst.setString(4, userv.getContrasenia());
            pst.setInt(5, userv.getId_tipo());
            pst.setInt(6, userv.getId_usuario());
            pst.execute();

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                last = rs.getString(1);
                JOptionPane.showMessageDialog(null, "Usuario actualizado con exito, ID:" + userv.getId_usuario());

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
                result = "Error: " + e;

            }
        }

        return result;

    }
    
            public boolean actualizarContrasenia(UsuariosVO userv, UsuariosVO pasvac) {
        String result = null, last = null;
        conexion cc = new conexion();
        Connection con = cc.getConexion();
        PreparedStatement pst = null;
        String sql = "UPDATE usuarios SET Contrasenia = ? WHERE Usuario = ? ";
        try {
            
            
            pst = con.prepareStatement(sql);
            pst.setString(1, pasvac.getContrasenia());
            pst.setString(2, userv.getUsuario());
            pst.execute();

            

            
            JOptionPane.showMessageDialog(null, "Contraseña actualizada con exito, Usuario:" + userv.getUsuario());
            
             

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al procesar: " + e.getMessage());
            return false;

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
        return true;

        

    }
    
    
    

    public static UsuariosVO buscarUsuarios(String clave, String Nombre) {
        UsuariosVO userv = new UsuariosVO();
        String result = null;
        conexion cc = new conexion();
        Connection con = cc.getConexion();
        PreparedStatement pst = null;
        String sql = "SELECT * FROM usuarios WHERE id_usuario = ? OR Nombre = %?%;";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, clave);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                userv.setId_usuario(Integer.parseInt(rs.getString(1)));
                userv.setNombre(rs.getString(2));
                userv.setApellido(rs.getString(3));
                userv.setUsuario(rs.getString(4));
                userv.setId_tipo(rs.getInt(6));

            }
            JOptionPane.showMessageDialog(null, "Usuario encontrado con exito, ID:" + userv.getId_usuario());

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al procesar: " + e.getMessage());

        } finally {
            try {
                if (con != null) {
                    con.close();
                    pst.close();
                }
            } catch (SQLException e) {
                userv.setResultado("Error: " + e);

            }
        }

        return userv;

    }

    public static String eliminarUsuarios(String clave) {
        String result = null;
        conexion cc = new conexion();
        Connection con = cc.getConexion();
        PreparedStatement pst = null;
        String sql = "DELETE FROM usuarios WHERE id_usuario = ?;";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, clave);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Usuario eliminado con exito");

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
    
     public boolean esEmail(String correo) {

        // Patrón para validar el email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = pattern.matcher(correo);

        return mather.find();

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
