package com.jeanpiress.conferidordejogos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotNull;
import javax.xml.bind.ParseConversionEvent;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeanpiress.conferidordejogos.dto.JogoRecebidoDTO;
import com.jeanpiress.conferidordejogos.entities.Jogo;
import com.jeanpiress.conferidordejogos.repository.JogoRepository;

@Service
public class JogoService {
   

	@Autowired
	private JogoRepository repository;
	
    


	public List<Jogo> buscar(){
		return repository.findAll();
	}
	
	public Jogo buscarPorId(Long id) {
		Optional<Jogo> obj = repository.findById(id);
		return obj.get();
	}
	
	public List<Jogo> buscarPorConcurso(Long concurso) {
		List<Jogo> obj = repository.findByNumeroConcurso(concurso);
		if(obj.size() == 0) {
			throw new EntityNotFoundException();
		}
		return obj;
		
	}
	
	public List<Jogo> buscarPorConcursoEUsuario(Long concurso, Long usuario) {
		
		List<Jogo> obj = repository.buscarPorNumeroConcursoAndUsuario(concurso, usuario);
		if(obj.size() == 0) {	
		throw new EntityNotFoundException();
		}
		return obj;
		
	}
	
	public Jogo converter(JogoRecebidoDTO jogoRecebido) {
		List<String> list = jogoRecebido.getList();
		List<Integer> numeros = new ArrayList<>();
		
		for(String x: list) {
			Integer a = Integer.parseInt(x);
			numeros.add(a);
		}
		
		Integer primeiro = null;	Integer segundo = null; Integer terceiro = null; Integer quarto = null;
		Integer quinto = null;	Integer sexto = null;	Integer setimo = null; Integer oitavo = null;
		Integer nono = null;	Integer decimo = null; Integer DPrimeiro = null;	Integer DSegundo = null;
		Integer DTerceiro = null;	Integer DQuarto = null;	Integer DQuinto = null;	Integer DSexto = null;
		Integer DSetimo = null;	Integer DOitavo = null;	Integer DNono = null;	Integer Vigesimo = null;
		
		
		if(numeros.size() == 15) {
		primeiro = numeros.get(0);	segundo = numeros.get(1); terceiro = numeros.get(2); quarto = numeros.get(3);
		quinto = numeros.get(4);	sexto = numeros.get(5);	setimo = numeros.get(6); oitavo = numeros.get(7);
		nono = numeros.get(8);	decimo = numeros.get(9); DPrimeiro = numeros.get(10);	DSegundo = numeros.get(11);
		DTerceiro = numeros.get(12);	DQuarto = numeros.get(13);	DQuinto = numeros.get(14);	DSexto = null;	
		DSetimo = null;	DOitavo = null;	DNono = null;	Vigesimo = null;}
		
		 if(numeros.size() == 16) {
			primeiro = numeros.get(0);	segundo = numeros.get(1); terceiro = numeros.get(2); quarto = numeros.get(3);
			quinto = numeros.get(4);	sexto = numeros.get(5);	setimo = numeros.get(6); oitavo = numeros.get(7);
			nono = numeros.get(8);	decimo = numeros.get(9); DPrimeiro = numeros.get(10);	DSegundo = numeros.get(11);
			DTerceiro = numeros.get(12);	DQuarto = numeros.get(13);	DQuinto = numeros.get(14);	DSexto = numeros.get(15);
			DSetimo = null;	DOitavo = null;	DNono = null;	Vigesimo = null;}
		
		 if(numeros.size() == 17) {
			primeiro = numeros.get(0);	segundo = numeros.get(1); terceiro = numeros.get(2); quarto = numeros.get(3);
			quinto = numeros.get(4);	sexto = numeros.get(5);	setimo = numeros.get(6); oitavo = numeros.get(7);
			nono = numeros.get(8);	decimo = numeros.get(9); DPrimeiro = numeros.get(10);	DSegundo = numeros.get(11);
			DTerceiro = numeros.get(12);	DQuarto = numeros.get(13);	DQuinto = numeros.get(14);	DSexto = numeros.get(15);
			DSetimo = numeros.get(16);	DOitavo = null;	DNono = null;	Vigesimo = null;}
		
		 if(numeros.size() == 18) {
			primeiro = numeros.get(0);	segundo = numeros.get(1); terceiro = numeros.get(2); quarto = numeros.get(3);
			quinto = numeros.get(4);	sexto = numeros.get(5);	setimo = numeros.get(6); oitavo = numeros.get(7);
			nono = numeros.get(8);	decimo = numeros.get(9); DPrimeiro = numeros.get(10);	DSegundo = numeros.get(11);
			DTerceiro = numeros.get(12);	DQuarto = numeros.get(13);	DQuinto = numeros.get(14);	DSexto = numeros.get(15);
			DSetimo = numeros.get(16);	DOitavo = numeros.get(17);	DNono = null;	Vigesimo = null;}
		
		 if(numeros.size() == 19) {
			primeiro = numeros.get(0);	segundo = numeros.get(1); terceiro = numeros.get(2); quarto = numeros.get(3);
			quinto = numeros.get(4);	sexto = numeros.get(5);	setimo = numeros.get(6); oitavo = numeros.get(7);
			nono = numeros.get(8);	decimo = numeros.get(9); DPrimeiro = numeros.get(10);	DSegundo = numeros.get(11);
			DTerceiro = numeros.get(12);	DQuarto = numeros.get(13);	DQuinto = numeros.get(14);	DSexto = numeros.get(15);
			DSetimo = numeros.get(16);	DOitavo = numeros.get(17);	DNono = numeros.get(18);	Vigesimo = null;}
		
		if(numeros.size() == 20)	{
			primeiro = numeros.get(0);	segundo = numeros.get(1); terceiro = numeros.get(2); quarto = numeros.get(3);
			quinto = numeros.get(4);	sexto = numeros.get(5);	setimo = numeros.get(6); oitavo = numeros.get(7);
			nono = numeros.get(8);	decimo = numeros.get(9); DPrimeiro = numeros.get(10);	DSegundo = numeros.get(11);
			DTerceiro = numeros.get(12);	DQuarto = numeros.get(13);	DQuinto = numeros.get(14);	DSexto = numeros.get(15);
			DSetimo = numeros.get(16);	DOitavo = numeros.get(17);	DNono = numeros.get(18);	Vigesimo = numeros.get(19);}
		
		Jogo jogo = new Jogo(null, jogoRecebido.getNumeroConcurso(), primeiro, segundo, terceiro, quarto, quinto, sexto, setimo, oitavo, nono, decimo, DPrimeiro, DSegundo,
				DTerceiro, DQuarto, DQuinto, DSexto, DSetimo, DOitavo, DNono, Vigesimo, jogoRecebido.getUsuario());
		
	return jogo;	
		
	}
	
				
	

	
	public Jogo inserir(Jogo jogo) {
		return repository.save(jogo);
		}
	
	public void deletar(Long id) {
		repository.deleteById(id);
		
	}
	
	public Jogo atualizar(Long id, Jogo jogo) {
		Jogo jogo2 = repository.getReferenceById(id);
		BeanUtils.copyProperties(jogo, jogo2, "id");
		 return repository.save(jogo2);
		
    }
}