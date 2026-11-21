package encapsulamento.lutador;

import java.util.Random;

public class Luta {

    // Atributos
    private Lutador desafiado;
    private Lutador desafiante;
    private final int rounds = 3;
    private boolean aprovado;
    private final Random random = new Random();

    // Metodos publicos
    public void marcarLuta(Lutador l1, Lutador l2) {
        lancarEstado();
        if (
            l1 == null ||
            l2 == null
        ) {
            lancarEstadoInvalido("Lutas nao podem ser marcadas com lutadores nulos");

        } else if (l1 == l2){ 
            lancarEstadoInvalido("Lutas nao podem ser marcadas entre o mesmo lutador");

        } else if (!l1.getCategoria().equals(l2.getCategoria())) {
            lancarEstadoInvalido("Lutas nao podem ser marcadas entre lutadores de categorias diferentes");

        } else {
            this.aprovado = true;
            this.desafiado = l1;
            this.desafiante = l2;
        }
    }

    public void lutar() {
        try {

            if (!this.aprovado) {
                lancarEstadoInvalido("A luta nao foi aprovada");
            }

            System.out.println("\n### "+ this.rounds + " ROUNDS TOTAIS ###\n");

            System.out.println("### DESAFIADO ###");
            this.desafiado.apresentar();

            System.out.println("### DESAFIANTE ###");
            this.desafiante.apresentar();

            System.out.println("### RESULTADO DA LUTA ###\n");

            int vencedor = this.random.nextInt(3);

            switch (vencedor) {
                case 0 -> {
                    System.out.println("EMPATE!!\n");
                    this.desafiado.empatarLuta();
                    this.desafiante.empatarLuta();
                }

                case 1 -> {
                    System.out.println("Vitoria do Lutador " + this.desafiado.getNome() + "\n");
                    this.desafiado.ganharLuta();
                    this.desafiante.perderLuta();
                }

                case 2 -> {
                    System.out.println("Vitoria do lutador " + this.desafiante.getNome() + "\n");
                    this.desafiante.ganharLuta();
                    this.desafiado.perderLuta();
                }
            }

        }  finally {
            lancarEstado();
        }  
    }

    // Metodos privados
    private void lancarEstado() {
        this.aprovado = false;
        this.desafiado = null;
        this.desafiante = null;
    }

    private void lancarEstadoInvalido(String mensagem) {
        throw new IllegalStateException("[ERROR]" + mensagem);
    }
}