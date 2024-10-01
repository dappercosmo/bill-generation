package com.trial.billGeneration.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
    public String customerName;
    public String phone;
    private long productId;
    private long quantity;
    private long totalPrice;
}
