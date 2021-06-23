package pl.bulandamichal.Pokedex.exceptions;

public class PokemonAlreadyExistsException extends RuntimeException{

    public PokemonAlreadyExistsException(String name){
        super("Pokemon with name " + name + "already exists!");
    }
}
