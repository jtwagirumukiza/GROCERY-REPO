package com.mypercent.Grocery.Model;


import java.math.BigDecimal;

//This is product model class. I can use lombook to minimize codes for constructor, getter and setter
public class Product {
    String productCode;
    String name;
    BigDecimal price;
    Volume volume;

    public Product(String productCode, String name, BigDecimal price, Volume volume) {
        this.productCode = productCode;
        this.name = name;
        this.price = price;
        this.volume = volume;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Volume getVolume() {
        return volume;
    }

    public void setVolume(Volume volume) {
        this.volume = volume;
    }
}
