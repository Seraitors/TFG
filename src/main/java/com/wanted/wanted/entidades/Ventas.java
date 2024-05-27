package com.wanted.wanted.entidades;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Ventas")
public class Ventas {

    @Id
    @GeneratedValue
    //@Min(value=1, message = "{mascota.id.mayorquecero}")
    @Column(nullable = false,unique = true)
    private  Long id;
    private LocalDate fechaCompra;
    private String nombre;
    private int figurasCompradas;
    private int precioTotal;
    private String datosVivienda;

}
