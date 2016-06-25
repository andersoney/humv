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

        menuItemSair = new JMenuItem("Encerrar");
        menuItemSair.addActionListener(this);
        menuUsuario.add(menuItemSair);

        getMenuBar().add(menuUsuario);

       

        menuDono = new JMenu("Dono");
        menuDono.setMnemonic('D');
        cadastroDono = new JMenuItem("Cadastro");
        cadastroDono.setMnemonic('C');
        cadastroDono.addActionListener(this);

        menuDono.add(cadastroDono);
        getMenuBar().add(menuDono);
       
        
        cadastroAnimal = new JMenuItem("Cadastro");
        cadastroAnimal.setMnemonic('C');
        cadastroAnimal.addActionListener(this);
        buscarAnimal = new JMenuItem("Busca");
        buscarAnimal.addActionListener(this);
        buscarAnimal.setMnemonic('B');
        alterarAnimal = new JMenuItem("Alteração");
        alterarAnimal.setMnemonic('A');
        alterarAnimal.addActionListener(this);
        removerAnimal = new JMenuItem("Remoção");
        removerAnimal.setMnemonic('R');
        removerAnimal.addActionListener(this);

        menuAnimal = new JMenu("Animal");
        menuAnimal.setMnemonic('A');
        menuAnimal.add(buscarAnimal);
        menuAnimal.add(cadastroAnimal);
        menuAnimal.add(alterarAnimal);
        menuAnimal.add(removerAnimal);
        getMenuBar().add(menuAnimal);
        
        menuSetor = new JMenu("Setor");
        menuItemCadastroSetor = new JMenuItem("Cadastro");
        menuItemCadastroSetor.addActionListener(this);
        menuItemBuscarSetor = new JMenuItem("Busca");
        menuItemBuscarSetor.addActionListener(this);
        menuItemAlterarSetor = new JMenuItem("Alteração");
        menuItemAlterarSetor.addActionListener(this);
        menuItemRemoverSetor = new JMenuItem("Remoção");
        menuItemRemoverSetor.addActionListener(this);
        menuSetor.add(menuItemBuscarSetor);
        menuSetor.add(menuItemCadastroSetor);
        menuSetor.add(menuItemAlterarSetor);
        menuSetor.add(menuItemRemoverSetor);
        getMenuBar().add(menuSetor);
        
        
        
        
        menuProcedimento = new JMenu("Procedimento");
        menuItemCadastrarProcedimento = new JMenuItem("Cadastro");
        menuItemCadastrarProcedimento.addActionListener(this);
        menuItemBuscarProcedimento = new JMenuItem("Busca");
        menuItemBuscarProcedimento.addActionListener(this);
        menuItemAlterarProcedimento = new JMenuItem("Alteração");
        menuItemAlterarProcedimento.addActionListener(this);
        menuItemRemoverProcedimento = new JMenuItem("Remoção");
        menuItemRemoverProcedimento.addActionListener(this);
        menuProcedimento.add(menuItemBuscarProcedimento);
        menuProcedimento.add(menuItemCadastrarProcedimento);
        menuProcedimento.add(menuItemAlterarProcedimento);
        menuProcedimento.add(menuItemRemoverProcedimento);
        getMenuBar().add(menuProcedimento);
        
        
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
            System.exit(0);
            //HUMVApp.getMainWindow().dispatchEvent(new WindowEvent(HUMVApp.getMainWindow(), WindowEvent.WINDOW_CLOSING));
        } else if (e.getSource().equals(cadastroAnimal)) {
            cadastroAnimais();
        } else if (e.getSource().equals(buscarAnimal)) {
            buscarAnimaisVisualização();
        } else if (e.getSource().equals(alterarAnimal)) {
            this.buscarAnimaisAlteracao();
        } else if (e.getSource().equals(removerAnimal)) {
            PropriedadeBuscarAnimais propBA = new PropriedadeBuscarAnimais(PropriedadesBusca.OPCAO_REMOVER);
            BuscaPanel bus = new BuscaPanel("BUSCA DE ANIMAL PARA REMOÇÃO", propBA);
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
         else if (e.getSource().equals(menuItemBuscarSetor)) {
            PropriedadesBuscaSetor propBA = new PropriedadesBuscaSetor(PropriedadesBusca.OPCAO_VISUALIZAR);
            BuscaPanel bus = new BuscaPanel("BUSCA DE SETOR PARA VISUALIZAÇÃO", propBA);
            LOG.info("Acessando Busca de Animal para remover.");
            HUMVApp.setNovoPainelCentral(bus);
        }
        else if(e.getSource().equals(menuItemAlterarSetor)){
            LOG.info("Alterar setor");
            PropriedadesBuscaSetor propBA = new PropriedadesBuscaSetor(PropriedadesBusca.OPCAO_ALTERAR);
            BuscaPanel bus = new BuscaPanel("BUSCA DE SETOR PARA ALTERAÇÃO", propBA);
            LOG.info("Acessando Busca de Setor para alterar.");
            HUMVApp.setNovoPainelCentral(bus);
        } else if (e.getSource().equals(menuItemRemoverSetor)) {
            PropriedadesBuscaSetor propBA = new PropriedadesBuscaSetor(PropriedadesBusca.OPCAO_REMOVER);
            BuscaPanel bus = new BuscaPanel("BUSCA DE SETOR PARA REMOÇÃO", propBA);
            LOG.info("Acessando Busca de Animal para remover.");
            HUMVApp.setNovoPainelCentral(bus);
        }else if(e.getSource().equals(menuItemCadastrarProcedimento)) {
            PropriedadeBuscaProcedimento propBA = new PropriedadeBuscaProcedimento(PropriedadesBusca.OPCAO_CADASTRAR);
            CadastroProcedimento procedimento=new CadastroProcedimento();
            HUMVApp.setNovoPainelCentral(procedimento);
            LOG.info("Acessando de cadastro para procedimento.");
        }
        else if (e.getSource().equals(menuItemBuscarProcedimento)) {
            PropriedadeBuscaProcedimento propBA = new PropriedadeBuscaProcedimento(PropriedadesBusca.OPCAO_VISUALIZAR);
            BuscaPanel bus = new BuscaPanel("BUSCA DE PROCEDIMENTO PARA VISUALIZAÇÃO", propBA);
            LOG.info("Acessando Busca de Animal para remover.");
            HUMVApp.setNovoPainelCentral(bus);
        }
        else if(e.getSource().equals(menuItemAlterarProcedimento)) {
            PropriedadeBuscaProcedimento propBA = new PropriedadeBuscaProcedimento(PropriedadesBusca.OPCAO_ALTERAR);
            BuscaPanel bus = new BuscaPanel("BUSCA DE PROCEDIMENTO PARA ALTERAÇÃO", propBA);
            LOG.info("Acessando Busca de procedimento para alterar.");
            HUMVApp.setNovoPainelCentral(bus);
        }
        else if (e.getSource().equals(menuItemRemoverProcedimento)) {
            PropriedadeBuscaProcedimento propBA = new PropriedadeBuscaProcedimento(PropriedadesBusca.OPCAO_REMOVER);
            BuscaPanel bus = new BuscaPanel("BUSCA DE PROCEDIMENTO PARA REMOÇÃO", propBA);
            LOG.info("Acessando Busca de Animal para remover.");
            HUMVApp.setNovoPainelCentral(bus);
        }        
    }

    private void cadastroAnimais() {
        HUMVApp.setNovoPainelCentral(new CadastroAnimal());
    }

    private void buscarAnimaisVisualização() {
        PropriedadeBuscarAnimais propBA = new PropriedadeBuscarAnimais(PropriedadesBusca.OPCAO_VISUALIZAR);
        BuscaPanel bus = new BuscaPanel("BUSCA DE ANIMAL PARA VISUALIZAÇÃO", propBA);
        LOG.info("Acessando Busca de Animal para visualizar.");
        HUMVApp.setNovoPainelCentral(bus);
    }

    private void buscarAnimaisAlteracao() {
        PropriedadeBuscarAnimais propBA = new PropriedadeBuscarAnimais(PropriedadesBusca.OPCAO_ALTERAR);
        BuscaPanel bus = new BuscaPanel("BUSCA DE ANIMAL PARA ALTERAÇÃO", propBA);
        LOG.info("Acessando Busca de Animal para alterar.");
        HUMVApp.setNovoPainelCentral(bus);
    }
    private static final Logger LOG = Logger.getLogger(FabricaMenuAdministrador.class.getName());
}
