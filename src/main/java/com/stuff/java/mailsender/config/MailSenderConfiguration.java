package com.stuff.java.mailsender.config;

import com.stuff.java.mailsender.domain.MailServerDescription;
import com.stuff.java.mailsender.process.MailSendCommand;
import com.stuff.java.mailsender.services.MailServerResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.util.Set;
import java.util.stream.Collectors;

@Configuration
public class MailSenderConfiguration {

    @Autowired
    private AppSettings appSettings;

    @Bean
    public MailServerResolver mailServerResolver() {
        Set<MailServerDescription> servers = appSettings.getTrustedDomains().stream()
                .map(MailServerDescription::parse)
                .collect(Collectors.toSet());
        return new MailServerResolver(servers);
    }

    @Bean
    public MailSendCommand mailSendCommand(MailServerResolver mailServerResolver) {
        return new MailSendCommand(mailServerResolver);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
