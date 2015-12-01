package rn.imagem;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import excecao.Excecoes;
import java.awt.Color;

public abstract class Imagem implements Zoom, Rotacao {

    private String[] EXT_RBG = {"png", "jpg", "bmp"};
    private String[] EXT_PBM = {"pbm"};

    protected File arquivo;
    protected BufferedImage imagem;
    protected String extensao;
    protected ImageIcon icone;
    protected double fator;

    public void abrir(File arq) {
        try {
            this.arquivo = arq;
            this.imagem = ImageIO.read(arq);
            this.icone = new ImageIcon(this.imagem);

            this.extensao = arquivo.getPath();
            this.extensao = extensao.substring(extensao.length() - 3, extensao.length());

            System.out.println("Arquivo aberto com sucesso");

        } catch (FileNotFoundException e1) {
            new Excecoes().arquivoNaoEncontrado();
        } catch (IOException e2) {
            new Excecoes().erroEntradaSaida(Excecoes.ERRO_ENTRADA);
        }
    }

    public void salvar(String endereco) {
        try {
            ImageIO.write(getImagem(), getExtensao(), new File(endereco));
            System.out.println("Arquivo salvo com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro IO Exception! Verifique se o arquivo especificado existe e tente novamente.");
        } catch (Exception e) {
            System.out.println("Erro Exception! " + e.getMessage());
        }
    }

    @Override
    public void aumentar() {
        int width = imagem.getWidth();
        int height = imagem.getHeight();

        int newWidth = width * 2;
        int newHeight = height * 2;

        BufferedImage imageAux = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Color c = new Color(imagem.getRGB(i, j));

                imageAux.setRGB(2 * i, 2 * j, c.getRGB());
                imageAux.setRGB(2 * i + 1, 2 * j, c.getRGB());
                imageAux.setRGB(2 * i, 2 * j + 1, c.getRGB());
                imageAux.setRGB(2 * i + 1, 2 * j + 1, c.getRGB());

            }
        }
        this.imagem = imageAux;
        this.icone = new ImageIcon(imagem);
    }

    @Override
    public void diminuir() {
        int width = imagem.getWidth();
        int height = imagem.getHeight();

        int newWidth = (width + 1) / 2;
        int newHeight = (height + 1) / 2;

        BufferedImage imageAux = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < newWidth; i++) {
            for (int j = 0; j < newHeight; j++) {
                Color c = new Color(imagem.getRGB(i * 2, j * 2));

                imageAux.setRGB(i, j, c.getRGB());

            }
        }
        this.imagem = imageAux;
        this.icone = new ImageIcon(imagem);

    }

    @Override
    public void rotacaoEsquerda() {
        BufferedImage imagemAux = new BufferedImage(getImagem().getHeight(), getImagem().getWidth(), BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < getImagem().getWidth(); i++) {
            for (int j = 0; j < getImagem().getHeight(); j++) {
                Color pixel = new Color(getImagem().getRGB(i, j));
                imagemAux.setRGB(j, getImagem().getWidth() - 1 - i, pixel.getRGB());
            }
        }
        setImagem(imagemAux);
        setIcone(new ImageIcon(imagemAux));
    }

    @Override
    public void rotacaoDireita() {
        BufferedImage imagemAux = new BufferedImage(getImagem().getHeight(), getImagem().getWidth(), BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < getImagem().getWidth(); i++) {
            for (int j = 0; j < getImagem().getHeight(); j++) {
                Color pixel = new Color(getImagem().getRGB(i, j));
                imagemAux.setRGB(getImagem().getHeight() - 1 - j, i, pixel.getRGB());
            }
        }
        setImagem(imagemAux);
        setIcone(new ImageIcon(imagemAux));
    }

    // ---- MODIFICADORES E ACESSO ---- //
    /**
     * @return the EXT_RBG
     */
    public String[] getEXT_RBG() {
        return EXT_RBG;
    }

    /**
     * @param EXT_RBG the EXT_RBG to set
     */
    public void setEXT_RBG(String[] EXT_RBG) {
        this.EXT_RBG = EXT_RBG;
    }

    /**
     * @return the EXT_PBM
     */
    public String[] getEXT_PBM() {
        return EXT_PBM;
    }

    /**
     * @param EXT_PBM the EXT_PBM to set
     */
    public void setEXT_PBM(String[] EXT_PBM) {
        this.EXT_PBM = EXT_PBM;
    }

    /**
     * @return the arquivo
     */
    public File getArquivo() {
        return arquivo;
    }

    /**
     * @param arquivo the arquivo to set
     */
    public void setArquivo(File arquivo) {
        this.arquivo = arquivo;
    }

    /**
     * @return the imagem
     */
    public BufferedImage getImagem() {
        return imagem;
    }

    /**
     * @param imagem the imagem to set
     */
    public void setImagem(BufferedImage imagem) {
        this.imagem = imagem;
    }

    /**
     * @return the extensao
     */
    public String getExtensao() {
        return extensao;
    }

    /**
     * @param extensao the extensao to set
     */
    public void setExtensao(String extensao) {
        this.extensao = extensao;
    }

    /**
     * @return the icone
     */
    public ImageIcon getIcone() {
        return icone;
    }

    /**
     * @param icone the icone to set
     */
    public void setIcone(ImageIcon icone) {
        this.icone = icone;
    }

}
