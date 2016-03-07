package net.infobosccoma.paisos.models.persistence.utilities;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by alumne on 2/23/2016.
 */
public class PaisosSQLiteHelper extends SQLiteOpenHelper {

    //Persistència SQL per crear la taula de Persons
    private final String SQL_CREATE_PAISOS = "CREATE TABLE Paisos(" +
            "	codi INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "	name TEXT, " +
            "	area INTEGER, " +
            "	population INTEGER, " +
            "	codiBandera TEXT, " +
            "	capital TEXT)";

    public PaisosSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_PAISOS);
        db.execSQL("INSERT INTO PAISOS(name, area, population, codiBandera, capital) VALUES ('Catalunya', 32000, 7500000, 'cat', 'Barcelona')");
        db.execSQL("INSERT INTO PAISOS(name, area, population, codiBandera, capital) VALUES ('Regne Unit', 243000, 64500000, 'uk', 'Londres')");
        db.execSQL("INSERT INTO PAISOS(name, area, population, codiBandera, capital) VALUES ('Alemanya', 357000, 81200000, 'ale', 'Berlin')");
        db.execSQL("INSERT INTO PAISOS(name, area, population, codiBandera, capital) VALUES ('França', 641000, 66300000, 'fra', 'Paris')");
        db.execSQL("INSERT INTO PAISOS(name, area, population, codiBandera, capital) VALUES ('Itàlia', 301000, 60700000, 'ita', 'Roma')");
        db.execSQL("INSERT INTO PAISOS(name, area, population, codiBandera, capital) VALUES ('Estats Units', 9850000, 322000000, 'usa', 'Washington')");
        db.execSQL("INSERT INTO PAISOS(name, area, population, codiBandera, capital) VALUES ('Russia', 17100000, 146000000, 'rus', 'Moscou')");
        db.execSQL("INSERT INTO PAISOS(name, area, population, codiBandera, capital) VALUES ('Xina', 9600000, 1376000000, 'xin', 'Pequín')");
        db.execSQL("INSERT INTO PAISOS(name, area, population, codiBandera, capital) VALUES ('Narnia', 150000, 25000000, 'nar', 'Cair Paravel')");
        db.execSQL("INSERT INTO PAISOS(name, area, population, codiBandera, capital) VALUES ('Japó', 378000, 127000000, 'jap', 'Tòquio')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Paisos");
        db.execSQL(SQL_CREATE_PAISOS);
        db.execSQL("INSERT INTO PAISOS(name, area, population, codiBandera, capital) VALUES ('Catalunya', 32000, 7500000, 'cat', 'Barcelona')");
        db.execSQL("INSERT INTO PAISOS(name, area, population, codiBandera, capital) VALUES ('Regne Unit', 243000, 64500000, 'uk', 'Londres')");
        db.execSQL("INSERT INTO PAISOS(name, area, population, codiBandera, capital) VALUES ('Alemanya', 357000, 81200000, 'ale', 'Berlin')");
        db.execSQL("INSERT INTO PAISOS(name, area, population, codiBandera, capital) VALUES ('França', 641000, 66300000, 'fra', 'Paris')");
        db.execSQL("INSERT INTO PAISOS(name, area, population, codiBandera, capital) VALUES ('Itàlia', 301000, 60700000, 'ita', 'Roma')");
        db.execSQL("INSERT INTO PAISOS(name, area, population, codiBandera, capital) VALUES ('Estats Units', 9850000, 322000000, 'usa', 'Washington')");
        db.execSQL("INSERT INTO PAISOS(name, area, population, codiBandera, capital) VALUES ('Russia', 17100000, 146000000, 'rus', 'Moscou')");
        db.execSQL("INSERT INTO PAISOS(name, area, population, codiBandera, capital) VALUES ('Xina', 9600000, 1376000000, 'xin', 'Pequín')");
        db.execSQL("INSERT INTO PAISOS(name, area, population, codiBandera, capital) VALUES ('Narnia', 150000, 25000000, 'nar', 'Cair Paravel')");
        db.execSQL("INSERT INTO PAISOS(name, area, population, codiBandera, capital) VALUES ('Japó', 378000, 127000000, 'jap', 'Tòquio')");
    }
}
