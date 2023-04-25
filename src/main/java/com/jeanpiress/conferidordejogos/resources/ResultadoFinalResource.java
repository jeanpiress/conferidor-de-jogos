package com.jeanpiress.conferidordejogos.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeanpiress.conferidordejogos.dto.FinaisDTO;
import com.jeanpiress.conferidordejogos.entities.ResultadoFinal;
import com.jeanpiress.conferidordejogos.service.ResultadoFinalService;

@RestController
@RequestMapping(value = "/finais")
public class ResultadoFinalResource {

	@Autowired
	private ResultadoFinalService service;


	@GetMapping(value = "/concurso/{concurso}/usuario/{usuario}")
	public ResponseEntity<List<FinaisDTO>> conferirConcurso(@PathVariable Long concurso, @PathVariable Long usuario){
		List<ResultadoFinal> r = service.conferirConcurso(concurso, usuario);
		List<FinaisDTO> finaisDto = r.stream().map(x -> new FinaisDTO(x)).collect(Collectors.toList());
		
		
		return ResponseEntity.ok().body(finaisDto);
		
	}
	
	
	
		
}
