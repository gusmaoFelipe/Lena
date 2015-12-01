package rn.escala_de_cinza;

import rn.imagem.Imagem;
import java.awt.Color;

public class HSV extends EscalaDeCinza {

    public HSV(Imagem imagem) {
        super(imagem);
        setTipo("Escala de Cinza: HSV");
    }

    @Override
    public int calcularPixel(Color c) {
        int v = Math.max(c.getBlue(), c.getGreen());
        v = Math.max(c.getRed(), v);
        return v;
    }
}
