package controle;

// Linkando a interface Controlador com a classe ControleRemoto
public class ControleRemoto implements Controlador{

    // Atributos da classe ControleRemoto
    private int volume;
    private boolean ligado;
    private boolean tocando;

    // Método construtor da classe ControleRemoto
    public ControleRemoto() {
        this.volume = 50;
        this.ligado = false;
        this.tocando = false;
        
    }

    // Implementando os métodos da interface Controlador
    
    @Override
    public void ligar() {
        this.ligado = true;
    }

    @Override
    public void desligar() {
        if (this.tocando) {
            this.tocando = false;
        }
        this.ligado = false;
    }

    @Override 
    public void abrirMenu() {
        System.out.println("Esta ligado? " + (this.ligado ? "Sim" : "Nao"));
        System.out.println("Esta tocando? " + (this.tocando ? "Sim" : "Nao"));
        System.out.print("Volume: ");
        for (int i = 0; i <= this.volume; i += 10 ) {
            System.out.print("|");
        }

    }

    @Override
    public void fecharMenu() {
        System.out.println("Fechando menu...");
    }
    
    @Override
    public void maisVolume() {
        if (this.ligado && this.volume < 100) {
            this.volume += 5;
        } else {
            System.out.println("Impossivel aumentar o volume");
        }
    }

    @Override 
    public void menosVolume() {
        if (this.ligado && this.volume > 0) {
            this.volume -= 5;
        } else {
            System.out.println("Impossivel diminuir o volume");
        }
    }

    @Override
    public void ligarMudo() {
        if (this.ligado && this.volume > 0) {
            this.volume = 0;
        }
    }

    @Override
    public void desligarMudo() {
        if (this.ligado && this.volume == 0) {
            this.volume = 50;
        }
    }

    @Override 
    public void play() {
        if (this.ligado && !this.tocando) {
            this.tocando = true;
        } else {
            System.out.println("Impossivel reproduzir");
        }
    }

    @Override 
    public void pause() {
        if (this.ligado && this.tocando) {
            this.tocando = false;
        } else {
            System.out.println("Impossivel pausar");
        }
    }
}
