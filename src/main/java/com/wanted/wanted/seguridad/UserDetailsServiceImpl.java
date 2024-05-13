package com.wanted.wanted.seguridad;


import com.wanted.wanted.entidades.Usuario;
import com.wanted.wanted.repositorio.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UsuarioRepository  registratRepositorio;
	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		Usuario registrar = registratRepositorio.buscarPorUsernameOEmail(s)
				.orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

		return User.builder()
				.username(registrar.getUsername())
				.password(registrar.getPassword())
				.authorities(registrar.getRoles().stream()
						.map((perfil) -> new SimpleGrantedAuthority(perfil.getNombre()))
						.collect(Collectors.toSet()))
				.disabled(false)
				.build();
	}
}