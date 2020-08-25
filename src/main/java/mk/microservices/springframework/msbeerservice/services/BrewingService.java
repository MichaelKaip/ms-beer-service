package mk.microservices.springframework.msbeerservice.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mk.microservices.springframework.msbeerservice.config.JmsConfig;
import mk.microservices.springframework.msbeerservice.domain.Beer;
import mk.microservices.springframework.msbeerservice.events.BrewBeerEvent;
import mk.microservices.springframework.msbeerservice.repositories.BeerRepository;
import mk.microservices.springframework.msbeerservice.services.inventory.BeerInventoryService;
import mk.microservices.springframework.msbeerservice.web.mappers.BeerMapper;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BrewingService {

    private final BeerRepository beerRepository;
    private final BeerInventoryService beerInventoryService;
    private final JmsTemplate jmsTemplate;
    private final BeerMapper beerMapper;

    @Scheduled(fixedRate = 5000) // every 5 seconds
    public void checkForLowInventory() {
        List<Beer> beerList = beerRepository.findAll();

        beerList.forEach(beer -> {
            Integer invQuantityOnHand = beerInventoryService.getOnHandInventory(beer.getId());

            log.debug("Min. Onhand is: " + beer.getMinOnHand());
            log.debug("Inventory is: " + invQuantityOnHand);

            if (beer.getMinOnHand() >= invQuantityOnHand) {
                jmsTemplate.convertAndSend(JmsConfig.BREWING_REQUEST_QUEUE, new BrewBeerEvent(beerMapper.beerToBeerDto(beer)));
            }
        });
    }
}
