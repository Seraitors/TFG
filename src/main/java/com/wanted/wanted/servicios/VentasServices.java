package com.wanted.wanted.servicios;


import com.wanted.wanted.entidades.Ventas;
import com.wanted.wanted.repositorio.VentasRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class VentasServices {
    
    private  final VentasRepository ventasRepository;

    

    public List<Ventas> findAll() {
        return ventasRepository.findAll();
    }

    public List<Ventas> saveAll(List<Ventas> lista) {
        return ventasRepository.saveAll(lista);
    }

    public Optional<Ventas> findById(long id) {
        return ventasRepository.findById(id);
    }


    public Ventas edit(Ventas m) {
        return ventasRepository.save(m);
    }

    public void delete(Ventas m) {
        ventasRepository.delete(m);
    }
    
    
}
