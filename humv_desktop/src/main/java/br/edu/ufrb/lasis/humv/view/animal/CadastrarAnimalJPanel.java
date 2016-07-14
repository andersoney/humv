package br.edu.ufrb.lasis.humv.view.animal;

import br.edu.ufrb.lasis.humv.HUMVApp;
import br.edu.ufrb.lasis.humv.view.dono.CadastrarDonoJDialog;
import br.edu.ufrb.lasis.humv.utils.ValidationsUtils;
import br.edu.ufrb.lasis.humv.utils.MaskUtils;
import java.util.Date;
import javax.swing.JOptionPane;
import br.edu.ufrb.lasis.humv.entity.Animal;
import br.edu.ufrb.lasis.humv.entity.Dono;
import br.edu.ufrb.lasis.humv.rest.RESTConnectionException;
import br.edu.ufrb.lasis.humv.rest.RESTMethods;
import br.edu.ufrb.lasis.humv.utils.MessageUtils;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

/**
 *
 * @author Andersoney
 */
public class CadastrarAnimalJPanel extends javax.swing.JPanel {

    private boolean grande = false;
    private String idDono;
    private String nome;
    private String porte;
    private final String servicoDono = "/api/dono";
    private final String servicoAnimal = "/api/animal";
    private Animal animalSelecionado;

    public CadastrarAnimalJPanel() {
        initComponents();
        jRadioButtonBuscaCpfActionPerformed(null);
        jRadioButtonPequenoPorteActionPerformed(null);
        jRadioButtonMachoActionPerformed(null);
        customInitComponents();
    }

    public CadastrarAnimalJPanel(Animal animalSelecionado) {
        this.animalSelecionado = animalSelecionado;
        initComponents();
        customInitComponents();
    }

    public CadastrarAnimalJPanel(boolean Pequeno) {
        initComponents();
        this.jLabelTitulo.setText("CADASTRO DE ANIMAL");
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

    private void customInitComponents() {
        jTextFieldNomeAnimal.setFocusable(true);
        if (animalSelecionado != null) {
            jLabelTitulo.setText("ATUALIZAÇÃO DE ANIMAL");
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
                    MessageUtils.erroConexao();
                }
            } else if (ValidationsUtils.isCNPJ(animalSelecionado.getIdDono())) {
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
                    MessageUtils.erroConexao();
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
        } else {
            jRadioButtonBuscaCpf.setSelected(true);
            jRadioButtonMacho.setSelected(true);
            jRadioButtonPequenoPorte.setSelected(true);
        }
    }

    public void setIdNull() {
        this.idDono = null;
        this.nome = null;
        this.jLabelNomeDono.setText("Nome: ");
        this.jLabelCpfDono.setText("CPF: ");
    }

    public JLabel getjLabelCpfDono() {
        return jLabelCpfDono;
    }

    public JLabel getjLabelNomeDono() {
        return jLabelNomeDono;
    }

    public void setIdDono(String idDono) {
        this.idDono = idDono;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelDadosDono = new javax.swing.JPanel();
        jButtonPesquisarDono = new javax.swing.JButton();
        jTextFieldBuscaCpf = new javax.swing.JTextField();
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
        jLabelPorte = new javax.swing.JLabel();
        jRadioButtonGrandePorte = new javax.swing.JRadioButton();
        jRadioButtonPequenoPorte = new javax.swing.JRadioButton();
        jLabelPelagem = new javax.swing.JLabel();
        jTextFieldPelagem = new javax.swing.JTextField();
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

        jButtonCadastrarNovoDono.setText("Novo...");
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
                .addGroup(jPanelDadosDonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelDadosDonoLayout.createSequentialGroup()
                        .addGroup(jPanelDadosDonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelDadosDonoLayout.createSequentialGroup()
                                .addComponent(jLabelDia)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanelDadosDonoLayout.createSequentialGroup()
                                .addGroup(jPanelDadosDonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelDadosDonoLayout.createSequentialGroup()
                                        .addComponent(jRadioButtonBuscaCpf)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jRadioButtonBuscaCnpj))
                                    .addComponent(jTextFieldBuscaCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonPesquisarDono)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCadastrarNovoDono))
                    .addGroup(jPanelDadosDonoLayout.createSequentialGroup()
                        .addGroup(jPanelDadosDonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCpfDono, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNomeDono, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelDadosDonoLayout.createSequentialGroup()
                                .addComponent(jDateChooserData, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanelDadosDonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanelDadosDonoLayout.createSequentialGroup()
                                        .addComponent(jLabelHora)
                                        .addGap(83, 83, 83))
                                    .addComponent(jSpinnerHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                    .addComponent(jButtonCadastrarNovoDono))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelNomeDono)
                .addGap(18, 18, 18)
                .addComponent(jLabelCpfDono)
                .addGap(18, 18, 18)
                .addGroup(jPanelDadosDonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDia)
                    .addComponent(jLabelHora))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDadosDonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooserData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinnerHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
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

        javax.swing.GroupLayout jPanelDadosAnimalLayout = new javax.swing.GroupLayout(jPanelDadosAnimal);
        jPanelDadosAnimal.setLayout(jPanelDadosAnimalLayout);
        jPanelDadosAnimalLayout.setHorizontalGroup(
            jPanelDadosAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosAnimalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadosAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelNomeAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNomeAnimal, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(jTextFieldRaca)
                    .addComponent(jLabelIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelRaca, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPelagem)
                    .addComponent(jLabelPelagem, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldIdade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelDadosAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDadosAnimalLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jTextFieldEspecie)
                        .addGap(37, 37, 37))
                    .addGroup(jPanelDadosAnimalLayout.createSequentialGroup()
                        .addGroup(jPanelDadosAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelDadosAnimalLayout.createSequentialGroup()
                                .addComponent(jRadioButtonMacho)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButtonFemea))
                            .addComponent(jLabelSexo)
                            .addComponent(jLabelPorte)
                            .addGroup(jPanelDadosAnimalLayout.createSequentialGroup()
                                .addComponent(jRadioButtonGrandePorte)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButtonPequenoPorte)))
                        .addGap(0, 0, Short.MAX_VALUE))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelPelagem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldPelagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("CADASTRO DE ANIMAL");

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
                    .addComponent(jLabelTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonConfirmar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanelDadosAnimal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelDadosDono, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabelTitulo)
                .addGap(18, 18, 18)
                .addComponent(jPanelDadosDono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelDadosAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonConfirmar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed

        if (idDono == null) {
            JOptionPane.showMessageDialog(this, "Escolha ou cadastre um dono na lista.");
            return;
        }

        char sexo;
        float peso;
        int idade = -1;
        Date data;
        if (this.jTextFieldNomeAnimal.getText().isEmpty()) {
            MessageUtils.validaCampoVazio("nome do animal");
            return;
        }
        String nomeAnimal = this.jTextFieldNomeAnimal.getText();
        if (this.jTextFieldEspecie.getText().isEmpty()) {
            MessageUtils.validaCampoVazio("espécie");
            return;
        }
        String especie = this.jTextFieldEspecie.getText();
        if (this.jTextFieldRaca.getText().isEmpty()) {
            MessageUtils.validaCampoVazio("raça");
            return;
        }
        String raca = this.jTextFieldRaca.getText();
        if (this.jTextFieldIdade.getText().isEmpty()) {
            MessageUtils.validaCampoVazio("idade");
        } else {
            idade = Integer.parseInt(this.jTextFieldIdade.getText());
        }
        if (this.jRadioButtonMacho.isSelected()) {
            sexo = 'M';
        } else {
            sexo = 'F';
        }

        String pelagem;
        if (this.jRadioButtonPequenoPorte.isSelected()) {
            if (this.jTextFieldPelagem.getText().isEmpty()) {
                MessageUtils.validaCampoVazio("pelagem");
                return;
            } else {
                pelagem = this.jTextFieldPelagem.getText();
            }
            porte = "pequeno";
        } else {
            porte = "grande";
            pelagem = "não se aplica.";
        }

        data = jDateChooserData.getDate();

        ClientResponse response;
        Animal animal = new Animal();
        animal.setIdDono(idDono);
        animal.setDataCadastro(data);
        animal.setEspecie(especie);
        animal.setIdade(idade);
        animal.setNome(nomeAnimal);
        animal.setPeso(0);
        animal.setRaca(raca);
        animal.setSexo(sexo);
        animal.setPorte(porte);
        animal.setPelagem(pelagem);

        try {
            if (animalSelecionado == null) {
                response = RESTMethods.post(this.servicoAnimal, animal);
            } else if (MessageUtils.dialogoRemoverAlterar("alterar", "animal", animalSelecionado.getNome())) {
                response = RESTMethods.put(this.servicoAnimal, animal);
            } else {
                return;
            }
            String resposta = response.getEntity(String.class);
            if (!resposta.equalsIgnoreCase("ok")) {
                if (animalSelecionado == null) {
                    MessageUtils.erroResposta(resposta);
                } else {
                    MessageUtils.erroResposta(resposta);
                }
            } else {
                if (animalSelecionado == null) {
                    MessageUtils.sucessoCadastro("animal");
                } else {
                    MessageUtils.sucessoAtualizacao("animal");
                }
                HUMVApp.exibirMensagemCarregamento();
                HUMVApp.setPainelCentralComLogo();
                HUMVApp.esconderMensagemCarregamento();
            }
        } catch (RESTConnectionException ex) {
            MessageUtils.erroConexao();
        }
    }//GEN-LAST:event_jButtonConfirmarActionPerformed


    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        int op = MessageUtils.dialogoCancelar("o cadastro", "animal");
        if (op == JOptionPane.OK_OPTION) {
            this.setVisible(false);
            System.gc();
            HUMVApp.exibirMensagemCarregamento();
            HUMVApp.setPainelCentralComLogo();
            HUMVApp.esconderMensagemCarregamento();
        }
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonPesquisarDonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarDonoActionPerformed
        if (jRadioButtonBuscaCpf.isSelected()) {
            if (ValidationsUtils.isCPF(this.jTextFieldBuscaCpf.getText())) {
                ClientResponse response;
                try {
                    this.setIdNull();
                    response = RESTMethods.get(servicoDono + "/" + MaskUtils.removeMascara(this.jTextFieldBuscaCpf.getText()) + "");
                    Dono at = response.getEntity(Dono.class);
                    this.idDono = at.getId();
                    this.jLabelCpfDono.setText("CPF: " + idDono);
                    this.jLabelNomeDono.setText("Nome: " + at.getNome());
                } catch (RESTConnectionException ex) {
                    MessageUtils.erroConexao();
                } catch (ClientHandlerException ex) {
                    JOptionPane.showMessageDialog(null, "Dono não encontrado. Por favor, digite um CPF válido.", "Erro", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                this.setIdNull();
                MessageUtils.validaCampoInvalido("CPF");
            }
        } else if (ValidationsUtils.isCNPJ(this.jTextFieldBuscaCpf.getText())) {
            ClientResponse response;
            try {
                this.setIdNull();
                response = RESTMethods.get(servicoDono + "/" + MaskUtils.removeMascara(this.jTextFieldBuscaCpf.getText()) + "");
                Dono at = response.getEntity(Dono.class);
                this.idDono = at.getId();
                this.jLabelCpfDono.setText("CNPJ: " + idDono);
                this.jLabelNomeDono.setText("Nome: " + at.getNome());
            } catch (RESTConnectionException ex) {
                MessageUtils.erroConexao();
            } catch (ClientHandlerException ex) {
                JOptionPane.showMessageDialog(null, "Dono não encontrado. Por favor, digite um CNPJ válido.", "Erro", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            this.setIdNull();
            MessageUtils.validaCampoInvalido("CNPJ");
        }
    }//GEN-LAST:event_jButtonPesquisarDonoActionPerformed

    private void jTextFieldBuscaCpfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscaCpfKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.jButtonPesquisarDonoActionPerformed(null);
        }
    }//GEN-LAST:event_jTextFieldBuscaCpfKeyPressed

    private void jButtonCadastrarNovoDonoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCadastrarNovoDonoMouseClicked
        new CadastrarDonoJDialog(this).setVisible(true);
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
        this.jLabelCpfDono.setText("CPF: ");
    }//GEN-LAST:event_jRadioButtonBuscaCpfActionPerformed

    private void jRadioButtonBuscaCnpjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonBuscaCnpjActionPerformed
        this.jRadioButtonBuscaCpf.setSelected(false);
        this.jTextFieldBuscaCpf.setText("");
        this.jTextFieldBuscaCpf.setEnabled(false);
        this.jLabelCpfDono.setText("CNPJ: ");
    }//GEN-LAST:event_jRadioButtonBuscaCnpjActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCadastrarNovoDono;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JButton jButtonPesquisarDono;
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
    private javax.swing.JLabel jLabelSexo;
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
    private javax.swing.JTextField jTextFieldBuscaCpf;
    private javax.swing.JTextField jTextFieldEspecie;
    private javax.swing.JTextField jTextFieldIdade;
    private javax.swing.JTextField jTextFieldNomeAnimal;
    private javax.swing.JTextField jTextFieldPelagem;
    private javax.swing.JTextField jTextFieldRaca;
    // End of variables declaration//GEN-END:variables

}
