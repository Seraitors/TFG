package com.wanted.wanted.servicios;

import com.wanted.wanted.entidades.Usuario;
import com.wanted.wanted.repositorio.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UsuarioServices {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public Usuario save(Usuario u) {
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        return usuarioRepository.save(u);
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public List<Usuario> saveAll(List<Usuario> lista) {
        return usuarioRepository.saveAll(lista);
    }

    public Optional<Usuario> findById(long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario findByUsernameOrEmail(String username, String email) {
        return usuarioRepository.findByUsernameOrEmail(username, email).orElse(null);
    }

    public Usuario edit(Usuario m) {
        return usuarioRepository.save(m);
    }

    public void delete(Usuario m) {
        usuarioRepository.delete(m);
    }
}
