/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.mant.controladorVO;

import java.util.Objects;

/**
 *
 * @author SKEL_LIVE
 */
public class UsuariosVO {
    private Integer id_usuario;
    private String Nombre;
    private String Apellido;
    private String Usuario;
    protected String Contrasenia;
    private Integer id_tipo;
    private String Nombre_tipo;
    private String resultado;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.Contrasenia);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UsuariosVO other = (UsuariosVO) obj;
        if (!Objects.equals(this.Contrasenia, other.Contrasenia)) {
            return false;
        }
        return true;
    }

    public String getNombre_tipo() {
        return Nombre_tipo;
    }

    public void setNombre_tipo(String Nombre_tipo) {
        this.Nombre_tipo = Nombre_tipo;
    }
    
    

    
    
    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContrasenia() {
        return Contrasenia;
    }

    public void setContrasenia(String Contrasenia) {
        this.Contrasenia = Contrasenia;
    }

    public Integer getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(Integer Id_tipo) {
        this.id_tipo = Id_tipo;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    
    

    @Override
    public String toString() {
        return Nombre + Apellido;
    }
    
    
  
    
}
