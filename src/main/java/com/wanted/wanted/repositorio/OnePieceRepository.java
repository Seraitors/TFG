package com.wanted.wanted.repositorio;



import com.wanted.wanted.entidades.OnePiece;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OnePieceRepository  extends JpaRepository<OnePiece,Long> {


    
}
