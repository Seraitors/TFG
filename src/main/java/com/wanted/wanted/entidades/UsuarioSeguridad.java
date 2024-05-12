package com.wanted.wanted.entidades;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioSeguridad {

    @NotNull( message = "el tipo debe ir rellenado")
    private  String nombre;
    @NotNull( message = "el tipo debe ir rellenado")
    private  String apellido;
    @NotNull( message = "el tipo debe ir rellenado")
    private  String correo;
    @NotNull( message = "el tipo debe ir rellenado")
    private  String contrasena;
}
