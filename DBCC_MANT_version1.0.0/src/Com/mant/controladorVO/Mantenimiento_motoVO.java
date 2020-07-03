/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.mant.controladorVO;

/**
 *
 * @author SKEL_LIVE
 */
public class Mantenimiento_motoVO {
    private Integer Id_producto;
    private String Tipo_carroceria;
    private String Motor;
    private String Serie_fabrica;
    private String CHASIS;
    private String Filtro_aceite;
    private String Bobinas;
    private String Bujias;
    private String Filtro_aire;
    private String Bomba_gasolina;
    private String Pastillas_del;
    private String Pastillas_post;
    private String resultado;

    public String getSerie_fabrica() {
        return Serie_fabrica;
    }

    public void setSerie_fabrica(String Serie_fabrica) {
        this.Serie_fabrica = Serie_fabrica;
    } 
        
    public Integer getId_producto() {
        return Id_producto;
    }

    public void setId_producto(Integer Id_producto) {
        this.Id_producto = Id_producto;
    }

    public String getTipo_carroceria() {
        return Tipo_carroceria;
    }

    public void setTipo_carroceria(String Tipo_carroceria) {
        this.Tipo_carroceria = Tipo_carroceria;
    }

    public String getCHASIS() {
        return CHASIS;
    }

    public void setCHASIS(String CHASIS) {
        this.CHASIS = CHASIS;
    }

    public String getMotor() {
        return Motor;
    }

    public void setMotor(String Motor) {
        this.Motor = Motor;
    }

    public String getFiltro_aceite() {
        return Filtro_aceite;
    }

    public void setFiltro_aceite(String Filtro_aceite) {
        this.Filtro_aceite = Filtro_aceite;
    }

    public String getBobinas() {
        return Bobinas;
    }

    public void setBobinas(String Bobinas) {
        this.Bobinas = Bobinas;
    }

    public String getBujias() {
        return Bujias;
    }

    public void setBujias(String Bujias) {
        this.Bujias = Bujias;
    }

    public String getFiltro_aire() {
        return Filtro_aire;
    }

    public void setFiltro_aire(String Filtro_aire) {
        this.Filtro_aire = Filtro_aire;
    }

    public String getBomba_gasolina() {
        return Bomba_gasolina;
    }

    public void setBomba_gasolina(String Bomba_gasolina) {
        this.Bomba_gasolina = Bomba_gasolina;
    }

    public String getPastillas_del() {
        return Pastillas_del;
    }

    public void setPastillas_del(String Pastillas_del) {
        this.Pastillas_del = Pastillas_del;
    }

    public String getPastillas_post() {
        return Pastillas_post;
    }

    public void setPastillas_post(String Pastillas_post) {
        this.Pastillas_post = Pastillas_post;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    
    
    
}
