package com.logical.if_else;

public class Bb {

    public static void main(String[] args) {
        Aa m = new Aa();
        m.setX(10);

        Aa same = m.self();
        System.out.println(same.x);        // 10
        System.out.println(same == m);     // true -> both references point to ONE object
    }
}
