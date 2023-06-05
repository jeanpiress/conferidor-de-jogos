package com.jeanpiress.conferidordejogos.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeanpiress.conferidordejogos.dto.Constancia;
import com.jeanpiress.conferidordejogos.dto.ResultadoRecebidoDTO;
import com.jeanpiress.conferidordejogos.dto.ResultadosDTO;
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
	
	
	public List<ResultadosDTO> ultimosResultados(){
		List<Resultado> r = repository.findAll();
		List<ResultadosDTO> listDto = r.stream().map(x -> new ResultadosDTO(x)).collect(Collectors.toList());
		
		Long ultimo = 0L;
		
		for(ResultadosDTO m: listDto) {
			if(m.getNumeroConcurso()> ultimo) {
				ultimo = m.getNumeroConcurso();
			}
			
		}
		
		
		
		
		Resultado resultado = repository.findByNumeroConcurso(ultimo);
		Resultado resultado2 = repository.findByNumeroConcurso(ultimo -1);
		Resultado resultado3 = repository.findByNumeroConcurso(ultimo -2);
		Resultado resultado4 = repository.findByNumeroConcurso(ultimo -3);
		
		ResultadosDTO menu = new ResultadosDTO(resultado);
		ResultadosDTO menu2 = new ResultadosDTO(resultado2);
		ResultadosDTO menu3 = new ResultadosDTO(resultado3);
		ResultadosDTO menu4 = new ResultadosDTO(resultado4);
		
		List<ResultadosDTO> menuList = new ArrayList<>();
		
		
		menuList.addAll(Arrays.asList(menu, menu2, menu3, menu4 ));
		
		return menuList;
	}
	
	public Constancia constancia(){
		List<ResultadosDTO> listResultados = ultimosResultados();
		
		Constancia menuDto = new Constancia() ;
		
		List<Integer> possiveis = IntStream.rangeClosed(1, 25).boxed().collect(Collectors.toList());
		List<Integer> repetido = new ArrayList<>();
		List<Integer> naoRepete= new ArrayList<>();
		
		
		ResultadosDTO resultado = listResultados.get(0);
		ResultadosDTO resultado2 = listResultados.get(1);
		ResultadosDTO resultado3 = listResultados.get(2);
		ResultadosDTO resultado4 = listResultados.get(3);
		

		
		for(Integer p: possiveis) {
			if(resultado.getList().contains(p) 
					&& resultado2.getList().contains(p)
					&& resultado3.getList().contains(p)
					&& resultado4.getList().contains(p))
			{
				
				repetido.add(p);
			}
		}
		
		for(Integer p: possiveis) {
			if(resultado.getList().contains(p) == false
					&& resultado2.getList().contains(p) == false
					&& resultado3.getList().contains(p) == false
					&& resultado4.getList().contains(p) == false) {
				
				naoRepete.add(p);
			}
		}
		
		menuDto.setNumerosNaoRepetidos(naoRepete);
		menuDto.setNumerosRepetidos(repetido);
		
		
		
		return menuDto;
	}
	
	public List<ResultadosDTO> ordenarListaResultado(List<ResultadosDTO> resultados) {
		List<Integer> listaOrdenada = new ArrayList<>();
		for(ResultadosDTO r: resultados) {
			listaOrdenada = r.getList().stream().sorted().collect(Collectors.toList());
			r.setList(listaOrdenada);
		}
		return resultados;
		
		
	}
	
	
	
	
}