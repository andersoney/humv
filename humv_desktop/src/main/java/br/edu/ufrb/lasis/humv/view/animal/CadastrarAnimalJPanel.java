package br.edu.ufrb.lasis.humv.view.animal;

import br.edu.ufrb.lasis.humv.HUMVApp;
import br.edu.ufrb.lasis.humv.view.dono.CadastrarDonoJDialog;
import br.edu.ufrb.lasis.humv.utils.ValidationsUtils;
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
public class CadastrarAnimalJPanel extends javax.swing.JPanel implements ActionListener {

    JFrame parent;
    boolean grande = false;
    String idDono;
    String nome;
    String porte;
    final private String servicoDono = "/api/dono";
    final private String servicoAnimal = "/api/animal";
    private static final Logger LOG = Logger.getLogger(CadastrarAnimalJPanel.class.getName());
    private Animal animalSelecionado;

    public CadastrarAnimalJPanel() {
        initComponents();
        customInitComponents();
    }

    public CadastrarAnimalJPanel(Animal animalSelecionado) {
        this.animalSelecionado = animalSelecionado;
        initComponents();
        customInitComponents();
    }

    private void customInitComponents() {
        jButtonConfirmar.addActionListener(this);
        jButtonCancelar.addActionListener(this);
        jTextFieldNomeAnimal.setFocusable(true);
        if (animalSelecionado != null) {
            jLabelTitulo.setText("Alteração de dados do animal");
            jTextFieldNomeAnimal.setText(animalSelecionado.getNome());
            jTextFieldEspecie.setText(animalSelecionado.getEspecie());
            jTextFieldIdade.setText("" + animalSelecionado.getIdade());
            jTextFieldRaca.setText(animalSelecionado.getRaca());
            
            if (ValidationsUtils.isCPF(animalSelecionado.getIdDono())) {
                jLabelCpfDono.setText("CPF: " + animalSelecionado.getIdDono());
                ClientResponse response;
                try {
                    this.setIdNull();
                    response = RESTMethods.get(servicoDono + "/" + animalSelecionado.getIdDono() + "");
                    Dono at = response.getEntity(Dono.class);
                    this.idDono = at.getId();
                    this.jLabelCpfDono.setText("CPF: " + idDono);
                    this.jLabelNomeDono.setText("Nome: " + at.getNome());
                } catch (RESTConnectionException ex) {
                    Logger.getLogger(CadastrarAnimalJPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if (ValidationsUtils.isCNPJ(animalSelecionado.getIdDono())) {
                jLabelCpfDono.setText("CNPJ: " + animalSelecionado.getIdDono());
                ClientResponse response;
                try {
                    this.setIdNull();
                    response = RESTMethods.get(servicoDono + "/" + animalSelecionado.getIdDono() + "");
                    Dono at = response.getEntity(Dono.class);
                    this.idDono = at.getId();
                    this.jLabelCpfDono.setText("CNPJ: " + this.idDono);
                    this.jLabelNomeDono.setText("Nome: " + at.getNome());
                } catch (RESTConnectionException ex) {
                    Logger.getLogger(CadastrarAnimalJPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (animalSelecionado.getPorte().equalsIgnoreCase("pequeno")) {
                this.jRadioButtonPequenoPorte.setSelected(true);
                jRadioButtonPequenoPorteActionPerformed(null);
                this.jRadioButtonPequenoPorte.setEnabled(false);
                this.jRadioButtonGrandePorte.setEnabled(false);
                jTextFieldPelagem.setText(animalSelecionado.getPelagem());
            } else {
                this.jRadioButtonGrandePorte.setSelected(true);
                jRadioButtonGrandePorteActionPerformed(null);
                this.jRadioButtonPequenoPorte.setEnabled(false);
                this.jRadioButtonGrandePorte.setEnabled(false);
            }
            if (animalSelecionado.getSexo() == 'M' || animalSelecionado.getSexo() == 'm') {
                jRadioButtonMacho.setSelected(true);
                jRadioButtonFemea.setSelected(false);
            } else {
                jRadioButtonMacho.setSelected(false);
                jRadioButtonFemea.setSelected(true);
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
    public CadastrarAnimalJPanel(JFrame parent) {
        this.parent = parent;
        initComponents();
        this.jLabelTitulo.setText("Cadastro do animal");
        this.jRadioButtonPequenoPorte.setSelected(true);
    }

    public CadastrarAnimalJPanel(JFrame parent, boolean Pequeno) {
        this.parent = parent;
        initComponents();
        this.jLabelTitulo.setText("Cadastro de Animais");
        this.jRadioButtonPequenoPorte.setSelected(true); 
        if (Pequeno) {
            this.jRadioButtonPequenoPorte.setSelected(true);
            jRadioButtonPequenoPorteActionPerformed(null);
            this.jRadioButtonGrandePorte.setEnabled(false);

        } else {
            this.jRadioButtonGrandePorte.setSelected(true);
            jRadioButtonGrandePorteActionPerformed(null);
            this.jRadioButtonPequenoPorte.setEnabled(false);
        }
    }

    public void setIdNull() {
        this.idDono = null;
        this.nome = null;
        this.jLabelNomeDono.setText("Nome: ");
        this.jLabelCpfDono.setText("CPF: ");
    }

    public void setId(String id, String nome) {
        this.idDono = id;
        this.nome = nome;
        this.jLabelNomeDono.setText("Nome: " + nome);
        this.jLabelCpfDono.setText("CPF: " + id);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelDadosDono = new javax.swing.JPanel();
        jButtonPesquisarDono = new javax.swing.JButton();
        jTextFieldBuscaCpf = new javax.swing.JTextField();
        jTextFieldBuscaCpf = MaskUtils.mascaraCpf();
        jLabelNomeDono = new javax.swing.JLabel();
        jLabelCpfDono = new javax.swing.JLabel();
        jButtonCadastrarNovoDono = new javax.swing.JButton();
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
        jPanelDadosAnimal = new javax.swing.JPanel();
        jLabelNomeAnimal = new javax.swing.JLabel();
        jTextFieldNomeAnimal = new javax.swing.JTextField();
        jLabelEspecie = new javax.swing.JLabel();
        jTextFieldEspecie = new javax.swing.JTextField();
        jLabelRaca = new javax.swing.JLabel();
        jTextFieldRaca = new javax.swing.JTextField();
        jLabelSexo = new javax.swing.JLabel();
        jRadioButtonMacho = new javax.swing.JRadioButton();
        jRadioButtonFemea = new javax.swing.JRadioButton();
        jLabelIdade = new javax.swing.JLabel();
        jTextFieldIdade = new javax.swing.JTextField();
        jTextFieldIdade = MaskUtils.mascaraIdade();
        jLabelPorte = new javax.swing.JLabel();
        jRadioButtonGrandePorte = new javax.swing.JRadioButton();
        jRadioButtonPequenoPorte = new javax.swing.JRadioButton();
        jLabelPelagem = new javax.swing.JLabel();
        jTextFieldPelagem = new javax.swing.JTextField();
        jLabelTipoAtendimento = new javax.swing.JLabel();
        jComboBoxTipoAtendimento = new javax.swing.JComboBox<>();
        jLabelRghumv = new javax.swing.JLabel();
        jButtonCancelar = new javax.swing.JButton();
        jLabelTitulo = new javax.swing.JLabel();
        jButtonConfirmar = new javax.swing.JButton();

        jPanelDadosDono.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do dono"));

        jButtonPesquisarDono.setText("Pesquisar");
        jButtonPesquisarDono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarDonoActionPerformed(evt);
            }
        });

        jTextFieldBuscaCpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldBuscaCpfKeyPressed(evt);
            }
        });

        jLabelNomeDono.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelNomeDono.setText("Nome:");

        jLabelCpfDono.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelCpfDono.setText("CPF:");

        jButtonCadastrarNovoDono.setText("Cadastrar novo...");
        jButtonCadastrarNovoDono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCadastrarNovoDonoMouseClicked(evt);
            }
        });
        jButtonCadastrarNovoDono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarNovoDonoActionPerformed(evt);
            }
        });

        jLabelDia.setText("Dia:");

        jLabelHora.setText("Hora:");

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

        javax.swing.GroupLayout jPanelDadosDonoLayout = new javax.swing.GroupLayout(jPanelDadosDono);
        jPanelDadosDono.setLayout(jPanelDadosDonoLayout);
        jPanelDadosDonoLayout.setHorizontalGroup(
            jPanelDadosDonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosDonoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadosDonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooserData, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNomeDono, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelDadosDonoLayout.createSequentialGroup()
                        .addGroup(jPanelDadosDonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldBuscaCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButtonBuscaCpf)
                            .addComponent(jLabelDia))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDadosDonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jRadioButtonBuscaCnpj)
                            .addComponent(jTextFieldBuscaCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 19, Short.MAX_VALUE)
                .addGroup(jPanelDadosDonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosDonoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanelDadosDonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCpfDono, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelDadosDonoLayout.createSequentialGroup()
                                .addComponent(jButtonPesquisarDono)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonCadastrarNovoDono))))
                    .addGroup(jPanelDadosDonoLayout.createSequentialGroup()
                        .addGroup(jPanelDadosDonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSpinnerHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelHora))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelDadosDonoLayout.setVerticalGroup(
            jPanelDadosDonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosDonoLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanelDadosDonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonBuscaCpf)
                    .addComponent(jRadioButtonBuscaCnpj))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDadosDonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPesquisarDono)
                    .addComponent(jTextFieldBuscaCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCadastrarNovoDono)
                    .addComponent(jTextFieldBuscaCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelDadosDonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNomeDono)
                    .addComponent(jLabelCpfDono))
                .addGap(20, 20, 20)
                .addGroup(jPanelDadosDonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDia)
                    .addComponent(jLabelHora))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDadosDonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSpinnerHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooserData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanelDadosAnimal.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do animal"));

        jLabelNomeAnimal.setText("Nome:");

        jLabelEspecie.setText("Espécie:");

        jLabelRaca.setText("Raça:");

        jLabelSexo.setText("Sexo:");

        jRadioButtonMacho.setText("Macho");
        jRadioButtonMacho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMachoActionPerformed(evt);
            }
        });

        jRadioButtonFemea.setText("Fêmea");
        jRadioButtonFemea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonFemeaActionPerformed(evt);
            }
        });

        jLabelIdade.setText("Idade:");

        jLabelPorte.setText("Porte do animal:");

        jRadioButtonGrandePorte.setText("Grande");
        jRadioButtonGrandePorte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonGrandePorteActionPerformed(evt);
            }
        });

        jRadioButtonPequenoPorte.setText("Pequeno");
        jRadioButtonPequenoPorte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonPequenoPorteActionPerformed(evt);
            }
        });

        jLabelPelagem.setText("Pelagem:");

        jLabelTipoAtendimento.setText("Tipo de atendimento:");

        jComboBoxTipoAtendimento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Agendado", "Emergência" }));

        jLabelRghumv.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelRghumv.setText("RGHUMV: ");

        javax.swing.GroupLayout jPanelDadosAnimalLayout = new javax.swing.GroupLayout(jPanelDadosAnimal);
        jPanelDadosAnimal.setLayout(jPanelDadosAnimalLayout);
        jPanelDadosAnimalLayout.setHorizontalGroup(
            jPanelDadosAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosAnimalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadosAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDadosAnimalLayout.createSequentialGroup()
                        .addGroup(jPanelDadosAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNomeAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldNomeAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldRaca, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelDadosAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelDadosAnimalLayout.createSequentialGroup()
                                .addComponent(jLabelEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29))
                            .addComponent(jTextFieldEspecie)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosAnimalLayout.createSequentialGroup()
                        .addGroup(jPanelDadosAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelDadosAnimalLayout.createSequentialGroup()
                                .addComponent(jLabelTipoAtendimento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelPelagem, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelDadosAnimalLayout.createSequentialGroup()
                                .addGroup(jPanelDadosAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelDadosAnimalLayout.createSequentialGroup()
                                        .addComponent(jLabelIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE))
                                    .addGroup(jPanelDadosAnimalLayout.createSequentialGroup()
                                        .addComponent(jTextFieldIdade)
                                        .addGap(72, 72, 72)))
                                .addGroup(jPanelDadosAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelDadosAnimalLayout.createSequentialGroup()
                                        .addComponent(jRadioButtonMacho)
                                        .addGap(46, 46, 46)
                                        .addComponent(jRadioButtonFemea))
                                    .addComponent(jLabelSexo)
                                    .addComponent(jLabelPorte)
                                    .addGroup(jPanelDadosAnimalLayout.createSequentialGroup()
                                        .addComponent(jRadioButtonGrandePorte)
                                        .addGap(42, 42, 42)
                                        .addComponent(jRadioButtonPequenoPorte)))))
                        .addGap(31, 31, 31))
                    .addGroup(jPanelDadosAnimalLayout.createSequentialGroup()
                        .addGroup(jPanelDadosAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelRaca, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelDadosAnimalLayout.createSequentialGroup()
                                .addComponent(jComboBoxTipoAtendimento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addGroup(jPanelDadosAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelRghumv)
                                    .addComponent(jTextFieldPelagem, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelDadosAnimalLayout.setVerticalGroup(
            jPanelDadosAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosAnimalLayout.createSequentialGroup()
                .addGroup(jPanelDadosAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelDadosAnimalLayout.createSequentialGroup()
                        .addComponent(jLabelEspecie)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelDadosAnimalLayout.createSequentialGroup()
                        .addComponent(jLabelNomeAnimal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNomeAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDadosAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelRaca)
                    .addComponent(jLabelSexo, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDadosAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDadosAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButtonMacho)
                        .addComponent(jRadioButtonFemea))
                    .addComponent(jTextFieldRaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDadosAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelIdade)
                    .addComponent(jLabelPorte))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDadosAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButtonGrandePorte)
                    .addComponent(jRadioButtonPequenoPorte))
                .addGap(9, 9, 9)
                .addGroup(jPanelDadosAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTipoAtendimento)
                    .addComponent(jLabelPelagem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDadosAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxTipoAtendimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPelagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabelRghumv)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelTitulo.setText("CADASTRAMENTO DE ANIMAL");

        jButtonConfirmar.setText("Confirmar");
        jButtonConfirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonConfirmarMouseClicked(evt);
            }
        });
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelDadosDono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonConfirmar))
                    .addComponent(jPanelDadosAnimal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabelTitulo)
                .addGap(26, 26, 26)
                .addComponent(jPanelDadosDono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jPanelDadosAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonConfirmar))
                .addContainerGap(33, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private String geraRghumv(){
        String rghumv="";
        try {
            ClientResponse response = RESTMethods.get("/api/animal");

            List<Animal> lista = (List<Animal>) RESTMethods.getObjectFromJSON(response, new TypeReference<List<Animal>>() {
            });
            int tam = lista.size();
            if(tam == 0) rghumv =""+ (lista.size()+1);
            else{
                rghumv =""+ (Integer.parseInt(lista.get(tam).getRghumv())+1);
            }
        } catch (RESTConnectionException | IOException ex) {
            MessagesUtils.erroConexao();
            LOG.warning(ex.getMessage());
            Logger.getLogger(CadastrarAnimalJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rghumv;
    }
    
    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed

        if (idDono == null) {
            JOptionPane.showMessageDialog(this, "Escolha ou cadastre um dono na lista.");
            return;
        }
        char sexo;
        float peso;
        int idade=-1;
        boolean pequenoPort;
        Date data;
        if (this.jTextFieldNomeAnimal.getText().isEmpty()) {
            MessagesUtils.validaCampoVazio("nome do animal");
            return;
        }
        String nomeAnimal = this.jTextFieldNomeAnimal.getText();
        if (this.jTextFieldEspecie.getText().isEmpty()) {
            MessagesUtils.validaCampoVazio("espécie");
            return;
        }
        String especie = this.jTextFieldEspecie.getText();
        if (this.jTextFieldRaca.getText().isEmpty()) {
            MessagesUtils.validaCampoVazio("raça");;
            return;
        }
        String raca = this.jTextFieldRaca.getText();
        if(this.jTextFieldIdade.getText().isEmpty()){
            MessagesUtils.validaCampoVazio("idade");;
        }else{
            idade = Integer.parseInt(this.jTextFieldIdade.getText());
        }
        if (this.jRadioButtonMacho.isSelected()) {
            sexo = 'M';
        } else {
            sexo = 'F';
        }
        
        String pelagem;
        if (this.jRadioButtonPequenoPorte.isSelected () ) {
            if (this.jTextFieldPelagem.getText().isEmpty()) {
                MessagesUtils.validaCampoVazio("pelagem");;
                return;
            } else {
                pelagem = this.jTextFieldPelagem.getText();
            }
            porte = "peqeno";
        }
        else {
            porte = "grande";
            pelagem = "não se aplica.";
        }
        String tipoDeAtendimento = null;
        if (this.jComboBoxTipoAtendimento.getSelectedIndex () == 0) {
            tipoDeAtendimento = "Agendado";
        }
        else if (this.jComboBoxTipoAtendimento.getSelectedIndex () == 1) {
            tipoDeAtendimento = "Emergência";
        }
        data = jDateChooserData.getDate();
        ClientResponse response;
        Animal animal = new Animal();
        animal.setIdDono(idDono);
        animal.setDataCadastro(data);
        animal.setEspecie(especie);
        animal.setIdade (idade);
        animal.setNome (nomeAnimal);
        animal.setPeso (0);
        animal.setRaca (raca);
        animal.setRghumv (geraRghumv());
        animal.setSexo (sexo);
        animal.setPorte (porte);
        animal.setPelagem (pelagem);
        try {
            response = RESTMethods.post(this.servicoAnimal, animal);
            String resposta = response.getEntity(String.class);
            if (!resposta.equalsIgnoreCase("ok")) {
                MessagesUtils.erroCadastro("animal");
            }else{
                MessagesUtils.sucessoCadastro("animal");
            }
        }
        catch (RESTConnectionException ex) {
            Logger.getLogger(CadastrarAnimalJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonConfirmarActionPerformed
    
    
    
    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        int op = MessagesUtils.dialogoCancelar("o cadastro", "animal");
        if(op == JOptionPane.OK_OPTION){
            this.setVisible(false);
            System.gc();
            HUMVApp.exibirMensagemCarregamento();
            HUMVApp.setPainelCentralComLogo();
            HUMVApp.esconderMensagemCarregamento();
        }
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonPesquisarDonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarDonoActionPerformed
        if(jRadioButtonBuscaCpf.isSelected()){
            if (ValidationsUtils.isCPF(MaskUtils.removeMascara(this.jTextFieldBuscaCpf.getText()))) {
                ClientResponse response;
                try {
                    this.setIdNull();
                    response = RESTMethods.get(servicoDono + "/" + MaskUtils.removeMascara(this.jTextFieldBuscaCpf.getText()) + "");
                    Dono at = response.getEntity(Dono.class);
                    this.idDono = at.getId();
                    this.jLabelCpfDono.setText("CPF: " + idDono);
                    this.jLabelNomeDono.setText("Nome: " + at.getNome());
                } catch (RESTConnectionException ex) {
                    Logger.getLogger(CadastrarAnimalJPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                this.setIdNull();
                MessagesUtils.validaCampoInvalido("CPF");
            }
        }else{
            if (ValidationsUtils.isCNPJ(MaskUtils.removeMascara(this.jTextFieldBuscaCnpj.getText()))) {
                ClientResponse response;
                try {
                    this.setIdNull();
                    response = RESTMethods.get(servicoDono + "/" + MaskUtils.removeMascara(this.jTextFieldBuscaCpf.getText()) + "");
                    Dono at = response.getEntity(Dono.class);
                    this.idDono = at.getId();
                    this.jLabelCpfDono.setText("CNPJ: " + idDono);
                    this.jLabelNomeDono.setText("Nome: " + at.getNome());
                } catch (RESTConnectionException ex) {
                    Logger.getLogger(CadastrarAnimalJPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                this.setIdNull();
                MessagesUtils.validaCampoInvalido("CNPJ");
            }
        }        
    }//GEN-LAST:event_jButtonPesquisarDonoActionPerformed

    private void jTextFieldBuscaCpfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscaCpfKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.jButtonPesquisarDonoActionPerformed(null);
        }
    }//GEN-LAST:event_jTextFieldBuscaCpfKeyPressed

    private void jButtonCadastrarNovoDonoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCadastrarNovoDonoMouseClicked
        CadastrarDonoJDialog dono = new CadastrarDonoJDialog(parent, true, this);
        dono.setTitle("CADASTRAMENTO DE DONO");
        dono.setLocationRelativeTo(null);
        dono.setVisible(true);
    }//GEN-LAST:event_jButtonCadastrarNovoDonoMouseClicked

    private void jButtonCadastrarNovoDonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarNovoDonoActionPerformed
      
    }//GEN-LAST:event_jButtonCadastrarNovoDonoActionPerformed

    private void jButtonConfirmarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonConfirmarMouseClicked
      
    }//GEN-LAST:event_jButtonConfirmarMouseClicked

    private void jRadioButtonPequenoPorteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonPequenoPorteActionPerformed
        this.jRadioButtonGrandePorte.setSelected(false);
        this.jLabelPelagem.setVisible(true);
        this.jTextFieldPelagem.setVisible(true);
    }//GEN-LAST:event_jRadioButtonPequenoPorteActionPerformed

    private void jRadioButtonGrandePorteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonGrandePorteActionPerformed
        this.jRadioButtonPequenoPorte.setSelected(false);
        this.jLabelPelagem.setVisible(false);
        this.jTextFieldPelagem.setVisible(false);
    }//GEN-LAST:event_jRadioButtonGrandePorteActionPerformed

    private void jRadioButtonFemeaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonFemeaActionPerformed
            this.jRadioButtonMacho.setSelected(false);
    }//GEN-LAST:event_jRadioButtonFemeaActionPerformed

    private void jRadioButtonMachoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMachoActionPerformed
        this.jRadioButtonFemea.setSelected(false);
    }//GEN-LAST:event_jRadioButtonMachoActionPerformed

    private void jRadioButtonBuscaCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonBuscaCpfActionPerformed
        this.jRadioButtonBuscaCnpj.setSelected(false);
        this.jTextFieldBuscaCpf.setEnabled(true);
        this.jTextFieldBuscaCpf.setFocusable(true);
        this.jTextFieldBuscaCnpj.setText("");
        this.jTextFieldBuscaCnpj.setEnabled(false);
        this.jLabelCpfDono.setText("CPF: ");
    }//GEN-LAST:event_jRadioButtonBuscaCpfActionPerformed

    private void jRadioButtonBuscaCnpjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonBuscaCnpjActionPerformed
        this.jRadioButtonBuscaCpf.setSelected(false);
        this.jTextFieldBuscaCnpj.setEnabled(true);
        this.jTextFieldBuscaCnpj.setFocusable(true);
        this.jTextFieldBuscaCpf.setText("");
        this.jTextFieldBuscaCpf.setEnabled(false);
        this.jLabelCpfDono.setText("CNPJ: ");
    }//GEN-LAST:event_jRadioButtonBuscaCnpjActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCadastrarNovoDono;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JButton jButtonPesquisarDono;
    private javax.swing.JComboBox<String> jComboBoxTipoAtendimento;
    private com.toedter.calendar.JDateChooser jDateChooserData;
    private javax.swing.JLabel jLabelCpfDono;
    private javax.swing.JLabel jLabelDia;
    private javax.swing.JLabel jLabelEspecie;
    private javax.swing.JLabel jLabelHora;
    private javax.swing.JLabel jLabelIdade;
    private javax.swing.JLabel jLabelNomeAnimal;
    private javax.swing.JLabel jLabelNomeDono;
    private javax.swing.JLabel jLabelPelagem;
    private javax.swing.JLabel jLabelPorte;
    private javax.swing.JLabel jLabelRaca;
    private javax.swing.JLabel jLabelRghumv;
    private javax.swing.JLabel jLabelSexo;
    private javax.swing.JLabel jLabelTipoAtendimento;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanelDadosAnimal;
    private javax.swing.JPanel jPanelDadosDono;
    private javax.swing.JRadioButton jRadioButtonBuscaCnpj;
    private javax.swing.JRadioButton jRadioButtonBuscaCpf;
    private javax.swing.JRadioButton jRadioButtonFemea;
    private javax.swing.JRadioButton jRadioButtonGrandePorte;
    private javax.swing.JRadioButton jRadioButtonMacho;
    private javax.swing.JRadioButton jRadioButtonPequenoPorte;
    private javax.swing.JSpinner jSpinnerHoras;
    private javax.swing.JTextField jTextFieldBuscaCnpj;
    private javax.swing.JTextField jTextFieldBuscaCpf;
    private javax.swing.JTextField jTextFieldEspecie;
    private javax.swing.JTextField jTextFieldIdade;
    private javax.swing.JTextField jTextFieldNomeAnimal;
    private javax.swing.JTextField jTextFieldPelagem;
    private javax.swing.JTextField jTextFieldRaca;
    // End of variables declaration//GEN-END:variables
    
    @Override
    public void actionPerformed(ActionEvent ae) {}
}
