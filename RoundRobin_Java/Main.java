import java.util.*; // Importa estruturas de dados 

public class Main {
    public static void main(String[] args) {
        // Cria uma fila de processos (FIFO) 
        Queue<Processo> fila = new LinkedList<>();

        // Adiciona processos na fila com seus respectivos tempos 
        fila.add(new Processo("P1", 10)); // Processo com 10 unidades 
        fila.add(new Processo("P2", 5));  // Processo com 5 unidades 
        fila.add(new Processo("P3", 8));  // Processo com 8 unidades 

        int quantum = 3;    // Tempo maximo por execucao 
        int tempoAtual = 0; // Tempo total decorrido 

        System.out.println("Execucao Round Robin: \n"); 

        // Enquanto houver processos na fila
        while (!fila.isEmpty()) {
            Processo p = fila.poll(); // Remove o primeiro da fila
            System.out.println("Executando " + p.nome); 

            // Se ainda precisa de mais tempo que o quantum 
            if (p.tempoRestante > quantum) {
                tempoAtual += quantum;          // Soma o tempo executado 
                p.tempoRestante -= quantum;     // Diminui o tempo restante 
                
                System.out.println(p.nome + " executou por " + quantum + " unidades"); 
                System.out.println("Tempo restante: " + p.tempoRestante + "\n"); 
                
                fila.add(p); // Volta para o final da fila 
            } else {
                // Se termina dentro do quantum 
                tempoAtual += p.tempoRestante; 
                p.tempoRestante = 0;
                
                System.out.println(p.nome + " finalizado!"); 
                System.out.println("Tempo total até agora: " + tempoAtual + "\n"); 
            }
        }
    }
}