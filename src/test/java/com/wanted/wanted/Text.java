package com.wanted.wanted;





import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;

import com.wanted.wanted.entidades.Arco;
import com.wanted.wanted.entidades.Figura;
import com.wanted.wanted.repositorio.ArcoRepository;
import com.wanted.wanted.repositorio.FiguraRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@DataJpaTest
@DBRider
@ExtendWith(SpringExtension.class)

public class Text {





        @Autowired
        private FiguraRepository figuraRepository;



        @Autowired
        private ArcoRepository arcoRepository;
        public static final int PAGE_SIZE = 2;


    @Test
    void testFindByNombreStartingWithIgnoreCase() {
        List<Figura> figuras = figuraRepository.findByNombreStartingWithIgnoreCase("Figura");
        assertThat(figuras).isNotEmpty();
    }

    @Test
    void testFindByNombreContainsIgnoreCase() {
        List<Figura> figuras = figuraRepository.findByNombreContainsIgnoreCase("Figura");
        assertThat(figuras).isNotEmpty();
    }

    @Test
    void testFindByNombre() {
        String nombre = "Figura";
        List<Figura> figuras = figuraRepository.findByNombre(nombre);
        assertThat(figuras).isNotEmpty();
    }

    @Test
    void testFindFigurasByPrecioGreaterThan() {
        int precio = 100;
        List<Figura> figuras = figuraRepository.findFigurasByPrecioGreaterThan(precio);
        assertThat(figuras).isNotEmpty();
    }

    @Test
    void testFindFigurasByPrecio() {
        int precio = 50;
        List<Figura> figuras = figuraRepository.findFigurasByPrecio(precio);
        assertThat(figuras).isNotEmpty();
    }

    @Test
    void testFindFigurasByNombre() {
        String nombre = "Nombre";
        List<Figura> figuras = figuraRepository.findFigurasByNombre(nombre);
        assertThat(figuras).isNotEmpty();
    }

    @Test
    void testFindFigurasByDes() {
        String des = "Descripción";
        List<Figura> figuras = figuraRepository.findFigurasByDes(des);
        assertThat(figuras).isNotEmpty();
    }

//    @Test
//    void testFindAllByOrderByNombreAsc() {
//        List<Figura> figuras = figuraRepository.findAllByOrderByNombreAsc();
//        assertThat(figuras).isNotEmpty();
//    }
//
//    @Test
//    void testFindTop3By() {
//        List<Figura> figuras = figuraRepository.findTop3By();
//        assertThat(figuras).isNotEmpty();
//    }


        /*//derivada
        @Test

        void testConsultasDerivadas() {
            List<Arco> arco = arcoRepository.findByNombre("Wano");
            assertThat(arco).hasSize(1);
        }







        //by example
        @Test
        public void testQueryByExample() {

            Figura ejemploPersona = new Figura();
            ejemploPersona.setNombre("Zoro");


            ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.STARTING);

            Example<Figura> example = Example.of(ejemploPersona, matcher);

            List<Figura> resultado = figuraRepository.findAll(example);
            System.out.println(resultado);
        }







        //query
        @Test
        @DataSet(value = {"datasets/persona.yml", "datasets/tipo_arco.yml"})
        public void TesDeQuery(){
            List<Figura> Figuras = figuraRepository.findPersonasByPrecio(90);

            assertThat(Figuras.get(0).getPrecio()).isEqualTo(90);

        }




        //ordenar
        @Test
        @DataSet(value = {"datasets/persona.yml", "datasets/tipo_arco.yml"})
        public  void Ordenar(){
            Sort sort = Sort.by(Sort.Order.asc("nombre"));


            List<Figura> personas = figuraRepository.findAllByOrderByNombreAsc(sort);
            assertEquals("Kaido",personas.get(0).getNombre());
        }


        @Test
        @DataSet(value = {"datasets/persona.yml", "datasets/tipo_arco.yml"})
        void should_FindByNombreStartingWithIgnoreCase() {
            // Aquí se asume que tienes una clase PersonaRepository para gestionar entidades Persona
            List<Figura> personas = figuraRepository.findByNombreContainsIgnoreCase("l");
            int numFiguras = 1;
            assertThat(personas).hasSize(numFiguras);
        }


        // busca entre dos precios y si lo encuentra te dice qu eets atood bien
        @Test

        void testFindAllWithCriteria_DosFechas() {
            Integer fechaFrom = 90;
            Integer fechaTo = 100;
            List<Figura> personas = figuraRepository.findAllWithCriteria(fechaFrom,fechaTo);

            assertThat(personas).extracting(Figura::getId)
                    .containsExactlyInAnyOrder(DatasetConstants.Luffy_id, DatasetConstants.Zoro_id);
        }

        @Test
        void testFindAllWithCriteria_Null(){

            Integer fechaFrom = 150;
            Integer fechaTo = 200;
            List<Figura> personas = figuraRepository.findAllWithCriteria(fechaFrom,fechaTo);

            assertThat(personas).extracting(Figura::getId)
                    .containsExactlyInAnyOrder(DatasetConstants.Sanji_id, DatasetConstants.Kaido_id);

        }
*/


























    }



