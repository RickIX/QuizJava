package entidades;

public class Ranking {
    private User jogador;
    private int pontuacao;

    public Ranking(User jogador, int pontuacao) {
        this.jogador = jogador;
        this.pontuacao = pontuacao;
    }

    public User getJogador() {
        return jogador;
    }

    public void setJogador(User jogador) {
        this.jogador = jogador;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
}

