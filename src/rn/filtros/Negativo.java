package rn.filtros;

import rn.imagem.Imagem;
import java.awt.Color;

public class Negativo extends Filtro {

    public Negativo(Imagem imagem) {
        super(imagem);
        setTipo("Negativo");
    }

    @Override
    public void executar() {
        for (int i = 0; i < getLargura(); i++) {
            for (int j = 0; j < getAltura(); j++) {
                int rgb = getImagem().getRGB(i, j); 				//a cor inversa é dado por 255 menos o valor de cada canal 				
                int r = 255 - (int) ((rgb & 0x00FF0000) >>> 16);
                int g = 255 - (int) ((rgb & 0x0000FF00) >>> 8);
                int b = 255 - (int) (rgb & 0x000000FF);
                Color color = new Color(r, g, b);
                getImagem().setRGB(i, j, color.getRGB());
            }
        }
    }

}
