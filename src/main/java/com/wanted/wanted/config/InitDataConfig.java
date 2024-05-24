/*
package com.wanted.wanted.config;

import com.wanted.wanted.entidades.*;
import com.wanted.wanted.servicios.*;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.password.PasswordEncoder;
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

        @Autowired
        private NovedadServices novedadServices;

        @Autowired
        private OnePieceServices onePieceServices;

        @Autowired
        private NarutoServices narutoServices;
        @Autowired
        private DragonBallServices dragonBallServices;

        private final PasswordEncoder passwordEncoder;
        private final UsuarioServices usuarioServices;

        @PostConstruct
        public void initUsuarios() {
                Rol roleUser = Rol.builder().nombre("ROLE_USER").build();
                // perfilUser = perfilService.save(perfilUser);
                Rol perfilAdmin = Rol.builder().nombre("ROLE_ADMIN").build();
                // perfilAdmin = perfilService.save(perfilAdmin);

                Usuario usuario = Usuario.builder()
                                .username("user")
                                .email("user@canciones.es")
                                .password("user")
                                .roles(Set.of(roleUser))
                                .build();
                usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));

                // usuario1 = usuarioService.save(usuario1);

                Usuario usuario2 = Usuario.builder()
                                .username("admin")
                                .email("admin@canciones.es")
                                .password("admin")
                                .roles(Set.of(roleUser, perfilAdmin))
                                .build();
                usuario2.setPassword(passwordEncoder.encode(usuario2.getPassword()));

                // usuario2 = usuarioService.save(usuario2);
                usuarioServices.saveAll(Arrays.asList(usuario, usuario2));
        }

        */
/**
         * hacer la base de datos como en el examen
         *//*


        @PostConstruct
        public void initData() {

                */
/**
                 * One piece
                 *//*

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

                */
/**
                 * Dragon ball
                 *//*

                Arco arco3 = Arco.builder()
                                .nombre("Namek")
                                .build();

                arcoServices.add(arco3);

                Arco arco4 = Arco.builder()
                                .nombre("Tierra")
                                .build();

                arcoServices.add(arco4);

                */
/**
                 * Naruto
                 *//*


                Arco arco5 = Arco.builder()
                                .nombre("Villa oculta de la Hoja")
                                .build();

                arcoServices.add(arco5);

                Figura figura = Figura.builder()

                                .url("../imagen/fotosLista/luffy.jpg")
                                .nombre("Luffy")
                                .des("Esta es una figura de luffy cuando estaba en wano ")
                                .arco(arco)
                                .precio(80).build();

                figuraServices.add(figura);

                Figura figura1 = Figura.builder()
                                .url("../imagen/fotosLista/zoro.jpg")
                                .nombre("Zoro")
                                .des("Esta es una figura de Zoro en wano, El ancho es 10 cm de alto y de largo son 70cm.  ")
                                .arco(arco2)
                                .precio(65).build();

                figuraServices.add(figura1);

                Figura figura2 = Figura.builder()
                                .url("/imagen/fotosLista/brook1.jpg")
                                .nombre("Brook")
                                .des("Esta es una figura de Brook en su lucha de Bif Mom, El ancho es 15 cm de alto y de largo son 50cm.  ")
                                .arco(arco2)
                                .precio(100).build();

                figuraServices.add(figura2);

                Figura figura3 = Figura.builder()
                                .url("/imagen/fotosLista/goku.jpg")
                                .nombre("Goku")
                                .des("Esta es la figura de Goku en su lucha contra el manvado Freezer, El ancho es 12 cm de alto y de largo son 60cm.  ")
                                .arco(arco3)
                                .precio(100).build();

                figuraServices.add(figura3);

                Figura figura4 = Figura.builder()
                                .url("/imagen/fotosLista/vegeta.jpg")
                                .nombre("Vegeta")
                                .des("Esta es una figura de vegeta herido despues de su pelea en Namek, El ancho es 10 cm de alto y de largo son 45cm.  ")
                                .arco(arco3)
                                .precio(30).build();

                figuraServices.add(figura4);

                Figura figura5 = Figura.builder()
                                .url("/imagen/fotosLista/freezer.jpg")
                                .nombre("Freezer")
                                .des("Esta es una figura de Freezer en Namek, El ancho es 10 cm de alto y de largo son 70cm.  ")
                                .arco(arco3)
                                .precio(50).build();

                figuraServices.add(figura5);

                Figura figura6 = Figura.builder()
                                .url("/imagen/fotosLista/piccolo.jpg")
                                .nombre("Piccolo")
                                .des("Esta es una figura de Piccolo en Namek, El ancho es 11.5 cm de alto y de largo son 300cm.  ")
                                .arco(arco3)
                                .precio(20).build();

                figuraServices.add(figura6);

                Figura figura7 = Figura.builder()
                                .url("/imagen/fotosLista/sasuke.jpg")
                                .nombre("sasuke")
                                .des("Esta es una figura de sasuke en la villa oculta de la hoja de pequño, El ancho es 10.5 cm de alto y de largo son 200cm.  ")
                                .arco(arco5)
                                .precio(30).build();

                figuraServices.add(figura7);
                Figura figura8 = Figura.builder()
                                .url("/imagen/fotosLista/naruto.jpg")
                                .nombre("naruto")
                                .des("Esta es una figura de naruto en la villa oculta de la hoja de pequño, El ancho es 10.5 cm de alto y de largo son 200cm.  ")
                                .arco(arco5)
                                .precio(30).build();

                figuraServices.add(figura8);

                Figura figura9 = Figura.builder()
                                .url("/imagen/fotosLista/narutoM.jpg")
                                .nombre("naruto")
                                .des("Esta es una figura de naruto en la villa oculta de la hoja de mayor, El ancho es 10.5 cm de alto y de largo son 200cm.  ")
                                .arco(arco5)
                                .precio(35).build();

                figuraServices.add(figura9);

                */
/**
                 * De aqui son las novedades de la semana
                 *//*


                Novedad novedad = Novedad.builder()
                                .url("/imagen/fotosLista/gohan.jpg")
                                .nombre("Gohan")
                                .des("Gohan modo bestia en la tierra su despertad ma skaioken")
                                .arco(arco4) // Aquí haces referencia a un arco no guardado
                                .precio(150).build();

                novedadServices.add(novedad);

                Novedad novedad1 = Novedad.builder()
                                .url("/imagen/fotosLista/narutoSabio.jpg")
                                .nombre("Naruto")
                                .des("Naruto pelea contra Pain Modo sabio 20 cm de alto y de largo 200cm")
                                .arco(arco5)
                                .precio(50).build();

                novedadServices.add(novedad1);

                Novedad novedad2 = Novedad.builder()
                                .url("/imagen/fotosLista/pain.jpg")
                                .nombre("Pain")
                                .des("Pain pelea contra Naruto Modo sabio 20 cm de alto y de largo 200cm")
                                .arco(arco5)
                                .precio(45).build();

                novedadServices.add(novedad2);

                Novedad novedad3 = Novedad.builder()
                                .url("/imagen/fotosLista/obito.jpg")
                                .nombre("Obito")
                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
                                .arco(arco5)
                                .precio(50).build();

                novedadServices.add(novedad3);

                */
/* Aqui empieza la pagina de one piece de figuras *//*

                OnePiece onePiece = OnePiece.builder()
                                .url("/imagen/fotosOnePiece/luffySombrero.jpg")
                                .nombre("Luffy")
                                .des("Luffy en la batalla contra kaido despues de dar la cara ante los yonkous, 30 cm de alto y de largo 122cm")
                                .arco(arco)
                                .precio(50).build();

                onePieceServices.add(onePiece);

                OnePiece onePiece1 = OnePiece.builder()
                                .url("/imagen/fotosOnePiece/shanks.jpg")
                                .nombre("Obito")
                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
                                .arco(arco5)
                                .precio(50).build();

                onePieceServices.add(onePiece1);

                OnePiece onePiece2 = OnePiece.builder()
                                .url("/imagen/fotosOnePiece/ace.jpg")
                                .nombre("Ace")
                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
                                .arco(arco5)
                                .precio(50).build();

                onePieceServices.add(onePiece2);

                OnePiece onePiece3 = OnePiece.builder()
                                .url("/imagen/fotosOnePiece/choper.jpg")
                                .nombre("Obito")
                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
                                .arco(arco5)
                                .precio(50).build();

                onePieceServices.add(onePiece3);

                OnePiece onePiece4 = OnePiece.builder()
                                .url("/imagen/fotosOnePiece/trio.jpg")
                                .nombre("Obito")
                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
                                .arco(arco5)
                                .precio(50).build();

                onePieceServices.add(onePiece4);

                OnePiece onePiece5 = OnePiece.builder()
                                .url("/imagen/fotosOnePiece/zoro1.jpg")
                                .nombre("Obito")
                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
                                .arco(arco5)
                                .precio(50).build();

                onePieceServices.add(onePiece5);

                OnePiece onePiece6 = OnePiece.builder()
                                .url("/imagen/fotosOnePiece/nami.jpg")
                                .nombre("Obito")
                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
                                .arco(arco5)
                                .precio(50).build();

                onePieceServices.add(onePiece6);

                OnePiece onePiece7 = OnePiece.builder()
                                .url("/imagen/fotosOnePiece/zoro2.jpg")
                                .nombre("Obito")
                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
                                .arco(arco5)
                                .precio(50).build();

                onePieceServices.add(onePiece7);
                OnePiece onePiece8 = OnePiece.builder()
                                .url("/imagen/fotosOnePiece/law.jpg")
                                .nombre("Obito")
                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
                                .arco(arco5)
                                .precio(50).build();

                onePieceServices.add(onePiece8);
                OnePiece onePiece9 = OnePiece.builder()
                                .url("/imagen/fotosOnePiece/sanji.jpg")
                                .nombre("Obito")
                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
                                .arco(arco5)
                                .precio(50).build();

                onePieceServices.add(onePiece9);
                OnePiece onePiece10 = OnePiece.builder()
                                .url("/imagen/fotosOnePiece/luffy1.jpg")
                                .nombre("Obito")
                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
                                .arco(arco5)
                                .precio(50).build();

                onePieceServices.add(onePiece10);
                OnePiece onePiece11 = OnePiece.builder()
                                .url("/imagen/fotosOnePiece/barbanegra.jpg")
                                .nombre("Obito")
                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
                                .arco(arco5)
                                .precio(50).build();

                onePieceServices.add(onePiece11);
                OnePiece onePiece12 = OnePiece.builder()
                                .url("/imagen/fotosOnePiece/kaido.jpg")
                                .nombre("Obito")
                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
                                .arco(arco5)
                                .precio(50).build();

                onePieceServices.add(onePiece12);
                OnePiece onePiece13 = OnePiece.builder()
                                .url("/imagen/fotosOnePiece/mam.jpg")
                                .nombre("Obito")
                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
                                .arco(arco5)
                                .precio(50).build();

                onePieceServices.add(onePiece13);
                OnePiece onePiece14 = OnePiece.builder()
                                .url("/imagen/fotosOnePiece/sabo.jpg")
                                .nombre("Obito")
                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
                                .arco(arco5)
                                .precio(50).build();

                onePieceServices.add(onePiece14);

                */
/* Aqui vienen las figuras de naruto *//*


                Naruto naruto = Naruto.builder()
                                .url("/imagen/fotosNaruto/gaara.jpeg")
                                .nombre("Obito")
                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
                                .arco(arco5)
                                .precio(50).build();

                narutoServices.add(naruto);
                Naruto naruto1 = Naruto.builder()
                                .url("/imagen/fotosNaruto/naruto1.jpeg")
                                .nombre("Obito")
                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
                                .arco(arco5)
                                .precio(50).build();

                narutoServices.add(naruto1);
                Naruto naruto2 = Naruto.builder()
                                .url("/imagen/fotosNaruto/obito2.jpeg")
                                .nombre("Obito")
                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
                                .arco(arco5)
                                .precio(50).build();

                narutoServices.add(naruto2);
                Naruto naruto3 = Naruto.builder()
                                .url("/imagen/fotosNaruto/itachi.jpeg")
                                .nombre("Obito")
                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
                                .arco(arco5)
                                .precio(50).build();

                narutoServices.add(naruto3);
                Naruto naruto4 = Naruto.builder()
                                .url("/imagen/fotosNaruto/naruto2.jpeg")
                                .nombre("Obito")
                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
                                .arco(arco5)
                                .precio(50).build();

                narutoServices.add(naruto4);
                Naruto naruto5 = Naruto.builder()
                                .url("/imagen/fotosNaruto/pain.jpeg")
                                .nombre("Obito")
                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
                                .arco(arco5)
                                .precio(50).build();

                narutoServices.add(naruto5);
                Naruto naruto6 = Naruto.builder()
                                .url("/imagen/fotosNaruto/kakasi.jpeg")
                                .nombre("Obito")
                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
                                .arco(arco5)
                                .precio(50).build();

                narutoServices.add(naruto6);
                Naruto naruto7 = Naruto.builder()
                                .url("/imagen/fotosNaruto/naruto3.jpeg")
                                .nombre("Obito")
                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
                                .arco(arco5)
                                .precio(50).build();

                narutoServices.add(naruto7);
                Naruto naruto8 = Naruto.builder()
                                .url("/imagen/fotosNaruto/sasuke.jpeg")
                                .nombre("Obito")
                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
                                .arco(arco5)
                                .precio(50).build();

                narutoServices.add(naruto8);
                Naruto naruto9 = Naruto.builder()
                                .url("/imagen/fotosNaruto/madara.jpeg")
                                .nombre("Obito")
                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
                                .arco(arco5)
                                .precio(50).build();

                narutoServices.add(naruto9);
                Naruto naruto10 = Naruto.builder()
                                .url("/imagen/fotosNaruto/obite3.jpeg")
                                .nombre("Obito")
                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
                                .arco(arco5)
                                .precio(50).build();

                narutoServices.add(naruto10);
                Naruto naruto11 = Naruto.builder()
                                .url("/imagen/fotosNaruto/kakasi1.jpeg")
                                .nombre("Obito")
                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
                                .arco(arco5)
                                .precio(50).build();

                narutoServices.add(naruto11);
                Naruto naruto12 = Naruto.builder()
                                .url("/imagen/fotosNaruto/madara1.jpeg")
                                .nombre("Obito")
                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
                                .arco(arco5)
                                .precio(50).build();

                narutoServices.add(naruto12);
                Naruto naruto13 = Naruto.builder()
                                .url("/imagen/fotosNaruto/obito.jpeg")
                                .nombre("Obito")
                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
                                .arco(arco5)
                                .precio(50).build();

                narutoServices.add(naruto13);
                Naruto naruto14 = Naruto.builder()
                                .url("/imagen/fotosNaruto/naruto.jpeg")
                                .nombre("Obito")
                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
                                .arco(arco5)
                                .precio(50).build();

                narutoServices.add(naruto14);

                Naruto naruto15 = Naruto.builder()
                                .url("/imagen/fotosNaruto/obito1.jpeg")
                                .nombre("Obito")
                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
                                .arco(arco5)
                                .precio(50).build();

                narutoServices.add(naruto15);

                Naruto naruto16 = Naruto.builder()
                                .url("/imagen/fotosNaruto/sakura.jpeg")
                                .nombre("Obito")
                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
                                .arco(arco5)
                                .precio(20).build();

                narutoServices.add(naruto16);

                */
/* Aqui empieza las figuras de dragon ball *//*

                DragonBall dragonBall = DragonBall.builder()
                                .url("/imagen/fotosDragonBall/broly.jpeg")
                                .nombre("Obito")
                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
                                .arco(arco5)
                                .precio(50).build();

                dragonBallServices.add(dragonBall);
                DragonBall dragonBall1 = DragonBall.builder()
                                .url("/imagen/fotosDragonBall/gohan3.jpeg")
                                .nombre("Obito")
                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
                                .arco(arco5)
                                .precio(50).build();

                dragonBallServices.add(dragonBall1);
                DragonBall dragonBall2 = DragonBall.builder()
                                .url("/imagen/fotosDragonBall/vegeta.jpeg")
                                .nombre("Obito")
                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
                                .arco(arco5)
                                .precio(50).build();

                dragonBallServices.add(dragonBall2);
                DragonBall dragonBall3 = DragonBall.builder()
                                .url("/imagen/fotosDragonBall/broly1.jpeg")
                                .nombre("Obito")
                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
                                .arco(arco5)
                                .precio(50).build();

                dragonBallServices.add(dragonBall3);
                DragonBall dragonBall4 = DragonBall.builder()
                                .url("/imagen/fotosDragonBall/goku.jpeg")
                                .nombre("Obito")
                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
                                .arco(arco5)
                                .precio(50).build();

                dragonBallServices.add(dragonBall4);
                DragonBall dragonBall5 = DragonBall.builder()
                                .url("/imagen/fotosDragonBall/vegeta1.jpeg")
                                .nombre("Obito")
                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
                                .arco(arco5)
                                .precio(50).build();

                dragonBallServices.add(dragonBall5);
                DragonBall dragonBall6 = DragonBall.builder()
                                .url("/imagen/fotosDragonBall/broly2.jpeg")
                                .nombre("Obito")
                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
                                .arco(arco5)
                                .precio(50).build();

                dragonBallServices.add(dragonBall6);
                DragonBall dragonBall7 = DragonBall.builder()
                                .url("/imagen/fotosDragonBall/goku1.jpeg")
                                .nombre("Obito")
                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
                                .arco(arco5)
                                .precio(50).build();

                dragonBallServices.add(dragonBall7);
                DragonBall dragonBall8 = DragonBall.builder()
                                .url("/imagen/fotosDragonBall/vegeta2.jpeg")
                                .nombre("Obito")
                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
                                .arco(arco5)
                                .precio(50).build();

                dragonBallServices.add(dragonBall8);
                DragonBall dragonBall9 = DragonBall.builder()
                                .url("/imagen/fotosDragonBall/gohan.jpeg")
                                .nombre("Obito")
                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
                                .arco(arco5)
                                .precio(50).build();

                dragonBallServices.add(dragonBall9);
                DragonBall dragonBall10 = DragonBall.builder()
                                .url("/imagen/fotosDragonBall/goku3.jpeg")
                                .nombre("Obito")
                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
                                .arco(arco5)
                                .precio(50).build();

                dragonBallServices.add(dragonBall10);
                DragonBall dragonBall11 = DragonBall.builder()
                                .url("/imagen/fotosDragonBall/vegeta3.jpeg")
                                .nombre("Obito")
                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
                                .arco(arco5)
                                .precio(50).build();

                dragonBallServices.add(dragonBall11);
                DragonBall dragonBall12 = DragonBall.builder()
                                .url("/imagen/fotosDragonBall/gohan1.jpeg")
                                .nombre("Obito")
                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
                                .arco(arco5)
                                .precio(50).build();

                dragonBallServices.add(dragonBall12);
                DragonBall dragonBall13 = DragonBall.builder()
                                .url("/imagen/fotosDragonBall/goku4.jpeg")
                                .nombre("Obito")
                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
                                .arco(arco5)
                                .precio(50).build();

                dragonBallServices.add(dragonBall13);
                DragonBall dragonBall14 = DragonBall.builder()
                                .url("/imagen/fotosDragonBall/vegeta4.jpeg")
                                .nombre("Obito")
                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
                                .arco(arco5)
                                .precio(50).build();

                dragonBallServices.add(dragonBall14);

                DragonBall dragonBall15 = DragonBall.builder()
                                .url("/imagen/fotosDragonBall/gohan2.jpeg")
                                .nombre("Obito")
                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
                                .arco(arco5)
                                .precio(50).build();

                dragonBallServices.add(dragonBall15);

                DragonBall dragonBall16 = DragonBall.builder()
                                .url("/imagen/fotosDragonBall/goku5.jpeg")
                                .nombre("Obito")
                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
                                .arco(arco5)
                                .precio(50).build();

                dragonBallServices.add(dragonBall16);

        }

}
*/
