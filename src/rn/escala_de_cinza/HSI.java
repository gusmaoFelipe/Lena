package rn.escala_de_cinza;

import rn.imagem.Imagem;
import java.awt.Color;

public class HSI extends EscalaDeCinza {

    public HSI(Imagem imagem) {
        super(imagem);
        setTipo("Escala de Cinza: HSI");
    }

    @Override
    public int calcularPixel(Color c) {
        return (int) (c.getRed() + c.getGreen() + c.getBlue()) / 3;
    }
}
