package com.example.wishlist.model;

public class Wish {
    private int product_id;
    private String produc_name;
    private int product_price;
    private boolean is_reserved;

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {this.product_id = product_id;}

    public String getProduc_name() {return produc_name;}

    public void setProduc_name(String produc_name) {this.produc_name = produc_name;}

    public int getProduct_price() {return product_price;}

    public void setProduct_price(int product_price) {this.product_price = product_price;}

    public boolean isIs_reserved() {return is_reserved;}

    public void setIs_reserved(boolean is_reserved) {this.is_reserved = is_reserved;}

    @Override
    public String toString() {
        return "Wish{" +
                "product_id=" + product_id +
                ", produc_name='" + produc_name + '\'' +
                ", product_price=" + product_price +
                ", is_reserved=" + is_reserved +
                '}';
    }
}
