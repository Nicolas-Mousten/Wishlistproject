package com.example.wishlist.model;

public class Wish {
    private int productId;
    private String productName;
    private int productPrice;
    private boolean isReserved;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {this.productId = productId;}

    public String getProductName() {return productName;}

    public void setProductName(String productName) {this.productName = productName;}

    public int getProductPrice() {return productPrice;}

    public void setProductPrice(int productPrice) {this.productPrice = productPrice;}

    public boolean isIsReserved() {return isReserved;}

    public void setIsReserved(boolean isReserved) {this.isReserved = isReserved;}

    @Override
    public String toString() {
        return "Wish{" +
                "product_id=" + productId +
                ", produc_name='" + productName + '\'' +
                ", product_price=" + productPrice +
                ", is_reserved=" + isReserved +
                '}';
    }
}
