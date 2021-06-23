package pl.bulandamichal.Pokedex.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.bulandamichal.Pokedex.model.Pokemon;
import pl.bulandamichal.Pokedex.model.PokemonType;
import pl.bulandamichal.Pokedex.repository.PokemonRepository;
import pl.bulandamichal.Pokedex.service.mappers.GetPokemonMapper;
import pl.bulandamichal.Pokedex.web.rest.dto.GetAllPokemonsResponse;
import pl.bulandamichal.Pokedex.web.rest.dto.GetPokemonResponse;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GetPokemonServiceTest {

    private PokemonRepository pokemonRepository;
    private GetPokemonService getPokemonService;
    private GetPokemonMapper getPokemonMapper;

    @BeforeEach
    void init(){
        pokemonRepository = mock(PokemonRepository.class);
        getPokemonMapper = mock(GetPokemonMapper.class);
        getPokemonService = new GetPokemonService(pokemonRepository,getPokemonMapper);
    }

    @Test
    void testGetPokemonById(){
        //given
        long id = 1L;
        Pokemon pokemon = Pokemon.builder()
                .id(id)
                .name("Pikachu")
                .type(PokemonType.ELECTRIC)
                .power(2)
                .build();

        when(pokemonRepository.findById(id)).thenReturn(Optional.of(pokemon));

        //when
        GetPokemonResponse foundPokemon = getPokemonService.getPokemonById(id);

        //then
        assertThat(foundPokemon).isEqualTo(getPokemonMapper.toDto(pokemon));
    }

    @Test
    void testGetPokemonByName(){
        //given
        long id = 1L;
        String name = "Pikachu";
        Pokemon pokemon = Pokemon.builder()
                .id(id)
                .name(name)
                .type(PokemonType.ELECTRIC)
                .power(2)
                .build();

        when(pokemonRepository.findByName(name)).thenReturn(Optional.of(pokemon));

        //when
        GetPokemonResponse foundPokemon = getPokemonService.getPokemonByName(name);

        //then
        assertThat(foundPokemon).isEqualTo(getPokemonMapper.toDto(pokemon));
    }


}