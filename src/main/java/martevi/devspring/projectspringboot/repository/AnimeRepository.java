package martevi.devspring.projectspringboot.repository;

import martevi.devspring.projectspringboot.domain.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimeRepository extends JpaRepository <Anime, Long>{
    List<Anime> findByName(String name);
}
