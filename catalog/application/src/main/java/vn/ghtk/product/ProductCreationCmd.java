package vn.ghtk.product;

import vn.ghtk.doman.catalog.Brand;
import vn.ghtk.doman.catalog.Category;
import vn.ghtk.doman.catalog.ProductStatus;

import java.util.List;

public record ProductCreationCmd(
	String model,
	Brand brand,
	Category category,
	String title,
	String slug,
	String description,
	List<String> images,
	String specifications,
	ProductStatus status,
	Long basePrice
) {

}