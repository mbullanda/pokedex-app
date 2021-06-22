package pl.bulandamichal.Pokedex.service.mappers;

import org.springframework.stereotype.Service;
import pl.bulandamichal.Pokedex.model.Pokemon;
import pl.bulandamichal.Pokedex.model.PokemonType;
import pl.bulandamichal.Pokedex.web.rest.dto.UpdatePokemonRequest;
import pl.bulandamichal.Pokedex.web.rest.dto.UpdatePokemonResponse;

@Service
public class UpdatePokemonMapper implements Convertable<UpdatePokemonRequest, Pokemon, UpdatePokemonResponse> {
    @Override
    public Pokemon fromDto(UpdatePokemonRequest input) {
        return Pokemon.builder()
                .name(input.getName())
                .type(PokemonType.fromString(input.getType()))
                .power(input.getPower())
                .build();
    }

    @Override
    public UpdatePokemonResponse toDto(Pokemon pokemon) {
        return UpdatePokemonResponse.builder()
                .id(pokemon.getId())
                .name(pokemon.getName())
                .type(pokemon.getType().getType())
                .power(pokemon.getPower())
                .build();
    }
}
