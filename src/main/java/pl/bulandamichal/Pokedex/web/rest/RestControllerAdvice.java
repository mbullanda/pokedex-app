package pl.bulandamichal.Pokedex.web.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.bulandamichal.Pokedex.exceptions.MissingPokemonByIdException;
import pl.bulandamichal.Pokedex.exceptions.MissingPokemonByNameException;
import pl.bulandamichal.Pokedex.exceptions.PokemonAlreadyExistsException;

@ControllerAdvice
public class RestControllerAdvice {

    @ExceptionHandler({MissingPokemonByIdException.class, MissingPokemonByNameException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String missingPokemon(RuntimeException exc){
        return exc.getMessage();
    }

    @ExceptionHandler({PokemonAlreadyExistsException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String pokemonAlreadyExists(RuntimeException exc){
        return exc.getMessage();
    }

}
