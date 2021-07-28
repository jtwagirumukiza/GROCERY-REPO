package com.mypercent.Grocery.Service;

import com.mypercent.Grocery.Model.Product;

import java.math.BigDecimal;

public interface PointOfSalesTerminal {
    void scan(Product product);
    BigDecimal calculateTotal();
}
