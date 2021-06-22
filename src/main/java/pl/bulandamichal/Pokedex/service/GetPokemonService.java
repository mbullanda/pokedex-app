package pl.bulandamichal.Pokedex.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bulandamichal.Pokedex.model.PokemonType;
import pl.bulandamichal.Pokedex.repository.PokemonRepository;
import pl.bulandamichal.Pokedex.service.mappers.GetPokemonMapper;
import pl.bulandamichal.Pokedex.web.rest.dto.GetAllPokemonsResponse;
import pl.bulandamichal.Pokedex.web.rest.dto.GetPokemonResponse;
import pl.bulandamichal.Pokedex.web.rest.dto.GetPokemonsByTypeResponse;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GetPokemonService {

    private final PokemonRepository pokemonRepository;
    private final GetPokemonMapper getPokemonMapper;

    public GetPokemonResponse getPokemonById(Long id){
        return getPokemonMapper.toDto(pokemonRepository.findById(id).orElseThrow(NoSuchElementException::new));
    }

    public GetAllPokemonsResponse getAllPokemons(){
        return GetAllPokemonsResponse.builder()
                .pokemons(pokemonRepository.findAll().stream()
                        .map(getPokemonMapper::toDto)
                        .collect(Collectors.toList())
                )
                .build();
    }

    public GetPokemonsByTypeResponse getPokemonsByType(String type){
        return GetPokemonsByTypeResponse.builder()
                .pokemons(pokemonRepository.findByType(PokemonType.fromString(type)).stream()
                        .map(getPokemonMapper::toDto)
                        .collect(Collectors.toList())
                )
                .build();
    }
}
