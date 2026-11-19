package uz.khakimjanovich.error4j.fixtures.complete;

import uz.khakimjanovich.error4j.StatusThrowable;

public enum DemoExceptionStatus implements StatusThrowable {
  DEMO_FAILED {
    @Override
    public String getType() {
      return name();
    }
  }
}
