package vn.ghtk.catalog.domain.variant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Color {
	COSMIC_ORANGE("COSMIC_ORANGE"),
	DEEP_BLUE("DEEP_BLUE"),
	SILVER("SILVER"),
	BLACK_TITAN("BLACK_TITAN"),
		;

	private final String name;
}
