/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.organizerooms.services;

import br.com.organizerooms.models.Ingrediente;
import br.com.organizerooms.repositorios.IngrendienteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Leandro Prado
 */
@Service
public class IngredienteService {

    @Autowired
    IngrendienteRepository ingrendienteRepository;

    public List<Ingrediente> buscarTodosIngredientes() {
        return this.ingrendienteRepository.findAllByOrderByNome();
    }

    public void remover(Long id) {
        this.ingrendienteRepository.deleteById(id);
    }

    public Ingrediente addIngrediente(Ingrediente ingrediente) {
        return this.ingrendienteRepository.save(ingrediente);
    }

    public Optional<Ingrediente> buscarPorId(Long id) {
        return this.ingrendienteRepository.findById(id);
    }

    public Ingrediente buscarPorNome(String nome) {
        return this.ingrendienteRepository.findByNome(nome);
    }

}
