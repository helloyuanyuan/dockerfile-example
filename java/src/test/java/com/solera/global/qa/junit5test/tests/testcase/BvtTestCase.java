package com.solera.global.qa.junit5test.tests.testcase;

import static org.assertj.core.api.Assertions.assertThat;

import com.solera.global.qa.junit5test.TestBase;
import com.solera.global.qa.junit5test.common.lifecycle.LifeCycle;
import com.solera.global.qa.junit5test.common.lifecycle.LifeCycleLogger;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.springframework.boot.test.context.SpringBootTest;

@DisplayName("junit.test.bvt")
@Tag("bvt")
@SpringBootTest
@LifeCycle
@Slf4j
class BvtTestCase extends TestBase implements LifeCycleLogger {

  @DisplayName("bvtTest")
  @Tag("bvt1")
  @Test
  void bvtTest() {
    log.info("execute bvtTest");
    log.info(MSG);
    assertThat("hello world").isSubstringOf(MSG);
  }

  @DisplayName("disableTest")
  @Tag("bvt2")
  @Test
  @Disabled
  void disableTest() {
    log.info("execute disableTest");
  }

  @DisplayName("timeoutTest")
  @Tag("bvt3")
  @Test
  @Timeout(unit = TimeUnit.MILLISECONDS, value = 2000)
  void timeoutTest() throws InterruptedException {
    log.info("execute timeoutTest");
    Thread.sleep(1000);
  }
}
