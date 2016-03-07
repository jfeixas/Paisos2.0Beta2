package net.infobosccoma.paisos.models.persistence.utilities;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import net.infobosccoma.paisos.models.business.entities.Pais;

/**
 * Created by alumne on 2/23/2016.
 */
public class SQLiteUtils {

    static final String NOM_BD = "Paisos.db";
    static final int VERSIO_BD = 1;

    public static SQLiteDatabase getConnection(Context context) {
        return new PaisosSQLiteHelper(context, NOM_BD, null, VERSIO_BD).getWritableDatabase();
    }

    public static Pais getPais(Cursor reader) {

        Pais pais = new Pais();

        pais.setCodi(reader.getLong(reader.getColumnIndex("codi")));
        pais.setName(reader.getString(reader.getColumnIndex("name")));
        pais.setArea(reader.getInt(reader.getColumnIndex("area")));
        pais.setPopulation(reader.getInt(reader.getColumnIndex("population")));
        pais.setCodibandera(reader.getString(reader.getColumnIndex("codiBandera")));
        pais.setCapital(reader.getString(reader.getColumnIndex("capital")));


        return pais;
    }
}
