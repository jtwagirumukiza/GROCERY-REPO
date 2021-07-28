package com.mypercent.Grocery.serviceImp;

import com.mypercent.Grocery.Model.Product;
import com.mypercent.Grocery.Service.PointOfSalesTerminal;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
// This is a service layer for business logic. It implements PointOfSalesTerminal interface
@Service
public class PointOfSalesTerminalImp implements PointOfSalesTerminal {


    private Map<String, List<Product>> productMap;

    public PointOfSalesTerminalImp() {
        this.productMap = new HashMap<>();
    }
// This is a method that scans product and adds it in hashmap
    @Override
    public void scan(Product product) {
      if (!productMap.containsKey(product.getProductCode())){
          productMap.put(product.getProductCode(), new ArrayList<>(Arrays.asList(product)) );

      }else {
          productMap.get(product.getProductCode()).add(product);
      }
    }
    // This is a method that compute Item Price for products
    private BigDecimal computeItemPrice(List<Product> products){
        BigDecimal totalPrice=BigDecimal.ZERO;
        Product p=products.get(0);
        if (p.getVolume()!=null){
            //number of volume
            int numberOfVolume = products.size()/p.getVolume().getQuantity();
            int quantityAboveVolume= products.size()%p.getVolume().getQuantity();
            //total price if the product has volume price
            totalPrice=BigDecimal.valueOf(numberOfVolume).multiply(p.getVolume().getVolumePrice()).add(BigDecimal.valueOf(quantityAboveVolume).multiply(p.getPrice()));
        }else {

                    //total price if the product does have volume price
            for (Product product : products) {
                totalPrice = totalPrice.add(product.getPrice());
            }
        }

        return totalPrice;
    }
            //This method calculate total
    @Override
    public BigDecimal calculateTotal() {
        BigDecimal totalPrice= BigDecimal.ZERO;
        for (Map.Entry<String, List<Product>> ps:productMap.entrySet()) {
            totalPrice=totalPrice.add(computeItemPrice(ps.getValue()));

        }
        return totalPrice;
    }
}
