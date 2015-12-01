package rn.correcoes;

import rn.imagem.Imagem;
import rn.imagem.ImagemEditavel;
import java.awt.Color;

/**
 * Classe CorrecaoBrilho. Classe abstrata que fornece a alteração na imagem para
 * as classes filhas
 */
public abstract class CorrecaoBrilho extends ImagemEditavel {

    public final int BRIGHTNESS_FACTOR_POSITIVE = 5;
    public final int BRIGHTNESS_FACTOR_NEGATIVE = -5;

    protected int fator;

    public CorrecaoBrilho(Imagem imagem) {
        super(imagem);
    }

    /**
     * executar(). Realiza a alteração de brilho na imagem; a função getFactor()
     * será executada nos objetos filhos por meio do polimorfismo
     */
    @Override
    public void executar() {
        for (int i = 0; i < getLargura(); i++) {
            for (int j = 0; j < getAltura(); j++) {
                Color c = new Color(getImagem().getRGB(i, j));

                int r = (int) c.getRed() + (int) getFator();
                int g = (int) c.getGreen() + (int) getFator();
                int b = (int) c.getBlue() + (int) getFator();

                if (r > 255) {
                    r = 255;
                } else if (r < 0) {
                    r = 0;
                }
                if (g > 255) {
                    g = 255;
                } else if (g < 0) {
                    g = 0;
                }
                if (b > 255) {
                    b = 255;
                } else if (b < 0) {
                    b = 0;
                }

                Color color = new Color(r, g, b);
                getImagem().setRGB(i, j, color.getRGB());
            }
        }
    }

    /**
     *
     * @return o Fator a ser aplicado na correção
     */
    @Override
    public double getFator() {
        return 0;
    }

}
