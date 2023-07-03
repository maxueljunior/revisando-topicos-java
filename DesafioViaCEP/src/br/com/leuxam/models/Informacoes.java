package br.com.leuxam.models;

public class Informacoes {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private Integer ibge;
    private Integer gia;
    private Integer ddd;
    private Integer siafi;

    public Informacoes(){
    }

    public Informacoes(InformacoesViaCEP cep){
        this.cep = cep.cep();
        this.logradouro = cep.logradouro();
        this.complemento = cep.complemento();
        this.bairro = cep.bairro();
        this.localidade = cep.localidade();
        this.uf = cep.uf();
        this.ibge = Integer.parseInt(cep.ibge());
        this.ddd = Integer.parseInt(cep.ddd());
        this.siafi = Integer.parseInt(cep.siafi());
    }
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Integer getIbge() {
        return ibge;
    }

    public void setIbge(Integer ibge) {
        this.ibge = ibge;
    }

    public Integer getGia() {
        return gia;
    }

    public void setGia(Integer gia) {
        this.gia = gia;
    }

    public Integer getDdd() {
        return ddd;
    }

    public void setDdd(Integer ddd) {
        this.ddd = ddd;
    }

    public Integer getSiafi() {
        return siafi;
    }

    public void setSiafi(Integer siafi) {
        this.siafi = siafi;
    }

    @Override
    public String toString() {
        return "cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", localidade='" + localidade + '\'' +
                ", uf='" + uf + '\'' +
                ", ibge=" + ibge +
                ", gia=" + gia +
                ", ddd=" + ddd +
                ", siafi=" + siafi +
                '}';
    }
}
