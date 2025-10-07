package vn.ghtk.doman.catalog;

import java.util.Optional;

public interface VariantRepository {
	void save(Variant variant);
	Optional<Variant> findById(VariantId id);
}
