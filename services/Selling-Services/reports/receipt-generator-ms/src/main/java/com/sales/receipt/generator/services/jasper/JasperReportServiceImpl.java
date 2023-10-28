package com.sales.receipt.generator.services.jasper;

import com.sales.receipt.generator.models.dto.ItemDTO;
import com.sales.receipt.generator.models.dto.TagDTO;
import com.sales.receipt.generator.models.entities.Customer;
import com.sales.receipt.generator.models.entities.Item;
import com.sales.receipt.generator.models.entities.Sale;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class JasperReportServiceImpl implements ReportService {
    @Override
    public byte[] createReport(Sale sale, Resource resource) throws IOException {
        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(resource.getInputStream());
            Map<String, Object> reportProperties = createReportProperties(sale);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, reportProperties, new JREmptyDataSource());
            return JasperExportManager.exportReportToPdf(jasperPrint);
        } catch (JRException e) {
            log.error("An error happened while binding the Sale to the jasper report: {}", e.getMessage());
            return new byte[1];
        }
    }

    private JRBeanCollectionDataSource createItemsDataSource(List<Item> items) {
        return new JRBeanCollectionDataSource(createDTOItems(items));
    }

    private List<ItemDTO> createDTOItems(List<Item> items) {
        return items.stream().map(item ->
                new ItemDTO().builder()
                        .name(item.getName())
                        .price(item.getPrice())
                        .tags(new JRBeanCollectionDataSource(item.getTags().stream().map(TagDTO::new).toList()))
                        .quantity(item.getQuantity())
                        .build()
        ).toList();
    }

    private JRBeanCollectionDataSource createCustomerDataSource(Customer customer) {
        return new JRBeanCollectionDataSource(Arrays.asList(customer));
    }

    private Map<String, Object> createReportProperties(Sale sale) {
        Map<String, Object> properties = new HashMap<>();
        JRBeanCollectionDataSource customerDataSource = createCustomerDataSource(sale.getCustomer());
        JRBeanCollectionDataSource itemsDataSource = createItemsDataSource(sale.getItems());
        properties.put("customerDS", customerDataSource);
        properties.put("itemsDS", itemsDataSource);
        properties.put("saleDate", sale.getSaleDate());
        properties.put("storeLocation", sale.getStoreLocation());
        properties.put("purchaseMethod", sale.getPurchaseMethod().toString());
        properties.put("couponUsed", sale.isCouponUsed() ? "Yes" : "No");
        return properties;
    }
}