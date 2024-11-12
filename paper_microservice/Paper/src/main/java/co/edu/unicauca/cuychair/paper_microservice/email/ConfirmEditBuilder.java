package co.edu.unicauca.cuychair.paper_microservice.email;

import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.email.Recipient;
import org.simplejavamail.email.EmailBuilder;

/**
 * Clase concreta para crear un Email que confirme la edición de un Paper a su autor
 *
 * */

public class ConfirmEditBuilder extends Builder {


    @Override
    public Email senderAndReceptor() {
        this.email=EmailBuilder.startingBlank().from("Notificaciones cuyChair","cuychair@gmail.com").to(paper.getAuthor().getName(),paper.getAuthor().getEmail()).buildEmail();
        return email;
    }

    @Override
    public Email subjectAndBody() {
        String nombreDestino="";
        String direccionDestino="";
        for (Recipient recipient : email.getRecipients()) {
            nombreDestino = recipient.getName();
            direccionDestino= recipient.getAddress();
        }
        this.email=EmailBuilder.startingBlank().from(email.getFromRecipient().getName(),email.getFromRecipient().getAddress()).to(nombreDestino,direccionDestino)
                .withSubject("Notificación edición de Trabajo")
                .withPlainText("Estimado Autor "+paper.getAuthor().getName()+"CurChair le informa que las modificaciones de su trabajo "+paper.getTitle()+"\n ,Perteneciente a la Conferencia "
                        +paper.getConference().getTitle()+", fueron recibidas con éxito \n\n Por favor no contestar a este correo, cuyChair le desea un buen dia")
                .buildEmail();
        return email;
    }

}
