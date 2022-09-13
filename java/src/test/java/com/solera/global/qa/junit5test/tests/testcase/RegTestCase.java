package com.solera.global.qa.junit5test.tests.testcase;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.solera.global.qa.junit5test.TestBase;
import com.solera.global.qa.junit5test.common.arguments.Languages;
import com.solera.global.qa.junit5test.common.lifecycle.LifeCycle;
import com.solera.global.qa.junit5test.common.lifecycle.LifeCycleLogger;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@LifeCycle
@Slf4j
@Tag("reg")
@DisplayName("junit.test.regression")
class RegTestCase extends TestBase implements LifeCycleLogger {

  @Execution(ExecutionMode.CONCURRENT)
  @DisplayName("ParameterizedTest - ValueSource - Strings")
  @ParameterizedTest
  @ValueSource(strings = {"a", "b", "c"})
  void valueSourceStringsTest(String value) {
    log.info("valueSourceStringsTest [{}]", value);
    assertTrue(null != value);
  }

  @Execution(ExecutionMode.CONCURRENT)
  @DisplayName("ParameterizedTest - ValueSource - Ints")
  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3})
  void valueSourceIntsTest(int value) {
    log.info("valueSourceIntsTest [{}]", value);
    assertTrue(value <= 3);
  }

  @Execution(ExecutionMode.CONCURRENT)
  @DisplayName("ParameterizedTest - ValueSource - NullAndEmptySource")
  @ParameterizedTest
  @NullAndEmptySource
  @ValueSource(strings = {"a", "b", "c"})
  void ValueSourceNullAndEmptySourceTest(String value) {
    log.info("valueSourceNullAndEmptySourceTest [{}]", value);
  }

  @Execution(ExecutionMode.CONCURRENT)
  @DisplayName("ParameterizedTest - ArgumentsSource")
  @ParameterizedTest
  @ArgumentsSource(Languages.class)
  void argumentsSourceTest(String value) {
    log.info("argumentsSourceTest [{}]", value);
    assertTrue(null != value);
  }

  static Stream<String> stringProvider() {
    return Stream.of("java", "go");
  }

  @Execution(ExecutionMode.CONCURRENT)
  @DisplayName("ParameterizedTest - MethodSource")
  @ParameterizedTest
  @MethodSource("stringProvider")
  void methodSourceTest(String value) {
    log.info("methodSourceTest [{}]", value);
  }

  @Execution(ExecutionMode.CONCURRENT)
  @DisplayName("ParameterizedTest - CsvSource")
  @ParameterizedTest
  @CsvSource(
      value = {"java, 100", "go, 100", "null, 50"},
      nullValues = "null")
  void csvSourceWithNullTest(String language, int rank) {
    log.info("csvSourceWithNullTest, language [{}], rank [{}]", language, rank);
  }
}
