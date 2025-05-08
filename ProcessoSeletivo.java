package Candidatura; // Define o pacote onde está localizada a classe

import java.util.Random; // Importa classe utilitária para geração de números aleatórios simples
import java.util.concurrent.ThreadLocalRandom; // Importa utilitário para gerar números aleatórios com segurança em ambientes concorrentes

public class ProcessoSeletivo {

	public static void main(String[] args) {
		// Lista de candidatos para tentar contato
		String[] candidatos = { "Guni", "Vanessa" };

		// Tenta entrar em contato com cada candidato da lista
		for (String candidato : candidatos) {
			entrandoEmContato(candidato);
		}
	}

	// Método que simula o processo de contato com o candidato
	static void entrandoEmContato(String candidato) {
		int tentativasRealizadas = 1; // Contador de tentativas de contato
		boolean continuarTentando = true; // Flag para controle do laço
		boolean atendeu = false; // Indica se o candidato atendeu ou não

		// Tenta contato até que o candidato atenda ou o número de tentativas chegue a 3
		do {
			atendeu = atender(); // Simula tentativa de chamada
			continuarTentando = !atendeu;

			if (continuarTentando)
				tentativasRealizadas++;
			else
				System.out.println("CONTATO REALIZADO");
		} while (continuarTentando && tentativasRealizadas < 3);

		// Exibe o resultado final da tentativa de contato
		if (atendeu)
			System.out.println("CONTATO FEITO COM " + candidato + " NA " + tentativasRealizadas + "ª TENTATIVA");
		else
			System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato + ". NÚMERO MÁXIMO DE TENTATIVAS ("
					+ tentativasRealizadas + ") REALIZADO.");
	}

	// Método auxiliar que simula a chance de o candidato atender (1 em 3 chances)
	static boolean atender() {
		return new Random().nextInt(3) == 1;
	}

	// Método que imprime os candidatos selecionados usando dois tipos de laço
	static void imprimirSelecionados() {
		String[] candidatos = { "Guni", "Vanessa" };

		System.out.println("Impressão da lista de candidatos pelo índice:");
		// Itera usando índice
		for (int indice = 0; indice < candidatos.length; indice++) {
			System.out.println("O candidato de n° " + (indice + 1) + " é " + candidatos[indice]);
		}

		System.out.println("Forma abreviada de interação (for-each):");
		// Itera diretamente sobre os elementos
		for (String candidato : candidatos) {
			System.out.println("O candidato selecionado foi " + candidato);
		}
	}

	// Método que simula a seleção de candidatos com base no salário pretendido
	static void selecaoCandidatos() {
		String[] Candidatos = { "Guni", "Vanessa", "Theo", "Jesus" };

		int candidatosSelecionados = 0; // Contador de candidatos aprovados
		int candidatosAtual = 0; // Índice do candidato atual na lista
		double salarioBase = 2000.0; // Salário oferecido pela empresa

		// Continua o processo até selecionar 4 candidatos ou acabar a lista
		while (candidatosSelecionados < 4 && candidatosAtual < Candidatos.length) {
			String candidato = Candidatos[candidatosAtual]; // Obtém nome do candidato
			double salarioPretendido = valorPretendido(); // Gera salário pretendido aleatório

			// Exibe proposta do candidato
			System.out.println("O candidato " + candidato + " solicitou este valor de salário: " + salarioPretendido);

			// Verifica se a proposta é aceitável
			if (salarioBase >= salarioPretendido) {
				System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
				candidatosSelecionados++;
			}

			candidatosAtual++;
		}
	}

	// Gera um valor aleatório entre 1800 e 2200 para representar o salário
	// pretendido
	static double valorPretendido() {
		return ThreadLocalRandom.current().nextDouble(1800.0, 2200.0);
	}

	// Analisa se a proposta de salário de um candidato é aceitável
	static void analisarCandidato(double salarioPretendido) {
		double salarioBase = 2000.0;

		if (salarioPretendido < salarioBase) {
			System.out.println("LIGAR PARA O CANDIDATO");
		} else if (salarioPretendido == salarioBase) {
			System.out.println("LIGAR PARA O CANDIDATO E FAZER CONTRAPROPOSTA");
		} else {
			System.out.println("ELIMINAR CANDIDATO");
		}
	}
}
