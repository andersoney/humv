/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.entity;

/**
 *
 * @author Luiz
 */
public class Setor {
    private String nome;
    private int id;
    
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }
    public void setCodigo(int codigo){
        this.id = codigo;
    }
    public int getCodigo(){
        return id;
    }
}