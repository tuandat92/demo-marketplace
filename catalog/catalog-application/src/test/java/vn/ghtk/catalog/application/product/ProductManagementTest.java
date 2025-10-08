package vn.ghtk.catalog.application.product;

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

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class ProductManagementTest {
	@InjectMocks
	private ProductManagementUC productManagementUC;

	@Mock
	private ProductRepository productRepository;

	ProductCreationCmd productCreationCmd;

	@BeforeEach
	void setUp() {
		productCreationCmd = new ProductCreationCmd(
			"iPhone 17 Pro",
			new Brand("Apple"),
			new Category("iPhone", "{}"),
			"Apple iPhone 17 Pro",
			"/iphone-17-pro/",
			"Đặc điểm nổi bật của iPhone 17 Pro\n" +
				"• Khẳng định đẳng cấp với khung nhôm nguyên khối chắc chắn và diện mạo mới.",
			List.of("https://cdn.tgdd.vn/Products/Images/42/342676/Slider/iphone-17-pro638949088567223883.jpg"),
			"{\"cpu\": \"A20 Bionic\", \"ram\": \"12GB\"}",
			ProductStatus.DRAFT,
			39990000L
		);
	}

	@Nested
	class TestCreateProduct {
		@Test
		void testCreateProductSuccess() {
			Mockito.when(productRepository.findByName(Mockito.any())).thenReturn(Optional.empty());
			Assertions.assertDoesNotThrow(() -> productManagementUC.createProduct(productCreationCmd));
		}

		@Test
		void testCreateProductExists() {
			Product productExist = Product.builder()
				.id(new ProductId(UUID.randomUUID().toString()))
				.model("iPhone 17 Pro")
				.build();
			Mockito.when(productRepository.findByName(Mockito.any())).thenReturn(Optional.of(productExist));
			Assertions.assertThrows(ProductException.class, () -> productManagementUC.createProduct(productCreationCmd));
		}

		@Nested
		class TestUpdateProduct {
			@Test
			void testUpdateProductSuccess() {
				Product productExist = Product.builder()
					.id(new ProductId("069b1e52-6fd5-4ae1-9165-493b353db2e8"))
					.model("iPhone 17 Pro")
					.build();
				Mockito.when(productRepository.findById(Mockito.any())).thenReturn(Optional.of(productExist));
				Mockito.when(productRepository.findByName(Mockito.any())).thenReturn(Optional.empty());
				Assertions.assertDoesNotThrow(() -> productManagementUC.updateProduct(new ProductId(UUID.randomUUID().toString()), productCreationCmd));
			}

			@Test
			void testUpdateProductFailProductNotExist() {
				Mockito.when(productRepository.findById(Mockito.any())).thenReturn(Optional.empty());
				Assertions.assertThrows(ProductException.class, () -> productManagementUC.updateProduct(new ProductId(UUID.randomUUID().toString()), productCreationCmd));
			}

			@Test
			void testUpdateProductFailProductExists() {
				Product product = Product.builder()
					.id(new ProductId("069b1e52-6fd5-4ae1-9165-493b353db2e8"))
					.title("Apple iPhone 17 Pro")
					.model("iPhone 17 Pro")
					.build();
				Mockito.when(productRepository.findById(Mockito.any())).thenReturn(Optional.of(product));

				Product productExist = Product.builder()
					.id(new ProductId("069b1e52-6fd5-4ae1-9165-493b353db2e9"))
					.title("Apple iPhone 17 Pro")
					.model("iPhone 17 Pro")
					.build();
				Mockito.when(productRepository.findByName(Mockito.any())).thenReturn(Optional.of(productExist));
				Assertions.assertThrows(ProductException.class, () -> productManagementUC.updateProduct(new ProductId(UUID.randomUUID().toString()), productCreationCmd));
			}
		}
	}

	@Nested
	class TestUpdateBasePrice {
		@Test
		void testUpdateProductFailProductExists() {
			ProductId productId = new ProductId("069b1e52-6fd5-4ae1-9165-493b353db2e8");
			Product product = Product.builder()
				.id(productId)
				.title("Apple iPhone 17 Pro")
				.model("iPhone 17 Pro")
				.build();
			Mockito.when(productRepository.findById(Mockito.any())).thenReturn(Optional.of(product));
			Assertions.assertDoesNotThrow(() -> productManagementUC.updateBasePrice(productId, 40000000L));
		}
	}

	@Nested
	class TestPublishRetireProduct {
		Product product;

		public TestPublishRetireProduct() {
			ProductId productId = new ProductId("069b1e52-6fd5-4ae1-9165-493b353db2e8");
			product = Product.builder()
				.id(productId)
				.category(new Category("Apple", ""))
				.title("Apple iPhone 17 Pro")
				.description("Đặc điểm nổi bật của iPhone 17 Pro\n" +
					"• Khẳng định đẳng cấp với khung nhôm nguyên khối chắc chắn và diện mạo mới.")
				.images(List.of("https://cdn.tgdd.vn/Products/Images/42/342676/Slider/iphone-17-pro638949088567223883.jpg"))
				.specifications("{\"cpu\": \"A20 Bionic\", \"ram\": \"12GB\"}")
				.status(ProductStatus.DRAFT)
				.model("iPhone 17 Pro")
				.build();
		}

		@Test
		void testPublishProduct() {
			ProductId productId = new ProductId("069b1e52-6fd5-4ae1-9165-493b353db2e8");
			Mockito.when(productRepository.findById(Mockito.any())).thenReturn(Optional.of(product));
			Assertions.assertDoesNotThrow(() -> productManagementUC.publishProduct(productId));
		}

		@Test
		void testRetireProduct() {
			ProductId productId = new ProductId("069b1e52-6fd5-4ae1-9165-493b353db2e8");
			Mockito.when(productRepository.findById(Mockito.any())).thenReturn(Optional.of(product));
			Assertions.assertDoesNotThrow(() -> productManagementUC.retireProduct(productId));
		}
	}

}
