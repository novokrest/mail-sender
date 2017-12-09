package com.stuff.java.mailsender.domain;

public class MailServerDescription {

    private final String domainKey;

    private final String smtpHost;

    private final int port;

    /**
     * Create {@link MailServerDescription} from raw string description
     *
     * @param description in format 'domainKey:smtpHost:port'
     *
     * @return {@link MailServerDescription}
     */
    public static MailServerDescription parse(String description) {
        String[] parts = description.split(":");
        return new MailServerDescription(parts[0], parts[1], Integer.parseInt(parts[2]));
    }

    private MailServerDescription(String domainKey, String smtpHost, int port) {
        this.domainKey = domainKey;
        this.smtpHost = smtpHost;
        this.port = port;
    }

    public String getDomainKey() {
        return domainKey;
    }

    public String getSmtpHost() {
        return smtpHost;
    }

    public int getPort() {
        return port;
    }
}
