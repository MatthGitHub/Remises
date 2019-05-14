/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.remises.services;

import ar.com.remises.model.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author matias
 */
public class SeguridadService {
    
    private static SeguridadService singleton;
    private static Usuario usuarioLogueado;
    private static List<Usuario> usuarios;
    private String mensaje = "";
    
    public static SeguridadService getSeguridadService(){
        if(singleton == null){
            return singleton = new SeguridadService();
        }else{
            return singleton;
        }
    }
    
    private SeguridadService(){
        usuarios = new ArrayList<>();
    }
    
    public boolean login(String nombreUsuario, String clave){
        
        usuarioLogueado = verificarUsuario(nombreUsuario, clave);
        if(usuarioLogueado == null){
            return false;
        }else{
            return true;
        }
    }
    
    
    public ArrayList<Usuario> cargarUsuarios(){
        
        usuarios.add(new Usuario(1, "Matias", "Benditti", "mbenditti", "mbenditti"));
        usuarios.add(new Usuario(2, "Juan Carlos", "Ramos", "jramos", "jramos"));
        usuarios.add(new Usuario(3, "Bruno", "Ovando", "bovando", "bovando"));
        usuarios.add(new Usuario(4, "Ramiro", "Diaz", "rdiaz", "rdiaz"));
        
        return (ArrayList<Usuario>) usuarios;
    }
    
    public Usuario verificarUsuario(String nombre, String clave){
        
        for(Usuario u : usuarios){
            if(u.getNombreUsuario().equals(nombre)){
                if(u.getClaveUsuario().equals(clave)){
                    mensaje = "Usuario conectado";
                    return u;
                }else{
                    mensaje = "Clave incorrecta";
                    return null;
                }
            }
        }
        
        mensaje = "Nombre de usuario no existe";
        return null;
    }

    public static Usuario getUsuarioLogueado() {
        return usuarioLogueado;
    }

    public static void setUsuarioLogueado(Usuario usuarioLogueado) {
        SeguridadService.usuarioLogueado = usuarioLogueado;
    }

    public static List<Usuario> getUsuarios() {
        return usuarios;
    }

    public static void setUsuarios(List<Usuario> usuarios) {
        SeguridadService.usuarios = usuarios;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
