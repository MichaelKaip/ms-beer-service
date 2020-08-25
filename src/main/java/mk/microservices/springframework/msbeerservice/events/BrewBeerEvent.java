package mk.microservices.springframework.msbeerservice.events;


import lombok.NoArgsConstructor;
import mk.microservices.springframework.msbeerservice.web.model.BeerDto;

@NoArgsConstructor
public class BrewBeerEvent extends BeerEvent {

    public BrewBeerEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
