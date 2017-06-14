package com.yz.singleton;

/**
 * Singleton class. Eagerly initialized static instance guarantees thread safety.
 */
public final class Singleton {

  /**
   * Static to class instance of the class.
   */
  private static final Singleton INSTANCE = new Singleton();

  /**
   * Private constructor so nobody can instantiate the class.
   */
  private Singleton() {}

  /**
   * To be called by user to obtain instance of the class.
   *
   * @return instance of the singleton.
   */
  public static Singleton getInstance() {
    return INSTANCE;
  }
}
