package br.com.organizerooms.services;

import java.util.Optional;

import br.com.organizerooms.models.Usuario;

public interface UsuarioService {

	/**
	* Busca e retorna um usuário dado um email.
	*
	* @param email
	* @return Optional<Usuario>
	*/
	Optional <Usuario> buscarPorEmail(String email);
}
