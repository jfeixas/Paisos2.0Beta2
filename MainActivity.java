package net.infobosccoma.paisos.views.impl.activities;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import net.infobosccoma.paisos.R;
import net.infobosccoma.paisos.models.business.entities.Pais;
import net.infobosccoma.paisos.models.persistence.daos.impl.PaisosSQliteDAO;
import net.infobosccoma.paisos.models.persistence.daos.interfaces.PaisosDAO;
import net.infobosccoma.paisos.presenters.impl.MainViewPresenterImpl;
import net.infobosccoma.paisos.presenters.interfaces.IMainViewPresenter;
import net.infobosccoma.paisos.views.impl.adapters.PaisListAdapter;
import net.infobosccoma.paisos.views.impl.adapters.SearchAdapter;
import net.infobosccoma.paisos.views.interfaces.IMainView;


public class MainActivity extends AppCompatActivity implements IMainView, AdapterView.OnItemClickListener {


    private ListView list;
    private ProgressBar progressBar;
    private Button btnRetry;
    private IMainViewPresenter presenter;
    private EditText buscador;
    private List<Pais> llistaPaisos;
    private PaisListAdapter adapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.list);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        btnRetry = (Button) findViewById(R.id.retry);
        //buscador = (SearchView) findViewById(R.id.action_search);
        buscador = (EditText) findViewById(R.id.action_search);

        presenter = new MainViewPresenterImpl();
        presenter.onCreate(this, getBaseContext());
        presenter.getPaisosFromService();

        /*buscador.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text

                MainActivity.this.adapter.getFilter().filter(cs);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) { }

            @Override
            public void afterTextChanged(Editable arg0) {}
        });*/

    }

    @Override
    public PaisListAdapter createPaisAdapter(List<Pais> paisos) {
        return new PaisListAdapter(this, paisos);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.detail, menu);
        return true;
    }

    @Override
    public void goToDetailActivity(Pais pais) {
        Intent intent = new Intent(this, DetailActivity.class);
        // quan s'han d'enviar objectes es fa embolcallant-los.
        // ens ajudem d'una llibreria externa, per no haver d'implementar la interface Parcelable
        intent.putExtra("PAIS", Parcels.wrap(pais));
        startActivityForResult(intent, 2);
    }

    @Override
    public void goToAfegirActivity() {
        Intent intent = new Intent(this, AfegirActivity.class);

        startActivityForResult(intent, 1);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        presenter.showList();
    }

    @Override
    public void createList(PaisListAdapter adapter) {
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
    }

    @Override
    public void createSearchList(SearchAdapter adapter) {

    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showRetryButton() {
        btnRetry.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideRetryButton() {
        btnRetry.setVisibility(View.GONE);
    }

    @Override
    public void showList() {
        list.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideList() {
        list.setVisibility(View.GONE);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        presenter.onItemClicked(position);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // action with ID action_refresh was selected
            case R.id.action_afegir:
                goToAfegirActivity();
                break;
            case R.id.action_sobre:
                showMessage("Paisos App, versió 1.0 Beta 1\nActualitzacions properament...");
                //Toast.makeText(getBaseContext(), "Paisos App, versió 1.0 Beta 1\nActualitzacions properament...", Toast.LENGTH_LONG).show();
                break;
            case R.id.action_search:
                showMessage("ha entrat aquí");
                //filtrarCerca();
                break;
            case R.id.action_sortir:
                finish();
                break;
            // action with ID action_settings was selected
            default:
                break;
        }

        return true;
    }

   /* public void filtrarCerca(List<Pais> paisos) {

        Pais p;
        PaisosDAO paisosDAO = new PaisosSQliteDAO(getBaseContext());
        p = paisosDAO.getByName(buscador.getQuery().toString());

        showMessage(p.getName());

        //list.setAdapter(createSearchAdapter(paisos));
    }*/




}
