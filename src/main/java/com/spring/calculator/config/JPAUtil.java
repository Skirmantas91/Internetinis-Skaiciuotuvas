package com.spring.calculator.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//JPAUtil yra pagalbinė klasė, skirta padėti inicializuoti ir konfigūruoti Java Persistence API (JPA) objektų valdymo kontekstą. Ši klasė gali būti naudojama pradiniame programos paleidime, kad būtų sukurtas ir sukonfigūruotas EntityManagerFactory objektas.
public class JPAUtil {

    private static final String PERSISTENCE_UNIT_NAME = "PERSISTENCE";
    private static EntityManagerFactory entityManagerFactory;

    //entityManagerFactory per aplikacijos veikima bus tik viena (tuo tarpu sesiju gali buti labai daug)
    //entityManagerFactory veikia SINGLETON sablono(patterno)
    public static EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return entityManagerFactory;
    }

    public static void shutdown() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }
}
