package mk.microservices.springframework.msbeerservice.repositories;

import mk.microservices.springframework.msbeerservice.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {
}
