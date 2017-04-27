import br.edu.ufrb.lasis.humv.entity.Material;
import java.math.BigInteger;
import java.util.Date;

public class SolicitacaoMaterial {

    private BigInteger id;
    private Material material;

    private BigInteger rghumvAnimal;
    private String nomeSetor;
    private String modelo = ""; // será preenchido somente se o material for
    // cirurgico;

    private Integer quantidadeSolicitada;
    private Integer quantidadeLiberada;
    private Date dataSolicitacao;
    private Date dataLiberacao;

    private String situacaoStatus; // solicitaçao vista, solicitação nao vista.

    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public Date getDataLiberacao() {
        return dataLiberacao;
    }

    public void setDataLiberacao(Date dataLiberacao) {
        this.dataLiberacao = dataLiberacao;
    }

    public void setQuantidadeSolicitada(Integer quantidadeSolicitada) {
        this.quantidadeSolicitada = quantidadeSolicitada;
    }

    public Integer getQuantidadeLiberada() {
        return quantidadeLiberada;
    }

    public void setQuantidadeLiberada(Integer quantidadeLiberada) {
        this.quantidadeLiberada = quantidadeLiberada;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getSituacaoStatus() {
        return situacaoStatus;
    }

    public void setSituacaoStatus(String situacaoStatus) {
        this.situacaoStatus = situacaoStatus;
    }

    /**
     * @return the material
     */
    public Material getMaterial() {
        return material;
    }

    /**
     * @param material the material to set
     */
    public void setMaterial(Material material) {
        this.material = material;
    }

    /**
     * @return the animal
     */
    public BigInteger getRghumvAnimal() {
        return rghumvAnimal;
    }

    /**
     * @param rghumvAnimal the animal to set
     */
    public void setRghumvAnimal(BigInteger rghumvAnimal) {
        this.rghumvAnimal = rghumvAnimal;
    }

    /**
     * @return the quantidade
     */
    public Integer getQuantidadeSolicitada() {
        return quantidadeSolicitada;
    }

    /**
     * @param quantidadeSolicitada the quantidade to set
     */
    public void setQuantidadeSolicitada(int quantidadeSolicitada) {
        this.quantidadeSolicitada = quantidadeSolicitada;
    }

    public String getNomeSetor() {
        return nomeSetor;
    }

    public void setNomeSetor(String nomeSetor) {
        this.nomeSetor = nomeSetor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

}