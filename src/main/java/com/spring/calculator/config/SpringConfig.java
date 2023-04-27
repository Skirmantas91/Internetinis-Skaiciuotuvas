package com.spring.calculator.config;

import com.spring.calculator.model.NumberDAO;
import com.spring.calculator.model.NumberDAOImpl;
import com.spring.calculator.service.NumberService;
import com.spring.calculator.service.NumberServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration - anotacija zyminti konfiguracijos komponeneta
//Viduje leidzia kurti Bean per metodus su @Bean anotacija
@Configuration
public class SpringConfig {
    //Bea n - tai objektai kurie sudaro Spring aplikacijos pagrinda
    //Paprastai tai JAVA klase realizuojanti tam tikrai interfeisa ir java bean specifikacija
    //Bean atitinka SINGLETON sablona - programines irangos projektavimo schema,
    //kuri riboja klases ivykdyma vienu vieninteliu egzemplioriumi
    //tai naudinga, kai reikia tikslaii vieno objekto norint koordinuoti veiksmus visoje sistemoje
    @Bean
    ////@Qualifier anotacija kartu su @Autowired patikslina su kuriuo konkreciai Bean susieti priklausomybe
    //    //Jeigu @Configuration klaseje yra daugiau negu vienas Bean, @Qualifier anotacija yra privaloma
    //    //Kitu atveju metama klaida -
    //    // 'Consider marking one of the beans as @Primary, updating the consumer to accept multiple beans,
    //    // or using @Qualifier to identify the bean that should be consumed'
    @Qualifier("NumberDAO")

    public NumberDAO getNumberDAO(){
        return new NumberDAOImpl();
    }

    @Bean
    @Qualifier("NumberService")
    public NumberService getNumberService(){
        return new NumberServiceImpl();
    }

}
