import java.util.ArrayList;
import java.util.Random;

public class Principal {
    public static void main(String[] args) {
        ArrayList<Jogador> jogadores = new ArrayList<>();
        ArrayList<Carta> baralho = new ArrayList<>();

        criaJogadoresECartas(jogadores, baralho);
        status(jogadores, "INICIAL");
        iniciarJogo(jogadores, baralho);
        statusFinal(jogadores);
    }

    public static void criaJogadoresECartas(ArrayList<Jogador> jogadores, ArrayList<Carta> baralho) {
        jogadores.add(new Jogador("Joao"));
        jogadores.add(new Jogador("Maria"));

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

    public static void status(ArrayList<Jogador> jogadores, String tipoStatus) {
        System.out.println("\n=========== STATUS " + tipoStatus + " ===========\n");
        for (Jogador jogador : jogadores) {

            System.out.println("Jogador: " + jogador.getNome() + "\nVida(s): " + jogador.getVida() + "\nEscudo: "
                    + jogador.getDefesa() + "\n");
        }
    }

    public static void statusFinal(ArrayList<Jogador> jogadores) {
        Jogador j1 = jogadores.get(0);
        Jogador j2 = jogadores.get(1);
        Jogador vencedor = null;
        
        System.out.println("=========== Fim Do Jogo ===========\n");

        if (verificaVivos(jogadores) == 1) {
            vencedor = j1.estaVivo() ? j1 : j2;
        } else {
            if (j1.getVida() > j2.getVida()) {
                vencedor = j1;
            } else if (j2.getVida() > j1.getVida()) {
                vencedor = j2;
            } else {
                if (j1.getDefesa() > j2.getDefesa()) {
                    vencedor = j1;
                } else if (j2.getDefesa() > j1.getDefesa()) {
                    vencedor = j2;
                }
            }
        }
        
        System.out.println("Vencedor do jogo: " + (vencedor != null ? vencedor.getNome() : "Empate.")  + "\nTotal de cartas jogadas: " + Carta.cartasJogadas);

    }

    public static void iniciarJogo(ArrayList<Jogador> jogadores, ArrayList<Carta> baralho) {
        
        Random sorteadorRandom = new Random();

        Jogador j1 = jogadores.get(0);
        Jogador j2 = jogadores.get(1);

        int numeroSorteado;
        Carta cartaSelecionada;

        while (Carta.cartasJogadas < 30 && verificaVivos(jogadores) > 1) {

            numeroSorteado = sorteadorRandom.nextInt(baralho.size());
            cartaSelecionada = baralho.get(numeroSorteado);
            if (cartaSelecionada instanceof CartaAtaque) {
                System.out.println(j1.getNome() + " atacou " + j2.getNome() + " com a carta: ("
                        + cartaSelecionada.getNome() + " | Poder: "
                        + cartaSelecionada.getPoder() + ")");
            } else {
                System.out.println(j1.getNome() + " se curou com a carta: (" + cartaSelecionada.getNome() + " | Poder: "
                        + cartaSelecionada.getPoder() + ")");
            }

            cartaSelecionada.jogar(j1, j2);

            if (j2.estaVivo()) {
                numeroSorteado = sorteadorRandom.nextInt(baralho.size());
                cartaSelecionada = baralho.get(numeroSorteado);
                if (cartaSelecionada instanceof CartaAtaque) {
                    System.out.println(j2.getNome() + " atacou " + j1.getNome() + " com a carta: ("
                            + cartaSelecionada.getNome() + " | Poder: "
                            + cartaSelecionada.getPoder() + ")");
                } else {
                    System.out.println(j2.getNome() + " se curou com a carta: (" + cartaSelecionada.getNome() + " | Poder: "
                                    + cartaSelecionada.getPoder() + ")");
                }
                cartaSelecionada.jogar(j2, j1);

            } else {
                System.out.println(j2.getNome() + " não jogou pois ela está morta.");
            }
            status(jogadores, "PARCIAL");
        }

    }

}