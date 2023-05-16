package com.jeanpiress.conferidordejogos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeanpiress.conferidordejogos.dto.ResultadoRecebidoDTO;
import com.jeanpiress.conferidordejogos.entities.Jogo;
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
	
	public Resultado buscarPorConsurso(Long concurso) {
		Resultado obj = repository.findByNumeroConcurso(concurso);
		if(obj == null) {
			throw new EntityNotFoundException();
		}
		return obj;
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
	
	public Resultado converterResultado(ResultadoRecebidoDTO resultadoRecebido) {
		List<String> list = resultadoRecebido.getList();
		List<Integer> numeros = new ArrayList<>();
		
		for(String x: list) {
			Integer a = Integer.parseInt(x);
			numeros.add(a);
		}
		
		Integer primeiro = numeros.get(0);	Integer segundo = numeros.get(1); Integer terceiro = numeros.get(2); 
		Integer quarto = numeros.get(3); Integer quinto = numeros.get(4);	Integer sexto = numeros.get(5);	
		Integer setimo = numeros.get(6); Integer oitavo = numeros.get(7); Integer nono = numeros.get(8);	
		Integer decimo = numeros.get(9); Integer DPrimeiro = numeros.get(10); Integer DSegundo = numeros.get(11);
		Integer DTerceiro = numeros.get(12); Integer DQuarto = numeros.get(13);	Integer DQuinto = numeros.get(14);
		
		
		
		
		Resultado resultado = new Resultado(null, resultadoRecebido.getNumeroConcurso(), primeiro, segundo, terceiro, quarto, quinto, sexto, setimo, oitavo, nono, decimo, DPrimeiro, DSegundo,
				DTerceiro, DQuarto, DQuinto);
		
	return resultado;	
		
	}
}