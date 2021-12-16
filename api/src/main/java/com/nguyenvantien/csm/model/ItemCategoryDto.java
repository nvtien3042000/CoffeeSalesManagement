package com.nguyenvantien.csm.model;

public class ItemCategoryDto extends Item{
	private String nameCategory;

	public ItemCategoryDto() {
		super();
	}

	public ItemCategoryDto(Integer id, String name, Double price, String unit, String nameCategory) {
		super(id, name, price, unit);
		this.nameCategory = nameCategory;
	}

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	@Override
	public String toString() {
		return "ItemCategoryDto [nameCategory=" + nameCategory + "]";
	}
	
}
