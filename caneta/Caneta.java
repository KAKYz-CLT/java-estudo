public class Caneta {
    String modelo;
    String cor;
    float ponta;
    int carga;
    private boolean tampada = true;

    void rabistar() {
        if (this.tampada == true && this.carga > 0) {
            System.out.print("A caneta esta tampada, destampe");
            System.out.print(" para poder rabiscar.");
        } else {
            System.out.println("Rabiscando...");
        }
    }

    void destampar() {
        if (this.tampada == false) {
            System.out.println("A caneta ja esta destampada");

        } else {
            this.tampada = false;
        }
    }

    void tampar() {
        if (this.tampada == true) {
            System.out.println("A caneta ja esta tampada");
        } else {
            this.tampada = true;
        }
    }

    void status() {
        System.out.println("Modelo: " +this.modelo);
        System.out.println("Cor: " + this.cor);
        System.out.println("Ponta: " + this.ponta);
        System.out.println("Carga: " + this.carga);
        // (tampada ? "Sim" : "Nao") e um operador
        // ternario, que funciona como um if/else, mas de forma resumida
        System.out.println("Tampada: " + (this.tampada ? "Sim" : "Nao"));
    }
}