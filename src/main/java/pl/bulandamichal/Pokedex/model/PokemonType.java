package pl.bulandamichal.Pokedex.model;

public enum PokemonType {

    NORMAL("normal"),
    WATER("water"),
    FIRE("fire"),
    ELECTRIC("electric"),
    ROCK("rock"),
    FLYING("flying");

    private final String type;

    PokemonType(String type) {
        this.type = type;
    }

    public static PokemonType fromString(String source){
        for (PokemonType type: PokemonType.values()){
            if (type.name().equals(source) || type.type.equalsIgnoreCase(source)){
                return type;
            }
        }
        throw new IllegalArgumentException();
    }

    public String getType() {
        return type;
    }
}
