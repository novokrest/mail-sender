package com.stuff.java.mailsender.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Set;

@Configuration
@PropertySource(value = "classpath:application.properties")
public class AppSettings {

    @Value("#{'${email.domains.trusted}'.split(',')}")
    private Set<String> trustedDomains;

    public Set<String> getTrustedDomains() {
        return trustedDomains;
    }
}
