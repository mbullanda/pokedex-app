package pl.bulandamichal.Pokedex.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bulandamichal.Pokedex.repository.PokemonRepository;

@Service
@AllArgsConstructor
public class CreatePokemonService {

    private final PokemonRepository pokemonRepository;


}
