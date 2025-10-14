package vn.ghtk.catalog.domain.product;

import vn.ghtk.catalog.domain.common.ErrorMessage;

public class ProductException extends RuntimeException {
  public ProductException(String message) {
    super(message);
  }

  public ProductException(ErrorMessage errorMessage) {
    super(errorMessage.message());
  }
}
