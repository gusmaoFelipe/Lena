package rn.imagem;

public interface Zoom {

    //Para a primeira versao, foi implementado somente dois fatores
    //por isso não as funções aumentar e diminuir nao recebem a escala
    public static final double SCALE_FACTOR_ZOOM_IN = 0.5;
    public static final double SCALE_FACTOR_ZOOM_OUT = 2.0;

    public void aumentar();

    public void diminuir();

    public double getFator();

    public void setFator(double valor);
}
