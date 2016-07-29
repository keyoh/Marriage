package ru.sbt;

public class Person {

    private final String name;

    private final boolean men;

    private Person spouse;

    public Person(String name, boolean man) {
        this.name = name;
        this.men = man;
    }


    public boolean marry(Person person) {
        if (men == person.isMen() || this.spouse == person || person == null) {
            return false;
        } else {
            if (spouse != null) {
                divorce();
            }
            this.spouse = person;
            person.marry(this);
            return true;
        }
    }


    public boolean divorce() {
        if (spouse == null) {
            return false;
        } else {
            Person exSpouse = spouse;
            spouse = null;
            exSpouse.divorce();
            return true;
        }
    }

    public boolean isMen() {
        return men;
    }

    public String getName() {
        return name;
    }

}