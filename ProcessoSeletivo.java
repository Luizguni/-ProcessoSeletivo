package Candidatura; // Define o pacote onde est� localizada a classe

import java.util.Random; // Importa classe utilit�ria para gera��o de n�meros aleat�rios simples
import java.util.concurrent.ThreadLocalRandom; // Importa utilit�rio para gerar n�meros aleat�rios com seguran�a em ambientes concorrentes

public class ProcessoSeletivo {

	public static void main(String[] args) {
		// Lista de candidatos para tentar contato
		String[] candidatos = { "Guni", "Vanessa" };

		// Tenta entrar em contato com cada candidato da lista
		for (String candidato : candidatos) {
			entrandoEmContato(candidato);
		}
	}

	// M�todo que simula o processo de contato com o candidato
	static void entrandoEmContato(String candidato) {
		int tentativasRealizadas = 1; // Contador de tentativas de contato
		boolean continuarTentando = true; // Flag para controle do la�o
		boolean atendeu = false; // Indica se o candidato atendeu ou n�o

		// Tenta contato at� que o candidato atenda ou o n�mero de tentativas chegue a 3
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
			System.out.println("CONTATO FEITO COM " + candidato + " NA " + tentativasRealizadas + "� TENTATIVA");
		else
			System.out.println("N�O CONSEGUIMOS CONTATO COM " + candidato + ". N�MERO M�XIMO DE TENTATIVAS ("
					+ tentativasRealizadas + ") REALIZADO.");
	}

	// M�todo auxiliar que simula a chance de o candidato atender (1 em 3 chances)
	static boolean atender() {
		return new Random().nextInt(3) == 1;
	}

	// M�todo que imprime os candidatos selecionados usando dois tipos de la�o
	static void imprimirSelecionados() {
		String[] candidatos = { "Guni", "Vanessa" };

		System.out.println("Impress�o da lista de candidatos pelo �ndice:");
		// Itera usando �ndice
		for (int indice = 0; indice < candidatos.length; indice++) {
			System.out.println("O candidato de n� " + (indice + 1) + " � " + candidatos[indice]);
		}

		System.out.println("Forma abreviada de intera��o (for-each):");
		// Itera diretamente sobre os elementos
		for (String candidato : candidatos) {
			System.out.println("O candidato selecionado foi " + candidato);
		}
	}

	// M�todo que simula a sele��o de candidatos com base no sal�rio pretendido
	static void selecaoCandidatos() {
		String[] Candidatos = { "Guni", "Vanessa", "Theo", "Jesus" };

		int candidatosSelecionados = 0; // Contador de candidatos aprovados
		int candidatosAtual = 0; // �ndice do candidato atual na lista
		double salarioBase = 2000.0; // Sal�rio oferecido pela empresa

		// Continua o processo at� selecionar 4 candidatos ou acabar a lista
		while (candidatosSelecionados < 4 && candidatosAtual < Candidatos.length) {
			String candidato = Candidatos[candidatosAtual]; // Obt�m nome do candidato
			double salarioPretendido = valorPretendido(); // Gera sal�rio pretendido aleat�rio

			// Exibe proposta do candidato
			System.out.println("O candidato " + candidato + " solicitou este valor de sal�rio: " + salarioPretendido);

			// Verifica se a proposta � aceit�vel
			if (salarioBase >= salarioPretendido) {
				System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
				candidatosSelecionados++;
			}

			candidatosAtual++;
		}
	}

	// Gera um valor aleat�rio entre 1800 e 2200 para representar o sal�rio
	// pretendido
	static double valorPretendido() {
		return ThreadLocalRandom.current().nextDouble(1800.0, 2200.0);
	}

	// Analisa se a proposta de sal�rio de um candidato � aceit�vel
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
