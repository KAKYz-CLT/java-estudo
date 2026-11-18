package contabanco;

public class ContaBanco {
    
    // ATRIBUTOS
    private int numConta;
    private String tipo;
    private String dono;
    private double saldo;
    private boolean ativo;

    // CONSTRUTOR
    public ContaBanco(int numConta, String tipo, String dono) {
        setNumConta(numConta);
        setTipo(tipo);
        setDono(dono);
        this.saldo = 0;
        this.ativo = true;
    }
    
    // REGRAS DE NEGOCIO
    public void abrirConta() {
        if (ativo) {
            System.out.println("A sua conta ja esta aberta");
        } else {
            this.ativo = true;
            System.out.println("A sua conta foi aberta com sucesso");
        }
    }

    public void fecharConta() {
        if (!ativo) {
            System.out.println("A sua conta ja esta fechada");
        } else {
            this.ativo = false;
            System.out.println("A sua conta foi fechada com sucesso");
        }
    }

    public void depositar(double deposito) {

        if (!ativo) {
            erro("O deposito nao pode ser efetuado visto que sua conta esta fechada");

        } else if (deposito > 0) {
            this.saldo += deposito;
            System.out.printf("Deposito no valor de R$%.2f feito com sucesso\n", deposito);

        } else {
            erro("O deposito no valor de R$"+ deposito +" e invalido");
        }
    }

    public void sacar(double saque) {
        if (!ativo) {
            erro("O saque nao pode ser efetuado visto que sua conta esta fechada");

        } else if (saque > 0 && saque <= this.saldo) {
            this.saldo -= saque;
            System.out.printf("Saque no valor de R$%.2f feito com sucesso\n", saque);

        } else {
            erro("O saque no valor de R$"+ saque +" nao pode ser efetuado por falta de saldo");
        }
    }

    public void pagarMensalidade() {
        if (!ativo) {
            erro("Nao e possivel pagar a mensalidade visto que a conta esta fechada");

        } else if (saldo > 12 && tipo.trim().equalsIgnoreCase("corrente")) {
            this.saldo -= 12;
            System.out.println("Mensalidade paga com sucesso por " + dono);

        } else if (saldo > 20 && tipo.trim().equalsIgnoreCase("poupanca")) {
            this.saldo -= 20;
            System.out.println("Mensalidade paga com sucesso por " + dono);

        }
    }

    public void verConta() {
        System.out.println("Numero: " + numConta);
        System.out.println("Tipo: " + tipo);
        System.out.println("Dono: " + dono);
        System.out.printf("Saldo: R$%.2f\n", saldo);
        System.out.println("Ativa: " + (ativo ? "Sim" : "Nao"));
    }

    // SETTERS
    private void setDono(String dono) {
        validarString(dono);

        this.dono = dono;
    }

    private void setNumConta(int numConta) {
        validarPositivo(numConta);

        this.numConta = numConta;
    }

    private void setTipo(String tipo) {
        validarString(tipo);
        if (
            !tipo.trim().equalsIgnoreCase("corrente") &&
            !tipo.trim().equalsIgnoreCase("poupanca")
        ) {
            erro("Tipo deve ser 'Corrente' ou 'Poupanca' ");
        }

        this.tipo = tipo;
    }

    // GETTERS
    public int getNumConta() {return numConta;}
    public String getTipo() {return tipo;}
    public String getDono() {return dono;}
    public double getSaldo() {return saldo;}
    public boolean isAtivo() {return ativo;}

    // VALIDACAO E TRATAMENTO DE ERRO

    private void validarPositivo(int numero) {
        if (numero < 0) {
            erro("Valor deve ser positivo!!");
        }
    }

    private void validarString(String string) {
        if (
            string == null ||
            string.trim().isBlank()
        ) {
            erro("Campo Vazio ou null!!");
        }
    }

    private void erro(String mensagem) {
        throw new IllegalArgumentException("[ERROR] " + mensagem);
    }

}
