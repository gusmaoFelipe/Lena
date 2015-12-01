package rn.imagem;

import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

public abstract class ImagemEditavel {

    protected Imagem alterada;
    private int largura;
    private int altura;

    protected String tipo;

    public ImagemEditavel(Imagem imagem) {
        this.alterada = imagem;
        this.largura = getImagem().getWidth();
        this.altura = getImagem().getHeight();
        executar();
    }

    protected void executar() {
        System.out.println("FOO");
    }

    protected void atualizaImagem(BufferedImage novaImagem) {
        setImagem(novaImagem);
        getAlteracao().setIcone(new ImageIcon(novaImagem));
    }

    protected Imagem getAlteracao() {
        return this.alterada;
    }

    protected BufferedImage getImagem() {
        return this.alterada.imagem;
    }

    protected void setImagem(BufferedImage novaImagem) {
        this.alterada.imagem = novaImagem;
    }

    /**
     * @return the largura
     */
    protected int getLargura() {
        return largura;
    }

    /**
     * @return the altura
     */
    protected int getAltura() {
        return altura;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getFator() {
        return 0;
    }

}
