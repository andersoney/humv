package br.edu.ufrb.lasis.humv.utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HUMVRegisterUser extends JFrame implements ActionListener{
    
    private JTextField nomeField, emailField, siapeField, passwordField;
    private JComboBox<String> comboPapeis;
    private final String[] papeis = {"ADMIN", "RECEPCAO", "FARMACIA", "ALMOXARIFADO", "MEDICO"};

    public HUMVRegisterUser(){
        initialize();
    }
    
    public void initialize(){
        setTitle("Cadastro de usuário");
        setSize(500, 500);
        
        JPanel mainPanel = new JPanel();
        
        setContentPane(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
    public static void main(String[] args) {
        
    }
    
}
