package martevi.devspring.projectspringboot.mapper;

import martevi.devspring.projectspringboot.domain.Anime;
import martevi.devspring.projectspringboot.resquests.AnimePostRequestBody;
import martevi.devspring.projectspringboot.resquests.AnimePutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class AnimeMapper {
    public static final AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);

    public abstract Anime toAnime(AnimePostRequestBody animePostRequestBody);

    public abstract Anime toAnime(AnimePutRequestBody animePutRequestBody);
}
