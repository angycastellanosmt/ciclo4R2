/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.ciclo4.retodos.web;

import co.edu.usa.ciclo4.retodos.model.User;
import co.edu.usa.ciclo4.retodos.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author angycastel
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {

    /**
     * Instancia de la clase de servicio
     */
    @Autowired
    private UserService userService;

    /**
     * Método para obtener una lista de usuarios
     *
     * @return Lista de usuarios
     */
    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAll();
    }

    /**
     * Método para obtener un usuario por id
     *
     * @param id: identificador del usuario en la colección
     * @return usuario por id
     */
    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable("id") int id) {
        return userService.getUser(id);
    }

    /**
     * Método para crear un nuevo usuario
     *
     * @param user: atributos del usuario
     * @return un nuevo usuario con los valores de los atributos dados
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    /**
     * Método para actualizar un usuario
     *
     * @param user: atributos actualizados del usuario
     * @return un usuario con sus atributos actualizados
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    /**
     * Método para borrar un usuario por id
     *
     * @param id: id del usuario que se desea eliminar de la colección
     * @return eliminación del usuario
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return userService.delete(id);
    }

    /**
     * Método para validar si un correo ya existe registrado en la colección
     *
     * @param email: correo que quiere validarse
     * @return un booleano dependiendo si existe o no el correo
     */
    @GetMapping("/emailexist/{email}")
    public boolean emailExists(@PathVariable("email") String email) {
        return userService.emailExist(email);
    }

    /**
     * Método para validar si una combinación correo y contraseña existen
     *
     * @param email:correo que quiere validarse
     * @param password: contraseña que quiere validarse
     * @return un booleano dependiendo si existe o no la combinación dada
     */
    @GetMapping("/{email}/{password}")
    public User autenticarUser(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.autenticarUsuario(email, password);
    }

}
