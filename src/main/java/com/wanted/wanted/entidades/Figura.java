package com.wanted.wanted.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Figura")
public class Figura {
    @Id @GeneratedValue
    //@Min(value=1, message = "{mascota.id.mayorquecero}")
    @Column(nullable = false,unique = true)
    private  Long id;

    @NotNull( message = "el tipo debe ir rellenado")
    private  String nombre;
    // @NotNull( message = "el tipo debe ir rellenado")

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
  /*  @JoinColumn(name = "tipo_arco", referencedColumnName = "nombre")*/
    private  Arco arco;

    private int precio;
    private  String des;
    private String url;
    private  int stock;
    private  String categoria;
    private LocalDate fecha_introducida;


}
