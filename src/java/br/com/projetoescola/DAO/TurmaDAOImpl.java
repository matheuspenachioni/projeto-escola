
package br.com.projetoescola.DAO;

import br.com.projetoescola.model.Turma;
import br.com.projetoescola.utils.SingleConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TurmaDAOImpl implements GenericDAO {
    private Connection conn;
    
    public TurmaDAOImpl() throws Exception{
        try{
            this.conn = SingleConnection.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
    
    @Override
    public Boolean cadastrar(Object object) {
        Turma oTurma = (Turma) object;
        Boolean retorno = false;
        if (oTurma.getIdTurma() == 0){
            retorno = this.inserir(oTurma);
        } else{
            retorno = this.alterar(oTurma);
        }
        return retorno;
    }
    
    @Override
    public Boolean inserir(Object object) {
        Turma oTurma = (Turma) object;
        PreparedStatement stmt = null;
        String sql = "INSERT INTO turma (siglaturma, periodoturma) VALUES (?, ?)";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, oTurma.getSiglaTurma());
            stmt.setString(2, oTurma.getPeriodoTurma());
            stmt.execute();
            conn.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao cadastrar a Turma! Erro: "+ ex.getMessage());
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
        Turma oTurma = (Turma) object;
        PreparedStatement stmt = null;
        String sql = "UPDATE turma SET siglaturma=?, periodoturma=? WHERE idturma=?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, oTurma.getSiglaTurma());
            stmt.setString(2, oTurma.getPeriodoTurma());
            stmt.setInt(3, oTurma.getIdTurma());
            stmt.execute();
            conn.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao alterar a Turma! Erro: "+ ex.getMessage());
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
        int idTurma = idObject;
        PreparedStatement stmt= null;
        String sql = "DELETE FROM turma WHERE idturma=?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idTurma);
            stmt.execute();
            conn.commit();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao excluir a Turma! Erro:" +ex.getMessage());
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
        int idTurma = idObject;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Turma oTurma = null;
        String sql="SELECT * FROM turma WHERE idturma=?";
        try {
            stmt = conn.prepareStatement (sql);
            stmt.setInt(1, idTurma);
            rs = stmt.executeQuery();
            while (rs.next()) {
                oTurma= new Turma();
                oTurma.setIdTurma(rs.getInt ("idturma"));
                oTurma.setSiglaTurma(rs.getString ("siglaturma"));
                oTurma.setPeriodoTurma(rs.getString ("periodoturma"));
            }
            return oTurma;
        } catch (Exception ex) {
            System.out.println("Problemas ao carregar Turma! Erro: "+ex.getMessage());
            return false;
        }
    }
    
    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM turma ORDER BY idturma";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Turma oTurma = new Turma();
                oTurma.setIdTurma(rs.getInt("idturma"));
                oTurma.setSiglaTurma(rs.getString("siglaturma"));
                oTurma.setPeriodoTurma(rs.getString("periodoturma"));
                resultado.add(oTurma);
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
