package pl.bulandamichal.Pokedex.service.mappers;

public interface Convertable <DOT_INPUT_TYPE, ENTITY, DTO_OUTPUT_TYPE>{

    ENTITY fromDto(DOT_INPUT_TYPE input);

    DTO_OUTPUT_TYPE toDto(ENTITY entity);
}
