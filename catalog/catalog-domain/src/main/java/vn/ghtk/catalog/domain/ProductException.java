package vn.ghtk.catalog.domain;

public class ProductException extends RuntimeException {
  public ProductException(String message) {
    super(message);
  }

  public ProductException(ErrorMessage errorMessage) {
    super(errorMessage.message());
  }
}
