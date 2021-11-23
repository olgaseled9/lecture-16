package by.itacademy.javaenterprise.seledsova.dao.impl;

import by.itacademy.javaenterprise.seledsova.dao.PassportDao;
import by.itacademy.javaenterprise.seledsova.entity.Passport;
import by.itacademy.javaenterprise.seledsova.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;

public class PassportDaoImpl implements PassportDao {

    private static final Logger logger = LoggerFactory.getLogger(PassportDaoImpl.class);
    private EntityManager entityManager;

    public PassportDaoImpl() {
    }

    public PassportDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Passport savePassport(Passport passport) {
        entityManager = HibernateUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(passport);
            entityManager.getTransaction().commit();
        } catch (HibernateException e) {
            entityManager.getTransaction().rollback();
            logger.error("Not able to add  " + passport.getClass().getName());
        } finally {
            entityManager.close();
        }
        return passport;
    }

    @Override
    public Passport findPassportById(long id) {
        Passport passport = new Passport();
        entityManager = HibernateUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            passport = entityManager.find(Passport.class, id);
            entityManager.getTransaction().commit();
        } catch (HibernateException e) {
            entityManager.getTransaction().rollback();
            logger.error("Not able to find  " + passport.getClass().getName());
        } finally {
            entityManager.close();
        }
        return passport;
    }
}

