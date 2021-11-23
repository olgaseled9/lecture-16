package by.itacademy.javaenterprise.seledsova.dao;

import by.itacademy.javaenterprise.seledsova.dao.impl.PassportDaoImpl;
import by.itacademy.javaenterprise.seledsova.entity.Passport;
import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

public class PassportDaoTest {

    private EntityManager entityManagerMock;
    private EntityTransaction entityTransactionMock;
    private PassportDao passportDao;

    @BeforeEach
    public void setUpBeforeEachTest() {
        entityManagerMock = Mockito.mock(EntityManager.class);
        entityTransactionMock = Mockito.mock(EntityTransaction.class);
        passportDao = new PassportDaoImpl(entityManagerMock);
    }

    @Test
    void shouldFindPassportByIdTest() {
        Passport passport = new Passport();
        Long id = 1L;
        passport.setPassportId(id);
        when(entityManagerMock.find(Passport.class, id)).thenReturn(passport);
        assertEquals(id, passportDao.findPassportById(id).getPassportId());
    }

    @Test
    void shouldFindPassportWithWrongIdTest() {
        Long id = -1L;
        assertNull(passportDao.findPassportById(id));
    }

    @Test
    public void shouldSavePassportTest() {
        Long id = 4L;
        Passport passport = new Passport();
        passport.setPassportId(4L);
        passport.setNumber(11114);
        when(entityManagerMock.find(Passport.class, id)).thenReturn(passport);
        assertEquals(passport.getPassportId(), id);
    }

    @After
    public void tearDown() throws Exception {
        entityManagerMock.close();
    }
}
