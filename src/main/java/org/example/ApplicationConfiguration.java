package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
    @Bean
    Book book() {
        return new Book(" One Hundred Years of Solitude");
    }
}
