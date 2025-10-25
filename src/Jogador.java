import  interfaces.iJogavel;

public class Jogador implements iJogavel{
    private String nome;
    private int vida = 2;
    private int defesa = 50;

    // Construtores
    public Jogador(String nome) {
        this.nome = nome;
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
        return this.vida >= 0 && this.defesa > 0;
    };
}   
