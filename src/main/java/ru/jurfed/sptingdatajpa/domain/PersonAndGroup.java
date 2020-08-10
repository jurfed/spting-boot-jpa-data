package ru.jurfed.sptingdatajpa.domain;

import javax.persistence.Entity;

public class PersonAndGroup {
    private String name;
    private int count;

    public PersonAndGroup(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "PersonAndGroup{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
