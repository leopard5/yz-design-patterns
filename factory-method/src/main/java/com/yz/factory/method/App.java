package com.yz.factory.method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * The Factory Method is a creational design pattern which uses factory methods to deal with the
 * problem of creating objects without specifying the exact class of object that will be created.
 * This is done by creating objects via calling a factory method either specified in an interface
 * and implemented by child classes, or implemented in a base class and optionally overridden by
 * derived classes—rather than by calling a constructor.
 * <p>
 * In this Factory Method example we have an interface ({@link Blacksmith}) with a method for
 * creating objects ({@link Blacksmith#manufactureWeapon}). The concrete subclasses (
 * {@link OrcBlacksmith}, {@link ElfBlacksmith}) then override the method to produce objects of
 * their liking.
 * 
 */
public class App {

  private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

  private final Blacksmith blacksmith;
  
  /**
   * Creates an instance of <code>App</code> which will use <code>blacksmith</code> to manufacture 
   * the weapons for war.
   * <code>App</code> is unaware which concrete implementation of {@link Blacksmith} it is using.
   * The decision of which blacksmith implementation to use may depend on configuration, or
   * the type of rival in war.
   * @param blacksmith a non-null implementation of blacksmith
   */
  public App(Blacksmith blacksmith) {
    this.blacksmith = blacksmith;
  }
  
  /**
   * Program entry point
   * 
   * @param args command line args
   */
  public static void main(String[] args) {
    // Lets go to war with Orc weapons
    App app = new App(new OrcBlacksmith());
    app.manufactureWeapons();
    
    // Lets go to war with Elf weapons
    app = new App(new ElfBlacksmith());
    app.manufactureWeapons();
  }
  
  private void manufactureWeapons() {
    Weapon weapon;
    weapon = blacksmith.manufactureWeapon(WeaponType.SPEAR);
    LOGGER.info(weapon.toString());
    weapon = blacksmith.manufactureWeapon(WeaponType.AXE);
    LOGGER.info(weapon.toString());
  }
}
