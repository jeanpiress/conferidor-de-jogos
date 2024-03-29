package com.jeanpiress.conferidordejogos.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeanpiress.conferidordejogos.entities.Jogo;
import com.jeanpiress.conferidordejogos.entities.Resultado;
import com.jeanpiress.conferidordejogos.entities.ResultadoFinal;
import com.jeanpiress.conferidordejogos.repository.ResultadoFinalRepository;

@Service
public class ResultadoFinalService {
   

	@Autowired
	private ResultadoFinalRepository finalrepository;
	
	@Autowired
	private ResultadoService resultadoService;
	
	@Autowired
	private JogoService jogoService;
	


	public List<ResultadoFinal> buscar(){
		return finalrepository.findAll();
	}
	
	public List<ResultadoFinal> conferirConcurso(Long concurso, Long usuario){
		List<Jogo> jogos = jogoService.buscarPorConcursoEUsuario(concurso, usuario);
		Resultado resultado = resultadoService.buscarPorConsurso(concurso);
		List<Integer> resultadoList = new ArrayList<>();
		resultadoList.addAll(Arrays.asList(resultado.getPrimeiroR(), resultado.getSegundoR(), resultado.getTerceiroR(), resultado.getQuartoR(), resultado.getQuintoR()
				, resultado.getSextoR(), resultado.getSetimoR(), resultado.getOitavoR(), resultado.getNonoR(), resultado.getDecimoR(), resultado.getdPrimeiroR()
				, resultado.getdSegundoR(), resultado.getdTerceiroR(), resultado.getdQuartoR(), resultado.getdQuintoR()));
		
		List<ResultadoFinal> rf = new ArrayList<>();
	
		
				
		for(Jogo acerto: jogos) {
			Integer a1 = resultadoList.stream().filter(x -> x == acerto.getPrimeiro()).findFirst().orElse(null);
			Integer a2 = resultadoList.stream().filter(x -> x == acerto.getSegundo()).findFirst().orElse(null);
			Integer a3 = resultadoList.stream().filter(x -> x == acerto.getTerceiro()).findFirst().orElse(null);
			Integer a4 = resultadoList.stream().filter(x -> x == acerto.getQuarto()).findFirst().orElse(null);
			Integer a5 = resultadoList.stream().filter(x -> x == acerto.getQuinto()).findFirst().orElse(null);
			Integer a6 = resultadoList.stream().filter(x -> x == acerto.getSexto()).findFirst().orElse(null);
			Integer a7 = resultadoList.stream().filter(x -> x == acerto.getSetimo()).findFirst().orElse(null);
			Integer a8 = resultadoList.stream().filter(x -> x == acerto.getOitavo()).findFirst().orElse(null);
			Integer a9 = resultadoList.stream().filter(x -> x == acerto.getNono()).findFirst().orElse(null);
			Integer a10 = resultadoList.stream().filter(x -> x == acerto.getDecimo()).findFirst().orElse(null);
			Integer a11 = resultadoList.stream().filter(x -> x == acerto.getDPrimeiro()).findFirst().orElse(null);
			Integer a12 = resultadoList.stream().filter(x -> x == acerto.getDSegundo()).findFirst().orElse(null);
			Integer a13 = resultadoList.stream().filter(x -> x == acerto.getDTerceiro()).findFirst().orElse(null);
			Integer a14 = resultadoList.stream().filter(x -> x == acerto.getDQuarto()).findFirst().orElse(null);
			Integer a15 = resultadoList.stream().filter(x -> x == acerto.getDQuinto()).findFirst().orElse(null);
			Integer a16 = resultadoList.stream().filter(x -> x == acerto.getDSexto()).findFirst().orElse(null);
			Integer a17 = resultadoList.stream().filter(x -> x == acerto.getDSetimo()).findFirst().orElse(null);
			Integer a18 = resultadoList.stream().filter(x -> x == acerto.getDOitavo()).findFirst().orElse(null);
			Integer a19 = resultadoList.stream().filter(x -> x == acerto.getDNono()).findFirst().orElse(null);
			Integer a20 = resultadoList.stream().filter(x -> x == acerto.getVigesimo()).findFirst().orElse(null);
			
			List<Integer> listTotais = new ArrayList<>();
			listTotais.addAll(Arrays.asList(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20));
			List<Integer> validos = new ArrayList<>();
			validos = listTotais.stream().filter(x -> x != null).collect(Collectors.toList());
			Integer totais = validos.size();
			
					
				
			
			
			rf.add(new ResultadoFinal(null, acerto.getId() , acerto.getNumeroConcurso(), a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15,
					a16, a17, a18, a19, a20, totais, acerto.getUsuario().getId()));  	
		}
		
		
		return rf;
	}
	
}