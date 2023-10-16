package br.com.masters3.controllers;


import br.com.masters3.beans.Hospedagem;
import br.com.masters3.dao.HospedagemDAO;
import br.com.masters3.dao.DataSource;

public class HospedagemController {
    private HospedagemDAO hospedagemDAO;

    public HospedagemController(DataSource dataSource) {
        hospedagemDAO = new HospedagemDAO(dataSource);
    }

    public void cadastrarHospedagem(Hospedagem hospedagem) {
        hospedagemDAO.create(hospedagem);
    }

    public Hospedagem buscarHospedagem(String nome) {
        Hospedagem hospedagem = new Hospedagem();
        hospedagem.setNome(nome);
        return hospedagemDAO.read(hospedagem);
    }

    public void atualizarHospedagem(Hospedagem hospedagem) {
        hospedagemDAO.update(hospedagem);
    }

    public void deletarHospedagem(String nome) {
        Hospedagem hospedagem = new Hospedagem();
        hospedagem.setNome(nome);
        hospedagemDAO.delete(hospedagem);
    }
}
