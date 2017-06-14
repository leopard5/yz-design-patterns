package com.yz.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * The object to be proxyed.
 * 
 */
public class IvoryTower implements WizardTower {

  private static final Logger LOGGER = LoggerFactory.getLogger(IvoryTower.class);

  public void enter(Wizard wizard) {
    LOGGER.info("{} enters the tower.", wizard);
  }

}
