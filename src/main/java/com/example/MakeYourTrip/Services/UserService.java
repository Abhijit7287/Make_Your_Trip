package com.example.MakeYourTrip.Services;


import com.example.MakeYourTrip.Models.User;
import com.example.MakeYourTrip.Repositories.UserRepository;
import com.example.MakeYourTrip.RequestDto.AddUserDto;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Data
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public ResponseEntity addUser(AddUserDto addUserDto){

        User user = User.builder().age(addUserDto.getAge())
                                  .emailId(addUserDto.getEmailId())
                                  .name(addUserDto.getName())
                                  .build();

        userRepository.save(user);

        return new ResponseEntity("User has been added Successfully", HttpStatus.OK);
    }
}
