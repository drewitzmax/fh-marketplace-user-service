package at.ac.fhcampuswien.fhmarketplace.rest;

import at.ac.fhcampuswien.fhmarketplace.model.User;
import at.ac.fhcampuswien.fhmarketplace.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @PostMapping
    @CrossOrigin(origins ="http://localhost:4200")
    public User register(@RequestBody User user, @AuthenticationPrincipal OidcUser authentication){
        var email = ((Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getClaimAsString("email");
        user.setEmail(email);
        var existingUser = userRepository.findByEmail(email);
        if(existingUser != null){
            return existingUser;
        }
        var registeredUser = userRepository.insert(user);
        return registeredUser;
    }

    @GetMapping(produces = "application/json")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> getMe(){
        var email = ((Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getClaimAsString("email");
        User me = userRepository.findByEmail(email);
        if(me ==null){
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(me, HttpStatus.OK);
    }

    @GetMapping(produces = "application/json", path = "/all")
    @CrossOrigin(origins="http://localhost:4200")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void deleteUser(@AuthenticationPrincipal OidcUser authentication){
        var email = authentication.getClaimAsString("email");
        userRepository.deleteUserByEmail(email);
    }
}
