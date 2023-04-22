package encriptação;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class ProgramaEncriptacao {

	private Scanner sc;
	@SuppressWarnings("unused")
	private Random random;
	private ArrayList<Character> list;
	private ArrayList<Character> shuffledList;
	private char character;

	private char[] letras;

	ProgramaEncriptacao() {

		sc = new Scanner(System.in);
		random = new Random();
		list = new ArrayList<Character>();
		shuffledList = new ArrayList<Character>();
		character = ' ';

		newKey();
		askQuestion();
	}

	private void askQuestion() {

		while (true) {
			System.out.println("************************************************************");
			System.out.println("O que voce quer fazer?");
			System.out.println("(N)ewKey, (G)etKey, (E)ncriptar, (D)ecriptar, (S)air");
			char resposta = Character.toUpperCase(sc.nextLine().charAt(0));

			switch (resposta) {
			case 'N':
				newKey();
				break;

			case 'G':
				getKey();
				break;

			case 'E':
				encrypt();
				break;

			case 'D':
				decrypt();
				break;

			case 'S':
				quit();
				break;

			default:
				System.out.println("Não é uma resposta valida >:)");
			}
		}
	}

	private void newKey() {

		character = ' ';
		list.clear();
		shuffledList.clear();

		for (int i = 32; i < 127; i++) {
			list.add(Character.valueOf(character));
			character++;
		}

		shuffledList = new ArrayList(list);
		Collections.shuffle(shuffledList);
		System.out.println("*Uma nova chave foi gerada*");
	}

	private void getKey() {

		System.out.println("Chave: ");
		for (Character x : list) {
			System.out.print(x);
		}
		System.out.println();
		for (Character x : shuffledList) {
			System.out.print(x);
		}
		System.out.println();
	}

	private void encrypt() {
		System.out.println("Escreva a mensagem a ser encriptada: ");
		String message = sc.nextLine();

		letras = message.toCharArray();

		for (int i = 0; i < letras.length; i++) {

			for (int j = 0; j < list.size(); j++) {
				if (letras[i] == list.get(j)) {
					letras[i] = shuffledList.get(j);
					break;
				}
			}
		}

		System.out.println("Encriptada: ");
		for (char x : letras) {
			System.out.print(x);
		}
		System.out.println();
	}

	private void decrypt() {
		System.out.println("Escreva a mensagem a ser decriptada: ");
		String message = sc.nextLine();

		letras = message.toCharArray();

		for (int i = 0; i < letras.length; i++) {

			for (int j = 0; j < shuffledList.size(); j++) {
				if (letras[i] == shuffledList.get(j)) {
					letras[i] = list.get(j);
					break;
				}
			}
		}

		System.out.println("Decriptada: ");
		for (char x : letras) {
			System.out.print(x);
		}
		System.out.println();
	}

	private void quit() {
		System.out.println("Vai com Deus");
		System.exit(0);
	}
}
