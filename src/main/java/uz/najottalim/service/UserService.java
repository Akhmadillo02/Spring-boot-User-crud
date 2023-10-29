package uz.najottalim.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.najottalim.entity.User;
import uz.najottalim.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


        public ResponseEntity<User> getById(Long id) {
            if (id == null) {
                Optional<User> byId = userRepository.findById(id);
                return ResponseEntity.accepted().build();
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    public Optional<User> getByName(String name) {
        return userRepository.findByName(name);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User save(User user) {
        if (user == null) {
            throw new RuntimeException("user null keldi");
        }
        return userRepository.save(user);
    }
}
