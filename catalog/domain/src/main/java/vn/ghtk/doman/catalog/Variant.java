package vn.ghtk.doman.catalog;

public class Variant {
	private VariantId id;
	private Product product;
	private String name;
	private Color color;
	private Capacity capacity;

	public Variant(VariantId id, Product product, String name, Color color, Capacity capacity) {
		this.id = id;
		this.product = product;
		this.name = name;
		this.color = color;
		this.capacity = capacity;
	}
}
