
package model.bin;


public class Professor extends Pessoa{
    private int siape;

    /*public Professor(String nome, int idade, String cpf, String sexo){
        super.setNome(nome);
        super.setIdade(idade);
        super.setCpf(cpf);
        super.setSexo(sexo);
    }*/
    
    public int getSiape() {
        return siape;
    }

    public void setSiape(int siape) {
        this.siape = siape;
    }
}
