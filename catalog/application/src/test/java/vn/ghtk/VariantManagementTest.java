package vn.ghtk;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import vn.ghtk.doman.catalog.*;
import vn.ghtk.variant.VariantCreationCmd;
import vn.ghtk.variant.VariantManagementUC;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class VariantManagementTest {
	@InjectMocks
	private VariantManagementUC variantManagementUC;

	@Mock
	private VariantRepository variantRepository;

	VariantCreationCmd variantCreationCmd;
	Product product;

	@BeforeEach
	void setUp() {
		product = Product.builder()
			.id(new ProductId(UUID.randomUUID().toString()))
			.brand(new Brand("Apple"))
			.category(new Category("iPhone", "{}"))
			.title("Apple iPhone 17 Pro")
			.slug("/iphone-17-pro/")
			.description("Đặc điểm nổi bật của iPhone 17 Pro\n" +
				"• Khẳng định đẳng cấp với khung nhôm nguyên khối chắc chắn và diện mạo mới.")
			.images(List.of("https://cdn.tgdd.vn/Products/Images/42/342676/Slider/iphone-17-pro638949088567223883.jpg"))
			.specifications("{\"cpu\": \"A20 Bionic\", \"ram\": \"12GB\"}")
			.status(ProductStatus.DRAFT)
			.build();

		variantCreationCmd = new VariantCreationCmd(product, "iPhone 17 Pro 256GB", Color.COSMIC_ORANGE, Capacity.GB_256);
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
			Variant variantUpdate = new Variant(variantId, product, "iPhone 17 Pro 256GB", Color.COSMIC_ORANGE, Capacity.GB_256);
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
