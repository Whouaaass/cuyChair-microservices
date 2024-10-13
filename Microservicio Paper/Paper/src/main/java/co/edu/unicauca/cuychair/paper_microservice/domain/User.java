package co.edu.unicauca.cuychair.paper_microservice.domain;

public class User {

    private long id;
    private String name;
    private String lastName;
    private String hashedPassword;
    private String email;

    public User(long id, String fldName, String fldLastName, String fldHashedPassword, String fldEmail) {
        this.id = id;
        this.name = fldName;
        this.lastName = fldLastName;
        this.hashedPassword = fldHashedPassword;
        this.email = fldEmail;
    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
