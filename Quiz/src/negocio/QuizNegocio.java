package negocio;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import entidades.Pergunta;
import persistencia.PerguntasPersistencia;

public class QuizNegocio {

    public static List<Pergunta> embaralharPerguntas() {
        List<Pergunta> perguntas = PerguntasPersistencia.listarPerguntas();

        // Verifica se há perguntas cadastradas
        if (perguntas.isEmpty()) {
            System.out.println("Não há perguntas cadastradas.");
            return Collections.emptyList();
        }

        // Embaralha as perguntas
        Collections.shuffle(perguntas);

        // Obtém apenas as 5 primeiras perguntas (ou menos se houver menos de 5 perguntas cadastradas)
        int numPerguntas = Math.min(5, perguntas.size());
        return perguntas.subList(0, numPerguntas);
    }
}





////Lógica para gerar um novo quiz: Você pode ter um método que seja responsável por criar um novo quiz, selecionando perguntas aleatórias da 
//base de perguntas. Esse método pode retornar um objeto contendo as perguntas e suas opções.
////
////Validação das respostas do usuário: Você pode ter um método que valide as respostas fornecidas pelo usuário durante o quiz. Esse método 
//pode comparar as respostas com as respostas corretas armazenadas na base de perguntas e calcular a pontuação do usuário.
////
////Cálculo da pontuação total: Você pode ter um método que calcule a pontuação total do usuário com base nas respostas corretas fornecidas.
//Esse método pode considerar o valor de cada pergunta e somá-los para obter a pontuação final.
////
////Atualização do ranking: Quando um usuário finaliza o quiz, você pode ter um método responsável por atualizar o ranking com a pontuação 
//do usuário. Esse método pode chamar os métodos da classe RankingPersistencia para realizar a inclusão ou atualização do registro do usuário 
//no ranking.