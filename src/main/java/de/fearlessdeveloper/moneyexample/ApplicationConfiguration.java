package de.fearlessdeveloper.moneyexample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public MoneyService createMoneyService() {
        return new MoneyService(null);
    }
}
