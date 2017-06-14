package com.yz.observer.generic;

import com.yz.observer.WeatherType;
import com.yz.observer.utils.InMemoryAppender;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.function.Supplier;

import static org.junit.Assert.assertEquals;

/**
 * Date: 12/27/15 - 11:44 AM
 *
 * @author Jeroen Meulemeester
 */
public abstract class ObserverTest<O extends Observer> {

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
   * The observer instance factory
   */
  private final Supplier<O> factory;

  /**
   * The weather type currently tested
   */
  private final WeatherType weather;

  /**
   * The expected response from the observer
   */
  private final String response;

  /**
   * Create a new test instance using the given parameters
   *
   * @param weather  The weather currently being tested
   * @param response The expected response from the observer
   * @param factory  The factory, used to create an instance of the tested observer
   */
  ObserverTest(final WeatherType weather, final String response, final Supplier<O> factory) {
    this.weather = weather;
    this.response = response;
    this.factory = factory;
  }

  /**
   * Verify if the weather has the expected influence on the observer
   */
  @Test
  public void testObserver() {
    final O observer = this.factory.get();
    assertEquals(0, appender.getLogSize());

    observer.update(null, this.weather);
    assertEquals(this.response, appender.getLastMessage());
    assertEquals(1, appender.getLogSize());
  }

}
