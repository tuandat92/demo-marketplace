package vn.ghtk.doman.catalog;

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

	public String title() {
		return this.title;
	}

	public ProductId id() {
		return this.id;
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

		public Product.ProductBuilder id(ProductId id) {
			this.id = id;
			return this;
		}

		public Product.ProductBuilder model(String model) {
			if (Objects.isNull(model) || model.isEmpty()) {
				throw new IllegalArgumentException("Tên model không được để trống");
			}
			this.model = model;
			return this;
		}

		public Product.ProductBuilder brand(Brand brand) {
			if (Objects.isNull(brand)) {
				throw new IllegalArgumentException("Thương hiệu chính thức không được null");
			}
			this.brand = brand;
			return this;
		}

		public Product.ProductBuilder category(Category category) {
			if (Objects.isNull(category)) {
				throw new IllegalArgumentException("Loại sản phẩm không được null");
			}
			this.category = category;
			return this;
		}

		public Product.ProductBuilder title(String title) {
			this.title = title;
			return this;
		}

		public Product.ProductBuilder slug(String slug) {
			this.slug = slug;
			return this;
		}

		public Product.ProductBuilder description(String description) {
			this.description = description;
			return this;
		}

		public Product.ProductBuilder images(List<String> images) {
			this.images = images;
			return this;
		}

		public Product.ProductBuilder specifications(String specifications) {
			this.specifications = specifications;
			return this;
		}

		public Product.ProductBuilder status(ProductStatus status) {
			this.status = status;
			return this;
		}

		public Product build() {
			return new Product(this);
		}
	}

	public static Product.ProductBuilder builder() {
		return new Product.ProductBuilder();
	}
}
