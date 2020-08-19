package mk.microservices.springframework.msbeerservice.services;

import mk.microservices.springframework.msbeerservice.web.model.BeerDto;
import mk.microservices.springframework.msbeerservice.web.model.BeerPagedList;
import mk.microservices.springframework.msbeerservice.web.model.BeerStyleEnum;
import org.springframework.data.domain.PageRequest;

import java.util.UUID;

public interface BeerService {

    BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest, Boolean showInventoryOnHand);

    BeerDto getBeerById(UUID beerId, Boolean showInventoryOnHand);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);
}
