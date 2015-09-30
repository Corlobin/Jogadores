/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifes.edu.br.persistencia;

import ifes.edu.br.negocio.Jogador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ricardo
 */
public class PersistenciaJogador {
    private Connection conn;
    private String SQL;

    public PersistenciaJogador() throws Exception {
        String url = "jdbc:postgresql://localhost:5432/jogadores";
        String usuario = "postgres";
        String senha = "ifes";
        try { 
            conn = DriverManager.getConnection(url, usuario, senha);            
        } catch (Exception e) {
            throw new Exception("Erro ao criar conexao " + e.getMessage());
        }
    }

    public void finalize() throws Exception {
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
            throw new Exception("Ocorreu um erro ao fechar a conexao");
        }
    }
    public void inserir(Jogador jogador) throws Exception {
        SQL = "INSERT INTO jogador (nome, idade) VALUES (?, ?)";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(SQL);
            stmt.setString(1, jogador.getNome());
            stmt.setInt(2, jogador.getIdade());
            stmt.execute();
            stmt.close();
        } catch (Exception ex) {
            System.out.println("" + ex.getMessage());
            throw new Exception("Erro ao inserir no banco de dados.");
        }      
    }
    

    
}
