package vn.ghtk.catalog.domain;

import java.util.Optional;

public interface ProductRepository {
	void save(Product product);
	Optional<Product> findByName(String name);
	Optional<Product> findById(ProductId id);
	void updateBasePrice(ProductId id, Long basePrice);
	void updateStatus(ProductId id, ProductStatus status);
}
