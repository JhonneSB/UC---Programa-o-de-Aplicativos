/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author carlos_js_santos
 */
public class ConexaoBanco {
    public Connection getConexao(){
        try {
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/palogin","root", "");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro de Conexão com o Banco");
            return null;
        
        }
        
    }
    
}
