package vn.ghtk.product;

import vn.ghtk.doman.catalog.ProductId;

public interface ProductManagement {
	void createProduct(ProductCreationCmd cmd);

	void updateProduct(ProductId id, ProductCreationCmd cmd);
	void updateBasePrice(ProductId id, Long basePrice);
	void publishProduct(ProductId id);
	void retireProduct(ProductId id);
}
