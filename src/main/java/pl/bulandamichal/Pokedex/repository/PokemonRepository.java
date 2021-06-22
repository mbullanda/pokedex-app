package pl.bulandamichal.Pokedex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bulandamichal.Pokedex.model.Pokemon;
import pl.bulandamichal.Pokedex.model.PokemonType;

import java.util.List;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

    List<Pokemon> findByType(PokemonType type);
}
