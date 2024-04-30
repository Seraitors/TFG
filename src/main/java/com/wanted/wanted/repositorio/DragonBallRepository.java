package com.wanted.wanted.repositorio;


import com.wanted.wanted.entidades.DragonBall;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
public interface DragonBallRepository  extends JpaRepository<DragonBall,Long>{
    
}
