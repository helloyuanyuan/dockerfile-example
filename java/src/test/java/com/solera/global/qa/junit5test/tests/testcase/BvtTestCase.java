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

@SpringBootTest
@LifeCycle
@Slf4j
@Tag("bvt")
@DisplayName("junit.test.bvt")
class BvtTestCase extends TestBase implements LifeCycleLogger {

  @DisplayName("bvtTest")
  @Test
  void bvtTest() {
    log.info("execute bvtTest");
    assertThat("hello world").isEqualTo(MSG);
  }

  @DisplayName("disableTest")
  @Test
  @Disabled
  void disableTest() {
    log.info("execute disableTest");
  }

  @Test
  @Timeout(unit = TimeUnit.MILLISECONDS, value = 2000)
  void timeoutTest() throws InterruptedException {
    log.info("execute timeoutTest");
    Thread.sleep(1000);
  }
}
