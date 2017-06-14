package com.yz.flyweight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * HealingPotion
 *
 */
public class HealingPotion implements Potion {

  private static final Logger LOGGER = LoggerFactory.getLogger(HealingPotion.class);

  @Override
  public void drink() {
    LOGGER.info("You feel healed. (Potion={})", System.identityHashCode(this));
  }
}
