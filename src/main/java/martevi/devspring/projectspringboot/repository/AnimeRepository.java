package martevi.devspring.projectspringboot.repository;

import martevi.devspring.projectspringboot.domain.Anime;

import java.util.List;

public interface AnimeRepository {
    List<Anime> listAll();
}
