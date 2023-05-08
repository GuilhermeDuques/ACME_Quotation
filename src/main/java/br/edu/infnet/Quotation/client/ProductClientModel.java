package br.edu.infnet.Quotation.client;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductClientModel{
    @JsonProperty
    private int productId;
    @JsonProperty
    private String productName;
    @JsonProperty
    private String productImage;
    @JsonProperty
    private int productQuantity;
    @JsonProperty
    private int codProduct;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public int getCodProduct() {
        return codProduct;
    }

    public void setCodProduct(int codProduct) {
        this.codProduct = codProduct;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Product{id=").append(productId);
        sb.append(", img=").append(productImage);
        sb.append(", name=").append(productName);
        sb.append(", quantity=").append(productQuantity);
        sb.append(", code=").append(codProduct);
        sb.append('}');
        return sb.toString();
    }
}
