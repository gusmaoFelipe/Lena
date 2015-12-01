package gui;

import rn.correcoes.GammaNegativo;
import rn.correcoes.GammaPositivo;
import rn.filtros.Mediana;
import rn.filtros.Sepia;
import rn.filtros.Media;
import rn.filtros.Negativo;
import rn.escala_de_cinza.HSI;
import rn.escala_de_cinza.YIQ;
import rn.escala_de_cinza.HSV;
import rn.escala_de_cinza.CIE;
import rn.imagem.Imagem;
import rn.imagem.ImagemPBM;
import rn.imagem.ImagemRGB;
import rn.imagem.ImagemEditavel;
import excecao.Excecoes;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import rn.correcoes.AumentaBrilho;
import rn.correcoes.DiminuiBrilho;

public class TelaPrincipal extends javax.swing.JFrame implements ActionListener {

    JLabel jLImagem;
    Imagem imagemAtual;
    ImagemEditavel editar;
    JButton[] botoes;
    Point mouseInitial, mouseFinal;

    public static int cont = 0;
    public final int QTDE_FERRAMENTAS = 9;

    public final String[] nomeFerramentas = new String[]{"Aumentar 50%", "Diminuir 50%", "Rotacionar à Esquerda",
        "Rotacionar à Direita", "Aumentar Brilho", "Diminuir Brilho", "Recortar", "Negativo", "Escala de Cinza"};

    public TelaPrincipal() {
        initComponents();
        jLImagem = new JLabel();
        jLImagem.setAlignmentX(CENTER_ALIGNMENT);
        jLImagem.setAlignmentY(CENTER_ALIGNMENT);
        jPImagem.add(jLImagem);
        botoes = new JButton[QTDE_FERRAMENTAS];
        mouseInitial = new Point(0, 0);
        mouseFinal = new Point(0, 0);
        inicializarFerramentas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPFerramentas = new javax.swing.JPanel();
        jScrollPaneImagem = new javax.swing.JScrollPane();
        jPImagem = new javax.swing.JPanel();
        jMPrincipal = new javax.swing.JMenuBar();
        jMArquivo = new javax.swing.JMenu();
        jMIAbir = new javax.swing.JMenuItem();
        jMISalvar = new javax.swing.JMenuItem();
        jMIFechar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMISair = new javax.swing.JMenuItem();
        jMEditar = new javax.swing.JMenu();
        jMIAumentar = new javax.swing.JMenuItem();
        jMIDiminuir = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMIRotateLeft = new javax.swing.JMenuItem();
        jMIRotateRight = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMIRecortar = new javax.swing.JMenuItem();
        jMImagem = new javax.swing.JMenu();
        jMIAumentarBrilho = new javax.swing.JMenuItem();
        jMIDiminuirBrilho = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMIAumentarGamma = new javax.swing.JMenuItem();
        jMIDiminuirGamma = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jMFiltros = new javax.swing.JMenu();
        jMIFiltroSepia = new javax.swing.JMenuItem();
        jMIMediana = new javax.swing.JMenuItem();
        jMIMedia = new javax.swing.JMenuItem();
        jMINegativo = new javax.swing.JMenuItem();
        jMEscalaDeCinza = new javax.swing.JMenu();
        jMIYIQ = new javax.swing.JMenuItem();
        jMIHSV = new javax.swing.JMenuItem();
        jMIHSI = new javax.swing.JMenuItem();
        jMICIE = new javax.swing.JMenuItem();
        jMJanela = new javax.swing.JMenu();
        jMITemaNormal = new javax.swing.JMenuItem();
        jMITemaEscuro = new javax.swing.JMenuItem();
        jMITemaClaro = new javax.swing.JMenuItem();
        jMIBranco = new javax.swing.JMenuItem();
        jMSobre = new javax.swing.JMenu();
        jMISobreLena = new javax.swing.JMenuItem();
        jMISobreVersao = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Lena");
        setResizable(false);

        jPFerramentas.setBackground(new java.awt.Color(213, 215, 219));
        jPFerramentas.setBorder(null);
        jPFerramentas.setPreferredSize(new java.awt.Dimension(60, 540));

        jPImagem.setBackground(new java.awt.Color(220, 223, 230));
        jPImagem.setLayout(new java.awt.GridLayout(1, 0));
        jScrollPaneImagem.setViewportView(jPImagem);

        jMPrincipal.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N

        jMArquivo.setMnemonic('A');
        jMArquivo.setText("Arquivo");
        jMArquivo.setToolTipText("");
        jMArquivo.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N

        jMIAbir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMIAbir.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jMIAbir.setText("Abrir");
        jMIAbir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIAbirActionPerformed(evt);
            }
        });
        jMArquivo.add(jMIAbir);

        jMISalvar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMISalvar.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jMISalvar.setText("Salvar");
        jMISalvar.setEnabled(false);
        jMISalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMISalvarActionPerformed(evt);
            }
        });
        jMArquivo.add(jMISalvar);

        jMIFechar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        jMIFechar.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jMIFechar.setText("Fechar");
        jMIFechar.setEnabled(false);
        jMIFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIFecharActionPerformed(evt);
            }
        });
        jMArquivo.add(jMIFechar);
        jMArquivo.add(jSeparator1);

        jMISair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMISair.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jMISair.setText("Sair");
        jMISair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMISairActionPerformed(evt);
            }
        });
        jMArquivo.add(jMISair);

        jMPrincipal.add(jMArquivo);

        jMEditar.setMnemonic('E');
        jMEditar.setText("Editar");
        jMEditar.setEnabled(false);
        jMEditar.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N

        jMIAumentar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_EQUALS, java.awt.event.InputEvent.CTRL_MASK));
        jMIAumentar.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jMIAumentar.setText("Aumentar");
        jMIAumentar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIAumentarActionPerformed(evt);
            }
        });
        jMEditar.add(jMIAumentar);

        jMIDiminuir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_MINUS, java.awt.event.InputEvent.CTRL_MASK));
        jMIDiminuir.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jMIDiminuir.setText("Diminuir");
        jMIDiminuir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIDiminuirActionPerformed(evt);
            }
        });
        jMEditar.add(jMIDiminuir);
        jMEditar.add(jSeparator3);

        jMIRotateLeft.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_LEFT, java.awt.event.InputEvent.CTRL_MASK));
        jMIRotateLeft.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jMIRotateLeft.setText("Rotação esquerda");
        jMIRotateLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIRotateLeftActionPerformed(evt);
            }
        });
        jMEditar.add(jMIRotateLeft);

        jMIRotateRight.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_RIGHT, java.awt.event.InputEvent.CTRL_MASK));
        jMIRotateRight.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jMIRotateRight.setText("Rotação Direita");
        jMIRotateRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIRotateRightActionPerformed(evt);
            }
        });
        jMEditar.add(jMIRotateRight);
        jMEditar.add(jSeparator5);

        jMIRecortar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        jMIRecortar.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jMIRecortar.setText("Recortar");
        jMIRecortar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIRecortarActionPerformed(evt);
            }
        });
        jMEditar.add(jMIRecortar);

        jMPrincipal.add(jMEditar);

        jMImagem.setMnemonic('I');
        jMImagem.setText("Imagem");
        jMImagem.setEnabled(false);
        jMImagem.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N

        jMIAumentarBrilho.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMIAumentarBrilho.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jMIAumentarBrilho.setText("Aumentar Brilho");
        jMIAumentarBrilho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIAumentarBrilhoActionPerformed(evt);
            }
        });
        jMImagem.add(jMIAumentarBrilho);

        jMIDiminuirBrilho.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        jMIDiminuirBrilho.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jMIDiminuirBrilho.setText("Diminuir Brilho");
        jMIDiminuirBrilho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIDiminuirBrilhoActionPerformed(evt);
            }
        });
        jMImagem.add(jMIDiminuirBrilho);
        jMImagem.add(jSeparator4);

        jMIAumentarGamma.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMIAumentarGamma.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jMIAumentarGamma.setText("Gamma +");
        jMIAumentarGamma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIAumentarGammaActionPerformed(evt);
            }
        });
        jMImagem.add(jMIAumentarGamma);

        jMIDiminuirGamma.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        jMIDiminuirGamma.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jMIDiminuirGamma.setText("Gamma -");
        jMIDiminuirGamma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIDiminuirGammaActionPerformed(evt);
            }
        });
        jMImagem.add(jMIDiminuirGamma);
        jMImagem.add(jSeparator6);

        jMFiltros.setText("Filtros");
        jMFiltros.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N

        jMIFiltroSepia.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMIFiltroSepia.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jMIFiltroSepia.setText("Sépia");
        jMIFiltroSepia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIFiltroSepiaActionPerformed(evt);
            }
        });
        jMFiltros.add(jMIFiltroSepia);

        jMIMediana.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMIMediana.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jMIMediana.setText("Mediana");
        jMIMediana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIMedianaActionPerformed(evt);
            }
        });
        jMFiltros.add(jMIMediana);

        jMIMedia.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMIMedia.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jMIMedia.setText("Média");
        jMIMedia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIMediaActionPerformed(evt);
            }
        });
        jMFiltros.add(jMIMedia);

        jMINegativo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMINegativo.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jMINegativo.setText("Negativo");
        jMINegativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMINegativoActionPerformed(evt);
            }
        });
        jMFiltros.add(jMINegativo);

        jMImagem.add(jMFiltros);

        jMEscalaDeCinza.setText("Escala de Cinza");
        jMEscalaDeCinza.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N

        jMIYIQ.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_MASK));
        jMIYIQ.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jMIYIQ.setText("NTSC/PAL");
        jMIYIQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIYIQActionPerformed(evt);
            }
        });
        jMEscalaDeCinza.add(jMIYIQ);

        jMIHSV.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.CTRL_MASK));
        jMIHSV.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jMIHSV.setText("HSV");
        jMIHSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIHSVActionPerformed(evt);
            }
        });
        jMEscalaDeCinza.add(jMIHSV);

        jMIHSI.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.CTRL_MASK));
        jMIHSI.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jMIHSI.setText("HSI");
        jMIHSI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIHSIActionPerformed(evt);
            }
        });
        jMEscalaDeCinza.add(jMIHSI);

        jMICIE.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.event.InputEvent.CTRL_MASK));
        jMICIE.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jMICIE.setText("CIE (HDTV)");
        jMICIE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMICIEActionPerformed(evt);
            }
        });
        jMEscalaDeCinza.add(jMICIE);

        jMImagem.add(jMEscalaDeCinza);

        jMPrincipal.add(jMImagem);

        jMJanela.setMnemonic('J');
        jMJanela.setText("Janela");
        jMJanela.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N

        jMITemaNormal.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMITemaNormal.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jMITemaNormal.setText("Normal");
        jMITemaNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMITemaNormalActionPerformed(evt);
            }
        });
        jMJanela.add(jMITemaNormal);

        jMITemaEscuro.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMITemaEscuro.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jMITemaEscuro.setText("Escuro");
        jMITemaEscuro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMITemaEscuroActionPerformed(evt);
            }
        });
        jMJanela.add(jMITemaEscuro);

        jMITemaClaro.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMITemaClaro.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jMITemaClaro.setText("Claro");
        jMITemaClaro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMITemaClaroActionPerformed(evt);
            }
        });
        jMJanela.add(jMITemaClaro);

        jMIBranco.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMIBranco.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jMIBranco.setText("Branco");
        jMIBranco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIBrancoActionPerformed(evt);
            }
        });
        jMJanela.add(jMIBranco);

        jMPrincipal.add(jMJanela);

        jMSobre.setMnemonic('S');
        jMSobre.setText("Sobre");
        jMSobre.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N

        jMISobreLena.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMISobreLena.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jMISobreLena.setText("Lena");
        jMISobreLena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMISobreLenaActionPerformed(evt);
            }
        });
        jMSobre.add(jMISobreLena);

        jMISobreVersao.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMISobreVersao.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jMISobreVersao.setText("Versão");
        jMISobreVersao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMISobreVersaoActionPerformed(evt);
            }
        });
        jMSobre.add(jMISobreVersao);

        jMPrincipal.add(jMSobre);

        setJMenuBar(jMPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPFerramentas, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPaneImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 729, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPaneImagem)
                    .addComponent(jPFerramentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMISairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMISairActionPerformed
        this.dispose();
    }//GEN-LAST:event_jMISairActionPerformed

    private void jMIAbirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIAbirActionPerformed
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, PNG & GIF Images", "jpg", "png", "gif", "pbm");
        chooser.setCurrentDirectory(new File("imagens"));
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Abrir Imagem");
        int op = chooser.showOpenDialog(this);
        if (op == JFileChooser.APPROVE_OPTION) {
            File arq = chooser.getSelectedFile();

            String extensao = arq.getName();
            extensao = extensao.substring(extensao.length() - 3, extensao.length());
            System.out.println(extensao);

            switch (extensao) {
                case "png":
                case "jpg":
                case "bmp":
                case "gif":
                    imagemAtual = new ImagemRGB(arq);
                    imagemAtual.abrir(arq);
                    jMIRecortar.setEnabled(true);
                    break;
                case "pbm":
                    imagemAtual = new ImagemPBM(arq);
                    imagemAtual.abrir(arq);
                    jMIRecortar.setEnabled(false);
                    break;
                default:
                    new Excecoes().formatoNaoSuportado();
                    break;
            }
            atualizarImagem();
            jMEditar.setEnabled(true);
            jMImagem.setEnabled(true);
            jMISalvar.setEnabled(true);
            jMIFechar.setEnabled(true);
            jMIAbir.setEnabled(false);
            habilitaBotoes();
        }
    }//GEN-LAST:event_jMIAbirActionPerformed

    private void jMISalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMISalvarActionPerformed
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter;
        String extensao = imagemAtual.getExtensao();

        filter = new FileNameExtensionFilter(extensao.toUpperCase() + " Images", extensao);
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Salvar Imagem");
        chooser.setCurrentDirectory(new File("imagens"));
        int op = chooser.showSaveDialog(this);
        if (op == JFileChooser.APPROVE_OPTION) {
            File arq = chooser.getSelectedFile();
            String path = arq.getName() + "." + extensao;
            imagemAtual.salvar("imagens/" + path);
        }
    }//GEN-LAST:event_jMISalvarActionPerformed

    private void jMIAumentarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIAumentarActionPerformed
        imagemAtual.aumentar();
        atualizarImagem();
    }//GEN-LAST:event_jMIAumentarActionPerformed

    private void jMIDiminuirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIDiminuirActionPerformed
        imagemAtual.diminuir();
        atualizarImagem();
    }//GEN-LAST:event_jMIDiminuirActionPerformed

    private void jMIFiltroSepiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIFiltroSepiaActionPerformed
        editar = new Sepia(imagemAtual);
        atualizarImagem();
    }//GEN-LAST:event_jMIFiltroSepiaActionPerformed

    private void jMIMedianaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIMedianaActionPerformed
        editar = new Mediana(imagemAtual);
        atualizarImagem();
    }//GEN-LAST:event_jMIMedianaActionPerformed

    private void jMIMediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIMediaActionPerformed
        editar = new Media(imagemAtual);
        atualizarImagem();
    }//GEN-LAST:event_jMIMediaActionPerformed

    private void jMIYIQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIYIQActionPerformed
        editar = new YIQ(imagemAtual);
        atualizarImagem();
    }//GEN-LAST:event_jMIYIQActionPerformed

    private void jMIHSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIHSVActionPerformed
        editar = new HSV(imagemAtual);
        atualizarImagem();
    }//GEN-LAST:event_jMIHSVActionPerformed

    private void jMIHSIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIHSIActionPerformed
        editar = new HSI(imagemAtual);
        atualizarImagem();
    }//GEN-LAST:event_jMIHSIActionPerformed

    private void jMICIEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMICIEActionPerformed
        editar = new CIE(imagemAtual);
        atualizarImagem();
    }//GEN-LAST:event_jMICIEActionPerformed

    private void jMIRotateLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIRotateLeftActionPerformed
        imagemAtual.rotacaoEsquerda();
        atualizarImagem();
    }//GEN-LAST:event_jMIRotateLeftActionPerformed

    private void jMIRotateRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIRotateRightActionPerformed
        imagemAtual.rotacaoDireita();
        atualizarImagem();
    }//GEN-LAST:event_jMIRotateRightActionPerformed

    /**
     * Pega ação do mouse (pontos iniciais e finais) para realizar o corte na
     * imagem
     */
    private void realizaCorte() {
        int newWidth = mouseFinal.x - mouseInitial.x;
        int newHeight = mouseFinal.y - mouseInitial.y;

        BufferedImage imageAux = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
        int x = 0, y = 0;

        for (int i = 0; i < newWidth; i++) {
            for (int j = 0; j < newHeight; j++) {
                x = mouseInitial.x + i;
                y = mouseInitial.y + j;
                Color c = new Color(imagemAtual.getImagem().getRGB(x, y));
                imageAux.setRGB(i, j, c.getRGB());
            }
        }
        imagemAtual.setImagem(imageAux);
        imagemAtual.setIcone(new ImageIcon(imageAux));
        atualizarImagem();

    }

    private void jMIRecortarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIRecortarActionPerformed
        jLImagem.addMouseListener(new java.awt.event.MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                recortarMousePressed(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                try {
                    recortarMouseReleased(e);
                } catch (Exception e1) {
                    recortarMousePressed(e);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }//GEN-LAST:event_jMIRecortarActionPerformed

    private void jMIAumentarGammaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIAumentarGammaActionPerformed
        editar = new GammaPositivo(imagemAtual);
        atualizarImagem();
    }//GEN-LAST:event_jMIAumentarGammaActionPerformed

    private void jMIDiminuirGammaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIDiminuirGammaActionPerformed
        editar = new GammaNegativo(imagemAtual);
        atualizarImagem();
    }//GEN-LAST:event_jMIDiminuirGammaActionPerformed

    private void jMINegativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMINegativoActionPerformed
        editar = new Negativo(imagemAtual);
        atualizarImagem();
    }//GEN-LAST:event_jMINegativoActionPerformed

    private void jMIFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIFecharActionPerformed
        jMIAbir.setEnabled(true);

        jMISalvar.setEnabled(false);
        jMIFechar.setEnabled(false);
        jMEditar.setEnabled(false);
        jMImagem.setEnabled(false);

        jLImagem.setIcon(null);
        jPImagem.updateUI();

        desabilitaBotoes();
    }//GEN-LAST:event_jMIFecharActionPerformed

    private void jMISobreLenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMISobreLenaActionPerformed
        try {
            File iconeLena = new File("logo/logo_lena.png");
            BufferedImage bi;
            bi = ImageIO.read(iconeLena);
            ImageIcon icon = new ImageIcon(bi);
            JOptionPane.showMessageDialog(this, "Editor de Imagens Lena", "Sobre", JOptionPane.PLAIN_MESSAGE, icon);
        } catch (IOException ex) {
            new excecao.Excecoes().arquivoNaoEncontrado();
        }
    }//GEN-LAST:event_jMISobreLenaActionPerformed

    private void jMISobreVersaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMISobreVersaoActionPerformed
        JOptionPane.showMessageDialog(this, "\nEditor de Imagens Lena\n\nVersao 0.1", "Versão", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_jMISobreVersaoActionPerformed

    private void jMITemaNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMITemaNormalActionPerformed
        modificarTema(0);
    }//GEN-LAST:event_jMITemaNormalActionPerformed

    private void jMITemaEscuroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMITemaEscuroActionPerformed
        modificarTema(1);
    }//GEN-LAST:event_jMITemaEscuroActionPerformed

    private void jMITemaClaroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMITemaClaroActionPerformed
        modificarTema(2);
    }//GEN-LAST:event_jMITemaClaroActionPerformed

    private void jMIBrancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIBrancoActionPerformed
        modificarTema(3);
    }//GEN-LAST:event_jMIBrancoActionPerformed

    private void jMIAumentarBrilhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIAumentarBrilhoActionPerformed
        editar = new AumentaBrilho(imagemAtual);
        atualizarImagem();
    }//GEN-LAST:event_jMIAumentarBrilhoActionPerformed

    private void jMIDiminuirBrilhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIDiminuirBrilhoActionPerformed
        editar = new DiminuiBrilho(imagemAtual);
        atualizarImagem();
    }//GEN-LAST:event_jMIDiminuirBrilhoActionPerformed

    private void modificarTema(int opcao) {
        switch (opcao) {
            case 0:
                for (int i = 0; i < QTDE_FERRAMENTAS; i++) {
                    botoes[i].setBackground(Color.GRAY);
                }
                break;
            case 1:
                for (int i = 0; i < QTDE_FERRAMENTAS; i++) {
                    botoes[i].setBackground(Color.DARK_GRAY);
                }
                break;
            case 2:
                for (int i = 0; i < QTDE_FERRAMENTAS; i++) {
                    botoes[i].setBackground(Color.LIGHT_GRAY);
                }
                break;
            case 3:
                for (int i = 0; i < QTDE_FERRAMENTAS; i++) {
                    botoes[i].setBackground(Color.WHITE);
                }
                break;
        }

        new Config().escrever(opcao);
    }

    private void recortarMousePressed(MouseEvent e) {
        this.mouseInitial = e.getPoint();
    }

    public void recortarMouseReleased(MouseEvent e) {
        this.mouseFinal = e.getPoint();
        realizaCorte();
        jLImagem.removeMouseListener((MouseListener) this);
    }

    public void atualizarImagem() {
        jLImagem.setIcon(imagemAtual.getIcone());
        jPImagem.updateUI();
    }

    public void habilitaBotoes() {
        for (JButton b : botoes) {
            b.setEnabled(true);
        }
    }

    public void desabilitaBotoes() {
        for (JButton b : botoes) {
            b.setEnabled(false);
        }
    }

    public BufferedImage[] abrirIcone() {
        String nomeArquivo = "ferramentas/";
        BufferedImage ferramentasBuffer[] = new BufferedImage[QTDE_FERRAMENTAS];
        for (int i = 0; i < QTDE_FERRAMENTAS; i++) {
            nomeArquivo += String.valueOf(i + 1) + ".jpg";
            try {
                File arquivo = new File(nomeArquivo);
                ferramentasBuffer[i] = ImageIO.read(arquivo);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            nomeArquivo = "ferramentas/";
        }
        return ferramentasBuffer;
    }

    public final void inicializarFerramentas() {
        BufferedImage[] ferramentasBuffer = abrirIcone();

        char[] mnemonic = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};

        for (int i = 0; i < QTDE_FERRAMENTAS; i++) {
            botoes[i] = new JButton("");
            botoes[i].setSize(50, 50);
            botoes[i].addActionListener(this);
            botoes[i].setPreferredSize(new Dimension(50, 50));
            botoes[i].setBorder(null);
            botoes[i].setFocusable(false);
            botoes[i].setToolTipText(nomeFerramentas[i]);
            botoes[i].setIcon(new ImageIcon(ferramentasBuffer[i]));
            botoes[i].setMnemonic(mnemonic[i]);
            this.jPFerramentas.add(botoes[i]);
        }

        int opcao = new Config().ler();
        modificarTema(opcao);

        desabilitaBotoes();
        jPFerramentas.updateUI();
    }

    /**
     * Main. Thread de TelaPrincipal.
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new TelaPrincipal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMArquivo;
    private javax.swing.JMenu jMEditar;
    private javax.swing.JMenu jMEscalaDeCinza;
    private javax.swing.JMenu jMFiltros;
    private javax.swing.JMenuItem jMIAbir;
    private javax.swing.JMenuItem jMIAumentar;
    private javax.swing.JMenuItem jMIAumentarBrilho;
    private javax.swing.JMenuItem jMIAumentarGamma;
    private javax.swing.JMenuItem jMIBranco;
    private javax.swing.JMenuItem jMICIE;
    private javax.swing.JMenuItem jMIDiminuir;
    private javax.swing.JMenuItem jMIDiminuirBrilho;
    private javax.swing.JMenuItem jMIDiminuirGamma;
    private javax.swing.JMenuItem jMIFechar;
    private javax.swing.JMenuItem jMIFiltroSepia;
    private javax.swing.JMenuItem jMIHSI;
    private javax.swing.JMenuItem jMIHSV;
    private javax.swing.JMenuItem jMIMedia;
    private javax.swing.JMenuItem jMIMediana;
    private javax.swing.JMenuItem jMINegativo;
    private javax.swing.JMenuItem jMIRecortar;
    private javax.swing.JMenuItem jMIRotateLeft;
    private javax.swing.JMenuItem jMIRotateRight;
    private javax.swing.JMenuItem jMISair;
    private javax.swing.JMenuItem jMISalvar;
    private javax.swing.JMenuItem jMISobreLena;
    private javax.swing.JMenuItem jMISobreVersao;
    private javax.swing.JMenuItem jMITemaClaro;
    private javax.swing.JMenuItem jMITemaEscuro;
    private javax.swing.JMenuItem jMITemaNormal;
    private javax.swing.JMenuItem jMIYIQ;
    private javax.swing.JMenu jMImagem;
    private javax.swing.JMenu jMJanela;
    private javax.swing.JMenuBar jMPrincipal;
    private javax.swing.JMenu jMSobre;
    private javax.swing.JPanel jPFerramentas;
    private javax.swing.JPanel jPImagem;
    private javax.swing.JScrollPane jScrollPaneImagem;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton botaoSelecionado = (JButton) e.getSource();
        String toolTip = botaoSelecionado.getToolTipText();

        if (toolTip.equals(nomeFerramentas[0])) {
            jMIAumentarActionPerformed(e);
        } else if (toolTip.equals(nomeFerramentas[1])) {
            jMIDiminuirActionPerformed(e);
        } else if (toolTip.equals(nomeFerramentas[2])) {
            jMIRotateLeftActionPerformed(e);
        } else if (toolTip.equals(nomeFerramentas[3])) {
            jMIRotateRightActionPerformed(e);
        } else if (toolTip.equals(nomeFerramentas[4])) {
            jMIAumentarGammaActionPerformed(e);
        } else if (toolTip.equals(nomeFerramentas[5])) {
            jMIDiminuirGammaActionPerformed(e);
        } else if (toolTip.equals(nomeFerramentas[6])) {
            jMIRecortarActionPerformed(e);
        } else if (toolTip.equals(nomeFerramentas[7])) {
            jMINegativoActionPerformed(e);
        } else if (toolTip.equals(nomeFerramentas[8])) {
            jMICIEActionPerformed(e);
        } else {
            System.out.println("erro");
        }

    }

}
