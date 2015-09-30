/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifes.edu.br.negocio;

/**
 *
 * @author Ricardo
 */
public class Jogador {
    private String nome;
    private int idade;
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) throws Exception {
        if(idade < 18) {
            throw new Exception("Idade menor que 18");
        } else {
            this.idade = idade;
        }
    }
}
