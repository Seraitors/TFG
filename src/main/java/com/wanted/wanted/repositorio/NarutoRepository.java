package com.wanted.wanted.repositorio;



import com.wanted.wanted.entidades.Figura;
import com.wanted.wanted.entidades.Naruto;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NarutoRepository extends JpaRepository<Naruto,Long> {


    public  List<Naruto> findByNombreContainsIgnoreCase(String s);
}
