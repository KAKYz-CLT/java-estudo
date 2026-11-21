package heranca.pessoa;

public class Professor extends Pessoa {
    
    // Atributos
    private String especialidade;
    private float salario;

    // Construtor
    public Professor(String nome, int idade, String sexo, String especialidade, float salario) {
        super(nome, idade, sexo);
        setEspecialidade(especialidade);
        setSalario(salario);
    }

    // Metodos publicos
    @Override
    public void apresentar() {
        System.out.printf("\nOla me chamo %s tenho %d anos, sou %s professor(a) especialista em %s e recebo R$%.2f",
            getNome(), getIdade(), getSexo(), especialidade, salario
        );
    }

    public void receberAumento(int aumento) {
        if (aumento < 1 ) {
            lancarArgumentoInvalido("Parametro aumento deve ser positivo");
        }

        this.salario += aumento;
    }
    
    // Getters
    public String getEspecialidade() {
        return especialidade;
    }

    public float getSalario() {
        return salario;
    }
    
    // Setters
    private void setEspecialidade(String especialidade) {
        if (especialidade == null || especialidade.isBlank()) {
            lancarArgumentoInvalido("Parametro especialidade vazio ou null");
        }
        
        this.especialidade = especialidade;
    }

    private void setSalario(float salario ) {
        if (salario < 1) {
            lancarArgumentoInvalido("Parametro salario deve ser positivo");
        }

        this.salario = salario;
    }

}
