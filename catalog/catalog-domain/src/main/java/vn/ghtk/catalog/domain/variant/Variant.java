package vn.ghtk.catalog.domain.variant;

import vn.ghtk.catalog.domain.product.ProductId;

public class Variant {
	private VariantId id;
	private ProductId productId;
	private String name;
	private Color color;
	private Capacity capacity;

	public Variant(VariantId id, ProductId productId, String name, Color color, Capacity capacity) {
		this.id = id;
		this.productId = productId;
		this.name = name;
		this.color = color;
		this.capacity = capacity;
	}
}
