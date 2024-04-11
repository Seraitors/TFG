package com.wanted.wanted.repositorio;


import com.wanted.wanted.entidades.Figura;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FiguraRepository extends JpaRepository<Figura,Long>  {

    public List<Figura> findByNombreStartingWithIgnoreCase (String nombre);

    public  List<Figura> findByNombreContainsIgnoreCase(String s);
    List<Figura> findByNombre(String nombre);
    List<Figura>findFigurasByPrecioGreaterThan(int precio);


    @Query("SELECT p FROM Figura p WHERE p.precio = :precio")
    List<Figura> findFigurasByPrecio(@Param("precio") int precio);


    @Query("SELECT p FROM Figura p WHERE p.nombre = :nombre")
    List<Figura> findFigurasByNombre(@Param("nombre") String nombre);



    @Query("SELECT p FROM Figura p WHERE p.des = :des")
    List<Figura> findFigurasByDes(@Param("des") String nombre);


    List<Figura> findAllByOrderByNombreAsc(Sort sort);
    public List<Figura> findTop3By(Sort sort);

    Page<Figura> findPageBy(Pageable pageable);






}
