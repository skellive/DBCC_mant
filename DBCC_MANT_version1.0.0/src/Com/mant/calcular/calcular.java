/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.mant.calcular;

import ClassDAO.VehiculosDAO;
import Com.mant.CRUD.conexion.conexion;
import Com.mant.controladorVO.VehiculoVO;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author User
 */
public class calcular {

    public boolean calculo(String kil, String CHASIS) {

        String chasis = CHASIS;
        Integer kilo = parseInt(kil);
        Integer rango;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conexion conn = new conexion();
        Connection cc = conn.getConexion();
        VehiculoVO vhvo = new VehiculoVO();
        VehiculosDAO vhda = new VehiculosDAO();

        try {
            if (kilo < 5000) {
                String sql = "SELECT vehiculo.`CHASIS`,\n"
                        + "mantenimiento_auto.`Tipo_carroceria`,\n"
                        + "mantenimiento_auto.`Motor`,\n"
                        + "mantenimiento_auto.`Filtro_aceite`,\n"
                        + "mantenimiento_auto.`Bobinas`,\n"
                        + "mantenimiento_auto.`Bujias`,\n"
                        + "mantenimiento_auto.`Filtro_aire`,\n"
                        + "mantenimiento_auto.`Bomba_gasolina`,\n"
                        + "mantenimiento_auto.`Microfiltro`,\n"
                        + "mantenimiento_auto.`Pastillas_del`,\n"
                        + "mantenimiento_auto.`Sensor_del`,\n"
                        + "mantenimiento_auto.`Pastillas_post`,\n"
                        + "mantenimiento_auto.`Sensor_post`\n"
                        + "FROM vehiculo \n"
                        + "INNER JOIN mantenimiento_auto ON mantenimiento_auto.Id_producto = vehiculo.`id_vehiculo` WHERE mantenimiento_auto.CHASIS " + chasis + ";";

                ps = cc.prepareStatement(sql);
                rs = ps.executeQuery();
                DefaultTableModel modelo = new DefaultTableModel();
                ResultSetMetaData rsMD = rs.getMetaData();
                int cantidadColumnas = rsMD.getColumnCount();
                modelo.addColumn("Tipo carroceria");
                modelo.addColumn("Motor");
                modelo.addColumn("Filtro aceite");
                modelo.addColumn("Bobinas");
                modelo.addColumn("Bujias");
                modelo.addColumn("Filtro aire");
                modelo.addColumn("Bomba gasolina");
                modelo.addColumn("Microfiltro");
                modelo.addColumn("Pastillas del");
                modelo.addColumn("Sensor del");
                modelo.addColumn("Pastillas post");
                modelo.addColumn("Sensor post");
                while (rs.next()) {

                    Object[] filas = new Object[cantidadColumnas];

                    for (int i = 0; i < cantidadColumnas; i++) {
                        filas[i] = rs.getObject(i + 1);
                    }
                    modelo.addRow(filas);
                    return true;

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(calcular.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return false;

    }

}
