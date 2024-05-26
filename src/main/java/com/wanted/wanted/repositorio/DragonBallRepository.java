package com.wanted.wanted.repositorio;


import com.wanted.wanted.entidades.DragonBall;

import com.wanted.wanted.entidades.Naruto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
public interface DragonBallRepository  extends JpaRepository<DragonBall,Long>{

    public  List<DragonBall> findByNombreContainsIgnoreCase(String s);
    
}
