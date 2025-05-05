
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Cargo extends JFrame {

    private JComboBox<String> comboBoxCargos;
    private DefaultListModel<String> listaCargosModel;
    private JList<String> listaCargos;
    private JButton btnAdicionar, btnRemover;




    public Cargo(){
        this.setVisible(true);
        // Configurações da janela
        setTitle("Cadastro de Cargos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel superior para o JComboBox e o botão "Adicionar"
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new FlowLayout());

        // JComboBox para seleção de cargos
        String[] cargosDisponiveis = {"Gerente", "Analista", "Desenvolvedor", "Suporte", "Designer", "Estagiário"};
        comboBoxCargos = new JComboBox<>(cargosDisponiveis);
        panelSuperior.add(new JLabel("Selecione o Cargo:"));
        panelSuperior.add(comboBoxCargos);

        // Botão para adicionar cargo à lista
        btnAdicionar = new JButton("Adicionar");
        panelSuperior.add(btnAdicionar);

        // Adiciona o painel superior à janela
        add(panelSuperior, BorderLayout.NORTH);

        // Modelo da JList que armazena os cargos selecionados
        listaCargosModel = new DefaultListModel<>();
        listaCargos = new JList<>(listaCargosModel);
        JScrollPane scrollPane = new JScrollPane(listaCargos);
        add(scrollPane, BorderLayout.CENTER);

        // Painel inferior para o botão "Remover"
        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new FlowLayout());

        // Botão para remover cargo da lista
        btnRemover = new JButton("Remover");
        panelInferior.add(btnRemover);
        add(panelInferior, BorderLayout.SOUTH);

        btnAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String cargoSelecionado = (String) comboBoxCargos.getSelectedItem();

                    if (!listaCargosModel.contains(cargoSelecionado)){
                        listaCargosModel.addElement(cargoSelecionado);

                    }else{
                        JOptionPane.showMessageDialog(null, "Cargo já adicionado");
                    }



            }
        });
        btnRemover.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String cargoSelecionado = (String) listaCargos.getSelectedValue();
                if(cargoSelecionado!=null){
                listaCargosModel.removeElement(cargoSelecionado);
                }else{
                    JOptionPane.showMessageDialog(null, "Selecione um cargo");
                }

                
            }    
        });
    }
}
