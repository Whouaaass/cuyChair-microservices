package co.edu.unicauca.cuychair.paper_microservice.email;

import co.edu.unicauca.cuychair.paper_microservice.domain.Paper;
import lombok.Getter;
import org.simplejavamail.api.email.Email;
import org.simplejavamail.email.EmailBuilder;

/**
 * Clase abstracta que define las funciones necesarias para construir un email
 *
 * email Es el email a construir
 * paper El paper que fue borrado, agregado o editado
  */

public abstract class Builder {

    @Getter
    protected Email email;
    protected Paper paper;

    public Builder init(Paper paper) {
        this.paper = paper;
        email=EmailBuilder.startingBlank().buildEmail();
        return this;
    }

    /**
     * Función para agregar el remitente y receptor del email
     *
     * */
    public abstract Email senderAndReceptor();
    /**
     * Función para agregar un título y un cuerpo al email
     *
     * */
    public abstract Email subjectAndBody();
}