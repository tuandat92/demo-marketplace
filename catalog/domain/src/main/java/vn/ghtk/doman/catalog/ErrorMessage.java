package vn.ghtk.doman.catalog;

public enum ErrorMessage {
  PRODUCT_EXISTS("Sản phẩm đã tồn tại"),
  PRODUCT_UPDATE_NOT_EXISTS("Sản phẩm cập nhật chưa tồn tại"),
  VARIANT_UPDATE_NOT_EXISTS("Variant cập nhật chưa tồn tại"),
  ;

  ErrorMessage(String message) {
    this.message = message;
  }

  private final String message;

  public String message() {
    return message;
  }
}
