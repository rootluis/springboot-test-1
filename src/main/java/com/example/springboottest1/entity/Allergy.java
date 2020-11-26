package com.example.springboottest1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TAB011_ALERGIA")
public class Allergy {

    @Id
    @SequenceGenerator(name = "seqAlergia",sequenceName = "ALERGIA_SEQ",initialValue = 10000,allocationSize = 100)
    @GeneratedValue(generator = "seqAlergia")
    @Column(name = "CD_ALERGIA")
    private int idAllergy;

    @Column(name = "NB_ALERGIA")
    private String nameAllergy;

    public Allergy() {
    }

    public Allergy(String nameAllergy) {
        this.nameAllergy = nameAllergy;
    }

    public int getIdAllergy() {
        return idAllergy;
    }

    public void setIdAllergy(int idAllergy) {
        this.idAllergy = idAllergy;
    }

    public String getNameAllergy() {
        return nameAllergy;
    }

    public void setNameAllergy(String nameAllergy) {
        this.nameAllergy = nameAllergy;
    }

    @Override
    public String toString() {
        return "Allergy{" +
                "idAllergy=" + idAllergy +
                ", nameAllergy='" + nameAllergy + '\'' +
                '}';
    }
}
