package pessoa;

public class Livro implements Publicacao {
    
    // Atributos
    private String titulo;
    private String autor;
    private int totalPaginas;
    private int paginaAtual;
    private boolean aberto;
    private Pessoa leitor;

    
    // Construtor
    public Livro(
        String titulo, String autor,
        int totalPaginas,Pessoa leitor
    ) {
        setTitulo(titulo);
        setAutor(autor);
        setTotalPaginas(totalPaginas);
        setLeitor(leitor);
        this.paginaAtual = 0;
        this.aberto = false;
        
    }

    // Metodos sobrescritos da interface Publicacao
    @Override
    public void fechar() {
        if (!this.aberto) {
            System.out.println("O livro ja esta fechado");
        } else {
            this.aberto = false;
        }
        
    }

    @Override
    public void abrir() {
        if (this.aberto) {
            System.out.println("O livro ja esta aberto");
        } else {
            this.aberto = true;
        }
       
    }

    @Override
    public void folhear(int pagina) {
        if (!aberto) {
            lancarEstadoInvalido("Livro fechado");

        } else if (pagina > this.totalPaginas || pagina < 0) {
            lancarArgumentoInvalido("Impossivel folhear ate esta pagina");

        } else {
            this.paginaAtual = pagina;
        }
    }
    @Override
    public void avancarPagina() {
        if (!aberto) {
            lancarEstadoInvalido("Livro fechado");

        } else if (this.paginaAtual >= this.totalPaginas) {
            lancarEstadoInvalido("Nao ha paginas para avancar");

        } else {
            this.paginaAtual += 1;
        }
        
    }

    @Override
    public void voltarPagina() {
        if (!aberto) {
            lancarEstadoInvalido("Livro fechado");

        } else if (this.paginaAtual == 0) {
            lancarEstadoInvalido("Nao ha paginas para voltar");

        } else {
            this.paginaAtual -= 1;
        }

        
    }

    // Metodos publicos
    public void detalhes() {
        System.out.println("========================");
        System.out.println("Titulo: " + this.titulo);
        System.out.println("Autor: " + this.autor);
        System.out.println("Paginas lidas: " + this.paginaAtual + "/" + totalPaginas);
        System.out.println("Aberto: " + (this.aberto ? "Sim" : "Nao"));
        System.out.println("Leitor: " + this.leitor.getNome());
        System.out.println("========================");
    }

    // Setters
    private void setTitulo(String titulo) { 
        if (titulo == null || titulo.isBlank()) {
            lancarArgumentoInvalido("Parametro titulo vazio ou null");
        }
        this.titulo = titulo;
    }

    private void setAutor(String autor) {
        if (autor == null || autor.isBlank()) {
            lancarArgumentoInvalido("Parametro autor vazio ou invalido");
        }
        this.autor = autor;
    }

    private void setTotalPaginas(int totalPaginas) {
        if (totalPaginas <= 0) {
            lancarArgumentoInvalido("Parametro total de paginas deve ser maior que 0");
        }
        this.totalPaginas = totalPaginas;
    }

    private void setLeitor(Pessoa leitor) {
        if (leitor == null) {
            lancarArgumentoInvalido("Parametro leitor e null");
        }
        this.leitor = leitor;
    }

    // Metodos privados
    private void lancarEstadoInvalido(String mensagem) {
        throw new IllegalStateException("[ERROR] " + mensagem);
    }

    private void lancarArgumentoInvalido(String mensagem) {
        throw new IllegalArgumentException("[ERROE] " + mensagem);
    }
}
