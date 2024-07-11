package at.ac.fhcampuswien.fhmarketplace.repository;

import at.ac.fhcampuswien.fhmarketplace.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    public User findByEmail(String email);
    public User deleteUserByEmail(String email);
}
