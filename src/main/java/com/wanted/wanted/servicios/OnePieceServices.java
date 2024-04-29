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

    private  final OnePieceRepository  onePieceRepository;




    public List<OnePiece> findAll() {
        return onePieceRepository.findAll();
    }


    public  OnePiece add(OnePiece p){
        onePieceRepository.save(p);
        return p;
    }


   
    public OnePiece edit(OnePiece m) {
        return onePieceRepository.save(m);
    }

    public void delete(OnePiece m) {

        onePieceRepository.delete(m);
    }
   
   
}
