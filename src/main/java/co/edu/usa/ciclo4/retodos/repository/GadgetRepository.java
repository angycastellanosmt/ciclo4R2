/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.ciclo4.retodos.repository;

import co.edu.usa.ciclo4.retodos.model.Gadget;
import co.edu.usa.ciclo4.retodos.repository.crud.GadgetCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author angycastel
 */
@Repository
public class GadgetRepository {
    
    @Autowired
    private GadgetCrudRepository gadgetCrudRepository;
    
    public List<Gadget> getAll(){
        return gadgetCrudRepository.findAll();
    }
    
    public Optional<Gadget> getGadget(int id){
        return gadgetCrudRepository.findById(id);
    }
    
    public Gadget save(Gadget gadget){
        return gadgetCrudRepository.save(gadget);
    }
    
   /* public void update (Gadget gadget){
        gadgetCrudRepository.save(gadget);
    }*/
    
    public void delete(Gadget gadget){
        gadgetCrudRepository.delete(gadget);
    }
}
