package uz.najottalim.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.najottalim.entity.User;
import uz.najottalim.service.UserService;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/one/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id) {
        return userService.getById(id);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


    @GetMapping("/findAll")
    public List<User> getAll() {
        return userService.getAll();
    }



    @PostMapping("/save")
    public ResponseEntity<User> save( @RequestBody User user) {
        User save = userService.save(user);
        return ResponseEntity.ok(save);
    }






}
