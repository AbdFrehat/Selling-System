package com.orderizer.data.orders.manager.client;

import com.orderizer.data.orders.manager.config.LocalAppConfig;
import com.selling.system.shared.module.handlers.ClientExceptionHandler;
import com.selling.system.shared.module.models.commands.DataCommand;
import com.selling.system.shared.module.models.enums.CommandType;
import com.selling.system.shared.module.models.responses.DataResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * This service class implements {@link SalesClientService} which the main goal for it to pass the query command based on the
 * query method to the right service.
 *
 * @author Abd Frehat
 * @since 1.0
 */
@Service
@Slf4j
public class SalesClientServiceImpl implements SalesClientService {


    private final WebClient webClient;

    private final LocalAppConfig localAppConfig;

    public SalesClientServiceImpl(WebClient webClient, LocalAppConfig localAppConfig) {
        this.webClient = webClient;
        this.localAppConfig = localAppConfig;
    }

    /**
     * This method takes the request object, build the web client and select the uri based on the queryMethod inside {@link DataCommand}
     *
     * @param dataCommand represents the request object to be sent to the data microservices
     * @return {@link Mono}<{@link DataResponse}> which represents the retrieved data from the query services.
     */
    @Override
    public Mono<DataResponse> sendRequest(DataCommand dataCommand) {
        return webClient
                .post()
                .uri(getUri(dataCommand.getCommandType()))
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(dataCommand)
                .retrieve()
                .onStatus(HttpStatusCode::isError, new ClientExceptionHandler(dataCommand.getCommandType().name()))
                .bodyToMono(DataResponse.class);
    }

    private String getUri(CommandType commandType) {
        return switch (commandType) {
            case GET_SALES, GET_FREE_SALES, GET_OPT_SALES -> localAppConfig.getServices().getContextPath().getDataGetManagerMs();
            case SAVE_SALE, SAVE_SALES -> localAppConfig.getServices().getContextPath().getDataSaveManagerMs();
            case UPDATE_SALE, UPDATE_SALES -> localAppConfig.getServices().getContextPath().getDataUpdateManagerMs();
            case DELETE_SALE, DELETE_SALES, DELETE_QUERY_SALES -> localAppConfig.getServices().getContextPath().getDataDeleteManagerMs();
        };
    }
}