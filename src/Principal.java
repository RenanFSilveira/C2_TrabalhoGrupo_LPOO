import java.util.ArrayList;
import java.util.Random;

public class Principal {
    public static void main(String[] args) {
        ArrayList<Jogador> jogadores = new ArrayList<>();
        ArrayList<Carta> baralho = new ArrayList<>();

        criaJogadoresECartas(jogadores, baralho);
        statusParcial(jogadores, "INICIAL");
        while (Carta.cartasJogadas < 30 && verificaVivos(jogadores) > 1) {
            compraCartas(jogadores, baralho);
        }
    }

    public static void criaJogadoresECartas(ArrayList<Jogador> jogadores, ArrayList<Carta> baralho) {
        jogadores.add(new Jogador("Joao", 2, 50));
        jogadores.add(new Jogador("Maria", 2, 50));

        // Cartas de Ataque com poderes: 10, 20, 30, 40
        baralho.add(new CartaAtaque("Flecha", 10));
        baralho.add(new CartaAtaque("Tiro", 20));
        baralho.add(new CartaAtaque("Explosão", 30));
        baralho.add(new CartaAtaque("Chinelada", 40));

        // Cartas de Defesa com poderes: 10, 15, 20
        baralho.add(new CartaDefesa("Escudo", 10));
        baralho.add(new CartaDefesa("Armadura", 15));
        baralho.add(new CartaDefesa("Reza de mãe", 20));
    }

    public static int verificaVivos(ArrayList<Jogador> jogadores) {
        int jogadoresVivos = 0;
        for (Jogador jogador : jogadores) {
            if (jogador.estaVivo()) {
                jogadoresVivos++;
            }
        }
        return jogadoresVivos;
    }

    public static void statusParcial(ArrayList<Jogador> jogadores, String tipoStatus) {
        System.out.println("=========== STATUS " + tipoStatus + " ===========");
        for (Jogador jogador : jogadores) {
            System.out.println("Jogador: " + jogador.getNome() + "\nVida(s): " + jogador.getVida() + "\nEscudo: "
                    + jogador.getDefesa() + "\n");
        }
    }

    public static void novaRodada(ArrayList<Jogador> jogadores, ArrayList<Carta> baralho) {
        int numeroSorteado;
        Random sorteadorRandom = new Random();
        numeroSorteado = sorteadorRandom.nextInt(7);
    }
}
