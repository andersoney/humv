package br.edu.ufrb.lasis.humv.view.menufactory;

import br.edu.ufrb.lasis.humv.HUMVApp;
import br.edu.ufrb.lasis.humv.view.dono.CadastrarDonoJPanel;
import br.edu.ufrb.lasis.humv.view.animal.CadastrarAnimalJPanel;
import br.edu.ufrb.lasis.humv.view.animal.PropriedadesBuscaAnimal;
import br.edu.ufrb.lasis.humv.view.busca.BuscaPanel;
import br.edu.ufrb.lasis.humv.view.busca.PropriedadesBusca;
import br.edu.ufrb.lasis.humv.view.procedimento.CadastrarProcedimentoJPanel;
import br.edu.ufrb.lasis.humv.view.procedimento.PropriedadesBuscaProcedimento;
import br.edu.ufrb.lasis.humv.view.setor.CadastrarSetorJPanel;
import br.edu.ufrb.lasis.humv.view.setor.PropriedadesBuscaSetor;
import br.edu.ufrb.lasis.humv.view.usuario.CadastrarUsuarioJPanel;
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

    private JMenuItem menuItemCadastroAnimal,
            menuItemBuscaAnimal,
            menuItemAlteracaoAnimal,
            menuItemRemocaoAnimal;

    private JMenu menuDono;
    private JMenuItem menuItemCadastroDono;
    
    private JMenu menuProcedimento;
    private JMenuItem menuItemCadastroProcedimento,
            menuItemBuscaProcedimento,
            menuItemAlteracaoProcedimento,
            menuItemRemocaoProcedimento;
    
    private JMenu menuSetor;
    private JMenuItem menuItemCadastroSetor,
            menuItemBuscaSetor,
            menuItemAlteracaoSetor,
            menuItemRemocaoSetor;
    
    private static final Logger log = Logger.getLogger(FabricaMenuAdministrador.class.getName());

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
        menuItemCadastroDono = new JMenuItem("Cadastro");
        menuItemCadastroDono.setMnemonic('C');
        menuItemCadastroDono.addActionListener(this);

        menuDono.add(menuItemCadastroDono);
        getMenuBar().add(menuDono);
       
        
        menuItemCadastroAnimal = new JMenuItem("Cadastro");
        menuItemCadastroAnimal.setMnemonic('C');
        menuItemCadastroAnimal.addActionListener(this);
        menuItemBuscaAnimal = new JMenuItem("Busca");
        menuItemBuscaAnimal.addActionListener(this);
        menuItemBuscaAnimal.setMnemonic('B');
        menuItemAlteracaoAnimal = new JMenuItem("Alteração");
        menuItemAlteracaoAnimal.setMnemonic('A');
        menuItemAlteracaoAnimal.addActionListener(this);
        menuItemRemocaoAnimal = new JMenuItem("Remoção");
        menuItemRemocaoAnimal.setMnemonic('R');
        menuItemRemocaoAnimal.addActionListener(this);

        menuAnimal = new JMenu("Animal");
        menuAnimal.setMnemonic('A');
        menuAnimal.add(menuItemBuscaAnimal);
        menuAnimal.add(menuItemCadastroAnimal);
        menuAnimal.add(menuItemAlteracaoAnimal);
        menuAnimal.add(menuItemRemocaoAnimal);
        getMenuBar().add(menuAnimal);
        
        menuSetor = new JMenu("Setor");
        menuItemCadastroSetor = new JMenuItem("Cadastro");
        menuItemCadastroSetor.addActionListener(this);
        menuItemBuscaSetor = new JMenuItem("Busca");
        menuItemBuscaSetor.addActionListener(this);
        menuItemAlteracaoSetor = new JMenuItem("Alteração");
        menuItemAlteracaoSetor.addActionListener(this);
        menuItemRemocaoSetor = new JMenuItem("Remoção");
        menuItemRemocaoSetor.addActionListener(this);
        menuSetor.add(menuItemBuscaSetor);
        menuSetor.add(menuItemCadastroSetor);
        menuSetor.add(menuItemAlteracaoSetor);
        menuSetor.add(menuItemRemocaoSetor);
        getMenuBar().add(menuSetor);
        
        
        
        
        menuProcedimento = new JMenu("Procedimento");
        menuItemCadastroProcedimento = new JMenuItem("Cadastro");
        menuItemCadastroProcedimento.addActionListener(this);
        menuItemBuscaProcedimento = new JMenuItem("Busca");
        menuItemBuscaProcedimento.addActionListener(this);
        menuItemAlteracaoProcedimento = new JMenuItem("Alteração");
        menuItemAlteracaoProcedimento.addActionListener(this);
        menuItemRemocaoProcedimento = new JMenuItem("Remoção");
        menuItemRemocaoProcedimento.addActionListener(this);
        menuProcedimento.add(menuItemBuscaProcedimento);
        menuProcedimento.add(menuItemCadastroProcedimento);
        menuProcedimento.add(menuItemAlteracaoProcedimento);
        menuProcedimento.add(menuItemRemocaoProcedimento);
        getMenuBar().add(menuProcedimento);

        super.criaMenuAjuda();
        
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(menuItemCadastroUsuario)) {
            HUMVApp.setNovoPainelCentral(new CadastrarUsuarioJPanel());
        } else if (e.getSource().equals(menuItemBuscaUsuario)) {
            HUMVApp.setNovoPainelCentral(new BuscaPanel("Buscar usuário", new PropriedadesBuscaUsuario(PropriedadesBuscaUsuario.OPCAO_VISUALIZAR)));
        } else if (e.getSource().equals(menuItemAlteracaoUsuario)) {
            HUMVApp.setNovoPainelCentral(new BuscaPanel("Buscar usuário para alteração", new PropriedadesBuscaUsuario(PropriedadesBuscaUsuario.OPCAO_ALTERAR)));
        } else if (e.getSource().equals(menuItemRemocaoUsuario)) {
            HUMVApp.setNovoPainelCentral(new BuscaPanel("Buscar usuário para remoção", new PropriedadesBuscaUsuario(PropriedadesBuscaUsuario.OPCAO_REMOVER)));
        } else if (e.getSource().equals(menuItemSair)) {
            System.exit(0);
            //HUMVApp.getMainWindow().dispatchEvent(new WindowEvent(HUMVApp.getMainWindow(), WindowEvent.WINDOW_CLOSING));
        } else if (e.getSource().equals(menuItemCadastroAnimal)) {
            cadastroAnimais();
        } else if (e.getSource().equals(menuItemBuscaAnimal)) {
            buscarAnimaisVisualização();
        } else if (e.getSource().equals(menuItemAlteracaoAnimal)) {
            this.buscarAnimaisAlteracao();
        } else if (e.getSource().equals(menuItemRemocaoAnimal)) {
            PropriedadesBuscaAnimal propBA = new PropriedadesBuscaAnimal(PropriedadesBusca.OPCAO_REMOVER);
            BuscaPanel bus = new BuscaPanel("BUSCA DE ANIMAL PARA REMOÇÃO", propBA);
            log.info("Acessando Busca de Animal para remover.");
            HUMVApp.setNovoPainelCentral(bus);
        } else if (e.getSource().equals(menuItemCadastroDono)) {
            log.info("Cadastro Dono");
            CadastrarDonoJPanel dono=new CadastrarDonoJPanel();
            HUMVApp.setNovoPainelCentral(dono);
        }else if(e.getSource().equals(menuItemCadastroSetor)){
            log.info("Cadastro Setor");
            CadastrarSetorJPanel setor=new CadastrarSetorJPanel();
            HUMVApp.setNovoPainelCentral(setor);
        }
         else if (e.getSource().equals(menuItemBuscaSetor)) {
            PropriedadesBuscaSetor propBA = new PropriedadesBuscaSetor(PropriedadesBusca.OPCAO_VISUALIZAR);
            BuscaPanel bus = new BuscaPanel("BUSCA DE SETOR PARA VISUALIZAÇÃO", propBA);
            log.info("Acessando Busca de Animal para remover.");
            HUMVApp.setNovoPainelCentral(bus);
        }
        else if(e.getSource().equals(menuItemAlteracaoSetor)){
            log.info("Alterar setor");
            PropriedadesBuscaSetor propBA = new PropriedadesBuscaSetor(PropriedadesBusca.OPCAO_ALTERAR);
            BuscaPanel bus = new BuscaPanel("BUSCA DE SETOR PARA ALTERAÇÃO", propBA);
            log.info("Acessando Busca de Setor para alterar.");
            HUMVApp.setNovoPainelCentral(bus);
        } else if (e.getSource().equals(menuItemRemocaoSetor)) {
            PropriedadesBuscaSetor propBA = new PropriedadesBuscaSetor(PropriedadesBusca.OPCAO_REMOVER);
            BuscaPanel bus = new BuscaPanel("BUSCA DE SETOR PARA REMOÇÃO", propBA);
            log.info("Acessando Busca de Animal para remover.");
            HUMVApp.setNovoPainelCentral(bus);
        }else if(e.getSource().equals(menuItemCadastroProcedimento)) {
            PropriedadesBuscaProcedimento propBA = new PropriedadesBuscaProcedimento(PropriedadesBusca.OPCAO_CADASTRAR);
            CadastrarProcedimentoJPanel procedimento=new CadastrarProcedimentoJPanel();
            HUMVApp.setNovoPainelCentral(procedimento);
            log.info("Acessando de cadastro para procedimento.");
        }
        else if (e.getSource().equals(menuItemBuscaProcedimento)) {
            PropriedadesBuscaProcedimento propBA = new PropriedadesBuscaProcedimento(PropriedadesBusca.OPCAO_VISUALIZAR);
            BuscaPanel bus = new BuscaPanel("BUSCA DE PROCEDIMENTO PARA VISUALIZAÇÃO", propBA);
            log.info("Acessando Busca de Animal para remover.");
            HUMVApp.setNovoPainelCentral(bus);
        }
        else if(e.getSource().equals(menuItemAlteracaoProcedimento)) {
            PropriedadesBuscaProcedimento propBA = new PropriedadesBuscaProcedimento(PropriedadesBusca.OPCAO_ALTERAR);
            BuscaPanel bus = new BuscaPanel("BUSCA DE PROCEDIMENTO PARA ALTERAÇÃO", propBA);
            log.info("Acessando Busca de procedimento para alterar.");
            HUMVApp.setNovoPainelCentral(bus);
        }
        else if (e.getSource().equals(menuItemRemocaoProcedimento)) {
            PropriedadesBuscaProcedimento propBA = new PropriedadesBuscaProcedimento(PropriedadesBusca.OPCAO_REMOVER);
            BuscaPanel bus = new BuscaPanel("BUSCA DE PROCEDIMENTO PARA REMOÇÃO", propBA);
            log.info("Acessando Busca de Animal para remover.");
            HUMVApp.setNovoPainelCentral(bus);
        }        
    }

    private void cadastroAnimais() {
        HUMVApp.setNovoPainelCentral(new CadastrarAnimalJPanel());
    }

    private void buscarAnimaisVisualização() {
        PropriedadesBuscaAnimal propBA = new PropriedadesBuscaAnimal(PropriedadesBusca.OPCAO_VISUALIZAR);
        BuscaPanel bus = new BuscaPanel("BUSCA DE ANIMAL PARA VISUALIZAÇÃO", propBA);
        log.info("Acessando Busca de Animal para visualizar.");
        HUMVApp.setNovoPainelCentral(bus);
    }

    private void buscarAnimaisAlteracao() {
        PropriedadesBuscaAnimal propBA = new PropriedadesBuscaAnimal(PropriedadesBusca.OPCAO_ALTERAR);
        BuscaPanel bus = new BuscaPanel("BUSCA DE ANIMAL PARA ALTERAÇÃO", propBA);
        log.info("Acessando Busca de Animal para alterar.");
        HUMVApp.setNovoPainelCentral(bus);
    }

}
