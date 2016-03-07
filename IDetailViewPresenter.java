package net.infobosccoma.paisos.presenters.interfaces;


import android.widget.MediaController;

import net.infobosccoma.paisos.models.business.entities.Pais;

import net.infobosccoma.paisos.views.interfaces.IDetailView;

public interface IDetailViewPresenter {

	public void onCreate(IDetailView view, Pais pais);

}
