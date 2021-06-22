package pl.bulandamichal.Pokedex.web.rest.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetPokemonsByTypeResponse {
    private List<GetPokemonResponse> pokemons;
}
