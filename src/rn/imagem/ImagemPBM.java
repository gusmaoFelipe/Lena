package rn.imagem;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class ImagemPBM extends Imagem {

    private int altura;
    private int largura;
    private int[][] matriz;

    public ImagemPBM(File arquivo) {
    }

    @Override
    public void abrir(File arq) {
        try {
            //carrega stream da nova imagem
            FileInputStream fis = new FileInputStream(arq);
            DataInputStream dis = new DataInputStream(fis);

            //Testando se arquivo é padrão P1
            if (!"P1".equals(dis.readLine())) {
                System.out.println("Erro IO: arquivo não está no formato correto. Por favor abra um arquivo em formato P1.");
            }

            String linha;
            do {
                //ignorando comentários
                linha = dis.readLine();
            } while (linha.charAt(0) == '#');

            //Lendo largura
            String aux = "";
            int i = 0;
            char c = linha.charAt(0);
            while (c != '\t') {
                aux += c;
                ++i;
                c = linha.charAt(i);
            }
            ++i;
            setLargura((int) Integer.valueOf(aux));

            //Lendo altura
            aux = "";
            while (i < linha.length()) {
                c = linha.charAt(i);
                aux += c;
                ++i;
            }
            setAltura(Integer.valueOf(aux));

            setMatriz(new int[getLargura()][getAltura()]);

            //Lendo imagem
            for (i = 0; i < getAltura(); i++) {
                aux = dis.readLine();
                for (int j = 0; j < aux.length(); j += 2) {
                    if (aux.charAt(j) == '1') {
                        this.setMatriz(0, j / 2, i);
                    } else {
                        this.setMatriz(1, j / 2, i);
                    }
                }
            }

            this.imagem = new BufferedImage(getLargura(), getAltura(), BufferedImage.BITMASK);
            //preenchendo imagem
            Color color;
            for (int contadorLargura = 0; contadorLargura < getLargura(); contadorLargura++) {
                for (int contadorAltura = 0; contadorAltura < getAltura(); contadorAltura++) {
                    int valor = getMatriz()[contadorLargura][contadorAltura] * 255;
                    color = new Color(valor, valor, valor);
                    imagem.setRGB(contadorLargura, contadorAltura, color.getRGB());
                }
            }

            this.icone = new ImageIcon(imagem);
            this.extensao = "pbm";
            this.arquivo = arq;
        } catch (IOException e) {
            System.out.println("Erro IO Exception: Verifique se o arquivo especificado existe e tente novamente.");
        } catch (NumberFormatException e) {
            System.out.println("Erro Exception: " + e.getMessage());
        }
    }

    @Override
    public void salvar(String endereco) {
        try {
            File f = new File(endereco);
            f.createNewFile();
            try (PrintWriter p = new PrintWriter(new FileWriter(f))) {
                if (!f.canWrite()) {
                    throw new IOException("Não pode ler arquivo");
                }
                p.println("P1");
                p.println("# " + endereco);
                p.println(getLargura() + "\t" + getAltura());
                for (int i = 0; i < getAltura(); i++) {
                    for (int j = 0; j < getLargura(); j++) {
                        p.print(String.valueOf(getMatriz()[j][i]) + " ");
                    }
                    p.print("\n");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ImagemPBM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void aumentar() {
        ImagemPBM novaImagem = new ImagemPBM(arquivo);
        novaImagem.setAltura(this.altura * 2);
        novaImagem.setLargura(this.largura * 2);
        novaImagem.setMatriz(new int[novaImagem.getLargura()][novaImagem.getAltura()]);

        BufferedImage newImage;
        newImage = new BufferedImage(novaImagem.getLargura(), novaImagem.getAltura(), BufferedImage.TYPE_3BYTE_BGR);

        Color c;
        int valor;
        for (int j = 0; j < this.getAltura(); j++) {
            for (int i = 0; i < this.getLargura(); i++) {
                valor = this.getMatriz(i, j) * 255;
                c = new Color(valor, valor, valor);
                //Preenchendo Imagem
                novaImagem.setMatriz(this.getMatriz(i, j), 2 * i, 2 * j);
                novaImagem.setMatriz(this.getMatriz(i, j), 2 * i + 1, 2 * j);
                novaImagem.setMatriz(this.getMatriz(i, j), 2 * i, 2 * j + 1);
                novaImagem.setMatriz(this.getMatriz(i, j), 2 * i + 1, 2 * j + 1);
                //Preenchendo buffer
                newImage.setRGB(2 * i, 2 * j, c.getRGB());
                newImage.setRGB(2 * i + 1, 2 * j, c.getRGB());
                newImage.setRGB(2 * i, 2 * j + 1, c.getRGB());
                newImage.setRGB(2 * i + 1, 2 * j + 1, c.getRGB());
            }
        }
        this.setMatriz(novaImagem.getMatriz());
        this.setAltura(novaImagem.getAltura());
        this.setLargura(novaImagem.getLargura());
        this.setImagem(newImage);
        this.setIcone(new ImageIcon(newImage));
        this.setFator(Zoom.SCALE_FACTOR_ZOOM_OUT);
    }

    @Override
    public void diminuir() {
        ImagemPBM novaImagem = new ImagemPBM(arquivo);
        novaImagem.setAltura((this.altura + 1) / 2);
        novaImagem.setLargura((this.largura + 1) / 2);
        novaImagem.setMatriz(new int[novaImagem.getLargura()][novaImagem.getAltura()]);

        BufferedImage newImage;
        newImage = new BufferedImage(novaImagem.getLargura(), novaImagem.getAltura(), BufferedImage.TYPE_3BYTE_BGR);

        Color c;
        int valor;
        for (int j = 0; j < this.getAltura(); j += 2) {
            for (int i = 0; i < this.getLargura(); i += 2) {
                valor = this.getMatriz(i, j) * 255;
                c = new Color(valor, valor, valor);
                //Preenchendo Imagem
                novaImagem.setMatriz(getMatriz(i, j), i / 2, j / 2);
                //Preenchendo buffer
                newImage.setRGB(i / 2, j / 2, c.getRGB());
            }
        }
        this.setMatriz(novaImagem.getMatriz());
        this.setAltura(novaImagem.getAltura());
        this.setLargura(novaImagem.getLargura());
        this.setImagem(newImage);
        this.setIcone(new ImageIcon(newImage));
        this.setFator(Zoom.SCALE_FACTOR_ZOOM_IN);
    }

    // -- MODIFICADORES E ACESSO -- //
    /**
     * @return the altura
     */
    public int getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(int altura) {
        this.altura = altura;
    }

    /**
     * @return the largura
     */
    public int getLargura() {
        return largura;
    }

    /**
     * @param largura the largura to set
     */
    public void setLargura(int largura) {
        this.largura = largura;
    }

    /**
     * @return the matriz
     */
    public int[][] getMatriz() {
        return matriz;
    }

    /**
     * @param matriz the matriz to set
     */
    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }

    public void setMatriz(int valor, int x, int y) {
        this.matriz[x][y] = valor;
    }

    public int getMatriz(int x, int y) {
        return this.matriz[x][y];
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
