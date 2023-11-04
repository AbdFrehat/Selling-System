package com.sales.receipt.generator.client;

import com.sales.receipt.generator.client.CalcPriceClient;
import com.sales.receipt.generator.models.entities.Item;
import com.sales.receipt.generator.models.responses.CalcPriceResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class CalcPriceClientImpl implements CalcPriceClient {

    private final WebClient webClient;

    public CalcPriceClientImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://CALC-PRICE-MS/selling/reports/calc/price/v1/").build();
    }

    @Override
    public Mono<CalcPriceResponse> retrieveCalcPrice(List<Item> items) {
        return webClient
                .post()
                .contentType(MediaType.APPLICATION_JSON)
                .body(Flux.fromIterable(items), Item.class)
                .retrieve()
                .bodyToMono(CalcPriceResponse.class);
    }
}
