package by.itacademy.javaenterprise.seledsova.dao;

import by.itacademy.javaenterprise.seledsova.entity.Passport;

public interface PassportDao {

    Passport savePassport(Passport passport);

    Passport findPassportById(long id);

}

