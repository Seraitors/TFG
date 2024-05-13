package com.wanted.wanted.servicios;


import com.wanted.wanted.entidades.UsuarioSeguridad;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UsuariosServicesSeguridad {


    private List<UsuarioSeguridad> usuarios = new ArrayList<>();


    public List<UsuarioSeguridad> findAll() {
        return usuarios;
    }

    // Registar usuarios
    public  void registarUSuario( UsuarioSeguridad usuario){
        usuarios.add(usuario);

    }

    public  UsuarioSeguridad  buscarUsuario(UsuarioSeguridad nombre){

        return usuarios.stream()
                .filter(n-> n.equals(nombre))
                .findFirst()
                .orElse(null);


    }

    public  boolean validarusuario(String name , String password ,String correo ){

        for (UsuarioSeguridad usuario:usuarios   ){

            if (usuario.getNombre().equals(name) && usuario.getContrasena().equals(password) && usuario.getCorreo().equals(correo)){

                return  true ;
            }
        }
        return false;

    }



   /* @PostConstruct
    public  void init(){

        usuarios.addAll(
                Arrays.asList(
                        UsuarioSeguridad.builder()

                                .nombre("admin")
                                .apellido("admin")
                                .correo("admin")
                                .contrasena("admin")

                                .build()
                ));




    }*/



}
