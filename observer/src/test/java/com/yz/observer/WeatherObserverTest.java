package com.yz.observer;

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
public abstract class WeatherObserverTest<O extends WeatherObserver> {

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
  WeatherObserverTest(final WeatherType weather, final String response, final Supplier<O> factory) {
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

    observer.update(this.weather);
    assertEquals(response, appender.getLastMessage());
    assertEquals(1, appender.getLogSize());
  }

}
