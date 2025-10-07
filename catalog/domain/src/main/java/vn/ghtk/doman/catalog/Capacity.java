package vn.ghtk.doman.catalog;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Capacity {
	GB_256("256GB"),
	GB_512("512GB"),
	T_1("1T"),
	;

	private final String name;
}
