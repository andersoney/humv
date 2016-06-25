package br.edu.ufrb.lasis.humv.view.animal;

import br.edu.ufrb.lasis.humv.HUMVApp;
import br.edu.ufrb.lasis.humv.view.dono.CadastroDonoJDialog;
import br.edu.ufrb.lasis.humv.utils.Util;
import br.edu.ufrb.lasis.humv.utils.MaskUtils;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import br.edu.ufrb.lasis.humv.entity.Animal;
import br.edu.ufrb.lasis.humv.entity.Dono;
import br.edu.ufrb.lasis.humv.rest.RESTConnectionException;
import br.edu.ufrb.lasis.humv.rest.RESTMethods;
import br.edu.ufrb.lasis.humv.utils.MessagesUtils;
import com.sun.jersey.api.client.ClientResponse;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import org.codehaus.jackson.type.TypeReference;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Andersoney
 */
public class CadastroAnimal extends javax.swing.JPanel implements ActionListener {

    JFrame parent;
    boolean grande = false;
    String idDono;
    String nome;
    String porte;
    final private String servicoDono = "/api/dono";
    final private String servicoAnimal = "/api/animal";
    private static final Logger LOG = Logger.getLogger(CadastroAnimal.class.getName());
    private Animal animalSelecionado;

    public CadastroAnimal() {
        initComponents();
        customInitComponents();
    }

    public CadastroAnimal(Animal animalSelecionado) {
        this.animalSelecionado = animalSelecionado;
        initComponents();
        customInitComponents();
    }

    private void customInitComponents() {
        buttonOK.addActionListener(this);
        buttonCancelar.addActionListener(this);
        textFieldNome.setFocusable(true);
        if (animalSelecionado != null) {
            labelTitulo.setText("Alteração de dados do animal");
            textFieldNome.setText(animalSelecionado.getNome());
            textFieldEspecie.setText(animalSelecionado.getEspecie());
            textFieldIdade.setText("" + animalSelecionado.getIdade());
            textFieldRaca.setText(animalSelecionado.getRaca());
            textFieldPeso.setText("" + animalSelecionado.getPeso());
            
            if (Util.isCPF(animalSelecionado.getIdDono())) {
                labelCpfDono.setText("CPF: " + animalSelecionado.getIdDono());
                ClientResponse response;
                try {
                    this.setIdNull();
                    response = RESTMethods.get(servicoDono + "/" + animalSelecionado.getIdDono() + "");
                    Dono at = response.getEntity(Dono.class);
                    this.idDono = at.getId();
                    this.labelCpfDono.setText("CPF: " + idDono);
                    this.nomeDJL.setText("Nome: " + at.getNome());
                } catch (RESTConnectionException ex) {
                    Logger.getLogger(CadastroAnimal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if (Util.isCNPJ(animalSelecionado.getIdDono())) {
                labelCpfDono.setText("CNPJ: " + animalSelecionado.getIdDono());
                ClientResponse response;
                try {
                    this.setIdNull();
                    response = RESTMethods.get(servicoDono + "/" + animalSelecionado.getIdDono() + "");
                    Dono at = response.getEntity(Dono.class);
                    this.idDono = at.getId();
                    this.labelCpfDono.setText("CNPJ: " + this.idDono);
                    this.nomeDJL.setText("Nome: " + at.getNome());
                } catch (RESTConnectionException ex) {
                    Logger.getLogger(CadastroAnimal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (animalSelecionado.getPorte().equalsIgnoreCase("pequeno")) {
                this.pequenoPorteJRB.setSelected(true);
                pequenoPorteJRBActionPerformed(null);
                this.pequenoPorteJRB.setEnabled(false);
                this.grandePorteJRB.setEnabled(false);
                textFieldPelagem.setText(animalSelecionado.getPelagem());
            } else {
                this.grandePorteJRB.setSelected(true);
                grandePorteJRBActionPerformed(null);
                this.pequenoPorteJRB.setEnabled(false);
                this.grandePorteJRB.setEnabled(false);
            }
            if (animalSelecionado.getSexo() == 'M' || animalSelecionado.getSexo() == 'm') {
                radioButtonMacho.setSelected(true);
                radioButtonFemea.setSelected(false);
            } else {
                radioButtonMacho.setSelected(false);
                radioButtonFemea.setSelected(true);
            }
            jLabelRghumv.setText("RGHUMV: " + animalSelecionado.getRghumv());
        }
        else{
            jLabelRghumv.setText("RGHUMV: " + geraRghumv());
        }
    }

    /**
     * Creates new form CadastroAnimals
     *
     * @param parent
     */
    public CadastroAnimal(JFrame parent) {
        this.parent = parent;
        initComponents();
        this.labelTitulo.setText("Cadastro do animal");
        this.pequenoPorteJRB.setSelected(true);
    }

    public CadastroAnimal(JFrame parent, boolean Pequeno) {
        this.parent = parent;
        initComponents();
        this.labelTitulo.setText("Cadastro de Animais");
        this.pequenoPorteJRB.setSelected(true); 
        if (Pequeno) {
            this.pequenoPorteJRB.setSelected(true);
            pequenoPorteJRBActionPerformed(null);
            this.grandePorteJRB.setEnabled(false);

        } else {
            this.grandePorteJRB.setSelected(true);
            grandePorteJRBActionPerformed(null);
            this.pequenoPorteJRB.setEnabled(false);
        }
    }

    public void setIdNull() {
        this.idDono = null;
        this.nome = null;
        this.nomeDJL.setText("Nome: ");
        this.labelCpfDono.setText("CPF: ");
    }

    public void setId(String id, String nome) {
        this.idDono = id;
        this.nome = nome;
        this.nomeDJL.setText("Nome: " + nome);
        this.labelCpfDono.setText("CPF: " + id);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pesquisarDJB = new javax.swing.JButton();
        jTextFieldBuscaCpf = new javax.swing.JTextField();
        jTextFieldBuscaCpf = MaskUtils.mascaraCpf();
        nomeDJL = new javax.swing.JLabel();
        labelCpfDono = new javax.swing.JLabel();
        jbCadastrarNovoDono = new javax.swing.JButton();
        Date date = new Date();
        SpinnerDateModel spinnerDateModel = new SpinnerDateModel(date,null,null,Calendar.HOUR_OF_DAY);
        jSpinnerHoras = new javax.swing.JSpinner(spinnerDateModel);
        JSpinner.DateEditor dateEditor= new JSpinner.DateEditor(jSpinnerHoras,"HH:mm:ss");
        jSpinnerHoras.setEditor(dateEditor);
        jDateChooserData = new com.toedter.calendar.JDateChooser();
        jDateChooserData.setDate(date);
        jLabelDia = new javax.swing.JLabel();
        jLabelHora = new javax.swing.JLabel();
        jRadioButtonBuscaCpf = new javax.swing.JRadioButton();
        jTextFieldBuscaCnpj = new javax.swing.JTextField();
        jTextFieldBuscaCnpj = MaskUtils.mascaraCnpj();
        jRadioButtonBuscaCnpj = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        nomeAJL = new javax.swing.JLabel();
        textFieldNome = new javax.swing.JTextField();
        especieJL = new javax.swing.JLabel();
        textFieldEspecie = new javax.swing.JTextField();
        racaJL = new javax.swing.JLabel();
        textFieldRaca = new javax.swing.JTextField();
        sexoJL = new javax.swing.JLabel();
        radioButtonMacho = new javax.swing.JRadioButton();
        radioButtonFemea = new javax.swing.JRadioButton();
        idadeJL = new javax.swing.JLabel();
        textFieldIdade = new javax.swing.JTextField();
        textFieldIdade = MaskUtils.mascaraIdade();
        pesoJL = new javax.swing.JLabel();
        textFieldPeso = new javax.swing.JTextField();
        porteDoAnimalJL = new javax.swing.JLabel();
        grandePorteJRB = new javax.swing.JRadioButton();
        pequenoPorteJRB = new javax.swing.JRadioButton();
        pelagemJL = new javax.swing.JLabel();
        textFieldPelagem = new javax.swing.JTextField();
        TipodeAtendimentoJL = new javax.swing.JLabel();
        comboBoxTipoAtendimento = new javax.swing.JComboBox<>();
        jLabelRghumv = new javax.swing.JLabel();
        buttonCancelar = new javax.swing.JButton();
        labelTitulo = new javax.swing.JLabel();
        buttonOK = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Dono"));

        pesquisarDJB.setText("Pesquisar");
        pesquisarDJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarDJBActionPerformed(evt);
            }
        });

        jTextFieldBuscaCpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldBuscaCpfKeyPressed(evt);
            }
        });

        nomeDJL.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nomeDJL.setText("Nome:");

        labelCpfDono.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelCpfDono.setText("CPF:");

        jbCadastrarNovoDono.setText("Cadastrar novo...");
        jbCadastrarNovoDono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbCadastrarNovoDonoMouseClicked(evt);
            }
        });
        jbCadastrarNovoDono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarNovoDonoActionPerformed(evt);
            }
        });

        jLabelDia.setText("Dia");

        jLabelHora.setText("Hora");

        jRadioButtonBuscaCpf.setText("CPF");
        jRadioButtonBuscaCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonBuscaCpfActionPerformed(evt);
            }
        });

        jRadioButtonBuscaCnpj.setText("CNPJ");
        jRadioButtonBuscaCnpj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonBuscaCnpjActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooserData, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeDJL, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldBuscaCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButtonBuscaCpf)
                            .addComponent(jLabelDia))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jRadioButtonBuscaCnpj)
                            .addComponent(jTextFieldBuscaCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCpfDono, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(pesquisarDJB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbCadastrarNovoDono))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelHora, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinnerHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonBuscaCpf)
                    .addComponent(jRadioButtonBuscaCnpj))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pesquisarDJB)
                    .addComponent(jTextFieldBuscaCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbCadastrarNovoDono)
                    .addComponent(jTextFieldBuscaCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeDJL)
                    .addComponent(labelCpfDono))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDia)
                    .addComponent(jLabelHora))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSpinnerHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooserData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Animal"));

        nomeAJL.setText("Nome");

        especieJL.setText("Espécie");

        racaJL.setText("Raça");

        sexoJL.setText("Sexo");

        radioButtonMacho.setText("Macho");
        radioButtonMacho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonMachoActionPerformed(evt);
            }
        });

        radioButtonFemea.setText("Fêmea");
        radioButtonFemea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonFemeaActionPerformed(evt);
            }
        });

        idadeJL.setText("Idade");

        pesoJL.setText("Peso");

        porteDoAnimalJL.setText("Porte do animal");

        grandePorteJRB.setText("Grande");
        grandePorteJRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grandePorteJRBActionPerformed(evt);
            }
        });

        pequenoPorteJRB.setText("Pequeno");
        pequenoPorteJRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pequenoPorteJRBActionPerformed(evt);
            }
        });

        pelagemJL.setText("Pelagem");

        TipodeAtendimentoJL.setText("Tipo de atendimento");

        comboBoxTipoAtendimento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal", "Emergencial" }));

        jLabelRghumv.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelRghumv.setText("RGHUMV: ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nomeAJL, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldRaca, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(especieJL, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29))
                                    .addComponent(textFieldEspecie)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(idadeJL, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(textFieldIdade)
                                        .addGap(72, 72, 72)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(radioButtonMacho)
                                        .addGap(46, 46, 46)
                                        .addComponent(radioButtonFemea))
                                    .addComponent(textFieldPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sexoJL)
                                    .addComponent(pesoJL)))
                            .addComponent(racaJL, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textFieldPelagem)
                                    .addComponent(comboBoxTipoAtendimento, 0, 200, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(grandePorteJRB)
                                    .addComponent(jLabelRghumv))
                                .addGap(47, 47, 47)
                                .addComponent(pequenoPorteJRB)
                                .addGap(26, 26, 26)))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TipodeAtendimentoJL)
                            .addComponent(pelagemJL, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(porteDoAnimalJL)
                        .addGap(137, 137, 137))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(especieJL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(nomeAJL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(racaJL)
                    .addComponent(sexoJL, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(radioButtonMacho)
                        .addComponent(radioButtonFemea))
                    .addComponent(textFieldRaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idadeJL)
                    .addComponent(pesoJL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(pequenoPorteJRB))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(porteDoAnimalJL)
                            .addComponent(TipodeAtendimentoJL))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboBoxTipoAtendimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(grandePorteJRB))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pelagemJL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldPelagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelRghumv))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        buttonCancelar.setText("Cancelar");
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });

        labelTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelTitulo.setText("CADASTRAMENTO DE ANIMAL");

        buttonOK.setText("Confirmar");
        buttonOK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonOKMouseClicked(evt);
            }
        });
        buttonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(buttonOK))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(labelTitulo)
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCancelar)
                    .addComponent(buttonOK))
                .addContainerGap(32, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private String geraRghumv(){
        String rghumv="";
        try {
            ClientResponse response = RESTMethods.get("/api/animal");

            List<Animal> lista = (List<Animal>) RESTMethods.getObjectFromJSON(response, new TypeReference<List<Animal>>() {
            });
            int tam = lista.size();
            rghumv =""+ (lista.size()+1);
        } catch (RESTConnectionException | IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar-se com banco de dados. Por favor, tente novamente mais tarde.", "Falha na autenticação", JOptionPane.ERROR_MESSAGE);
            LOG.warning(ex.getMessage());
            Logger.getLogger(CadastroAnimal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rghumv;
    }
    
    private void buttonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOKActionPerformed

        if (idDono == null) {
            JOptionPane.showMessageDialog(this, "Escolha ou cadastre um dono na lista.");
            return;
        }
        char sexo;
        float peso;
        int idade=-1;
        boolean pequenoPort;
        Date data;
        if (!Util.isNotNull(this.textFieldNome.getText())) {
            JOptionPane.showMessageDialog(this, "Nome do animal não pode ficar vazio.");
            return;
        }
        String nomeAnimal = this.textFieldNome.getText();
        if (!Util.isNotNull(this.textFieldEspecie.getText())) {
            JOptionPane.showMessageDialog(this, "Especie não pode ficar vazio.");
            return;
        }
        String especie = this.textFieldEspecie.getText();
        if (!Util.isNotNull(this.textFieldRaca.getText())) {
            JOptionPane.showMessageDialog(this, "Campo raça não pode ficar vazio.");
            return;
        }
        String raca = this.textFieldRaca.getText();
        if(this.textFieldIdade.getText().length()==0){
            JOptionPane.showMessageDialog(this, "Digite uma idade valida.\nValor Inteiro.");
        }else{
            idade = Integer.parseInt(this.textFieldIdade.getText());
        }
        if (this.radioButtonMacho.isSelected()) {
            sexo = 'M';
        } else {
            sexo = 'F';
        }
        try {
            peso = Float.parseFloat(this.textFieldPeso.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Digite um peso valido.");
            return;
        }
        String pelagem = null;
        if (this.pequenoPorteJRB.isSelected () ) {
            if (!Util.isNotNull(this.textFieldPelagem.getText())) {
                JOptionPane.showMessageDialog(this, "Digite a pelagem do animal.");
                return;
            } else {
                pelagem = this.textFieldPelagem.getText();
            }
            porte = "peqeno";
        }
        else {
            porte = "grande";
            pelagem = "não se aplica.";
        }
        String tipoDeAtendimento = null;
        if (this.comboBoxTipoAtendimento.getSelectedIndex () == 0) {
            tipoDeAtendimento = "Normal";
        }
        else if (this.comboBoxTipoAtendimento.getSelectedIndex () == 1) {
            tipoDeAtendimento = "Emergencial";
        }
        data = jDateChooserData.getDate();
        ClientResponse response;
        Animal animal = new Animal();
        animal.setIdDono(idDono);
        animal.setDataCadastro(data);
        animal.setEspecie(especie);
        animal.setIdade (idade);
        animal.setNome (nomeAnimal);
        animal.setPeso (peso);
        animal.setRaca (raca);
        animal.setRghumv (geraRghumv());
        animal.setSexo (sexo);
        animal.setPorte (porte);
        animal.setPelagem (pelagem);
        try {
            response = RESTMethods.post(this.servicoAnimal, animal);
            String resposta = response.getEntity(String.class);
            if (!resposta.equalsIgnoreCase("ok")) {
                JOptionPane.showMessageDialog(this, resposta, "Falha no cadastro", JOptionPane.ERROR_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Sucesso no cadastro");
            }
        }
        catch (RESTConnectionException ex) {
            Logger.getLogger(CadastroAnimal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonOKActionPerformed
    
    
    
    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        int op = MessagesUtils.dialogoCancelar("o cadastro", "animal");
        if(op == JOptionPane.OK_OPTION){
            this.setVisible(false);
            System.gc();
            HUMVApp.exibirMensagemCarregamento();
            HUMVApp.setPainelCentralComLogo();
            HUMVApp.esconderMensagemCarregamento();
        }
    }//GEN-LAST:event_buttonCancelarActionPerformed

    private void pesquisarDJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarDJBActionPerformed
        if(jRadioButtonBuscaCpf.isSelected()){
            if (Util.isCPF(this.jTextFieldBuscaCpf.getText())) {
                ClientResponse response;
                try {
                    this.setIdNull();
                    response = RESTMethods.get(servicoDono + "/" + this.jTextFieldBuscaCpf.getText() + "");
                    Dono at = response.getEntity(Dono.class);
                    this.idDono = at.getId();
                    this.labelCpfDono.setText("CPF: " + idDono);
                    this.nomeDJL.setText("Nome: " + at.getNome());
                } catch (RESTConnectionException ex) {
                    Logger.getLogger(CadastroAnimal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                this.setIdNull();
                MessagesUtils.validaCampoInvalido("CPF");
            }
        }else{
            if (Util.isCNPJ(this.jTextFieldBuscaCnpj.getText())) {
                ClientResponse response;
                try {
                    this.setIdNull();
                    response = RESTMethods.get(servicoDono + "/" + this.jTextFieldBuscaCnpj.getText() + "");
                    Dono at = response.getEntity(Dono.class);
                    this.idDono = at.getId();
                    this.labelCpfDono.setText("CNPJ: " + idDono);
                    this.nomeDJL.setText("Nome: " + at.getNome());
                } catch (RESTConnectionException ex) {
                    Logger.getLogger(CadastroAnimal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                this.setIdNull();
                MessagesUtils.validaCampoInvalido("CNPJ");
            }
        }        
    }//GEN-LAST:event_pesquisarDJBActionPerformed

    private void jTextFieldBuscaCpfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscaCpfKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.pesquisarDJBActionPerformed(null);
        }
    }//GEN-LAST:event_jTextFieldBuscaCpfKeyPressed

    private void jbCadastrarNovoDonoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbCadastrarNovoDonoMouseClicked
        CadastroDonoJDialog dono = new CadastroDonoJDialog(parent, true, this);
        dono.setTitle("CADASTRAMENTO DE DONO");
        dono.setLocationRelativeTo(null);
        dono.setVisible(true);
    }//GEN-LAST:event_jbCadastrarNovoDonoMouseClicked

    private void jbCadastrarNovoDonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarNovoDonoActionPerformed
      
    }//GEN-LAST:event_jbCadastrarNovoDonoActionPerformed

    private void buttonOKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonOKMouseClicked
      
    }//GEN-LAST:event_buttonOKMouseClicked

    private void pequenoPorteJRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pequenoPorteJRBActionPerformed
        this.grandePorteJRB.setSelected(false);
        this.pelagemJL.setVisible(true);
        this.textFieldPelagem.setVisible(true);
    }//GEN-LAST:event_pequenoPorteJRBActionPerformed

    private void grandePorteJRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grandePorteJRBActionPerformed
        this.pequenoPorteJRB.setSelected(false);
        this.pelagemJL.setVisible(false);
        this.textFieldPelagem.setVisible(false);
    }//GEN-LAST:event_grandePorteJRBActionPerformed

    private void radioButtonFemeaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonFemeaActionPerformed
            this.radioButtonMacho.setSelected(false);
    }//GEN-LAST:event_radioButtonFemeaActionPerformed

    private void radioButtonMachoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonMachoActionPerformed
        this.radioButtonFemea.setSelected(false);
    }//GEN-LAST:event_radioButtonMachoActionPerformed

    private void jRadioButtonBuscaCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonBuscaCpfActionPerformed
        this.jRadioButtonBuscaCnpj.setSelected(false);
        this.jTextFieldBuscaCpf.setEnabled(true);
        this.jTextFieldBuscaCpf.setFocusable(true);
        this.jTextFieldBuscaCnpj.setText("");
        this.jTextFieldBuscaCnpj.setEnabled(false);
        this.labelCpfDono.setText("CPF: ");
    }//GEN-LAST:event_jRadioButtonBuscaCpfActionPerformed

    private void jRadioButtonBuscaCnpjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonBuscaCnpjActionPerformed
        this.jRadioButtonBuscaCpf.setSelected(false);
        this.jTextFieldBuscaCnpj.setEnabled(true);
        this.jTextFieldBuscaCnpj.setFocusable(true);
        this.jTextFieldBuscaCpf.setText("");
        this.jTextFieldBuscaCpf.setEnabled(false);
        this.labelCpfDono.setText("CNPJ: ");
    }//GEN-LAST:event_jRadioButtonBuscaCnpjActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TipodeAtendimentoJL;
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonOK;
    private javax.swing.JComboBox<String> comboBoxTipoAtendimento;
    private javax.swing.JLabel especieJL;
    private javax.swing.JRadioButton grandePorteJRB;
    private javax.swing.JLabel idadeJL;
    private com.toedter.calendar.JDateChooser jDateChooserData;
    private javax.swing.JLabel jLabelDia;
    private javax.swing.JLabel jLabelHora;
    private javax.swing.JLabel jLabelRghumv;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButtonBuscaCnpj;
    private javax.swing.JRadioButton jRadioButtonBuscaCpf;
    private javax.swing.JSpinner jSpinnerHoras;
    private javax.swing.JTextField jTextFieldBuscaCnpj;
    private javax.swing.JTextField jTextFieldBuscaCpf;
    private javax.swing.JButton jbCadastrarNovoDono;
    private javax.swing.JLabel labelCpfDono;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel nomeAJL;
    private javax.swing.JLabel nomeDJL;
    private javax.swing.JLabel pelagemJL;
    private javax.swing.JRadioButton pequenoPorteJRB;
    private javax.swing.JLabel pesoJL;
    private javax.swing.JButton pesquisarDJB;
    private javax.swing.JLabel porteDoAnimalJL;
    private javax.swing.JLabel racaJL;
    private javax.swing.JRadioButton radioButtonFemea;
    private javax.swing.JRadioButton radioButtonMacho;
    private javax.swing.JLabel sexoJL;
    private javax.swing.JTextField textFieldEspecie;
    private javax.swing.JTextField textFieldIdade;
    private javax.swing.JTextField textFieldNome;
    private javax.swing.JTextField textFieldPelagem;
    private javax.swing.JTextField textFieldPeso;
    private javax.swing.JTextField textFieldRaca;
    // End of variables declaration//GEN-END:variables
    
    @Override
    public void actionPerformed(ActionEvent ae) {}
}
