package pl.bulandamichal.Pokedex.exceptions;

public class MissingPokemonByNameException extends RuntimeException{

    public MissingPokemonByNameException(String name){
        super("Pokemon with name " + name + " missing!");
    }
}
