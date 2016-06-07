package br.edu.ufrb.lasis.humv.view.Animais;

import br.edu.ufrb.lasis.humv.utils.Util;
import br.edu.ufrb.lasis.humv.Dono.CadastroDonoJDialog;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import br.edu.ufrb.lasis.humv.entity.AnimalGrande;
import br.edu.ufrb.lasis.humv.entity.AnimalPequeno;
import br.edu.ufrb.lasis.humv.entity.Dono;
import br.edu.ufrb.lasis.humv.rest.RESTConnectionException;
import br.edu.ufrb.lasis.humv.rest.RESTMethods;
import br.edu.ufrb.lasis.humv.view.busca.PropriedadesBusca;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Andersoney
 */
public class CadastroAnimals extends javax.swing.JPanel {

    public CadastroAnimals(JFrame parent, AnimalGrande atualAnimal, String opcao) {
        this.atualAnimal = atualAnimal;
        this.parent = parent;
        initComponents();
        this.tituloJL.setText("Cadastro do animal");
        configurarAnimalAtual();
        this.opcao = opcao;
        switch (opcao) {
            case PropriedadesBusca.OPCAO_ALTERAR:
                this.confirmarJB.setText("Alterar");
                break;
            case PropriedadesBusca.OPCAO_REMOVER:
                this.confirmarJB.setText("remover");
                break;
            case PropriedadesBusca.OPCAO_VISUALIZAR:
                this.confirmarJB.setVisible(false);
                break;
            default:
                break;
        }
    }

    public CadastroAnimals(JFrame parent, boolean Pequeno) {
        this.opcao = "Cadastro";
        this.parent = parent;
        initComponents();
        this.tituloJL.setText("Cadastro de Animais");
        this.pequenoPorteJRB.setSelected(true);
        Calendar cal = Calendar.getInstance();
        Date n = cal.getTime();
        this.SetarData(n);
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

    /**
     * Creates new form CadastroAnimals
     *
     * @param parent
     */
    public CadastroAnimals(JFrame parent) {
        //this.removerDono();
        this.opcao="Cadastro";
        this.parent = parent;
        initComponents();
        this.tituloJL.setText("Cadastro do animal");
        this.pequenoPorteJRB.setSelected(true);
        Calendar cal = Calendar.getInstance();
        Date n = cal.getTime();
        SetarData(n);
    }

    private void SetarData(Date n) {
        this.opcao = "Cadastro";
        adicionarAno();
        this.diaJCB.setSelectedIndex(n.getDate());
        this.mesJCB.setSelectedIndex(n.getMonth() + 1);
        this.anoJCB.setSelectedIndex(n.getYear() - (n.getYear() - 60) + 1);
        this.horaJCB.setSelectedIndex(n.getHours() + 1);
        this.minJCB.setSelectedIndex(n.getMinutes() + 1);
    }

    private void configurarAnimalAtual() throws ClientHandlerException, UniformInterfaceException, HeadlessException {
        this.cadastrarDJL.setEnabled(false);
        this.cpfBuscarJTF.setEnabled(false);

        if (this.atualAnimal instanceof AnimalPequeno) {
            this.PelagemJTF.setText(((AnimalPequeno) this.atualAnimal).getPelagem());
        }
        this.SetarData(atualAnimal.getDataCadastro());
        this.nomeAJTF.setText(this.atualAnimal.getNome());
        this.especieJTF.setText(this.atualAnimal.getEspecie());
        this.cpfBuscarJTF.setText(this.atualAnimal.getCpfDono());
        this.buscarDonoCPF();
        this.especieJTF.setText(this.atualAnimal.getEspecie());
        this.idadeJTF.setText("" + this.atualAnimal.getIdade());
        this.pesoJTF.setText("" + this.atualAnimal.getPeso());
        this.racaJTF.setText(this.atualAnimal.getRaca());
        this.rghumvJTF.setText("" + this.atualAnimal.getRghumv());
        if (this.atualAnimal.getSexo() == 'm' || this.atualAnimal.getSexo() == 'M') {
            this.machoJRB.setSelected(true);
            this.femeaJRB.setSelected(false);
        } else {
            this.machoJRB.setSelected(false);
            this.femeaJRB.setSelected(true);
        }
    }

    private void removerDono() {
        ClientResponse response;
        try {
            response = RESTMethods.delete(this.servicoAnimalG + "/05741155529", "humv");
        } catch (RESTConnectionException ex) {
            Logger.getLogger(CadastroAnimals.class.getName()).log(Level.SEVERE, null, ex);
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
        this.cpfDJL.setText("CPF: ");
    }

    public void setCPF(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
        this.nomeDJL.setText("Nome: " + nome);
        this.cpfDJL.setText("CPF: " + cpf);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        buscarDJL = new javax.swing.JLabel();
        pesquisarDJB = new javax.swing.JButton();
        cpfBuscarJTF = new javax.swing.JTextField();
        nomeDJL = new javax.swing.JLabel();
        cpfDJL = new javax.swing.JLabel();
        cadastrarDJL = new javax.swing.JLabel();
        diaJCB = new javax.swing.JComboBox<>();
        mesJCB = new javax.swing.JComboBox<>();
        anoJCB = new javax.swing.JComboBox<>();
        horaJCB = new javax.swing.JComboBox<>();
        minJCB = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        nomeAJL = new javax.swing.JLabel();
        nomeAJTF = new javax.swing.JTextField();
        especieJL = new javax.swing.JLabel();
        especieJTF = new javax.swing.JTextField();
        racaJL = new javax.swing.JLabel();
        racaJTF = new javax.swing.JTextField();
        sexoJL = new javax.swing.JLabel();
        machoJRB = new javax.swing.JRadioButton();
        femeaJRB = new javax.swing.JRadioButton();
        idadeJL = new javax.swing.JLabel();
        idadeJTF = new javax.swing.JTextField();
        pesoJL = new javax.swing.JLabel();
        pesoJTF = new javax.swing.JTextField();
        rghumvJL = new javax.swing.JLabel();
        rghumvJTF = new javax.swing.JTextField();
        porteDoAnimalJL = new javax.swing.JLabel();
        grandePorteJRB = new javax.swing.JRadioButton();
        pequenoPorteJRB = new javax.swing.JRadioButton();
        pelagemJL = new javax.swing.JLabel();
        PelagemJTF = new javax.swing.JTextField();
        TipodeAtendimentoJL = new javax.swing.JLabel();
        tipodeAtendimentoJCB = new javax.swing.JComboBox<>();
        cancelarJB = new javax.swing.JButton();
        tituloJL = new javax.swing.JLabel();
        confirmarJB = new javax.swing.JButton();

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

        nomeDJL.setText("Nome");

        cpfDJL.setText("CPF");

        cadastrarDJL.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        cadastrarDJL.setForeground(new java.awt.Color(0, 0, 255));
        cadastrarDJL.setText("Cadastrar novo Dono");
        cadastrarDJL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cadastrarDJLMouseClicked(evt);
            }
        });

        diaJCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dia", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        mesJCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mes", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        horaJCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hora", "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));

        minJCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Min", "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nomeDJL, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(diaJCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(mesJCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(anoJCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cpfDJL, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(horaJCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(minJCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(cpfBuscarJTF, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(pesquisarDJB))
                        .addComponent(buscarDJL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(cadastrarDJL, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buscarDJL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pesquisarDJB)
                    .addComponent(cpfBuscarJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cadastrarDJL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeDJL)
                    .addComponent(cpfDJL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(diaJCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mesJCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anoJCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(horaJCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minJCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Animal"));

        nomeAJL.setText("Nome");

        especieJL.setText("Espécie");

        racaJL.setText("Raça");

        sexoJL.setText("Sexo");

        machoJRB.setText("Macho");
        machoJRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                machoJRBActionPerformed(evt);
            }
        });

        femeaJRB.setText("Fêmea");
        femeaJRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femeaJRBActionPerformed(evt);
            }
        });

        idadeJL.setText("Idade");

        pesoJL.setText("Peso");

        rghumvJL.setText("RGHUMV");

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

        tipodeAtendimentoJCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal", "Emergencial", " " }));

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
                            .addComponent(nomeAJTF))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(especieJL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(especieJTF, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(idadeJL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(idadeJTF, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pesoJL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pesoJTF)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(racaJL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(racaJTF, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sexoJL, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(machoJRB)
                                .addGap(18, 18, 18)
                                .addComponent(femeaJRB))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rghumvJL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rghumvJTF, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(porteDoAnimalJL, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(grandePorteJRB)
                                .addGap(18, 18, 18)
                                .addComponent(pequenoPorteJRB))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TipodeAtendimentoJL)
                            .addComponent(tipodeAtendimentoJCB, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pelagemJL, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                            .addComponent(PelagemJTF))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(especieJL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(especieJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(nomeAJL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomeAJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(racaJL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(racaJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(sexoJL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(machoJRB)
                            .addComponent(femeaJRB))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(idadeJL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idadeJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(pesoJL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pesoJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(grandePorteJRB)
                                .addComponent(pequenoPorteJRB)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(porteDoAnimalJL)
                            .addGap(32, 32, 32)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rghumvJL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rghumvJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pelagemJL)
                    .addComponent(TipodeAtendimentoJL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PelagemJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipodeAtendimentoJCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        cancelarJB.setText("Cancelar");
        cancelarJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarJBActionPerformed(evt);
            }
        });

        tituloJL.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tituloJL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloJL.setText("Titulo");

        confirmarJB.setText("Confirmar");
        confirmarJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarJBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(cancelarJB)
                                    .addGap(18, 18, 18)
                                    .addComponent(confirmarJB))
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(tituloJL, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(tituloJL, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelarJB)
                    .addComponent(confirmarJB))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void machoJRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_machoJRBActionPerformed
        // TODO add your handling code here:
        this.femeaJRB.setSelected(false);
    }//GEN-LAST:event_machoJRBActionPerformed

    private void femeaJRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femeaJRBActionPerformed
        // TODO add your handling code here:
        this.machoJRB.setSelected(false);
    }//GEN-LAST:event_femeaJRBActionPerformed

    private void pequenoPorteJRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pequenoPorteJRBActionPerformed
        // TODO add your handling code here:
        this.grandePorteJRB.setSelected(false);
        this.pelagemJL.setVisible(true);
        this.PelagemJTF.setVisible(true);
    }//GEN-LAST:event_pequenoPorteJRBActionPerformed

    private void grandePorteJRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grandePorteJRBActionPerformed
        // TODO add your handling code here:
        this.pequenoPorteJRB.setSelected(false);
        this.pelagemJL.setVisible(false);
        this.PelagemJTF.setVisible(false);
    }//GEN-LAST:event_grandePorteJRBActionPerformed

    private void cadastrarDJLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cadastrarDJLMouseClicked
        // TODO add your handling code here:
        CadastroDonoJDialog dono = new CadastroDonoJDialog(parent, true, this);
        dono.setTitle("Cadastro de dono de animais");
        dono.setLocationRelativeTo(null);
        dono.setVisible(true);
    }//GEN-LAST:event_cadastrarDJLMouseClicked

    private void confirmarJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarJBActionPerformed
        // TODO add your handling code here:
        if (cpf == null) {
            JOptionPane.showMessageDialog(this, "Escolha um dono na lista ou cadastre.");
            return;
        }
        char sexo;
        float peso;
        int idade;
        boolean pequenoPort;
        if (!Util.isNotNull(this.nomeAJTF.getText())) {
            JOptionPane.showMessageDialog(this, "Nome do animal não pode ficar vazio.");
            return;
        }
        String nome = this.nomeAJTF.getText();
        if (!Util.isNotNull(this.especieJTF.getText())) {
            JOptionPane.showMessageDialog(this, "Especie não pode ficar vazio.");
            return;
        }
        String especie = this.especieJTF.getText();
        if (!Util.isNotNull(this.racaJTF.getText())) {
            JOptionPane.showMessageDialog(this, "Campo raça não pode ficar vazio.");
            return;
        }
        String raca = this.racaJTF.getText();
        try {
            idade = Integer.parseInt(this.idadeJTF.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Digite uma idade valida.\nValor Inteiro.");
            return;
        }
        if (this.machoJRB.isSelected()) {
            sexo = 'M';
        } else {
            sexo = 'F';
        }
        try {
            peso = Float.parseFloat(this.pesoJTF.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Digite um peso valido.");
            return;
        }
        String rghumv;
        if (!Util.isNotNull(this.rghumvJTF.getText())) {
            JOptionPane.showMessageDialog(this, "Preencha o RGHUMV.");
            return;
        } else {
            rghumv = this.rghumvJTF.getText();
        }
        String pelagem = null;
        if (this.pequenoPorteJRB.isSelected()) {
            if (!Util.isNotNull(this.PelagemJTF.getText())) {
                JOptionPane.showMessageDialog(this, "Digite a pelagem do animal.");
                return;
            } else {
                pelagem = this.PelagemJTF.getText();
                pequenoPort = true;
            }
        } else {
            pequenoPort = false;
        }
        String tipoDeAtendimento = null;
        if (this.tipodeAtendimentoJCB.getSelectedIndex() == 0) {
            tipoDeAtendimento = "Normal";
        } else if (this.tipodeAtendimentoJCB.getSelectedIndex() == 1) {
            tipoDeAtendimento = "Emergencial";
        }
        if (this.anoJCB.getSelectedIndex() == 0
                || this.mesJCB.getSelectedIndex() == 0
                || this.diaJCB.getSelectedIndex() == 0
                || this.horaJCB.getSelectedIndex() == 0
                || this.minJCB.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Digite uma data e hora valida.");
        }
        ClientResponse response;
        if (!pequenoPort) {
            AnimalGrande aniGrand = new AnimalGrande();
            aniGrand.setCpfDono(cpf);
            aniGrand.setDataCadastro(new Date(this.anoJCB.getSelectedIndex() + (Calendar.getInstance().getTime().getYear() - 60),
                    this.mesJCB.getSelectedIndex(),
                    this.diaJCB.getSelectedIndex(),
                    this.horaJCB.getSelectedIndex() - 1, this.minJCB.getSelectedIndex() - 1));
            aniGrand.setEspecie(especie);
            aniGrand.setIdade(idade);
            aniGrand.setNome(nome);
            aniGrand.setPeso(peso);
            aniGrand.setRaca(raca);
            aniGrand.setRghumv(rghumv);
            aniGrand.setSexo(sexo);

            try {
                response = RESTMethods.post(this.servicoAnimalG, aniGrand);
                String resposta = response.getEntity(String.class);
                if (!resposta.equalsIgnoreCase("ok")) {
                    JOptionPane.showMessageDialog(this, resposta, "Falha no cadastro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (RESTConnectionException ex) {
                Logger.getLogger(CadastroAnimals.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            AnimalPequeno aniPequeno = new AnimalPequeno();
            aniPequeno.setCpfDono(cpf);
            //Verificar aqui.
            //aniPequeno.setDataCadastro(new Date(idade, WIDTH, idade, ERROR, WIDTH));
            aniPequeno.setEspecie(especie);
            aniPequeno.setIdade(idade);
            aniPequeno.setNome(nome);
            aniPequeno.setPeso(peso);
            aniPequeno.setRaca(raca);
            aniPequeno.setRghumv(rghumv);
            aniPequeno.setSexo(sexo);
            aniPequeno.setPelagem(pelagem);

            try {
                response = RESTMethods.post(servicoAnimalP, aniPequeno);
                String resposta = response.getEntity(String.class);
                if (!resposta.equalsIgnoreCase("ok")) {
                    JOptionPane.showMessageDialog(this, resposta, "Falha no cadastro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (RESTConnectionException ex) {
                Logger.getLogger(CadastroAnimals.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_confirmarJBActionPerformed

    private void cancelarJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarJBActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        System.gc();
    }//GEN-LAST:event_cancelarJBActionPerformed

    private void pesquisarDJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarDJBActionPerformed
        buscarDonoCPF();

    }//GEN-LAST:event_pesquisarDJBActionPerformed

    private void buscarDonoCPF() throws ClientHandlerException, HeadlessException, UniformInterfaceException {
        // TODO add your handling code here:

        //Dando erro aqui, a ser verificado, tudo indica que seja a forma c-
        //omo o parametro é passado que é tratado como ilegal pela classe feita por tassio.
        if (Util.isCPF(this.cpfBuscarJTF.getText())) {
            ClientResponse response;
            try {
                this.setCPFNull();
                response = RESTMethods.get(servicoDono + "/" + this.cpfBuscarJTF.getText() + "");
                Dono at = response.getEntity(Dono.class);
                this.cpf = at.getCpf();
                this.cpfDJL.setText("CPF: " + cpf);
                this.nomeDJL.setText("Nome: " + at.getNome());
            } catch (RESTConnectionException ex) {
                Logger.getLogger(CadastroAnimals.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            this.setCPFNull();
            JOptionPane.showMessageDialog(null, "Digite um CPF Valido.");
        }
    }

    private void cpfBuscarJTFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cpfBuscarJTFKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.pesquisarDJBActionPerformed(null);
        }
    }//GEN-LAST:event_cpfBuscarJTFKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField PelagemJTF;
    private javax.swing.JLabel TipodeAtendimentoJL;
    private javax.swing.JComboBox<String> anoJCB;
    private javax.swing.JLabel buscarDJL;
    private javax.swing.JLabel cadastrarDJL;
    private javax.swing.JButton cancelarJB;
    private javax.swing.JButton confirmarJB;
    private javax.swing.JTextField cpfBuscarJTF;
    private javax.swing.JLabel cpfDJL;
    private javax.swing.JComboBox<String> diaJCB;
    private javax.swing.JLabel especieJL;
    private javax.swing.JTextField especieJTF;
    private javax.swing.JRadioButton femeaJRB;
    private javax.swing.JRadioButton grandePorteJRB;
    private javax.swing.JComboBox<String> horaJCB;
    private javax.swing.JLabel idadeJL;
    private javax.swing.JTextField idadeJTF;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton machoJRB;
    private javax.swing.JComboBox<String> mesJCB;
    private javax.swing.JComboBox<String> minJCB;
    private javax.swing.JLabel nomeAJL;
    private javax.swing.JTextField nomeAJTF;
    private javax.swing.JLabel nomeDJL;
    private javax.swing.JLabel pelagemJL;
    private javax.swing.JRadioButton pequenoPorteJRB;
    private javax.swing.JLabel pesoJL;
    private javax.swing.JTextField pesoJTF;
    private javax.swing.JButton pesquisarDJB;
    private javax.swing.JLabel porteDoAnimalJL;
    private javax.swing.JLabel racaJL;
    private javax.swing.JTextField racaJTF;
    private javax.swing.JLabel rghumvJL;
    private javax.swing.JTextField rghumvJTF;
    private javax.swing.JLabel sexoJL;
    private javax.swing.JComboBox<String> tipodeAtendimentoJCB;
    private javax.swing.JLabel tituloJL;
    // End of variables declaration//GEN-END:variables

    private JFrame parent;
    private boolean grande = false;
    private String cpf;
    private String nome;
    final private String servicoDono = "/api/dono";
    final private String servicoAnimalP = "/api/animalPequeno";
    final private String servicoAnimalG = "/api/animalGrande";
    private static final Logger LOG = Logger.getLogger(CadastroAnimals.class.getName());
    private String opcao;
    static final public String OPCAO_CADASTRO="Cadastro";
    private AnimalGrande atualAnimal;
}
