package org.spring.context;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.spring.context")
public class ContextConfig {

    @Bean
    public Logger logger(){
        return Logger.getLogger(ContextConfig.class);
    }

}
