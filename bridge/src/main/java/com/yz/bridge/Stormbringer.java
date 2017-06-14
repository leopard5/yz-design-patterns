package com.yz.bridge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * Stormbringer
 *
 */
public class Stormbringer extends SoulEatingMagicWeaponImpl {

  private static final Logger LOGGER = LoggerFactory.getLogger(Stormbringer.class);

  @Override
  public void wieldImp() {
    LOGGER.info("wielding Stormbringer");
  }

  @Override
  public void swingImp() {
    LOGGER.info("swinging Stormbringer");
  }

  @Override
  public void unwieldImp() {
    LOGGER.info("unwielding Stormbringer");
  }

  @Override
  public void eatSoulImp() {
    LOGGER.info("Stormbringer devours the enemy's soul");
  }
}
