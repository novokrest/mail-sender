package com.stuff.java.mailsender.process;


import com.stuff.java.mailsender.domain.Account;
import com.stuff.java.mailsender.domain.Mail;
import com.stuff.java.mailsender.domain.MailSentStatus;
import com.stuff.java.mailsender.domain.MailServerDescription;
import com.stuff.java.mailsender.services.MailServerResolver;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.Optional;

public class MailSendCommand {

    private final MailServerResolver mailServerResolver;

    public MailSendCommand(@Nonnull MailServerResolver mailServerResolver) {
        this.mailServerResolver = Objects.requireNonNull(mailServerResolver);
    }

    public MailSentStatus execute(Mail mail) {
        Optional<MailServerDescription> mailServer = mailServerResolver.resolveSmptHost(mail.getDomain());
        if (!mailServer.isPresent()) {
            return new MailSentStatus("Failed: could not resolve domain: " + mail.getDomain());
        }
        try {
            sendMail(mail, mailServer.get());
            return new MailSentStatus("Success");
        } catch (EmailException e) {
            e.printStackTrace();
            return new MailSentStatus("Failed: " + e.getMessage());
        }
    }

    private void sendMail(Mail mail, MailServerDescription mailServer) throws EmailException {
        Email email = new SimpleEmail();

        email.setHostName(mailServer.getSmtpHost());
        email.setSmtpPort(mailServer.getPort());
        email.setSSLOnConnect(true);
        email.setStartTLSEnabled(true);

        Account author = mail.getAuthor();
        email.setAuthenticator(new DefaultAuthenticator(author.getEmail(), author.getPassword()));
        email.setFrom(author.getEmail());

        for (String recipient : mail.getRecipients()) {
            email.addTo(recipient);
        }

        email.setSubject(mail.getSubject());
        email.setMsg(mail.getMessage());

        email.send();
    }
}
