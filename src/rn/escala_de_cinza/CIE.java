package rn.escala_de_cinza;

import rn.imagem.Imagem;
import java.awt.Color;

public class CIE extends EscalaDeCinza {

    public CIE(Imagem imagem) {
        super(imagem);
        setTipo("Escala de Cinza: CIE");
    }

    @Override
    public int calcularPixel(Color c) {
        return (int) (0.2125 * c.getRed() + 0.7154 * c.getGreen() + 0.0721 * c.getBlue());
    }

}
