package net.infobosccoma.paisos.helpers;

import net.infobosccoma.paisos.models.business.entities.Pais;

import java.util.ArrayList;
import java.util.List;

import net.infobosccoma.paisos.models.business.entities.Pais;

/**
 * Created by Josep Feixas on 25/01/2016.
 */
public class PaisBuilder {
    public PaisBuilder() {
    }

    public List<Pais> getPaisos() {

        List<Pais> paisos = new ArrayList<>();
        paisos.add(new Pais(0, "Catalunya", 32000, 7500000, "cat", "Barcelona"));
        paisos.add(new Pais(1, "Regne Unit", 243000, 64500000, "uk", "Londres"));
        paisos.add(new Pais(2, "Alemanya", 357000, 81200000, "ale", "Berlin"));
        paisos.add(new Pais(3, "França", 640000, 66300000, "fra", "Paris"));
        paisos.add(new Pais(4, "Italia", 301000, 60700000, "ita", "Roma"));
        paisos.add(new Pais(5, "Estats Units", 9850000, 322000000, "usa", "Washington"));
        paisos.add(new Pais(6, "Russia", 17100000, 146000000, "rus", "Moscou"));
        paisos.add(new Pais(7, "Xina", 9600000, 1376000000, "xin", "Pequín"));
        paisos.add(new Pais(8, "Narnia", 150000, 25000000, "nar", "Cair Paravel"));

        return paisos;
    }
}
