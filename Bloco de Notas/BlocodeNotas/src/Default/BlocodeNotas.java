/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Default;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author carlos_js_santos
 */
public class BlocodeNotas extends javax.swing.JFrame {
    private JTextArea textArea;
    private JScrollPane scrollPane;
    private JMenuBar menuBar;
    private JMenu menuEditar, menuArquivo;
    private JMenuItem menuClaro, menuEscuro, menuAzul, menuRosa, menuNovo,menuAbrir,menuSalvar,menuSair;


    /**
     * Creates new form BlocodeNotas
     */
    public BlocodeNotas() {
        //initComponents();
       
        setTitle("Bloco de Notas");
        setSize(800,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); //Centraliza a tela
        //dispose_on_close, nthing_on_close,hide_on_close
        setResizable(false);// Impossibilita ajuste da tela por parte do usuário
        
        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea);
        add(scrollPane);
        
        //Barra de menu
        menuBar = new JMenuBar();
        menuArquivo = new JMenu ("Arquivo");
        menuEditar = new JMenu ("Editor");
        menuBar.add(menuArquivo);
        menuBar.add(menuEditar);
        
        //
        menuNovo = new JMenuItem("Nova"); 
        menuAbrir = new JMenuItem("Abrir"); 
        menuSalvar = new JMenuItem("Salvar");
        menuSair = new JMenuItem("Sair");
        
        menuClaro = new JMenuItem ("Claro");
        menuEscuro = new JMenuItem ("Escuro");
        menuAzul = new JMenuItem ("Azul");
        menuRosa = new JMenuItem ("Rosa");
        
        menuArquivo.add(menuNovo);
        menuArquivo.add(menuAbrir);
        menuArquivo.add(menuSalvar);
        menuArquivo.addSeparator();
        menuArquivo.add(menuSair);
        menuEditar.add(menuClaro);
        menuEditar.add(menuEscuro);
        menuEditar.add(menuAzul);
        menuEditar.add(menuRosa);
                
        setJMenuBar(menuBar);
        
        menuNovo.addActionListener(e ->novoArquivo());
        menuAbrir.addActionListener(e ->abrirArquivo());
        menuSalvar.addActionListener(e ->salvarArquivo());
        menuClaro.addActionListener(e ->menuClaro());
        menuEscuro.addActionListener(e ->menuEscuro());
        menuAzul.addActionListener(e ->menuAzul());
        menuRosa.addActionListener(e ->menuRosa());
        menuSair.addActionListener(e ->System.exit(0));
        
    }
    private void novoArquivo(){
        //textArea.setText("");
        if(!textArea.getText().isEmpty()){
            String[] options = {"SIM", "NÃO", "CANCELAR"};
            int option = JOptionPane.showConfirmDialog(this, "Você tem um texto não salvo.Deseja salvar antes de criar um novo arquivo?",
                    "Salvar Arquivo", JOptionPane.YES_NO_CANCEL_OPTION);
            if(option == JOptionPane.YES_OPTION){
                salvarArquivo();
                textArea.setText("");
            }else if(option == JOptionPane.NO_OPTION){
                textArea.setText("");
            }
        }else{
            textArea.setText("");
        }
    
    }
    private void menuClaro(){
                textArea.setBackground(Color.WHITE);
                textArea.setForeground(Color.BLACK);
                Font font = new Font ("Arial", Font.PLAIN,18);
                textArea.setFont(font);
                revalidate();
                repaint();
        
    }
    private void menuEscuro(){
                textArea.setBackground(Color.BLACK);
                textArea.setForeground(Color.WHITE);
                Font font = new Font ("Arial", Font.PLAIN,18);
                textArea.setFont(font);
                revalidate();
                repaint();
    }
    private void menuAzul(){
                textArea.setBackground(Color.BLUE);
                textArea.setForeground(Color.WHITE);
                Font font = new Font ("Arial", Font.PLAIN,18);
                textArea.setFont(font);
                revalidate();
                repaint();
        
    }
    private void menuRosa(){
                textArea.setBackground(Color.PINK);
                textArea.setForeground(Color.WHITE);
                Font font = new Font ("Arial", Font.PLAIN,18);
                textArea.setFont(font);
                revalidate();
                repaint();
              
    }
    private void abrirArquivo(){
        JFileChooser arquivo = new JFileChooser();
        int option = arquivo.showOpenDialog(this);
        if(option==JFileChooser.APPROVE_OPTION){
            try{
                File arquivoB =arquivo.getSelectedFile();
                BufferedReader reader = new BufferedReader(new  FileReader (arquivoB));
                textArea.read(reader, null);
                reader.close();
        } catch (IOException e){
            e.printStackTrace(); //nome, mensagem, lista de erro
        }}
    }
    private void salvarArquivo(){
        JFileChooser arquivo = new JFileChooser();
        int option = arquivo.showOpenDialog(this);
        if(option==JFileChooser.APPROVE_OPTION){
            try{
                File arquivoB = arquivo.getSelectedFile();
                BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivoB));
                textArea.write(escritor);
                escritor.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BlocodeNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BlocodeNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BlocodeNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BlocodeNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BlocodeNotas().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
