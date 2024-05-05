package com.wanted.wanted.servicios;


import com.wanted.wanted.entidades.Rol;
import com.wanted.wanted.repositorio.RolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service

public class RolServices {


    private final RolRepository rolRepository;



    public List<Rol> findAll() {
        return rolRepository.findAll();
    }
    public Optional<Rol> findByNombre(String nombre) { return rolRepository.findByNombre(nombre);}

    public Rol save(Rol p) { return rolRepository.save(p); }







}
