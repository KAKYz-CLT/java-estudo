public class Caneta {

    private String modelo;
    private String cor;
    private float ponta;
    private int carga;
    private boolean tampada;

    public Caneta() {
        this(
        "BIC",
        "Azul",
        0.5f,
        100
        );
    }

    public Caneta(String modelo) {
        this(
            modelo,
            "Azul",
            0.5f,
            100
        );
    }

    public Caneta(String modelo, String cor) {
        this(
            modelo,
            cor,
            0.5f,
            100
        );
    }

    public Caneta(String modelo, String cor, float ponta) {
        this(
            modelo,
            cor,
            ponta,
            100
        );
    }


    public Caneta(
        String modelo,
        String cor,
        float ponta,
        int carga
      
    ) {
        this.modelo = modelo;
        this.cor = cor;
        this.ponta = ponta;
        this.carga = carga;
        this.tampada = true;
    }

    public void rabistar() {
        if (tampada) {
            System.out.print("A caneta esta tampada, destampe");
            System.out.print(" para poder rabiscar.");
        } else if (!tampada && carga > 0) {
            System.out.println("Rabiscando...");
        }
    }

    protected void destampar() {
        if (!tampada) {
            System.out.println("A caneta ja esta destampada");

        } else {
            tampada = false;
        }
    }

    protected void tampar() {
        if (tampada) {
            System.out.println("A caneta ja esta tampada");
        } else {
            tampada = true;
        }
    }

    public void status() {

        System.out.println("Modelo: " + modelo);
        System.out.println("Cor: " + cor);
        System.out.println("Ponta: " + ponta);
        System.out.println("Carga: " + carga);
        // (tampada ? "Sim" : "Nao") e um operador
        // ternario, que funciona como um if/else, mas de forma resumida
        System.out.println("Tampada: " + (tampada ? "Sim" : "Nao"));
    }

    public String getModelo() {return this.modelo;}
    public String getCor() {return this.cor;}
    public float getPonta() {return this.ponta;}
    public int getCarga() {return this.carga;}
    public boolean getTampada() {return this.tampada;}

    public void setModelo(String modelo) {this.modelo = modelo;}
    public void setCor(String cor) {this.cor = cor;}
    public void setPonta(float ponta) {this.ponta = ponta;}
    public void setCarga(int carga) {this.carga = carga;}

}