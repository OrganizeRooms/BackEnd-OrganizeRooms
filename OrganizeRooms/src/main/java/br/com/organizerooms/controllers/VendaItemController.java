/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.organizerooms.controllers;

import br.com.organizerooms.dto.VendaItemDTO;
import br.com.organizerooms.models.VendaItem;
import br.com.organizerooms.models.Response;
import br.com.organizerooms.services.VendaItemService;
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
@RequestMapping("/itensvenda")
public class VendaItemController {
    
     @Autowired
     VendaItemService vendaItemService;
    
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')")
    public ResponseEntity<Response> buscarTodosItensVenda() {
        List<VendaItem> list = vendaItemService.buscarTodosItensVenda();
        List<VendaItemDTO> listDto = list.stream().map(obj -> new VendaItemDTO(obj)).collect(Collectors.toList());
        Response response = new Response(listDto);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')")
    public ResponseEntity<Response> addVenda(@RequestBody VendaItemDTO venda) {
        VendaItem vendaModel = new VendaItem(venda);
        VendaItemDTO vendaDTO = new VendaItemDTO(vendaItemService.addItemVenda(vendaModel));
        Response response = new Response(vendaDTO);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')")
    public ResponseEntity<Response> atualizarVenda(@RequestBody VendaItemDTO venda) {
        VendaItem vendaModel = new VendaItem(venda);
        VendaItemDTO vendaDTO = new VendaItemDTO(vendaItemService.addItemVenda(vendaModel));
        Response response = new Response(vendaDTO);
        return ResponseEntity.ok().body(response);
    }
    
    @DeleteMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')")
    public ResponseEntity<Response> deletarVenda(@RequestBody VendaItemDTO venda) {
        VendaItem vendaModel = new VendaItem(venda);
        VendaItemDTO vendaDTO = new VendaItemDTO(vendaItemService.addItemVenda(vendaModel));
        Response response = new Response(vendaDTO);
        return ResponseEntity.ok().body(response);
    }
}
