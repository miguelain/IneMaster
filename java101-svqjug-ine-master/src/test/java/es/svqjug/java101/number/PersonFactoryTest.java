package es.svqjug.java101.number;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonFactoryTest {
    @Test
    public void whenCreateAStudentTheNameStartForStudent() {
        //when
        Student101 student = PersonFactory.new101Student();

        //then
        assertThat(student.getName()).startsWith("student-");
    }

    @Test
    public void whenCreateAPersonTheNameStartForPerson() {
        //when
        Person person = PersonFactory.newPerson();

        //then
        assertThat(person.getName()).startsWith("person-");
    }
}