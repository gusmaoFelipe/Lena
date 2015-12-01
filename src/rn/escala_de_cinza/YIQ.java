package rn.escala_de_cinza;

import rn.imagem.Imagem;
import java.awt.Color;

public class YIQ extends EscalaDeCinza {

    public YIQ(Imagem imagem) {
        super(imagem);
        setTipo("Escala de Cinza: NTSC/PAL");
    }

    @Override
    public int calcularPixel(Color c) {
        return (int) (0.299 * c.getRed() + 0.587 * c.getGreen() + 0.114 * c.getBlue());
    }

}
