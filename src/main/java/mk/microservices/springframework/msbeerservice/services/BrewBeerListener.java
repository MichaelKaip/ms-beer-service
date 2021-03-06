package mk.microservices.springframework.msbeerservice.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mk.microservices.springframework.msbeerservice.config.JmsConfig;
import mk.microservices.springframework.msbeerservice.domain.Beer;
import mk.microservices.springframework.msbeerservice.events.BrewBeerEvent;
import mk.microservices.springframework.msbeerservice.events.NewInventoryEvent;
import mk.microservices.springframework.msbeerservice.repositories.BeerRepository;
import mk.microservices.springframework.msbeerservice.web.model.BeerDto;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BrewBeerListener {

    private final BeerRepository beerRepository;
    private final JmsTemplate jmsTemplate;

    @Transactional
    @JmsListener(destination = JmsConfig.BREWING_REQUEST_QUEUE)
    public void listen(BrewBeerEvent event) {
        BeerDto beerDto = event.getBeerDto();

        Beer beer = beerRepository.getOne(beerDto.getId());

        beerDto.setQuantityOnHand(beer.getQuantityToBrew());

        NewInventoryEvent newInventoryEvent = new NewInventoryEvent(beerDto);

        log.debug("Brewed beer" + beer.getMinOnHand() + "| QuantityOnHand: " + beerDto.getQuantityOnHand());

        jmsTemplate.convertAndSend(JmsConfig.NEW_INVENTORY_QUEUE, newInventoryEvent);
    }
}
