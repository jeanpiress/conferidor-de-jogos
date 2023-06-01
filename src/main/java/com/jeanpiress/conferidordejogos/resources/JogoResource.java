package com.jeanpiress.conferidordejogos.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jeanpiress.conferidordejogos.dto.JogoDTO;
import com.jeanpiress.conferidordejogos.dto.JogoRecebidoDTO;
import com.jeanpiress.conferidordejogos.entities.Jogo;
import com.jeanpiress.conferidordejogos.service.JogoService;

@RestController
@RequestMapping(value = "/jogos")
public class JogoResource {

	@Autowired
	private JogoService service;

	
	
	@GetMapping
	public ResponseEntity<List<JogoDTO>> buscar(){
		List<Jogo> u = service.buscar();
		List<JogoDTO> listDto = u.stream().map(x -> new JogoDTO(x)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto);
		
	}
	
	
	@GetMapping(value = "/id/{id}")
	public ResponseEntity<Jogo> buscarPorId(@PathVariable Long id){
			Jogo u = service.buscarPorId(id);
		return ResponseEntity.ok().body(u);
		
	}
	
	@GetMapping(value = "/concurso/{concurso}")
	public ResponseEntity<List<JogoDTO>> buscarPorConcurso(@PathVariable Long concurso){
			List<Jogo> jogos = service.buscarPorConcurso(concurso);
			List<JogoDTO> listDto = jogos.stream().map(x -> new JogoDTO(x)).collect(Collectors.toList());
			return ResponseEntity.ok().body(listDto);
		
	} 
	
	@GetMapping(value = "/concurso/{concurso}/usuario/{usuario}")
	public ResponseEntity<List<JogoDTO>> buscarPorConcursoEUsuario(@PathVariable Long concurso, @PathVariable Long usuario){
			List<Jogo> jogos = service.buscarPorConcursoEUsuario(concurso, usuario);
			List<JogoDTO> listDto = jogos.stream().map(x -> new JogoDTO(x)).collect(Collectors.toList());
			List<Integer> numerosOrdenados = new ArrayList<>();
			for(JogoDTO jogosDto: listDto) {
				numerosOrdenados = jogosDto.getList();
				numerosOrdenados = numerosOrdenados.stream().sorted()
		                .collect(Collectors.toList());
				jogosDto.setList(numerosOrdenados);
			}
			
			return ResponseEntity.ok().body(listDto);
		
	} 
	

	@PostMapping
	public ResponseEntity<Jogo> inserir(@Valid @RequestBody JogoRecebidoDTO jogoRecebido){
		Jogo r = service.converter(jogoRecebido);
		Jogo j = service.inserir(r);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(j.getId()).toUri();
		return ResponseEntity.created(uri).body(j);
	}
	
	@PostMapping(value = "/base/{concursoBase}/espelho/{concursoEspelho}/usuario/{usuario}")
	public ResponseEntity<List<Jogo>> inserirEspelho(@PathVariable Long concursoBase, @PathVariable Long concursoEspelho, @PathVariable Long usuario){
		List<Jogo> espelho = service.espelharJogo(concursoBase, concursoEspelho, usuario);
		
		return ResponseEntity.ok().body(espelho);
	}
	
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		service.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Jogo> atualizar(@PathVariable Long id, @RequestBody Jogo jogo){
		Jogo jogo2 = service.atualizar(id, jogo);
		return ResponseEntity.ok().body(jogo2);
	}
		
}
