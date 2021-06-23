package pl.bulandamichal.Pokedex.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.bulandamichal.Pokedex.model.Pokemon;
import pl.bulandamichal.Pokedex.model.PokemonType;

import java.util.List;
import java.util.Optional;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

    List<Pokemon> findByType(PokemonType type);

    @Override
    Page<Pokemon> findAll(Pageable page);

    Optional<Pokemon> findByName(String name);
}
