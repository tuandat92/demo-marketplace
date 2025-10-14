package vn.ghtk.catalog.domain.variant;

import java.util.Optional;

public interface VariantRepository {
	void save(Variant variant);
	Optional<Variant> findById(VariantId id);
}
