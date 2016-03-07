package net.infobosccoma.paisos.presenters.impl;


import net.infobosccoma.paisos.models.business.entities.Pais;
import net.infobosccoma.paisos.presenters.interfaces.IDetailViewPresenter;
import net.infobosccoma.paisos.views.interfaces.IDetailView;


public class DetailViewPresenterImpl implements IDetailViewPresenter {

	private IDetailView view;
	private Pais pais;

	@Override
	public void onCreate(IDetailView detailView, Pais pais) {
		view = detailView;
		this.pais = pais;

		view.setName(pais.getName());
		view.setArea(pais.getArea());
		view.setPopulation(pais.getPopulation());
		view.setImage(pais.getCodiBandera());
		view.setCapital(pais.getCapital());

	}

}
