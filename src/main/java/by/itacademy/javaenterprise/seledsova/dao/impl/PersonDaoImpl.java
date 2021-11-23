package by.itacademy.javaenterprise.seledsova.dao.impl;

import by.itacademy.javaenterprise.seledsova.dao.PersonDao;
import by.itacademy.javaenterprise.seledsova.entity.Person;
import by.itacademy.javaenterprise.seledsova.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;

public class PersonDaoImpl implements PersonDao {

    private static final Logger logger = LoggerFactory.getLogger(PassportDaoImpl.class);
    private EntityManager entityManager;

    public PersonDaoImpl() {
    }

    public PersonDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Person savePerson(Person person) {
        entityManager = HibernateUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(person);
            entityManager.getTransaction().commit();
            return person;
        } catch (HibernateException e) {
            entityManager.getTransaction().rollback();
            logger.error("Not able to add  " + person.getClass().getName());
        } finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public Person findPersonById(long id) {
        entityManager = HibernateUtil.getEntityManager();
        Person person = new Person();
        try {
            entityManager.getTransaction().begin();
            person = entityManager.find(Person.class, id);
            entityManager.getTransaction().commit();
        } catch (HibernateException e) {
            entityManager.getTransaction().rollback();
            logger.error("Not able to find  " + person.getClass().getName());
        } finally {
            entityManager.close();
        }
        return person;
    }
}

