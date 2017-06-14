package com.yz.mediator;

/**
 * 
 * The Mediator pattern defines an object that encapsulates how a set of objects interact. This
 * pattern is considered to be a behavioral pattern due to the way it can alter the program's
 * running behavior.
 * <p>
 * Usually a program is made up of a large number of classes. So the logic and computation is
 * distributed among these classes. However, as more classes are developed in a program, especially
 * during maintenance and/or refactoring, the problem of communication between these classes may
 * become more complex. This makes the program harder to read and maintain. Furthermore, it can
 * become difficult to change the program, since any change may affect code in several other
 * classes.
 * <p>
 * With the Mediator pattern, communication between objects is encapsulated with a mediator object.
 * Objects no longer communicate directly with each other, but instead communicate through the
 * mediator. This reduces the dependencies between communicating objects, thereby lowering the
 * coupling.
 * <p>
 * In this example the mediator encapsulates how a set of objects ({@link PartyMember}) interact.
 * Instead of referring to each other directly they use the mediator ({@link Party}) interface.
 * 
 */
public class App {

  /**
   * Program entry point
   * 
   * @param args command line args
   */
  public static void main(String[] args) {

    // create party and members
    Party party = new PartyImpl();
    Hobbit hobbit = new Hobbit();
    Wizard wizard = new Wizard();
    Rogue rogue = new Rogue();
    Hunter hunter = new Hunter();

    // add party members
    party.addMember(hobbit);
    party.addMember(wizard);
    party.addMember(rogue);
    party.addMember(hunter);

    // perform actions -> the other party members
    // are notified by the party
    hobbit.act(Action.ENEMY);
    wizard.act(Action.TALE);
    rogue.act(Action.GOLD);
    hunter.act(Action.HUNT);
  }
}
