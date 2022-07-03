package com.example.dripteens.controller;

import com.example.dripteens.model.UserModel;
import com.example.dripteens.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "createuser",method = RequestMethod.POST)
    public ResponseEntity<Object> createUser(@RequestParam String lnames,@RequestParam String fnames, @RequestParam int age){
        UserModel userModel = new UserModel(fnames,lnames,age);
        userRepository.save(userModel);
        return new ResponseEntity<Object>("saved", HttpStatus.OK);

    }
    @RequestMapping(value = "getallusers", method = RequestMethod.GET)
    public ResponseEntity<Object> getUsers(){
        List<UserModel> Users= userRepository.findAll();
        if (Users==null){
            return new ResponseEntity<Object>("no users found",HttpStatus.OK);
        }
        else{
            return  new ResponseEntity<Object>(Users,HttpStatus.OK);
        }
    }
    @RequestMapping(value = "getuser",method = RequestMethod.POST)
    public ResponseEntity<Object> getUser(@RequestParam int id){
       UserModel user= userRepository.findById(id);
       if (user==null){
           return new ResponseEntity<>("no user found",HttpStatus.OK);
       }
       else{
           return  new ResponseEntity<>(user,HttpStatus.OK);
       }
    }
    @RequestMapping(value="deleteuser",method = RequestMethod.POST)
    public ResponseEntity<Object> deleteUser(@RequestParam int id){
        UserModel user= userRepository.findById(id);
        if (user==null){
            return new ResponseEntity<Object>("no user found to delete",HttpStatus.OK);
        }
        else{
            userRepository.delete(user);
            return new ResponseEntity<Object>("user deleted",HttpStatus.OK);
        }

    }
    @RequestMapping(value = "updateuser",method = RequestMethod.POST)
    public ResponseEntity<Object> updateUser(@RequestParam int id, @RequestParam String fnames, @RequestParam String lnames,@RequestParam int age){
        UserModel user= userRepository.findById(id);
        if (user==null){
            return new ResponseEntity<>("no user found",HttpStatus.OK);

        }
        else{
            user.setFnames(fnames);
            user.setLnames(lnames);
            user.setAge(age);
            userRepository.save(user);
            return  new ResponseEntity<>("saved",HttpStatus.OK);

        }
    }
    @RequestMapping(value = "getnumberofuser", method = RequestMethod.GET)
    public ResponseEntity<Object> getNumberOfUsers(){
        long number = userRepository.count();
        return new ResponseEntity<Object>(number,HttpStatus.OK);
    }
}
