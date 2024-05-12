package com.wanted.wanted.servicios;


import com.wanted.wanted.entidades.Usuario;


import com.wanted.wanted.repositorio.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service

public class UsuarioServices {


    private final UsuarioRepository usuarioRepository;



    private final PasswordEncoder passwordEncoder;





    public Usuario save(Usuario u) {
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        return usuarioRepository.save(u);
    }





    public List<Usuario> saveAll (List<Usuario> lista) { return usuarioRepository.saveAll(lista); }

    public Usuario findById(long id) {
        return usuarioRepository.findById(id).orElse(null);
    }


    public Usuario findByUsernameOrEmail(String username, String email) {
        return usuarioRepository.findByUsernameOrEmail(username, email).orElse(null);
    }




    private List<Usuario> usuarios = new ArrayList<>();

        public void registrarUsuario(Usuario usuario) {
            usuarios.add(usuario);
        }

        public boolean validarUsuario(String email, String contrasena) {
            for (Usuario usuario : usuarios) {
                if (usuario.getEmail().equals(email) && usuario.getPassword().equals(contrasena)) {
                    return true; // Credenciales válidas
                }
            }
            return false; // Credenciales inválidas
        }


}
