package com.wanted.wanted.servicios;



import com.wanted.wanted.entidades.OnePiece;
import com.wanted.wanted.repositorio.OnePieceRepository;
import com.wanted.wanted.repositorio.OnePieceRepository;

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
public class OnePieceServices {

    private  final OnePieceServices  onePieceServices;




    public List<OnePiece> findAll() {
        return onePieceServices.findAll();
    }


    public  OnePiece add(OnePiece p){
        onePieceServices.save(p);
        return p;
    }


   
    public OnePiece edit(OnePiece m) {
        return onePieceServices.save(m);
    }

    public void delete(OnePiece m) {

        onePieceServices.delete(m);
    }
   

    
}
