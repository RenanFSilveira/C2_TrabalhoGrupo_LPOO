import  interfaces.iJogavel;

public class Jogador implements iJogavel{
    private String nome;
    private int vida = 2;
    private int defesa = 50;

    // Construtores
    public Jogador(String nome, int vida, int defesa) {
        this.nome = nome;
        this.vida = vida;
        this.defesa = defesa;
    }

    public Jogador() {
        this.nome = "";
        this.vida = 2;
        this.defesa = 50;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public int getDefesa() {
        return defesa;
    }

    // Faltando: Métodos da classe Jogavel.
    public void atacar(int poder){
        this.defesa -= poder;

        if (this.defesa <= 0){
            this.vida --;
            this.defesa += 100;
        }
     };

    public void defender(int poder){
        this.defesa += poder;
    };

    public boolean estaVivo(){
        return this.vida > 0 || this.defesa > 0;
    };
}   
