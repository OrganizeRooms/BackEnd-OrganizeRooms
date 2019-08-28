package br.com.organizerooms.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.organizerooms.models.Usuario;
import br.com.organizerooms.repositorios.UsuarioRepository;
import java.util.List;

@Service
public class UsuarioServiceImpl implements  UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;

        @Override
	public Optional<Usuario> buscarPorEmail(String email) {
		return Optional.ofNullable(this.usuarioRepository.findByEmail(email));
	}
        
        public List<Usuario> buscarTodosUsuarios(){
            return this.usuarioRepository.findAllByOrderByNome();
        }
        
        public Usuario addUsuario(Usuario user){            
            return this.usuarioRepository.save(user);       
        }
        
        public Optional<Usuario> buscarPorId(Long id){
            return this.usuarioRepository.findById(id);
        }
}
