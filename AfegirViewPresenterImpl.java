package net.infobosccoma.paisos.presenters.impl;


import net.infobosccoma.paisos.views.interfaces.IAfegirView;
import net.infobosccoma.paisos.presenters.interfaces.IAfegirViewPresenter;

public class AfegirViewPresenterImpl implements IAfegirViewPresenter {

    private IAfegirView view;

    public void onCreate(IAfegirView afegirView) {
        view = afegirView;
    }


}