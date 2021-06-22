package pl.bulandamichal.Pokedex.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bulandamichal.Pokedex.model.Pokemon;
import pl.bulandamichal.Pokedex.repository.PokemonRepository;
import pl.bulandamichal.Pokedex.service.mappers.CreatePokemonMapper;
import pl.bulandamichal.Pokedex.web.rest.dto.CreatePokemonRequest;
import pl.bulandamichal.Pokedex.web.rest.dto.CreatePokemonResponse;

@Service
@AllArgsConstructor
public class CreatePokemonService {

    private final PokemonRepository pokemonRepository;
    private final CreatePokemonMapper createPokemonMapper;


    public CreatePokemonResponse createPokemon(CreatePokemonRequest request) {
        Pokemon pokemonToCreate = createPokemonMapper.fromDto(request);
        return createPokemonMapper.toDto(pokemonRepository.save(pokemonToCreate));
    }
}
