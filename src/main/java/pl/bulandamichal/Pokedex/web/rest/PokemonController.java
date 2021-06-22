package pl.bulandamichal.Pokedex.web.rest;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.bulandamichal.Pokedex.service.CreatePokemonService;
import pl.bulandamichal.Pokedex.service.GetPokemonService;
import pl.bulandamichal.Pokedex.service.UpdatePokemonService;
import pl.bulandamichal.Pokedex.web.rest.dto.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/pokemons")
@AllArgsConstructor
@Transactional
public class PokemonController {

    private final CreatePokemonService createPokemonService;
    private final GetPokemonService getPokemonService;
    private final UpdatePokemonService updatePokemonService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatePokemonResponse createPokemon(@RequestBody @Valid CreatePokemonRequest request){
        return createPokemonService.createPokemon(request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetPokemonResponse getPokemonById(@PathVariable Long id){
        return getPokemonService.getPokemonById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public GetAllPokemonsResponse getAllPokemons(){
        return getPokemonService.getAllPokemons();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UpdatePokemonResponse updatePokemon(@PathVariable Long id, @RequestBody @Valid UpdatePokemonRequest request){
        return updatePokemonService.updatePokemon(id, request);
    }
}
