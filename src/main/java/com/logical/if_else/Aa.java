package com.logical.if_else;

/*
 * TRAP QUESTION: what happens with  class Aa { Aa a = new Aa(); }  ?
 * Every new Aa() creates another Aa for its field, which creates another... forever
 * -> java.lang.StackOverflowError.
 *
 * Fix: create the object lazily (only when needed) or make it static.
 * Here we return "this" - the current object itself.
 */
public class Aa {

    int x;

    public void setX(int x) {
        this.x = x;
    }

    public Aa self() {
        return this;
    }
}
