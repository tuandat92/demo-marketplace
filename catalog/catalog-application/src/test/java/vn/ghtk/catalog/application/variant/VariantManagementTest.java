package vn.ghtk.catalog.application.variant;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import vn.ghtk.catalog.domain.*;

import java.util.Optional;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class VariantManagementTest {
	@InjectMocks
	private VariantManagementUC variantManagementUC;

	@Mock
	private VariantRepository variantRepository;

	VariantCreationCmd variantCreationCmd;
	ProductId productId;

	@BeforeEach
	void setUp() {
		productId = new ProductId(UUID.randomUUID().toString());
		variantCreationCmd = new VariantCreationCmd(productId, "iPhone 17 Pro 256GB", Color.COSMIC_ORANGE, Capacity.GB_256);
	}

	@Nested
	class TestCreateVariant {
		@Test
		void testCreateSuccess() {
			Assertions.assertDoesNotThrow(() -> variantManagementUC.createVariant(variantCreationCmd));
		}
	}

	@Nested
	class TestUpdateVariant {
		@Test
		void testUpdateSuccess() {
			VariantId variantId = new VariantId(UUID.randomUUID().toString());
			Variant variantUpdate = new Variant(variantId, productId, "iPhone 17 Pro 256GB", Color.COSMIC_ORANGE, Capacity.GB_256);
			Mockito.when(variantRepository.findById(Mockito.any())).thenReturn(Optional.of(variantUpdate));
			Assertions.assertDoesNotThrow(() -> variantManagementUC.updateVariant(new VariantId(UUID.randomUUID().toString()), variantCreationCmd));
		}

		@Test
		void testUpdateFailVariantNotExist() {
			Mockito.when(variantRepository.findById(Mockito.any())).thenReturn(Optional.empty());
			Assertions.assertThrows(VariantException.class, () -> variantManagementUC.updateVariant(new VariantId(UUID.randomUUID().toString()), variantCreationCmd));
		}
	}
}
