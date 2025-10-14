package vn.ghtk.catalog.domain.product;

import vn.ghtk.catalog.domain.product.Category;

import java.util.Optional;

public interface CategoryRepository {
	void save(Category category);
	Optional<Category> findByValue(String value);
}
