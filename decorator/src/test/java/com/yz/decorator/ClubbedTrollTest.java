package com.yz.decorator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * Tests for {@link ClubbedTroll}
 */
public class ClubbedTrollTest {

  @Test
  public void testSmartHostile() throws Exception {
    // Create a normal troll first, but make sure we can spy on it later on.
    final Troll simpleTroll = spy(new SimpleTroll());

    // Now we want to decorate the troll to make it stronger ...
    final Troll clubbed = new ClubbedTroll(simpleTroll);
    assertEquals(20, clubbed.getAttackPower());
    verify(simpleTroll, times(1)).getAttackPower();

    // Check if the clubbed troll actions are delegated to the decorated troll
    clubbed.attack();
    verify(simpleTroll, times(1)).attack();

    clubbed.fleeBattle();
    verify(simpleTroll, times(1)).fleeBattle();
    verifyNoMoreInteractions(simpleTroll);
  }
}
