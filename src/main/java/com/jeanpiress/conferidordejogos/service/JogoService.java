package com.jeanpiress.conferidordejogos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotNull;
import javax.xml.bind.ParseConversionEvent;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeanpiress.conferidordejogos.dto.JogoRecebidoDTO;
import com.jeanpiress.conferidordejogos.entities.Jogo;
import com.jeanpiress.conferidordejogos.entities.Usuario;
import com.jeanpiress.conferidordejogos.repository.JogoRepository;
import com.jeanpiress.conferidordejogos.repository.UsuarioRepository;

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
		
		
		Integer primeiro = numeros.get(0);	Integer  segundo = numeros.get(1); Integer  terceiro = numeros.get(2); Integer  quarto = numeros.get(3);
		Integer  quinto = numeros.get(4);	Integer sexto = numeros.get(5);	Integer  setimo = numeros.get(6); Integer  oitavo = numeros.get(7);
		Integer  nono = numeros.get(8);	Integer  decimo = numeros.get(9); Integer  DPrimeiro = numeros.get(10);	Integer  DSegundo = numeros.get(11);
		Integer  DTerceiro = numeros.get(12);	Integer  DQuarto = numeros.get(13);	Integer  DQuinto = numeros.get(14);	Integer  DSexto = null;	
		Integer  DSetimo = null;	Integer DOitavo = null;	Integer  DNono = null;	Integer Vigesimo = null;
		
		 if(numeros.size() >= 16 ) {
			DSexto = numeros.get(15);
			}
		
		 if(numeros.size() >= 17) {
			DSetimo = numeros.get(16);}
		
		 if(numeros.size() >= 18) {
			DOitavo = numeros.get(17);}
		
		 if(numeros.size() >= 19) {
			DNono = numeros.get(18);}
		
		if(numeros.size() == 20)	{
			Vigesimo = numeros.get(19);}
		
		Jogo jogo = new Jogo(null, jogoRecebido.getNumeroConcurso(), primeiro, segundo, terceiro, quarto, quinto, sexto, setimo, oitavo, nono, decimo, DPrimeiro, DSegundo,
				DTerceiro, DQuarto, DQuinto, DSexto, DSetimo, DOitavo, DNono, Vigesimo, jogoRecebido.getUsuario());
		
	return jogo;	
		
	}
		

	
	public Jogo inserir(Jogo jogo) {
		return repository.save(jogo);
		}
	
	
	public Long ultimoId() {
		List<Jogo> todosJogos = repository.findAll();
		Long ultimoId = 0L;
		
		for(Jogo jogo: todosJogos) {
			if(jogo.getId() > ultimoId) {
				ultimoId = jogo.getId();
			}
			
		}
		
		return ultimoId;
		
	}
	
	
	public List<Jogo> espelharJogo(Long concursoBase, Long concursoEspelho, Long usuario) {
		
		List<Jogo> jogosBase = buscarPorConcursoEUsuario(concursoBase, usuario);
		List<Jogo> listaEspelho = new ArrayList<>();
		
		Jogo novoJogo = new Jogo();
		
		Long novoId = ultimoId() + 1;				
		
		for(Jogo base: jogosBase) {
			novoJogo.setPrimeiro(base.getPrimeiro()); novoJogo.setSegundo(base.getSegundo()); novoJogo.setTerceiro(base.getTerceiro());
			novoJogo.setQuarto(base.getQuarto()); novoJogo.setQuinto(base.getQuinto()); novoJogo.setSexto(base.getSexto());
			novoJogo.setSetimo(base.getSetimo()); novoJogo.setOitavo(base.getOitavo()); novoJogo.setNono(base.getNono());
			novoJogo.setDecimo(base.getDecimo()); novoJogo.setDPrimeiro(base.getDPrimeiro()); novoJogo.setDSegundo(base.getDSegundo());
			novoJogo.setDTerceiro(base.getDTerceiro()); novoJogo.setDQuarto(base.getDQuarto()); novoJogo.setDQuinto(base.getDQuinto());
			novoJogo.setDSexto(base.getDSexto()); novoJogo.setDSetimo(base.getDSetimo()); novoJogo.setDOitavo(base.getDOitavo());
			novoJogo.setDNono(base.getDNono()); novoJogo.setVigesimo(base.getVigesimo()); novoJogo.setId(novoId); novoJogo.setNumeroConcurso(concursoEspelho);
			novoJogo.setUsuario(base.getUsuario());
			
			
			listaEspelho.add(novoJogo);
			
			novoId ++;
		
		}
				
		return repository.saveAll(listaEspelho);
		
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