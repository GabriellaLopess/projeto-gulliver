package br.com.masters3.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.masters3.beans.Hospedagem;

public class HospedagemDAO implements DAO<Hospedagem> {
    private DataSource dataSource;

    public HospedagemDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public DataSource getDataSource() {
        return this.dataSource;
    }

    @Override
    public void create(Hospedagem object) {
        try {
            String SQL = "INSERT INTO sua_tabela (nome, local, tipo, descricao, preco) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);

            stm.setString(1, object.getNome());
            stm.setString(2, object.getLocal());
            stm.setString(3, object.getTipo());
            stm.setString(4, object.getDescricao());
            stm.setDouble(5, object.getPreco());

            int res = stm.executeUpdate();

            if (res != 0) {
                System.out.println("Hospedagem inserida com sucesso");
            } else {
                throw new RuntimeException("Erro ao inserir hospedagem");
            }
        } catch (Exception ex) {
            System.out.println("HospedagemDAO.CREATE = " + ex.getMessage());
        }
    }

    @Override
    public Hospedagem read(Hospedagem object) {
        try {
            String SQL = "SELECT * FROM sua_tabela WHERE nome = ?";
            PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);
            stm.setString(1, object.getNome());
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                Hospedagem hospedagem = new Hospedagem();
                hospedagem.setNome(rs.getString("nome"));
                hospedagem.setLocal(rs.getString("local"));
                hospedagem.setTipo(rs.getString("tipo"));
                hospedagem.setDescricao(rs.getString("descricao"));
                hospedagem.setPreco(rs.getDouble("preco"));
                return hospedagem;
            } else {
                return null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("HospedagemDAO.READ = " + ex.getMessage());
        }
        return null;
    }

    @Override
    public void update(Hospedagem object) {
        try {
            String SQL = "UPDATE sua_tabela SET local = ?, tipo = ?, descricao = ?, preco = ? WHERE nome = ?";
            PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);

            stm.setString(1, object.getLocal());
            stm.setString(2, object.getTipo());
            stm.setString(3, object.getDescricao());
            stm.setDouble(4, object.getPreco());
            stm.setString(5, object.getNome());

            int res = stm.executeUpdate();

            if (res != 0) {
                System.out.println("Hospedagem atualizada com sucesso");
            } else {
                throw new RuntimeException("Erro ao atualizar hospedagem");
            }
        } catch (Exception ex) {
            System.out.println("HospedagemDAO.UPDATE = " + ex.getMessage());
        }
    }

    @Override
    public void delete(Hospedagem object) {
        try {
            String SQL = "DELETE FROM sua_tabela WHERE nome = ?";
            PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);
            stm.setString(1, object.getNome());

            int res = stm.executeUpdate();

            if (res != 0) {
                System.out.println("Hospedagem excluída com sucesso");
            } else {
                throw new RuntimeException("Erro ao apagar hospedagem");
            }
        } catch (Exception ex) {
            System.out.println("HospedagemDAO.DELETE = " + ex.getMessage());
        }
    }
}
