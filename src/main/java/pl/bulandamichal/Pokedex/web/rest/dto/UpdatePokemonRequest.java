package pl.bulandamichal.Pokedex.web.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePokemonRequest {

    @NotBlank(message = "Name cannot be blank")
    private String name;
    @NotBlank(message = "Type cannot be blank")
    private String type;
    @Min(message = "Power must be greater than 0", value = 1)
    private int power;
}
