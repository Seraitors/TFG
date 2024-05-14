package com.wanted.wanted.servicios;

import java.util.List;

import com.wanted.wanted.entidades.DragonBall;
import com.wanted.wanted.entidades.Figura;
import com.wanted.wanted.repositorio.DragonBallRepository;



import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Slf4j
@RequiredArgsConstructor
@Service
public class DragonBallServices {
    


      private  final DragonBallRepository DragonBallRepository;




    public List<DragonBall> findAll() {
        return DragonBallRepository.findAll();
    }


    public  DragonBall add(DragonBall p){
        DragonBallRepository.save(p);
        return p;
    }


   
    public DragonBall edit(DragonBall m) {
        return DragonBallRepository.save(m);
    }

    public void delete(DragonBall m) {

        DragonBallRepository.delete(m);
    }

    
    public Optional<DragonBall> findById(Long id) {
        return DragonBallRepository.findById(id);
    }
}
