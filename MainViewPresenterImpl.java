package net.infobosccoma.paisos.presenters.impl;


import android.content.Context;

import net.infobosccoma.paisos.helpers.PaisBuilder;
import net.infobosccoma.paisos.models.business.entities.Pais;
import net.infobosccoma.paisos.models.persistence.daos.impl.PaisosSQliteDAO;
import net.infobosccoma.paisos.models.persistence.daos.interfaces.PaisosDAO;
import net.infobosccoma.paisos.presenters.interfaces.IMainViewPresenter;
import net.infobosccoma.paisos.views.interfaces.IMainView;

import java.util.List;


public class MainViewPresenterImpl implements IMainViewPresenter {


    private IMainView view;
    private List<Pais> llistaPaisos;
    private Context context;
    private PaisosDAO paisosDAO;

    @Override
    public void onCreate(IMainView view, Context context) {
        this.view = view;
        this.context = context;
    }

    @Override
    public void getPaisosFromService() {
        view.showProgressBar();
        view.hideList();

        // Aquí, és on demanem les dades
        // En aquest exemple, agafo les dades d'un "creador" de paisos
        //PaisBuilder paisBuilder = new PaisBuilder();
        //llistaPaisos = paisBuilder.getPaisos();

        paisosDAO = new PaisosSQliteDAO(context);
        llistaPaisos = paisosDAO.getAll();

        showList();
    }

    @Override
    public void showList() {
        view.hideProgressBar();
        llistaPaisos = paisosDAO.getAll();
        view.createList(view.createPaisAdapter(llistaPaisos));
        view.showList();
    }

    @Override
    public void onItemClicked(int position) {
        view.goToDetailActivity(llistaPaisos.get(position));
    }
}

