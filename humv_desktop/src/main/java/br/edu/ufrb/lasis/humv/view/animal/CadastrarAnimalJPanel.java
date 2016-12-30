package br.edu.ufrb.lasis.humv.view.animal;

import br.edu.ufrb.lasis.humv.HUMVApp;
import br.edu.ufrb.lasis.humv.utils.MaskUtils;
import java.util.Date;
import javax.swing.JOptionPane;
import br.edu.ufrb.lasis.humv.entity.Animal;
import br.edu.ufrb.lasis.humv.entity.Dono;
import br.edu.ufrb.lasis.humv.rest.RESTConnectionException;
import br.edu.ufrb.lasis.humv.rest.RESTMethods;
import br.edu.ufrb.lasis.humv.utils.InterfaceGraficaUtils;
import br.edu.ufrb.lasis.humv.utils.ResultadoBusca;
import br.edu.ufrb.lasis.humv.view.busca.BuscaJPanel;
import br.edu.ufrb.lasis.humv.view.busca.PropriedadesBusca;
import br.edu.ufrb.lasis.humv.view.dono.CadastrarDonoJPanel;
import br.edu.ufrb.lasis.humv.view.dono.PropriedadesBuscaDono;
import com.sun.jersey.api.client.ClientResponse;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Andersoney
 */
public class CadastrarAnimalJPanel extends javax.swing.JPanel implements ResultadoBusca {

    private final static Logger logger = LoggerFactory.getLogger(CadastrarAnimalJPanel.class);
    private boolean grande = false;
    private Dono dono = null;
    private String porte;
    private final String servicoAnimal = "/api/animal";
    private Animal animalSelecionado;
    private static final String[] ESPECIES = {Animal.ESPECIE_CANINO, Animal.ESPECIE_FELINO, Animal.ESPECIE_CAPRINO, Animal.ESPECIE_OVINO, Animal.ESPECIE_BOVINO, Animal.ESPECIE_EQUINO, Animal.ESPECIE_SUINO, Animal.ESPECIE_OUTROS};

    public CadastrarAnimalJPanel() {
        initComponents();
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
            jLabelRghumv.setText("RGHUMV: "+animalSelecionado.getRghumv());
            jLabelTitulo.setText("ATUALIZAÇÃO DE ANIMAL");
            jTextFieldNomeAnimal.setText(animalSelecionado.getNome());
            jComboBoxEspecies.setSelectedIndex(findEspecieIndex(animalSelecionado.getEspecie()));
            jTextFieldIdade.setText("" + animalSelecionado.getIdade());
            jTextFieldRaca.setText(animalSelecionado.getRaca());
            if (animalSelecionado.getDono().getTipoDocumento().equalsIgnoreCase("CPF")) {
                this.dono = animalSelecionado.getDono();
                this.jLabelCpfDono.setText("CPF: " + MaskUtils.formatarStringCPF(animalSelecionado.getDono().getCpfCnpj()));
                this.jLabelNomeDono.setText("Nome: " + animalSelecionado.getDono().getNome());
            } else {
                this.dono = animalSelecionado.getDono();
                this.jLabelCpfDono.setText("CNPJ: " + MaskUtils.formatarStringCNPJ(animalSelecionado.getDono().getCpfCnpj()));
                this.jLabelNomeDono.setText("Nome: " + animalSelecionado.getDono().getNome());
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
            jRadioButtonMacho.setSelected(true);
            jRadioButtonPequenoPorte.setSelected(true);
        }
    }
    
    private int findEspecieIndex(String especie){
        for(int i=0; i < ESPECIES.length; i++){
            if(especie.equalsIgnoreCase(ESPECIES[i])){
                return i;
            }
        }
        return ESPECIES.length - 1;
    }

    public void setIdNull() {
        this.dono = null;
        this.jLabelNomeDono.setText("Nome: ");
        this.jLabelCpfDono.setText("CPF: ");
    }

    public void setDono(Dono dono) {
        this.dono = dono;
    }

    @Override
    public void setResultado(Object resultado) {
        this.dono = (Dono) resultado;
        this.jLabelCpfDono.setText("CPF: " + MaskUtils.formatarCPF_CNPJ(dono.getCpfCnpj(), dono.getTipoDocumento()));
        this.jLabelNomeDono.setText("Nome: " + dono.getNome());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelDadosDono = new javax.swing.JPanel();
        jButtonPesquisarDono = new javax.swing.JButton();
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
        jPanelDadosAnimal = new javax.swing.JPanel();
        jLabelNomeAnimal = new javax.swing.JLabel();
        jTextFieldNomeAnimal = new javax.swing.JTextField();
        jLabelEspecie = new javax.swing.JLabel();
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
        jLabelRghumv = new javax.swing.JLabel();
        jComboBoxEspecies = new javax.swing.JComboBox<>();
        jButtonCancelar = new javax.swing.JButton();
        jLabelTitulo = new javax.swing.JLabel();
        jButtonConfirmar = new javax.swing.JButton();

        jPanelDadosDono.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do dono"));

        jButtonPesquisarDono.setIcon(new javax.swing.ImageIcon("imagens/small_buscar.png"));
        jButtonPesquisarDono.setText("Buscar");
        jButtonPesquisarDono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarDonoActionPerformed(evt);
            }
        });

        jLabelNomeDono.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelNomeDono.setText("Nome:");

        jLabelCpfDono.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelCpfDono.setText("CPF:");

        jButtonCadastrarNovoDono.setIcon(new javax.swing.ImageIcon("imagens/small_cadastrar.png"));
        jButtonCadastrarNovoDono.setText("Novo");
        jButtonCadastrarNovoDono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarNovoDonoActionPerformed(evt);
            }
        });

        jLabelDia.setText("Dia:");

        jLabelHora.setText("Hora:");

        javax.swing.GroupLayout jPanelDadosDonoLayout = new javax.swing.GroupLayout(jPanelDadosDono);
        jPanelDadosDono.setLayout(jPanelDadosDonoLayout);
        jPanelDadosDonoLayout.setHorizontalGroup(
            jPanelDadosDonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosDonoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadosDonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabelDia, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelDadosDonoLayout.createSequentialGroup()
                        .addComponent(jDateChooserData, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelDadosDonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelDadosDonoLayout.createSequentialGroup()
                                .addComponent(jLabelHora)
                                .addGap(83, 83, 83))
                            .addComponent(jSpinnerHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabelNomeDono, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                    .addComponent(jLabelCpfDono, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelDadosDonoLayout.createSequentialGroup()
                .addComponent(jButtonPesquisarDono, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCadastrarNovoDono, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelDadosDonoLayout.setVerticalGroup(
            jPanelDadosDonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosDonoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadosDonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPesquisarDono)
                    .addComponent(jButtonCadastrarNovoDono))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelNomeDono)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelCpfDono)
                .addGap(18, 18, 18)
                .addGroup(jPanelDadosDonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDia)
                    .addComponent(jLabelHora))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDadosDonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooserData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinnerHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jComboBoxEspecies.setModel(new javax.swing.DefaultComboBoxModel(ESPECIES));

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
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
                        .addComponent(jRadioButtonPequenoPorte))
                    .addComponent(jLabelRghumv, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxEspecies, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );
        jPanelDadosAnimalLayout.setVerticalGroup(
            jPanelDadosAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosAnimalLayout.createSequentialGroup()
                .addGroup(jPanelDadosAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelDadosAnimalLayout.createSequentialGroup()
                        .addComponent(jLabelEspecie)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxEspecies, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1))
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
                .addGroup(jPanelDadosAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPelagem)
                    .addComponent(jLabelRghumv, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldPelagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonCancelar.setIcon(new javax.swing.ImageIcon("imagens/small_cancelar.png"));
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("CADASTRO DE ANIMAL");

        jButtonConfirmar.setIcon(new javax.swing.ImageIcon("imagens/small_salvar.png"));
        jButtonConfirmar.setText("Salvar");
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
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanelDadosAnimal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelDadosDono, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
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
                .addContainerGap(15, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed

        if (dono == null) {
            JOptionPane.showMessageDialog(this, "Você deve escolher ou cadastrar um dono para prosseguir com a operação.");
            return;
        }

        char sexo;
        int idade = -1;
        Date data;
        if (this.jTextFieldNomeAnimal.getText().isEmpty()) {
            InterfaceGraficaUtils.validaCampoVazio("nome do animal");
            return;
        }
        String nomeAnimal = this.jTextFieldNomeAnimal.getText();
        String especie = (String) this.jComboBoxEspecies.getSelectedItem();
        if (this.jTextFieldRaca.getText().isEmpty()) {
            InterfaceGraficaUtils.validaCampoVazio("raça");
            return;
        }
        String raca = this.jTextFieldRaca.getText();
        if (this.jTextFieldIdade.getText().isEmpty()) {
            InterfaceGraficaUtils.validaCampoVazio("idade");
            return;
        } else {
            try {
                idade = Integer.parseInt(this.jTextFieldIdade.getText());
            } catch (NumberFormatException ex) {
                InterfaceGraficaUtils.validaCampoInvalido("idade");
                return;
            }
        }
        if (this.jRadioButtonMacho.isSelected()) {
            sexo = 'M';
        } else {
            sexo = 'F';
        }

        String pelagem;
        if (this.jRadioButtonPequenoPorte.isSelected()) {
            if (this.jTextFieldPelagem.getText().isEmpty()) {
                InterfaceGraficaUtils.validaCampoVazio("pelagem");
                return;
            } else {
                pelagem = this.jTextFieldPelagem.getText();
            }
            porte = "Pequeno";
        } else {
            porte = "Grande";
            pelagem = "não se aplica.";
        }

        data = jDateChooserData.getDate();

        Animal animal = new Animal();
        animal.setDono(dono);
        animal.setDataCadastro(data);
        animal.setEspecie(especie);
        animal.setIdade(idade);
        animal.setNome(nomeAnimal);
        animal.setPeso(0);
        animal.setRaca(raca);
        animal.setSexo(sexo);
        animal.setPorte(porte);
        animal.setPelagem(pelagem);

        ClientResponse response;
        try {
            if (animalSelecionado == null) {
                response = RESTMethods.post(this.servicoAnimal, animal);
            } else if (InterfaceGraficaUtils.dialogoRemoverAlterar("alterar", "animal", animalSelecionado.getNome())) {
                animal.setRghumv(animalSelecionado.getRghumv());
                response = RESTMethods.put(this.servicoAnimal, animal);
            } else {
                return;
            }
            String resposta = response.getEntity(String.class);
            if (!resposta.equalsIgnoreCase("ok")) {
                if (animalSelecionado == null) {
                    InterfaceGraficaUtils.erroResposta(resposta);
                } else {
                    InterfaceGraficaUtils.erroResposta(resposta);
                }
            } else {
                if (animalSelecionado == null) {
                    InterfaceGraficaUtils.sucessoCadastro("animal");
                } else {
                    InterfaceGraficaUtils.sucessoAtualizacao("animal");
                }
                HUMVApp.setPainelCentralComLogo();
            }
        } catch (RESTConnectionException ex) {
            InterfaceGraficaUtils.erroConexao();
            logger.error("mensagem: " + ex.getMessage(), ex);
        }
    }//GEN-LAST:event_jButtonConfirmarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        boolean sair = InterfaceGraficaUtils.dialogoCancelar("o cadastro", "animal");
        if (sair) {
            this.setVisible(false);
            System.gc();
            HUMVApp.setPainelCentralComLogo();
        }
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonPesquisarDonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarDonoActionPerformed
        JFrame jFrame = new JFrame("Busca");
        PropriedadesBuscaDono propriedadesBusca = new PropriedadesBuscaDono(PropriedadesBusca.OPCAO_SELECIONAR, jFrame, this);
        BuscaJPanel buscaPanel = new BuscaJPanel("BUSCA DE DONO", propriedadesBusca);
        jFrame.setContentPane(buscaPanel);
        InterfaceGraficaUtils.exibirJanela(jFrame);
    }//GEN-LAST:event_jButtonPesquisarDonoActionPerformed

    private void jButtonCadastrarNovoDonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarNovoDonoActionPerformed
        JFrame jFrame = new JFrame("Cadastro de dono");
        CadastrarDonoJPanel cadastrarDonoJPanel = new CadastrarDonoJPanel(jFrame, this);
        jFrame.setContentPane(cadastrarDonoJPanel);
        InterfaceGraficaUtils.exibirJanela(jFrame);
    }//GEN-LAST:event_jButtonCadastrarNovoDonoActionPerformed

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCadastrarNovoDono;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JButton jButtonPesquisarDono;
    private javax.swing.JComboBox<String> jComboBoxEspecies;
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
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanelDadosAnimal;
    private javax.swing.JPanel jPanelDadosDono;
    private javax.swing.JRadioButton jRadioButtonFemea;
    private javax.swing.JRadioButton jRadioButtonGrandePorte;
    private javax.swing.JRadioButton jRadioButtonMacho;
    private javax.swing.JRadioButton jRadioButtonPequenoPorte;
    private javax.swing.JSpinner jSpinnerHoras;
    private javax.swing.JTextField jTextFieldIdade;
    private javax.swing.JTextField jTextFieldNomeAnimal;
    private javax.swing.JTextField jTextFieldPelagem;
    private javax.swing.JTextField jTextFieldRaca;
    // End of variables declaration//GEN-END:variables

}
