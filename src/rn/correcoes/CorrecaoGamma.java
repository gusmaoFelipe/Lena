/**
 * Classe Correcao,
 */
package rn.correcoes;

import rn.imagem.Imagem;
import rn.imagem.ImagemEditavel;
import java.awt.Color;

public abstract class CorrecaoGamma extends ImagemEditavel {

    public final double GAMMA_FACTOR_POSITIVE = 0.95;
    public final double GAMMA_FACTOR_NEGATIVE = 1.05;

    protected double fator;

    public CorrecaoGamma(Imagem imagem) {
        super(imagem);
        executar();
        setTipo("Correção Gamma");
    }

    @Override
    public void executar() {

        for (int i = 0; i < getLargura(); i++) {
            for (int j = 0; j < getAltura(); j++) {
                Color c = new Color(getImagem().getRGB(i, j));

                int r = (int) (Math.pow(c.getRed() / 255.0, getFator()) * 255);
                int g = (int) (Math.pow(c.getGreen() / 255.0, getFator()) * 255);
                int b = (int) (Math.pow(c.getBlue() / 255.0, getFator()) * 255);

                Color color = new Color(r, g, b);
                getImagem().setRGB(i, j, color.getRGB());

            }
        }
    }

    @Override
    public double getFator() {
        return 0;
    }

}
