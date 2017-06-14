package com.yz.flyweight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * InvisibilityPotion
 *
 */
public class InvisibilityPotion implements Potion {

  private static final Logger LOGGER = LoggerFactory.getLogger(InvisibilityPotion.class);

  @Override
  public void drink() {
    LOGGER.info("You become invisible. (Potion={})", System.identityHashCode(this));
  }
}
