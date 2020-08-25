package mk.microservices.springframework.msbeerservice.events;


import mk.microservices.springframework.msbeerservice.web.model.BeerDto;

public class BrewBeerEvent extends BeerEvent {

    public BrewBeerEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
