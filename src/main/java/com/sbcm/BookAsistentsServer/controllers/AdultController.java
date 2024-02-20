package com.sbcm.BookAsistentsServer.controllers;

import com.sbcm.BookAsistentsServer.models.Adult;
import com.sbcm.BookAsistentsServer.repositories.AdultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.print.attribute.HashPrintJobAttributeSet;
import java.util.*;

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
        //Como tal aquí va a colocar el ultimo id registrado y le va a sumar dos, así de simple. la logica real se va a ver en el registro en la base de datos
        adult.setId(adultRepository.findLasId()+2);
        adult.setnVisitas(1);
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

    /**
     * De la misma manera tenemos un nuevo endpoint que recibirá como variable de ruta (valor en el url) el nombre completo del usuario y devolverá un JSONArray con los resultados
     * @param nombre nombre completo del usuario a buscar
     * @return JSON Array con las coincidencias
     */
    @GetMapping("/search/{nombre}")
    public Iterable<Adult> findAdultByCompleteName(@PathVariable String nombre){
        //Este codigo tiene su propia logica pero no hace falta verla de momento
        System.out.println(nombre);
        String[] parts = nombre.split(" ");
        List<String> partsList = Arrays.asList(parts);
        String complete = nombre.replace(" ", "% %");
        System.out.println(complete);
        Set<Adult> setAdult = new LinkedHashSet<>();
        //Se busca palabra por palabra empezando a quitar los apeidos asegurando que no se haya escrito mal
        for (int i = 1; i<parts.length; i++){
            String replace = String.join("% %", partsList.subList(0, partsList.size()-i));
            setAdult.addAll(adultRepository.findByNombreCompleto(replace));
        }
        //Si no funciona, entonces vamos quitando los nombres hasta terminar con los apeidos
        for (int i = parts.length-1; i>0; i--){
            String replace = String.join("% %",partsList.subList(partsList.size()-i, partsList.size()-1));
            setAdult.addAll(adultRepository.findByNombreCompleto(replace));
        }
        //Y al inicio de la lista colocamos la mejor coincidencia
        setAdult.addAll(adultRepository.findByNombreCompleto(complete));
        //retornamos la lista de todas las coincidencias
        return new ArrayList<>(setAdult);
    }
}
