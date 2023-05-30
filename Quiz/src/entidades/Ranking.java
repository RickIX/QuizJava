package entidades;

public class Ranking {
    private String nome;
    private int pontuacao;
    
    public Ranking(String nome, int pontuacao) {
        this.nome = nome;
        this.pontuacao = pontuacao;
    }
    
    public String getNome() {
        return nome;
    }
    
    public int getPontuacao() {
        return pontuacao;
    }
}
