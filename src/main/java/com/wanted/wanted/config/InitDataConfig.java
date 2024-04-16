package com.wanted.wanted.config;

import com.wanted.wanted.entidades.Arco;
import com.wanted.wanted.entidades.Figura;
import com.wanted.wanted.servicios.ArcoServices;
import com.wanted.wanted.servicios.FiguraServices;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Configuration
@EnableJpaAuditing
@RequiredArgsConstructor
@Component
public class InitDataConfig {

        @Autowired
        private FiguraServices figuraServices;

        @Autowired
        private ArcoServices arcoServices;

        /*
         * private final PasswordEncoder passwordEncoder;
         * private final RegistrarService registrarService;
         * 
         * @PostConstruct
         * public void initUsuarios() {
         * Roles roleUser = Roles.builder().nombre("ROLE_USER").build();
         * //perfilUser = perfilService.save(perfilUser);
         * Roles perfilAdmin = Roles.builder().nombre("ROLE_ADMIN").build();
         * //perfilAdmin = perfilService.save(perfilAdmin);
         * 
         * Registrar registrar = Registrar.builder()
         * .username("user")
         * .email("user@canciones.es")
         * .password("user")
         * .roles(Set.of(roleUser))
         * .build();
         * registrar.setPassword(passwordEncoder.encode(registrar.getPassword()));
         * 
         * //usuario1 = usuarioService.save(usuario1);
         * 
         * Registrar registrar2 = Registrar.builder()
         * .username("admin")
         * .email("admin@canciones.es")
         * .password("admin")
         * .roles(Set.of(roleUser, perfilAdmin))
         * .build();
         * registrar2.setPassword(passwordEncoder.encode(registrar2.getPassword()));
         * 
         * //usuario2 = usuarioService.save(usuario2);
         * registrarService.saveAll(Arrays.asList(registrar,registrar2));
         * }
         */

        /**
         * hacer la base de datos como en el examen
         */

        @PostConstruct
        public void initData() {

                Arco arco = Arco.builder()
                                .nombre("Wano").build();

                arcoServices.add(arco);

                Arco arco1 = Arco.builder()
                                .nombre("Marinforce").build();

                arcoServices.add(arco1);

                Arco arco2 = Arco.builder()
                                .nombre("Dressrosa")
                                .build();

                arcoServices.add(arco2);

                Arco arco3 = Arco.builder()
                        .nombre("Namek")
                        .build();

                        arcoServices.add(arco3);


                Figura figura = Figura.builder()

                                .url("/imagen/fotosLista/luffy.jpg")
                                .nombre("Luffy")
                                .des("Esta es una figura de luffy cuando estaba en wano ")
                                .arco(arco)
                                .precio("80€").build();

                figuraServices.add(figura);

                Figura figura1 = Figura.builder()
                                .url("/imagen/fotosLista/zoro.jpg")
                                .nombre("Zoro")
                                .des("Esta es una figura de Zoro en wano, El ancho es 10 cm de alto y de largo son 70cm.  ")
                                .arco(arco2)
                                .precio("80€").build();

                figuraServices.add(figura1);

                Figura figura2 = Figura.builder()
                                .url("/imagen/fotosLista/brook.jpg")
                                .nombre("Brook")
                                .des("Esta es una figura de Brook en su lucha de Bif Mom, El ancho es 15 cm de alto y de largo son 50cm.  ")
                                .arco(arco2)
                                .precio("100€").build();

                figuraServices.add(figura2);

                Figura figura3 = Figura.builder()
                                .url("/imagen/fotosLista/goku.jpg")
                                .nombre("Goku")
                                .des("Esta es la figura de Goku en su lucha contra el manvado Freezer, El ancho es 12 cm de alto y de largo son 60cm.  ")
                                .arco(arco3)
                                .precio("100€").build();

                figuraServices.add(figura3);

                Figura figura4 = Figura.builder()
                                .url("/imagen/fotosLista/vegeta.jpg")
                                .nombre("Vegeta")
                                .des("Esta es una figura de vegeta herido despues de su pelea en Namek, El ancho es 10 cm de alto y de largo son 45cm.  ")
                                .arco(arco3)
                                .precio("30€").build();

                figuraServices.add(figura4);

                Figura figura5 = Figura.builder()
                                .url("/imagen/fotosLista/freezer.jpg")
                                .nombre("Freezer")
                                .des("Esta es una figura de Freezer en Namek, El ancho es 10 cm de alto y de largo son 70cm.  ")
                                .arco(arco3)
                                .precio("50€").build();

                figuraServices.add(figura5);

        }

}
