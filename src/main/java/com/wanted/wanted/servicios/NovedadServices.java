package com.wanted.wanted.servicios;

import com.wanted.wanted.entidades.Novedad;
import com.wanted.wanted.repositorio.NovedadRepository;
import com.wanted.wanted.repositorio.NovedadRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.List;
import java.util.Optional;


@Slf4j
@Service
@RequiredArgsConstructor


public class NovedadServices {



    private  final NovedadRepository novedadRepository;




    public List<Novedad> findAll() {
        return novedadRepository.findAll();
    }


    public  Novedad add(Novedad p){
        novedadRepository.save(p);
        return p;
    }


   
    public Novedad edit(Novedad m) {
        return novedadRepository.save(m);
    }

    public void delete(Novedad m) {

        novedadRepository.delete(m);
    }
   

  
    
}
