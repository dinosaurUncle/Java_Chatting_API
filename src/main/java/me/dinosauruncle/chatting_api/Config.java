package me.dinosauruncle.chatting_api;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;
import java.util.Map;

@EnableJpaRepositories(basePackages = "me.dinosauruncle.chatting_api")
@Configuration
public class Config {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public Map<String, Object> parameterMap() {return new HashMap<String, Object>();}

    @Bean
    public ProxyFactoryBean proxyFactoryBean() { return new ProxyFactoryBean();}

}
