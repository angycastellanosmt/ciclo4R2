/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.ciclo4.retodos.web;

import co.edu.usa.ciclo4.retodos.model.Gadget;
import co.edu.usa.ciclo4.retodos.service.GadgetService;
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
@RequestMapping("/api/gadget")
@CrossOrigin("*")
public class GadgetController {
    @Autowired
    private GadgetService gadgetService;
    
    @GetMapping("/all")
    public List<Gadget> getAll(){
        return gadgetService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Gadget> getGadgetI(@PathVariable("id")Integer id){
        return gadgetService.getGadget(id);
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Gadget saveGadget(@RequestBody Gadget gadget){
        return gadgetService.saveGadget(gadget);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Gadget updateGadget(@RequestBody Gadget gadget){
        return gadgetService.updateGadget(gadget);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteGadget(@PathVariable("id")Integer id){
        return gadgetService.delete(id);
        
    }
}
