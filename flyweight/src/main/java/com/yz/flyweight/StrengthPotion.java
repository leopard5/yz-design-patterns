package com.yz.flyweight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * StrengthPotion
 *
 */
public class StrengthPotion implements Potion {

  private static final Logger LOGGER = LoggerFactory.getLogger(StrengthPotion.class);

  @Override
  public void drink() {
    LOGGER.info("You feel strong. (Potion={})", System.identityHashCode(this));
  }
}
