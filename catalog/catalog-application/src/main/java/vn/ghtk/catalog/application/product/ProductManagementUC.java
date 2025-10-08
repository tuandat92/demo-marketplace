package vn.ghtk.catalog.application.product;

import lombok.RequiredArgsConstructor;
import vn.ghtk.catalog.domain.*;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class ProductManagementUC implements ProductManagement {
	private final ProductRepository productRepository;

	@Override
	public void createProduct(ProductCreationCmd cmd) {
		if (productRepository.findByName(cmd.title()).isPresent()) {
			throw new ProductException(ErrorMessage.PRODUCT_EXISTS);
		}

		Product product = Product.builder()
			.id(new ProductId(UUID.randomUUID().toString()))
			.model(cmd.model())
			.brand(cmd.brand())
			.category(cmd.category())
			.title(cmd.title())
			.slug(cmd.slug())
			.description(cmd.description())
			.images(cmd.images())
			.specifications(cmd.specifications())
			.status(cmd.status())
			.basePrice(cmd.basePrice())
			.build();
		productRepository.save(product);
	}

	@Override
	public void updateProduct(ProductId id, ProductCreationCmd cmd) {
		if (productRepository.findById(id).isEmpty()) {
			throw new ProductException(ErrorMessage.PRODUCT_UPDATE_NOT_EXISTS);
		}

		Optional<Product> productOptional = productRepository.findByName(cmd.title());
		if (productOptional.isPresent()) {
			Product product = productOptional.get();
			if (Objects.equals(product.title(), cmd.title()) && !Objects.equals(product.id(), id)) {
				throw new ProductException(ErrorMessage.PRODUCT_EXISTS);
			}
		}

		Product productSave = Product.builder()
			.id(id)
			.model(cmd.model())
			.brand(cmd.brand())
			.category(cmd.category())
			.title(cmd.title())
			.slug(cmd.slug())
			.description(cmd.description())
			.images(cmd.images())
			.specifications(cmd.specifications())
			.status(cmd.status())
			.basePrice(cmd.basePrice())
			.build();
		productRepository.save(productSave);
	}

	@Override
	public void updateBasePrice(ProductId id, Long basePrice) {
		if (productRepository.findById(id).isEmpty()) {
			throw new ProductException(ErrorMessage.PRODUCT_UPDATE_NOT_EXISTS);
		}

		productRepository.updateBasePrice(id, basePrice);
	}

	@Override
	public void publishProduct(ProductId id) {
		Optional<Product> productOptional = productRepository.findById(id);
		if (productOptional.isEmpty()) {
			throw new ProductException(ErrorMessage.PRODUCT_UPDATE_NOT_EXISTS);
		}

		Product product = productOptional.get();
		if (!product.isValidPublish()) {
			throw new ProductException(ErrorMessage.CANNOT_PUBLISH_PRODUCT);
		}

		productRepository.updateStatus(id, ProductStatus.PUBLISHED);
	}

	@Override
	public void retireProduct(ProductId id) {
		if (productRepository.findById(id).isEmpty()) {
			throw new ProductException(ErrorMessage.PRODUCT_UPDATE_NOT_EXISTS);
		}

		productRepository.updateStatus(id, ProductStatus.RETIRED);
	}
}
