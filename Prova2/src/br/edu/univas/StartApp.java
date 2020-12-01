package br.edu.univas;

import java.util.Scanner;

public class StartApp {
	static Scanner reading = new Scanner(System.in);
	static Conta[] contas = new Conta[100];
	static int count = 0;

	public static void main(String[] args) {

		int opcao = 0;
		do {
			listOpetions();
			opcao = reading.nextInt();
			switch (opcao) {
			case 1:
				cadastro();
				break;
			case 2:
				verSaldo();
				break;
			case 3:
				break;
			default:
				System.out.println("Opção inválida.");
				break;
			}

		} while (opcao != 3);

		System.out.println("Fim");

	}

	private static void cadastro() {
		Conta c = new Conta();
		System.out.println("Descrição da conta: ");
		c.descricao = reading.next();
		reading.nextLine();
		System.out.println("Valor: ");
		c.valor = reading.nextFloat();
		reading.nextLine();
		System.out.println("Data de Vencimento: ");
		c.dataVencimento = reading.next();
		reading.nextLine();
		System.out.println("Tipo da conta: dispesa/receita");
		c.tipo = reading.next();
		reading.nextLine();

		contas[count] = c;
		count++;

	}

	private static void verSaldo() {
		float cD = 0, cR = 0;
		for (int i = 0; i < count; i++) {
			if (contas[i].tipo.equals("dispesa")) {
				cD += contas[i].valor;
			} else {
				cR += contas[i].valor;
			}
		}
		System.out.println("Saldo: " + (cR - cD));
	}

	static void listOpetions() {
		System.out.println("Escolhe uma opção do menu:");
		System.out.println("1 – Cadastrar conta");
		System.out.println("2 – Ver Saldo");
		System.out.println("3 – Sair");
		System.out.println();
	}

}
