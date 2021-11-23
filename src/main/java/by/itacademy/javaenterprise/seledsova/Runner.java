package by.itacademy.javaenterprise.seledsova;

import by.itacademy.javaenterprise.seledsova.dao.PassportDao;
import by.itacademy.javaenterprise.seledsova.dao.PersonDao;
import by.itacademy.javaenterprise.seledsova.dao.impl.PassportDaoImpl;
import by.itacademy.javaenterprise.seledsova.dao.impl.PersonDaoImpl;
import by.itacademy.javaenterprise.seledsova.util.FlywayUtil;
import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Runner {

    private static final Logger logger = LoggerFactory.getLogger(Runner.class);

    public static void main(String[] args) {
        try {
            FlywayUtil.cleanMigration();
            FlywayUtil.updateMigration();
            PersonDao personDao = new PersonDaoImpl();
            personDao.findPersonById(3);
            PassportDao passportDao = new PassportDaoImpl();
            passportDao.findPassportById(3);
        } catch (HibernateException e) {
            logger.error(e.getMessage(), e);
        }
    }
}
