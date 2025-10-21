package vn.ghtk.catalog.domain.product;

import java.util.Optional;

public interface ProductRepository {
	void save(Product product);
	Optional<Product> findByName(String name);
	Optional<Product> findById(ProductId id);
}
