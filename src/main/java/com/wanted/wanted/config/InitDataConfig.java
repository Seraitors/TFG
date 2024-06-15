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
//                                .email("user@wanted.es")
//                                .password("user")
//                                .roles(Set.of(roleUser))
//                                .build();
//                usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
//
//                // usuario1 = usuarioService.save(usuario1);
//
//                Usuario usuario2 = Usuario.builder()
//                                .username("admin")
//                                .email("admin@wanted.es")
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
//                                .fecha_introducida(LocalDate.of(2021,10,11))
//                                .precio(80).build();
//
//                figuraServices.add(figura);
//
//                Figura figura1 = Figura.builder()
//                                .url("/imagen/fotosLista/zoro.jpg")
//                                .nombre("Zoro")
//                                .des("Esta es una figura de Zoro en wano, El ancho es 10 cm de alto y de largo son 70 cm.  ")
//                                .arco(arco2)
//                        .stock(2)
//                        .categoria("one-piece")
//                        .fecha_introducida(LocalDate.of(1999,9,10))
//                                .precio(65).build();
//
//                figuraServices.add(figura1);
//
//                Figura figura2 = Figura.builder()
//                                .url("/imagen/fotosLista/brook1.jpg")
//                                .nombre("Brook")
//                                .des("Esta es una figura de Brook en su lucha de Bif Mom, El ancho es 15 cm de alto y de largo son 50 cm.  ")
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
//                                .des("Esta es la figura de Goku en su lucha contra el malvado Freezer, El ancho es 12 cm de alto y de largo son 60 cm.  ")
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
//                                .des("Esta es una figura de vegeta herido despues de su pelea en Namek, El ancho es 10 cm de alto y de largo son 45 cm.  ")
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
//                                .des("Esta es una figura de Freezer en Namek, El ancho es 10 cm de alto y de largo son 70 cm.  ")
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
//                                .des("Esta es una figura de Piccolo en Namek, El ancho es 11.5 cm de alto y de largo son 300 cm.  ")
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
//                                .des("Esta es una figura de sasuke en la villa oculta de la hoja de pequño, El ancho es 10.5 cm de alto y de largo son 200 cm.  ")
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
//                                .des("Esta es una figura de naruto en la villa oculta de la hoja de pequño, El ancho es 10.5 cm de alto y de largo son 200 cm.  ")
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
//                                .des("Esta es una figura de naruto en la villa oculta de la hoja de mayor, El ancho es 10.5 cm de alto y de largo son 200 cm.  ")
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
//                                .des("Gohan modo bestia en la tierra su despertar kaioken. El ancho es 10.5 cm de alto y de largo son 200 cm.  ")
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
//                                .nombre("Naruto")
//                                .des("naruto pelea contra Pain Modo sabio 20 cm de alto y de largo 20 cm")
//                                .arco(arco5)
//                    .stock(2)
//                    .categoria("naruto")
//                    .fecha_introducida(LocalDate.of(2004,8,12))
//                                .precio(50).build();
//
//            figuraServices.add(novedad1);
//
//            Figura novedad2 = Figura.builder()
//                                .url("/imagen/fotosNovedad/pain.jpeg")
//                                .nombre("Pain")
//                                .des("Pain pelea contra naruto Modo sabio 20 cm de alto y de largo 20 cm")
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
//                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 20cm")
//                                .arco(arco5)
//                    .stock(0)
//                    .categoria("novedad")
//                    .fecha_introducida(LocalDate.of(2018,11,20))
//                                .precio(50).build();
//
//            figuraServices.add(novedad3);
//
//            Figura novedad4 = Figura.builder()
//                    .url("/imagen/fotosNovedad/axel.jpg")
//                    .nombre("Axel")
//                    .des("Axel en su entramiento de la llave espada antes de su enfretamiento con la orgizacion XIII  20 cm de alto y de largo 20cm")
//                    .arco(arco4)
//                    .stock(1)
//                    .categoria("novedad")
//                    .fecha_introducida(LocalDate.of(2019,11,26))
//                    .precio(50).build();
//
//            figuraServices.add(novedad4);
//
//            Figura novedad5 = Figura.builder()
//                    .url("/imagen/fotosNovedad/rimuru.jpg")
//                    .nombre("Rimuru")
//                    .des("El gram Rimuru sentado en su trono como nuevo dios demonio 20 cm de alto y de largo 20cm")
//                    .arco(arco4)
//                    .stock(1)
//                    .categoria("novedad")
//                    .fecha_introducida(LocalDate.of(2018,11,26))
//                    .precio(50).build();
//
//            figuraServices.add(novedad5);
//
//
//
//            Figura novedad6 = Figura.builder()
//                    .url("/imagen/fotosNovedad/roxas.jpg")
//                    .nombre("Roxas")
//                    .des("Roxas incorporeo de de Sora blandido sus dos llaves espadas  20 cm de alto y de largo 20cm")
//                    .arco(arco5)
//                    .stock(1)
//                    .categoria("novedad")
//                    .fecha_introducida(LocalDate.of(2018,12,26))
//                    .precio(50).build();
//
//            figuraServices.add(novedad6);
//
//            Figura novedad7 = Figura.builder()
//                    .url("/imagen/fotosNovedad/sora.jpg")
//                    .nombre("Sora")
//                    .des("Sora en la saga del  salvador kingdom hearts   20 cm de alto y de largo 20cm")
//                    .arco(arco5)
//                    .stock(1)
//                    .categoria("novedad")
//                    .fecha_introducida(LocalDate.of(2019,10,26))
//                    .precio(50).build();
//
//            figuraServices.add(novedad7);
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
//                                .nombre("Shanks")
//                                .des("Shanks unos de los nuevos yonkous del nuevo mar  20 cm de alto y de largo 20cm")
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
//                                .des("Ace hermano de luffy uno de los mejores siempre sera recordado 20 cm de alto y de largo 20cm")
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
//                                .nombre("Chopper")
//                                .des("Chopper unos de los medicos de la tripulacion  20 cm de alto y de largo 20cm")
//                                .arco(arco5)
//                    .stock(1)
//                    .categoria("one-piece")
//                    .fecha_introducida(LocalDate.of(2014,12,22))
//                                .precio(50).build();
//
//            figuraServices.add(onePiece3);
//
//            Figura onePiece4 = Figura.builder()
//                                .url("/imagen/fotosOnePiece/trio.jpg")
//                                .nombre("Tres")
//                                .des("Zoro, Sanji , Luffy lso tres mejores de los sombreros de paja  20 cm de alto y de largo 20cm")
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
//                                .nombre("Zoro")
//                                .des("Zoro guerrero de wano y con sus espadas del olvido  20 cm de alto y de largo 20cm")
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
//                                .nombre("Nami")
//                                .des("Nami navegadora del barco y vicecapitana del viajero  20 cm de alto y de largo 20cm")
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
//                                .nombre("Zoro")
//                                .des("Zoro modo guerrero banda los sombreros de paja 20 cm de alto y de largo 20cm")
//                                .arco(arco5)
//                    .stock(0)
//                    .categoria("one-piece")
//                    .fecha_introducida(LocalDate.of(2023,10,20))
//                                .precio(50).build();
//
//            figuraServices.add(onePiece7);
//            Figura onePiece8 = Figura.builder()
//                                .url("/imagen/fotosOnePiece/law.jpg")
//                                .nombre("Law")
//                                .des("Law amigo de luffy y fiel compañero den el red line 20 cm de alto y de largo 20cm")
//                                .arco(arco5)
//                    .stock(1)
//                    .categoria("one-piece")
//                    .fecha_introducida(LocalDate.of(2023,9,20))
//                                .precio(50).build();
////    **********************************************************************************************************************************************************
//            figuraServices.add(onePiece8);
//            Figura onePiece9 = Figura.builder()
//                                .url("/imagen/fotosOnePiece/sanji.jpg")
//                                .nombre("Sanji ")
//                                .des("En su boda con unas de las hijas de Big Mon 20 cm de alto y de largo 20cm")
//                                .arco(arco5)
//                    .stock(2)
//                    .categoria("one-piece")
//                    .fecha_introducida(LocalDate.of(2024,1,22))
//                                .precio(60).build();
//
//            figuraServices.add(onePiece9);
//            Figura onePiece10 = Figura.builder()
//                                .url("/imagen/fotosOnePiece/luffy1.jpg")
//                                .nombre("Luffy")
//                                .des("Luffy en unas de sus transformacion contra lucci  20 cm de alto y de largo 20cm")
//                                .arco(arco5)
//                    .stock(0)
//                    .categoria("one-piece")
//                    .fecha_introducida(LocalDate.of(2012,10,1))
//                                .precio(25).build();
//
//            figuraServices.add(onePiece10);
//            Figura onePiece11 = Figura.builder()
//                                .url("/imagen/fotosOnePiece/barbanegra.jpg")
//                                .nombre("Barbanegra")
//                                .des("Barbanegra uno de los nuevos yonkous del nuevo mar 20 cm de alto y de largo 20cm")
//                                .arco(arco5)
//                    .stock(2)
//                    .categoria("one-piece")
//                    .fecha_introducida(LocalDate.of(2010,9,3))
//                                .precio(30).build();
//
//            figuraServices.add(onePiece11);
//            Figura onePiece12 = Figura.builder()
//                                .url("/imagen/fotosOnePiece/kaido.jpg")
//                                .nombre("Kaido")
//                                .des("Kaido antiguo emperador del mar y tambien emperador de wano 20 cm de alto y de largo 20cm")
//                                .arco(arco1)
//                    .stock(1)
//                    .categoria("one-piece")
//                    .fecha_introducida(LocalDate.of(2011,7,8))
//                                .precio(50).build();
//
//            figuraServices.add(onePiece12);
//            Figura onePiece13 = Figura.builder()
//                                .url("/imagen/fotosOnePiece/mam.jpg")
//                                .nombre("Big-Mam")
//                                .des("Big Mam modo guerra pelea contra Law y Kidd  20 cm de alto y de largo 20cm")
//                                .arco(arco1)
//                    .stock(2)
//                    .categoria("one-piece")
//                    .fecha_introducida(LocalDate.of(2010,7,17))
//                                .precio(40).build();
//
//            figuraServices.add(onePiece13);
//            Figura onePiece14 = Figura.builder()
//                                .url("/imagen/fotosOnePiece/sabo.jpg")
//                                .nombre("Sabo")
//                                .des("Sabo hermano de Luffy y parte del ejercito de la revolucion 20 cm de alto y de largo 10cm")
//                                .arco(arco1)
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
//                                .nombre("Gaara")
//                                .des("Gaara modo pelea en la gran guerra ninja 20 cm de alto y de largo 20cm")
//                                .arco(arco5)
//                    .stock(1)
//                    .categoria("naruto")
//                    .fecha_introducida(LocalDate.of(2024,10,22))
//                                .precio(50).build();
//
//            figuraServices.add(naruto);
//            Figura naruto1 = Figura.builder()
//                                .url("/imagen/fotosNaruto/naruto1.jpeg")
//                                .nombre("Naruto")
//                                .des("Naruto despertar incompleto del zorro de 9 colas Kurama 20 cm de alto y de largo 20cm")
//                                .arco(arco5)
//                    .stock(0)
//                    .categoria("naruto")
//                    .fecha_introducida(LocalDate.of(2023,10,22))
//                                .precio(50).build();
//
//            figuraServices.add(naruto1);
//            Figura naruto2 = Figura.builder()
//                                .url("/imagen/fotosNaruto/obito2.jpeg")
//                                .nombre("Obito")
//                                .des("Obito cuando perdio todo lo que mas le importaba Rin era su mundo  20 cm de alto y de largo 20cm")
//                                .arco(arco5)
//                    .stock(0)
//                    .categoria("naruto")
//                    .fecha_introducida(LocalDate.of(2022,10,22))
//                                .precio(50).build();
//
//            figuraServices.add(naruto2);
//            Figura naruto3 = Figura.builder()
//                                .url("/imagen/fotosNaruto/itachi.jpeg")
//                                .nombre("Itachi")
//                                .des("Itachi antes de dejar la aldea y matar a todo su clan 20 cm de alto y de largo 20cm")
//                                .arco(arco5)
//                    .stock(1)
//                    .categoria("naruto")
//                    .fecha_introducida(LocalDate.of(2021,10,22))
//                                .precio(50).build();
//
//            figuraServices.add(naruto3);
//            Figura naruto4 = Figura.builder()
//                                .url("/imagen/fotosNaruto/naruto2.jpeg")
//                                .nombre("Naruto")
//                                .des("Naruto despertar del guerrero legendario  20 cm de alto y de largo 20cm")
//                                .arco(arco5)
//                    .stock(1)
//                    .categoria("naruto")
//                    .fecha_introducida(LocalDate.of(2020,10,22))
//                                .precio(50).build();
//
//            figuraServices.add(naruto4);
//            Figura naruto5 = Figura.builder()
//                                .url("/imagen/fotosNaruto/pain.jpeg")
//                                .nombre("Pain")
//                                .des("Pain pelea con Naruto  20 cm de alto y de largo 20cm")
//                                .arco(arco5)
//                    .stock(0)
//                    .categoria("naruto")
//                    .fecha_introducida(LocalDate.of(2024,11,22))
//                                .precio(50).build();
//
//            figuraServices.add(naruto5);
//            Figura naruto6 = Figura.builder()
//                                .url("/imagen/fotosNaruto/kakasi.jpeg")
//                                .nombre("Kakasi")
//                                .des("Kakasi mastro de naruto y futuro Hokague 20 cm de alto y de largo 20cm")
//                                .arco(arco5)
//                    .stock(0)
//                    .categoria("naruto")
//                    .fecha_introducida(LocalDate.of(2024,10,23))
//                                .precio(50).build();
//
//            figuraServices.add(naruto6);
//            Figura naruto7 = Figura.builder()
//                                .url("/imagen/fotosNaruto/naruto3.jpeg")
//                                .nombre("Naruto-Sasuke")
//                                .des("Naruto y Sasuke en la pelicula de la aldea  20 cm de alto y de largo 200cm")
//                                .arco(arco5)
//                    .stock(1)
//                    .categoria("naruto")
//                    .fecha_introducida(LocalDate.of(2024,10,24))
//                                .precio(50).build();
//
//            figuraServices.add(naruto7);
//            Figura naruto8 = Figura.builder()
//                                .url("/imagen/fotosNaruto/sasuke.jpeg")
//                                .nombre("Sasuke")
//                                .des("Sasuke modo pelea en la gran guerra ninja 20 cm de alto y de largo 20cm")
//                                .arco(arco5)
//                    .stock(1)
//                    .categoria("naruto")
//                    .fecha_introducida(LocalDate.of(2024,10,25))
//                                .precio(50).build();
//
//            figuraServices.add(naruto8);
//            Figura naruto9 = Figura.builder()
//                                .url("/imagen/fotosNaruto/madara.jpeg")
//                                .nombre("Madara")
//                                .des("Madara modo pelea en la gran guerra ninja 20 cm de alto y de largo 20cm")
//                                .arco(arco5)
//                    .stock(0)
//                    .categoria("naruto")
//                    .fecha_introducida(LocalDate.of(2024,10,26))
//                                .precio(50).build();
//
//            figuraServices.add(naruto9);
//            Figura naruto10 = Figura.builder()
//                                .url("/imagen/fotosNaruto/obite3.jpeg")
//                                .nombre("Obito")
//                                .des("Obito modo pelea en la gran guerra ninja transformado en besta 20 cm de alto y de largo 20cm")
//                                .arco(arco5)
//                    .stock(0)
//                    .categoria("naruto")
//                    .fecha_introducida(LocalDate.of(2024,10,27))
//                                .precio(50).build();
//
//            figuraServices.add(naruto10);
//            Figura naruto11 = Figura.builder()
//                                .url("/imagen/fotosNaruto/kakasi1.jpeg")
//                                .nombre("Kakasi")
//                                .des("Kakasi de joven en entramiento con su padre  20 cm de alto y de largo 20cm")
//                                .arco(arco5)
//                    .stock(0)
//                    .categoria("naruto")
//                    .fecha_introducida(LocalDate.of(2024,10,28))
//                                .precio(50).build();
//
//            figuraServices.add(naruto11);
//            Figura naruto12 = Figura.builder()
//                                .url("/imagen/fotosNaruto/madara1.jpeg")
//                                .nombre("Madara")
//                                .des("Madara modo pelea en la gran guerra ninja transformase en bestia  20 cm de alto y de largo 20cm")
//                                .arco(arco5)
//                    .stock(2)
//                    .categoria("naruto")
//                    .fecha_introducida(LocalDate.of(2024,10,29))
//                                .precio(50).build();
//
//            figuraServices.add(naruto12);
//            Figura naruto13 = Figura.builder()
//                                .url("/imagen/fotosNaruto/obito.jpeg")
//                                .nombre("Obito")
//                                .des("Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 20cm")
//                                .arco(arco5)
//                    .stock(0)
//                    .categoria("naruto")
//                    .fecha_introducida(LocalDate.of(2024,10,30))
//                                .precio(50).build();
//
//            figuraServices.add(naruto13);
//            Figura naruto14 = Figura.builder()
//                                .url("/imagen/fotosNaruto/naruto.jpeg")
//                                .nombre("Naruto")
//                                .des("Naruto modo ozaru en la gran guerra ninja 20 cm de alto y de largo 20cm")
//                                .arco(arco5)
//                    .stock(1)
//                    .categoria("naruto")
//                    .fecha_introducida(LocalDate.of(2023,10,22))
//                                .precio(50).build();
//
//            figuraServices.add(naruto14);
//
//            Figura naruto15 = Figura.builder()
//                                .url("/imagen/fotosNaruto/obito1.jpeg")
//                                .nombre("Obito")
//                                .des(" Obito despues de ir a la aldea de la niebla 20 cm de alto y de largo 21cm")
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
//                                .nombre("Sakura")
//                                .des("Skura mujer de sasuke  20 cm de alto y de largo 20cm")
//                                .arco(arco5)
//                    .stock(0)
//                    .categoria("naruto")
//                    .fecha_introducida(LocalDate.of(2022,10,22))
//                                .precio(20).build();
//
//            figuraServices.add(naruto16);
//
//            Figura dragonBall = Figura.builder()
//                                .url("/imagen/fotosDragonBall/broly.jpeg")
//                                .nombre("Broly")
//                                .des("Broly el super guerrero legendario  20 cm de alto y de largo 20cm")
//                                .arco(arco4)
//                    .stock(1)
//                    .categoria("dragon-ball")
//                    .fecha_introducida(LocalDate.of(2021,10,22))
//                                .precio(50).build();
//
//            figuraServices.add(dragonBall);
//            Figura dragonBall1 = Figura.builder()
//                                .url("/imagen/fotosDragonBall/gohan3.jpeg")
//                                .nombre("Gohan")
//                                .des("Gohan hijo de goku modo bestia  20 cm de alto y de largo 20cm")
//                                .arco(arco4)
//                    .stock(1)
//                    .categoria("dragon-ball")
//                    .fecha_introducida(LocalDate.of(2024,10,22))
//                                .precio(50).build();
//
//            figuraServices.add(dragonBall1);
//            Figura dragonBall2 = Figura.builder()
//                                .url("/imagen/fotosDragonBall/vegeta.jpeg")
//                                .nombre("Vegeta")
//                                .des("Vegeta primera aparicion en la tierra con Nappa 20 cm de alto y de largo 20cm")
//                                .arco(arco4)
//                    .stock(1)
//                    .categoria("dragon-ball")
//                    .fecha_introducida(LocalDate.of(2022,10,1))
//                                .precio(50).build();
//
//            figuraServices.add(dragonBall2);
//            Figura dragonBall3 = Figura.builder()
//                                .url("/imagen/fotosDragonBall/broly1.jpeg")
//                                .nombre("Broly")
//                                .des("Broly figura de la pelicula contar goku 20 cm de alto y de largo 20cm")
//                                .arco(arco4)
//                    .stock(1)
//                    .categoria("dragon-ball")
//                    .fecha_introducida(LocalDate.of(2022,10,2))
//                                .precio(50).build();
//
//            figuraServices.add(dragonBall3);
//            Figura dragonBall4 = Figura.builder()
//                                .url("/imagen/fotosDragonBall/goku.jpeg")
//                                .nombre("Goku")
//                                .des("Goku en su transformacion se super sayan blue 20 cm de alto y de largo 20cm")
//                                .arco(arco4)
//                    .stock(1)
//                    .categoria("dragon-ball")
//                    .fecha_introducida(LocalDate.of(2022,10,3))
//                                .precio(50).build();
//
//            figuraServices.add(dragonBall4);
//            Figura dragonBall5 = Figura.builder()
//                                .url("/imagen/fotosDragonBall/vegeta1.jpeg")
//                                .nombre("Vegeta")
//                                .des("Vegeta  en su transformacion se super sayan blue  20 cm de alto y de largo 20cm")
//                                .arco(arco4)
//                    .stock(1)
//                    .categoria("dragon-ball")
//                    .fecha_introducida(LocalDate.of(2022,10,4))
//                                .precio(50).build();
//
//            figuraServices.add(dragonBall5);
//            Figura dragonBall6 = Figura.builder()
//                                .url("/imagen/fotosDragonBall/broly2.jpeg")
//                                .nombre("Broly")
//                                .des("Broly en su segunda transformacion  20 cm de alto y de largo 20cm")
//                                .arco(arco4)
//                    .stock(0)
//                    .categoria("dragon-ball")
//                    .fecha_introducida(LocalDate.of(2022,10,5))
//                                .precio(50).build();
//
//            figuraServices.add(dragonBall6);
//            Figura dragonBall7 = Figura.builder()
//                                .url("/imagen/fotosDragonBall/goku1.jpeg")
//                                .nombre("Goku")
//                                .des("Goku  en su transformacion de super sayan  20 cm de alto y de largo 20cm")
//                                .arco(arco4)
//                    .stock(0)
//                    .categoria("dragon-ball")
//                    .fecha_introducida(LocalDate.of(2022,10,5))
//                                .precio(50).build();
//
//            figuraServices.add(dragonBall7);
//            Figura dragonBall8 = Figura.builder()
//                                .url("/imagen/fotosDragonBall/vegeta2.jpeg")
//                                .nombre("Vegeta")
//                                .des("Vegeta en su modo super sayan blue 20 cm de alto y de largo 20cm")
//                                .arco(arco4)
//                    .stock(2)
//                    .categoria("dragon-ball")
//                    .fecha_introducida(LocalDate.of(2022,10,6))
//                                .precio(50).build();
//
//            figuraServices.add(dragonBall8);
//            Figura dragonBall9 = Figura.builder()
//                                .url("/imagen/fotosDragonBall/gohan.jpeg")
//                                .nombre("Gohan")
//                                .des("Gohan en la saga de Cell super sayan 2   20 cm de alto y de largo 20cm")
//                                .arco(arco4)
//                    .stock(1)
//                    .categoria("dragon-ball")
//                    .fecha_introducida(LocalDate.of(2022,10,7))
//                                .precio(50).build();
//
//            figuraServices.add(dragonBall9);
//            Figura dragonBall10 = Figura.builder()
//                                .url("/imagen/fotosDragonBall/goku3.jpeg")
//                                .nombre("Goku")
//                                .des("Black Goku es Zamas en el cuerpo de Goku  20 cm de alto y de largo 20cm")
//                                .arco(arco4)
//                    .stock(0)
//                    .categoria("dragon-ball")
//                    .fecha_introducida(LocalDate.of(2022,10,8))
//                                .precio(50).build();
//
//            figuraServices.add(dragonBall10);
//            Figura dragonBall11 = Figura.builder()
//                                .url("/imagen/fotosDragonBall/vegeta3.jpeg")
//                                .nombre("Vegeta")
//                                .des("Vegeta en la saga de  Majin Buu 20 cm de alto y de largo 20cm")
//                                .arco(arco4)
//                    .stock(1)
//                    .categoria("dragon-ball")
//                    .fecha_introducida(LocalDate.of(2024,10,9))
//                                .precio(50).build();
//
//            figuraServices.add(dragonBall11);
//            Figura dragonBall12 = Figura.builder()
//                                .url("/imagen/fotosDragonBall/gohan1.jpeg")
//                                .nombre("Gohan ")
//                                .des("Gohan  de pequeño  20 cm de alto y de largo 20cm")
//                                .arco(arco4)
//                    .stock(0)
//                    .categoria("dragon-ball")
//                    .fecha_introducida(LocalDate.of(2022,10,10))
//                                .precio(50).build();
//
//            figuraServices.add(dragonBall12);
//            Figura dragonBall13 = Figura.builder()
//                                .url("/imagen/fotosDragonBall/goku4.jpeg")
//                                .nombre("Gogueta")
//                                .des("Gogueta  fison de Goku y Vegeta 20 cm de alto y de largo 20cm")
//                                .arco(arco4)
//                    .stock(0)
//                    .categoria("dragon-ball")
//                    .fecha_introducida(LocalDate.of(2022,10,11))
//                                .precio(50).build();
//
//            figuraServices.add(dragonBall13);
//            Figura dragonBall14 = Figura.builder()
//                                .url("/imagen/fotosDragonBall/vegeta4.jpeg")
//                                .nombre("Vegeta")
//                                .des("Vegeta modo ultra ego   20 cm de alto y de largo 20cm")
//                                .arco(arco4)
//                    .stock(0)
//                    .categoria("dragon-ball")
//                    .fecha_introducida(LocalDate.of(2022,10,13))
//                                .precio(50).build();
//
//            figuraServices.add(dragonBall14);
//
//            Figura dragonBall15 = Figura.builder()
//                                .url("/imagen/fotosDragonBall/gohan2.jpeg")
//                                .nombre("Gohan-Goku")
//                                .des(" Gohan y Goku de joven pasando tiempo padre e hijo  20 cm de alto y de largo 20cm")
//                                .arco(arco4)
//                    .stock(1)
//                    .categoria("dragon-ball")
//                    .fecha_introducida(LocalDate.of(2022,10,14))
//                                .precio(50).build();
//
//            figuraServices.add(dragonBall15);
//
//            Figura dragonBall16 = Figura.builder()
//                                .url("/imagen/fotosDragonBall/goku5.jpeg")
//                                .nombre("Goku")
//                                .des("Goku de pequeño en el torneo de artes marciales 20 cm de alto y de largo 20cm")
//                                .arco(arco4)
//                    .stock(0)
//                    .categoria("dragon-ball")
//                    .fecha_introducida(LocalDate.of(2022,10,14))
//                                .precio(50).build();
//
//            figuraServices.add(dragonBall16);
//
//        }
//
//}
