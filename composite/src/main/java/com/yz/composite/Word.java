package com.yz.composite;

import java.util.List;

/**
 * Word
 */
public class Word extends LetterComposite {

    /**
     * Constructor
     */
    public Word(List<Letter> letters) {
        for (Letter l : letters) {
            this.add(l);
        }
    }

    @Override
    protected void printThisBefore() {
        System.out.print(" ");
    }

    @Override
    protected void printThisAfter() {
        // nop
    }
}
