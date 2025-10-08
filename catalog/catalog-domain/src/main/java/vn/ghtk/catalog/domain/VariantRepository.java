package vn.ghtk.catalog.domain;

import java.util.Optional;

public interface VariantRepository {
	void save(Variant variant);
	Optional<Variant> findById(VariantId id);
}
