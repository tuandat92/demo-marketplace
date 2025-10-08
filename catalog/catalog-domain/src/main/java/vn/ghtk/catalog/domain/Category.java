package vn.ghtk.catalog.domain;

public class Category {
	private String name;
	private String properties;

	public Category(String name, String properties) {
		this.name = name;
		this.properties = properties;
	}

	String name() {
		return this.name;
	}

	String properties() {
		return this.properties;
	}
}
