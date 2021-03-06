/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda.dao;

import br.com.agenda.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Napoleao Kazu Onaya
 */
public class ClienteDAO {
    
    public boolean inserir(Cliente cliente){
        
        try {
            
            Connection connection = ConnectionFactory.getConnection();
            
            String sql ="insert into cliente"
                    + "(nome,telefone)"
                    + "values(?,?)";
            
            PreparedStatement pstmt = connection.prepareStatement(sql);
            
            pstmt.setString(1,cliente.getNome());
            pstmt.setString(2,cliente.getTelefone());
            
            pstmt.execute();
            
            pstmt.close();
            connection.close();
            
            return true;
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public boolean deletar(Cliente cliente){
        
        try {
            
            Connection connection = ConnectionFactory.getConnection();
            
            String sql =" delete from cliente "
                    + "where id ="+cliente.getId();
            
            PreparedStatement pstmt = connection.prepareStatement(sql);
            
            pstmt.execute();
            
            pstmt.close();
            connection.close();
            
            return true;
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public ResultSet selecionaTodos(){
        
        try {
            
            Connection connection = ConnectionFactory.getConnection();
            
            PreparedStatement pstmt = connection.prepareStatement("select *from cliente");
            
            ResultSet rst = pstmt.executeQuery();
            
            return rst;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
    }
    
}
