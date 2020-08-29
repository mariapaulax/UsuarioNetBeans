/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ulbra.dao;

import br.com.ulbra.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author maria
 */
public class UsuarioDao {
    public boolean checkLogin(String email, String senha) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        boolean check = false;

        try{
            stmt = con.prepareStatement("SELECT * FROM tbusuario WHERE email = ? and senha = ?");
            stmt.setString(1, email);
            stmt.setString(2, senha);
            
             rs = stmt.executeQuery();

            if (rs.next()) {

                check = true;
            }


        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return check;

}

   public void create(Usuario u){
       
       Connection con = ConnectionFactory.getConnection();
       PreparedStatement stmt = null;
               
        try {
            stmt = con.prepareStatement("INSERT INTO tbusuario (nome,email,senha)VALUES(?,?,?)");
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getSenha());
            
            stmt.executeUpdate();

           JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
   
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar"+ex);
         System.out.println(ex);
   
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }

   }

   
      public List<Usuario> read(){
          
   Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Usuario> usuarios = new ArrayList<>(); 
       
        try {
            stmt = con.prepareStatement("SELECT * FROM tbusuario");
            rs = stmt.executeQuery();
               
            while (rs.next()) {

                Usuario usuario = new Usuario();
                
                usuario.setCodigo(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuarios.add(usuario);
            }
            
            } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
          return usuarios;

      }

      public List<Usuario> readForDesc(String desc) {
   
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
      List<Usuario> produtos = new ArrayList<>();
       try {
            stmt = con.prepareStatement("SELECT * FROM tbusuario WHERE nome LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            
           rs = stmt.executeQuery();

            while (rs.next()) {

                Usuario usuario = new Usuario();
                
                usuario.setCodigo(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                produtos.add(usuario);
                
            }
             } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return produtos;

    }


       public void update(Usuario u) throws SQLException { 
      Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
         try{
            stmt = con.prepareStatement("UPDATE tbusuario SET nome = ? ,email = ?,senha = ? WHERE id = ?");
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getSenha());
            stmt.setInt(4, u.getCodigo());

        stmt.executeUpdate();
     JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
        public void delete(Usuario u) throws SQLException {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("DELETE FROM tbusuario WHERE id = ?");
            stmt.setInt(1, u.getCodigo());
            
             stmt.executeUpdate();
             JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
}





        

       
















