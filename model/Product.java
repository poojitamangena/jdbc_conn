package model;

public class Product {
	private int prod_id;
	private String prod_name;
	private int min_qual;
	private int price;
	private int quant;

	public int getProd_id() {
		return prod_id;
	}

	public void setProd_id(int prod_id) {
		this.prod_id = prod_id;
	}

	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

	public int getMin_qual() {
		return min_qual;
	}

	public void setMin_qual(int min_qual) {
		this.min_qual = min_qual;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuant() {
		return quant;
	}

	public void setQuant(int quant) {
		this.quant = quant;
	}
}
