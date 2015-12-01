package rn.correcoes;

import rn.imagem.Imagem;

public class GammaNegativo extends CorrecaoGamma {

    public GammaNegativo(Imagem imagem) {
        super(imagem);
    }

    @Override
    public double getFator() {
        return this.GAMMA_FACTOR_NEGATIVE;
    }

}
