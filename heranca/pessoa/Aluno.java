package heranca.pessoa;

public class Aluno extends Pessoa {

    // Atributos
    private int matricula;
    private boolean ativo;
    private String curso;

    // Construtor
    public Aluno(String nome, int idade, String sexo, int matricula, String curso) {
        super(nome, idade, sexo);
        this.ativo = true;
        setMatricula(matricula);
        setCurso(curso);
    }

    // Metodos publicos
    @Override
    public void apresentar() {
        System.out.printf("\nOla me chamo %s tenho %d anos, sou %s %s",
            getNome(), getIdade(), getSexo(), (ativo ? " matriculado(a) no curso " + curso + " matricula Nº" + matricula : " e cancelei minha matricula no curso " + curso)
        );
    }

    public void cancelarMatricula() {
        this.ativo = false;
    }

    // Getters
    public int getMatricula() {
        return matricula;
    }

    public String getCurso() {
        return curso;
    }

    // Setters
    private void setMatricula(int matricula) {
        if (matricula <= 0 ) {
            lancarArgumentoInvalido("Parametro matricula deve ser positivo");
        }
    
        this.matricula = matricula;
    }
    
    private void setCurso(String curso) {
        if (curso == null || curso.isBlank()) {
            lancarArgumentoInvalido("Parametro curso vazio ou null");
        }
    
        this.curso = curso;
    }

}
