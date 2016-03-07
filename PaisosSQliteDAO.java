package net.infobosccoma.paisos.models.persistence.daos.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import net.infobosccoma.paisos.models.business.entities.Pais;

import java.util.ArrayList;
import java.util.List;

import net.infobosccoma.paisos.models.business.entities.Pais;
import net.infobosccoma.paisos.models.persistence.daos.interfaces.PaisosDAO;
import net.infobosccoma.paisos.models.persistence.utilities.SQLiteUtils;

/**
 * Created by alumne on 2/23/2016.
 */
public class PaisosSQliteDAO implements PaisosDAO {

    private Context context;

    public PaisosSQliteDAO(Context context) {
        this.context = context;
    }

    @Override
    public Pais getById(long id) {
        Pais pais = null;

        SQLiteDatabase conn = SQLiteUtils.getConnection(context);
        Cursor result = conn.query(true, "Paisos",
                new String[]{"codi", "name", "area", "population", "codiBandera", "capital"},
                "codi = ?", new String[] { String.valueOf(id) }, null, null, null, null);

        pais = SQLiteUtils.getPais(result);

        conn.close();
        return pais;

    }

    @Override
    public Pais getByName(String nom) {
        Pais pais = null;

        SQLiteDatabase conn = SQLiteUtils.getConnection(context);
        Cursor result = conn.query(true, "Paisos",
                new String[]{"codi", "name", "area", "population", "codiBandera", "capital"},
                "name = ?", new String[] { String.valueOf(nom) }, null, null, null, null);

        pais = SQLiteUtils.getPais(result);

        conn.close();
        return pais;

    }

    @Override
    public List<Pais> getAll() {
        List<Pais> paisos = new ArrayList();

        SQLiteDatabase conn = SQLiteUtils.getConnection(context);
        Cursor result = conn.query(true, "Paisos", new String[]{"codi", "name", "area", "population", "codiBandera", "capital"},
                null, null, null, null, null, null);

        while (result.moveToNext()){
            paisos.add(SQLiteUtils.getPais(result));
        }

        //conn.close();
        return paisos;
    }

    @Override
    public boolean save(Pais pais) {
        SQLiteDatabase conn = SQLiteUtils.getConnection(context);
        ContentValues dades = new ContentValues();

        dades.put("name", pais.getName());
        dades.put("area", pais.getArea());
        dades.put("population", pais.getPopulation());
        dades.put("codiBandera", pais.getCodiBandera());
        dades.put("capital", pais.getCapital());

        try {
            long codi = conn.insertOrThrow("Paisos", null, dades);
            return true;

        } catch (SQLException e) {
            Log.e("Paisos", e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Pais pais) {
        ContentValues dades = new ContentValues();
        SQLiteDatabase conn = SQLiteUtils.getConnection(context);

        dades.put("name", pais.getName());
        dades.put("area", pais.getArea());
        dades.put("population", pais.getPopulation());
        dades.put("codiBandera", pais.getCodiBandera());
        dades.put("capital", pais.getCapital());

        return conn.update("Paisos", dades, "codi = ?", new String[] {String.valueOf(pais.getCodi())}) > 0;
        //conn.up
    }

    @Override
    public boolean delete(Pais pais) {
        // obtenir l'objecte BD en mode esriptura
        SQLiteDatabase conn = SQLiteUtils.getConnection(context);

        return conn.delete("Paisos", "codi=?", new String[] {String.valueOf(pais.getCodi()) }) > 0;
    }
}
