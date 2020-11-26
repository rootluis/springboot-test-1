package com.example.springboottest1.service;

import com.example.springboottest1.entity.Allergy;

import java.util.List;

public interface AllergyServiceJpa {

    public List<Allergy> findAll();

    public Allergy findAlergia(int idAlergia);

    public void save(Allergy objAlergia);

    public void delete(int idAlergia);
}
