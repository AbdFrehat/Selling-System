package com.selling.system.data.sales.delete.service;

import com.selling.system.data.shared.module.service.QueryResponseService;
import com.selling.system.data.shared.module.service.SalesService;
import com.selling.system.data.shared.module.util.QueryResponseMapperUtil;
import com.selling.system.shared.module.models.commands.QueryCommand;
import com.selling.system.shared.module.models.responses.QueryResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import static com.selling.system.data.shared.module.convertors.ObjectToSalesConvertor.toSale;

@Service
@Slf4j
public class QueryResponseServiceImpl implements QueryResponseService {

    private final SalesService salesService;

    public QueryResponseServiceImpl(SalesService salesService) {
        this.salesService = salesService;
    }

    @Override
    public Mono<ResponseEntity<QueryResponse>> buildQueryResponse(QueryCommand queryCommand) {
        log.info("DELETE_SALE Command is called");
        return QueryResponseMapperUtil.mapMonoToResponse(salesService.deleteSale(toSale(queryCommand.getPayload())));
    }
}