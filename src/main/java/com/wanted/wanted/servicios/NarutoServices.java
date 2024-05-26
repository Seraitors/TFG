package com.wanted.wanted.servicios;



import com.wanted.wanted.entidades.DragonBall;
import com.wanted.wanted.entidades.Figura;
import com.wanted.wanted.entidades.Naruto;
import com.wanted.wanted.repositorio.NarutoRepository;
import com.wanted.wanted.repositorio.NarutoRepository;

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
public class NarutoServices {

    private  final NarutoRepository  narutoRepository;




    public List<Naruto> findAll() {
        return narutoRepository.findAll();
    }


    public  Naruto add(Naruto p){
        narutoRepository.save(p);
        return p;
    }


   
    public Naruto edit(Naruto m) {
        return narutoRepository.save(m);
    }

    public void delete(Naruto m) {

        narutoRepository.delete(m);
    }


    public Optional<Naruto> findById(Long id) {
        return narutoRepository.findById(id);
    }


    public  Page<Naruto> findByNombre(String s){

        List<Naruto> list = narutoRepository.findByNombreContainsIgnoreCase(unaccent(s));
        return new PageImpl<>(list);
    }


    public static String unaccent(String src) {
        return Normalizer
                .normalize(src, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "");
    }

}
