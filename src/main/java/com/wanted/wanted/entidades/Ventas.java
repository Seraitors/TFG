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
    @Column(nullable = false,unique = true)
    private  Long id;
    private LocalDate fechaCompra;
    private String nombre;
    private int figuraComprada;
    private int precioTotal;
    private String datosVivienda;

}
