package com.yz.flyweight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * HolyWaterPotion
 *
 */
public class HolyWaterPotion implements Potion {

  private static final Logger LOGGER = LoggerFactory.getLogger(HolyWaterPotion.class);

  @Override
  public void drink() {
    LOGGER.info("You feel blessed. (Potion={})", System.identityHashCode(this));
  }
}
