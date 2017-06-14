package com.yz.decorator;

/**
 * TrollDecorator is a decorator for {@link Troll} objects. The calls to the {@link Troll} interface
 * are intercepted and decorated. Finally the calls are delegated to the decorated {@link Troll}
 * object.
 *
 */
public class TrollDecorator implements Troll {

  private Troll decorated;

  public TrollDecorator(Troll decorated) {
    this.decorated = decorated;
  }

  @Override
  public void attack() {
    decorated.attack();
  }

  @Override
  public int getAttackPower() {
    return decorated.getAttackPower();
  }

  @Override
  public void fleeBattle() {
    decorated.fleeBattle();
  }
}
