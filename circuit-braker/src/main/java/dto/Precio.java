package dto;

import java.math.BigDecimal;

public class Precio {

private Integer id;
	
	private String code_product;

	private String description;
	
	private BigDecimal price;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode_product() {
		return code_product;
	}
	public void setCode_product(String code_product) {
		this.code_product = code_product;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
