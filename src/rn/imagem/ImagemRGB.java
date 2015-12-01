package rn.imagem;

import java.awt.image.BufferedImage;
import java.io.File;

public class ImagemRGB extends Imagem {

    private int quantidadeCanais;

    public ImagemRGB(File arquivo) {
        super();
    }

    @Override
    public void abrir(File arq) {
        super.abrir(arq);
        this.setQuantidadeCanais();
    }

    public void setQuantidadeCanais() {
        int type = this.imagem.getType();

        if (type == BufferedImage.TYPE_3BYTE_BGR
                || type == BufferedImage.TYPE_INT_RGB
                || type == BufferedImage.TYPE_INT_BGR) {
            this.quantidadeCanais = 3;
        } else if (type == BufferedImage.TYPE_4BYTE_ABGR_PRE
                || type == BufferedImage.TYPE_4BYTE_ABGR_PRE
                || type == BufferedImage.TYPE_INT_ARGB
                || type == BufferedImage.TYPE_INT_ARGB_PRE) {
            this.quantidadeCanais = 4;
        } else if (type == BufferedImage.TYPE_BYTE_GRAY
                || type == BufferedImage.TYPE_BYTE_BINARY
                || type == BufferedImage.TYPE_USHORT_GRAY) {
            this.quantidadeCanais = 1;
        } else {
            this.quantidadeCanais = 0;
        }
    }

    @Override
    public void diminuir() {
        super.diminuir();
        setFator(Zoom.SCALE_FACTOR_ZOOM_IN);
    }

    @Override
    public void aumentar() {
        super.aumentar();
        setFator(Zoom.SCALE_FACTOR_ZOOM_OUT);
    }

    public int getQuantidadeCanais() {
        return this.quantidadeCanais;
    }

    @Override
    public double getFator() {
        return this.fator;
    }

    @Override
    public void setFator(double valor) {
        this.fator = valor;
    }
}
