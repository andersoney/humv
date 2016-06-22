package br.edu.ufrb.lasis.humv.view.animal;

import br.edu.ufrb.lasis.humv.view.dono.CadastroDonoJDialog;
import br.edu.ufrb.lasis.humv.utils.Util;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import br.edu.ufrb.lasis.humv.entity.Animal;
import br.edu.ufrb.lasis.humv.entity.Dono;
import br.edu.ufrb.lasis.humv.rest.RESTConnectionException;
import br.edu.ufrb.lasis.humv.rest.RESTMethods;
import com.sun.jersey.api.client.ClientResponse;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    String cpf;
    String nome;
    String porte;
    final private String servicoDono = "/api/dono";
    final private String servicoAnimalP = "/api/animalPequeno";
    final private String servicoAnimalG = "/api/animalGrande";
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
            labelCpfDono.setText("CPF: " + animalSelecionado.getCpfDono());
            if (Util.isCPF(animalSelecionado.getCpfDono())) {
                ClientResponse response;
                try {
                    this.setCPFNull();
                    response = RESTMethods.get(servicoDono + "/" + animalSelecionado.getCpfDono() + "");
                    Dono at = response.getEntity(Dono.class);
                    this.cpf = at.getCpf();
                    this.labelCpfDono.setText("CPF: " + cpf);
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
        }
    }

    /**
     * Creates new form CadastroAnimals
     *
     * @param parent
     */
    public CadastroAnimal(JFrame parent) {
        //this.removerDono();
        this.parent = parent;
        initComponents();
        this.labelTitulo.setText("Cadastro do animal");
        this.pequenoPorteJRB.setSelected(true);
        Calendar cal = Calendar.getInstance();
        Date n = cal.getTime();
        adicionarAno();
        this.diaJCB.setSelectedIndex(n.getDate());
        this.mesJCB.setSelectedIndex(n.getMonth() + 1);
        this.anoJCB.setSelectedIndex(n.getYear() - (n.getYear() - 60) + 1);
        this.horaJCB.setSelectedIndex(n.getHours() + 1);
        this.minJCB.setSelectedIndex(n.getMinutes() + 1);
    }

    CadastroAnimal(Object object, Animal atual, String OPCAO_VISUALIZAR) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void removerDono() {
        ClientResponse response;
        try {
            response = RESTMethods.delete(this.servicoAnimalG + "/05741155529", "humv");
        } catch (RESTConnectionException ex) {
            Logger.getLogger(CadastroAnimal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public CadastroAnimal(JFrame parent, boolean Pequeno) {
        this.parent = parent;
        initComponents();
        this.labelTitulo.setText("Cadastro de Animais");
        this.pequenoPorteJRB.setSelected(true);
        Calendar cal = Calendar.getInstance();
        Date n = cal.getTime();
        adicionarAno();
        this.diaJCB.setSelectedIndex(n.getDate());
        this.mesJCB.setSelectedIndex(n.getMonth() + 1);
        this.anoJCB.setSelectedIndex(n.getYear() - (n.getYear() - 60) + 1);
        this.horaJCB.setSelectedIndex(n.getHours() + 1);
        this.minJCB.setSelectedIndex(n.getMinutes() + 1);
        if (Pequeno) {
            this.pequenoPorteJRB.setSelected(true);
            pequenoPorteJRBActionPerformed(null);
            this.pequenoPorteJRB.setEnabled(false);
            this.grandePorteJRB.setEnabled(false);

        } else {
            this.grandePorteJRB.setSelected(true);
            grandePorteJRBActionPerformed(null);
            this.pequenoPorteJRB.setEnabled(false);
            this.grandePorteJRB.setEnabled(false);
        }
    }

    private void adicionarAno() {
        Calendar cal = Calendar.getInstance();
        Date n = cal.getTime();
        this.anoJCB.addItem("Ano");
        for (int i = n.getYear() - 60; i <= n.getYear(); i++) {
            this.anoJCB.addItem("" + (i + 1900));
        }
    }

    public void setCPFNull() {
        this.cpf = null;
        this.nome = null;
        this.nomeDJL.setText("Nome: ");
        this.labelCpfDono.setText("CPF: ");
    }

    public void setCPF(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
        this.nomeDJL.setText("Nome: " + nome);
        this.labelCpfDono.setText("CPF: " + cpf);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        buscarDJL = new javax.swing.JLabel();
        pesquisarDJB = new javax.swing.JButton();
        cpfBuscarJTF = new javax.swing.JTextField();
        nomeDJL = new javax.swing.JLabel();
        labelCpfDono = new javax.swing.JLabel();
        diaJCB = new javax.swing.JComboBox<>();
        mesJCB = new javax.swing.JComboBox<>();
        anoJCB = new javax.swing.JComboBox<>();
        horaJCB = new javax.swing.JComboBox<>();
        minJCB = new javax.swing.JComboBox<>();
        jbCadastrarNovoDono = new javax.swing.JButton();
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
        pesoJL = new javax.swing.JLabel();
        textFieldPeso = new javax.swing.JTextField();
        porteDoAnimalJL = new javax.swing.JLabel();
        grandePorteJRB = new javax.swing.JRadioButton();
        pequenoPorteJRB = new javax.swing.JRadioButton();
        pelagemJL = new javax.swing.JLabel();
        textFieldPelagem = new javax.swing.JTextField();
        TipodeAtendimentoJL = new javax.swing.JLabel();
        comboBoxTipoAtendimento = new javax.swing.JComboBox<>();
        buttonCancelar = new javax.swing.JButton();
        labelTitulo = new javax.swing.JLabel();
        buttonOK = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Dono"));

        buscarDJL.setText("Digite o CPF do dono");

        pesquisarDJB.setText("Pesquisar");
        pesquisarDJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarDJBActionPerformed(evt);
            }
        });

        cpfBuscarJTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cpfBuscarJTFKeyPressed(evt);
            }
        });

        nomeDJL.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nomeDJL.setText("Nome:");

        labelCpfDono.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelCpfDono.setText("CPF:");

        diaJCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dia", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        mesJCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mes", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        horaJCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hora", "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));

        minJCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Min", "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60" }));

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomeDJL, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(diaJCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mesJCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(anoJCB, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cpfBuscarJTF, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(buscarDJL, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pesquisarDJB)
                        .addGap(28, 28, 28)
                        .addComponent(jbCadastrarNovoDono))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(horaJCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(minJCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelCpfDono, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buscarDJL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pesquisarDJB)
                    .addComponent(cpfBuscarJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbCadastrarNovoDono))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeDJL)
                    .addComponent(labelCpfDono))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(minJCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(horaJCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anoJCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mesJCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diaJCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
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

        comboBoxTipoAtendimento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal", "Emergencial", " " }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nomeAJL, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                            .addComponent(textFieldNome))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(especieJL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textFieldEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(idadeJL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textFieldIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(99, 99, 99)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textFieldPeso)
                            .addComponent(pesoJL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(racaJL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textFieldRaca, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sexoJL, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(radioButtonMacho)
                                .addGap(18, 18, 18)
                                .addComponent(radioButtonFemea))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TipodeAtendimentoJL)
                            .addComponent(comboBoxTipoAtendimento, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(porteDoAnimalJL, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(grandePorteJRB)
                                .addGap(18, 18, 18)
                                .addComponent(pequenoPorteJRB))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pelagemJL, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldPelagem, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
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
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(racaJL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldRaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(sexoJL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radioButtonMacho)
                            .addComponent(radioButtonFemea))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(idadeJL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(pesoJL)
                        .addGap(26, 26, 26)))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(grandePorteJRB)
                            .addComponent(pequenoPorteJRB)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(porteDoAnimalJL)
                            .addComponent(TipodeAtendimentoJL))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboBoxTipoAtendimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pelagemJL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldPelagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        buttonCancelar.setText("Cancelar");
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });

        labelTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelTitulo.setText("Titulo");

        buttonOK.setText("Confirmar");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(155, 155, 155)
                                .addComponent(buttonCancelar)
                                .addGap(41, 41, 41)
                                .addComponent(buttonOK)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCancelar)
                    .addComponent(buttonOK))
                .addContainerGap(42, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void radioButtonMachoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonMachoActionPerformed
        // TODO add your handling code here:
        this.radioButtonFemea.setSelected(false);
    }//GEN-LAST:event_radioButtonMachoActionPerformed

    private void radioButtonFemeaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonFemeaActionPerformed
        // TODO add your handling code here:
        this.radioButtonMacho.setSelected(false);
    }//GEN-LAST:event_radioButtonFemeaActionPerformed

    private void pequenoPorteJRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pequenoPorteJRBActionPerformed
        // TODO add your handling code here:
        this.grandePorteJRB.setSelected(false);
        this.pelagemJL.setVisible(true);
        this.textFieldPelagem.setVisible(true);
    }//GEN-LAST:event_pequenoPorteJRBActionPerformed

    private void grandePorteJRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grandePorteJRBActionPerformed
        // TODO add your handling code here:
        this.pequenoPorteJRB.setSelected(false);
        this.pelagemJL.setVisible(false);
        this.textFieldPelagem.setVisible(false);
    }//GEN-LAST:event_grandePorteJRBActionPerformed

    private void buttonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOKActionPerformed
        // TODO add your handling code here:
        if (cpf == null) {
            JOptionPane.showMessageDialog(this, "Escolha um dono na lista ou cadastre.");
            return;
        }
        char sexo;
        float peso;
        int idade;
        boolean pequenoPort;
        if (!Util.isNotNull(this.textFieldNome.getText())) {
            JOptionPane.showMessageDialog(this, "Nome do animal não pode ficar vazio.");
            return;
        }
        String nome = this.textFieldNome.getText();
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
        try {
            idade = Integer.parseInt(this.textFieldIdade.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Digite uma idade valida.\nValor Inteiro.");
            return;
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
        String rghumv="";
        try {
            ClientResponse response = RESTMethods.get("/api/animal");

            List<Animal> lista = (List<Animal>) RESTMethods.getObjectFromJSON(response, new TypeReference<List<Animal>>() {
            });
            rghumv = "" + lista.size()+1;
        } catch (RESTConnectionException | IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar-se com banco de dados. Por favor, tente novamente mais tarde.", "Falha na autenticação", JOptionPane.ERROR_MESSAGE);
            LOG.warning(ex.getMessage());
            Logger.getLogger(CadastroAnimal.class.getName()).log(Level.SEVERE, null, ex);
        }

    String pelagem = null;

    if (this.pequenoPorteJRB.isSelected () 
        ) {
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

    if (this.comboBoxTipoAtendimento.getSelectedIndex () 
        == 0) {
            tipoDeAtendimento = "Normal";
    }

    else if (this.comboBoxTipoAtendimento.getSelectedIndex () 
        == 1) {
            tipoDeAtendimento = "Emergencial";
    }

    if (this.anoJCB.getSelectedIndex () 
        == 0
                || this.mesJCB.getSelectedIndex() == 0
                || this.diaJCB.getSelectedIndex() == 0
                || this.horaJCB.getSelectedIndex() == 0
                || this.minJCB.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Digite uma data e hora valida.");
    }
    ClientResponse response;

    Animal animal = new Animal();

    animal.setCpfDono (cpf);

    animal.setDataCadastro (

    new Date(this.anoJCB.getSelectedIndex() + (Calendar.getInstance().getTime().getYear() - 60),
                    this.mesJCB.getSelectedIndex(),
                    this.diaJCB.getSelectedIndex(),
                    this.horaJCB.getSelectedIndex() - 1, this.minJCB.getSelectedIndex() - 1));
    animal.setEspecie (especie);

    animal.setIdade (idade);

    animal.setNome (nome);

    animal.setPeso (peso);

    animal.setRaca (raca);

    animal.setRghumv (rghumv);

    animal.setSexo (sexo);

    animal.setPorte (porte);

    animal.setPelagem (pelagem);

    
        try {
            response = RESTMethods.post(this.servicoAnimal, animal);
        String resposta = response.getEntity(String.class);
        if (!resposta.equalsIgnoreCase("ok")) {
            JOptionPane.showMessageDialog(this, resposta, "Falha no cadastro", JOptionPane.ERROR_MESSAGE);
        }
    }
    catch (RESTConnectionException ex

    
        ) {
            Logger.getLogger(CadastroAnimal.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_buttonOKActionPerformed

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        System.gc();
    }//GEN-LAST:event_buttonCancelarActionPerformed

    private void pesquisarDJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarDJBActionPerformed
        // TODO add your handling code here:
        
            //Dando erro aqui, a ser verificado, tudo indica que seja a forma c-
            //omo o parametro é passado que é tratado como ilegal pela classe feita por tassio.
            if (Util.isCPF(this.cpfBuscarJTF.getText())) {
                ClientResponse response;
                try {
                    this.setCPFNull();
                    response = RESTMethods.get(servicoDono + "/" + this.cpfBuscarJTF.getText() + "");
                    Dono 

at = response.getEntity(Dono.class
);
                    this.cpf = at.getCpf();
                    this.labelCpfDono.setText("CPF: " + cpf);
                    this.nomeDJL.setText("Nome: " + at.getNome());
                

} catch (RESTConnectionException ex) {
                    Logger.getLogger(CadastroAnimal.class
.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                this.setCPFNull();
                JOptionPane.showMessageDialog(null, "Digite um CPF Valido.");
            }
            
    }//GEN-LAST:event_pesquisarDJBActionPerformed

    private void cpfBuscarJTFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cpfBuscarJTFKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.pesquisarDJBActionPerformed(null);
        }
    }//GEN-LAST:event_cpfBuscarJTFKeyPressed

    private void jbCadastrarNovoDonoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbCadastrarNovoDonoMouseClicked
        CadastroDonoJDialog dono = new CadastroDonoJDialog(parent, true, this);
        dono.setTitle("Cadastro de dono de animais");
        dono.setLocationRelativeTo(null);
        dono.setVisible(true);
    }//GEN-LAST:event_jbCadastrarNovoDonoMouseClicked

    private void jbCadastrarNovoDonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarNovoDonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbCadastrarNovoDonoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TipodeAtendimentoJL;
    private javax.swing.JComboBox<String> anoJCB;
    private javax.swing.JLabel buscarDJL;
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonOK;
    private javax.swing.JComboBox<String> comboBoxTipoAtendimento;
    private javax.swing.JTextField cpfBuscarJTF;
    private javax.swing.JComboBox<String> diaJCB;
    private javax.swing.JLabel especieJL;
    private javax.swing.JRadioButton grandePorteJRB;
    private javax.swing.JComboBox<String> horaJCB;
    private javax.swing.JLabel idadeJL;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jbCadastrarNovoDono;
    private javax.swing.JLabel labelCpfDono;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JComboBox<String> mesJCB;
    private javax.swing.JComboBox<String> minJCB;
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
        public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
