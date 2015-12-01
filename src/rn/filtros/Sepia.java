package rn.filtros;

import rn.imagem.Imagem;
import java.awt.Color;
import java.awt.image.BufferedImage;

public final class Sepia extends Filtro {

    public Sepia(Imagem imagem) {
        super(imagem);
        setTipo("Filtro Sépia");
    }

    @Override
    public void executar() {
        BufferedImage novaImagem = new BufferedImage(getLargura(), getAltura(), BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < getLargura(); i++) {
            for (int j = 0; j < getAltura(); j++) {
                Color c = new Color(getImagem().getRGB(i, j));
                int r = (int) (0.393 * c.getRed() + 0.769 * c.getGreen() + 0.189 * c.getBlue());
                int g = (int) (0.349 * c.getRed() + 0.686 * c.getGreen() + 0.168 * c.getBlue());
                int b = (int) (0.272 * c.getRed() + 0.534 * c.getGreen() + 0.131 * c.getBlue());

                if (r > 255) {
                    r = 255;
                }

                if (g > 255) {
                    g = 255;
                }

                if (b > 255) {
                    b = 255;
                }
                Color color = new Color(r, g, b);
                novaImagem.setRGB(i, j, color.getRGB());
            }
        }
        atualizaImagem(novaImagem);
    }

}
