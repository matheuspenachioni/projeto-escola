
package br.com.projetoescola.DAO;

import br.com.projetoescola.model.Aluno;
import br.com.projetoescola.model.Turma;
import br.com.projetoescola.utils.SingleConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAOImpl implements GenericDAO{
    private Connection conn;
    
    public AlunoDAOImpl() throws Exception{
        try{
            this.conn = SingleConnection.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        Aluno oAluno = (Aluno) object;
        Boolean retorno = false;
        if (oAluno.getIdAluno() == 0){
            retorno = this.inserir(oAluno);
        } else{
            retorno = this.alterar(oAluno);
        }
        return retorno;
    }

    @Override
    public Boolean inserir(Object object) {
        Aluno oAluno = (Aluno) object;
        PreparedStatement stmt = null;
        String sql = "INSERT INTO aluno (nomealuno, idturma, telefonealuno) VALUES (?, ?, ?)";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, oAluno.getNomeAluno());
            stmt.setInt(2, oAluno.getTurma().getIdTurma());
            stmt.setString(3, oAluno.getTelefoneAluno());
            stmt.execute();
            conn.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao cadastrar o Aluno! Erro: "+ ex.getMessage());
                ex.printStackTrace();
                conn.rollback();
            } catch (SQLException e) {
                System.out.println("Erro: "+e.getMessage());
                e.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Boolean alterar(Object object) {
        Aluno oAluno = (Aluno) object;
        PreparedStatement stmt = null;
        String sql = "UPDATE aluno SET nomealuno=?, idturma=?, telefoneoaluno=? WHERE idaluno=?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, oAluno.getNomeAluno());
            stmt.setInt(2, oAluno.getTurma().getIdTurma());
            stmt.setString(3, oAluno.getTelefoneAluno());
            stmt.setInt(4, oAluno.getIdAluno());
            stmt.execute();
            conn.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao alterar o Aluno! Erro: "+ ex.getMessage());
                ex.printStackTrace();
                conn.rollback();
            } catch (SQLException e) {
                System.out.println("Erro: "+ e.getMessage());
                e.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Boolean excluir(int idObject) {
        int idAluno = idObject;
        PreparedStatement stmt= null;
        String sql = "DELETE FROM aluno WHERE idaluno=?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idAluno);
            stmt.execute();
            conn.commit();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao excluir o Aluno! Erro:" +ex.getMessage());
            try {
                conn.rollback();
            } catch (SQLException e) {
                System.out.println("Erro rolback "+e.getMessage());
                e.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Object carregar(int idObject) {
        int idAluno = idObject;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Aluno oAluno = null;
        String sql="SELECT * FROM aluno WHERE idaluno=?";
        try {
            stmt = conn.prepareStatement (sql);
            stmt.setInt(1, idAluno);
            rs = stmt.executeQuery();
            while (rs.next()) {
                oAluno= new Aluno();
                oAluno.setIdAluno(rs.getInt ("idaluno"));
                oAluno.setNomeAluno(rs.getString ("nomealuno"));
                oAluno.setTelefoneAluno(rs.getString ("telefonealuno"));
                
                TurmaDAOImpl oTurmaDAOImpl = new TurmaDAOImpl();
                oAluno.setTurma((Turma) oTurmaDAOImpl.carregar(rs.getInt("idturma")));
            }
            return oAluno;
        } catch (Exception ex) {
            System.out.println("Problemas ao carregar Aluno! Erro: "+ex.getMessage());
            return false;
        }
    }

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM aluno ORDER BY idaluno";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Aluno oAluno = new Aluno();
                oAluno.setIdAluno(rs.getInt("idaluno"));
                oAluno.setNomeAluno(rs.getString("nomealuno"));
                oAluno.setTelefoneAluno(rs.getString("telefonealuno"));
                
                TurmaDAOImpl oTurmaDAOImpl = null;
                try {
                    oTurmaDAOImpl = new TurmaDAOImpl();
                } catch (Exception ex){
                    System.out.println("Erro ao buscar Turma! Erro: "+ ex.getMessage());
                    ex.printStackTrace();
                }
                oAluno.setTurma((Turma) oTurmaDAOImpl.carregar(rs.getInt("idturma")));
                resultado.add(oAluno);
            }
        } catch (SQLException e) {
            System.out.println("Problemas ao listar Turma! Erro: "+e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                SingleConnection.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conexão! Erro" + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return resultado;
    }
    
}
