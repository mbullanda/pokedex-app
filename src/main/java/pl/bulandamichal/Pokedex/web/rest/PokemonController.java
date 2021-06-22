package pl.bulandamichal.Pokedex.web.rest;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.bulandamichal.Pokedex.service.CreatePokemonService;
import pl.bulandamichal.Pokedex.web.rest.dto.CreatePokemonRequest;
import pl.bulandamichal.Pokedex.web.rest.dto.CreatePokemonResponse;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/pokemons")
@AllArgsConstructor
@Transactional
public class PokemonController {

    private final CreatePokemonService createPokemonService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatePokemonResponse createPokemon(@RequestBody @Valid CreatePokemonRequest request){
        return createPokemonService.createPokemon(request);
    }
}
