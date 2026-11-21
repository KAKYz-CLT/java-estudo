package encapsulamento.lutador;

public class Lutador {
    
    // Atributos
    private String nome;
    private String nacionalidade;
    private int idade;
    private float altura;
    private float peso;
    private String categoria;
    private int vitorias;
    private int derrotas;
    private int empates;

    // construtor
    public Lutador(
        String nome,String nacionalidade,
        int idade, float altura,
        float peso, int vitorias,
        int derrotas, int empates
    ) {
        setNome(nome);
        setNacionalidade(nacionalidade);
        setIdade(idade);
        setAltura(altura);
        setPeso(peso);
        setVitorias(vitorias);
        setDerrotas(derrotas);
        setEmpates(empates);
    }

    // Metodos publicos
    public void apresentar() {
        System.out.println("Lutador: " + this.getNome());
        System.out.println("Nacionalidade: " + this.getNacionalidade());
        System.out.println("Idade: " + this.getIdade() + " anos");
        System.out.println("Altura: " + this.getAltura() + " m");
        System.out.println("Peso: " + this.getPeso() + " kg");
        System.out.println("Categoria: " + this.getCategoria());
        System.out.println("Vitórias: " + this.getVitorias());
        System.out.println("Derrotas: " + this.getDerrotas());
        System.out.println("Empates: " + this.getEmpates());
        System.out.print("\n");
    }

    public void status() {
        System.out.println(this.getNome() + " é um lutador da categoria " + this.getCategoria());
        System.out.println("Vitórias: " + this.getVitorias());
        System.out.println("Derrotas: " + this.getDerrotas());
        System.out.println("Empates: " + this.getEmpates());
    }
    
    public void ganharLuta() {
        this.setVitorias(this.getVitorias() + 1);
    }

    public void perderLuta() {
        this.setDerrotas(this.getDerrotas() + 1);
    }

    public void empatarLuta() {
        this.setEmpates(this.getEmpates() + 1);
    }
    
    // Getters
    public String getNome() { return this.nome; }
    public String getNacionalidade() { return this.nacionalidade; }
    public int getIdade() { return this.idade; }
    public float getAltura() { return this.altura; }
    public float getPeso() { return this.peso; }
    public String getCategoria() { return this.categoria; }
    public int getVitorias() { return this.vitorias; }
    public int getDerrotas() { return this.derrotas; }
    public int getEmpates() { return this.empates; }
    
    // Setters 
    private void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            argumentoInvalido("Nome não pode ser nulo ou vazio.");
        }
        
        this.nome = nome;
    }

    private void setNacionalidade(String nacionalidade) {
        if (nacionalidade == null || nacionalidade.isBlank()) {
            argumentoInvalido("Nacionalidade não pode ser nula ou vazia.");
        }
        
        this.nacionalidade = nacionalidade;
    }

    private void setIdade(int idade) {
        if (idade <= 17) {
            argumentoInvalido("Idade deve ser maior que 17 anos.");
        }

        this.idade = idade;
    }

    private void setAltura(float altura) {
        if (altura <= 0) {
            argumentoInvalido("Altura deve ser maior que 0.");
        }

        this.altura = altura;
    }

    private void setCategoria(float peso) {
        if (peso < 52.2 ) {
            argumentoInvalido("Peso abaixo do limite permitido para qualquer categoria.");
        }else if (peso > 52.2  && peso <= 70.3) {
            this.categoria = "Leve";
        } else if (peso > 70.3 && peso <= 83.9) {
            this.categoria = "Médio";
        } else if (peso > 83.9 && peso <= 120.2) {
            this.categoria = "Pesado";
        } else {
            argumentoInvalido("Peso acima do limite permitido para qualquer categoria.");
        }
    }

    private void setPeso(float peso) {
        setCategoria(peso);
        this.peso = peso;
    }

    private void setVitorias(int vitorias) {
        if (vitorias < 0) {
            argumentoInvalido("Número de vitórias não pode ser negativo.");
        }

        this.vitorias = vitorias;
    }

    private void setDerrotas(int derrotas) {
        if (derrotas < 0) {
            argumentoInvalido("Número de derrotas não pode ser negativo.");
        }

        this.derrotas = derrotas;
    }

    private void setEmpates(int empates) {
        if (empates < 0) {
            argumentoInvalido("Número de empates não pode ser negativo.");
        }

        this.empates = empates;
    }


    // Metodos privados
    private void argumentoInvalido(String mensagem) {
        throw new IllegalArgumentException("[ERROR] " + mensagem);
    }
}
