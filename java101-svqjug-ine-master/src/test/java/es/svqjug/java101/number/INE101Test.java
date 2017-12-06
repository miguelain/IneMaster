package es.svqjug.java101.number;

import org.junit.Test;

// import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

public class INE101Test {

    @Test
    public void whenNoPersonAreCreatedThenInINE101AreCreated0Person() {

        //when
        Integer numberOfPerson = INE101.getNumberOfPerson();

        //then
        assertThat(numberOfPerson).isEqualTo(0);
    }

    @Test
    public void whenOnePersonAreCreatedThenInINE101AreCreated1Person() {
        //given
        PersonFactory.newPerson();

        //when
        Integer numberOfPerson = INE101.getNumberOfPerson();

        //then
        assertThat(numberOfPerson).isEqualTo(1);
    }

    @Test
    public void whenNoStudentAreCreatedThenInINE101AreCreated0Student() {

        //when
        Integer numberOfStudent = INE101.getNumberOfStudent();

        //then
        assertThat(numberOfStudent).isEqualTo(0);
    }

    @Test
    public void whenOneStudentAreCreatedThenInINE101AreCreated1Student() {
        //given
        PersonFactory.new101Student();

        //when
        Integer numberOfStudent = INE101.getNumberOfStudent();

        //then
        assertThat(numberOfStudent).isEqualTo(1);
    }

    @Test
    public void whenOnePersonAreCreatedThenInINE101AreCreated0Student() {
        //given
        PersonFactory.newPerson();

        //when
        Integer numberOfStudent = INE101.getNumberOfStudent();

        //then
        assertThat(numberOfStudent).isEqualTo(0);
    }

    @Test
    public void whenOneStudentAreCreatedThenInINE101AreCreated1Person() {
        //given
        PersonFactory.new101Student();

        //when
        Integer numberOfPerson = INE101.getNumberOfPerson();

        //then
        assertThat(numberOfPerson).isEqualTo(1);
    }
}