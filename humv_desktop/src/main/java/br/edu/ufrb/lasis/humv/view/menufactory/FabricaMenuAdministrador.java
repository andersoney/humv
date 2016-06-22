/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.view.menufactory;


import br.edu.ufrb.lasis.humv.HUMVApp;
import br.edu.ufrb.lasis.humv.view.dono.CadastrarDonoJPanel;
import br.edu.ufrb.lasis.humv.view.animal.CadastroAnimal;
import br.edu.ufrb.lasis.humv.view.animal.PropriedadeBuscarAnimais;
import br.edu.ufrb.lasis.humv.view.busca.BuscaPanel;
import br.edu.ufrb.lasis.humv.view.busca.PropriedadesBusca;
import br.edu.ufrb.lasis.humv.view.procedimento.CadastroProcedimento;
import br.edu.ufrb.lasis.humv.view.procedimento.PropriedadeBuscaProcedimento;
import br.edu.ufrb.lasis.humv.view.setor.CadastrarSetorJPanel;
import br.edu.ufrb.lasis.humv.view.setor.PropriedadesBuscaSetor;
import br.edu.ufrb.lasis.humv.view.usuario.CadastrarUsuarioPanel;
import br.edu.ufrb.lasis.humv.view.usuario.PropriedadesBuscaUsuario;
import java.awt.event.ActionEvent;
import java.util.logging.Logger;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author tassiovale
 */
public class FabricaMenuAdministrador extends MenuBarFabricaAbstrata {

    private JMenu menuUsuario;
    private JMenuItem menuItemCadastroUsuario, menuItemBuscaUsuario, menuItemAlteracaoUsuario, menuItemRemocaoUsuario, menuItemSair, menuItemSobre;

    private JMenu menuAnimal;
    private JMenuItem cadastroAnimal,
            buscarAnimal,
            alterarAnimal,
            removerAnimal;

    private JMenu menuDono;
    private JMenuItem cadastroDono;
    
    private JMenu menuProcedimento;
    private JMenuItem menuItemCadastrarProcedimento,
            menuItemBuscarProcedimento,
            menuItemAlterarProcedimento,
            menuItemRemoverProcedimento;
    
    private JMenu menuSetor;
    private JMenuItem menuItemCadastroSetor,
            menuItemBuscarSetor,
            menuItemAlterarSetor,
            menuItemRemoverSetor;

    public FabricaMenuAdministrador(JPanel mainPanel) {
        super(mainPanel);
    }

    @Override
    public void criaMenuBar() {
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

        menuItemSair = new JMenuItem("Sair");
        menuItemSair.addActionListener(this);
        menuUsuario.add(menuItemSair);

        getMenuBar().add(menuUsuario);

        cadastroAnimal = new JMenuItem("Cadastro");
        cadastroAnimal.setMnemonic('C');
        cadastroAnimal.addActionListener(this);
        buscarAnimal = new JMenuItem("Buscar");
        buscarAnimal.addActionListener(this);
        buscarAnimal.setMnemonic('B');
        alterarAnimal = new JMenuItem("Alterar");
        alterarAnimal.setMnemonic('A');
        alterarAnimal.addActionListener(this);
        removerAnimal = new JMenuItem("Remover");
        removerAnimal.setMnemonic('R');
        removerAnimal.addActionListener(this);

        menuAnimal = new JMenu("Animal");
        menuAnimal.setMnemonic('A');
        menuAnimal.add(cadastroAnimal);
        menuAnimal.add(buscarAnimal);
        menuAnimal.add(alterarAnimal);
        menuAnimal.add(removerAnimal);
        getMenuBar().add(menuAnimal);

        menuDono = new JMenu("Dono");
        menuDono.setMnemonic('D');
        cadastroDono = new JMenuItem("Cadastro");
        cadastroDono.setMnemonic('C');
        cadastroDono.addActionListener(this);

        menuDono.add(cadastroDono);
        getMenuBar().add(menuDono);
        
        menuProcedimento = new JMenu("Procedimento");
        menuItemCadastrarProcedimento = new JMenuItem("Cadastrar");
        menuItemCadastrarProcedimento.addActionListener(this);
        menuItemBuscarProcedimento = new JMenuItem("Buscar");
        menuItemBuscarProcedimento.addActionListener(this);
        menuItemAlterarProcedimento = new JMenuItem("Alterar");
        menuItemAlterarProcedimento.addActionListener(this);
        menuItemRemoverProcedimento = new JMenuItem("Remover");
        menuItemRemoverProcedimento.addActionListener(this);
        menuProcedimento.add(menuItemCadastrarProcedimento);
        menuProcedimento.add(menuItemBuscarProcedimento);
        menuProcedimento.add(menuItemAlterarProcedimento);
        menuProcedimento.add(menuItemRemoverProcedimento);
        getMenuBar().add(menuProcedimento);
        
        menuSetor = new JMenu("Setor");
        menuItemCadastroSetor = new JMenuItem("Cadastrar");
        menuItemCadastroSetor.addActionListener(this);
        menuItemBuscarSetor = new JMenuItem("Buscar");
        menuItemBuscarSetor.addActionListener(this);
        menuItemAlterarSetor = new JMenuItem("Alterar");
        menuItemAlterarSetor.addActionListener(this);
        menuItemRemoverSetor = new JMenuItem("Remover");
        menuItemRemoverSetor.addActionListener(this);
        menuSetor.add(menuItemCadastroSetor);
        menuSetor.add(menuItemBuscarSetor);
        menuSetor.add(menuItemAlterarSetor);
        menuSetor.add(menuItemRemoverSetor);
        getMenuBar().add(menuSetor);
        
        super.criaMenuAjuda();
        
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(menuItemCadastroUsuario)) {
            HUMVApp.setNovoPainelCentral(new CadastrarUsuarioPanel());
        } else if (e.getSource().equals(menuItemBuscaUsuario)) {
            HUMVApp.setNovoPainelCentral(new BuscaPanel("Buscar usuário", new PropriedadesBuscaUsuario(PropriedadesBuscaUsuario.OPCAO_VISUALIZAR)));
        } else if (e.getSource().equals(menuItemAlteracaoUsuario)) {
            HUMVApp.setNovoPainelCentral(new BuscaPanel("Buscar usuário para alteração", new PropriedadesBuscaUsuario(PropriedadesBuscaUsuario.OPCAO_ALTERAR)));
        } else if (e.getSource().equals(menuItemRemocaoUsuario)) {
            HUMVApp.setNovoPainelCentral(new BuscaPanel("Buscar usuário para remoção", new PropriedadesBuscaUsuario(PropriedadesBuscaUsuario.OPCAO_REMOVER)));
        } else if (e.getSource().equals(menuItemSair)) {
       
        } else if (e.getSource().equals(menuItemSobre)) {
            JOptionPane.showMessageDialog(null, "Desenvolvido por LaSiS - UFRB");
        } else if (e.getSource().equals(cadastroAnimal)) {
            cadastroAnimais();
        } else if (e.getSource().equals(buscarAnimal)) {
            buscarAnimaisVisualização();
        } else if (e.getSource().equals(alterarAnimal)) {
            this.buscarAnimaisAlteracao();
        } else if (e.getSource().equals(removerAnimal)) {
            PropriedadeBuscarAnimais propBA = new PropriedadeBuscarAnimais(PropriedadesBusca.OPCAO_REMOVER);
            BuscaPanel bus = new BuscaPanel("Busca de animal para remover.", propBA);
            LOG.info("Acessando Busca de Animal para remover.");
            HUMVApp.setNovoPainelCentral(bus);
        } else if (e.getSource().equals(cadastroDono)) {
            LOG.info("Cadastro Dono");
            CadastrarDonoJPanel dono=new CadastrarDonoJPanel();
            HUMVApp.setNovoPainelCentral(dono);
        }else if(e.getSource().equals(menuItemCadastroSetor)){
            LOG.info("Cadastro Setor");
            CadastrarSetorJPanel setor=new CadastrarSetorJPanel();
            HUMVApp.setNovoPainelCentral(setor);
        }
        else if(e.getSource().equals(menuItemAlterarSetor)){
            LOG.info("Alterar setor");
            PropriedadesBuscaSetor propBA = new PropriedadesBuscaSetor(PropriedadesBusca.OPCAO_ALTERAR);
            BuscaPanel bus = new BuscaPanel("Busca de setor para alterar.", propBA);
            LOG.info("Acessando Busca de Setor para alterar.");
            HUMVApp.setNovoPainelCentral(bus);
        } else if (e.getSource().equals(menuItemRemoverSetor)) {
            PropriedadesBuscaSetor propBA = new PropriedadesBuscaSetor(PropriedadesBusca.OPCAO_REMOVER);
            BuscaPanel bus = new BuscaPanel("Busca de animal para remover.", propBA);
            LOG.info("Acessando Busca de Animal para remover.");
            HUMVApp.setNovoPainelCentral(bus);
        }else if(e.getSource().equals(menuItemCadastrarProcedimento)) {
            PropriedadeBuscaProcedimento propBA = new PropriedadeBuscaProcedimento(PropriedadesBusca.OPCAO_CADASTRAR);
            CadastroProcedimento procedimento=new CadastroProcedimento();
            HUMVApp.setNovoPainelCentral(procedimento);
            LOG.info("Acessando de cadastro para procedimento.");
        }
        else if(e.getSource().equals(menuItemAlterarProcedimento)) {
            PropriedadeBuscaProcedimento propBA = new PropriedadeBuscaProcedimento(PropriedadesBusca.OPCAO_ALTERAR);
            BuscaPanel bus = new BuscaPanel("Busca do procedimento para alterar.", propBA);
            LOG.info("Acessando Busca de procedimento para alterar.");
            HUMVApp.setNovoPainelCentral(bus);
        }
        else if (e.getSource().equals(menuItemRemoverProcedimento)) {
            PropriedadeBuscaProcedimento propBA = new PropriedadeBuscaProcedimento(PropriedadesBusca.OPCAO_REMOVER);
            BuscaPanel bus = new BuscaPanel("Busca de animal para remover.", propBA);
            LOG.info("Acessando Busca de Animal para remover.");
            HUMVApp.setNovoPainelCentral(bus);
        }
    }

    private void cadastroAnimais() {
        HUMVApp.setNovoPainelCentral(new CadastroAnimal());
    }

    private void buscarAnimaisVisualização() {
        PropriedadeBuscarAnimais propBA = new PropriedadeBuscarAnimais(PropriedadesBusca.OPCAO_VISUALIZAR);
        BuscaPanel bus = new BuscaPanel("Busca de animal para visualização.", propBA);
        LOG.info("Acessando Busca de Animal para visualizar.");
        HUMVApp.setNovoPainelCentral(bus);
    }

    private void buscarAnimaisAlteracao() {
        PropriedadeBuscarAnimais propBA = new PropriedadeBuscarAnimais(PropriedadesBusca.OPCAO_ALTERAR);
        BuscaPanel bus = new BuscaPanel("Busca de animal para alteração.", propBA);
        LOG.info("Acessando Busca de Animal para alterar.");
        HUMVApp.setNovoPainelCentral(bus);
    }
    private static final Logger LOG = Logger.getLogger(FabricaMenuAdministrador.class.getName());
}
