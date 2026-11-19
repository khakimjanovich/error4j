package io.github.org4j.error;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class ErrorDefinitionsTest {

  private static void check(String fixture) {
    ErrorDefinitions.assertComplete(
        "io.github.org4j.error.fixtures." + fixture,
        "classpath*:fixtures/" + fixture + "/*-exception.yaml");
  }

  @Test
  void aCompleteDefinitionPasses() {
    assertThatCode(() -> check("complete")).doesNotThrowAnyException();
  }

  @Test
  void aMissingLanguageFails() {
    assertThatThrownBy(() -> check("missinglanguage"))
        .isInstanceOf(AssertionError.class)
        .hasMessageContaining("DEMO_FAILED");
  }

  @Test
  void aPlaceholderMissingInOneLanguageFails() {
    assertThatThrownBy(() -> check("placeholder"))
        .isInstanceOf(AssertionError.class)
        .hasMessageContaining("DEMO_FAILED");
  }

  @Test
  void aDefinitionNobodyThrowsFails() {
    assertThatThrownBy(() -> check("leftover"))
        .isInstanceOf(AssertionError.class)
        .hasMessageContaining("DEMO_GONE");
  }
}
