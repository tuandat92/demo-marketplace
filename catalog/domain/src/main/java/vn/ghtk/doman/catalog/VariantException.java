package vn.ghtk.doman.catalog;

public class VariantException extends RuntimeException {
  public VariantException(String message) {
    super(message);
  }

  public VariantException(ErrorMessage errorMessage) {
    super(errorMessage.message());
  }
}
