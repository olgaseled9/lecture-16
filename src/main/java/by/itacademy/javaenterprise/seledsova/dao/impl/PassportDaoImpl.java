package by.itacademy.javaenterprise.seledsova.dao.impl;

import by.itacademy.javaenterprise.seledsova.dao.PassportDao;
import by.itacademy.javaenterprise.seledsova.entity.Passport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;

public class PassportDaoImpl implements PassportDao {

    private static final Logger logger = LoggerFactory.getLogger(PassportDaoImpl.class);
    private final EntityManager entityManager;

    public PassportDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Passport savePassport(Passport passport) {
        if (passport == null) throw new IllegalArgumentException();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(passport);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            logger.error(e.getMessage(), e);
        }
        return passport;
    }

    @Override
    public Passport findPassportById(long id) {
        Passport passport = new Passport();
        try {
            passport = entityManager.find(Passport.class, id);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return passport;
    }
}

