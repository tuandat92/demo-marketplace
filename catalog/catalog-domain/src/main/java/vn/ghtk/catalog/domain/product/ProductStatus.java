package vn.ghtk.catalog.domain.product;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ProductStatus {
	DRAFT(1, "DRAFT"),
	PUBLISHED(2, "PUBLISHED"),
	RETIRED(3, "RETIRED"),
	;

	private final Integer value;
	private final String name;
}
