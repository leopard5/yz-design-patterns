package com.yz.state;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * Peaceful state.
 *
 */
public class PeacefulState implements State {

  private static final Logger LOGGER = LoggerFactory.getLogger(PeacefulState.class);

  private Mammoth mammoth;

  public PeacefulState(Mammoth mammoth) {
    this.mammoth = mammoth;
  }

  @Override
  public void observe() {
    LOGGER.info("{} is calm and peaceful.", mammoth);
  }

  @Override
  public void onEnterState() {
    LOGGER.info("{} calms down.", mammoth);
  }

}
