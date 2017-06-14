package com.yz.decorator;

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

/**
 * Tests for {@link SimpleTroll}
 */
public class SimpleTrollTest {

  private InMemoryAppender appender;

  @Before
  public void setUp() {
    appender = new InMemoryAppender(SimpleTroll.class);
  }

  @After
  public void tearDown() {
    appender.stop();
  }

  @Test
  public void testTrollActions() throws Exception {
    final SimpleTroll troll = new SimpleTroll();
    assertEquals(10, troll.getAttackPower());

    troll.attack();
    assertEquals("The troll tries to grab you!", appender.getLastMessage());

    troll.fleeBattle();
    assertEquals("The troll shrieks in horror and runs away!", appender.getLastMessage());

    assertEquals(2, appender.getLogSize());
  }

  private class InMemoryAppender extends AppenderBase<ILoggingEvent> {

    private List<ILoggingEvent> log = new LinkedList<>();

    public InMemoryAppender(Class clazz) {
      ((Logger) LoggerFactory.getLogger(clazz)).addAppender(this);
      start();
    }

    @Override
    protected void append(ILoggingEvent eventObject) {
      log.add(eventObject);
    }

    public String getLastMessage() {
      return log.get(log.size() - 1).getMessage();
    }

    public int getLogSize() {
      return log.size();
    }
  }
}
