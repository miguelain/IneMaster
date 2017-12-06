package es.svqjug.java101.number;

public class Student101 extends Person {

    static Integer numberOfStudent = 0;

    public Student101(String nombre) {
        super(nombre);
        numberOfStudent++;
    }
}
