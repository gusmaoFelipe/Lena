package excecao;

import javax.swing.JOptionPane;

/**
 * Classe para mensagens de erro: as funções geram JOptionPane informando sobre
 * o erro
 */
public class Excecoes extends Exception {

    public static final int ERRO_ENTRADA = 0;
    public static final int ERRO_SAIDA = 1;

    public final String FORMATO_NAO_SUPORTADO = "Formato de arquivo não suportado nesta versão";
    public final String ENTRADA = "Erro de leitura de arquivo";
    public final String SAIDA = "Erro de escrita de arquivo";
    public final String ARQUIVO_NAO_ENCONTRADO = "Arquivo não encontrado";
    public final String PILHA_VAZIA = "Não há alterações anteriores";

    public void formatoNaoSuportado() {
        JOptionPane.showMessageDialog(null, FORMATO_NAO_SUPORTADO);
    }

    /**
     * Pilha de Imagens está vazia
     */
    public void pilhaVazia() {
        JOptionPane.showMessageDialog(null, PILHA_VAZIA);
    }

    /**
     *
     * @param option 0 erro de entrada e 1 para erro de saída
     */
    public void erroEntradaSaida(int option) {
        if (option == 0) {
            JOptionPane.showMessageDialog(null, ENTRADA);
        } else {
            JOptionPane.showMessageDialog(null, SAIDA);
        }
    }

    public void arquivoNaoEncontrado() {
        JOptionPane.showMessageDialog(null, ARQUIVO_NAO_ENCONTRADO);
    }

}
