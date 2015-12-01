package gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * Classe para realizar alterações e leituras no arquivo de configuração do
 * sistema. O arquivo de configuração (config.txt) está localizado na pasta
 * "config"
 */
public class Config {

    private final String ARQUIVO_CONFIGURACAO = "config/config.txt";

    InputStream is;
    InputStreamReader isr;
    BufferedReader br;

    OutputStream os;
    OutputStreamWriter osr;
    BufferedWriter bw;

    /**
     * Ler. Função para ler o inteiro presente no arquivo de texto de
     * configuração
     *
     * @return opcao: inteiro presente no arquivo de configuração | -1: erro de
     * leitura de arquivo
     */
    public int ler() {
        try {
            is = new FileInputStream(new File(ARQUIVO_CONFIGURACAO));
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            int opcao = Integer.parseInt(br.readLine());
            br.close();
            return opcao;
        } catch (IOException ex) {
            new excecao.Excecoes().erroEntradaSaida(excecao.Excecoes.ERRO_ENTRADA);
        }
        return -1;
    }

    /**
     * Escrever. Função para escrever um inteiro no arquivo de texto de
     * configuração
     *
     * @param opcao
     */
    public void escrever(int opcao) {
        try {
            os = new FileOutputStream(new File(ARQUIVO_CONFIGURACAO));
            osr = new OutputStreamWriter(os);
            bw = new BufferedWriter(osr);
            bw.write(String.valueOf(opcao));
            bw.close();
        } catch (FileNotFoundException fx) {
            new excecao.Excecoes().arquivoNaoEncontrado();
        } catch (IOException ex) {
            new excecao.Excecoes().erroEntradaSaida(excecao.Excecoes.ERRO_ENTRADA);
        }
    }
}
