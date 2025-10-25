public class CartaDefesa extends Carta {
    
    public CartaDefesa(String nome, int poder){
        super(nome, poder);
    }
    
    @Override
    public void jogar(Jogador jogadorDaVez, Jogador inimigo){
        jogadorDaVez.defender(this.getPoder());
        Carta.cartasJogadas++;
    }
}
