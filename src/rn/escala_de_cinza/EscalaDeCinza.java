package rn.escala_de_cinza;

import rn.imagem.Imagem;
import rn.imagem.ImagemEditavel;
import java.awt.Color;

public abstract class EscalaDeCinza extends ImagemEditavel {

    public EscalaDeCinza(Imagem imagem) {
        super(imagem);
        executar();
    }

    @Override
    public void executar() {
        for (int i = 0; i < getLargura(); i++) {
            for (int j = 0; j < getAltura(); j++) {
                Color c = new Color(getImagem().getRGB(i, j));
                int valor = calcularPixel(c);
                c = new Color(valor, valor, valor);
                getImagem().setRGB(i, j, c.getRGB());
            }
        }
    }

    public int calcularPixel(Color c) {
        return 0;           //pois está na classe abstrata
    }
}
