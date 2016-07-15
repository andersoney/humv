package br.edu.ufrb.lasis.humv.view.menufactory;

import br.edu.ufrb.lasis.humv.HUMVApp;
import br.edu.ufrb.lasis.humv.view.dono.CadastrarDonoJPanel;
import br.edu.ufrb.lasis.humv.view.animal.CadastrarAnimalJPanel;
import br.edu.ufrb.lasis.humv.view.animal.PropriedadesBuscaAnimal;
import br.edu.ufrb.lasis.humv.view.busca.BuscaPanel;
import br.edu.ufrb.lasis.humv.view.busca.PropriedadesBusca;
import br.edu.ufrb.lasis.humv.view.dono.PropriedadesBuscaDono;
import br.edu.ufrb.lasis.humv.view.procedimento.CadastrarProcedimentoJPanel;
import br.edu.ufrb.lasis.humv.view.procedimento.PropriedadesBuscaProcedimento;
import br.edu.ufrb.lasis.humv.view.projeto.CadastrarProjetoJPanel;
import br.edu.ufrb.lasis.humv.view.projeto.PropriedadesBuscaProjeto;
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
    private JMenuItem menuItemCadastroDono,
            menuItemBuscaDono,
            menuItemAlteracaoDono,
            menuItemRemocaoDono;

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

    private JMenu menuProjeto;
    private JMenuItem menuItemCadastroProjeto,
            menuItemBuscaProjeto,
            menuItemAlteracaoProjeto,
            menuItemRemocaoProjeto;

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
        menuItemBuscaDono = new JMenuItem("Busca");
        menuItemBuscaDono.addActionListener(this);
        menuDono.add(menuItemBuscaDono);
        menuItemAlteracaoDono = new JMenuItem("Alteração");
        menuItemAlteracaoDono.addActionListener(this);
        menuDono.add(menuItemAlteracaoDono);
        menuItemRemocaoDono = new JMenuItem("Remoção");
        menuItemRemocaoDono.addActionListener(this);
        menuDono.add(menuItemRemocaoDono);

        getMenuBar().add(menuDono);

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
        menuItemRemocaoAnimal = new JMenuItem("Remoção");
        menuItemRemocaoAnimal.setMnemonic('R');
        menuItemRemocaoAnimal.addActionListener(this);
        menuAnimal.add(menuItemRemocaoAnimal);

        getMenuBar().add(menuAnimal);

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
        menuItemRemocaoSetor = new JMenuItem("Remoção");
        menuItemRemocaoSetor.addActionListener(this);
        menuSetor.add(menuItemRemocaoSetor);

        getMenuBar().add(menuSetor);

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
        menuItemRemocaoProcedimento = new JMenuItem("Remoção");
        menuItemRemocaoProcedimento.addActionListener(this);
        menuProcedimento.add(menuItemRemocaoProcedimento);

        getMenuBar().add(menuProcedimento);

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
        menuItemRemocaoProjeto = new JMenuItem("Remoção");
        menuItemRemocaoProjeto.addActionListener(this);
        menuProjeto.add(menuItemRemocaoProjeto);

        getMenuBar().add(menuProjeto);

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
        } else if (e.getSource().equals(menuItemCadastroAnimal)) {
            HUMVApp.setNovoPainelCentral(new CadastrarAnimalJPanel());
        } else if (e.getSource().equals(menuItemBuscaAnimal)) {
            PropriedadesBuscaAnimal propBA = new PropriedadesBuscaAnimal(PropriedadesBusca.OPCAO_VISUALIZAR);
            BuscaPanel bus = new BuscaPanel("BUSCA DE ANIMAL PARA VISUALIZAÇÃO", propBA);
            HUMVApp.setNovoPainelCentral(bus);
        } else if (e.getSource().equals(menuItemAlteracaoAnimal)) {
            PropriedadesBuscaAnimal propBA = new PropriedadesBuscaAnimal(PropriedadesBusca.OPCAO_ALTERAR);
            BuscaPanel bus = new BuscaPanel("BUSCA DE ANIMAL PARA ALTERAÇÃO", propBA);
            HUMVApp.setNovoPainelCentral(bus);
        } else if (e.getSource().equals(menuItemRemocaoAnimal)) {
            PropriedadesBuscaAnimal propBA = new PropriedadesBuscaAnimal(PropriedadesBusca.OPCAO_REMOVER);
            BuscaPanel bus = new BuscaPanel("BUSCA DE ANIMAL PARA REMOÇÃO", propBA);
            HUMVApp.setNovoPainelCentral(bus);
        } else if (e.getSource().equals(menuItemCadastroDono)) {
            CadastrarDonoJPanel dono = new CadastrarDonoJPanel();
            HUMVApp.setNovoPainelCentral(dono);
        } else if (e.getSource().equals(menuItemBuscaDono)) {
            PropriedadesBuscaDono propBA = new PropriedadesBuscaDono(PropriedadesBusca.OPCAO_VISUALIZAR);
            BuscaPanel bus = new BuscaPanel("BUSCA DE DONO PARA VISUALIZAÇÃO", propBA);
            HUMVApp.setNovoPainelCentral(bus);
        } else if (e.getSource().equals(menuItemAlteracaoDono)) {
            PropriedadesBuscaDono propBA = new PropriedadesBuscaDono(PropriedadesBusca.OPCAO_ALTERAR);
            BuscaPanel bus = new BuscaPanel("BUSCA DE DONO PARA ALTERAÇÃO", propBA);
            HUMVApp.setNovoPainelCentral(bus);
        } else if (e.getSource().equals(menuItemRemocaoDono)) {
            PropriedadesBuscaDono propBA = new PropriedadesBuscaDono(PropriedadesBusca.OPCAO_REMOVER);
            BuscaPanel bus = new BuscaPanel("BUSCA DE DONO PARA REMOÇÃO", propBA);
            HUMVApp.setNovoPainelCentral(bus);
        } else if (e.getSource().equals(menuItemCadastroSetor)) {
            CadastrarSetorJPanel setor = new CadastrarSetorJPanel();
            HUMVApp.setNovoPainelCentral(setor);
        } else if (e.getSource().equals(menuItemBuscaSetor)) {
            PropriedadesBuscaSetor propBA = new PropriedadesBuscaSetor(PropriedadesBusca.OPCAO_VISUALIZAR);
            BuscaPanel bus = new BuscaPanel("BUSCA DE SETOR PARA VISUALIZAÇÃO", propBA);
            HUMVApp.setNovoPainelCentral(bus);
        } else if (e.getSource().equals(menuItemAlteracaoSetor)) {
            PropriedadesBuscaSetor propBA = new PropriedadesBuscaSetor(PropriedadesBusca.OPCAO_ALTERAR);
            BuscaPanel bus = new BuscaPanel("BUSCA DE SETOR PARA ALTERAÇÃO", propBA);
            HUMVApp.setNovoPainelCentral(bus);
        } else if (e.getSource().equals(menuItemRemocaoSetor)) {
            PropriedadesBuscaSetor propBA = new PropriedadesBuscaSetor(PropriedadesBusca.OPCAO_REMOVER);
            BuscaPanel bus = new BuscaPanel("BUSCA DE SETOR PARA REMOÇÃO", propBA);
            HUMVApp.setNovoPainelCentral(bus);
        } else if (e.getSource().equals(menuItemCadastroProcedimento)) {
            CadastrarProcedimentoJPanel procedimento = new CadastrarProcedimentoJPanel();
            HUMVApp.setNovoPainelCentral(procedimento);
        } else if (e.getSource().equals(menuItemBuscaProcedimento)) {
            PropriedadesBuscaProcedimento propBA = new PropriedadesBuscaProcedimento(PropriedadesBusca.OPCAO_VISUALIZAR);
            BuscaPanel bus = new BuscaPanel("BUSCA DE PROCEDIMENTO PARA VISUALIZAÇÃO", propBA);
            HUMVApp.setNovoPainelCentral(bus);
        } else if (e.getSource().equals(menuItemAlteracaoProcedimento)) {
            PropriedadesBuscaProcedimento propBA = new PropriedadesBuscaProcedimento(PropriedadesBusca.OPCAO_ALTERAR);
            BuscaPanel bus = new BuscaPanel("BUSCA DE PROCEDIMENTO PARA ALTERAÇÃO", propBA);
            HUMVApp.setNovoPainelCentral(bus);
        } else if (e.getSource().equals(menuItemRemocaoProcedimento)) {
            PropriedadesBuscaProcedimento propBA = new PropriedadesBuscaProcedimento(PropriedadesBusca.OPCAO_REMOVER);
            BuscaPanel bus = new BuscaPanel("BUSCA DE PROCEDIMENTO PARA REMOÇÃO", propBA);
            HUMVApp.setNovoPainelCentral(bus);
        } else if (e.getSource().equals(menuItemCadastroProjeto)) {
            CadastrarProjetoJPanel projeto = new CadastrarProjetoJPanel();
            HUMVApp.setNovoPainelCentral(projeto);
        } else if (e.getSource().equals(menuItemBuscaProjeto)) {
            PropriedadesBuscaProjeto propBA = new PropriedadesBuscaProjeto(PropriedadesBusca.OPCAO_VISUALIZAR);
            BuscaPanel bus = new BuscaPanel("BUSCA DE PROJETO PARA VISUALIZAÇÃO", propBA);
            HUMVApp.setNovoPainelCentral(bus);
        } else if (e.getSource().equals(menuItemAlteracaoProjeto)) {
            PropriedadesBuscaProjeto propBA = new PropriedadesBuscaProjeto(PropriedadesBusca.OPCAO_ALTERAR);
            BuscaPanel bus = new BuscaPanel("BUSCA DE PROCEDIMENTO PARA ALTERAÇÃO", propBA);
            HUMVApp.setNovoPainelCentral(bus);
        } else if (e.getSource().equals(menuItemRemocaoProjeto)) {
            PropriedadesBuscaProjeto propBA = new PropriedadesBuscaProjeto(PropriedadesBusca.OPCAO_REMOVER);
            BuscaPanel bus = new BuscaPanel("BUSCA DE PROCEDIMENTO PARA REMOÇÃO", propBA);
            HUMVApp.setNovoPainelCentral(bus);
        }
    }

}
