package br.com.organizerooms.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.organizerooms.models.Venda;
import br.com.organizerooms.models.Usuario;
import br.com.organizerooms.repositorios.VendaRepository;
import java.util.List;

@Service
public class VendaService{

	@Autowired
	private VendaRepository vendaRepository;
        
        public List<Venda> buscarTodasVendas(){
            return this.vendaRepository.findAll();
        }
        
        public Venda addVenda(Venda venda){            
            return this.vendaRepository.save(venda);       
        }
        
        public Optional<Venda> buscarPorId(Long id){
            return this.vendaRepository.findById(id);
        }
}
