package vn.ghtk.catalog.application.variant;

import vn.ghtk.catalog.domain.VariantId;

public interface VariantManagement {
	void createVariant(VariantCreationCmd cmd);
	void updateVariant(VariantId id, VariantCreationCmd cmd);
}
