package com.example.springboottest1.controller;

import com.example.springboottest1.entity.Allergy;
import com.example.springboottest1.service.AllergyServiceJpa;
import com.example.springboottest1.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.MessageFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/testApi")
public class AllergyController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AllergyController.class);
    private static final String CLASS_NAME = "Ejecutando " + AllergyController.class.getName();

    private AllergyServiceJpa allergyServiceJpa;

    @Autowired
    public AllergyController(AllergyServiceJpa allergyServiceJpa) {
        this.allergyServiceJpa = allergyServiceJpa;
    }

    @GetMapping("/allergies")
    public List<Allergy> getAllergys() {
        LOGGER.info(MessageFormatter.format(Constants.LOG_FULL, CLASS_NAME, "getAllergys()").getMessage());
        return allergyServiceJpa.findAll();
    }

    @GetMapping("/allergies/{idAllergy}")
    public Allergy getAllergy(@PathVariable int idAllergy) {
        LOGGER.info(MessageFormatter.format(Constants.LOG_FULL, CLASS_NAME, "getAllergy()").getMessage());
        Allergy theAllergy = allergyServiceJpa.findAlergia(idAllergy);
        if (theAllergy == null) {
            LOGGER.info(MessageFormatter.format(Constants.LOG_FULL, "No se ha encontrado la clave de la Alergia", idAllergy).getMessage());
            throw new RuntimeException("No se ha encontrado la clave de la Alergia: " + idAllergy);
        }
        return theAllergy;
    }

    @PostMapping("/allergies")
    public Allergy addAllergy(@RequestBody Allergy objAllergy) {
        LOGGER.info(MessageFormatter.format(Constants.LOG_FULL, CLASS_NAME, "getAllergy()").getMessage());
        objAllergy.setIdAllergy(0);
        allergyServiceJpa.save(objAllergy);
        return objAllergy;
    }

    @PutMapping("/allergies")
    public Allergy updateAllergy(@RequestBody Allergy objAllergy) {
        LOGGER.info(MessageFormatter.format(Constants.LOG_FULL, CLASS_NAME, "updateAllergy()").getMessage());
        allergyServiceJpa.save(objAllergy);
        return objAllergy;
    }

    @DeleteMapping("/allergies/{idAllergy}")
    public String deleteAllergy(@PathVariable int idAllergy) {
        LOGGER.info(MessageFormatter.format(Constants.LOG_FULL, "Ejecutando " + CLASS_NAME, "deleteAllergy()").getMessage());
        Allergy theAllergy = allergyServiceJpa.findAlergia(idAllergy);
        if (theAllergy == null) {
            LOGGER.info(MessageFormatter.format(Constants.LOG_FULL, "No es posible eliminar la clave de alergia: " + idAllergy, "debido a que no se ha encontrado en la BD").getMessage());
            throw new RuntimeException("No es posible eliminar la clave de alergia: " + idAllergy
                    + " debido a que no se ha encontrado en la BD");
        }
        allergyServiceJpa.delete(idAllergy);
        return "La alergia se ha eliminado exitosamente";
    }
}
