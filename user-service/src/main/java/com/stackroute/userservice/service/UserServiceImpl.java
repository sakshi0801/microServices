/**
 * This class provides implementation for user service methods
 */

package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.exception.UserAlreadyExistException;
import com.stackroute.userservice.exception.UserNotFoundException;
import com.stackroute.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Value("${spring.userAlreadyExist}")
    private String userAlreadyExist;

    @Value("${spring.userNotFound}")
    private String userNotFound;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //This method is used to save a user in database
   @Override
   public User saveUser(User user) throws UserAlreadyExistException {
       if(userRepository.existsById(user.getId()))
       {
           throw  new UserAlreadyExistException(userAlreadyExist);
       }
       User savedUser=userRepository.save(user);
       if(savedUser == null)
       {
           throw new UserAlreadyExistException(userAlreadyExist);
       }
       return savedUser;
   }

   //This method is to get all users from database
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //This method is used to find a user by its id
    @Override
    public User findById(int id) throws UserNotFoundException {
       User user1 =null;
       if(userRepository.existsById(id))
       {
           user1=userRepository.findById(id).get();
           if(user1==null){
               throw new UserNotFoundException(userNotFound);
           }
       }
        return user1;
    }

    //This method is used to find a user by its name
    @Override
    public User findByName(String firstName) throws UserNotFoundException{
       User user=null;
       user=userRepository.findByName(firstName);
       if(user==null){
           throw new UserNotFoundException(userNotFound);
       }
       return user;
    }
}
