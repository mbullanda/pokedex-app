package pl.bulandamichal.Pokedex.web.rest.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdatePokemonResponse {
    private long id;
    private String name;
    private String type;
    private int power;
}
