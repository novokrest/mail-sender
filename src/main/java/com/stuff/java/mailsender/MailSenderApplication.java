package com.stuff.java.mailsender;

import com.stuff.java.mailsender.config.AppSettings;
import com.stuff.java.mailsender.config.MailSenderConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@Import({
		MailSenderConfiguration.class,
		AppSettings.class
})
@SpringBootApplication
public class MailSenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailSenderApplication.class, args);
	}
}
