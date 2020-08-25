package mk.microservices.springframework.msbeerservice.events;

import lombok.*;
import mk.microservices.springframework.msbeerservice.web.model.BeerDto;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class BeerEvent implements Serializable {

    static final long serialVersionUID = -3212918175434350487L;

    private BeerDto beerDto;
}
