package br.com.masters3.beans;

public class Cidade {
    private int id; 
    private String cidade;
    private String estado;
    private String siglaEstado;
    private String pais;
    private String siglaPais;

    public Cidade() {
       
    }

    public Cidade(String cidade, String estado, String siglaEstado, String pais, String siglaPais) {
        this.cidade = cidade;
        this.estado = estado;
        this.siglaEstado = siglaEstado;
        this.pais = pais;
        this.siglaPais = siglaPais;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSiglaEstado() {
        return siglaEstado;
    }

    public void setSiglaEstado(String siglaEstado) {
        this.siglaEstado = siglaEstado;
    }

    public String getPais() {
        return pais;
    }

    public void setSiglaPais(String siglaPais) {
        this.siglaPais = siglaPais;
    }

}
