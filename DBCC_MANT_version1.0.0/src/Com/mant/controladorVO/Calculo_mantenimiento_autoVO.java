
package Com.mant.controladorVO;

import Com.mant.singleton.ClaseLogSingleton;


public class Calculo_mantenimiento_autoVO {
    
    private Integer id_calculo_mantenimiento_auto;
    private String CHASIS;
    private String Tipo_carroceria;
    private String Numero_articulo;
    private String Cod_paq_repuesto;
    private String Repuesto;
    private Integer Kilometraje;
    private Integer Valor_total;
    private String Resultado;
    
    public String getCHASIS() {
        return CHASIS;
    }

    public void setCHASIS(String CHASIS) {
        this.CHASIS = CHASIS;
    }

    public String getTipo_carroceria() {
        return Tipo_carroceria;
    }

    public void setTipo_carroceria(String Tipo_carroceria) {
        this.Tipo_carroceria = Tipo_carroceria;
    }

    public Integer getId_calculo_mantenimiento_auto() {
        return id_calculo_mantenimiento_auto;
    }

    public void setId_calculo_mantenimiento_auto(Integer id_calculo_mantenimiento_auto) {
        this.id_calculo_mantenimiento_auto = id_calculo_mantenimiento_auto;
    }

    public String getNumero_articulo() {
        return Numero_articulo;
    }

    public void setNumero_articulo(String Numero_articulo) {
        this.Numero_articulo = Numero_articulo;
    }

    public String getCod_paq_repuesto() {
        return Cod_paq_repuesto;
    }

    public void setCod_paq_repuesto(String Cod_paq_repuesto) {
        this.Cod_paq_repuesto = Cod_paq_repuesto;
    }    

    public String getRepuesto() {
        return Repuesto;
    }

    public void setRepuesto(String Repuesto) {
        this.Repuesto = Repuesto;
    }

    public Integer getKilometraje() {
        return Kilometraje;
    }

    public void setKilometraje(Integer Kilometraje) {
        this.Kilometraje = Kilometraje;
    }

    public Integer getValor_total() {
        return Valor_total;
    }

    public void setValor_total(Integer Valor_total) {
        this.Valor_total = Valor_total;
    }

    public String getResultado() {
        return Resultado;
    }

    public void setResultado(String Resultado) {
        this.Resultado = Resultado;
    }
    
    
    
    
    
    
    
}
