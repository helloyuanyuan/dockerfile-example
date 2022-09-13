package com.solera.global.qa.junit5test.common.lifecycle;

import java.util.logging.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public interface LifeCycleLogger {

  static final Logger logger = Logger.getLogger(LifeCycleLogger.class.getName());

  @BeforeAll
  default void beforeAllTests(TestInfo testInfo) {
    logger.info(() -> "####################### TEST SUITE START #######################");
    logger.info(() -> String.format("Test Suite: [%s]", testInfo.getDisplayName()));
    logger.info(() -> "################################################################\n");
  }

  @AfterAll
  default void afterAllTests(TestInfo testInfo) {
    logger.info(() -> "######################## TEST SUITE END ########################");
    logger.info(() -> String.format("Test Suite: [%s]", testInfo.getDisplayName()));
    logger.info(() -> "################################################################\n");
  }

  @BeforeEach
  default void beforeEachTest(TestInfo testInfo) {
    logger.info(() -> "----------------------- TEST CASE START ------------------------");
    logger.info(() -> String.format("About to execute [%s]", testInfo.getDisplayName()));
    logger.info(() -> "----------------------------------------------------------------");
  }

  @AfterEach
  default void afterEachTest(TestInfo testInfo) {
    logger.info(() -> "------------------------ TEST CASE END -------------------------");
    logger.info(() -> String.format("Finished executing [%s]", testInfo.getDisplayName()));
    logger.info(() -> "----------------------------------------------------------------\n");
  }
}
