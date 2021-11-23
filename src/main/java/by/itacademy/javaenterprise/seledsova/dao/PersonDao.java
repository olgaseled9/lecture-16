package by.itacademy.javaenterprise.seledsova.dao;

import by.itacademy.javaenterprise.seledsova.entity.Person;

public interface PersonDao {

    Person savePerson(Person person);

    Person findPersonById(long id);

}
