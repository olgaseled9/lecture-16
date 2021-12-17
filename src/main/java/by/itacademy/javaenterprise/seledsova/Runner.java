package by.itacademy.javaenterprise.seledsova;

import by.itacademy.javaenterprise.seledsova.dao.PassportDao;
import by.itacademy.javaenterprise.seledsova.dao.PersonDao;
import by.itacademy.javaenterprise.seledsova.dao.impl.PassportDaoImpl;
import by.itacademy.javaenterprise.seledsova.dao.impl.PersonDaoImpl;
import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Runner {

    private static final Logger logger = LoggerFactory.getLogger(Runner.class);

    public static void main(String[] args) {
        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("by.it");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            PersonDao personDao = new PersonDaoImpl(entityManager);
            logger.info("{}", personDao.findPersonById(3));
            PassportDao passportDao = new PassportDaoImpl(entityManager);
            logger.info("{}", passportDao.findPassportById(3));
        } catch (HibernateException e) {
            logger.error(e.getMessage(), e);
        }
    }
}
