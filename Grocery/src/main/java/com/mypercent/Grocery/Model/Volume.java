package com.mypercent.Grocery.Model;


import java.math.BigDecimal;
////This is volume model class. I can use lombook to minimize codes for constructor, getter and setter
public class Volume {
    private int quantity;
    private BigDecimal volumePrice;

    public Volume(int quantity, BigDecimal volumePrice) {
        this.quantity = quantity;
        this.volumePrice = volumePrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getVolumePrice() {
        return volumePrice;
    }

    public void setVolumePrice(BigDecimal volumePrice) {
        this.volumePrice = volumePrice;
    }
}
