package pl.bulandamichal.Pokedex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bulandamichal.Pokedex.model.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
}
