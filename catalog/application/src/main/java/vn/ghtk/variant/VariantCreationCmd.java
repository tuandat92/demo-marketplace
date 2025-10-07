package vn.ghtk.variant;

import vn.ghtk.doman.catalog.Capacity;
import vn.ghtk.doman.catalog.Color;
import vn.ghtk.doman.catalog.Product;

public record VariantCreationCmd(
	Product product,
	String name,
	Color color,
	Capacity capacity
) {
}
