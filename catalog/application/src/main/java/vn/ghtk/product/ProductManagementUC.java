package vn.ghtk.product;

import vn.ghtk.doman.catalog.*;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class ProductManagementUC implements ProductManagement {
	private final ProductRepository productRepository;

	public ProductManagementUC(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

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
			.build();
		productRepository.save(productSave);
	}
}
