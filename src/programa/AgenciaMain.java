package programa;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Conta;
import entities.Pessoa;

public class AgenciaMain {

	static Scanner sc = new Scanner(System.in);

	// Preciso de uma lista de conta, porque agencia têm várias contas.
	static ArrayList<Conta> contasBancarias;

	public static void main(String[] args) {

		contasBancarias = new ArrayList<Conta>();
		operacoes();

		sc.close();

	}

	public static void operacoes() {
		System.out.println("===========================================================");
		System.out.println("======================Hello Bank===========================");
		System.out.println("===========================================================");
		System.out.println("---------------- Escolha uma opção ----------------------- ");
		System.out.println("===========================================================");
		System.out.println("| 1 - Criar conta  |");
		System.out.println("| 2 - Depositar    |");
		System.out.println("| 3 - Sacar        |");
		System.out.println("| 4 - Transferir   |");
		System.out.println("| 5 - Listar       |");
		System.out.println("| 6 - Sair         |");
		System.out.println("===========================================================");

		int operacao = sc.nextInt();

		switch (operacao) {
		case 1:
			criarConta();
			break;
		case 2:
			depositar();
			break;
		case 3:
			sacar();
			break;
		case 4:
			transferir();
			break;
		case 5:
			listarContas();
			break;
		case 6:
			System.out.println("Obrigado.");
			System.exit(0);
			break;
		default:
			System.out.println("Opção inválida!.");
			operacoes();
			break;
		}

	}

	public static void criarConta() {
		System.out.println("Nome: ");
		String nome = sc.next();
		System.out.println("Cpf: ");
		String cpf = sc.next();
		System.out.println("E-mail: ");
		String email = sc.next();

		Pessoa pessoa = new Pessoa(email, email, email);
		Conta conta = new Conta(pessoa);
		contasBancarias.add(conta);
		System.out.println("Sua conta foi criada com sucesso!");

		operacoes();
	}

	public static Conta encontrarConta(int numeroConta) {
		Conta conta = null;
		if (contasBancarias.size() > 0) {
			for (Conta c : contasBancarias) {
				if (c.getNumeroConta() == numeroConta) {
					conta = c;
				}
			}
		}
		return conta;

	}

	public static void depositar() {
		System.out.println("Número da conta: ");
		int numeroConta = sc.nextInt();

		Conta conta = encontrarConta(numeroConta); 

		if (conta != null) {
			System.out.println("Qual o valor deseja depositar? ");
			Double valorDeposito = sc.nextDouble();
			conta.depositar(valorDeposito);
		} else {
			System.out.println("Conta inexistente!");
		}
		operacoes();
	}

	public static void sacar() {
		System.out.println("Número da conta: ");
		int numeroConta = sc.nextInt();

		Conta conta = encontrarConta(numeroConta);

		if (conta != null) {
			System.out.println("Qual valor deseja sacar? ");
			Double valorSaque = sc.nextDouble();
			conta.sacar(valorSaque);
		} else {
			System.out.println("Conta inexistente!");
		}
		operacoes();
	}

	public static void transferir() {
		System.out.println("Número da conta do remetente: ");
		int numeroContaRemetente = sc.nextInt();

		Conta contaRemetente = encontrarConta(numeroContaRemetente);

		if (contaRemetente != null) {
			System.out.println("Qual o número da conta do destinatário: ");
			int destinatario = sc.nextInt();

			Conta contaDestinatario = encontrarConta(destinatario);

			if (contaDestinatario != null) {
				System.out.println("Valor da transferência: ");
				Double valorTransferencia = sc.nextDouble();

				contaRemetente.transferir(contaDestinatario, valorTransferencia);
			} else {
				System.out.println("A conta para depósito não foi encontrada.");
			}
		} else {
			System.out.println("A conta para tranferência não foi encontrada.");
		}
		operacoes();
	}

	public static void listarContas() {
		if (contasBancarias.size() > 0) {
			for (Conta conta : contasBancarias) {
				System.out.println(conta);
			}
		} else {
			System.out.println("Não existe contas cadastradas!");
		}
		operacoes();
	}
}
