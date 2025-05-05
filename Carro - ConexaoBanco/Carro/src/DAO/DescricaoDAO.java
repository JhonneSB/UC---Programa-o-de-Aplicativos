/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Telas.Descricao;
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
public class DescricaoDAO {
    private Connection con;

    public DescricaoDAO() {
        this.con = new ConexaoBanco().getConexao();
    }
    
    
    public Descricao adicionar(String desc, String pot, String cor) {
    Descricao novaDescricao = new Descricao(desc, pot, cor);
    String SQL = "INSERT INTO cadcarros (desc_carro, pot_carro, cor_carro) VALUES (?, ?, ?)";
    try (PreparedStatement ps = con.prepareStatement(SQL)) {
        ps.setString(1, desc);
        ps.setString(2, pot);
        ps.setString(3, cor);
        ps.executeUpdate();
        return novaDescricao;
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao adicionar ");
        return null; 
    }

    }
    
    public void adicionarDesc(Descricao descricao) {
        String SQL = "INSERT INTO cadcarros (desc_carro, pot_carro, cor_carro) VALUES (?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(SQL)) {
            ps.setString(1, descricao.getDesc());
            ps.setString(2, descricao.getPot());
            ps.setString(3, descricao.getCor());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Carro adicionado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar");
        }
    }
    
    public void removerCad(int idCodigo) throws SQLException {
        String sql = "DELETE FROM cadcarros WHERE cod_carro = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idCodigo);
            ps.executeUpdate();
        } catch (java.sql.SQLIntegrityConstraintViolationException e) {
            throw new SQLException("Erro: Não foi possível excluir");
        }
    }
    
   public ArrayList<Descricao> getDescricoes() {
    String SQL = "SELECT * FROM cadcarros";
    ArrayList<Descricao> descricoes = new ArrayList<>();
    
    try (PreparedStatement ps = con.prepareStatement(SQL); ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
            Descricao descricao = new Descricao();
            descricao.setCod(rs.getInt("cod_carro"));
            descricao.setDesc(rs.getString("desc_carro"));
            descricao.setPot(rs.getString("pot_carro"));
            descricao.setCor(rs.getString("cor_carro"));
            descricoes.add(descricao);
        }
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
    return descricoes;
}

    public void alterarDesc(int codigo, String descricao) {
        String sql = "UPDATE cadcarros SET cor_carro = ? WHERE cod_carro = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, descricao);
            ps.setInt(2, codigo);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }}


