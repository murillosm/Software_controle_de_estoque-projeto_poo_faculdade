package estoque;

import model.entities.Usuario;

public class ClassPrincipal {

	public static void main(String[] args) {
		Usuario u = new Usuario("12111567811");
		//u.setCpfUser("12311567811");
		System.out.print(u.getCpfUser());
		//u.imprimir();
		
	
	}
}
