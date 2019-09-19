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


public class Main {
    public static void main(String [] args) throws SQLException{
        EntradaDeDados entrada = new EntradaDeDados();
        String opt = JOptionPane.showInputDialog("O - Sair\n1 - Salvar\n2 - Buscar\n3 - Remover\n4 - Atualizar");
        
        switch(opt){
            case "0":
                break;
                
            case "1":
                if(opt.equals("1")){
                    String opt2 = JOptionPane.showInputDialog("1 - Aluno\n2 - Professor");
                    if(opt2.equals("1")){
                        Aluno aluno = null;
                        entrada.entradaAluno(aluno);
                    }else{
                        Professor professor = null;
                        entrada.entradaProfessor(professor);
                    }
                }
                break;
                
            case "2":
                String opt2 = JOptionPane.showInputDialog("1 - Buscar Aluno\n2 - Buscar Professor");
                if(opt2.equals("1")){
                    String opt3 = JOptionPane.showInputDialog("1 - Buscar por Id\n2 - Buscar todos");
                    if(opt3.equals("2")){
                        Aluno aluno = null;
                        entrada.exibirTodosAlunos(aluno);
                    }else if(opt3.equals("1")){
                        Aluno aluno = null;
                        entrada.exibirAluno(aluno);
                    }if(opt2.equals("2")){
                        if(opt3.equals("1")){
                            Professor professor = null;
                            entrada.exibirProfessor(professor);
                        }else{
                            Professor professor = null;
                            entrada.exibirTodosProfessores(professor);
                        }
                    }else{
                        JOptionPane.showInputDialog(null, "Opcao invalida!");
                    }
                }
                break;
                
            case "3":
                if(opt.equals("3")){
                    String opt3 = JOptionPane.showInputDialog("1 - Aluno\n2 - Professor");
                    if(opt3.equals("1")){
                        Aluno aluno = null;
                        entrada.removerAluno(aluno);
                    }else{
                        Professor professor = null;
                        entrada.removerProfessor(professor);
                    }
                }
                break;
            
            case "4":
                if(opt.equals("4")){
                    String opt3 = JOptionPane.showInputDialog("1 - Aluno\n2 - Professor");
                    if(opt3.equals("1")){
                        Aluno aluno = null;
                        entrada.atualizarAluno(aluno);
                    }else{
                        Professor professor = null;
                        entrada.atualizarProfessor(professor);
                    }
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opcao invalida!");
        }
    }
}
