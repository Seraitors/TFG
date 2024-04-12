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
    private FiguraServices  figuraServices;

    @Autowired
    private ArcoServices arcoServices;



   /* private final PasswordEncoder passwordEncoder;
    private final RegistrarService registrarService;

    @PostConstruct
    public void initUsuarios() {
        Roles roleUser = Roles.builder().nombre("ROLE_USER").build();
        //perfilUser = perfilService.save(perfilUser);
        Roles perfilAdmin = Roles.builder().nombre("ROLE_ADMIN").build();
        //perfilAdmin = perfilService.save(perfilAdmin);

        Registrar registrar = Registrar.builder()
                .username("user")
                .email("user@canciones.es")
                .password("user")
                .roles(Set.of(roleUser))
                .build();
        registrar.setPassword(passwordEncoder.encode(registrar.getPassword()));

        //usuario1 = usuarioService.save(usuario1);

        Registrar registrar2 = Registrar.builder()
                .username("admin")
                .email("admin@canciones.es")
                .password("admin")
                .roles(Set.of(roleUser, perfilAdmin))
                .build();
        registrar2.setPassword(passwordEncoder.encode(registrar2.getPassword()));

        //usuario2 = usuarioService.save(usuario2);
        registrarService.saveAll(Arrays.asList(registrar,registrar2));
    }*/

/**
 * hacer la base de datos como en el examen
 */


@PostConstruct
    public  void  initData(){

    Arco arco = Arco.builder()
            .nombre("Wano").build();

    arcoServices.add(arco);

    Figura figura =Figura.builder()
            .nombre("Luffy")
            .des("Esta es una figura de luffy cuando estaba en wano ")
            .arco(arco)
            .precio(80).build();

        figuraServices.add(figura);

}





}
