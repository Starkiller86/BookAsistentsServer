package com.sbcm.BookAsistentsServer.controllers;
import com.sbcm.BookAsistentsServer.models.Personaldatakid;
import com.sbcm.BookAsistentsServer.repositories.KidPersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("sbcm/personalK")
public class KidPersonalController {
    KidPersonalRepository personalRepository;

    @Autowired
    public void setPersonalRepository(KidPersonalRepository personalRepository) {
        this.personalRepository = personalRepository;
    }

    @GetMapping
    public Iterable<Personaldatakid> getPersonalData(){
        return personalRepository.findAll();
    }

    @GetMapping("/{id}")
    public Personaldatakid getPersonalDataById(@PathVariable Integer id){
        return personalRepository.findById(id).orElse(null);
    }

    @PostMapping
    public void postPersonalData(@RequestBody Personaldatakid personal){
        personalRepository.save(personal);

    }
    @PutMapping
    public void putPersonalData(@RequestBody Personaldatakid personal){
        personalRepository.save(personal);

    }

    @DeleteMapping("/{id}")
    public void deletePersonalData(@PathVariable Integer id){
        personalRepository.deleteById(id);
    }

}
