/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.mant.conexion_excel;

import Com.mant.CRUD.conexion.conexion;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class excel {

    public static void subirArchivosMotosVehiculo(String ruta) throws IOException, SQLException {

        conexion con = new conexion();
        

        try {
            Connection conn = con.getConexion();
            PreparedStatement ps;
            FileInputStream file = new FileInputStream(new File(ruta));

            XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet sheet = wb.getSheetAt(0);

            int numFilas = sheet.getLastRowNum();

            for (int a = 1; a <= numFilas; a++) {
                Row fila = sheet.getRow(a);

                ps = conn.prepareStatement("INSERT INTO vehiculo (CHASIS, id_serie, Tipo_carroceria, Tipo_motor, Serie_fabrica) VALUES(?, ?, ?, ?, ?)");

                ps.setString(1, fila.getCell(0).getStringCellValue());
                ps.setString(2, fila.getCell(1).getStringCellValue());
                ps.setString(3, fila.getCell(2).getStringCellValue());
                ps.setString(4, fila.getCell(3).getStringCellValue());
                ps.setString(5, fila.getCell(4).getStringCellValue());
                ps.execute();

            }
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(excel.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al procesar:" + ex);
        }

    }

    public static void subirArchivosMotosMoto(String ruta) throws IOException, SQLException {

        conexion con = new conexion();

        PreparedStatement ps2;

        try {
            Connection conn = con.getConexion();

            FileInputStream file = new FileInputStream(new File(ruta));

            XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet sheet = wb.getSheetAt(0);

            int numFilas = sheet.getLastRowNum();

            for (int a = 1; a <= numFilas; a++) {
                Row fila = sheet.getRow(a);

                ps2 = conn.prepareStatement("INSERT INTO mantenimiento_auto(Tipo_carroceria, CHASIS, Motor, Serie_fabrica, Filtro_aceite, Bobinas, Bujias, Filtro_aire, Bomba_gasolina, Microfiltro, Pastillas_del, Sensor_del, Pastillas_post, Sensor_post, Disco_del_1, Disco_del_2, Disco_post_1, Disco_post_2) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

                ps2.setString(1, fila.getCell(0).getStringCellValue());
                ps2.setString(2, fila.getCell(2).getStringCellValue());
                ps2.setString(3, fila.getCell(3).getStringCellValue());
                ps2.setString(4, fila.getCell(4).getStringCellValue());
                ps2.setDouble(5, fila.getCell(5).getNumericCellValue());
                ps2.setDouble(6, fila.getCell(6).getNumericCellValue());
                ps2.setDouble(7, fila.getCell(7).getNumericCellValue());
                ps2.setDouble(8, fila.getCell(8).getNumericCellValue());
                ps2.setDouble(9, fila.getCell(9).getNumericCellValue());
                ps2.setDouble(10, fila.getCell(10).getNumericCellValue());
                ps2.setDouble(11, fila.getCell(11).getNumericCellValue());
                ps2.setDouble(12, fila.getCell(11).getNumericCellValue());
                ps2.setDouble(13, fila.getCell(12).getNumericCellValue());
                ps2.setDouble(14, fila.getCell(13).getNumericCellValue());
                ps2.setDouble(15, fila.getCell(14).getNumericCellValue());
                ps2.setDouble(16, fila.getCell(15).getNumericCellValue());
                ps2.setDouble(17, fila.getCell(16).getNumericCellValue());
                ps2.setDouble(18, fila.getCell(17).getNumericCellValue());
                ps2.execute();

            }
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(excel.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al procesar:" + ex);
        }

    }

    
    
    
    public static void subiArchivosAutos(String ruta) throws IOException, SQLException {

        conexion con = new conexion();

        PreparedStatement ps2;

        try {
            Connection conn = con.getConexion();

            FileInputStream file = new FileInputStream(new File(ruta));

            XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet sheet = wb.getSheetAt(0);

            int numFilas = sheet.getLastRowNum();

            for (int a = 1; a <= numFilas; a++) {
                Row fila = sheet.getRow(a);

                ps2 = conn.prepareStatement("INSERT INTO mantenimiento_auto(Tipo_carroceria, CHASIS, Motor, Serie_fabrica, Filtro_aceite, Bobinas, Bujias, Filtro_aire, Bomba_gasolina, Microfiltro, Pastillas_del, Sensor_del, Pastillas_post, Sensor_post, Disco_del_1, Disco_del_2, Disco_post_1, Disco_post_2) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                        
                ps2.setString(1, fila.getCell(0).getStringCellValue());
                ps2.setString(2, fila.getCell(1).getStringCellValue());
                ps2.setString(3, fila.getCell(2).getStringCellValue());
                ps2.setString(4, fila.getCell(3).getStringCellValue());
                ps2.setDouble(5, fila.getCell(4).getNumericCellValue());
                ps2.setDouble(6, fila.getCell(5).getNumericCellValue());
                ps2.setDouble(7, fila.getCell(6).getNumericCellValue());
                ps2.setDouble(8, fila.getCell(7).getNumericCellValue());
                ps2.setDouble(9, fila.getCell(8).getNumericCellValue());
                ps2.setDouble(10, fila.getCell(9).getNumericCellValue());
                ps2.setDouble(11, fila.getCell(10).getNumericCellValue());
                ps2.setDouble(12, fila.getCell(11).getNumericCellValue());
                ps2.setDouble(13, fila.getCell(12).getNumericCellValue());
                ps2.setDouble(14, fila.getCell(13).getNumericCellValue());
                ps2.setDouble(15, fila.getCell(14).getNumericCellValue());
                ps2.setDouble(16, fila.getCell(15).getNumericCellValue());
                ps2.setDouble(17, fila.getCell(16).getNumericCellValue());
                ps2.setDouble(18, fila.getCell(17).getNumericCellValue());
                ps2.execute();

            }
            
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(excel.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al procesar:" + ex);
        }

    }
    
    public static void subirArchivosAutosConexion(String ruta) throws IOException, SQLException{
        
        conexion con = new conexion();
        

        try {
            Connection conn = con.getConexion();
            PreparedStatement ps;
            FileInputStream file = new FileInputStream(new File(ruta));

            XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet sheet = wb.getSheetAt(0);

            int numFilas = sheet.getLastRowNum();

            for (int a = 1; a <= numFilas; a++) {
                Row fila = sheet.getRow(a);

                ps = conn.prepareStatement("INSERT INTO vehiculo (CHASIS, id_serie, Tipo_carroceria, Tipo_motor, Serie_fabrica) VALUES(?, ?, ?, ?, ?)");

                ps.setString(1, fila.getCell(0).getStringCellValue());
                ps.setString(2, fila.getCell(1).getStringCellValue());
                ps.setString(3, fila.getCell(2).getStringCellValue());
                ps.setString(4, fila.getCell(3).getStringCellValue());
                ps.setString(5, fila.getCell(4).getStringCellValue());
                ps.execute();

            }
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(excel.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al procesar:" + ex);
        }
        
        
    }
    
}
