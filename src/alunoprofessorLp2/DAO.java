
package alunoprofessorLp2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.bin.Aluno;
import model.bin.Professor;

public class DAO {
    Connection conexao = null;
    
    public void salvarAluno(Aluno aluno) throws SQLException {
        conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/lp2", "nbuser", "nbuser");
        String sql = "insert into Aluno (ra, nome, idade, cpf, sexo) values (?,?,?,?,?)";
        
        try {
            PreparedStatement preparador = conexao.prepareStatement(sql);
            preparador.setInt(1, aluno.getRa());
            preparador.setString(2, aluno.getNome());
            preparador.setInt(3, aluno.getIdade());
            preparador.setString(4, aluno.getCpf());
            preparador.setString(5, aluno.getSexo());


            int retorno = preparador.executeUpdate();

            if (retorno > 0) {
                JOptionPane.showMessageDialog(null, "Aluno salvo com Sucesso !");
                preparador.close();
            }
        
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            conexao.close();
        }
    }
    
    public void salvarProfessor(Professor professor) throws SQLException{
        conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/lp2", "nbuser", "nbuser");
        String sql = "insert into professor (, nome, idade, cpf, sexo) values (?,?,?,?,?)";
        
        try {
            PreparedStatement preparador = conexao.prepareStatement(sql);
            preparador.setString(1, professor.getNome());
            preparador.setInt(2, professor.getIdade());
            preparador.setString(3, professor.getCpf());
            preparador.setString(4, professor.getSexo());
            preparador.setInt(5, professor.getSiape());
            
            
            int retorno = preparador.executeUpdate();
            
            if (retorno > 0) {
                JOptionPane.showMessageDialog(null, "Professor salvo com Sucesso !");
                preparador.close();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            conexao.close();
        }
    }
    
    public void removerAluno(Aluno a) throws SQLException{
        String sql = "delete from aluno where cpf = ?";    
        conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/lp2", "nbuser", "nbuser");
        
        try {
            PreparedStatement preparador = conexao.prepareStatement(sql);
            preparador.setString(1,a.getCpf());
            
            int retorno = preparador.executeUpdate();
            if(retorno >0 ){
                JOptionPane.showMessageDialog(null, "Aluno deletado com sucesso!");
                preparador.close();
            }
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Deletar: "+ex);
        } finally{
            conexao.close();
        }
    
    }
    
    public void removerProfessor(Professor p) throws SQLException{
        conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/lp2", "nbuser", "nbuser");
        String sql = "delete from professor where cpf = ?";
        
        try {
            PreparedStatement preparador = conexao.prepareStatement(sql);
            preparador.setString(1, p.getCpf());
            
            int retorno = preparador.executeUpdate();
            if(retorno >0 ){
                JOptionPane.showMessageDialog(null, "Professor deletado com sucesso!");
                preparador.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Deletar: "+ex);
        } finally{
            conexao.close();
        }
    }
    
    public Aluno exibirAluno(Aluno a) throws SQLException{
        Aluno alu = null;
        String sql= "select * from aluno where ra = ?";
        try{
            PreparedStatement preparador = conexao.prepareStatement(sql);
            preparador.setInt(1, a.getRa());
            ResultSet rs = preparador.executeQuery();
            
            while(rs.next()){
                alu = new Aluno();
                alu.setNome(rs.getString("nome"));
                alu.setIdade(rs.getInt("idade"));
                alu.setCpf(rs.getString("cpf"));
                alu.setSexo(rs.getString("sexo"));
                alu.setRa(rs.getInt("ra"));
            }
            
            int retorno = preparador.executeUpdate();
                if (retorno > 0) {
                    JOptionPane.showMessageDialog(null, "Busca efetuada com sucesso!");
                    rs.close();
                    preparador.close();
                    return alu;
                }
    }catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage());
    } finally {
        conexao.close();
    }
}
    
    public Professor exibirProfessor(Professor p) throws SQLException{
        Professor pro = null;
        String sql= "select * from professor where siape = ?";
        try{
            PreparedStatement preparador = conexao.prepareStatement(sql);
            preparador.setInt(1, p.getSiape());
            ResultSet rs = preparador.executeQuery();
            
            while(rs.next()){
                pro = new Professor();
                pro.setNome(rs.getString("nome"));
                pro.setIdade(rs.getInt("idade"));
                pro.setCpf(rs.getString("cpf"));
                pro.setSexo(rs.getString("sexo"));
                pro.setSiape(rs.getInt("siape"));
            }
            
            int retorno = preparador.executeUpdate();
            if (retorno > 0) {
                JOptionPane.showMessageDialog(null, "Busca efetuada com sucesso!");
                rs.close();
                preparador.close();
                return pro;
            }
    }catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage());
    } finally {
        conexao.close();
    }
    }
        
    public Aluno exibirTodosAlunos() throws SQLException{
        ArrayList<Aluno> lista = new ArrayList<Aluno>();
        Aluno alu = null;
        String sql = "select * from aluno";
        
        try{
            PreparedStatement preparador = conexao.prepareStatement(sql);
            ResultSet rs = preparador.executeQuery();
            
            while(rs.next()){
                alu = new Aluno();
                alu.setNome(rs.getString("nome"));
                alu.setIdade(rs.getInt("idade"));
                alu.setCpf(rs.getString("cpf"));
                alu.setSexo(rs.getString("sexo"));
                alu.setRa(rs.getInt("ra"));
                lista.add(alu);
            }
            
            int retorno = preparador.executeUpdate();
            if (retorno > 0) {
                JOptionPane.showMessageDialog(null, "Listado com sucesso!");
                rs.close();
                preparador.close();
                return alu;
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            conexao.close();
        }
    }
    
    public Professor exibirTodosProfessores() throws SQLException{
        ArrayList<Professor> lista = new ArrayList<Professor>();
        Professor pro = null;
        String sql = "select * from professor";
        
        try{
            PreparedStatement preparador = conexao.prepareStatement(sql);
            ResultSet rs = preparador.executeQuery();
            
            while(rs.next()){
                pro = new Professor();
                pro.setNome(rs.getString("nome"));
                pro.setIdade(rs.getInt("idade"));
                pro.setCpf(rs.getString("cpf"));
                pro.setSexo(rs.getString("sexo"));
                pro.setSiape(rs.getInt("siape"));
                lista.add(pro);
            }
            
            int retorno = preparador.executeUpdate();
            if (retorno > 0) {
                JOptionPane.showMessageDialog(null, "Listado com sucesso!");
                rs.close();
                preparador.close();
                return pro;
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            conexao.close();
        }
    }
    
    public void atualizarAluno(Aluno a) throws SQLException{
        String sql = "update aluno set nome = ?, idade = ?, cpf = ?, sexo = ? where ra = ?";
        
        try{
            PreparedStatement preparador = conexao.prepareStatement(sql);
            preparador.setString(1, a.getNome());
            preparador.setInt(2, a.getIdade());
            preparador.setString(3, a.getCpf());
            preparador.setString(4, a.getSexo());
            preparador.setInt(5, a.getRa());
            
            int retorno = preparador.executeUpdate();
            if(retorno >0 ){
                JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
                preparador.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: "+ex);
        } finally{
            conexao.close();
        }
    }
    
    public void atualizarProfessor(Professor p) throws SQLException{
        String sql = "update professor set nome = ?, idade = ?, cpf = ?, sexo = ? where siape = ?";
        
        try{
            PreparedStatement preparador = conexao.prepareStatement(sql);
            preparador.setString(1, p.getNome());
            preparador.setInt(2, p.getIdade());
            preparador.setString(3, p.getCpf());
            preparador.setString(4, p.getSexo());
            preparador.setInt(5, p.getSiape());
            
            int retorno = preparador.executeUpdate();
            if(retorno >0 ){
                JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
                preparador.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: "+ex);
        } finally{
            conexao.close();
        }
    }
    
}
