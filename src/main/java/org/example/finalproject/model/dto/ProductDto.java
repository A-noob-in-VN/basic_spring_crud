package org.example.finalproject.model.dto;

import lombok.Data;

@Data
public class ProductDto {

    private Integer productId;
    private String productName;
    private Integer productPrice;
    private Integer produceCode;
    private String productMfg;
    private String productBbf;
    private String productSite;
    private Integer productQuantity;
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProduceCode() {
        return produceCode;
    }

    public void setProduceCode(Integer produceCode) {
        this.produceCode = produceCode;
    }

    public String getProductMfg() {
        return productMfg;
    }

    public void setProductMfg(String productMfg) {
        this.productMfg = productMfg;
    }

    public String getProductBbf() {
        return productBbf;
    }

    public void setProductBbf(String productBbf) {
        this.productBbf = productBbf;
    }

    public String getProductSite() {
        return productSite;
    }

    public void setProductSite(String productSite) {
        this.productSite = productSite;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
