package com.hotel.BookingManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.BookingManagement.service.interfac.UserServiceInterface;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceInterface userService;

}
