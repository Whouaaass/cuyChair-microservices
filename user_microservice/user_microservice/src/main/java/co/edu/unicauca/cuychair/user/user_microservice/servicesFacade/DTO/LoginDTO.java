package co.edu.unicauca.cuychair.user.user_microservice.servicesFacade.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
public class LoginDTO {
    public LoginDTO(){}
    private String email;
    private String password;
}
