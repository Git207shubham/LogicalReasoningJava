package com.logical.if_else;

/*
 * ENCAPSULATION (a POJO / JavaBean):
 * - fields are private  -> nobody can change them directly
 * - access only through public getters/setters -> we can add validation in one place
 * In real projects Lombok @Data / @Getter / @Setter generates these methods.
 */
public class Whilee {

    private String name;
    private int rollno;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        if (rollno <= 0) {
            throw new IllegalArgumentException("rollno must be positive");
        }
        this.rollno = rollno;
    }
}
