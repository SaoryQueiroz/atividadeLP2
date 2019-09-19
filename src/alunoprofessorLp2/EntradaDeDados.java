/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alunoprofessorLp2;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.bin.Aluno;
import model.bin.Professor;

public class EntradaDeDados {
    DAO dao = new DAO();
    Aluno aluno = new Aluno();
    Professor professor = new Professor();
    
    public void entradaAluno() throws SQLException{
        aluno.setNome(JOptionPane.showInputDialog("Nome: "));
        aluno.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Entre com a idade: ")));
	aluno.setCpf(JOptionPane.showInputDialog("Entre com o cpf: "));
	aluno.setSexo(JOptionPane.showInputDialog("Entre com o sexo: "));
        aluno.setRa(Integer.parseInt(JOptionPane.showInputDialog("Entre com o ra: ")));
	dao.salvarAluno(aluno);
    }
    
    public void entradaProfessor() throws SQLException{
        professor.setNome(JOptionPane.showInputDialog("Nome: "));
        professor.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Entre com a idade: ")));
	professor.setCpf(JOptionPane.showInputDialog("Entre com o cpf: "));
	professor.setSexo(JOptionPane.showInputDialog("Entre com o sexo: "));
        professor.setSiape(Integer.parseInt(JOptionPane.showInputDialog("SIAPE: ")));
        dao.salvarProfessor(professor);
    }
    
    public void exibirAluno() throws SQLException{
        //aluno = new Aluno();
        aluno.setRa(Integer.parseInt(JOptionPane.showInputDialog("Entre com o ra do aluno a ser exibido: ")));
    	JOptionPane.showMessageDialog(null, dao.exibirAluno(aluno));
    }
    
    public void exibirProfessor() throws SQLException{
        professor.setSiape(Integer.parseInt(JOptionPane.showInputDialog("Entre com o siape do professor a ser exibido: ")));
    	JOptionPane.showMessageDialog(null, dao.exibirProfessor(professor));
    }
    
    public void exibirTodosAlunos() throws SQLException{
        JOptionPane.showMessageDialog(null, dao.exibirTodosAluno());
    }
    
    public void exibirTodosProfessores() throws SQLException{
        JOptionPane.showMessageDialog(null, dao.exibirTodosProfessores());
    }
    
    public void removerAluno() throws SQLException{
    	aluno.setRa(Integer.parseInt(JOptionPane.showInputDialog("Entre com o ra do aluno que desejar deletar: ")));
        dao.removerAluno(aluno);
        JOptionPane.showMessageDialog(null, "Aluno do ra " + aluno.getRa() + " foi deletado com sucesso.");
    }
    
    public void removerProfessor() throws SQLException{
    	professor.setSiape(Integer.parseInt(JOptionPane.showInputDialog("Entre com o ra do aluno que desejar deletar: ")));
        dao.removerProfessor(professor);
        JOptionPane.showMessageDialog(null, "O professor do siape " + professor.getSiape() + " foi deletado com sucesso.");
    }
    
    public void atualizarAluno() throws SQLException{
	aluno.setRa(Integer.parseInt(JOptionPane.showInputDialog("Entre com o ra do aluno a ser atualizado: ")));
	aluno.setNome(JOptionPane.showInputDialog("Entre com o nome: "));
	aluno.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Entre com a idade: ")));
	aluno.setCpf(JOptionPane.showInputDialog("Entre com o cpf: "));
	aluno.setSexo(JOptionPane.showInputDialog("Entre com o sexo: "));
        dao.atualizarAluno(aluno);
       }
    public void atualizarProfessor() throws SQLException{
	professor.setSiape(Integer.parseInt(JOptionPane.showInputDialog("Entre com o siape do professor: ")));
	professor.setNome(JOptionPane.showInputDialog("Entre com o nome: "));
	professor.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Entre com a idade: ")));
	professor.setCpf(JOptionPane.showInputDialog("Entre com o cpf: "));
	professor.setSexo(JOptionPane.showInputDialog("Entre com o sexo: "));
        dao.atualizarProfessor(professor);
       }

}
