package org.practice.project.DTO;

public class ProductDTO {
	private int id ;
	private  String name;
	private double price;
	private double weight;
	private int categoryId;
	private String description;
	private String imageName;
	
	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public ProductDTO(int id, String name, double price, double weight, int categoryId, String description,
			String imageName) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.weight = weight;
		this.categoryId = categoryId;
		this.description = description;
		this.imageName = imageName;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
}