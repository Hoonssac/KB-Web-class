package org.scoula.pokedex.controller;

import java.util.ArrayList;
import java.util.List;

import org.scoula.pokedex.dto.PokemonListResponse;
import org.scoula.pokedex.dto.PokemonListResult;
import org.scoula.pokedex.dto.PokemonDTO;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Value;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/pokemon")
@PropertySource("classpath:/application.properties")
@Api(tags = "포켓몬 도감 API")
public class PokedexController {

	@Value("${pokedex.url}")
	private String apiUrl;

	private final RestTemplate restTemplate = new RestTemplate();

	@ApiOperation(value = "포켓몬 목록", notes = "포켓몬 목록 상세 조회")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "성공적으로 요청이 처리되었습니다.", response = PokemonDTO.class),
	    @ApiResponse(code = 400, message = "잘못된 요청입니다."),
	    @ApiResponse(code = 500, message = "서버에서 오류가 발생했습니다.")
	})
	@GetMapping("/list")
	public List<PokemonDTO> getPokemonList() {
		// 1단계: 포켓몬 이름과 URL 목록을 먼저 요청
		String listUrl = UriComponentsBuilder
			.fromHttpUrl(apiUrl + "/pokemon")
			.queryParam("limit", 20)
			.queryParam("offset", 0)
			.toUriString();

		PokemonListResponse response = restTemplate.getForObject(listUrl, PokemonListResponse.class);

		// 2단계: 각 포켓몬의 상세 정보를 URL로 요청하여 리스트 구성
		List<PokemonDTO> detailedList = new ArrayList<>();
		for (PokemonListResult item : response.getResults()) {
			PokemonDTO pokemon = restTemplate.getForObject(item.getUrl(), PokemonDTO.class);
			detailedList.add(pokemon);
		}

		return detailedList;
	}

	@ApiOperation(value = "포켓몬 목록", notes = "포켓몬 상세 정보 조회")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "성공적으로 요청이 처리되었습니다.", response = PokemonDTO.class),
		@ApiResponse(code = 400, message = "잘못된 요청입니다."),
		@ApiResponse(code = 500, message = "서버에서 오류가 발생했습니다.")
	})
	@GetMapping("/{name}")
	public ResponseEntity<?> getPokemonDetail(@PathVariable String name) {
		String url = UriComponentsBuilder
			.fromHttpUrl(apiUrl + "/pokemon/" + name)
			.toUriString();

		try {
			PokemonDTO pokemon = restTemplate.getForObject(url, PokemonDTO.class);
			return ResponseEntity.ok(pokemon);
		} catch (HttpClientErrorException.NotFound e) {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.valueOf("text/plain; charset=UTF-8"));
			return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.headers(headers)
				.body("해당 포켓몬을 찾을 수 없습니다");
		}
	}
}