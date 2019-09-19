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
                        entrada.entradaAluno();
                    }else{
                        Professor professor = null;
                        entrada.entradaProfessor();
                    }
                }
                break;
                
            case "2":
                String opt2 = JOptionPane.showInputDialog("1 - Buscar Aluno\n2 - Buscar Professor");
                if(opt2.equals("1")){
                    String opt3 = JOptionPane.showInputDialog("1 - Buscar por Id\n2 - Buscar todos");
                    if(opt3.equals("2")){
                        Aluno aluno = null;
                        entrada.exibirTodosAlunos();
                    }else if(opt3.equals("1")){
                        Aluno aluno = null;
                        entrada.exibirAluno();
                    }if(opt2.equals("2")){
                        if(opt3.equals("1")){
                            Professor professor = null;
                            entrada.exibirProfessor();
                        }else{
                            Professor professor = null;
                            entrada.exibirTodosProfessores();
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
                        entrada.removerAluno();
                    }else{
                        Professor professor = null;
                        entrada.removerProfessor();
                    }
                }
                break;
            
            case "4":
                if(opt.equals("4")){
                    String opt3 = JOptionPane.showInputDialog("1 - Aluno\n2 - Professor");
                    if(opt3.equals("1")){
                        Aluno aluno = null;
                        entrada.atualizarAluno();
                    }else{
                        Professor professor = null;
                        entrada.atualizarProfessor();
                    }
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opcao invalida!");
        }
    }
}
