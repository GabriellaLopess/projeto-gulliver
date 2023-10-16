package br.com.masters3.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.format.DateTimeFormatter;
import br.com.masters3.beans.Cidade;
import br.com.masters3.beans.Usuario;

public class UsuarioDAO implements DAO<Usuario> {
    private DataSource dataSource;

    public UsuarioDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public DataSource getDataSource() {
        return this.dataSource;
    }

    @Override
    public void create(Usuario object) {
        try {
            String SQL = "insert into TB_TIN_USUARIO (nivel, genero, email, senha, nome, nascimento, ultimo_acesso, foto, id_cidade) values (?,?,?,?,?,?,?,?,?)";

            PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);

            stm.setString(1, object.getNivel());
            stm.setString(2, object.getGenero());
            stm.setString(3, object.getEmail());
            stm.setString(4, object.getSenha());
            stm.setString(5, object.getNome());
            stm.setString(6, object.getNascimento().format(DateTimeFormatter.ofPattern("dd/MM/YYYY")));
            stm.setString(7, object.getUltimoAcesso().format(DateTimeFormatter.ofPattern("dd/MM/YYYY")));
            stm.setString(8, object.getFoto());
            stm.setInt(9, object.getCidade().getId());
            stm.setInt(10, object.getId());

            int res = stm.executeUpdate();

            if (res != 0) {
                System.out.println("Usu�rio inserido com sucesso");
            } else {
                throw new RuntimeException("Erro ao inserir usu�rio");
            }
        } catch (Exception ex) {
            System.out.println("UsuarioDAO.CREATE = " + ex.getMessage());
        }
    }

    @Override
    public Usuario read(Usuario object) {
        try {
            String SQL = "select * from TB_TIN_USUARIO inner join TB_TIN_CIDADE  on TB_TIN_USUARIO.ID_CIDADE = TB_TIN_CIDADE.ID where email = ? and senha = ?";

            PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);

            stm.setString(1, object.getEmail());
            stm.setString(2, object.getSenha());

            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("ID"));
                usuario.setNome(rs.getString("NOME"));
                usuario.setNivel(rs.getString("NIVEL"));
                usuario.setGenero(rs.getString("GENERO"));
                usuario.setEmail(rs.getString("EMAIL"));
                usuario.setSenha(rs.getString("SENHA"));
                usuario.setNascimento(rs.getDate("NASCIMENTO").toLocalDate());
                usuario.setUltimoAcesso(rs.getDate("ULTIMO_ACESSO").toLocalDate());
                usuario.setFoto(rs.getString("FOTO"));
                Cidade cidade = new Cidade();
                cidade.setId(rs.getInt("ID_CIDADE"));
                cidade.setCidade(rs.getString("CIDADE"));
                cidade.setEstado(rs.getString("ESTADO"));
                cidade.setSiglaEstado(rs.getString("SIGLA_ESTADO"));
               
         cidade.setSiglaPais(rs.getString("SIGLA_PAIS"));
                usuario.setCidade(cidade);
                return usuario;
            } else {
                return null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("UsuarioDAO.READ = " + ex.getMessage());
        }
        return null;
    }

    @Override
    public void update(Usuario object) {
        try {
            String SQL = "update TB_TIN_USUARIO set nivel = ?, genero = ?, email = ?, senha = ?, nome = ?, nascimento = ?, ultimo_acesso = ?, foto = ?, id_cidade = ? where id = ?";

            PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);

            stm.setString(1, object.getNivel());
            stm.setString(2, object.getGenero());
            stm.setString(3, object.getEmail());
            stm.setString(4, object.getSenha());
            stm.setString(5, object.getNome());
            stm.setString(6, object.getNascimento().format(DateTimeFormatter.ofPattern("dd/MM/YYYY")));
            stm.setString(7, object.getUltimoAcesso().format(DateTimeFormatter.ofPattern("dd/MM/YYYY")));
            stm.setString(8, object.getFoto());
            stm.setInt(9, object.getCidade().getId());
            stm.setInt(10, object.getId());

            int res = stm.executeUpdate();
            if (res != 0) {
                System.out.println("Usu�rio atualizado com sucesso");
            } else {
                throw new RuntimeException("Erro ao atualizar usu�rio");
            }
        } catch (Exception ex) {
            System.out.println("UsuarioDAO.UPDATE =" + ex.getMessage());
        }
    }

    @Override
    public void delete(Usuario object) {
        try {
            String SQL = "delete from  TB_TIN_USUARIO where ID = ?";
            PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);
            stm.setInt(1, object.getId());
            int res = stm.executeUpdate();
            if (res != 0) {
                System.out.println("Usu�rio exclu�do com sucesso");
            } else {
                throw new RuntimeException("Erro ao apagar usu�rio");
            }
        } catch (Exception ex) {
            System.out.println("UsuarioDAO.DELETE = " + ex.getMessage());
        }
    }
}
