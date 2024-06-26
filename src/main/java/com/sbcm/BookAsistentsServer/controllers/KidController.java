package com.sbcm.BookAsistentsServer.controllers;

import com.sbcm.BookAsistentsServer.models.Kid;
import com.sbcm.BookAsistentsServer.repositories.KidPersonalRepository;
import com.sbcm.BookAsistentsServer.repositories.KidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

/**El controlador Rest es un importante para poder crear los métodos que se encuentran en el CRUD esto
 * haciendo uso de las solicitudes HTTP en la aplicación, ya que, con ayuda de esto y el uso de las Urls es
 * posible realizar estos métodos CRUD.
 * Cada uno de estos métodos cuando se relacionan con un controlador rest quiere decír que la respuesta seran web.
 * Es necesario colocar "sbcm/bookasistents/kids", pues esto es un dominio de aplicación en donde se
 * encuentran las solicitudes de los metodos CRUD, las cuales ayuda a poder encontrar los datos de los registros
 * **/
@RestController
@RequestMapping("sbcm/registrolibrerias/kids")
public class KidController {
    //Este es utilizado para poder tener acceso a los registros de la base de datos "TableKids"
    KidRepository kidRepository;

    KidPersonalRepository personalkidRepo;

    @Autowired
    public void setPersonalkidRepo(KidPersonalRepository personalkidRepo) {
        this.personalkidRepo = personalkidRepo;
    }

    /***
     * La función de este es establecer la inyección de dependencias Spring a kidRepository
     * @param kidRepository esta es la instancia que se usa para inyectar las dependencias Spring
     */
    @Autowired
    public void setBookAsistentsRepository(KidRepository kidRepository) {
        this.kidRepository = kidRepository;
    }

    /***
     * Esta parte se encarga de poder tener los registros que se encuentran en la base de datos
     * @return el interable es lo que se retornara, pues aquí se encuentran todos los registros de la base de datos
     */
    @GetMapping
    public Iterable<Kid>getKids(){
        return kidRepository.findAll();
    }

    /***
     * En esta parte se van a obtener los datos de un registro en específico mediante el id
     * @param id esta es la variable que ayudara a poder determinar el registro
     * @return se retorna el registro especificado por su id
     */

    @GetMapping("/{id}")
    public Kid getKidById(@PathVariable int id){
        return kidRepository.findById(id).orElse(null);
    }

    /***
     * Lo que realiza esta función es poder crear registros en la base de datos
     * @param kid es el objeto que se usara con todos los datos
     * @return
     */

    @PostMapping
    public int postKid(@RequestBody Kid kid){
        int lastId = kidRepository.findLasId()+2;
        kid.setId(lastId);
        kid.setnVisitas(1);
        kidRepository.save(kid);
        return lastId;
    }

    /***
     * Este tiene como función el poder actualizar los datos de un registro en la base de datos
     * @param kid este es el objeto con sus datos
     */

    @PutMapping
    public void putKid(@RequestBody Kid kid){
        if (!kidRepository.existsById(kid.getId()))
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND,"no se encontro en el datos");
        kid.setnVisitas(kid.getnVisitas()+1);
        kidRepository.save(kid);
    }

    /***
     * Aquí lo que se hara sera eliminar algún registro de la base de datos, mediante el uso del id
     * @param id esta es la variable que se usa como identificador de los registros, el cual ayudara a eliminar el registro
     */
    @DeleteMapping("/{id}")
    public void deleteKidById(@PathVariable int id){
        if (!kidRepository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se encontro el dato");
        System.out.println(personalkidRepo.existsById(id));
        if (personalkidRepo.existByIdKid(id)>0){
            personalkidRepo.deleteById(personalkidRepo.findByKidId(id));
        }
        kidRepository.deleteById(id);
    }

    @GetMapping("/search/{nombre}")
    public Iterable<Kid>findKidbyCompleteName(@PathVariable String nombre) {
        System.out.println(nombre);
        String[] parts = nombre.split("");
        List<String> partsList = Arrays.asList(parts);
        String complete = nombre.replace("", "% %");
        System.out.println(complete);
        Set<Kid> setKid = new LinkedHashSet<>();
        for (int i = 1; i < parts.length; i++) {
            String replace = String.join("% %", partsList.subList(partsList.size() - i, partsList.size() - 1));
            setKid.addAll(kidRepository.findByNombreCompleto(replace));
        }
        for (int i = parts.length - 1; i > 0; i--) {
            String replace = String.join("% %", partsList.subList(partsList.size() - i, partsList.size() - 1));
            setKid.addAll(kidRepository.findByNombreCompleto(complete));
        }
        setKid.addAll(kidRepository.findByNombreCompleto(complete));
        return new ArrayList<>(setKid);
    }
}
