package com.stuff.java.mailsender.services;

import com.stuff.java.mailsender.domain.MailServerDescription;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MailServerResolver {

    private final Map<String, MailServerDescription> servers;

    public MailServerResolver(Set<MailServerDescription> servers) {
        this.servers = servers.stream().collect(Collectors.toMap(MailServerDescription::getDomainKey, Function.identity()));
    }

    public Optional<MailServerDescription> resolveSmptHost(String domainKey) {
        return Optional.ofNullable(servers.get(domainKey));
    }
}
