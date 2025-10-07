package vn.ghtk.product;

import vn.ghtk.doman.catalog.ProductId;

public interface ProductManagement {
	void createProduct(ProductCreationCmd cmd);

	void updateProduct(ProductId id, ProductCreationCmd cmd);
}
