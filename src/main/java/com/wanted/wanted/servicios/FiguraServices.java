package com.wanted.wanted.servicios;


import com.wanted.wanted.entidades.Figura;
import com.wanted.wanted.repositorio.FiguraRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor

@Transactional
public class FiguraServices {

    private  final FiguraRepository repositorio;




    public List<Figura> findAll() {
        return repositorio.findAll();
    }


    public  Figura add(Figura p){
        repositorio.save(p);
        return p;
    }

    public void addAll(List<Figura> lista) {
        repositorio.saveAll(lista);
    }



    public Optional<Figura> findById(Long id) {
        return repositorio.findById(id);
    }

    public Figura edit(Figura m) {
        return repositorio.save(m);
    }

    public void delete(Figura m) {

        repositorio.delete(m);
    }
    // mirar a ver qu ehace esto
    public static String unaccent(String src) {
        return Normalizer
                .normalize(src, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "");
    }

    // esto es para que funcione lo de filtrar por qu ecomo estabamos devolviendo una lista necesitabmos una Page para que funcione
   public  Page<Figura> findByNombre(String s){

       List<Figura> list = repositorio.findByNombreContainsIgnoreCase(unaccent(s));
       return new PageImpl<>(list);
   }

    public Page<Figura> findAllPaginated(Pageable pageable) {
        return repositorio.findAll(pageable);
    }


 public  Figura save(Figura p){
        return  repositorio.save(p);

 }

    public void deleteById(Long id) {
        repositorio.deleteById(id);
    }



    /*
    Prueba de numeor aleatorio
     */


    public List<Figura> getRandomFiguras(int number) {
        List<Figura> allFiguras = repositorio.findAll();
        Collections.shuffle(allFiguras);
        return allFiguras.stream().limit(number).collect(Collectors.toList());
    }


    /*Esto es para filtrar por categoria */

    public List<Figura> getFigurasByCategoria(String categoria) {
        return repositorio.findFigurasByCategoriaContaining(categoria);
    }
        /*Filtrar por fecha*/
    public List<Figura> getFigurasByFechaIntroducida(LocalDate fecha) {
        return repositorio.findFigurasByFechaIntroducida(fecha);
    }


    /*Todo el metodo de numeros aleatorios y de categoria*/

    public List<Figura> getFiguras(int number, String categoria) {
        List<Figura> figuras;


        if (categoria != null && !categoria.isEmpty()) {
            // Filtrar por categoría
            figuras = repositorio.findFigurasByCategoriaContaining(categoria);
            if (categoria.equalsIgnoreCase("novedad")) {
                Collections.shuffle(figuras);
                figuras = figuras.stream().limit(number).collect(Collectors.toList());
            }
        } else {
            // Obtener todas las figuras y mezclar para seleccionar aleatoriamente
            figuras = repositorio.findAll();
            Collections.shuffle(figuras);
            figuras = figuras.stream().limit(number).collect(Collectors.toList());
        }

        return figuras;
    }


    public void restarStock(String id ){

        repositorio.restarStockById(id);

    }
}
