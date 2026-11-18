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
            estadoIlegal("A sua conta ja esta aberta");
        } else {
            this.ativo = true;
        }
    }

    public void fecharConta() {
        if (!ativo) {
            estadoIlegal("A sua conta ja esta fechada");

        } else if (saldo != 0){
            estadoIlegal("Nao e possivel fechar a conta, saldo disponivel");

        } else {
            this.ativo = false;
        }
    }

    public void depositar(double deposito) {

        if (!ativo) {
            estadoIlegal("Deposito invalido, conta fechada");

        } else if (deposito > 0) {
            this.saldo += deposito;

        } else {
            argumentoIlegal("O deposito no valor de R$"+ deposito +" e invalido");
        }
    }

    public void sacar(double saque) {
        if (!ativo) {
            estadoIlegal("Saque invalido, conta fechada");

        } else if (saque == 0 || saque < 0 ) {
            argumentoIlegal("O saque deve ser > 0");

        } else if (saque <= this.saldo) {
            this.saldo -= saque;

        } else {
            argumentoIlegal("O saque no valor de R$"+ saque +" nao pode ser efetuado por falta de saldo");

        }
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
            argumentoIlegal("Tipo deve ser 'Corrente' ou 'Poupanca' ");
        }
        tipo = tipo.trim().toLowerCase();


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
        if (numero <= 0) {
            argumentoIlegal("Valor deve ser positivo!!");
        }
    }

    private void validarString(String string) {
        if (
            string == null ||
            string.isBlank()
        ) {
            argumentoIlegal("Campo Vazio ou null!!");
        }
    }

    private void argumentoIlegal(String mensagem) {
        throw new IllegalArgumentException("[ERROR] " + mensagem);
    }

    private void estadoIlegal(String mensagem) {
        throw new IllegalStateException("[ERROR] " + mensagem);
    }

}
