package io.github.org4j.error.fixtures.complete;

import io.github.org4j.error.StatusThrowable;

public enum DemoExceptionStatus implements StatusThrowable {
  DEMO_FAILED {
    @Override
    public String getType() {
      return name();
    }
  }
}
