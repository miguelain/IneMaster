package es.svqjug.java101.number;

public class Person {
    private String name;
    static Integer numberOfPerson = 0;

    public Person (String nombre) {
        numberOfPerson++;
        name = nombre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
