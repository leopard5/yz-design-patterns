package com.yz.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Adapter class. Adapts the interface of the device ({@link FishingBoat}) into {@link BattleShip}
 * interface expected by the client ({@link Captain}). <br>
 * In this case we added a new function fire to suit the interface. We are reusing the
 * {@link FishingBoat} without changing itself. The Adapter class can just map the functions of the
 * Adaptee or add, delete features of the Adaptee.
 *
 */
public class BattleFishingBoat implements BattleShip {

  private static final Logger LOGGER = LoggerFactory.getLogger(BattleFishingBoat.class);

  private FishingBoat boat;

  public BattleFishingBoat() {
    boat = new FishingBoat();
  }

  @Override
  public void fire() {
    LOGGER.info("fire!");
  }

  @Override
  public void move() {
    boat.sail();
  }
}
