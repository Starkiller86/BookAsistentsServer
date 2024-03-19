package com.sbcm.BookAsistentsServer.controllers;

import com.sbcm.BookAsistentsServer.models.Personaldataadult;
import com.sbcm.BookAsistentsServer.repositories.AdultPersonalRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("sbcm/personalA")
public class AdultPersonalController {
    AdultPersonalRepository personalRepository;

    @Autowired
    public void setPersonalRepository(AdultPersonalRepository personalRepository) {
        this.personalRepository = personalRepository;
    }

    @GetMapping

    public Iterable<Personaldataadult> getPersonalData(){
        return personalRepository.findAll();
    }
    @GetMapping("/{id}")
    public Personaldataadult getPersonalDataById(@PathVariable Integer id){
        return personalRepository.findById(id).orElse(null);
    }
    @PostMapping
    @Transactional
    public int postPersonalData(@RequestBody Personaldataadult personal){
        personalRepository.save(personal);
        int idPersonal = personal.getIdAdulto().getId();
        return personalRepository.findByAdultId(idPersonal);
    }
    @PutMapping
    public void putPersonalData(@RequestBody Personaldataadult personal){
        personalRepository.save(personal);
    }
    @DeleteMapping("/{id}")
    public void deletePersonalData(@PathVariable Integer id){
        personalRepository.deleteById(id);
    }
}
