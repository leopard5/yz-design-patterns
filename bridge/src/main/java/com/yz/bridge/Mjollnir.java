package com.yz.bridge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * Mjollnir
 *
 */
public class Mjollnir extends FlyingMagicWeaponImpl {

  private static final Logger LOGGER = LoggerFactory.getLogger(Mjollnir.class);

  @Override
  public void wieldImp() {
    LOGGER.info("wielding Mjollnir");
  }

  @Override
  public void swingImp() {
    LOGGER.info("swinging Mjollnir");
  }

  @Override
  public void unwieldImp() {
    LOGGER.info("unwielding Mjollnir");
  }

  @Override
  public void flyImp() {
    LOGGER.info("Mjollnir hits the enemy in the air and returns back to the owner's hand");
  }
}
