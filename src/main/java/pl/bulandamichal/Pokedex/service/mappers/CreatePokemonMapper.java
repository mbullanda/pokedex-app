package pl.bulandamichal.Pokedex.service.mappers;

import org.springframework.stereotype.Service;
import pl.bulandamichal.Pokedex.model.Pokemon;
import pl.bulandamichal.Pokedex.model.PokemonType;
import pl.bulandamichal.Pokedex.web.rest.dto.CreatePokemonRequest;
import pl.bulandamichal.Pokedex.web.rest.dto.CreatePokemonResponse;

@Service
public class CreatePokemonMapper implements Convertable<CreatePokemonRequest, Pokemon, CreatePokemonResponse> {
    @Override
    public Pokemon fromDto(CreatePokemonRequest input) {
        return Pokemon.builder()
                .name(input.getName())
                .type(PokemonType.fromString(input.getType()))
                .power(input.getPower())
                .build();
    }

    @Override
    public CreatePokemonResponse toDto(Pokemon pokemon) {
        return CreatePokemonResponse.builder()
                .id(pokemon.getId())
                .name(pokemon.getName())
                .type(pokemon.getType().getType())
                .power(pokemon.getPower())
                .build();
    }
}
