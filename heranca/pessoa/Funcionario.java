package heranca.pessoa;

public class Funcionario extends Pessoa {
    
    // Atributos
    private String setor;
    private boolean trabalhando;

    // Construtor
    public Funcionario(String nome, int idade, String sexo, String setor) {
        super(nome, idade, sexo);
        setSetor(setor);
        this.trabalhando = true;
    }

    // Metodos publicos
    @Override
    public void apresentar() {
        System.out.printf("\nOla me chamo %s tenho %d anos, sou %s e tabalho no setor %s ",
                getNome() ,getIdade(), getSexo(), setor + 
                (trabalhando ? " e estou tabalhando" : " e nao estou trabalhando") 
        );
    }

    public void mudarTrabalho() {
        this.trabalhando = !this.trabalhando;
    }

    // Getters
    public String getSetor() {
        return setor;
    }

    public boolean isTrabalhando() {
        return trabalhando;
    }

    // Setters
    private void setSetor(String setor) {
        if (setor == null || setor.isBlank())  {
            lancarArgumentoInvalido("Parametro setor e vazio ou null");
        }

        this.setor = setor;
    }
}
