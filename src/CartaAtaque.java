public class CartaAtaque extends Carta {

    public CartaAtaque(String nome, int poder){
        super(nome, poder);
    }

    @Override
    public void jogar(Jogador jogadorDaVez, Jogador inimigo){
        inimigo.atacar(this.getPoder());
        Carta.cartasJogadas++;
        
    }
}
