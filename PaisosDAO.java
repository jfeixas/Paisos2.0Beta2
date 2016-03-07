package net.infobosccoma.paisos.models.persistence.daos.interfaces;

import java.util.List;

import net.infobosccoma.paisos.models.business.entities.Pais;

/**
 * Created by alumne on 2/23/2016.
 */
public interface PaisosDAO {

    Pais getById(long id);
    Pais getByName (String nom);
    List<Pais> getAll();
    boolean save(Pais pais);
    boolean update(Pais pais);
    boolean delete(Pais pais);
}
