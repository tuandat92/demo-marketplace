package vn.ghtk.catalog.application.variant;

import vn.ghtk.catalog.domain.common.ErrorMessage;
import vn.ghtk.catalog.domain.variant.Variant;
import vn.ghtk.catalog.domain.variant.VariantException;
import vn.ghtk.catalog.domain.variant.VariantId;
import vn.ghtk.catalog.domain.variant.VariantRepository;

import java.util.UUID;

public class VariantManagementUC implements VariantManagement {
	private final VariantRepository variantRepository;

	public VariantManagementUC(VariantRepository variantRepository) {
		this.variantRepository = variantRepository;
	}

	@Override
	public void createVariant(VariantCreationCmd cmd) {
		Variant variant = new Variant(new VariantId(UUID.randomUUID().toString()), cmd.productId(), cmd.name(), cmd.color(), cmd.capacity());
		variantRepository.save(variant);
	}

	@Override
	public void updateVariant(VariantId id, VariantCreationCmd cmd) {
		if (variantRepository.findById(id).isEmpty()) {
			throw new VariantException(ErrorMessage.VARIANT_UPDATE_NOT_EXISTS);
		}

		Variant variant = new Variant(id, cmd.productId(), cmd.name(), cmd.color(), cmd.capacity());
		variantRepository.save(variant);
	}
}
