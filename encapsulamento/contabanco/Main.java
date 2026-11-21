package encapsulamento.contabanco;

public class Main {
    public static  void verConta(ContaBanco contaBanco) {
            System.out.println("Numero: " + contaBanco.getNumConta());
            System.out.println("Tipo: " + contaBanco.getTipo());
            System.out.println("Dono: " + contaBanco.getDono());
            System.out.printf("Saldo: R$%.2f%n", contaBanco.getSaldo());
            System.out.println("Ativa: " + (contaBanco.isAtivo() ? "Sim" : "Nao"));
        }

    public static void main(String[] args) {
        ContaBanco c = new ContaBanco(1,"CORRENTE", "Miguel");

        c.fecharConta();
        c.abrirConta();
        c.depositar(100);
        c.depositar(500);
        verConta(c);
        
    }
}
