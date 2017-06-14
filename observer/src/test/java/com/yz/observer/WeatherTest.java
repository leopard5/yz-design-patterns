package com.yz.observer;

import com.yz.observer.utils.InMemoryAppender;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

/**
 * Date: 12/27/15 - 11:08 AM
 *
 * @author Jeroen Meulemeester
 */
public class WeatherTest {

  private InMemoryAppender appender;

  @Before
  public void setUp() {
    appender = new InMemoryAppender(Weather.class);
  }

  @After
  public void tearDown() {
    appender.stop();
  }

  /**
   * Add a {@link WeatherObserver}, verify if it gets notified of a weather change, remove the
   * observer again and verify that there are no more notifications.
   */
  @Test
  public void testAddRemoveObserver() {
    final WeatherObserver observer = mock(WeatherObserver.class);

    final Weather weather = new Weather();
    weather.addObserver(observer);
    verifyZeroInteractions(observer);

    weather.timePasses();
    assertEquals("The weather changed to rainy.", appender.getLastMessage());
    verify(observer).update(WeatherType.RAINY);

    weather.removeObserver(observer);
    weather.timePasses();
    assertEquals("The weather changed to windy.", appender.getLastMessage());

    verifyNoMoreInteractions(observer);
    assertEquals(2, appender.getLogSize());
  }

  /**
   * Verify if the weather passes in the order of the {@link WeatherType}s
   */
  @Test
  public void testTimePasses() {
    final WeatherObserver observer = mock(WeatherObserver.class);
    final Weather weather = new Weather();
    weather.addObserver(observer);

    final InOrder inOrder = inOrder(observer);
    final WeatherType[] weatherTypes = WeatherType.values();
    for (int i = 1; i < 20; i++) {
      weather.timePasses();
      inOrder.verify(observer).update(weatherTypes[i % weatherTypes.length]);
    }

    verifyNoMoreInteractions(observer);
  }

}
