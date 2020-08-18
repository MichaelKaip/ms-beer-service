package mk.microservices.springframework.msbeerservice.services.inventory;

import mk.microservices.springframework.msbeerservice.bootstrap.BeerLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Disabled // utility for manual testing
@SpringBootTest
class BeerInventoryServiceImplTest {

    @Autowired
    BeerInventoryService beerInventoryService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getOnHandInventory() {
        Integer quantityOnHand = beerInventoryService.getOnHandInventory(BeerLoader.BEER_1_UUID);

        System.out.println(quantityOnHand);
    }

}