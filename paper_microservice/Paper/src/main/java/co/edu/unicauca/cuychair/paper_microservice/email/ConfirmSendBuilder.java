package co.edu.unicauca.cuychair.paper_microservice.email;

import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.email.Recipient;
import org.simplejavamail.email.EmailBuilder;


/**
 * Clase concreta para crear un Email que confirme la subida de un Paper a su autor
 *
 * */
public class ConfirmSendBuilder extends Builder {

    private String htmlText;

    @Override
    public Email senderAndReceptor() {
        this.email=EmailBuilder.startingBlank().from("Notificaciones cuyChair","cuychair@gmail.com").to(paper.getAuthor().getName(),paper.getAuthor().getEmail()).buildEmail();
        return email;
    }

    @Override
    public Email subjectAndBody() {
         htmlText="<html><body>" +
                "<h1>Estimado Autor</h1>" +
                "<p><strong>"+paper.getAuthor().getName()+" "+paper.getAuthor().getLastName()+"</strong></p>"+
                "<h3>CurChair confirma la entrega de su trabajo </h3>"+
                "<p><strong>"+paper.getTitle()+"</strong></p>"+
                "<h3>Perteneciente a la conferencia </h3>"+
                "<p><strong>"+paper.getConference().getTitle()+"</strong></p>"+
                "<h6>Por favor no contestar a este correo</h6>"+
                "</body></html>";
         String nombreDestino="";
        String direccionDestino="";
        for (Recipient recipient : email.getRecipients()) {
            nombreDestino = recipient.getName();
            direccionDestino= recipient.getAddress();
        }
        this.email=EmailBuilder.startingBlank().from(email.getFromRecipient().getName(),email.getFromRecipient().getAddress()).to(nombreDestino,direccionDestino)
                .withSubject("Notificación de entrega de trabajos")
                .withHTMLText(htmlText)
                .buildEmail();
        return email;
    }

}
