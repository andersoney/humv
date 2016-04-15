package br.edu.ufrb.lasis.humv.entity;

public class PapelUsuario {

    private static final long serialVersionUID = -5175042223077958364L;
    private Integer usuarioPapelId;
    private Usuario usuario;
    private String papel;

    public PapelUsuario() {
    }

    public PapelUsuario(Usuario usuario, String papel) {
        this.usuario = usuario;
        this.papel = papel;
    }

    public Integer getUsuarioPapelId() {
        return this.usuarioPapelId;
    }

    public void setUsuarioPapelId(Integer usuarioPapelId) {
        this.usuarioPapelId = usuarioPapelId;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getPapel() {
        return this.papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }

}
