package vn.ghtk.catalog.application.product;

import vn.ghtk.catalog.domain.Brand;
import vn.ghtk.catalog.domain.Category;
import vn.ghtk.catalog.domain.ProductStatus;

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