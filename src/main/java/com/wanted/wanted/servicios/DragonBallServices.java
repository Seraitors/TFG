package com.wanted.wanted.servicios;

import java.text.Normalizer;
import java.util.List;

import com.wanted.wanted.entidades.DragonBall;
import com.wanted.wanted.entidades.Figura;
import com.wanted.wanted.entidades.Naruto;
import com.wanted.wanted.repositorio.DragonBallRepository;



import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Slf4j
@RequiredArgsConstructor
@Service
public class DragonBallServices {
    


      private  final DragonBallRepository dragonBallRepository;




    public List<DragonBall> findAll() {
        return dragonBallRepository.findAll();
    }


    public  DragonBall add(DragonBall p){
        dragonBallRepository.save(p);
        return p;
    }


   
    public DragonBall edit(DragonBall m) {
        return dragonBallRepository.save(m);
    }

    public void delete(DragonBall m) {

        dragonBallRepository.delete(m);
    }

    
    public Optional<DragonBall> findById(Long id) {
        return dragonBallRepository.findById(id);
    }


    public Page<DragonBall> findByNombre(String s){

        List<DragonBall> list = dragonBallRepository.findByNombreContainsIgnoreCase(unaccent(s));
        return new PageImpl<>(list);
    }


    public static String unaccent(String src) {
        return Normalizer
                .normalize(src, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "");
    }
}
