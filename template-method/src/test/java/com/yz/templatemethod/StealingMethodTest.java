package com.yz.templatemethod;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Date: 12/30/15 - 18:12 PM
 *
 * @author Jeroen Meulemeester
 */
public abstract class StealingMethodTest<M extends StealingMethod> {

  private InMemoryAppender appender;

  @Before
  public void setUp() {
    appender = new InMemoryAppender();
  }

  @After
  public void tearDown() {
    appender.stop();
  }

  /**
   * The tested stealing method
   */
  private final M method;

  /**
   * The expected target
   */
  private final String expectedTarget;

  /**
   * The expected target picking result
   */
  private final String expectedTargetResult;

  /**
   * The expected confusion method
   */
  private final String expectedConfuseMethod;

  /**
   * The expected stealing method
   */
  private final String expectedStealMethod;

  /**
   * Create a new test for the given stealing method, together with the expected results
   *
   * @param method                The tested stealing method
   * @param expectedTarget        The expected target name
   * @param expectedTargetResult  The expected target picking result
   * @param expectedConfuseMethod The expected confusion method
   * @param expectedStealMethod   The expected stealing method
   */
  public StealingMethodTest(final M method, String expectedTarget, final String expectedTargetResult,
                            final String expectedConfuseMethod, final String expectedStealMethod) {

    this.method = method;
    this.expectedTarget = expectedTarget;
    this.expectedTargetResult = expectedTargetResult;
    this.expectedConfuseMethod = expectedConfuseMethod;
    this.expectedStealMethod = expectedStealMethod;
  }

  /**
   * Verify if the thief picks the correct target
   */
  @Test
  public void testPickTarget() {
    assertEquals(expectedTarget, this.method.pickTarget());
  }

  /**
   * Verify if the target confusing step goes as planned
   */
  @Test
  public void testConfuseTarget() {
    assertEquals(0, appender.getLogSize());

    this.method.confuseTarget(this.expectedTarget);
    assertEquals(this.expectedConfuseMethod, appender.getLastMessage());
    assertEquals(1, appender.getLogSize());
  }

  /**
   * Verify if the stealing step goes as planned
   */
  @Test
  public void testStealTheItem() {
    assertEquals(0, appender.getLogSize());

    this.method.stealTheItem(this.expectedTarget);
    assertEquals(this.expectedStealMethod, appender.getLastMessage());
    assertEquals(1, appender.getLogSize());
  }

  /**
   * Verify if the complete steal process goes as planned
   */
  @Test
  public void testSteal() {
    this.method.steal();

    assertTrue(appender.logContains(this.expectedTargetResult));
    assertTrue(appender.logContains(this.expectedConfuseMethod));
    assertTrue(appender.logContains(this.expectedStealMethod));
    assertEquals(3, appender.getLogSize());
  }

  private class InMemoryAppender extends AppenderBase<ILoggingEvent> {
    private List<ILoggingEvent> log = new LinkedList<>();

    public InMemoryAppender() {
      ((Logger) LoggerFactory.getLogger("root")).addAppender(this);
      start();
    }

    @Override
    protected void append(ILoggingEvent eventObject) {
      log.add(eventObject);
    }

    public int getLogSize() {
      return log.size();
    }

    public String getLastMessage() {
      return log.get(log.size() - 1).getFormattedMessage();
    }

    public boolean logContains(String message) {
      return log.stream().anyMatch(event -> event.getFormattedMessage().equals(message));
    }
  }
}
