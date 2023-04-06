package com.example.SpringCommerce.product;

public class CartItem {
    private product product;
    private int productId;
    private int quantity;
    private double price;

    public CartItem(com.example.SpringCommerce.product.product product, int productId, int quantity, double price) {
        this.product = product;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    public com.example.SpringCommerce.product.product getProduct() {
        return product;
    }

    public void setProduct(com.example.SpringCommerce.product.product product) {
        this.product = product;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
