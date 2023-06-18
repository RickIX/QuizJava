package front;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import entidades.Pergunta;
import entidades.Ranking;
import entidades.User;
import persistencia.PerguntasPersistencia;
import persistencia.UserPersistencia;
import negocio.QuizNegocio;
import entidades.Ranking;
import persistencia.RankingPersistencia;
import java.util.Date;

public class Principal {
	public static void main(String[] args) {
		int opc;
		do {
			System.out.println("--------MENU--------");
			System.out.println("1 - Jogadores");
			System.out.println("2 - Perguntas");
			System.out.println("3 - Jogar");
			System.out.println("4 - Ranking de Jogadores");
			System.out.println("5 - Sair");
			opc = Console.readInt("Opção: ");

			switch (opc) {
			case 1:
				int opc3;
				do {
					System.out.println("--------JOGADORES--------");
					System.out.println("1 - Cadastrar jogador");
					System.out.println("2 - Listar jogadores");
					System.out.println("3 - Atualizar jogador");
					System.out.println("4 - Deletar Jogador");
					System.out.println("5 - Voltar");

					opc3 = Console.readInt("Opção: ");
					switch (opc3) {
					case 1:
						User objJogador = new User();
						objJogador.setNome(Console.readString("Nome: "));
						objJogador.setSenha(Console.readString("Senha: "));
						UserPersistencia persistencia = new UserPersistencia();
						persistencia.incluir(objJogador);
						break;
					case 2:
						List<User> usuarios = UserPersistencia.getUsuarios();
						for (User usuario : usuarios) {
							System.out.println("ID: " + usuario.getId());
							System.out.println("Nome: " + usuario.getNome());
							System.out.println("Senha: " + usuario.getSenha());
							System.out.println("Pontos: " + usuario.getPontos());
							System.out.println("-------------------------");
						}
						break;

					case 3:
						User jogadorAtualizar = new User();
						int id = Console.readInt("ID do jogador a ser atualizado: ");
						jogadorAtualizar = UserPersistencia.getUsuarioPorId(id);
						if (jogadorAtualizar != null) {
							jogadorAtualizar.setNome(Console.readString("Novo nome: "));
							jogadorAtualizar.setSenha(Console.readString("Nova senha: "));
							boolean atualizado = UserPersistencia.alterar(jogadorAtualizar);
							if (atualizado) {
								System.out.println("Jogador atualizado com sucesso.");
							} else {
								System.out.println("Falha ao atualizar jogador.");
							}
						} else {
							System.out.println("Jogador não encontrado.");
						}
						break;

					case 4:
						System.out.println("EXCLUSÃO");
						User objJogador1 = new User();
						objJogador1.setNome(Console.readString("nome do jogador a ser excluido: "));
						objJogador1 = UserPersistencia.encontrarPorNome(objJogador1.getNome());
						if (objJogador1 != null) {
							System.out.println("ID: " + objJogador1.getId());
							System.out.println("Nome: " + objJogador1.getNome());
							String resp = Console.readString("\n\nQuer excluir? ");
							if (resp.equals("S")) {
								if (UserPersistencia.excluir(objJogador1) == true) {
									System.out.println("\n\nA exclusão foi realizada...");
								} else {
									System.out.println("\n\nA exclusão não pôde ser realizada no momento...");
								}
							}
						} else {
							System.out.println("\n\nnão encontrado...");
						}
						break;
					case 5:
						break;
					}
				} while (opc3 != 5);
				break;

			case 2:
				int opc2;
				do {
					System.out.println("--------PERGUNTAS--------");
					System.out.println("1 - Cadastrar pergunta");
					System.out.println("2 - Listar pergunta");
					System.out.println("3 - Atualizar pergunta");
					System.out.println("4 - Deletar pergunta");
					System.out.println("5 - Voltar");

					opc2 = Console.readInt("Opção: ");
					switch (opc2) {
					case 1:
						Pergunta objPergunta = new Pergunta();
						objPergunta.setDescricao(Console.readString("Qual a pergunta: "));

						objPergunta.setA(Console.readString("Alternativa A :"));
						objPergunta.setB(Console.readString("Alternativa B :"));
						objPergunta.setC(Console.readString("Alternativa C :"));
						objPergunta.setD(Console.readString("Alternativa D :"));
						objPergunta.setCorreta(Console.readString("Qual a alternativa correta: "));

						int valor = Console.readInt("Valor da pergunta: ");
						objPergunta.setValor(valor);

						PerguntasPersistencia.incluir(objPergunta);
						break;

					case 2:
						List<Pergunta> perguntas = PerguntasPersistencia.listarPerguntas();
						for (Pergunta pergunta : perguntas) {
							System.out.println("ID: " + pergunta.getId());
							System.out.println("Descrição: " + pergunta.getDescricao());
							System.out.println("Alternativa A: " + pergunta.getA());
							System.out.println("Alternativa B: " + pergunta.getB());
							System.out.println("Alternativa C: " + pergunta.getC());
							System.out.println("Alternativa D: " + pergunta.getD());
							System.out.println("Correta: " + pergunta.getCorreta());
							System.out.println("Valor da pergunta: " + pergunta.getValor());
							System.out.println("-------------------------");
						}
						break;
					case 3:
						Pergunta pergunta = new Pergunta();
						int id = Console.readInt("ID da pergunta a ser atualizada: ");
						pergunta = PerguntasPersistencia.getPerguntaPorId(id);
						if (pergunta != null) {
							pergunta.setDescricao(Console.readString("Nova Descrição: "));
							pergunta.setA(Console.readString("Novo valor para A: "));
							pergunta.setB(Console.readString("Novo valor para B: "));
							pergunta.setC(Console.readString("Novo valor para C: "));
							pergunta.setD(Console.readString("Novo valor para D: "));
							pergunta.setCorreta(Console.readString("Qual a nova alternativa correta: "));
							pergunta.setValor(Console.readInt("Quanto a questão vale: "));
							boolean atualizado = PerguntasPersistencia.alterar(pergunta);

						} else {
							System.out.println("não foi possivel atualizar a pergunta");
						}

						break;
					case 4:
						Pergunta objPergunta2 = new Pergunta();
						int idd = Console.readInt("ID da pergunta que quer deletar: ");
						objPergunta2 = PerguntasPersistencia.getPerguntaPorId(idd);
						if (objPergunta2 != null) {
							PerguntasPersistencia.excluir(objPergunta2);
						}
						break;
					case 5:
						break;
					}
				} while (opc2 != 5);
				break;

			case 3:
				// Obtém a lista de perguntas
				List<Pergunta> perguntas = PerguntasPersistencia.listarPerguntas();

				// Verifica se há perguntas cadastradas
				if (perguntas.isEmpty()) {
					System.out.println("Não há perguntas cadastradas.");
					break;
				}

				// Obtém o jogador
				System.out.println("----------LOGIN----------");
				String nome = Console.readString("nome: ");
				String senha = Console.readString("senha: ");
				User jogador = UserPersistencia.login(nome, senha);

				// Verifica se o jogador existe
				if (jogador == null) {
					System.out.println("Jogador não encontrado.");
					break;
				}

				int pontuacao = 0;

				
				
				
				// Obtém a lista de perguntas embaralhadas
				List<Pergunta> perguntasEmbaralhadas = QuizNegocio.embaralharPerguntas();

				// Verifica se há perguntas suficientes para o jogo
				if (perguntasEmbaralhadas.isEmpty()) {
				    System.out.println("Não há perguntas suficientes para jogar.");
				    break;
				}
				
				
				// Itera sobre as perguntas
				for (Pergunta pergunta : perguntasEmbaralhadas) {
					System.out.println("Pergunta:");
					System.out.println(pergunta.getDescricao());
					System.out.println("Alternativa A: " + pergunta.getA());
					System.out.println("Alternativa B: " + pergunta.getB());
					System.out.println("Alternativa C: " + pergunta.getC());
					System.out.println("Alternativa D: " + pergunta.getD());

					// Obtém a resposta do usuário
					String resposta = Console.readString("Resposta: ");

					// Verifica se a resposta está correta
					if (resposta.equals(pergunta.getCorreta())) {
						pontuacao += pergunta.getValor();
						System.out.println("Resposta correta! Pontuação atual: " + pontuacao);
					} else {
						System.out.println("Resposta incorreta!");
					}
				}

				Date dataAtual = new Date();

				// Atualiza a pontuação do jogador
				jogador.setPontos(jogador.getPontos() + pontuacao);
				boolean atualizado = UserPersistencia.alterar(jogador);

				// Criar objeto Ranking com nome do jogador, pontuação e data atual
				Ranking rankingJogador = new Ranking();
				rankingJogador.setId(jogador.getId());
				rankingJogador.setNome(nome);
				rankingJogador.setPontuacao(pontuacao);
				rankingJogador.setDataa(dataAtual);
				

				// Incluir jogador no ranking
				// Incluir jogador no ranking
				boolean inclusaoSucesso;
				try {
				    inclusaoSucesso = RankingPersistencia.incluir(rankingJogador);
				    if (inclusaoSucesso) {
				        System.out.println("Jogador incluído no ranking com sucesso!");
				    } else {
				        System.out.println("Falha ao incluir jogador no ranking.");
				    }
				} catch (Exception e) {
				    System.out.println("Erro ao incluir jogador no ranking:");
				    
				}


				break;
			case 4:
			    List<Ranking> rankings = RankingPersistencia.listarRankings();
			    
			    if (rankings.isEmpty()) {
			        System.out.println("Não há jogadores no ranking.");
			    } else {
			        System.out.println("Jogadores no ranking:");
			        for (Ranking ranking : rankings) {
			            System.out.println("Nome: " + ranking.getNome());
			            System.out.println("Pontuação: " + ranking.getPontuacao());
			            System.out.println("Data: " + ranking.getDataa());
			            System.out.println("------------------------");
			        }
			    }
			    
			    break;


			case 5:
				break;
			}
		} while (opc != 5);
	}
}
