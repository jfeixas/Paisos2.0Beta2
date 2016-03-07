package net.infobosccoma.paisos.views.interfaces;


public interface IDetailView {

    // exemple de mètode per assignar una imatge a partir d'una URL
    public void setImage(String codiBandera);

    // mètodes per assignar el nom i cognom
    public void setName(String text);
    public void setArea(int area);
    public void setPopulation(int population);
    public void setCapital(String capital);
    //public void setHimne(String codiBandera);
}
