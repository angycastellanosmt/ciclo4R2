/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.ciclo4.retodos.service;

import co.edu.usa.ciclo4.retodos.model.User;
import co.edu.usa.ciclo4.retodos.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author angycastel
 */
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public List<User> getAll(){
        return userRepository.getAll();
    }
    
    public Optional<User> getUser(int id){
        return userRepository.getUser(id);
    }
    
    public User saveUser (User user){
        if(user.getId()==null){
            return user;
        }else{
            Optional<User> useraux= userRepository.getUser(user.getId());
            if (useraux.isEmpty()){    
            if(emailExist(user.getEmail())==false){
                return userRepository.save(user);
            }else{
                return user;
            }
            }else{
        return user;
    }
    
        }
    }
    public boolean emailExist(String email) {
        return userRepository.emailExist(email);
    }

    public User updateUser (User user){
        if (user.getId() != null) {
            Optional<User> useraux = userRepository.getUser(user.getId());
            if (!useraux.isEmpty()) {
                if (user.getIdentification() != null) {
                    useraux.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    useraux.get().setName(user.getName());
                }
                if (user.getAddress() != null) {
                    useraux.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    useraux.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    useraux.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    useraux.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    useraux.get().setZone(user.getZone());
                }
                
                return userRepository.save(useraux.get());
                //return useraux.get();
            } else {
                return user;
            }
        } else {
            return user;
        }

    }
    
    public boolean delete(int userId) {
        Boolean aBoolean = getUser(userId).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public User autenticarUsuario (String email, String password) {
        Optional<User> usuario = userRepository.autenticarUsuario(email, password);
        if (usuario.isEmpty()) {
           // return new User (email, password, "NO DEFINIDO");
           return new User();
        } else {
            return usuario.get();
        }
    }    
    
}
