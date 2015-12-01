package rn.filtros;

import rn.imagem.Imagem;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class Mediana extends Filtro {

    public Mediana(Imagem imagem) {
        super(imagem);
        setTipo("Filtro Mediana");
    }

    @Override
    public void executar() {
        BufferedImage novaImagem = new BufferedImage(getLargura(), getAltura(), BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < getLargura(); i++) {
            for (int j = 0; j < getAltura(); j++) {
                if (i == 0
                        || j == 0
                        || j == getAltura() - 1
                        || i == getLargura() - 1) {
                    novaImagem.setRGB(i, j, getImagem().getRGB(i, j));
                }
            }
        }
        int[] vetor = new int[9];
        for (int i = 1; i < getLargura() - 1; i++) {
            for (int j = 1; j < getAltura() - 1; j++) {
                int h = 0x000000FF;
                vetor[0] = (getImagem().getRGB(i - 1, j - 1) & h);
                vetor[1] = (getImagem().getRGB(i - 1, j) & h);
                vetor[2] = (getImagem().getRGB(i - 1, j + 1) & h);
                vetor[3] = (getImagem().getRGB(i, j - 1) & h);
                vetor[4] = (getImagem().getRGB(i, j) & h);
                vetor[5] = (getImagem().getRGB(i, j + 1) & h);
                vetor[6] = (getImagem().getRGB(i + 1, j - 1) & h);
                vetor[7] = (getImagem().getRGB(i + 1, j) & h);
                vetor[8] = (getImagem().getRGB(i + 1, j + 1) & h);

                int k;
                for (k = 1; k < 9; k++) {
                    int l = vetor[k];
                    int m = k - 1;
                    while ((m >= 0) && (l < vetor[m])) {
                        vetor[m + 1] = vetor[m];
                        m--;
                    }
                    vetor[m + 1] = l;
                }
                k = vetor[4];
                Color c = new Color(k, k, k);
                novaImagem.setRGB(i, j, c.getRGB());
            }
        }
        atualizaImagem(novaImagem);
    }

}
