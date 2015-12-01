package rn.correcoes;

import rn.imagem.Imagem;

public class GammaPositivo extends CorrecaoGamma {

    public GammaPositivo(Imagem imagem) {
        super(imagem);
    }

    @Override
    public double getFator() {
        return this.GAMMA_FACTOR_POSITIVE;
    }

}
