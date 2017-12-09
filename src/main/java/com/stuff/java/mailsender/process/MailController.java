package com.stuff.java.mailsender.process;

import com.stuff.java.mailsender.domain.Mail;
import com.stuff.java.mailsender.domain.MailSentStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class MailController {

    @Autowired
    private MailSendCommand mailSendCommand;

    @RequestMapping(method = RequestMethod.POST, path = "/send")
    public ResponseEntity<MailSentStatus> send(@RequestBody Mail mail) {
        return new ResponseEntity<>(mailSendCommand.execute(mail), HttpStatus.OK);
    }
}
