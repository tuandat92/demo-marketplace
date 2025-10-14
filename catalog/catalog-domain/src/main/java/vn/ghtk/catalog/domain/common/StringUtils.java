package vn.ghtk.catalog.domain.common;

public class StringUtils {
	public static String clean(String input) {
		if (input == null) {
			return null;
		}
		return input.trim().replaceAll("\\s+", " ");
	}

	public static boolean isNullOrBlank(String input) {
		return input == null || input.isBlank();
	}
}
