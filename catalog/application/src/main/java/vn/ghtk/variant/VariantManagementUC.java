package vn.ghtk.variant;

import vn.ghtk.doman.catalog.*;

import java.util.UUID;

public class VariantManagementUC implements VariantManagement {
	private final VariantRepository variantRepository;

	public VariantManagementUC(VariantRepository variantRepository) {
		this.variantRepository = variantRepository;
	}

	@Override
	public void createVariant(VariantCreationCmd cmd) {
		Variant variant = new Variant(new VariantId(UUID.randomUUID().toString()), cmd.product(), cmd.name(), cmd.color(), cmd.capacity());
		variantRepository.save(variant);
	}

	@Override
	public void updateVariant(VariantId id, VariantCreationCmd cmd) {
		if (variantRepository.findById(id).isEmpty()) {
			throw new VariantException(ErrorMessage.VARIANT_UPDATE_NOT_EXISTS);
		}

		Variant variant = new Variant(id, cmd.product(), cmd.name(), cmd.color(), cmd.capacity());
		variantRepository.save(variant);
	}
}
