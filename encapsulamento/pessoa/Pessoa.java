package encapsulamento.pessoa;

public class Pessoa {
    
    // Atributos
    private String nome;
    private int idade;
    private String sexo;

    // Construtor
    public Pessoa (String nome, int idade, String sexo) {
        setNome(nome);;
        setIdade(idade);
        setSexo(sexo);

    }

    // Metodos publicos
    public void fazerAniversario() {
        this.idade++;
    }

    public void apresentar() {
        System.out.printf("Olá me chamo %s, tenho %d anos",this.nome ,this.idade);
    }
    
    // Getters
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getSexo() {
        return sexo;
    }
    
    // Setters
    private void setNome (String nome) {
        if (nome == null || nome.isBlank()) {
            lancarArgumentoInvalido("Parametro nome vazio ou null");
        }

        this.nome = nome;
    }

    private void setIdade (int idade) {
        if (idade <= 0) {
            lancarArgumentoInvalido("Parametro idade deve ser positivo");
        }
    }

    private void setSexo (String sexo) {
        sexo = sexo.trim().toLowerCase();

        if (sexo == null || sexo.isBlank()) {
            lancarArgumentoInvalido("Parametro sexo vazio ou null");

        } else if (
            !sexo.equals("homem") &&
            !sexo.equals("mulher")
        ) {
            lancarArgumentoInvalido("Parametro sexo deve ser homen ou mulher");

        } else {
            this.sexo = sexo;
        }
    }

    // Metodos privados
    private void lancarArgumentoInvalido(String mensagem ) {
        throw new IllegalArgumentException("[ERROR] " + mensagem);
    }

}
