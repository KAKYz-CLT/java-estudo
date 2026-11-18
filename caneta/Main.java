public class Main {
    public static void main(String[] args) {
        Caneta c = new Caneta();
        Caneta c1 = new Caneta();

        c.modelo = "BIC";
        c.cor = "Preto";
        c.ponta = 0.5f;
        c.carga = 80;
        // c.status();

        c.rabistar();
        
        c1.modelo = "Faber Castell";
        c1.cor = "Azul";   
        c1.ponta = 0.7f;
        c1.carga = 100;

        c1.destampar();
        c1.rabistar();

    }
}
