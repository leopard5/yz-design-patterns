package com.yz.flyweight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * AlchemistShop holds potions on its shelves. It uses PotionFactory to provide the potions.
 * 
 */
public class AlchemistShop {

  private static final Logger LOGGER = LoggerFactory.getLogger(AlchemistShop.class);

  private List<Potion> topShelf;
  private List<Potion> bottomShelf;

  /**
   * Constructor
   */
  public AlchemistShop() {
    topShelf = new ArrayList<>();
    bottomShelf = new ArrayList<>();
    fillShelves();
  }

  private void fillShelves() {

    PotionFactory factory = new PotionFactory();

    topShelf.add(factory.createPotion(PotionType.INVISIBILITY));
    topShelf.add(factory.createPotion(PotionType.INVISIBILITY));
    topShelf.add(factory.createPotion(PotionType.STRENGTH));
    topShelf.add(factory.createPotion(PotionType.HEALING));
    topShelf.add(factory.createPotion(PotionType.INVISIBILITY));
    topShelf.add(factory.createPotion(PotionType.STRENGTH));
    topShelf.add(factory.createPotion(PotionType.HEALING));
    topShelf.add(factory.createPotion(PotionType.HEALING));

    bottomShelf.add(factory.createPotion(PotionType.POISON));
    bottomShelf.add(factory.createPotion(PotionType.POISON));
    bottomShelf.add(factory.createPotion(PotionType.POISON));
    bottomShelf.add(factory.createPotion(PotionType.HOLY_WATER));
    bottomShelf.add(factory.createPotion(PotionType.HOLY_WATER));
  }

  /**
   * Get a read-only list of all the items on the top shelf
   *
   * @return The top shelf potions
   */
  public final List<Potion> getTopShelf() {
    return Collections.unmodifiableList(this.topShelf);
  }

  /**
   * Get a read-only list of all the items on the bottom shelf
   *
   * @return The bottom shelf potions
   */
  public final List<Potion> getBottomShelf() {
    return Collections.unmodifiableList(this.bottomShelf);
  }

  /**
   * Enumerate potions
   */
  public void enumerate() {

    LOGGER.info("Enumerating top shelf potions\n");

    for (Potion p : topShelf) {
      p.drink();
    }

    LOGGER.info("Enumerating bottom shelf potions\n");

    for (Potion p : bottomShelf) {
      p.drink();
    }
  }
}
