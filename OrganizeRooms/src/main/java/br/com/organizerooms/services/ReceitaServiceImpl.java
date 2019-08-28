package br.com.organizerooms.services;

import br.com.organizerooms.models.Receita;
import br.com.organizerooms.models.Usuario;
import br.com.organizerooms.repositorios.ReceitaRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lucas Jansen
 */
@Service
public class ReceitaServiceImpl {

    @Autowired
    private ReceitaRepository receitaRepository;

    public Receita addReceita(Receita receita) {
        return this.receitaRepository.save(receita);
    }

    public Optional<Receita> buscarPorId(Long id) {
        return this.receitaRepository.findById(id);
    }
}
