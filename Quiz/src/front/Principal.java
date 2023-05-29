package front;

import entidades.User;
import front.Console;
import persistencia.UserPersistencia;

public class Principal {

	public static void main(String[] args) {
		User objCliente = new User();
		objCliente.setNome(Console.readString("\n\nInforme o nome do player: "));
				UserPersistencia.incluir(objCliente);
				System.out.println("\n\nInclusão bem sucedida...");

	}
}
