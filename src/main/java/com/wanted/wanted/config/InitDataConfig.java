//package com.wanted.wanted.config;
//
//import com.wanted.wanted.entidades.*;
//import com.wanted.wanted.servicios.*;
//
//import jakarta.annotation.PostConstruct;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDate;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Set;
//
//@Configuration
//@EnableJpaAuditing
//@RequiredArgsConstructor
//@Component
//public class InitDataConfig {
//
//        @Autowired
//        private FiguraServices figuraServices;
//
//        @Autowired
//        private ArcoServices arcoServices;
//
//
//
//        private final PasswordEncoder passwordEncoder;
//        private final UsuarioServices usuarioServices;
//
//        @PostConstruct
//        public void initUsuarios() {
//                Rol roleUser = Rol.builder().nombre("ROLE_USER").build();
//                // perfilUser = perfilService.save(perfilUser);
//                Rol perfilAdmin = Rol.builder().nombre("ROLE_ADMIN").build();
//                // perfilAdmin = perfilService.save(perfilAdmin);
//
//                Usuario usuario = Usuario.builder()
//                                .username("user")
//                                .email("user@canciones.es")
//                                .password("user")
//                                .roles(Set.of(roleUser))
//                                .build();
//                usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
//
//                // usuario1 = usuarioService.save(usuario1);
//
//                Usuario usuario2 = Usuario.builder()
//                                .username("admin")
//                                .email("admin@canciones.es")
//                                .password("admin")
//                                .roles(Set.of(roleUser, perfilAdmin))
//                                .build();
//                usuario2.setPassword(passwordEncoder.encode(usuario2.getPassword()));
//
//                // usuario2 = usuarioService.save(usuario2);
//                usuarioServices.saveAll(Arrays.asList(usuario, usuario2));
//        }
//
//
//
//
//
//        @PostConstruct
//        public void initData() {
//
//
//
//
//
//                Arco arco = Arco.builder()
//                                .nombre("Wano").build();
//
//                arcoServices.add(arco);
//
//                Arco arco1 = Arco.builder()
//                                .nombre("Marinforce").build();
//
//                arcoServices.add(arco1);
//
//                Arco arco2 = Arco.builder()
//                                .nombre("Dressrosa")
//                                .build();
//
//                arcoServices.add(arco2);
//
//
//
//
//                Arco arco3 = Arco.builder()
//                                .nombre("Namek")
//                                .build();
//
//                arcoServices.add(arco3);
//
//                Arco arco4 = Arco.builder()
//                                .nombre("Tierra")
//                                .build();
//
//                arcoServices.add(arco4);
//
//
//
//
//                Arco arco5 = Arco.builder()
//                                .nombre("Villa oculta de la Hoja")
//                                .build();
//
//                arcoServices.add(arco5);
//
//                Figura figura = Figura.builder()
//
//                                .url("/imagen/fotosLista/luffy.jpg")
//                                .nombre("Luffy")
//                                .des("Esta es una figura de luffy cuando estaba en wano ")
//                                .arco(arco)
//                                .stock(1)
//                                .categoria("one-piece")
//                                .fecha_introducida(LocalDate.of(1999,10,10))
//                                .precio(80).build();
//
//                figuraServices.add(figura);
//
//                Figura figura1 = Figura.builder()
//                                .url("/imagen/fotosLista/zoro.jpg")
//                                .nombre("Zoro")
//                                .des("Esta es una figura de Zoro en wano, El ancho es 10 cm de alto y de largo son 70cm.  ")
//                                .arco(arco2)
//                        .stock(2)
//                        .categoria("one-piece")
//                        .fecha_introducida(LocalDate.of(1999,10,10))
//                                .precio(65).build();
//
//                figuraServices.add(figura1);
//
//                Figura figura2 = Figura.builder()
//                                .url("/imagen/fotosLista/brook1.jpg")
//                                .nombre("Brook")
//                                .des("Esta es una figura de Brook en su lucha de Bif Mom, El ancho es 15 cm de alto y de largo son 50cm.  ")
//                                .arco(arco2)
//                        .stock(0)
//                        .categoria("one-piece")
//                        .fecha_introducida(LocalDate.of(2024,10,22))
//                                .precio(100).build();
//
//                figuraServices.add(figura2);
//
//                Figura figura3 = Figura.builder()
//                                .url("/imagen/fotosLista/goku.jpg")
//                                .nombre("Goku")
//                                .des("Esta es la figura de Goku en su lucha contra el manvado Freezer, El ancho es 12 cm de alto y de largo son 60cm.  ")
//                                .arco(arco3)
//                        .stock(1)
//                        .categoria("dragon-ball")
//                        .fecha_introducida(LocalDate.of(2022,8,2))
//                                .precio(100).build();
//
//                figuraServices.add(figura3);
//
//                Figura figura4 = Figura.builder()
//                                .url("/imagen/fotosLista/vegeta.jpg")
//                                .nombre("Vegeta")
//                                .des("Esta es una figura de vegeta herido despues de su pelea en Namek, El ancho es 10 cm de alto y de largo son 45cm.  ")
//                                .arco(arco3)
//                        .stock(5)
//                        .categoria("dragon-ball")
//                        .fecha_introducida(LocalDate.of(2014,12,22))
//                                .precio(30).build();
//
//                figuraServices.add(figura4);
//
//                Figura figura5 = Figura.builder()
//                                .url("/imagen/fotosLista/freezer.jpg")
//                                .nombre("Freezer")
//                                .des("Esta es una figura de Freezer en Namek, El ancho es 10 cm de alto y de largo son 70cm.  ")
//                                .arco(arco3)
//                        .stock(2)
//                        .categoria("dragon-ball")
//                        .fecha_introducida(LocalDate.of(2015,2,2))
//                                .precio(50).build();
//
//                figuraServices.add(figura5);
//
//                Figura figura6 = Figura.builder()
//                                .url("/imagen/fotosLista/piccolo.jpg")
//                                .nombre("Piccolo")
//                                .des("Esta es una figura de Piccolo en Namek, El ancho es 11.5 cm de alto y de largo son 300cm.  ")
//                                .arco(arco3)
//                        .stock(10)
//                        .categoria("dragon-ball")
//                        .fecha_introducida(LocalDate.of(2011,11,16))
//                                .precio(20).build();
//
//                figuraServices.add(figura6);
//
//                Figura figura7 = Figura.builder()
//                                .url("/imagen/fotosLista/sasuke.jpg")
//                                .nombre("sasuke")
//                                .des("Esta es una figura de sasuke en la villa oculta de la hoja de pequño, El ancho es 10.5 cm de alto y de largo son 200cm.  ")
//                                .arco(arco5)
//                        .stock(5)
//                        .categoria("naruto")
//                        .fecha_introducida(LocalDate.of(2014,5,8))
//                                .precio(30).build();
//
//                figuraServices.add(figura7);
//                Figura figura8 = Figura.builder()
//                                .url("/imagen/fotosLista/naruto.jpg")
//                                .nombre("naruto")
//                                .des("Esta es una figura de naruto en la villa oculta de la hoja de pequño, El ancho es 10.5 cm de alto y de largo son 200cm.  ")
//                                .arco(arco5)
//                        .stock(2)
//                        .categoria("naruto")
//                        .fecha_introducida(LocalDate.of(2010,10,10))
//                                .precio(30).build();
//
//                figuraServices.add(figura8);
//
//                Figura figura9 = Figura.builder()
//                                .url("/imagen/fotosLista/narutoM.jpg")
//                                .nombre("naruto")
//                                .des("Esta es una figura de naruto en la villa oculta de la hoja de mayor, El ancho es 10.5 cm de alto y de largo son 200cm.  ")
//                                .arco(arco5)
//                        .stock(3)
//                        .categoria("naruto")
//                        .fecha_introducida(LocalDate.of(2011,6,14))
//                                .precio(35).build();
//
//                figuraServices.add(figura9);
//
//
//
//
//
//            Figura novedad = Figura.builder()
//                                .url("/imagen/fotosLista/gohan.jpg")
//                                .nombre("Gohan")
//                                .des("Gohan modo bestia en la tierra su despertad ma skaioken")
//                                .arco(arco4)
//                    .stock(2)
//                    .categoria("novedad")
//                    .fecha_introducida(LocalDate.of(2006,5,10))
//                                .precio(150).build();
//
//            figuraServices.add(novedad);
//
//            Figura novedad1 = Figura.builder()
//                                .url("/imagen/fotosLista/narutoSabio.jpg")
//                                .nombre("naruto")
//                                .des("naruto pelea contra Pain Modo sabio 20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(2)
//                    .categoria("naruto")
//                    .fecha_introducida(LocalDate.of(2004,8,12))
//                                .precio(50).build();
//
//            figuraServices.add(novedad1);
//
//            Figura novedad2 = Figura.builder()
//                                .url("/imagen/fotosLista/pain.jpg")
//                                .nombre("Pain")
//                                .des("Pain pelea contra naruto Modo sabio 20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(3)
//                    .categoria("novedad")
//                    .fecha_introducida(LocalDate.of(2018,11,26))
//                                .precio(45).build();
//
//            figuraServices.add(novedad2);
//
//            Figura novedad3 = Figura.builder()
//                                .url("/imagen/fotosLista/obito.jpg")
//                                .nombre("Obito")
//                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(0)
//                    .categoria("novedad")
//                    .fecha_introducida(LocalDate.of(2018,11,26))
//                                .precio(50).build();
//
//            figuraServices.add(novedad3);
//
//            Figura novedad4 = Figura.builder()
//                    .url("/imagen/fotosLista/obito.jpg")
//                    .nombre("Obito")
//                    .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                    .arco(arco5)
//                    .stock(0)
//                    .categoria("novedad")
//                    .fecha_introducida(LocalDate.of(2018,11,26))
//                    .precio(50).build();
//
//            figuraServices.add(novedad4);
//
//            Figura novedad5 = Figura.builder()
//                    .url("/imagen/fotosLista/obito.jpg")
//                    .nombre("Obito")
//                    .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                    .arco(arco5)
//                    .stock(0)
//                    .categoria("novedad")
//                    .fecha_introducida(LocalDate.of(2018,11,26))
//                    .precio(50).build();
//
//            figuraServices.add(novedad5);
//
//
//
//            Figura novedad6 = Figura.builder()
//                    .url("/imagen/fotosLista/obito.jpg")
//                    .nombre("Obito")
//                    .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                    .arco(arco5)
//                    .stock(0)
//                    .categoria("novedad")
//                    .fecha_introducida(LocalDate.of(2018,11,26))
//                    .precio(50).build();
//
//            figuraServices.add(novedad6);
//
//
//            Figura onePiece = Figura.builder()
//                                .url("/imagen/fotosOnePiece/luffySombrero.jpg")
//                                .nombre("Luffy")
//                                .des("Luffy en la batalla contra kaido despues de dar la cara ante los yonkous, 30 cm de alto y de largo 122cm")
//                                .arco(arco)
//                    .stock(0)
//                    .categoria("one-piece")
//                    .fecha_introducida(LocalDate.of(2024,10,22))
//                                .precio(50).build();
//
//            figuraServices.add(onePiece);
//
//            Figura onePiece1 = Figura.builder()
//                                .url("/imagen/fotosOnePiece/shanks.jpg")
//                                .nombre("Obito")
//                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(1)
//                    .categoria("one-piece")
//                    .fecha_introducida(LocalDate.of(2024,10,22))
//                                .precio(50).build();
//
//            figuraServices.add(onePiece1);
//
//            Figura onePiece2 = Figura.builder()
//                                .url("/imagen/fotosOnePiece/ace.jpg")
//                                .nombre("Ace")
//                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(2)
//                    .categoria("one-piece")
//                    .fecha_introducida(LocalDate.of(2014,10,22))
//                                .precio(50).build();
//
//            figuraServices.add(onePiece2);
//
//            Figura onePiece3 = Figura.builder()
//                                .url("/imagen/fotosOnePiece/choper.jpg")
//                                .nombre("Obito")
//                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(01)
//                    .categoria("one-piece")
//                    .fecha_introducida(LocalDate.of(2014,11,22))
//                                .precio(50).build();
//
//            figuraServices.add(onePiece3);
//
//            Figura onePiece4 = Figura.builder()
//                                .url("/imagen/fotosOnePiece/trio.jpg")
//                                .nombre("Obito")
//                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(2)
//                    .categoria("one-piece")
//                    .fecha_introducida(LocalDate.of(2021,10,12))
//                                .precio(50).build();
//
//            figuraServices.add(onePiece4);
//
//            Figura onePiece5 = Figura.builder()
//                                .url("/imagen/fotosOnePiece/zoro1.jpg")
//                                .nombre("Obito")
//                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(0)
//                    .categoria("one-piece")
//                    .fecha_introducida(LocalDate.of(2024,10,22))
//                                .precio(50).build();
//
//            figuraServices.add(onePiece5);
//
//            Figura onePiece6 = Figura.builder()
//                                .url("/imagen/fotosOnePiece/nami.jpg")
//                                .nombre("Obito")
//                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(0)
//                    .categoria("one-piece")
//                    .fecha_introducida(LocalDate.of(2024,12,20))
//                                .precio(50).build();
//
//            figuraServices.add(onePiece6);
//
//            Figura onePiece7 = Figura.builder()
//                                .url("/imagen/fotosOnePiece/zoro2.jpg")
//                                .nombre("Obito")
//                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(0)
//                    .categoria("one-piece")
//                    .fecha_introducida(LocalDate.of(2023,10,20))
//                                .precio(50).build();
//
//            figuraServices.add(onePiece7);
//            Figura onePiece8 = Figura.builder()
//                                .url("/imagen/fotosOnePiece/law.jpg")
//                                .nombre("Obito")
//                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(1)
//                    .categoria("one-piece")
//                    .fecha_introducida(LocalDate.of(2023,9,20))
//                                .precio(50).build();
////    **********************************************************************************************************************************************************
//            figuraServices.add(onePiece8);
//            Figura onePiece9 = Figura.builder()
//                                .url("/imagen/fotosOnePiece/sanji.jpg")
//                                .nombre("Obito")
//                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(2)
//                    .categoria("one-piece")
//                    .fecha_introducida(LocalDate.of(2024,1,22))
//                                .precio(60).build();
//
//            figuraServices.add(onePiece9);
//            Figura onePiece10 = Figura.builder()
//                                .url("/imagen/fotosOnePiece/luffy1.jpg")
//                                .nombre("Obito")
//                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(0)
//                    .categoria("one-piece")
//                    .fecha_introducida(LocalDate.of(2012,10,1))
//                                .precio(25).build();
//
//            figuraServices.add(onePiece10);
//            Figura onePiece11 = Figura.builder()
//                                .url("/imagen/fotosOnePiece/barbanegra.jpg")
//                                .nombre("Obito")
//                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(5)
//                    .categoria("one-piece")
//                    .fecha_introducida(LocalDate.of(2010,9,3))
//                                .precio(30).build();
//
//            figuraServices.add(onePiece11);
//            Figura onePiece12 = Figura.builder()
//                                .url("/imagen/fotosOnePiece/kaido.jpg")
//                                .nombre("Obito")
//                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(1)
//                    .categoria("one-piece")
//                    .fecha_introducida(LocalDate.of(2011,7,8))
//                                .precio(50).build();
//
//            figuraServices.add(onePiece12);
//            Figura onePiece13 = Figura.builder()
//                                .url("/imagen/fotosOnePiece/mam.jpg")
//                                .nombre("Big Mam")
//                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(2)
//                    .categoria("one-piece")
//                    .fecha_introducida(LocalDate.of(2010,7,17))
//                                .precio(40).build();
//
//            figuraServices.add(onePiece13);
//            Figura onePiece14 = Figura.builder()
//                                .url("/imagen/fotosOnePiece/sabo.jpg")
//                                .nombre("Sabo")
//                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(3)
//                    .categoria("one-piece")
//                    .fecha_introducida(LocalDate.of(2009,11,7))
//                                .precio(30).build();
//
//            figuraServices.add(onePiece14);
//
//
//
//
//            Figura naruto = Figura.builder()
//                                .url("/imagen/fotosNaruto/gaara.jpeg")
//                                .nombre("Obito")
//                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(1)
//                    .categoria("naruto")
//                    .fecha_introducida(LocalDate.of(2024,10,22))
//                                .precio(50).build();
//
//            figuraServices.add(naruto);
//            Figura naruto1 = Figura.builder()
//                                .url("/imagen/fotosNaruto/naruto1.jpeg")
//                                .nombre("Obito")
//                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(0)
//                    .categoria("naruto")
//                    .fecha_introducida(LocalDate.of(2024,10,22))
//                                .precio(50).build();
//
//            figuraServices.add(naruto1);
//            Figura naruto2 = Figura.builder()
//                                .url("/imagen/fotosNaruto/obito2.jpeg")
//                                .nombre("Obito")
//                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(0)
//                    .categoria("naruto")
//                    .fecha_introducida(LocalDate.of(2024,10,22))
//                                .precio(50).build();
//
//            figuraServices.add(naruto2);
//            Figura naruto3 = Figura.builder()
//                                .url("/imagen/fotosNaruto/itachi.jpeg")
//                                .nombre("Obito")
//                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(0)
//                    .categoria("naruto")
//                    .fecha_introducida(LocalDate.of(2024,10,22))
//                                .precio(50).build();
//
//            figuraServices.add(naruto3);
//            Figura naruto4 = Figura.builder()
//                                .url("/imagen/fotosNaruto/naruto2.jpeg")
//                                .nombre("Obito")
//                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(0)
//                    .categoria("naruto")
//                    .fecha_introducida(LocalDate.of(2024,10,22))
//                                .precio(50).build();
//
//            figuraServices.add(naruto4);
//            Figura naruto5 = Figura.builder()
//                                .url("/imagen/fotosNaruto/pain.jpeg")
//                                .nombre("Obito")
//                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(0)
//                    .categoria("naruto")
//                    .fecha_introducida(LocalDate.of(2024,10,22))
//                                .precio(50).build();
//
//            figuraServices.add(naruto5);
//            Figura naruto6 = Figura.builder()
//                                .url("/imagen/fotosNaruto/kakasi.jpeg")
//                                .nombre("Obito")
//                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(0)
//                    .categoria("naruto")
//                    .fecha_introducida(LocalDate.of(2024,10,22))
//                                .precio(50).build();
//
//            figuraServices.add(naruto6);
//            Figura naruto7 = Figura.builder()
//                                .url("/imagen/fotosNaruto/naruto3.jpeg")
//                                .nombre("Obito")
//                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(0)
//                    .categoria("naruto")
//                    .fecha_introducida(LocalDate.of(2024,10,22))
//                                .precio(50).build();
//
//            figuraServices.add(naruto7);
//            Figura naruto8 = Figura.builder()
//                                .url("/imagen/fotosNaruto/sasuke.jpeg")
//                                .nombre("Obito")
//                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(0)
//                    .categoria("naruto")
//                    .fecha_introducida(LocalDate.of(2024,10,22))
//                                .precio(50).build();
//
//            figuraServices.add(naruto8);
//            Figura naruto9 = Figura.builder()
//                                .url("/imagen/fotosNaruto/madara.jpeg")
//                                .nombre("Obito")
//                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(0)
//                    .categoria("naruto")
//                    .fecha_introducida(LocalDate.of(2024,10,22))
//                                .precio(50).build();
//
//            figuraServices.add(naruto9);
//            Figura naruto10 = Figura.builder()
//                                .url("/imagen/fotosNaruto/obite3.jpeg")
//                                .nombre("Obito")
//                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(0)
//                    .categoria("naruto")
//                    .fecha_introducida(LocalDate.of(2024,10,22))
//                                .precio(50).build();
//
//            figuraServices.add(naruto10);
//            Figura naruto11 = Figura.builder()
//                                .url("/imagen/fotosNaruto/kakasi1.jpeg")
//                                .nombre("Obito")
//                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(0)
//                    .categoria("naruto")
//                    .fecha_introducida(LocalDate.of(2024,10,22))
//                                .precio(50).build();
//
//            figuraServices.add(naruto11);
//            Figura naruto12 = Figura.builder()
//                                .url("/imagen/fotosNaruto/madara1.jpeg")
//                                .nombre("Obito")
//                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(0)
//                    .categoria("naruto")
//                    .fecha_introducida(LocalDate.of(2024,10,22))
//                                .precio(50).build();
//
//            figuraServices.add(naruto12);
//            Figura naruto13 = Figura.builder()
//                                .url("/imagen/fotosNaruto/obito.jpeg")
//                                .nombre("Obito")
//                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(0)
//                    .categoria("naruto")
//                    .fecha_introducida(LocalDate.of(2024,10,22))
//                                .precio(50).build();
//
//            figuraServices.add(naruto13);
//            Figura naruto14 = Figura.builder()
//                                .url("/imagen/fotosNaruto/naruto.jpeg")
//                                .nombre("Obito")
//                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(0)
//                    .categoria("naruto")
//                    .fecha_introducida(LocalDate.of(2024,10,22))
//                                .precio(50).build();
//
//            figuraServices.add(naruto14);
//
//            Figura naruto15 = Figura.builder()
//                                .url("/imagen/fotosNaruto/obito1.jpeg")
//                                .nombre("Obito")
//                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(0)
//                    .categoria("naruto")
//                    .fecha_introducida(LocalDate.of(2024,10,22))
//                                .precio(50).build();
//
//            figuraServices.add(naruto15);
//
//            Figura naruto16 = Figura.builder()
//                                .url("/imagen/fotosNaruto/sakura.jpeg")
//                                .nombre("Obito")
//                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(0)
//                    .categoria("naruto")
//                    .fecha_introducida(LocalDate.of(2024,10,22))
//                                .precio(20).build();
//
//            figuraServices.add(naruto16);
//
//            Figura dragonBall = Figura.builder()
//                                .url("/imagen/fotosDragonBall/broly.jpeg")
//                                .nombre("Obito")
//                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(0)
//                    .categoria("dragon-ball")
//                    .fecha_introducida(LocalDate.of(2024,10,22))
//                                .precio(50).build();
//
//            figuraServices.add(dragonBall);
//            Figura dragonBall1 = Figura.builder()
//                                .url("/imagen/fotosDragonBall/gohan3.jpeg")
//                                .nombre("Obito")
//                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(0)
//                    .categoria("dragon-ball")
//                    .fecha_introducida(LocalDate.of(2024,10,22))
//                                .precio(50).build();
//
//            figuraServices.add(dragonBall1);
//            Figura dragonBall2 = Figura.builder()
//                                .url("/imagen/fotosDragonBall/vegeta.jpeg")
//                                .nombre("Obito")
//                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(0)
//                    .categoria("dragon-ball")
//                    .fecha_introducida(LocalDate.of(2024,10,22))
//                                .precio(50).build();
//
//            figuraServices.add(dragonBall2);
//            Figura dragonBall3 = Figura.builder()
//                                .url("/imagen/fotosDragonBall/broly1.jpeg")
//                                .nombre("Obito")
//                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(0)
//                    .categoria("dragon-ball")
//                    .fecha_introducida(LocalDate.of(2024,10,22))
//                                .precio(50).build();
//
//            figuraServices.add(dragonBall3);
//            Figura dragonBall4 = Figura.builder()
//                                .url("/imagen/fotosDragonBall/goku.jpeg")
//                                .nombre("Obito")
//                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(0)
//                    .categoria("dragon-ball")
//                    .fecha_introducida(LocalDate.of(2024,10,22))
//                                .precio(50).build();
//
//            figuraServices.add(dragonBall4);
//            Figura dragonBall5 = Figura.builder()
//                                .url("/imagen/fotosDragonBall/vegeta1.jpeg")
//                                .nombre("Obito")
//                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(0)
//                    .categoria("dragon-ball")
//                    .fecha_introducida(LocalDate.of(2024,10,22))
//                                .precio(50).build();
//
//            figuraServices.add(dragonBall5);
//            Figura dragonBall6 = Figura.builder()
//                                .url("/imagen/fotosDragonBall/broly2.jpeg")
//                                .nombre("Obito")
//                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(0)
//                    .categoria("dragon-ball")
//                    .fecha_introducida(LocalDate.of(2024,10,22))
//                                .precio(50).build();
//
//            figuraServices.add(dragonBall6);
//            Figura dragonBall7 = Figura.builder()
//                                .url("/imagen/fotosDragonBall/goku1.jpeg")
//                                .nombre("Obito")
//                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(0)
//                    .categoria("dragon-ball")
//                    .fecha_introducida(LocalDate.of(2024,10,22))
//                                .precio(50).build();
//
//            figuraServices.add(dragonBall7);
//            Figura dragonBall8 = Figura.builder()
//                                .url("/imagen/fotosDragonBall/vegeta2.jpeg")
//                                .nombre("Obito")
//                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(0)
//                    .categoria("dragon-ball")
//                    .fecha_introducida(LocalDate.of(2024,10,22))
//                                .precio(50).build();
//
//            figuraServices.add(dragonBall8);
//            Figura dragonBall9 = Figura.builder()
//                                .url("/imagen/fotosDragonBall/gohan.jpeg")
//                                .nombre("Obito")
//                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(0)
//                    .categoria("dragon-ball")
//                    .fecha_introducida(LocalDate.of(2024,10,22))
//                                .precio(50).build();
//
//            figuraServices.add(dragonBall9);
//            Figura dragonBall10 = Figura.builder()
//                                .url("/imagen/fotosDragonBall/goku3.jpeg")
//                                .nombre("Obito")
//                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(0)
//                    .categoria("dragon-ball")
//                    .fecha_introducida(LocalDate.of(2024,10,22))
//                                .precio(50).build();
//
//            figuraServices.add(dragonBall10);
//            Figura dragonBall11 = Figura.builder()
//                                .url("/imagen/fotosDragonBall/vegeta3.jpeg")
//                                .nombre("Obito")
//                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(0)
//                    .categoria("dragon-ball")
//                    .fecha_introducida(LocalDate.of(2024,10,22))
//                                .precio(50).build();
//
//            figuraServices.add(dragonBall11);
//            Figura dragonBall12 = Figura.builder()
//                                .url("/imagen/fotosDragonBall/gohan1.jpeg")
//                                .nombre("Obito")
//                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(0)
//                    .categoria("dragon-ball")
//                    .fecha_introducida(LocalDate.of(2024,10,22))
//                                .precio(50).build();
//
//            figuraServices.add(dragonBall12);
//            Figura dragonBall13 = Figura.builder()
//                                .url("/imagen/fotosDragonBall/goku4.jpeg")
//                                .nombre("Obito")
//                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(0)
//                    .categoria("dragon-ball")
//                    .fecha_introducida(LocalDate.of(2024,10,22))
//                                .precio(50).build();
//
//            figuraServices.add(dragonBall13);
//            Figura dragonBall14 = Figura.builder()
//                                .url("/imagen/fotosDragonBall/vegeta4.jpeg")
//                                .nombre("Obito")
//                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(0)
//                    .categoria("dragon-ball")
//                    .fecha_introducida(LocalDate.of(2024,10,22))
//                                .precio(50).build();
//
//            figuraServices.add(dragonBall14);
//
//            Figura dragonBall15 = Figura.builder()
//                                .url("/imagen/fotosDragonBall/gohan2.jpeg")
//                                .nombre("Obito")
//                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(0)
//                    .categoria("dragon-ball")
//                    .fecha_introducida(LocalDate.of(2024,10,22))
//                                .precio(50).build();
//
//            figuraServices.add(dragonBall15);
//
//            Figura dragonBall16 = Figura.builder()
//                                .url("/imagen/fotosDragonBall/goku5.jpeg")
//                                .nombre("Obito")
//                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(0)
//                    .categoria("dragon-ball")
//                    .fecha_introducida(LocalDate.of(2024,10,22))
//                                .precio(50).build();
//
//            figuraServices.add(dragonBall16);
//
//        }
//
//}
