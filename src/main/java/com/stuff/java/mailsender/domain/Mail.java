package com.stuff.java.mailsender.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableSet;

import java.util.Set;

public class Mail {

    private final String domain;

    private final Account author;

    private final Set<String> recipients;

    private final String subject;

    private final String message;

    @JsonCreator
    private Mail(@JsonProperty("domain") String domain,
                 @JsonProperty("author") Account author,
                 @JsonProperty("recipients") Set<String> recipients,
                 @JsonProperty("subject") String subject,
                 @JsonProperty("message") String message) {
        this.domain = domain;
        this.author = author;
        this.recipients = recipients;
        this.subject = subject;
        this.message = message;
    }

    public String getDomain() {
        return domain;
    }

    public Account getAuthor() {
        return author;
    }

    public Set<String> getRecipients() {
        return ImmutableSet.copyOf(recipients);
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }
}
