package vn.ghtk.catalog.application.variant;


import vn.ghtk.catalog.domain.variant.Capacity;
import vn.ghtk.catalog.domain.variant.Color;
import vn.ghtk.catalog.domain.product.ProductId;

public record VariantCreationCmd(
	ProductId productId,
	String name,
	Color color,
	Capacity capacity
) {
}
