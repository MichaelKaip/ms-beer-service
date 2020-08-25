package mk.microservices.springframework.msbeerservice.events;

import mk.microservices.springframework.msbeerservice.web.model.BeerDto;

public class NewInventoryEvent extends BeerEvent {

    public NewInventoryEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
