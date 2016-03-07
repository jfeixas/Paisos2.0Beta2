package net.infobosccoma.paisos.views.interfaces;

import android.view.MenuItem;

import net.infobosccoma.paisos.models.business.entities.Pais;
import net.infobosccoma.paisos.views.impl.adapters.PaisListAdapter;
import net.infobosccoma.paisos.views.impl.adapters.SearchAdapter;

import java.util.List;


public interface IMainView {

    public void createList(PaisListAdapter adapter);

    public void createSearchList(SearchAdapter adapter);

    public PaisListAdapter createPaisAdapter(List<Pais> paisos);

    public void goToDetailActivity(Pais paisos);

    public void goToAfegirActivity();

    public void showProgressBar();

    public void hideProgressBar();

    public void showRetryButton();

    public void hideRetryButton();

    public void showList();

    public void hideList();

    public void showMessage(String message);

    public boolean onOptionsItemSelected(MenuItem item);
}
