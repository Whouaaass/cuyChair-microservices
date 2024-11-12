package co.edu.unicauca.cuychair.paper_microservice.email;

import co.edu.unicauca.cuychair.paper_microservice.domain.Paper;
import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.api.mailer.config.TransportStrategy;
import org.simplejavamail.mailer.MailerBuilder;


/**
 * Director encargado de construir el email y enviarlo
 *
 * */
public class DirectorSendEmail {
    private Builder builder;
    private Paper paper;

    public DirectorSendEmail(Builder builder, Paper paper) {
        this.builder = builder;
        this.paper = paper;
    }

    public void buildAndSend() {
        Mailer ma= MailerBuilder.withSMTPServer("smtp.gmail.com", 587, "cuychair@gmail.com", "cies amcp hfot rxhh")
                .withTransportStrategy(TransportStrategy.SMTP_TLS)
                .buildMailer();
        builder.init(paper);
        builder.senderAndReceptor();
        builder.subjectAndBody();
        ma.sendMail(builder.getEmail());
    }
}
