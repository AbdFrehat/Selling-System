package com.selling.system.data.sales.save.service;

import com.selling.system.data.shared.module.service.QueryResponseService;
import com.selling.system.data.shared.module.service.SalesService;
import com.selling.system.data.shared.module.util.QueryResponseMapperUtil;
import com.selling.system.shared.module.models.commands.DataCommand;
import com.selling.system.shared.module.models.responses.DataResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import static com.selling.system.data.shared.module.convertors.ObjectToSalesConvertor.toSales;

@Service
@Slf4j
public class QueryResponseServiceImpl implements QueryResponseService {

    private final SalesService salesService;

    public QueryResponseServiceImpl(SalesService salesService) {
        this.salesService = salesService;
    }

    @Override
    public Mono<ResponseEntity<DataResponse>> buildQueryResponse(DataCommand dataCommand) {
        log.info("SAVE_SALES Command is called");
        return QueryResponseMapperUtil.mapFluxToResponse(salesService.saveSales(toSales(dataCommand.getPayload())));
    }
}