package pl.bulandamichal.Pokedex.exceptions;

public class MissingPokemonByIdException extends RuntimeException{

    public MissingPokemonByIdException(Long id){
        super("Pokemon with id " + id + " missing!");
    }
}
