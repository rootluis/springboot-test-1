package com.example.springboottest1.service.impl;

import com.example.springboottest1.dao.AllergyRepository;
import com.example.springboottest1.entity.Allergy;
import com.example.springboottest1.service.AllergyServiceJpa;
import com.example.springboottest1.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.MessageFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AllergyServiceJpaImpl implements AllergyServiceJpa {

    private static final Logger LOGGER = LoggerFactory.getLogger(AllergyServiceJpaImpl.class);
    private static final String MSG_SERVICE = "Ejecutando " + AllergyServiceJpaImpl.class.getName();

    private AllergyRepository allergyRepository;

    @Autowired
    public AllergyServiceJpaImpl(AllergyRepository allergyRepository) {
        this.allergyRepository = allergyRepository;
    }

    @Override
    public List<Allergy> findAll() {
        LOGGER.info(MessageFormatter.format(Constants.LOG_FULL, MSG_SERVICE, "findAll()").getMessage());
        return allergyRepository.findAll();
    }

    @Override
    public Allergy findAlergia(int idAlergia) {
        LOGGER.info(MessageFormatter.format(Constants.LOG_FULL, MSG_SERVICE, "findAlergia()").getMessage());
        Optional<Allergy> result = allergyRepository.findById(idAlergia);
        Allergy theAlergy = null;

        if (result.isPresent()) {
            theAlergy = result.get();
        } else {
            LOGGER.warn(MessageFormatter.format(Constants.LOG_FULL, "No se encontro la Alergia", idAlergia).getMessage());
            throw new RuntimeException("No se encontro la Alergia " + idAlergia);
        }
        return theAlergy;
    }

    @Override
    public void save(Allergy objAlergia) {
        LOGGER.info(MessageFormatter.format(Constants.LOG_FULL, MSG_SERVICE, "save()").getMessage());
        allergyRepository.save(objAlergia);

    }

    @Override
    public void delete(int idAlergia) {
        LOGGER.info(MessageFormatter.format(Constants.LOG_FULL, MSG_SERVICE, "delete()").getMessage());
        allergyRepository.deleteById(idAlergia);

    }
}
