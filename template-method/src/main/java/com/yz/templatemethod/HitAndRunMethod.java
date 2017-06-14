package com.yz.templatemethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * HitAndRunMethod implementation of {@link StealingMethod}.
 *
 */
public class HitAndRunMethod extends StealingMethod {

  private static final Logger LOGGER = LoggerFactory.getLogger(HitAndRunMethod.class);

  @Override
  protected String pickTarget() {
    return "old goblin woman";
  }

  @Override
  protected void confuseTarget(String target) {
    LOGGER.info("Approach the {} from behind.", target);
  }

  @Override
  protected void stealTheItem(String target) {
    LOGGER.info("Grab the handbag and run away fast!");
  }
}
