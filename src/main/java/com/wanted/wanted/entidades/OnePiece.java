package com.wanted.wanted.entidades;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
public class OnePiece {
    @Id @GeneratedValue
    //@Min(value=1, message = "{mascota.id.mayorquecero}")
    @Column(nullable = false,unique = true)
    private  Long id;


    private  String nombre;


    

    private String precio;
    private  String des;
    private String url;
}
