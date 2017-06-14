package com.yz.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Device class (adaptee in the pattern). We want to reuse this class
 *
 */
public class FishingBoat {

  private static final Logger LOGGER = LoggerFactory.getLogger(FishingBoat.class);

  public void sail() {
    LOGGER.info("The Boat is moving to that place");
  }

  public void fish() {
    LOGGER.info("fishing ...");
  }

}
