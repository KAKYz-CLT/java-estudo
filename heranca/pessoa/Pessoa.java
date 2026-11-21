package heranca.pessoa;

public class Pessoa {
    
    // Atriubutos
    private String nome;
    private int idade;
    private String sexo;
    
    // Construtor
    public Pessoa(String nome, int idade, String sexo) {
        setNome(nome);
        setIdade(idade);
        setSexo(sexo);
    }

    // Metodos publicos
    public void fazerAniversario() {
        this.idade ++;
    }

    public void apresentar() {
        System.out.printf("\nOla me chamo %s tenho %d anos, sou %s", nome, idade, sexo);
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
    private void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            lancarArgumentoInvalido("Parametro nome vazio ou null");
        }
    
        this.nome = nome;
    }
    
    private  void setIdade(int idade) {
        if (idade <= 0) {
            lancarArgumentoInvalido("Parametro idade deve ser positivo");
        }
    
        this.idade = idade;
    }
    
    private void setSexo(String sexo) {
    
        if (sexo == null || sexo.isBlank()) {
            lancarArgumentoInvalido("Parametro sexo vazio ou null");
    
        } else if (
            !sexo.trim().equalsIgnoreCase("homem") &&
            !sexo.trim().equalsIgnoreCase("mulher")
         ) {
            lancarArgumentoInvalido("Parametro sexo deve ser homem ou mulher");
    
        }
    
        this.sexo = sexo;
    }

    // Metodos privados
    protected void lancarArgumentoInvalido(String mensagem) {
        throw new IllegalArgumentException("[ERROR] " + mensagem);
    }
}
