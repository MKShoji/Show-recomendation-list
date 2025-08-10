package com.shoji.my_friends_show_list.infra.controller;

import com.shoji.my_friends_show_list.application.usecases.user.CreateUser;
import com.shoji.my_friends_show_list.application.usecases.user.GetAllUser;
import com.shoji.my_friends_show_list.application.usecases.user.GetUserById;
import com.shoji.my_friends_show_list.domain.models.user.User;
import com.shoji.my_friends_show_list.infra.persistence.converters.dtos.UserRequestCreation;
import com.shoji.my_friends_show_list.infra.persistence.converters.dtos.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final GetUserById getUserByIdUseCase;
    private final GetAllUser getAllUserUseCase;
    private final CreateUser createUserUseCase;

    public UserController(GetUserById getUserByIdUseCase, GetAllUser getAllUserUseCase, CreateUser createUserUseCase) {
        this.getUserByIdUseCase = getUserByIdUseCase;
        this.getAllUserUseCase = getAllUserUseCase;
        this.createUserUseCase = createUserUseCase;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = getUserByIdUseCase.execute(id);

        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = getAllUserUseCase.execute();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody UserRequestCreation requestCreation) {
        User user = createUserUseCase.execute(requestCreation);

        return ResponseEntity.status(201).body(user);
    }
}

