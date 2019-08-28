package br.com.organizerooms.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.organizerooms.models.VendaItem;
import br.com.organizerooms.repositorios.VendaItemRepository;
import java.util.List;

@Service
public class VendaItemService{

	@Autowired
	private VendaItemRepository vendaItemRepository;
        
        public List<VendaItem> buscarTodosItensVenda(){
            return this.vendaItemRepository.findAll();
        }
        
        public VendaItem addItemVenda(VendaItem venda){            
            return this.vendaItemRepository.save(venda);       
        }
        
        public Optional<VendaItem> buscarPorId(Long id){
            return this.vendaItemRepository.findById(id);
        }
}
