package com.orderizer.data.update.orders.manager.model.response;

import com.orderizer.data.update.orders.manager.model.common.Customer;
import com.orderizer.data.update.orders.manager.model.common.Item;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class OrderUpdateResponse {

    private long globalIdentifier;

    private long localIdentifier;

    private LocalDateTime orderDate;

    private List<Item> items;

    private String storeLocation;

    private BigDecimal totalPrice;

    private Customer customer;

    private boolean couponUsed;

    private String purchaseMethod;
}
