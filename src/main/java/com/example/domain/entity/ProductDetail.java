package com.example.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.example.config.layers.BaseEntity;

@Entity
public class ProductDetail implements BaseEntity {
	private static final long serialVersionUID = 6234288539963471065L;
	
	private Long id;
	private String productId;
    private String productName;
    private String shortDescription;
    private String longDescription;
    private String inventoryId;
    
    @Id
    public String getProductId() {
        return productId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getShortDescription() {
        return shortDescription;
    }
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
    public String getLongDescription() {
        return longDescription;
    }
    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }
    public String getInventoryId() {
        return inventoryId;
    }
    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}