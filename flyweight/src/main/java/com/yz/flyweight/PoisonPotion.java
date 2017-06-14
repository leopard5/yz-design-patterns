package com.yz.flyweight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * PoisonPotion
 *
 */
public class PoisonPotion implements Potion {

  private static final Logger LOGGER = LoggerFactory.getLogger(PoisonPotion.class);

  @Override
  public void drink() {
    LOGGER.info("Urgh! This is poisonous. (Potion={})", System.identityHashCode(this));
  }
}
