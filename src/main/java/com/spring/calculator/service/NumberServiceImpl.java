package com.spring.calculator.service;

import com.spring.calculator.model.Number;
import com.spring.calculator.model.NumberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
//@Service - sluoksnis skirtas 'verslo' logikai
//po serviso sluoksniu kreipiames i DB aka DAO
@Service
public class NumberServiceImpl implements NumberService {

    //@Autowired naudoajma autoamtine priklausomybiu injekcijai(IOC - inversion of control)
    //Kad panaudoti @Autowired anotacija pirmiausia reikia tureti apsirasius @Bean @Configuraction klase
    @Autowired
    //@Qualifier anotacija kartu su @Autowired patikslina su kuriuo konkreciai Bean susieti priklausomybe
    //Jeigu @Configuration klaseje yra daugiau negu vienas Bean, @Qualifier anotacija yra privaloma
    //Kitu atveju metama klaida -
    // 'Consider marking one of the beans as @Primary, updating the consumer to accept multiple beans,
    // or using @Qualifier to identify the bean that should be consumed'
    @Qualifier("NumberDAO")
    private NumberDAO numberDAO;
    @Override
    public void insert(Number number) {
        numberDAO.insertEntity(number);

    }

    @Override
    public Number getById(int id) {

        return numberDAO.findEntityById(id);
    }

    @Override
    public List<Number> getAll() {
        return numberDAO.findEntities();
    }

    @Override
    public void update(Number number) {
        numberDAO.updateEntity(number);

    }

    @Override
    public void delete(int id) {
        numberDAO.removeEntityById(id);

    }
}
