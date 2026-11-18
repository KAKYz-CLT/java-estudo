package contabanco;

public class Main {
    public static void main(String[] args) {
        ContaBanco c = new ContaBanco(1,"CORRENTE", "Miguel");

        c.fecharConta();
        c.abrirConta();
        c.depositar(100);
        c.depositar(500);
        c.verConta();
    }
}
