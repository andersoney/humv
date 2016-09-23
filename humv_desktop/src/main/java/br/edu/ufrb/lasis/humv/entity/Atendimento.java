package br.edu.ufrb.lasis.humv.entity;

import java.math.BigInteger;
import java.util.Date;

/**
 *
 * @author tassiovale
 */
public class Atendimento {

    public static final Integer COBRANCA_VALOR_NORMAL = 0;
    public static final Integer COBRANCA_VALOR_AULA = 1;
    public static final Integer COBRANCA_ISENTA = 2;
    public static final Integer COBRANCA_DESCONTO = 3;

    public static final Integer STATUS_AGENDADO = 0;
    public static final Integer STATUS_CANCELADO = 1;
    public static final Integer STATUS_REALIZADO = 2;

    private BigInteger id;
    
    private Animal animal;

    private Procedimento procedimento;

    private Usuario medico;

    private Date horarioMarcado;
    private Integer tipoCobranca;
    private Double valorCobrado;
    private Integer porcentagemDesconto;
    private String observacoes;
    private boolean retorno;
    private boolean extra;
    private Integer status;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Procedimento getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }

    public Usuario getMedico() {
        return medico;
    }

    public void setMedico(Usuario medico) {
        this.medico = medico;
    }

    public Date getHorarioMarcado() {
        return horarioMarcado;
    }

    public void setHorarioMarcado(Date horarioMarcado) {
        this.horarioMarcado = horarioMarcado;
    }

    public Integer getTipoCobranca() {
        return tipoCobranca;
    }

    public void setTipoCobranca(Integer tipoCobranca) {
        this.tipoCobranca = tipoCobranca;
    }

    public Double getValorCobrado() {
        return valorCobrado;
    }

    public void setValorCobrado(Double valorCobrado) {
        this.valorCobrado = valorCobrado;
    }

    public Integer getPorcentagemDesconto() {
        return porcentagemDesconto;
    }

    public void setPorcentagemDesconto(Integer porcentagemDesconto) {
        this.porcentagemDesconto = porcentagemDesconto;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public boolean isRetorno() {
        return retorno;
    }

    public void setRetorno(boolean retorno) {
        this.retorno = retorno;
    }

    public boolean isExtra() {
        return extra;
    }

    public void setExtra(boolean extra) {
        this.extra = extra;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
