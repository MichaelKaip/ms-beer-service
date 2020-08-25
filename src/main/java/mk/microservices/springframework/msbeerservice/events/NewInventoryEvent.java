package mk.microservices.springframework.msbeerservice.events;

import lombok.NoArgsConstructor;
import mk.microservices.springframework.msbeerservice.web.model.BeerDto;

@NoArgsConstructor
public class NewInventoryEvent extends BeerEvent {

    public NewInventoryEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
