
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Funcionario {

    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;
    private String cargo;
    private ArrayList<Funcionario> listaFuncionarios;

    public Funcionario() {
    }

    public Funcionario(String nome, String cpf, String endereco, String telefone, String cargo) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cargo = cargo;
    }
    public String toString(){
        return nome+";"+cpf+";"+endereco+";"+telefone+";"+cargo;

    }

    public void exportarParaTXT(ArrayList<Funcionario> listaFuncionarios){
        try (BufferedWriter dados = new BufferedWriter( new FileWriter("Funcionarios.txt"))){
            for (Funcionario f:listaFuncionarios)
            {
                dados.write(f.toString());
                dados.newLine();
            }

            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Exportar para o arquivo" + e.getMessage());
        }
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

}
