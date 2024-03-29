package com.orderizer.data.delete.orders.manager.handler;

import com.orderizer.data.delete.orders.manager.config.LocalAppConfig;
import com.orderizer.data.delete.orders.manager.model.request.DeleteOrdersSearchRequest;
import com.orderizer.data.delete.orders.manager.validator.api.Validator;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class DeleteOrdersSearchHandler implements HandlerFunction<ServerResponse> {

    private final WebClient webClient;

    private final Validator<DeleteOrdersSearchRequest> validator;

    public DeleteOrdersSearchHandler(LocalAppConfig localAppConfig, WebClient.Builder webClient, Validator<DeleteOrdersSearchRequest> validator) {
        this.validator = validator;
        this.webClient = webClient.baseUrl(localAppConfig.getServices().getContextPath().getDataDeleteSearchOrders()).build();
    }

    @NotNull
    @Override
    public Mono<ServerResponse> handle(@NotNull ServerRequest request) {
        return request.bodyToMono(DeleteOrdersSearchRequest.class)
                .flatMap(validator::validate)
                .flatMap(deleteOrdersSearchRequest -> webClient.post()
                        .bodyValue(deleteOrdersSearchRequest)
                        .retrieve()
                        .toBodilessEntity()
                        .then(ServerResponse.noContent().build()));
    }
}
