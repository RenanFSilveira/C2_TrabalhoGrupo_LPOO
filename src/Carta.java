
public abstract class Carta {
    // Atributo de classe: Static, é somente da classe. Protected: Visibilidade em todas as herdeiras e nas do mesmo pacote.
    private String nome;
    private int poder;
    protected static int cartasJogadas;

    // Construtores
    public Carta(String nome, int poder ) {
        this.nome = nome;
        this.poder = poder;        
    }

    public Carta() {
        this.nome = "";
        this.poder = 0;
    }

    // Getts
    public String getNome() {
        return nome;
    }

    public int getPoder() {
        return poder;
    }

    public static int getCartasJogadas() {
        return cartasJogadas;
    }

    // ToString
    @Override
    public String toString() {
        return "Carta: Nome = " + nome + ", poder = " + poder;
    }

    public abstract void jogar(Jogador jogadorDaVez, Jogador jogadorAtacado);
    
    
}
