// TODO: 19/02/2024
//  Crie uma sobrecarga do jogar() que será um novo jogo, esse deve receber
//  um número, jogar(int num). O jogo consiste em o jogador escolher um número
//  de 0 até ‘num’(numero colocado no parâmetro). Se acertar ganha um ponto,
//  se errar ele perde um ponto. Tanto o número 'num', quanto o valor que o
//  jogador escolher no jogo devem ser coletado por input no console.


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Jogo {
    Random rand = new Random();
    private int limite = 3;
    private int escolhaComp = rand.nextInt(limite) +1;
    private static String melhorJogador;
    private static int numeroJogadas = 0;
    private static int getNumeroJogadas = 0;

    public static int getNumeroJogadas() {
        return numeroJogadas;
    }

    public static void setNumeroJogadas() {
        Jogo.numeroJogadas++;
    }

    public static String getMelhorJogador() {
        return melhorJogador;
    }

    public static void setMelhorJogador(String melhorJogador) {
        Jogo.melhorJogador = melhorJogador;
    }

    public void jogar(int jogador, ArrayList<Jogador> ranking) {

        Scanner entrada = new Scanner(System.in);
        Mensagens.menuPedraPapelTesoura();
        System.out.print("Digite a sua opção: ");
        int opcao2 = entrada.nextInt();
        if (opcao2 == 0) {
            return;
        }
        System.out.println("Computador escolheu " + escolhaComp +".");
        if (escolhaComp == opcao2){
            System.out.println("Empate");
        } else
        if ((escolhaComp - opcao2 == -1) || (escolhaComp - opcao2 == 2)) {
            System.out.println("Você Venceu!");
            ranking.get(jogador).adicionarPontos();
        } else {
            System.out.println("Você Perdeu!");
        }
        ranking.get(jogador).adicionarTentativa();
        System.out.println("Jogador: " + ranking.get(jogador).getNome());
        System.out.println("Pontos: " + ranking.get(jogador).getPontuacao());
        System.out.println("Tentativas: " + ranking.get(jogador).getNumeroTentativas());
    }

    public void jogar(int jogador, ArrayList<Jogador> ranking, int limite) {
        int numeroOculto = rand.nextInt(10);
        Scanner entrada = new Scanner(System.in);
        int chances = 10;


        while (chances > 0) {
            Mensagens.menuJogoAdivinhaNumero(chances);
            int chute = entrada.nextInt();
            chances--;

            if (chute == numeroOculto) {
                System.out.println("Você adivinhou!");
                ranking.get(jogador).adicionarPontos();
                return;
            } else {
                System.out.println("você errou!");
                ranking.get(jogador).perderPontos(1);
                continue;
            }

        }
        if (chances == 0) {
            System.out.println("VOCÊ PERDEU!");
        }

        ranking.get(jogador).adicionarTentativa();

    }
}
