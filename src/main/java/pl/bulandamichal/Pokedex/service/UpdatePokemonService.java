package pl.bulandamichal.Pokedex.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bulandamichal.Pokedex.model.Pokemon;
import pl.bulandamichal.Pokedex.model.PokemonType;
import pl.bulandamichal.Pokedex.repository.PokemonRepository;
import pl.bulandamichal.Pokedex.service.mappers.UpdatePokemonMapper;
import pl.bulandamichal.Pokedex.web.rest.dto.UpdatePokemonRequest;
import pl.bulandamichal.Pokedex.web.rest.dto.UpdatePokemonResponse;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class UpdatePokemonService {

    private final PokemonRepository pokemonRepository;
    private final UpdatePokemonMapper updatePokemonMapper;

    public UpdatePokemonResponse updatePokemon(Long id, UpdatePokemonRequest request){
        Pokemon pokemonToUpdate = pokemonRepository.findById(id).orElseThrow(NoSuchElementException::new);
        pokemonToUpdate.setName(request.getName());
        pokemonToUpdate.setType(PokemonType.fromString(request.getType()));
        pokemonToUpdate.setPower(request.getPower());
        return updatePokemonMapper.toDto(pokemonToUpdate);
    }
}
