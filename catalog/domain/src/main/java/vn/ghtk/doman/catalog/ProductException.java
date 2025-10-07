package vn.ghtk.doman.catalog;

public class ProductException extends RuntimeException {
  public ProductException(String message) {
    super(message);
  }

  public ProductException(ErrorMessage errorMessage) {
    super(errorMessage.message());
  }
}
