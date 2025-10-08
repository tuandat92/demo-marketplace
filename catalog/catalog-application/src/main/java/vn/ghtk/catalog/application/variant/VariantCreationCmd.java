package vn.ghtk.catalog.application.variant;


import vn.ghtk.catalog.domain.Capacity;
import vn.ghtk.catalog.domain.Color;
import vn.ghtk.catalog.domain.ProductId;

public record VariantCreationCmd(
	ProductId productId,
	String name,
	Color color,
	Capacity capacity
) {
}
