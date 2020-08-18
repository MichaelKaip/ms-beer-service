package mk.microservices.springframework.msbeerservice.web.mappers;

import mk.microservices.springframework.msbeerservice.domain.Beer;
import mk.microservices.springframework.msbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto BeerToBeerDto(Beer beer);

    Beer BeerDtoToBeer(BeerDto dto);
}