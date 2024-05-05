package com.wanted.wanted.repositorio;

import com.wanted.wanted.entidades.Rol;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolRepository extends JpaRepository<Rol,Long> {


    public Optional<Rol> findByNombre(String nombre);
/*    public  Optional<PerfilSignupDto>   findIdNombreAsRecordByNombre(String nombre);*/

}
