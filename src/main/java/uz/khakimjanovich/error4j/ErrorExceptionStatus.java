package uz.khakimjanovich.error4j;

public enum ErrorExceptionStatus implements StatusThrowable {
  INTERNAL_ERROR,
  VALIDATION_FAILED,
  UNAUTHORIZED,
  FORBIDDEN;

  @Override
  public String getType() {
    return name();
  }
}
