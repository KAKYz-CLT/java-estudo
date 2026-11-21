package encapsulamento.pessoa;

public class Main {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("Carlos", 10, "homem");
        
        Livro livro = new Livro(
        "Java POO", "Osiel Pereira Pinto ",
        101, pessoa
        );

        pessoa.apresentar();
        livro.detalhes();
    }
}
