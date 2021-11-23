package by.itacademy.javaenterprise.seledsova.dao;

import by.itacademy.javaenterprise.seledsova.dao.impl.PersonDaoImpl;
import by.itacademy.javaenterprise.seledsova.entity.Person;
import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

public class PersonDaoTest {

    private EntityManager entityManagerMock;
    private EntityTransaction entityTransactionMock;
    private PersonDao personDao;

    @BeforeEach
    public void setUpBeforeEachTest() {
        entityManagerMock = Mockito.mock(EntityManager.class);
        entityTransactionMock = Mockito.mock(EntityTransaction.class);
        personDao = new PersonDaoImpl(entityManagerMock);
    }

    @Test
    void shouldFindPersonByIdTest() {
        Person person = new Person();
        Long id = 1L;
        person.setId(id);
        when(entityManagerMock.find(Person.class, id)).thenReturn(person);
        assertEquals(id, personDao.findPersonById(id).getId());
    }

    @Test
    void shouldFindPersonWithWrongIdTest() {
        Long id = -1L;
        assertNull(personDao.findPersonById(id));
    }

    @Test
    public void shouldSavePassportTest() {
        Long id = 4L;
        Person person = new Person();
        person.setId(4L);
        person.setFirstName("Vika");
        person.setLastName("Soroka");
        person.setPatronymic("Victorovna");
        when(entityManagerMock.find(Person.class, id)).thenReturn(person);
        assertEquals(person.getId(), id);
    }

    @After
    public void tearDown() throws Exception {
        entityManagerMock.close();
    }
}
