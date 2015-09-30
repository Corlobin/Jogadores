/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifes.edu.br.negocio;

import ifes.edu.br.persistencia.PersistenciaJogador;

/**
 *
 * @author Ricardo
 */
public class ControleJogador {
    static public void inserirJogador(String nome, int idade) throws Exception {
        Jogador jogador;
        try {
            jogador = new Jogador();
            jogador.setNome(nome);
            jogador.setIdade(idade);
            
            PersistenciaJogador persistencia = new PersistenciaJogador();
            persistencia.inserir(jogador);
            
        } catch(Exception e) {
            throw new Exception(" " + e.getMessage());            
        }
    }
}
