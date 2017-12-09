package com.stuff.java.mailsender.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MailSentStatus {

    private final String status;

    public MailSentStatus(String status) {
        this.status = status;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }
}
