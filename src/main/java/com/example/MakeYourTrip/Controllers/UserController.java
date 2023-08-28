package com.example.MakeYourTrip.Controllers;

import com.example.MakeYourTrip.RequestDto.AddUserDto;
import com.example.MakeYourTrip.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")
public class UserController {


    @Autowired
    private UserService userService;


    @PostMapping("/addUser")
    public ResponseEntity addUser(@RequestBody AddUserDto addUserDto){

       return userService.addUser(addUserDto);

    }

}
