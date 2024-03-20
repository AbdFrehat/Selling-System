package com.orderizer.data.orders.manager.handlers.delete;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class DataDeleteMultiHandler implements HandlerFunction<ServerResponse> {
    @NotNull
    @Override
    public Mono<ServerResponse> handle(@NotNull ServerRequest request) {
        return ServerResponse.ok().bodyValue("DataDeleteMultiHandler");
    }
}