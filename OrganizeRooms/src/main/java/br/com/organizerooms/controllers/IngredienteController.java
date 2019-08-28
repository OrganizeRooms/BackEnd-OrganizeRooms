/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.organizerooms.controllers;

import br.com.organizerooms.dto.IngredienteDTO;
import br.com.organizerooms.models.Ingrediente;
import br.com.organizerooms.models.Response;
import br.com.organizerooms.services.IngredienteService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Leandro Prado
 */
@RestController
@RequestMapping("/ingrediente")
public class IngredienteController {

    @Autowired
    IngredienteService ingredienteService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')")
    public ResponseEntity<Response> buscarTodosIngredientes() {
        List<Ingrediente> list = ingredienteService.buscarTodosIngredientes();
        Response response = new Response(list);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')")
    public ResponseEntity<Response> addIngrediente(@RequestBody IngredienteDTO ingrDto) {
        Ingrediente ingrediente;
        Boolean adicionou = false;

        if (ingrDto != null) {
            if (!existeIngrediente(ingrDto)) {
                ingrediente = ingredienteService.addIngrediente(new Ingrediente(ingrDto));

                if (ingrediente != null) {
                    adicionou = true;
                }
            }
        }
        return ResponseEntity.ok().body(new Response(adicionou));
    }

    @PutMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')")
    public ResponseEntity<Response> alterarIngrediente(@RequestBody IngredienteDTO ingrDto) {
        Ingrediente ingrediente;
        Boolean alterou = false;

        if (ingrDto != null) {
            Optional<Ingrediente> oriIngrediente = ingredienteService.buscarPorId(ingrDto.getId());

            ingrediente = ingredienteService.addIngrediente(new Ingrediente(ingrDto));
            if (ingrediente == null) {
                return ResponseEntity.ok().body(new Response(alterou));
            } else {
                if (!oriIngrediente.get().getNome().equalsIgnoreCase(ingrediente.getNome())) {
                    alterou = true;
                }
            }
        }
        return ResponseEntity.ok().body(new Response(alterou));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')")
    public ResponseEntity<Response> deletarIngrediente(@PathVariable String id) {
        Boolean deletou = false;

        if (id != null) {
            if (!existeIngredienteReceita(Long.parseLong(id))) {
                ingredienteService.remover(Long.parseLong(id));

                deletou = !ingredienteService.buscarPorId(Long.parseLong(id)).isPresent();
            }
        }
        return ResponseEntity.ok().body(new Response(deletou));
    }

    private Boolean existeIngrediente(IngredienteDTO ingrDto) {
        Ingrediente ingre = this.ingredienteService.buscarPorNome(ingrDto.getNome().toUpperCase());
        return ingre != null;
    }

    private Boolean existeIngredienteReceita(Long idIngr) {

        Optional<Ingrediente> opIngre = this.ingredienteService.buscarPorId(idIngr);
        Ingrediente ingr = opIngre.get();

        return !ingr.getReceitas().isEmpty();
    }
}
