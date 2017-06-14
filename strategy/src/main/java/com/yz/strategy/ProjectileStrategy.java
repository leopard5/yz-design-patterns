package com.yz.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * Projectile strategy.
 *
 */
public class ProjectileStrategy implements DragonSlayingStrategy {

  private static final Logger LOGGER = LoggerFactory.getLogger(ProjectileStrategy.class);

  @Override
  public void execute() {
    LOGGER.info("You shoot the dragon with the magical crossbow and it falls dead on the ground!");
  }
}
