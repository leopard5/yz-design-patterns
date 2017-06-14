package com.yz.bridge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * Excalibur
 *
 */
public class Excalibur extends BlindingMagicWeaponImpl {

  private static final Logger LOGGER = LoggerFactory.getLogger(Excalibur.class);

  @Override
  public void wieldImp() {
    LOGGER.info("wielding Excalibur");
  }

  @Override
  public void swingImp() {
    LOGGER.info("swinging Excalibur");
  }

  @Override
  public void unwieldImp() {
    LOGGER.info("unwielding Excalibur");
  }

  @Override
  public void blindImp() {
    LOGGER.info("bright light streams from Excalibur blinding the enemy");
  }
}
