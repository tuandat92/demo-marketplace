package vn.ghtk.catalog.domain;

public class VariantException extends RuntimeException {
  public VariantException(String message) {
    super(message);
  }

  public VariantException(ErrorMessage errorMessage) {
    super(errorMessage.message());
  }
}
