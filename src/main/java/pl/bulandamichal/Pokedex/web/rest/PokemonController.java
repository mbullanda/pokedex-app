package pl.bulandamichal.Pokedex.web.rest;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.bulandamichal.Pokedex.service.CreatePokemonService;
import pl.bulandamichal.Pokedex.service.DeletePokemonService;
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
    private final DeletePokemonService deletePokemonService;

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

    @GetMapping(params = {"!page", "!size"})
    @ResponseStatus(HttpStatus.OK)
    public GetAllPokemonsResponse getAllPokemons(){
        return getPokemonService.getAllPokemons();
    }

    @GetMapping("/type/{type}")
    @ResponseStatus(HttpStatus.OK)
    public GetPokemonsByTypeResponse getPokemonsByType(@PathVariable String type){
        return getPokemonService.getPokemonsByType(type);
    }

    @GetMapping("/pokemon/{name}")
    @ResponseStatus(HttpStatus.OK)
    public GetPokemonResponse getPokemonByName(@PathVariable String name){
        return getPokemonService.getPokemonByName(name);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public GetAllPokemonsResponse getAllPokemons(Pageable page){
        return getPokemonService.getAllPokemons(page);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UpdatePokemonResponse updatePokemon(@PathVariable Long id, @RequestBody @Valid UpdatePokemonRequest request){
        return updatePokemonService.updatePokemon(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePokemonById(@PathVariable Long id){
        deletePokemonService.deletePokemonById(id);
    }
}
