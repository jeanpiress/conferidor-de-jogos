package com.jeanpiress.conferidordejogos.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.jeanpiress.conferidordejogos.dto.Constancia;
import com.jeanpiress.conferidordejogos.dto.ResultadoRecebidoDTO;
import com.jeanpiress.conferidordejogos.dto.ResultadosDTO;
import com.jeanpiress.conferidordejogos.entities.Resultado;
import com.jeanpiress.conferidordejogos.entities.ResultadoApi;
import com.jeanpiress.conferidordejogos.repository.ResultadoRepository;

@Service
public class ResultadoService {

	@Autowired
	private ResultadoRepository repository;

	String apiURL = "https://apiloterias.com.br/app/resultado";
	String loteria = "lotofacil";
	Long concurso;

	@Value("${TOKEN_API}")
	public String token;

	

	public List<Resultado> buscar() {
		return repository.findAll();
	}

	public Resultado buscarPorId(Long id) {
		Optional<Resultado> obj = repository.findById(id);
		return obj.get();
	}

	public Resultado buscarPorConsurso(Long concurso) {
		Resultado obj = repository.findByNumeroConcurso(concurso);
		if (obj == null) {
			throw new EntityNotFoundException();
		}
		return obj;
	}

	public Long ultimoConcurso() {
		List<Resultado> r = repository.findAll();
		List<ResultadosDTO> listDto = r.stream().map(x -> new ResultadosDTO(x)).collect(Collectors.toList());

		Long ultimo = 0L;

		for (ResultadosDTO m : listDto) {
			if (m.getNumeroConcurso() > ultimo) {
				ultimo = m.getNumeroConcurso();
			}

		}

		return ultimo;
	}

	public Resultado inserirPorAPI() throws Exception {

		// determinal qual concurso deve ser chamado
		concurso = ultimoConcurso() + 1;

		// capturar json da api
		String requestURL = apiURL + "?loteria=" + loteria + "&token=" + token + "&concurso=" + concurso;
		URL url = new URL(requestURL);
		URLConnection connection = url.openConnection();
		InputStream is = connection.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		String api;
		StringBuilder resultadoJson = new StringBuilder();
		while ((api = br.readLine()) != null) {
			resultadoJson.append(api);
		}

		// transformar json recebido em ResultadoApi.class
		ResultadoApi resultadoApi = new Gson().fromJson(resultadoJson.toString(), ResultadoApi.class);

		Resultado resultado = converterResultadoApi(resultadoApi);

		return repository.save(resultado);
	}

	public Resultado converterResultadoApi(ResultadoApi api) {
		Resultado resultado = new Resultado();
		List<String> dezenas = api.getDezenas();

		resultado.setNumeroConcurso(api.getNumero_concurso());
		resultado.setPrimeiroR(Integer.parseInt(dezenas.get(0)));
		resultado.setSegundoR(Integer.parseInt(dezenas.get(1)));
		resultado.setTerceiroR(Integer.parseInt(dezenas.get(2)));
		resultado.setQuartoR(Integer.parseInt(dezenas.get(3)));
		resultado.setQuintoR(Integer.parseInt(dezenas.get(4)));
		resultado.setSextoR(Integer.parseInt(dezenas.get(5)));
		resultado.setSetimoR(Integer.parseInt(dezenas.get(6)));
		resultado.setOitavoR(Integer.parseInt(dezenas.get(7)));
		resultado.setNonoR(Integer.parseInt(dezenas.get(8)));
		resultado.setDecimoR(Integer.parseInt(dezenas.get(9)));
		resultado.setdPrimeiroR(Integer.parseInt(dezenas.get(10)));
		resultado.setdSegundoR(Integer.parseInt(dezenas.get(11)));
		resultado.setdTerceiroR(Integer.parseInt(dezenas.get(12)));
		resultado.setdQuartoR(Integer.parseInt(dezenas.get(13)));
		resultado.setdQuintoR(Integer.parseInt(dezenas.get(14)));

		return resultado;
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

		for (String x : list) {
			Integer a = Integer.parseInt(x);
			numeros.add(a);
		}

		Integer primeiro = numeros.get(0);
		Integer segundo = numeros.get(1);
		Integer terceiro = numeros.get(2);
		Integer quarto = numeros.get(3);
		Integer quinto = numeros.get(4);
		Integer sexto = numeros.get(5);
		Integer setimo = numeros.get(6);
		Integer oitavo = numeros.get(7);
		Integer nono = numeros.get(8);
		Integer decimo = numeros.get(9);
		Integer DPrimeiro = numeros.get(10);
		Integer DSegundo = numeros.get(11);
		Integer DTerceiro = numeros.get(12);
		Integer DQuarto = numeros.get(13);
		Integer DQuinto = numeros.get(14);

		Resultado resultado = new Resultado(null, resultadoRecebido.getNumeroConcurso(), primeiro, segundo, terceiro,
				quarto, quinto, sexto, setimo, oitavo, nono, decimo, DPrimeiro, DSegundo, DTerceiro, DQuarto, DQuinto);

		return resultado;

	}

	public List<ResultadosDTO> ultimosResultados() {
		List<Resultado> r = repository.findAll();
		List<ResultadosDTO> listDto = r.stream().map(x -> new ResultadosDTO(x)).collect(Collectors.toList());

		Long ultimo = 0L;

		for (ResultadosDTO m : listDto) {
			if (m.getNumeroConcurso() > ultimo) {
				ultimo = m.getNumeroConcurso();
			}

		}

		Resultado resultado = repository.findByNumeroConcurso(ultimo);
		Resultado resultado2 = repository.findByNumeroConcurso(ultimo - 1);
		Resultado resultado3 = repository.findByNumeroConcurso(ultimo - 2);
		Resultado resultado4 = repository.findByNumeroConcurso(ultimo - 3);

		ResultadosDTO menu = new ResultadosDTO(resultado);
		ResultadosDTO menu2 = new ResultadosDTO(resultado2);
		ResultadosDTO menu3 = new ResultadosDTO(resultado3);
		ResultadosDTO menu4 = new ResultadosDTO(resultado4);

		List<ResultadosDTO> menuList = new ArrayList<>();

		menuList.addAll(Arrays.asList(menu, menu2, menu3, menu4));

		return menuList;
	}

	public Constancia constancia() throws Exception {
		// inseriri novo concurso caso exita
		inserirPorAPI();

		// verificar quais numeros apareceram e os que não apareceram nos ultimos 4
		// concursos
		List<ResultadosDTO> listResultados = ultimosResultados();

		Constancia menuDto = new Constancia();

		List<Integer> possiveis = IntStream.rangeClosed(1, 25).boxed().collect(Collectors.toList());
		List<Integer> repetido = new ArrayList<>();
		List<Integer> naoRepete = new ArrayList<>();

		ResultadosDTO resultado = listResultados.get(0);
		ResultadosDTO resultado2 = listResultados.get(1);
		ResultadosDTO resultado3 = listResultados.get(2);
		ResultadosDTO resultado4 = listResultados.get(3);

		for (Integer p : possiveis) {
			if (resultado.getList().contains(p) && resultado2.getList().contains(p) && resultado3.getList().contains(p)
					&& resultado4.getList().contains(p)) {

				repetido.add(p);
			}

			if (resultado.getList().contains(p) == false && resultado2.getList().contains(p) == false
					&& resultado3.getList().contains(p) == false && resultado4.getList().contains(p) == false) {

				naoRepete.add(p);
			}
		}

		menuDto.setNumerosNaoRepetidos(naoRepete);
		menuDto.setNumerosRepetidos(repetido);

		return menuDto;
	}

	public List<ResultadosDTO> ordenarListaResultado(List<ResultadosDTO> resultados) {
		List<Integer> listaOrdenada = new ArrayList<>();
		for (ResultadosDTO r : resultados) {
			listaOrdenada = r.getList().stream().sorted().collect(Collectors.toList());
			r.setList(listaOrdenada);
		}
		return resultados;

	}

}