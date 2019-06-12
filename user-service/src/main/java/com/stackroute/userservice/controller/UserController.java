/**
 * This class is used as controller for user service
 */

package com.stackroute.userservice.controller;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.exception.UserAlreadyExistException;
import com.stackroute.userservice.exception.UserNotFoundException;
import com.stackroute.userservice.repository.UserRepository;
import com.stackroute.userservice.service.UserService;
import javassist.bytecode.stackmap.BasicBlock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api/v1")
public class UserController {

    @Value("${spring.userNotFound}")
    private String userNotFound;

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //This method post user in the database
    @PostMapping("User")
    public ResponseEntity<?> saveUser(@RequestBody User user)
    {
        ResponseEntity responseEntity;
        try {
            userService.saveUser(user);
            responseEntity=new ResponseEntity<String>("Successfully created ", HttpStatus.CREATED);
        }
        catch (UserAlreadyExistException ex)
        {
            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.ALREADY_REPORTED);
        }
        return  responseEntity;
    }

    //This method get users from the database
    @GetMapping("User")
    public ResponseEntity<?> getAllUsers()
    {
        return  new ResponseEntity<List<User>>(userService.getAllUsers(),HttpStatus.OK);
    }

    //This method get a particular user from database
    @GetMapping("User1/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") int id)
    {
        ResponseEntity responseEntity;
        try {
            User user=userService.findById(id);
            if(user==null){
                responseEntity=new ResponseEntity<String>(userNotFound,HttpStatus.NOT_FOUND);
            }
            else {
                responseEntity = new ResponseEntity<String>("User found", HttpStatus.OK);
            }
        }
        catch(UserNotFoundException ex)
        {
            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }
        return  responseEntity;
    }

    //This method get a user from database by its name
    @GetMapping("User2/{firstName}")
    public ResponseEntity<?> findByName(@PathVariable("firstName") String firstName){
        ResponseEntity responseEntity;
        try {
            User user=userService.findByName(firstName);
            if(user==null){
                responseEntity=new ResponseEntity<String>(userNotFound,HttpStatus.NOT_FOUND);
            }
            else {
                responseEntity = new ResponseEntity<String>("User found", HttpStatus.OK);
            }
        }
        catch(UserNotFoundException ex)
        {
            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }
}
