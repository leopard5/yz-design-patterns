package com.yz.observer.generic;

import com.yz.observer.Hobbits;
import com.yz.observer.WeatherObserverTest;
import com.yz.observer.WeatherType;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Date: 12/27/15 - 12:07 PM
 *
 * @author Jeroen Meulemeester
 */
@RunWith(Parameterized.class)
public class GHobbitsTest extends ObserverTest<GHobbits> {

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    final List<Object[]> testData = new ArrayList<>();
    testData.add(new Object[]{WeatherType.SUNNY, "The happy hobbits bade in the warm sun."});
    testData.add(new Object[]{WeatherType.RAINY, "The hobbits look for cover from the rain."});
    testData.add(new Object[]{WeatherType.WINDY, "The hobbits hold their hats tightly in the windy weather."});
    testData.add(new Object[]{WeatherType.COLD, "The hobbits are shivering in the cold weather."});
    return testData;
  }

  /**
   * Create a new test with the given weather and expected response
   *
   * @param weather  The weather that should be unleashed on the observer
   * @param response The expected response from the observer
   */
  public GHobbitsTest(final WeatherType weather, final String response) {
    super(weather, response, GHobbits::new);
  }

}
