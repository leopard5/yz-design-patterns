package com.yz.composite;

import java.util.List;

/**
 * Sentence
 */
public class Sentence extends LetterComposite {

    /**
     * Constructor
     */
    public Sentence(List<Word> words) {
        for (Word w : words) {
            this.add(w);
        }
    }

    @Override
    protected void printThisBefore() {
        // nop
    }

    @Override
    protected void printThisAfter() {
        System.out.print(".");
    }
}
