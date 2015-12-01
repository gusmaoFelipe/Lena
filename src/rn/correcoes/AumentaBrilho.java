package rn.correcoes;

import rn.imagem.Imagem;

/**
 * Classe AumentaBrilho. Classe que fornece a alteração do brilho na imagem
 */
public class AumentaBrilho extends CorrecaoBrilho {

    /**
     * Construtor para Aumentar Brilho. Executa
     *
     * @param imagem
     */
    public AumentaBrilho(Imagem imagem) {
        super(imagem);
        executar();
    }

    /**
     * @return BRIGHTNESS_FACTOR_POSITIVE
     */
    @Override
    public double getFator() {
        return BRIGHTNESS_FACTOR_POSITIVE;
    }

}
