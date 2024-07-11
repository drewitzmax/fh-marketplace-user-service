package at.ac.fhcampuswien.fhmarketplace.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;

import java.util.ArrayList;
import java.util.List;

@Document("users")
public class User {
    @Id
    public String id;
    @Indexed(unique = true)
    public String username;
    @Indexed(unique = true)
    public String email;
    public String telephone;
    public Address address;

    public List<String> postings;

    public User(String id, String username, String email, String telephone, Address address, List<String> postings) {
        super();
        this.id = id;
        this.username = username;
        this.email = email;
        this.telephone = telephone;
        this.address = address;
        this.postings = postings != null ? postings : new ArrayList<>();
    }

    public void setEmail(String user) {
        this.email = user;
    }
}
