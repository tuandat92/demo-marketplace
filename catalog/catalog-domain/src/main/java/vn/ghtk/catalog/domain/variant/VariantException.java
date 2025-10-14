package vn.ghtk.catalog.domain.variant;

import vn.ghtk.catalog.domain.common.ErrorMessage;

public class VariantException extends RuntimeException {
  public VariantException(String message) {
    super(message);
  }

  public VariantException(ErrorMessage errorMessage) {
    super(errorMessage.message());
  }
}
