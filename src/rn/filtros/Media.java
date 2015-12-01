package rn.filtros;

import rn.imagem.Imagem;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

public class Media extends Filtro {

    public Media(Imagem imagem) {
        super(imagem);
        setTipo("Filtro da Média");
    }

    @Override
    protected void executar() {
        BufferedImage novaImagem = new BufferedImage(getLargura(), getAltura(), BufferedImage.TYPE_3BYTE_BGR);
        float data[] = {1.0f / 9.0f, 1.0f / 9.0f, 1.0f / 9.0f,
            1.0f / 9.0f, 1.0f / 9.0f, 1.0f / 9.0f,
            1.0f / 9.0f, 1.0f / 9.0f, 1.0f / 9.0f,};

        Kernel kernel = new Kernel(3, 3, data);
        ConvolveOp convolve = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
        convolve.filter(getImagem(), novaImagem);
        setImagem(novaImagem);
        atualizaImagem(novaImagem);
    }

}
