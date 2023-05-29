package front;

import entidades.User;
import front.Console;
import persistencia.UserPersistencia;

public class Principal {
	public static void main(String[] args) {
		int opc;
		do{
			System.out.println("--------MENU--------");
			System.out.println("1 - Cadastrar Jogador");
			System.out.println("2 - Cadastrar Perguntas");
			System.out.println("3 - Jogar");
			System.out.println("4 - Sair");
			opc = Console.readInt("Opção: ");
			switch(opc){
				case 1:
					User objJogador = new User();
					//fazer metodo para verificar se o nome e a senha JUNTOS ja foi cadastrado
					objJogador.setNome(Console.readString("Nome: "));
					objJogador.setSenha("Crie uma senha: ");
					break;
				case 2:
					
					break;
			}
		}while(opc != 3);
	}
}
