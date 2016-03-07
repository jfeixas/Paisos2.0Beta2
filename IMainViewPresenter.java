package net.infobosccoma.paisos.presenters.interfaces;


import android.content.Context;

import net.infobosccoma.paisos.views.interfaces.IMainView;

public interface IMainViewPresenter {

    public void onCreate(IMainView view, Context context);

    public void getPaisosFromService();

    public void showList();

    public void onItemClicked(int position);

}
