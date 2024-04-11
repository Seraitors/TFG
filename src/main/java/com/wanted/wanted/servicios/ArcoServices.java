package com.wanted.wanted.servicios;


import com.wanted.wanted.entidades.Arco;
import com.wanted.wanted.repositorio.ArcoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Slf4j
@RequiredArgsConstructor
@Service
public class ArcoServices {


    private final ArcoRepository arcoRepository;

    public List<Arco> findAll() {
        return arcoRepository.findAll();
    }

    public Arco add( Arco m) {
        arcoRepository.save(m);
        return m;
    }

    public void addAll(List<Arco> lista) {
        arcoRepository.saveAll(lista);
    }

    public Optional<Arco> findById(Long id) {
        return arcoRepository.findById(id);
    }

    public Arco edit(Arco m) {
        return arcoRepository.save(m);
    }

    public void delete(Arco m) {
        arcoRepository.delete(m);
    }

}
