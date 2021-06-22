package pl.bulandamichal.Pokedex.service.mappers;

import org.springframework.stereotype.Service;
import pl.bulandamichal.Pokedex.model.Pokemon;
import pl.bulandamichal.Pokedex.web.rest.dto.GetPokemonResponse;

@Service
public class GetPokemonMapper implements Convertable<Void, Pokemon, GetPokemonResponse> {
    @Override
    public Pokemon fromDto(Void input) {
        throw new UnsupportedOperationException("Unsupported operation");
    }

    @Override
    public GetPokemonResponse toDto(Pokemon pokemon) {
        return GetPokemonResponse.builder()
                .id(pokemon.getId())
                .name(pokemon.getName())
                .type(pokemon.getType().getType())
                .power(pokemon.getPower())
                .build();
    }
}
