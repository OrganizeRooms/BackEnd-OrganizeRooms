/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.organizerooms.controllers;

import br.com.organizerooms.dto.VendaDTO;
import br.com.organizerooms.models.Venda;
import br.com.organizerooms.models.Response;
import br.com.organizerooms.services.VendaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.stream.Collectors;

/**
 *
 * @author Eder Jean Dias
 */

@RestController
@RequestMapping("/vendas")
public class VendaController {
    
     @Autowired
     VendaService vendaService;
    
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')")
    public ResponseEntity<Response> buscarTodasVendas() {
        List<Venda> list = vendaService.buscarTodasVendas();
        List<VendaDTO> listDto = list.stream().map(obj -> new VendaDTO(obj)).collect(Collectors.toList());
        Response response = new Response(listDto);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')")
    public ResponseEntity<Response> addVenda(@RequestBody VendaDTO venda) {
        Venda vendaModel = new Venda(venda);
        VendaDTO vendaDTO = new VendaDTO(vendaService.addVenda(vendaModel));
        Response response = new Response(vendaDTO);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')")
    public ResponseEntity<Response> atualizarVenda(@RequestBody VendaDTO venda) {
        Venda vendaModel = new Venda(venda);
        VendaDTO vendaDTO = new VendaDTO(vendaService.addVenda(vendaModel));
        Response response = new Response(vendaDTO);
        return ResponseEntity.ok().body(response);
    }
    
    @DeleteMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')")
    public ResponseEntity<Response> deletarVenda(@RequestBody VendaDTO venda) {
        Venda vendaModel = new Venda(venda);
        VendaDTO vendaDTO = new VendaDTO(vendaService.addVenda(vendaModel));
        Response response = new Response(vendaDTO);
        return ResponseEntity.ok().body(response);
    }
}
