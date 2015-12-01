package rn.imagem;

public interface Rotacao {

    //Para a primeira versao, foi implementado somente duas direoes
    //por isso as funções de rotacao nao recebem parametros
    public static final double GRAU_ROTACAO_ESQUERDA = 90;
    public static final double GRAU_ROTACAO_DIREITA = 90;

    public void rotacaoEsquerda();

    public void rotacaoDireita();

}
