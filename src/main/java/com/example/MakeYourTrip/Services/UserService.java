package com.example.MakeYourTrip.Services;


import com.example.MakeYourTrip.Models.User;
import com.example.MakeYourTrip.Repositories.UserRepository;
import com.example.MakeYourTrip.RequestDto.AddUserDto;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
@Data
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaMailSender javaMailSender;


    public ResponseEntity addUser(AddUserDto addUserDto) throws MessagingException {

        User user = User.builder().age(addUserDto.getAge())
                                  .emailId(addUserDto.getEmailId())
                                  .name(addUserDto.getName())
                                  .build();

        userRepository.save(user);

//        SimpleMailMessage mailMessage = new SimpleMailMessage();
//
//        String body = "Welcome to Make your Trip , Booking Flights, Buses are now very quicker with Make Your Trip. Hurry Up...! and Book your Tickets";
//
//        mailMessage.setSubject("Hi "+ user.getName() + " Welcome to Make My Trip");
//
//        mailMessage.setFrom("cosmosrider001@gmail.com");
//
//        mailMessage.setTo(user.getEmailId());
//
//        mailMessage.setText(body);
//
//        javaMailSender.send(mailMessage);


        MimeMessage message = javaMailSender.createMimeMessage();

        String body = "Welcome to Make your Trip , Booking Flights, Buses are now very quicker with Make Your Trip. Hurry Up...! and Book your Tickets";

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("cosmosrider001@gmail.com");

            helper.setTo(user.getEmailId());

            helper.setSubject("Hi "+ user.getName() + " Welcome to Make Your Trip");

            helper.setText(body);

            FileSystemResource file = new FileSystemResource(new File("D:\\projectS\\welcome.jpg"));

            helper.addAttachment("Holly COW..!",file.getFile());

            javaMailSender.send(message);

            return new ResponseEntity("User has been added Successfully", HttpStatus.OK);

        }catch(MessagingException e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }


    }
}
