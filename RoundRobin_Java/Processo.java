// Classe que representa um processo 
class Processo {
    String nome;           // Nome do processo 
    int tempoRestante;     // Tempo restante de execucao

    // Construtor da classe Processo 
    public Processo(String nome, int tempo) {
        this.nome = nome;             // Define o nome do processo 
        this.tempoRestante = tempo;   // Define o tempo inicial 
    }
}