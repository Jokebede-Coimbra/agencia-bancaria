package entities;

import utilitarios.Utils;

public class Conta {

	private static Integer contadorContas = 1;

	private Integer numeroConta;
	private Double saldo = 0.0;
	private Pessoa pessoa;

	public Conta(Pessoa pessoa) {
		this.numeroConta = contadorContas;
		this.pessoa = pessoa;
		contadorContas += 1;
	}

	public Integer getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(Integer numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public void depositar(Double valor) {
		if (valor > 0) {
			setSaldo(getSaldo() + valor);
			System.out.println("Seu depósito foi realizado com sucesso!");
		} else {
			System.out.println("Não foi possível realizar o depósito!");
		}
	}

	public void sacar(Double valor) {
		if (valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			System.out.println("Saque realizado com sucesso!");
		} else {
			System.out.println("Não foi possível realizar o saque!");
		}
	}

	public void transferir(Conta contaDestino, Double valor) {
		if (valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			contaDestino.saldo = contaDestino.getSaldo() + valor;
			System.out.println("Transferência realizado com sucesso!");
		} else {
			System.out.println("Não foi possível realizar a transferência!");
		}
	}
	
	public void cancelarConta() {
		
	}

	@Override
	public String toString() {
		return "\nNumero da Conta:" + this.getNumeroConta() + "\nNome:" + pessoa.getNome() + "\nCpf:" + pessoa.getCpf()
				+ "\nE-mail:" + pessoa.getEmail() + "\nSaldo = " + Utils.doubleToString(this.getSaldo());
	}

}
