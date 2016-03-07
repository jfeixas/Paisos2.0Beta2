package net.infobosccoma.paisos.models.business.entities;

import org.parceler.Parcel;

/**
 * Created by marc on 25/01/2016.
 */
@Parcel
public class Pais {

    private long codi;
    private String name;
    private int area;
    private int population;
    private String codiBandera;
    private String capital;

    public Pais() {

    }
    public Pais(long codi, String name, int area, int population, String codiBandera, String capital) {
        this.codi = codi;
        this.name = name;
        this.area = area;
        this.population = population;
        this.codiBandera = codiBandera;
        this.capital = capital;
    }

    public int getPopulation() {
        return population;
    }

    public long getCodi() {
        return codi;
    }

    public void setCodi(long codi) {
        this.codi = codi;
    }

    public int getArea() {
        return area;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCodiBandera() {
        return codiBandera;
    }

    public void setCodibandera(String codiBandera) {
        this.codiBandera = codiBandera;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
}
