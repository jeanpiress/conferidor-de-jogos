package com.jeanpiress.conferidordejogos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeanpiress.conferidordejogos.entities.Resultado;
import com.jeanpiress.conferidordejogos.repository.ResultadoRepository;

@Service
public class ResultadoService {
   

	@Autowired
	private ResultadoRepository repository;
    


	public List<Resultado> buscar(){
		return repository.findAll();
	}
	
	public Resultado buscarPorId(Long id) {
		Optional<Resultado> obj = repository.findById(id);
		return obj.get();
	}

	public Resultado inserir(Resultado resultado) {
		return repository.save(resultado);
		}
	
	public void deletar(Long id) {
		repository.deleteById(id);
		
	}
	
	public Resultado atualizar(Long id, Resultado resultado) {
		Resultado resultado2 = repository.getReferenceById(id);
		BeanUtils.copyProperties(resultado, resultado2, "id");
		 return repository.save(resultado2);
		
    }
}