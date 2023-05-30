package front;
import java.util.List;

import entidades.Pergunta;
import entidades.User;
import persistencia.PerguntasPersistencia;
import persistencia.UserPersistencia;


public class Principal {
	public static void main(String[] args) {
        int opc;
        do {
            System.out.println("--------MENU--------");
            System.out.println("1 - Jogadores");
            System.out.println("2 - Perguntas");
            System.out.println("3 - Jogar");
            System.out.println("4 - Sair");
            opc = Console.readInt("Opção: ");

            switch (opc) {
                case 1:
                    do {
                        System.out.println("--------JOGADORES--------");
                        System.out.println("1 - Cadastrar jogador");
                        System.out.println("2 - Listar jogadores");
                        System.out.println("3 - Atualizar jogador");
                        System.out.println("4 - Deletar Jogador");
                        System.out.println("5 - Sair");

                        opc = Console.readInt("Opção: ");
                        switch (opc) {
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
                                int id = Console.readInt("ID do jogador a ser atualizado: ");
                                User jogadorAtualizar = UserPersistencia.getUsuarioPorId(id);
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
                        		if(objJogador1 != null) {                    			
                        			System.out.println("ID: " + objJogador1.getId());
                        			System.out.println("Nome: " + objJogador1.getNome());
                        			String resp = Console.readString("\n\nQuer excluir? ");
                        			if(resp.equals("S")) {
                        				if(UserPersistencia.excluir(objJogador1) == true) {
                        					System.out.println("\n\nA exclusão foi realizada...");
                        				}
                        				else {
                        					System.out.println("\n\nA exclusão não pôde ser realizada no momento...");
                        				}
                        			}
                        		}
                        		else {
                        			System.out.println("\n\nnão encontrado...");
                        		}
                                break;
                            case 5:
                                break;
                        }
                    } while (opc != 5);
                    break;

                case 2:
                    do {
                        System.out.println("--------PERGUNTAS--------");
                        System.out.println("1 - Cadastrar pergunta");
                        System.out.println("2 - Listar pergunta");
                        System.out.println("3 - Atualizar pergunta");
                        System.out.println("4 - Deletar pergunta");
                        System.out.println("5 - Sair");

                        opc = Console.readInt("Opção: ");
                        switch (opc) {
                        case 1:
                            Pergunta objPergunta = new Pergunta();
                            objPergunta.setDescricao(Console.readString("Qual a pergunta: "));
                            
                            String[] alternativas = new String[4];
                            for (int i = 0; i < alternativas.length; i++) {
                                alternativas[i] = Console.readString("Alternativa " + (i + 1) + ": ");
                            }
                            objPergunta.setAlternativas(alternativas);
                            
                            
                            System.out.println("Escolha a alternativa correta:");
                            objPergunta.imprimirAlternativas();
                            
                          
                            int correta = Console.readInt("Opção: ");
                            objPergunta.setCorreta(correta - 1); 
                            
                            
                            int valor = Console.readInt("Valor da pergunta: ");
                            objPergunta.setValor(valor);
                            
                            PerguntasPersistencia.incluir(objPergunta);
                            break;

                            case 2:
                                PerguntasPersistencia.listarPerguntas();
                                break;
                            case 3:
                            	int id = Console.readInt("ID da pergunta a ser atualizad: ");
                                Pergunta pergunta = PerguntasPersistencia.getPerguntaPorId(id);
                                if (pergunta != null) {
                                	pergunta.setDescricao(Console.readString("Nova Descrição: "));
                                	pergunta.setValor(Console.readInt("Novo valor: "));
                                }
                                break;
                            case 4:
                            	Pergunta objPergunta2 = new Pergunta();
                            	int idd = Console.readInt("ID da pergunta a ser atualizad: ");
                                objPergunta2 = PerguntasPersistencia.getPerguntaPorId(idd);
                                if (objPergunta2 != null) {
                                	PerguntasPersistencia.excluir(objPergunta2);
                                }
                                break;
                            case 5:
                                break;
                        }
                    } while (opc != 5);
                    break;

                case 3:
                	//jogar
                    break;
                case 4:
                    break;
            }
        } while (opc != 4);
    }
}
