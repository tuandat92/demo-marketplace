package vn.ghtk.doman.catalog;

import java.util.Optional;

public interface ProductRepository {
	void save(Product product);
	Optional<Product> findByName(String name);
	Optional<Product> findById(ProductId id);
}
