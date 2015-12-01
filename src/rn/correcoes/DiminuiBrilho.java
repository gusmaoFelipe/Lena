package rn.correcoes;

import rn.imagem.Imagem;

public class DiminuiBrilho extends CorrecaoBrilho {

    public DiminuiBrilho(Imagem imagem) {
        super(imagem);
        executar();
    }

    @Override
    public double getFator() {
        return BRIGHTNESS_FACTOR_NEGATIVE;
    }

}
