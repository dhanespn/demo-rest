package com.example.demo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public UsersEntity fetchUserByUsername(String username) throws NoSuchCustomerExistsException{
        Optional<UsersEntity> usersEntityOptional = usersRepository.findByUsername(username);
        if (usersEntityOptional.isPresent()){
            return usersEntityOptional.get();
        }else {
            throw new NoSuchCustomerExistsException(HttpStatus.NOT_FOUND.value(), "No Such user exists");
        }
    }

    public UsersEntity addNewUser(UsersPojo usersPojo){
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setUserRole(usersPojo.getUserRole());
        usersEntity.setFirstName(usersPojo.getFirstName());
        usersEntity.setLastName(usersPojo.getLastName());
        usersEntity.setUsername(usersPojo.getUsername());

       return  usersRepository.save(usersEntity);
    }

    public  List<UsersEntity> fetchAllUsers(){
        List<UsersEntity> h = usersRepository.findAll();
       // System.out.println(h);
        return h;
    }
}