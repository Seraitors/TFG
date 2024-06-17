package com.wanted.wanted;





import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;

import com.wanted.wanted.entidades.Arco;
import com.wanted.wanted.entidades.Figura;
import com.wanted.wanted.repositorio.ArcoRepository;
import com.wanted.wanted.repositorio.FiguraRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@Slf4j
@Transactional
@SpringBootTest
public class Text {





        @Autowired
        private FiguraRepository figuraRepository;


    @Test
    public void testFindByNombre() {
        Figura figura = new Figura();
        figura.setNombre("Obito");
        figuraRepository.save(figura);

        List<Figura> result = figuraRepository.findByNombre("Obito");
        assertEquals(1, result.size());
        assertEquals("Obito", result.get(0).getNombre());
    }

    @Test
    public void testArcoBuilder() {
        Arco arco = Arco.builder()
                .id(1L)
                .nombre("Pepe")
                .build();
        assertNotNull(arco);
        assertEquals(1L, arco.getId());
        assertEquals("Pepe", arco.getNombre());
    }











    }



