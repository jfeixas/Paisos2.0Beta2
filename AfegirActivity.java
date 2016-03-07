package net.infobosccoma.paisos.views.impl.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import net.infobosccoma.paisos.R;
import net.infobosccoma.paisos.models.business.entities.Pais;
import net.infobosccoma.paisos.models.persistence.daos.impl.PaisosSQliteDAO;
import net.infobosccoma.paisos.models.persistence.daos.interfaces.PaisosDAO;
import net.infobosccoma.paisos.presenters.impl.AfegirViewPresenterImpl;
import net.infobosccoma.paisos.presenters.interfaces.IAfegirViewPresenter;
import net.infobosccoma.paisos.views.interfaces.IAfegirView;

import org.parceler.Parcels;

public class AfegirActivity extends AppCompatActivity implements IAfegirView {

    private EditText txtName;
    private EditText txtArea;
    private EditText txtPopulation;
    private EditText txtCapital;
    private EditText txtBandera;

    private IAfegirViewPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afegir);

        presenter = new AfegirViewPresenterImpl();
        presenter.onCreate(this);

    }

    public void goToMainActivity(View v) {
        finish();
    }

    public void afegirNouPais(View v) {

        Pais nouPais = new Pais();

        txtName = (EditText) findViewById(R.id.txt_afegir_nom);
        txtArea = (EditText) findViewById(R.id.txt_afegir_area);
        txtPopulation = (EditText) findViewById(R.id.txt_afegir_poblacio);
        txtCapital = (EditText) findViewById(R.id.txt_afegir_capital);
        txtBandera = (EditText) findViewById(R.id.txt_afegir_bandera);
        nouPais.setName(txtName.getText().toString());
        nouPais.setArea(Integer.valueOf(txtArea.getText().toString()));
        nouPais.setPopulation(Integer.valueOf(txtPopulation.getText().toString()));
        nouPais.setCodibandera(txtBandera.getText().toString());
        nouPais.setCapital(txtCapital.getText().toString());

        PaisosDAO paisosDAO = new PaisosSQliteDAO(getBaseContext());
        paisosDAO.save(nouPais);

        Toast.makeText(getBaseContext(), "Nou pais afegit correctament!", Toast.LENGTH_LONG).show();

        txtName.setText("");
        txtArea.setText("");
        txtPopulation.setText("");
        txtCapital.setText("");
        txtBandera.setText("");
    }

    @Override
    public void goToMainActivity(Pais paisos) {

    }

    @Override
    public void afegirNouPais() {

    }
}
