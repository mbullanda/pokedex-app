package pl.bulandamichal.Pokedex.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bulandamichal.Pokedex.exceptions.MissingPokemonByIdException;
import pl.bulandamichal.Pokedex.repository.PokemonRepository;

@Service
@AllArgsConstructor
public class DeletePokemonService {

    private final PokemonRepository pokemonRepository;

    public void deletePokemonById(Long id){
        if (!pokemonRepository.existsById(id)){
            throw new MissingPokemonByIdException(id);
        }
        pokemonRepository.deleteById(id);
    }
}
