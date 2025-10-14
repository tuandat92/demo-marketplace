package vn.ghtk.catalog.domain.product;

import java.util.Optional;

public interface BrandRepository {
	void save(Brand brand);
	Optional<Brand> findByValue(String value);
}
