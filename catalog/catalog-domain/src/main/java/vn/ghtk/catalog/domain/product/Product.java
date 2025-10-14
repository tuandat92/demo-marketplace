package vn.ghtk.catalog.domain.product;

import vn.ghtk.catalog.domain.common.StringUtils;

import java.util.List;
import java.util.Objects;

public class Product {
	private ProductId id;
	private String model;
	private Brand brand;
	private Category category;
	private String title;
	private String slug;
	private String description;
	private List<String> images;
	private String specifications;
	private ProductStatus status;
	private Long basePrice;

	public String title() {
		return this.title;
	}

	public ProductId id() {
		return this.id;
	}

	public boolean isValidPublish() {
		// để publish được cần category, title, desc != null, images tối thiểu 1 ảnh
		return Objects.nonNull(category) && !title.isEmpty() && !description.isEmpty() && !images.isEmpty();
	}

	Product(ProductBuilder builder) {
		this.id = builder.id;
		this.model = builder.model;
		this.brand = builder.brand;
		this.category = builder.category;
		this.title = builder.title;
		this.slug = builder.slug;
		this.description = builder.description;
		this.images = builder.images;
		this.specifications = builder.specifications;
		this.status = builder.status;
		this.basePrice = builder.basePrice;
	}

	public static class ProductBuilder {
		private ProductId id;
		private String model;
		private Brand brand;
		private Category category;
		private String title;
		private String slug;
		private String description;
		private List<String> images;
		private String specifications;
		private ProductStatus status;
		private Long basePrice;

		public ProductBuilder id(ProductId id) {
			this.id = id;
			return this;
		}

		public ProductBuilder model(String model) {
			if (Objects.isNull(model) || model.isEmpty()) {
				throw new IllegalArgumentException("Tên model không được để trống");
			}
			this.model = StringUtils.clean(model);
			return this;
		}

		public ProductBuilder brand(Brand brand) {
			if (Objects.isNull(brand)) {
				throw new IllegalArgumentException("Thương hiệu chính thức không được null");
			}
			this.brand = brand;
			return this;
		}

		public ProductBuilder category(Category category) {
			if (Objects.isNull(category)) {
				throw new IllegalArgumentException("Loại sản phẩm không được null");
			}
			this.category = category;
			return this;
		}

		public ProductBuilder title(String title) {
			this.title = StringUtils.clean(title);
			return this;
		}

		public ProductBuilder slug(String slug) {
			this.slug = StringUtils.clean(slug);
			return this;
		}

		public ProductBuilder description(String description) {
			this.description = description;
			return this;
		}

		public ProductBuilder images(List<String> images) {
			this.images = images;
			return this;
		}

		public ProductBuilder specifications(String specifications) {
			this.specifications = specifications;
			return this;
		}

		public ProductBuilder status(ProductStatus status) {
			this.status = status;
			return this;
		}

		public ProductBuilder basePrice(Long basePrice) {
			this.basePrice = basePrice;
			return this;
		}

		public Product build() {
			return new Product(this);
		}
	}

	public static ProductBuilder builder() {
		return new ProductBuilder();
	}
}
