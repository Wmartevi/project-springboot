package martevi.devspring.projectspringboot.service;

import lombok.RequiredArgsConstructor;
import martevi.devspring.projectspringboot.domain.Anime;
import martevi.devspring.projectspringboot.exception.BadRequestException;
import martevi.devspring.projectspringboot.mapper.AnimeMapper;
import martevi.devspring.projectspringboot.repository.AnimeRepository;
import martevi.devspring.projectspringboot.resquests.AnimePostRequestBody;
import martevi.devspring.projectspringboot.resquests.AnimePutRequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimeService {

    private final AnimeRepository animeRepository;

    public List<Anime> ListAll(){
        return animeRepository.findAll();

    }

    public List<Anime> findByName(String name){
        return animeRepository.findByName(name);

    }

    public Anime findByIdOrThrowBadRequestException(long id){
        return animeRepository.findById(id)
               .orElseThrow(() -> new BadRequestException("Anime not Found"));
    }

    public Anime save(AnimePostRequestBody animePostRequestBody) {
        //return animeRepository.save(Anime.builder().name(animePostRequestBody.getName()).build());
        return animeRepository.save(AnimeMapper.INSTANCE.toAnime(animePostRequestBody));
    }

    public void delete(long id) {
       animeRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(AnimePutRequestBody animePutRequestBody) {
        Anime savedAnime =  findByIdOrThrowBadRequestException(animePutRequestBody.getId());
        Anime anime = AnimeMapper.INSTANCE.toAnime(animePutRequestBody);
        anime.setId(savedAnime.getId());
        /*Anime anime = Anime.builder()
                .id(savedAnime.getId())
                .name(animePutRequestBody.getName())
                .build();*/
        animeRepository.save(anime);
    }
}
