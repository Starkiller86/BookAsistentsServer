package com.sbcm.BookAsistentsServer.controllers;

import com.sbcm.BookAsistentsServer.models.Adult;
import com.sbcm.BookAsistentsServer.repositories.AdultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**El controlador Rest es un componente importante para poder hacer los metodos que se encuentran en el CRUD, esto
 * mediante el uso de las solicitudes de HTTP en la aplicación, pues mediante con esto y las Urls es posible realizar estos
 * métodos.
 * Cada uno de estos  métodos al basarse en el controlador Rest recibira respuestas web
 * Es necesario el colocar "sbcm/bookasistents/adults", pues esto es el dominio de la aplicación en donde se
 * encuentran las solicitudes de los métodos CRUD, pues esto ayuda a poder encontrar los datos de los registros
 * **/
@RestController
@RequestMapping("sbcm/registrolibrerias/adults") //Prueba de GitHub
public class AdultController {
    //Este es utilizado para poder acceder a los registros en la base de datos "bookAsistents"
    AdultRepository adultRepository;

    /***
     * En este se establecen las inyecciones de dependencias a adultRepository
     * @param adultRepository esta es la instancia a la cual contiene la inyección de dependencias de Spring
     */
    @Autowired
    public void setBookAsistentsRepository(AdultRepository adultRepository) {
        this.adultRepository = adultRepository;
    }

    /***
     * Esta parte se encarga de poder tener todos los registros que se encuentran en la base de datos
     * @return interable retornara todos los registros de la base de datos
     */
    @GetMapping
    public Iterable<Adult>getAduls(){
    return adultRepository.findAll();
    }

    /***
     * Aqui se obtiene un registro en especifico de la base de datos mediante su id
     * @param id es la variable de identificación que se encargara de encontrar el registro
     * @return registro que se especifico con el id
     */

    @GetMapping("/{id}")
    public Adult getAdultById(@PathVariable int id){
    return adultRepository.findById(id).orElse(null);
    }

    /***
     * En esta parte se crean registros en la base de datos
     * @param adult y los datos que se registrarón en el programa
     */

    @PostMapping
    public  void  postAdult(@RequestBody Adult adult){
    adultRepository.save(adult);
    }

    /***
     * Lo que realiza este método es actualizar los datos de un registro en la base de datos
     * @param adult y los datos los cuales se actualizarán en la base de datos
     */

    @PutMapping
    public void putAdult(@RequestBody Adult adult){
        if (!adultRepository.existsById(adult.getId()))
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND,"no se encontro en el datos");
        adultRepository.save(adult);
    }

    /***
     * Esto tienen como función eliminar un registro especificado por su id en la base de datos
     * @param id es la variable que se utilizara para poder eliminar el registro
     */
    @DeleteMapping("/{id}")
    public void deleteAdultById(@PathVariable int id){
    if (!adultRepository.existsById(id))
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se encontro el dato");
    adultRepository.deleteById(id);
    }

    @GetMapping("/search/{nombre}")
    public Iterable<Adult> findAdultByCompleteName(@PathVariable String nombre){
        System.out.println(nombre);
        String[] parts = nombre.split(" ");
        List<String> partsList = new ArrayList<>();
        Collections.addAll(partsList, parts);
        String complete = nombre.replace(" ", "% %");

        List<Adult> best = adultRepository.findByNombreCompleto(complete);
        List<Adult> list = new ArrayList<>(best);
        for (int i = 0; i<parts.length; i++){
            if (!partsList.isEmpty() && partsList.size()>1){
                partsList.remove(partsList.size()-1);
                String replace = String.join("% %", partsList);
                List<Adult> replaceList = adultRepository.findByNombreCompleto(replace);
                list.addAll(replaceList);
            }
        }
        for (Adult a: list
             ) {
            System.out.println(a.getNombre() + " " + a.getApellido());
        }
        return list;
    }
}
