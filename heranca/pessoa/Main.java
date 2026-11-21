package heranca.pessoa;

public class Main {
    public static void main(String[] args) {
        Pessoa p = new Pessoa("Carlos", 19, "homem");
        Aluno p1 = new Aluno("Maria", 15, "mulher", 243, "Java POO");
        Funcionario p2 = new Funcionario("Rogerio", 35, "homem", "RH");
        Professor p3 = new Professor("Raimundo", 49, "Homem", "Matematica", 2500f);
        

        Pessoa[] pessoas = new Pessoa[4];

        pessoas[0] = p;
        pessoas[1] = p1;
        pessoas [2] = p2;
        pessoas [3] = p3;

        for (Pessoa pessoa : pessoas) {
            pessoa.apresentar();
        }
    }
}
