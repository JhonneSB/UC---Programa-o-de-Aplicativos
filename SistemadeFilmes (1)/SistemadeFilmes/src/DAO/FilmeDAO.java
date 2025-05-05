/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Telas.Filme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author carlos_js_santos
 */
public class FilmeDAO {
    private Connection con;
    ResultSet rs;
    PreparedStatement ps;
    
    public FilmeDAO(){
        this.con = new ConexaoBanco().getConexao();
              
    }
    public void cadastrarDes(Filme desenho){
        String SQL = "Insert into desenho(nom_cad,desc_cad,preco_cad)Values(?,?,?)";
        try (PreparedStatement ps = con.prepareStatement(SQL)){
            ps.setString(1,desenho.getNome());
            ps.setString(2,desenho.getDesc());
            ps.setBigDecimal(3,desenho.getPreco());
            System.out.println("Filme " + desenho.getNome() + " cadastrado!");
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Filme cadastrado");
        }catch (Exception e){
             JOptionPane.showMessageDialog(null, "Erro ao adicionar"+ e);
            
        }
        
    }
    public void removerDes(int idCad)throws SQLException{
        String sql ="Delete from desenho where cod_cad=?";
        try (Connection connection = new ConexaoBanco().getConexao()){
        PreparedStatement ps = connection.prepareStatement(sql);
                
        ps.setInt(1, idCad);
        ps.executeUpdate();
        
        } catch (java.sql.SQLIntegrityConstraintViolationException e){
                
        throw new SQLException("Erro: Não foi possivel excluir");
        }
        
    }
    public ArrayList<Filme> getDesenhos(){
        String SQL = "Select * from desenho";
        ArrayList<Filme> desenhos = null;
        try (Connection connection = new ConexaoBanco().getConexao();
               PreparedStatement ps = connection.prepareStatement(SQL);)
    {
        try(ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                if(desenhos==null){
                    desenhos= new ArrayList<>();
                }
            Filme desenho = new Filme();
            desenho.setCod(rs.getInt("cod_cad"));
            desenho.setNome(rs.getString("nom_cad"));
            desenho.setDesc(rs.getString("desc_cad"));
            desenho.setPreco(rs.getBigDecimal("preco_cad"));
            desenhos.add(desenho);
            
            }
          
        }
        return desenhos;
        } catch (Exception e) {
            throw new RuntimeException (e);
          
        }
    }
    public void alterarDes(int codigo, String password){
        String sql = "Update cadastar set nom_cad"+"= ? where cod_cad = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, password);
            ps.setInt(2, codigo);
            ps.execute();
            ps.close();
            
        } catch (Exception e) {
        }
        
    }
    
    
    
}
