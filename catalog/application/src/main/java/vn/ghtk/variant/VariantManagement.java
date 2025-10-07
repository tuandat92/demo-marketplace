package vn.ghtk.variant;

import vn.ghtk.doman.catalog.VariantId;

public interface VariantManagement {
	void createVariant(VariantCreationCmd cmd);
	void updateVariant(VariantId id, VariantCreationCmd cmd);
}
