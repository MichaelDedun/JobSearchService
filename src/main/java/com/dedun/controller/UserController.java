package com.dedun.controller;

import com.dedun.model.User;
import com.dedun.model.enums.Role;
import com.dedun.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Set<Role> getRole(@AuthenticationPrincipal User user) {
        return userService.getRole(user);
    }
}
