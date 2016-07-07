package br.edu.ufrb.lasis.humv.entity;

import java.io.Serializable;

/**
 * Entidade que modela informações de setor.
 *
 *
 * Ver requisitos R007 - R010
 *
 * @author Luiz Antônio Pereira
 * @author Vinicius Moura
 * 
 * @version 3
 *
 * @since 26 de junho de 2016
 *
 */

public class Setor implements Serializable {
    
    private static final long serialVersionUID = 3567599639175582162L;

    private Integer codigo;
    private String nome;
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

}