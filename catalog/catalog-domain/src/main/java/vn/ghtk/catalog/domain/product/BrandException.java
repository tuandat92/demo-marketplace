package vn.ghtk.catalog.domain.product;

import vn.ghtk.catalog.domain.common.ErrorMessage;

public class BrandException extends RuntimeException {
  public BrandException(String message) {
    super(message);
  }

  public BrandException(ErrorMessage errorMessage) {
    super(errorMessage.message());
  }
}
