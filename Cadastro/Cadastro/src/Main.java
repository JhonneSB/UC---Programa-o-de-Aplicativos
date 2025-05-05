
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

//import javafx.event.ActionEvent;

public class Main extends JFrame {
    private JButton btnCadastrar, btnConsultar, btnAtualizar, btnExcluir,btnCargo;
    private JTable tabelaFuncionarios;
    private DefaultTableModel modeloTabela;
    private ArrayList<Funcionario> listaFuncionarios;

    public Main() throws ParseException{
          listaFuncionarios = new ArrayList<>();
        setLayout(null);
        
        // Criação dos JLabels
        JLabel labelNome = new JLabel("Nome:");
        JLabel labelCpf = new JLabel("CPF:");
        JLabel labelEndereco = new JLabel("Endereço:");
        JLabel labelTelefone = new JLabel("Telefone:");
        JLabel labelCargo = new JLabel("Cargo:");
        
        // Definição da posição dos JLabels
        labelNome.setBounds(30, 30, 100, 30);
        labelCpf.setBounds(30, 70, 100, 30);
        labelEndereco.setBounds(30, 110, 100, 30);
        labelTelefone.setBounds(30, 150, 100, 30);
        labelCargo.setBounds(30, 190, 100, 30);
        
        // Criação dos JTextFields
        JTextField campoNome = new JTextField();
        // JTextField campoCpf = new JTextField();
        JTextField campoEndereco = new JTextField();
        // JTextField campoTelefone = new JTextField();
        JTextField campoCargo = new JTextField();

        //Mascara para CPF
        MaskFormatter formatarCPF = new MaskFormatter("###.###.###-##");
        formatarCPF.setPlaceholderCharacter('_');
        JFormattedTextField campoCpf = new JFormattedTextField(formatarCPF);
        campoCpf.setColumns(14);

        //Mascara para telefone
        MaskFormatter formatarTelefone = new MaskFormatter("(##) #####-####");
        formatarTelefone.setPlaceholderCharacter('_');
        JFormattedTextField campotelefone = new JFormattedTextField(formatarTelefone);
        campotelefone.setColumns(15);




         // Definição da posição dos JTextFields
        campoNome.setBounds(130, 30, 200, 30);
        campoCpf.setBounds(130, 70, 200, 30);
        campoEndereco.setBounds(130, 110, 200, 30);
        campotelefone.setBounds(130, 150, 200, 30);
        campoCargo.setBounds(130, 190, 200, 30);
        
        // Configurações da janela
        setTitle("Cadastro de Funcionário");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

               // Criação dos botões de CRUD
        btnCadastrar = new JButton("Cadastrar");
        btnConsultar = new JButton("Consultar");
        btnAtualizar = new JButton("Atualizar");
        btnExcluir = new JButton("Excluir");
        btnCargo = new JButton("Cargos");

        // Definição da posição dos botões
        btnCargo.setBounds(345, 29, 100, 30);
        btnCadastrar.setBounds(30, 230, 100, 30);
        btnConsultar.setBounds(140, 230, 100, 30);
        btnAtualizar.setBounds(250, 230, 100, 30);
        btnExcluir.setBounds(360, 230, 100, 30);

        // Configuração da JTable
        String[] colunas = {"Nome", "CPF", "Endereço", "Telefone", "Cargo"};
        modeloTabela = new DefaultTableModel(colunas, 0); // Modelo de tabela sem dados iniciais
        tabelaFuncionarios = new JTable(modeloTabela);
        JScrollPane painelTabela = new JScrollPane(tabelaFuncionarios); // Adiciona a tabela a um painel com barra de rolagem

        painelTabela.setBounds(30, 270, 430, 150); // Definição da posição e tamanho da tabela

         // Adiciona os componentes ao JFrame
         add(labelNome);
         add(campoNome);
         add(labelCpf);
         add(campoCpf);
         add(labelEndereco);
         add(campoEndereco);
         add(labelTelefone);
         add(campotelefone);
         add(labelCargo);
         add(campoCargo);
         add(btnCadastrar);
         add(btnConsultar);
         add(btnAtualizar);
         add(btnExcluir);
         add(btnCargo);
         add(painelTabela); // oi

         btnCadastrar.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        String nome = campoNome.getText();
                        String cpf = campoCpf.getText();
                        String endereco = campoEndereco.getText();
                        String telefone = campotelefone.getText();
                        String cargo = campoCargo.getText();
                        modeloTabela.addRow(new Object[]{nome, cpf, endereco, telefone, cargo});

                        Funcionario funcionario = new Funcionario(nome, cpf, endereco, telefone, cargo);

                        listaFuncionarios.add(funcionario);
                        funcionario.exportarParaTXT(listaFuncionarios);

                         campoNome.setText("");
                         campoCpf.setText("");
                         campoEndereco.setText("");
                         campotelefone.setText("");
                         campoCargo.setText("");

                        
                    }

         });

         btnConsultar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

            JFileChooser fileChooser = new JFileChooser();
            int resultado = fileChooser.showOpenDialog(null);
            if(resultado == JFileChooser.APPROVE_OPTION);
            File arquivoSelecionado = fileChooser.getSelectedFile();

            //Limpar tabela e arraylist
            listaFuncionarios.clear();
            modeloTabela.setRowCount(0);

            try(BufferedReader dados = new BufferedReader(new FileReader(arquivoSelecionado))) {
                String linha;
                while ((linha=dados.readLine())!=null){
                    String[] bdados = linha.split(";");
                    if (bdados.length ==5) {
                        String nome = bdados[0];
                        String cpf = bdados[1];
                        String endereco = bdados[2];
                        String telefone = bdados[3];
                        String cargo = bdados[4];

                        Funcionario funcionario = new Funcionario(nome, cpf, endereco, telefone, cargo);
                        listaFuncionarios.add(funcionario);

                        modeloTabela.addRow(new Object[]{nome, cpf, endereco, telefone, cargo});

                        
                    }

                }
                JOptionPane.showMessageDialog(null, "Dados importados com sucesso");
                
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo");

            }


            }
        });

        btnAtualizar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                listaFuncionarios.clear();
                for (int i = 0; i < modeloTabela.getRowCount(); i++){
                    String nome = (String) modeloTabela.getValueAt(i, 0);
                    String cpf = (String) modeloTabela.getValueAt(i, 1);
                    String endereco = (String)modeloTabela.getValueAt(i, 2);
                    String telefone = (String)modeloTabela.getValueAt(i, 3);
                    String cargo = (String)modeloTabela.getValueAt(i, 4);


                    Funcionario func = new Funcionario(nome, cpf, endereco, telefone, cargo);
                    listaFuncionarios.add(func);
                    func.exportarParaTXT(listaFuncionarios);



                }


            
            }
        });

        btnExcluir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int linhaselecionada = tabelaFuncionarios.getSelectedRow();
                if(linhaselecionada!=-1){
                listaFuncionarios.remove(linhaselecionada);
                modeloTabela.removeRow(linhaselecionada);
            
            }else{
                JOptionPane.showMessageDialog(null, "Selecione um funcionário para excluir");
            }
        }

        });

        btnCargo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new Cargo();

            
            }
        });

        

         revalidate();
         repaint();
         

    }
    
    public static void main(String[] args) throws Exception {
        Main frame = new Main();
        frame.setVisible(true);
        Funcionario fun = new Funcionario();
        
    }
}
