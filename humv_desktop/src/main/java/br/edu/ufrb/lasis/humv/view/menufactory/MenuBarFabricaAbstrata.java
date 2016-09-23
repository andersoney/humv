/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.view.menufactory;

import br.edu.ufrb.lasis.humv.HUMVApp;
import br.edu.ufrb.lasis.humv.view.agendamento.BuscarAgendaMedicoJPanel;
import br.edu.ufrb.lasis.humv.view.animal.CadastrarAnimalJPanel;
import br.edu.ufrb.lasis.humv.view.animal.PropriedadesBuscaAnimal;
import br.edu.ufrb.lasis.humv.view.busca.BuscaJPanel;
import br.edu.ufrb.lasis.humv.view.busca.PropriedadesBusca;
import br.edu.ufrb.lasis.humv.view.dono.CadastrarDonoJPanel;
import br.edu.ufrb.lasis.humv.view.dono.PropriedadesBuscaDono;
import br.edu.ufrb.lasis.humv.view.procedimento.CadastrarProcedimentoJPanel;
import br.edu.ufrb.lasis.humv.view.procedimento.PropriedadesBuscaProcedimento;
import br.edu.ufrb.lasis.humv.view.projeto.CadastrarProjetoJPanel;
import br.edu.ufrb.lasis.humv.view.projeto.PropriedadesBuscaProjeto;
import br.edu.ufrb.lasis.humv.view.setor.CadastrarSetorJPanel;
import br.edu.ufrb.lasis.humv.view.setor.PropriedadesBuscaSetor;
import br.edu.ufrb.lasis.humv.view.usuario.CadastrarUsuarioJPanel;
import br.edu.ufrb.lasis.humv.view.usuario.PropriedadesBuscaUsuario;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author tassiovale
 */
public abstract class MenuBarFabricaAbstrata implements ActionListener {

    private JMenuBar menuBar;

    private JMenu menuAjuda;
    private JMenuItem menuItemSair, menuItemSobre;

    private JMenu menuUsuario;
    private JMenuItem menuItemCadastroUsuario, 
            menuItemBuscaUsuario, 
            menuItemAlteracaoUsuario, 
            menuItemRemocaoUsuario;
    private JButton buttonCadastrarUsuario;

    private JMenu menuAnimal;
    private JMenuItem menuItemCadastroAnimal,
            menuItemBuscaAnimal,
            menuItemAlteracaoAnimal,
            menuItemRemocaoAnimal;
    private JButton buttonCadastrarAnimal;

    private JMenu menuDono;
    private JMenuItem menuItemCadastroDono,
            menuItemBuscaDono,
            menuItemAlteracaoDono,
            menuItemRemocaoDono;

    private JMenu menuProcedimento;
    private JMenuItem menuItemCadastroProcedimento,
            menuItemBuscaProcedimento,
            menuItemAlteracaoProcedimento,
            menuItemRemocaoProcedimento;
    private JButton buttonCadastrarProcedimento;

    private JMenu menuSetor;
    private JMenuItem menuItemCadastroSetor,
            menuItemBuscaSetor,
            menuItemAlteracaoSetor,
            menuItemRemocaoSetor;

    private JMenu menuProjeto;
    private JMenuItem menuItemCadastroProjeto,
            menuItemBuscaProjeto,
            menuItemAlteracaoProjeto,
            menuItemRemocaoProjeto;
    
    private JMenu menuAtendimento;
    private JMenuItem menuItemAgendarAtendimento;
    private JButton buttonAgendarAtendimento;

    private JPanel panelButtons;
    private GridBagConstraints panelConstraints;

    public MenuBarFabricaAbstrata(JPanel mainPanel, JPanel panelLeft) {
        panelButtons = new JPanel(new GridBagLayout());
        panelConstraints = new GridBagConstraints();
        panelConstraints.gridx = 0;
        panelConstraints.gridy = 0;
        panelConstraints.fill = GridBagConstraints.HORIZONTAL;
        
        panelLeft.setLayout(new BorderLayout());
        panelLeft.add(panelButtons, BorderLayout.NORTH);
        panelConstraints.insets.top = 15; panelConstraints.insets.bottom = 10;
        panelButtons.add(new JLabel(new ImageIcon("imagens/humv-logo-top.png")), panelConstraints);
        panelConstraints.insets.top = 0; panelConstraints.insets.bottom = 0;
        panelConstraints.ipady = 1;
        
        this.menuBar = new JMenuBar();
        mainPanel.add(menuBar, BorderLayout.PAGE_START);
    }

    public abstract void criaMenuBar();

    public void criaMenuAjuda() {
        menuAjuda = new JMenu("Ajuda");
        
        menuItemSobre = new JMenuItem("Sobre");
        menuAjuda.add(menuItemSobre);
        
        getMenuBar().add(menuAjuda);
    }

    public void criaMenuUsuario() {
        menuUsuario = new JMenu("Usuário");

        menuItemBuscaUsuario = new JMenuItem("Busca");
        menuItemBuscaUsuario.addActionListener(this);
        menuUsuario.add(menuItemBuscaUsuario);
        menuItemCadastroUsuario = new JMenuItem("Cadastro");
        menuItemCadastroUsuario.addActionListener(this);
        menuUsuario.add(menuItemCadastroUsuario);
        menuItemAlteracaoUsuario = new JMenuItem("Alteração");
        menuItemAlteracaoUsuario.addActionListener(this);
        menuUsuario.add(menuItemAlteracaoUsuario);
        menuItemRemocaoUsuario = new JMenuItem("Remoção");
        menuItemRemocaoUsuario.addActionListener(this);
        menuUsuario.add(menuItemRemocaoUsuario);
        menuUsuario.addSeparator();
        menuItemSair = new JMenuItem("Encerrar");
        menuItemSair.addActionListener(this);
        menuUsuario.add(menuItemSair);

        getMenuBar().add(menuUsuario);
    }

    public void criaMenuDono(boolean comRemover) {
        menuDono = new JMenu("Dono");
        menuDono.setMnemonic('D');

        menuItemCadastroDono = new JMenuItem("Cadastro");
        menuItemCadastroDono.setMnemonic('C');
        menuItemCadastroDono.addActionListener(this);
        menuDono.add(menuItemCadastroDono);
        menuItemBuscaDono = new JMenuItem("Busca");
        menuItemBuscaDono.addActionListener(this);
        menuDono.add(menuItemBuscaDono);
        menuItemAlteracaoDono = new JMenuItem("Alteração");
        menuItemAlteracaoDono.addActionListener(this);
        menuDono.add(menuItemAlteracaoDono);

        if (comRemover) {
            menuItemRemocaoDono = new JMenuItem("Remoção");
            menuItemRemocaoDono.addActionListener(this);
            menuDono.add(menuItemRemocaoDono);
        }

        getMenuBar().add(menuDono);
    }

    public void criaMenuAnimal(boolean comRemover) {
        menuAnimal = new JMenu("Animal");
        menuAnimal.setMnemonic('A');

        menuItemCadastroAnimal = new JMenuItem("Cadastro");
        menuItemCadastroAnimal.setMnemonic('C');
        menuItemCadastroAnimal.addActionListener(this);
        menuAnimal.add(menuItemCadastroAnimal);
        menuItemBuscaAnimal = new JMenuItem("Busca");
        menuItemBuscaAnimal.addActionListener(this);
        menuItemBuscaAnimal.setMnemonic('B');
        menuAnimal.add(menuItemBuscaAnimal);
        menuItemAlteracaoAnimal = new JMenuItem("Alteração");
        menuItemAlteracaoAnimal.setMnemonic('A');
        menuItemAlteracaoAnimal.addActionListener(this);
        menuAnimal.add(menuItemAlteracaoAnimal);

        if (comRemover) {
            menuItemRemocaoAnimal = new JMenuItem("Remoção");
            menuItemRemocaoAnimal.setMnemonic('R');
            menuItemRemocaoAnimal.addActionListener(this);
            menuAnimal.add(menuItemRemocaoAnimal);
        }

        getMenuBar().add(menuAnimal);
    }

    public void criaMenuSetor(boolean comRemover) {
        menuSetor = new JMenu("Setor");

        menuItemCadastroSetor = new JMenuItem("Cadastro");
        menuItemCadastroSetor.addActionListener(this);
        menuSetor.add(menuItemCadastroSetor);
        menuItemBuscaSetor = new JMenuItem("Busca");
        menuSetor.add(menuItemBuscaSetor);
        menuItemBuscaSetor.addActionListener(this);
        menuItemAlteracaoSetor = new JMenuItem("Alteração");
        menuItemAlteracaoSetor.addActionListener(this);
        menuSetor.add(menuItemAlteracaoSetor);

        if (comRemover) {
            menuItemRemocaoSetor = new JMenuItem("Remoção");
            menuItemRemocaoSetor.addActionListener(this);
            menuSetor.add(menuItemRemocaoSetor);
        }

        getMenuBar().add(menuSetor);
    }

    public void criaMenuProcedimento(boolean comRemover) {
        menuProcedimento = new JMenu("Procedimento");

        menuItemCadastroProcedimento = new JMenuItem("Cadastro");
        menuItemCadastroProcedimento.addActionListener(this);
        menuProcedimento.add(menuItemCadastroProcedimento);
        menuItemBuscaProcedimento = new JMenuItem("Busca");
        menuItemBuscaProcedimento.addActionListener(this);
        menuProcedimento.add(menuItemBuscaProcedimento);
        menuItemAlteracaoProcedimento = new JMenuItem("Alteração");
        menuItemAlteracaoProcedimento.addActionListener(this);
        menuProcedimento.add(menuItemAlteracaoProcedimento);

        if (comRemover) {
            menuItemRemocaoProcedimento = new JMenuItem("Remoção");
            menuItemRemocaoProcedimento.addActionListener(this);
            menuProcedimento.add(menuItemRemocaoProcedimento);
        }

        getMenuBar().add(menuProcedimento);
    }

    public void criaMenuProjeto(boolean comRemover) {
        menuProjeto = new JMenu("Projeto");

        menuItemCadastroProjeto = new JMenuItem("Cadastro");
        menuItemCadastroProjeto.addActionListener(this);
        menuProjeto.add(menuItemCadastroProjeto);
        menuItemBuscaProjeto = new JMenuItem("Busca");
        menuItemBuscaProjeto.addActionListener(this);
        menuProjeto.add(menuItemBuscaProjeto);
        menuItemAlteracaoProjeto = new JMenuItem("Alteração");
        menuItemAlteracaoProjeto.addActionListener(this);
        menuProjeto.add(menuItemAlteracaoProjeto);

        if (comRemover) {
            menuItemRemocaoProjeto = new JMenuItem("Remoção");
            menuItemRemocaoProjeto.addActionListener(this);
            menuProjeto.add(menuItemRemocaoProjeto);
        }

        getMenuBar().add(menuProjeto);
    }
    
    public void criaMenuAtendimento() {
        menuAtendimento = new JMenu("Atendimento");

        menuItemAgendarAtendimento = new JMenuItem("Agendar atendimento");
        menuItemAgendarAtendimento.addActionListener(this);
        menuAtendimento.add(menuItemAgendarAtendimento);

        getMenuBar().add(menuAtendimento);
    }
    
    public void criaBotaoCadastrarAnimal(){
        buttonCadastrarAnimal = new JButton("Cadastrar animal", new ImageIcon("imagens/icon_pet.png"));
        buttonCadastrarAnimal.addActionListener(this);
        this.addButtonToRightPanel(buttonCadastrarAnimal);
    }
    
    public void criaBotaoCadastrarUsuario(){
        buttonCadastrarUsuario = new JButton("Cadastrar usuário", new ImageIcon("imagens/icon_usuario.png"));
        buttonCadastrarUsuario.addActionListener(this);
        this.addButtonToRightPanel(buttonCadastrarUsuario);
    }
    
    public void criaBotaoCadastrarProcedimento(){
        buttonCadastrarProcedimento = new JButton("Cadastrar procedimento", new ImageIcon("imagens/icon_procedimento.png"));
        buttonCadastrarProcedimento.addActionListener(this);
        this.addButtonToRightPanel(buttonCadastrarProcedimento);
    }
    
    public void criaBotaoAgendarAtendimento(){
        buttonAgendarAtendimento = new JButton("Agendar atendimento", new ImageIcon("imagens/icon_agenda.png"));
        buttonAgendarAtendimento.addActionListener(this);
        this.addButtonToRightPanel(buttonAgendarAtendimento);
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }
    
    private void addButtonToRightPanel(JButton button){
        panelConstraints.gridy++;
        panelButtons.add(button, panelConstraints);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (source.equals(menuItemSobre)) {
            JOptionPane.showMessageDialog(null, "Desenvolvido por LaSiS - UFRB");
        } else if (source.equals(menuItemCadastroUsuario) || source.equals(buttonCadastrarUsuario)) {
            HUMVApp.setNovoPainelCentral(new CadastrarUsuarioJPanel());
        } else if (source.equals(menuItemBuscaUsuario) || source.equals(menuItemAlteracaoUsuario)) {
            HUMVApp.setNovoPainelCentral(new BuscaJPanel("BUSCAR USUÁRIO PARA VISUALIZAÇÃO/ALTERAÇÃO", new PropriedadesBuscaUsuario(PropriedadesBuscaUsuario.OPCAO_VISUALIZAR_ALTERAR)));
        } else if (source.equals(menuItemRemocaoUsuario)) {
            HUMVApp.setNovoPainelCentral(new BuscaJPanel("BUSCAR USUÁRIO PARA REMOÇÃO", new PropriedadesBuscaUsuario(PropriedadesBuscaUsuario.OPCAO_REMOVER)));
        } else if (source.equals(menuItemSair)) {
            System.exit(0);
        } else if (source.equals(menuItemCadastroAnimal) || source.equals(buttonCadastrarAnimal)) {
            HUMVApp.setNovoPainelCentral(new CadastrarAnimalJPanel());
        } else if (source.equals(menuItemBuscaAnimal) || source.equals(menuItemAlteracaoAnimal)) {
            PropriedadesBuscaAnimal propriedadesBusca = new PropriedadesBuscaAnimal(PropriedadesBusca.OPCAO_VISUALIZAR_ALTERAR);
            BuscaJPanel buscaPanel = new BuscaJPanel("BUSCA DE ANIMAL PARA VISUALIZAÇÃO/ALTERAÇÃO", propriedadesBusca);
            HUMVApp.setNovoPainelCentral(buscaPanel);
        } else if (source.equals(menuItemRemocaoAnimal)) {
            PropriedadesBuscaAnimal propriedadesBusca = new PropriedadesBuscaAnimal(PropriedadesBusca.OPCAO_REMOVER);
            BuscaJPanel buscaPanel = new BuscaJPanel("BUSCA DE ANIMAL PARA REMOÇÃO", propriedadesBusca);
            HUMVApp.setNovoPainelCentral(buscaPanel);
        } else if (source.equals(menuItemCadastroDono)) {
            CadastrarDonoJPanel dono = new CadastrarDonoJPanel();
            HUMVApp.setNovoPainelCentral(dono);
        } else if (source.equals(menuItemBuscaDono) || source.equals(menuItemAlteracaoDono)) {
            PropriedadesBuscaDono propriedadesBusca = new PropriedadesBuscaDono(PropriedadesBusca.OPCAO_VISUALIZAR_ALTERAR);
            BuscaJPanel buscaPanel = new BuscaJPanel("BUSCA DE DONO PARA VISUALIZAÇÃO/ALTERAÇÃO", propriedadesBusca);
            HUMVApp.setNovoPainelCentral(buscaPanel);
        } else if (source.equals(menuItemRemocaoDono)) {
            PropriedadesBuscaDono propriedadesBusca = new PropriedadesBuscaDono(PropriedadesBusca.OPCAO_REMOVER);
            BuscaJPanel buscaPanel = new BuscaJPanel("BUSCA DE DONO PARA REMOÇÃO", propriedadesBusca);
            HUMVApp.setNovoPainelCentral(buscaPanel);
        } else if (source.equals(menuItemCadastroSetor)) {
            CadastrarSetorJPanel setor = new CadastrarSetorJPanel();
            HUMVApp.setNovoPainelCentral(setor);
        } else if (source.equals(menuItemBuscaSetor) || source.equals(menuItemAlteracaoSetor)) {
            PropriedadesBuscaSetor propriedadesBusca = new PropriedadesBuscaSetor(PropriedadesBusca.OPCAO_VISUALIZAR_ALTERAR);
            BuscaJPanel buscaPanel = new BuscaJPanel("BUSCA DE SETOR PARA VISUALIZAÇÃO/ALTERAÇÃO", propriedadesBusca);
            HUMVApp.setNovoPainelCentral(buscaPanel);
        } else if (source.equals(menuItemRemocaoSetor)) {
            PropriedadesBuscaSetor propriedadesBusca = new PropriedadesBuscaSetor(PropriedadesBusca.OPCAO_REMOVER);
            BuscaJPanel buscaPanel = new BuscaJPanel("BUSCA DE SETOR PARA REMOÇÃO", propriedadesBusca);
            HUMVApp.setNovoPainelCentral(buscaPanel);
        } else if (source.equals(menuItemCadastroProcedimento) || source.equals(buttonCadastrarProcedimento)) {
            CadastrarProcedimentoJPanel procedimento = new CadastrarProcedimentoJPanel();
            HUMVApp.setNovoPainelCentral(procedimento);
        } else if (source.equals(menuItemBuscaProcedimento) || source.equals(menuItemAlteracaoProcedimento)) {
            PropriedadesBuscaProcedimento propriedadesBusca = new PropriedadesBuscaProcedimento(PropriedadesBusca.OPCAO_VISUALIZAR_ALTERAR);
            BuscaJPanel buscaPanel = new BuscaJPanel("BUSCA DE PROCEDIMENTO PARA VISUALIZAÇÃO/ALTERAÇÃO", propriedadesBusca);
            HUMVApp.setNovoPainelCentral(buscaPanel);
        } else if (source.equals(menuItemRemocaoProcedimento)) {
            PropriedadesBuscaProcedimento propriedadesBusca = new PropriedadesBuscaProcedimento(PropriedadesBusca.OPCAO_REMOVER);
            BuscaJPanel buscaPanel = new BuscaJPanel("BUSCA DE PROCEDIMENTO PARA REMOÇÃO", propriedadesBusca);
            HUMVApp.setNovoPainelCentral(buscaPanel);
        } else if (source.equals(menuItemCadastroProjeto)) {
            CadastrarProjetoJPanel projeto = new CadastrarProjetoJPanel();
            HUMVApp.setNovoPainelCentral(projeto);
        } else if (source.equals(menuItemBuscaProjeto) || source.equals(menuItemAlteracaoProjeto)) {
            PropriedadesBuscaProjeto propriedadesBusca = new PropriedadesBuscaProjeto(PropriedadesBusca.OPCAO_VISUALIZAR_ALTERAR);
            BuscaJPanel buscaPanel = new BuscaJPanel("BUSCA DE PROCEDIMENTO PARA VISUALIZAÇÃO/ALTERAÇÃO", propriedadesBusca);
            HUMVApp.setNovoPainelCentral(buscaPanel);
        } else if (source.equals(menuItemRemocaoProjeto)) {
            PropriedadesBuscaProjeto propriedadesBusca = new PropriedadesBuscaProjeto(PropriedadesBusca.OPCAO_REMOVER);
            BuscaJPanel buscaPanel = new BuscaJPanel("BUSCA DE PROCEDIMENTO PARA REMOÇÃO", propriedadesBusca);
            HUMVApp.setNovoPainelCentral(buscaPanel);
        } else if (source.equals(menuItemAgendarAtendimento) || source.equals(buttonAgendarAtendimento)) {
            HUMVApp.setNovoPainelCentral(new BuscarAgendaMedicoJPanel());
        }
        
    }
}
