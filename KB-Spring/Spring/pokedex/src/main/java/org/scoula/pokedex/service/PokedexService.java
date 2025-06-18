package org.scoula.pokedex.service;

import java.util.ArrayList;
import java.util.List;

import org.scoula.pokedex.dto.PokemonDTO;
import org.scoula.pokedex.dto.PokemonListResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
//
// @Service
// @RequiredArgsConstructor
// public class PokedexService {
//
// 	public List<PokemonDTO> getTop20Pokemons() {
// 		String url = "https://pokeapi.co/api/v2/pokemon?limit=20";
// 		RestTemplate restTemplate = new RestTemplate();
// 		PokemonListResponse response = restTemplate.getForObject(url, PokemonListResponse.class);
//
// 		List<PokemonDTO> result = new ArrayList<>();
// 		for (PokemonListResponse.PokemonEntry entry : response.getResults()) {
// 			PokemonDTO pokemon = restTemplate.getForObject(entry.getUrl(), PokemonDTO.class);
// 			result.add(pokemon);
// 		}
//
// 		return result;
// 	}
// }
