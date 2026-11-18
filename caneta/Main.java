public class Main {
    public static void main(String[] args) {
        Caneta c = new Caneta();
        Caneta c1 = new Caneta();

        c.setModelo("BIC");
        c.setCor("Preto");
        c.setPonta(0.5f);
        c.setCarga(80);
        // c.status();

        c.rabistar();
        
        c1.setModelo("Faber Castell");
        c1.setCor("Azul");
        c1.setPonta(0.7f);
        c1.setCarga(100);

        c1.destampar();
        c1.rabistar();

    }
}
